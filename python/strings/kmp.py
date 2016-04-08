__author__ = 'hs634'


def is_match(string, pat):
    return is_match_rec(string, 0, pat, 0, {})


def is_match_rec(string, i, pat, j, cmap):
    if i == len(string) and j == len(pat):
        return True
    if i == len(string) or j == len(pat):
        return False

    if pat[j] in cmap:
        t = cmap[pat[j]]
        if i + len(t) > len(string) or not string[i:i + len(t)] == t:
            return False
        return is_match_rec(string, i + len(t), pat, j + 1, cmap)

    for k in range(i, len(string)):
        cmap[pat[j]] = string[i:k + 1]
        if is_match_rec(string, k + 1, pat, j + 1, cmap):
            return True
        del cmap[pat[j]]
    return False


print is_match("redbluebluered", "abba")
print is_match("abba", "abba")
print is_match("aabb", "xyzabcxzyabc")

'''
template <int N=900>
struct Counter {
 int count[N];
 int lastPosition;
 int lastTime;
 int sum;
 Counter() {
  memset(count, 0, sizeof(count));
  lastPosition = 0;
  sum = 0;
  lastTime = time(NULL);
 }
 void move() {
  int t = time(NULL);
  int gap = min(t - lastTime, N);
  for (int k = 0; k < gap; ++k) {
   lastPosition = (lastPosition + 1) % N;
   sum -= count[lastPosition];
   count[lastPosition] = 0;
  }
  lastTime = t;
 }
 void hit() {
  move();
  count[lastPosition]++;
  sum++;
 }
 int getcount() {
  move();
  return sum;
 }
};
'''


def subset_sum(mi, n, curset, cursum, target):
    # calculate all possible subsets sum == target
    #assumes mainset is already sorted in ascending order
    global mainset

    if cursum > target:  #return constraint violated
        return

    if cursum == target:  #subset found print
        print map(lambda i: mainset[i],
                  filter(lambda x: curset[x] == 1, range(n)))

    if mi == n:  #return leaf reached
        return

    else:  #explore more subsets
        for i in range(mi, n):
            curset[i] = 1
            cursum += mainset[i]
            subset_sum(i + 1, n, curset, cursum, target)
            curset[i] = 0
            cursum -= mainset[i]

mainset=[-2,-1,2,3,4,5,6]
n=len(mainset)
print subset_sum(0,n,[0]*n, 0, 0)
