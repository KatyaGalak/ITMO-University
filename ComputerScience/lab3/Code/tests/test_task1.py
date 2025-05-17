import unittest
from task1 import *
import os

class Test1TestCase(unittest.TestCase):
    # (answer = 0)
    def test_zero(self):
        cur_dir = os.getcwd()
        file_path = os.path.join(cur_dir, "tests/files_with_text_for_tests/files_for_task1", "ZeroAnswer.txt")
        with open(file_path, "r") as file:
            text = file.read()
        res = count_num_emoticons(text)
        self.assertEqual(res, 0)

    # (small answer)
    def test_small_0(self):
        cur_dir = os.getcwd()
        file_path = os.path.join(cur_dir, "tests/files_with_text_for_tests/files_for_task1", "SmallAnswer_0.txt")
        with open(file_path, "r") as file:
            text = file.read()
        res = count_num_emoticons(text)
        self.assertEqual(res, 6)

    def test_small_1(self):
        cur_dir = os.getcwd()
        file_path = os.path.join(cur_dir, "tests/files_with_text_for_tests/files_for_task1", "SmallAnswer_1.txt")
        with open(file_path, "r") as file:
            text = file.read()
        res = count_num_emoticons(text)
        self.assertEqual(res, 9)

    # (big answer)
    def test_big_0(self):
        cur_dir = os.getcwd()
        file_path = os.path.join(cur_dir, "tests/files_with_text_for_tests/files_for_task1", "BigAnswer_0.txt")
        with open(file_path, "r") as file:
            text = file.read()
        res = count_num_emoticons(text)
        self.assertEqual(res, 90145)

    def test_big_1(self):
        cur_dir = os.getcwd()
        file_path = os.path.join(cur_dir, "tests/files_with_text_for_tests/files_for_task1", "BigAnswer_1.txt")
        with open(file_path, "r") as file:
            text = file.read()
        res = count_num_emoticons(text)
        self.assertEqual(res, 1412311)