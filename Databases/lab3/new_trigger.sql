--Выполняется update first_name, second_name в person, если second_name > first_name занулять дату рождения


drop trigger if exists trigger_for_person on person;
drop function if exists update_person_names();

create or replace function update_person_names()
returns trigger as $$
BEGIN
	if TG_TABLE_NAME != 'person' then
		RAISE EXCEPTION 'Триггер вызван для неправильной таблицы: %', TG_TABLE_NAME;
	end if;

	if NEW.second_name > NEW.first_name then
		NEW.date_of_birth := NULL;
	end if;
	return NEW;
END;
$$ LANGUAGE plpgsql;

create trigger trigger_for_person
before update on person
for each row 
execute function update_person_names();