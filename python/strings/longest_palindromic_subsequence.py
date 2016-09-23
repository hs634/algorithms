__author__ = 'hs634'

def longest_palindromic_subsequence(arr):

    n = len(arr)
    return lps(arr, 0, n-1)

def lps(arr, low, high):
    if low > high:
        return 0
    if low == high:
        return 1
    if arr[low] == arr[high] and low+1 == high:
        return 2
    if arr[low] == arr[high]:
        return 2 + lps(arr, low+1, high-1)

    return max((lps(arr,low+1, high)),(lps(arr,low, high-1)))


#print longest_palindromic_subsequence([1, 2, 4, 5, 1])
#print longest_palindromic_subsequence([1, 5, 2, 3, 2, 5])
#print longest_palindromic_subsequence([1,2,3,1,1,1,1,1])


def dp_lps(arr):
    n = len(arr)
    L = [[0] * n for __ in range(n)]
    for i in range(n):
        L[i][i] = 1

    for l in range(2, n+1):
        for i in range(n-l+1):
            j = i + l - 1
            if l == 2 and arr[i] == arr[j]:
                L[i][j] = 2
            elif arr[i] == arr[j]:
                L[i][j] = 2 + L[i+1][j-1]
            else:
                L[i][j] = max(L[i][j-1], L[i+1][j])

    print L[0][n-1]
    index = L[0][n-1] - 1
    length = index
    result = [-1] * L[0][n-1]
    j = n - 1
    i = 0
    while i < n and j >= 0:
        if arr[i] == arr[j]:
            result[index] = arr[j]
            result[length-index] = arr[j]
            index -= 1
            i += 1
            j -= 1
        elif L[i][j] == L[i][j-1]:
            j -= 1
        elif L[i][j] == L[i+1][j]:
            i += 1
        elif L[i][j] == 1:
            result[index] = arr[j]
            break
    print result




print dp_lps([1,2,4,5,1])

print dp_lps([1,2,1,2,1])

print dp_lps(['a','g','b','d','b','a'])



'''
private void backtrack(int [][] dpTable, char[] charArray){
    char[] palindrome = new char[dpTable[0][dpTable.length - 1]];
    int index = palindrome.length - 1;
    int length = index;
    for(int j = dpTable.length-1, i = 0 ; i &lt; dpTable.length &amp;&amp; j &gt; 0 ;  ){
        if(dpTable[i][j] == 1){
            palindrome[index] = charArray[j];
            break;
        }
        else if(dpTable[i][j] == 2 + dpTable[i+1][j-1]){
            palindrome[index] = charArray[j];
            palindrome[length - index] = charArray[j];
            index--;
            i++; j--;
        }else{
            if(dpTable[i][j-1] == dpTable[i][j]){
                j--;
            }else{
                i++;
            }
        }
    }
    System.out.println(Arrays.toString(palindrome));
}
'''


