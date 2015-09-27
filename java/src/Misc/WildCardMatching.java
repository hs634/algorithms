package Misc;

public class WildCardMatching {

	
	public static void main(String[] args){
		
		String input = "abeeeed";
		String pattern = "?b*d**";
		
		System.out.println("Matches : " + isMatching(input, pattern));
	}

	private static boolean isMatching(String input, String pattern) {
		char[] s = input.toCharArray();
		char[] p = pattern.toCharArray();
		int match = 0;
		int star = -1;
		int s_cur = 0;
		int p_cur = 0;
		int s_len = s.length;
		int p_len = p.length;
		
		while(s_cur < s_len){
			
			if(p_cur < p_len && (s[s_cur] == p[p_cur] || p[p_cur] == '?')){
				s_cur++;
				p_cur++;
			}
			else if(p_cur<p_len && p[p_cur] == '*'){
				match = s_cur;
				star = p_cur;
				p_cur++;
			}
			else if(star!=-1){
				p_cur = star+1;
				match = match+1;
				s_cur = match;
			}
			else
				return false;
			
		}
		
		//check if the rest of the pattern is a * and the input has reached the end of string
		while(p_cur < p_len && p[p_cur] =='*')
			p_cur++;
		
		if(p_cur != p_len)
			return false;
		return true;
	}
}
/*
 * class Solution:

    def isMatch(self, s, p):
        s_cur = 0;
        p_cur= 0;
        match = 0;
        star = -1;
        while s_cur<len(s):
            if p_cur< len(p) and (s[s_cur]==p[p_cur] or p[p_cur]=='?'):
                s_cur = s_cur + 1
                p_cur = p_cur + 1
            elif p_cur<len(p) and p[p_cur]=='*':
                match = s_cur
                star = p_cur
                p_cur = p_cur+1
            elif (star!=-1):
                p_cur = star+1
                match = match+1
                s_cur = match
            else:
                return False
        while p_cur<len(p) and p[p_cur]=='*':
            p_cur = p_cur+1
             
        if p_cur==len(p):
            return True
        else:
            return False
                 
 */



/**
Analysis:

For each element in s
If *s==*p or *p == ? which means this is a match, then goes to next element s++ p++.
If p=='*', this is also a match, but one or many chars may be available, so let us save this *'s position and the matched s position.
If not match, then we check if there is a * previously showed up,
       if there is no *,  return false;
       if there is an *,  we set current p to the next element of *, and set current s to the next saved s position.

e.g.

abed
?b*d**

a=?, go on, b=b, go on,
e=*, save * position star=3, save s position ss = 3, p++
e!=d,  check if there was a *, yes, ss++, s=ss; p=star+1
d=d, go on, meet the end.
check the rest element in p, if all are *, true, else false;
*/
/**
 * 
Implement wildcard pattern matching with support for '?' and '*'.
'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") ‰ Õ false
isMatch("aa","aa") ‰ Õ true
isMatch("aaa","aa") ‰ Õ false
isMatch("aa", "*") ‰ Õ true
isMatch("aa", "a*") ‰ Õ true
isMatch("ab", "?*") ‰ Õ true
isMatch("aab", "c*a*b") ‰ Õ false
 */
