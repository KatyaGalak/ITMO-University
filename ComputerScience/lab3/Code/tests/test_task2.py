import unittest
from task2 import *
import os

class Test2TestCase(unittest.TestCase):
    # (answer = 0)
    def test_zero(self):
        cur_dir = os.getcwd()
        file_path = os.path.join(cur_dir, "tests/files_with_text_for_tests/files_for_task2", "ZeroAnswer.txt")
        with open(file_path, "r", encoding="utf-8") as file:
            text = file.read()
        res = find_sort_last_names(text)
        self.assertEqual(res, [])

    # (small answer)
    def test_small_0(self):
        cur_dir = os.getcwd()
        file_path = os.path.join(cur_dir, "tests/files_with_text_for_tests/files_for_task2", "SmallAnswer_0.txt")
        with open(file_path, "r", encoding="utf-8") as file:
            text = file.read()
        res = find_sort_last_names(text)
        my_res = ['Борисов-Зинченко-Малышев', 'Зайцев', 'Иванов', 'Козлов-Алексеенко', 'Кузнецов', 'Петрова', 'Попова', 
                  'Романов', 'Сидоров', 'Смирнова', 'Соколова', 'Федоров']
        self.assertEqual(res, my_res)

    def test_small_1(self):
        cur_dir = os.getcwd()
        file_path = os.path.join(cur_dir, "tests/files_with_text_for_tests/files_for_task2", "SmallAnswer_1.txt")
        with open(file_path, "r", encoding="utf-8") as file:
            text = file.read()
        res = find_sort_last_names(text)
        my_res = ['Андреев', 'Борисов', 'Васильев', 'Зайцев', 'Иванов', 'Козлов', 'Коновалов', 'Кузнецов', 'Николаев', 
                  'Петров', 'Попова', 'Романов', 'Савельев', 'Сидоров', 'Смирнова', 'Соколов', 'Степанов', 'Федоров', 'Филиппов']
        self.assertEqual(res, my_res)

    def test_small_2(self):
        cur_dir = os.getcwd()
        file_path = os.path.join(cur_dir, "tests/files_with_text_for_tests/files_for_task2", "SmallAnswer_2.txt")
        with open(file_path, "r", encoding="utf-8") as file:
            text = file.read()
        res = find_sort_last_names(text)
        my_res = ['Игнатьева', 'Кузнецова-Борисова', 'Макарова', 'Попов', 'Семенов-Иванов', 'Сидорова-Ильина', 'Тихонова', 'Филиппов']
        self.assertEqual(res, my_res)

    # (big answer)
    def test_big_0(self):
        cur_dir = os.getcwd()
        file_path = os.path.join(cur_dir, "tests/files_with_text_for_tests/files_for_task2", "BigAnswer_0.txt")
        with open(file_path, "r", encoding="utf-8") as file:
            text = file.read()
        res = find_sort_last_names(text)
        my_res = ['Андреев', 'Борисов', 'Васильев', 'Васильева', 'Волкова', 'Голубев-Серов', 
                  'Григорьев', 'Дмитриев', 'Евдокимов', 'Ефимов-Степанюк-Бондарев', 'Жаров', 'Зайцев', 
                  'Захаров', 'Иванов', 'Иванова', 'Казаков', 'Киселев', 'Климов', 
                  'Ковалев', 'Ковалева', 'Козлов', 'Комаров', 'Коновалов', 'Копылов', 
                  'Королев', 'Костров', 'Кузнецов', 'Кузьмина', 'Леонов', 'Литвинов-Грибов-Кулаков', 
                  'Макаров', 'Малахов', 'Малышев', 'Марков', 'Мартынов', 'Медведев', 
                  'Медведева', 'Михайлов', 'Михайлова', 'Моисеев', 'Морозов-Семенов', 'Наумов', 
                  'Нестеров', 'Никитин', 'Никитина', 'Николаев', 'Новиков', 'Новикова', 
                  'Петров', 'Попова', 'Романов', 'Савельев', 'Сидоров', 'Смирнова', 
                  'Соколов-Завьялов', 'Степанов', 'Федоров', 'Филиппов']
        self.assertEqual(res, my_res)

