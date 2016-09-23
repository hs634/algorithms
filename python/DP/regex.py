__author__ = 'hs634'

'''
public boolean isMatch(String s, String p) {
	// base case
	if (p.length() == 0) {
		return s.length() == 0;
	}

	// special case
	if (p.length() == 1) {

		// if the length of s is 0, return false
		if (s.length() < 1) {
			return false;
		}

		//if the first does not match, return false
		else if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
			return false;
		}

		// otherwise, compare the rest of the string of s and p.
		else {
			return isMatch(s.substring(1), p.substring(1));
		}
	}

	// case 1: when the second char of p is not '*'
	if (p.charAt(1) != '*') {
		if (s.length() < 1) {
			return false;
		}
		if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
			return false;
		} else {
			return isMatch(s.substring(1), p.substring(1));
		}
	}

	// case 2: when the second char of p is '*', complex case.
	else {
		//case 2.1: a char & '*' can stand for 0 element
		if (isMatch(s, p.substring(2))) {
			return true;
		}

		//case 2.2: a char & '*' can stand for 1 or more preceding element,
		//so try every sub string
		int i = 0;
		while (i<s.length() && (s.charAt(i)==p.charAt(0) || p.charAt(0)=='.')){
			if (isMatch(s.substring(i + 1), p.substring(2))) {
				return true;
			}
			i++;
		}
		return false;
	}
}
'''

'''
bool isMatch(const char *s, const char *p) {
  assert(s && p);
  if (*p == '\0') return *s == '\0';

  // next char is not '*': must match current character
  if (*(p+1) != '*') {
    assert(*p != '*');
    return ((*p == *s) || (*p == '.' && *s != '\0')) && isMatch(s+1, p+1);
  }
  // next char is '*'
  while ((*p == *s) || (*p == '.' && *s != '\0')) {
    if (isMatch(s, p+2)) return true;
    s++;
  }
  return isMatch(s, p+2);
}
'''


def match(first, second):
    if len(first) == 0:
        return len(second) == 0
    elif len(first) == 1:
        if len(second) < 1:
            return False
        if first[0] == '*':
            return True
        if first[0] == '?':
            return len(second) == 1
        return first[0] == second[0]
    else:
        if first[1] != '*':
            return ((first[0] == second[0]) or (first[0] == '?' and len(second) > 0)) and match(first[1:], second[1:])
        else:
            i = 0
            while i < len(second) and (first[0] == second[0] or first[0] == "?"):
                if match(first[2:], second[i+1:]):
                    return True
                i += 1
            return False

print match("fi*d?", "firecodee")


def match(first, second):
    if len(first) == 0:
        return len(second) == 0
    elif len(first) == 1:
        if len(second) < 1:
            return False
        if first[0] == '*':
            return True
        if first[0] == '?':
            return len(second) == 1
        return first[0] == second[0]
    else:
        if first[0] != '*':
            return (len(second) > 0 and (first[0] == second[0]) or (first[0] == '?' and len(second) > 0)) and match(
                first[1:], second[1:])
        else:
            i = 0
            while i < len(second):
                if match(first[1:], second[i + 1:]):
                    return True
                i += 1
            return False
