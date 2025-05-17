import unittest
from task3 import *
import os

class Test3TestCase(unittest.TestCase):
    # (answer = 0)
    def test_zero(self):
        cur_dir = os.getcwd()
        file_path = os.path.join(cur_dir, "tests/files_with_text_for_tests/files_for_task3", "ZeroAnswer.txt")
        with open(file_path, "r", encoding="utf-8") as file:
            text = file.read()
        res = search_words_with_one_vowel(text)
        self.assertEqual(res, [])

    # (small answer)
    def test_small_0(self):
        cur_dir = os.getcwd()
        file_path = os.path.join(cur_dir, "tests/files_with_text_for_tests/files_for_task3", "SmallAnswer_0.txt")
        with open(file_path, "r", encoding="utf-8") as file:
            text = file.read()
        res = search_words_with_one_vowel(text)
        my_res = ['рог', 'град', 'стол', 'стул', 'фата', 'шкаф', 'город', 'молоток'] 
        self.assertEqual(res, my_res)

    def test_small_1(self):
        cur_dir = os.getcwd()
        file_path = os.path.join(cur_dir, "tests/files_with_text_for_tests/files_for_task3", "SmallAnswer_1.txt")
        with open(file_path, "r", encoding="utf-8") as file:
            text = file.read()
        res = search_words_with_one_vowel(text)
        my_res = ['кот', 'пот', 'Рот', 'Ток', 'борт', 'Горб', 'Куст', 'мозг', 'торт', 'Лампа', 'топот', 'Тромб']
        self.assertEqual(res, my_res)

    # (big answer)
    def test_big_0(self):
        cur_dir = os.getcwd()
        file_path = os.path.join(cur_dir, "tests/files_with_text_for_tests/files_for_task3", "BigAnswer_0.txt")
        with open(file_path, "r", encoding="utf-8") as file:
            text = file.read()
        res = search_words_with_one_vowel(text)
        my_res = ['ум', 'бок', 'Ком', 'лак', 'лом', 'пар', 'том', 'угл', 'бинт', 'день', 'клей', 
                  'корм', 'корт', 'корь', 'курс', 'лень', 'Литр', 'мост', 'Парк', 'ромб', 'сель', 'сеть', 
                  'тост', 'файл', 'фото', 'Ветер', 'вихрь', 'мороз', 'папка', 'спрей', 'Ткань', 'топор',
                  'Смерчь', 'квадрат', 'Лампада', 'Пингвин', 'карандаш', 'сложность']
        self.assertEqual(res, my_res)

    def test_big_1(self):
        cur_dir = os.getcwd()
        file_path = os.path.join(cur_dir, "tests/files_with_text_for_tests/files_for_task3", "BigAnswer_1.txt")
        with open(file_path, "r", encoding="utf-8") as file:
            text = file.read()
        res = search_words_with_one_vowel(text)
        my_res = ['вал', 'вид', 'Газ', 'код', 'кол', 'нос', 'рис', 'сад', 'сук', 'шок', 'ямб', 
                  'блок', 'боль', 'врач', 'даль', 'дань', 'дача', 'круг', 'лист', 'мышь', 
                  'риск', 'Ритм', 'Рост', 'Соль', 'сорт', 'хлеб', 'цвет', 'брешь', 'брошь', 
                  'весть', 'въезд', 'гость', 'Грамм', 'грипп', 'дробь', 'кварц', 'квест', 'Кисть', 
                  'кость', 'кросс', 'лесть', 'месть', 'нефть', 'носок', 'около', 'пасть', 'плеть', 'Принц', 
                  'ртуть', 'Сахар', 'скотч', 'Скрип', 'спрос', 'старт', 'ствол', 'Степь', 'стиль', 
                  'страж', 'страх', 'стриж', 'Строй', 'тембр', 'тесть', 'тросс', 'фрукт', 'хруст', 
                  'честь', 'шесть', 'взгляд', 'гвоздь', 'горсть', 'гроздь', 'грусть', 'доктор', 
                  'скорбь', 'спектр', 'стресс', 'тормоз', 'шерсть', 'Четверг', 'абракадабра']
        
        self.assertEqual(res, my_res)

