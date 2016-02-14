__author__ = 'hs634'

def print_anagrams(words):
    aux = [(i, sorted(word)) for i,word in enumerate(words)]
    sorted_aux = sorted(aux, key=lambda tup: tup[1])

    for item in sorted_aux:
        print words[item[0]]

print_anagrams(["cat", "dog", "tac", "god", "act"])
