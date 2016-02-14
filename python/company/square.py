__author__ = 'hs634'

# For each character in the plaintext,
# - Convert the character to a number, based on its position in the English alphabet (e.g. a -> 1, e -> 5)
# - Convert the number to a roman numeral
# - Concatenate all the roman numerals together
# Return the concatenated string

# "cat" --> 3, 1, 20 --> III, I, XX --> "IIIIXX"

# Assume: no whitespace, no punctuation, and all lowercase letters

roman_numerals = [
        "I",
        "II",
        "III",
        "IV",
        "V",
        "VI",
        "VII",
        "VIII",
        "IX",
        "X",
        "XI",
        "XII",
        "XIII",
        "XIV",
        "XV",
        "XVI",
        "XVII",
        "XVIII",
        "XIX",
        "XX",
        "XXI",
        "XXII",
        "XXIII",
        "XXIV",
        "XXV",
        "XXVI",
        ]

def encrypt(string):
    cipher_text = ''
    for ch in string:
        num = ord(ch) - 97
        cipher_text += roman_numerals[num]
    return cipher_text

print encrypt("cat")

# For a given ciphertext s
# Define a "valid plaintext" or "valid decryption" as:
# Any plaintext t such that encrypt(t) == s

# Returns any single valid plaintext
def decrypt(string):
    plain = ''
    for ch in string:
        if ch in roman_numerals:
            plain += chr(roman_numerals.index(ch) + 97)

    return plain

print decrypt("IIIIXX")

# Returns all valid plaintexts
def allDecryptions(string):
    allD = set()

    if len(string) == 0:
        return set()

    if string in roman_numerals:
        allD.add(chr(roman_numerals.index(string) + 97))

    for i in range(1, len(string)):
        left = allDecryptions(string[:i])
        right = allDecryptions(string[i:])
        for prefix in left:
            for suffix in right:
                allD.add(prefix + suffix)

    return allD

for string in allDecryptions("IIIIXX"):
    print string
print "Finished"
# Want ['aaa', 'ab', 'ba', 'c']

