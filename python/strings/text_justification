__author__ = 'harsh'


class Solution:
    # @param words, a list of strings
    # @param L, an integer
    # @return a list of strings
    def fullJustify(self, words, L):
        begin, end = 0, 0

        result = []

        while begin < len(words):
            words_len = 0
            while end < len(words):
                if (words_len + len(words[end]) + (end - begin)) <= L:
                    words_len += len(words[end])
                    end += 1
                else:
                    break
            temp_str = ""
            if end == len(words) or end == begin + 1:
                temp_str = " ".join(words[begin:end])
                temp_str += " " * (L - len(temp_str))
            else:
                spaces_count = (L - words_len) // (end - begin - 1)
                additional_spaces = (L - words_len) % (end - begin - 1)

                for index in xrange(begin, end-1):
                    if index - begin < additional_spaces:
                        temp_str += words[index] + " " * (spaces_count + 1)
                    else:
                        temp_str += words[index] + " " * (spaces_count)
                temp_str += words[end-1]
            result.append(temp_str)
            begin = end
        return result

    @staticmethod
    def main():
        words = ["This", "is", "an", "example", "of", "text", "justification."]
        L = 16
        print "Original text is %s" % (" ".join(words))
        print "Justified text is"
        print Solution().fullJustify(words, L)


Solution().main()