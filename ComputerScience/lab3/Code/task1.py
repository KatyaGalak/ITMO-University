import re

def count_num_emoticons(search_str):
    return len(re.findall(r':<\)', search_str))
