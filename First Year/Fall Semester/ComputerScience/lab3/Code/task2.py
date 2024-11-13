import re

def find_sort_last_names(search_text):
    pattern = r'([А-Я][а-я]+(?:-[А-Я][а-я]+)*)(?:\s[А-Я]\.[А-Я]\.)'
    last_names = sorted(set(re.findall(pattern, search_text)))

    return last_names
