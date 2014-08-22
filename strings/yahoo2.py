__author__ = 'harsh'


'''
    Given two words, determine if the first word, or any anagram of it, appears in consecutive characters of the second word.
    For instance, tea appears as an anagram in the last three letters of slate, but let does not appear as an anagram in actor
    even though all the letters of let appear in slate.
    Return the anagram of the first word that has appeared in the second word.
    Sample Input 1
    tea
    slate

    Sample Output1
    ate
    Sample Input 2
    let
    slate

    Sample Output2
    NONE

'''
def is_substr_anagram(soFar, rest, superstr):
    if len(rest) == 0:
        if soFar in superstr:
            print soFar + " is present in " + superstr
            return soFar
        else:
            return None
    else:
        for i, ch in enumerate(list(rest)):
            sub_soFar = is_substr_anagram(soFar + ch, rest[:i] + rest[i+1:], superstr)
            if sub_soFar:
                return sub_soFar

    return None


def main():
    soFar = is_substr_anagram("", "an", "arpana")
    print soFar

main()