__author__ = 'hs634'

def  distributeCandy( score):
    candies = [1 for i in range(len(score))]
    for i in range(1, len(score)):
        if score[i] > score[i-1]:
            candies[i] = candies[i-1] + 1
    for i in range(len(score)-2, -1, -1):
        if score[i+1] < score[i] and candies[i+1] >= candies[i]:
            candies[i] = candies[i+1] + 1
    return sum(candies)