import re

def has_one_vowel(word):
    list_vowels = ["Аа", "Ее", "Ёё", "Ии", "Оо", "Уу", "Ыы", "Ээ", "Юю", "Яя"]
    cnt = 0
    for vowel in list_vowels:
        if bool(re.search(rf'[{vowel}]', word)) == False:
            continue
        cnt += 1
        word_without_one_vowel = re.sub(f'[{vowel}]', '', word)

        vowels_to_search = re.sub(f'[{vowel}]', '', 'АаЕеЁёИиОоУуЫыЭэЮюЯя')

        pattern = rf'[{vowels_to_search}]'

        if bool(re.search(pattern, word_without_one_vowel)) == True:
            return False
    if cnt > 0:
        return True
    return False

def my_key(a):
    return (len(a), a.lower())

def search_words_with_one_vowel(search_string):
    words = re.findall(r'\b\w+\b', search_string)

    one_vowel_words = [word for word in words if has_one_vowel(word)]

    return sorted(set(one_vowel_words), key=my_key)
