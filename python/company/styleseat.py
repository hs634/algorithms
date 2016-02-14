__author__ = 'hs634'


# 'fasdfffffejwaejjfaajaoajeafaasf'
# What's the character that occurs consecutively most times and the amount of times it occurs?
# ['f', 5]

input = 'fasdfffffejwaejjfaajaoajeafaasf'
result = []




def highest(input):
    prev_char = None
    current_count = 0
    max_char = None
    max_count = 0

    for index, char in enumerate(input):

    # input.split().each_with_index do |char,index|
    #['f','a','a',....]
    # is f the same as previous character?
    # => no it's not
    # => highest is f, 1 time
    # next: 'a'
    # is a the same as previous character (f) ?
    # => no it's not
    # => highest is a, 1 time
    # next: 'a'
    # is a the same as previous character (a)?
    # => yes it is
    # => highest is still a, 2 times


        if char == prev_char:
          # increment current character count
            current_count += 1
            if current_count > max_count:
              max_count = current_count
              max_char = char

        else:
          # assign previous character
          prev_char = char
          current_count = 1

    return [max_char, max_count]


print highest(input)
#{'f' => 1}
#{'f' => 2, 'a' => 1}
#result = [f, 2]


#result = {'f' => 9, 'a' => 7,....}

#1. number
#2. empty string
#3. special character
#4. longest string >> how long?

#sorted_input = 'aaaaffffj..'
