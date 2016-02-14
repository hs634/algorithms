__author__ = 'hs634'


def firstRepeatedWord( s):
    delimiters = [' ', '\t', ',', ':', ';', '-', '.']
    cur_word = ''
    words_seen = {}
    #loop through each character in the sentence
    for ch in s:
        if ch in delimiters:
            if cur_word in words_seen:
                return cur_word
            words_seen[cur_word] = True
            cur_word = ''
        else:
            cur_word += ch
    if cur_word and cur_word in words_seen:
        return cur_word
    return None


s = 'Had Haddock had a fit?'

print firstRepeatedWord(s)