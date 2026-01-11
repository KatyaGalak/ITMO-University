CREATE OR REPLACE FUNCTION update_person_danger_level()
RETURNS TRIGGER AS $$
DECLARE
    upd_person_id BIGINT;
    calc_danger_level INT;
BEGIN
    IF TG_TABLE_NAME = 'Collision' THEN
        upd_person_id := NEW.person_id;
    ELSIF TG_TABLE_NAME = 'Reaction_to_sound' THEN
        upd_person_id := NEW.person_id;
    ELSE
        RETURN NULL;
    END IF;

    SELECT 
        COALESCE((
            SELECT COUNT(DISTINCT danger_id) * 3 
            FROM Collision
            WHERE person_id = upd_person_id
        ), 0)
        +
        COALESCE((
            SELECT COUNT(DISTINCT rtc.sound_id) 
            FROM Reaction_to_sound rts
            JOIN Sound snd ON rts.sound_id = snd.sound_id
            WHERE rts.person_id = upd_person_id
            AND snd.type_sound IN ('звуки животных', 'звуки транспорта')
        ), 0)
    INTO calc_danger_level;

    UPDATE Person 
    SET danger_level = calc_danger_level
    WHERE person_id = upd_person_id;

    --RETURN NULL;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_collision_danger
AFTER INSERT OR UPDATE OR DELETE ON Collision
FOR EACH ROW
EXECUTE FUNCTION update_person_danger_level();

CREATE TRIGGER trg_reaction_danger
AFTER INSERT OR UPDATE OR DELETE ON Reaction_to_sound
FOR EACH ROW
EXECUTE FUNCTION update_person_danger_level();