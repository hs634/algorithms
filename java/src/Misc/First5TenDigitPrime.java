package Misc;

public class First5TenDigitPrime {

}

/*
public enum SieveOfEratosthenes {
002
    SIEVE;
003
     
004
    private int[] sieve;
005
 
006
    private SieveOfEratosthenes() {
007
        // initialize with first million primes - 15485865
008
        // initialize with first 10k primes - 104729
009
        sieve = initialize(104729);
010
    }

    private int[] initialize(int sieveSize) {
016
        long sqrt = Math.round(Math.ceil(Math.sqrt(sieveSize)));
017
        long actualSieveSize = (int) (sqrt * sqrt);
018
 
019
        // data is initialized to zero
020
        int[] sieve = new int[actualSieveSize];
021
 
022
        for (int x = 2; x < sqrt; x++) {
023
            if (sieve[x] == 0) {
024
                for (int y = 2 * x; y < actualSieveSize; y += x) {
025
                    sieve[y] = x;
026
                }
027
            }
028
        }
029
 
030
        return sieve;
031
    }
032
 
033*/
    /**
034
     * Is this a prime number?
035
     *
036
     * @FIXME handle n >= sieve.length!
037
     *
038
     * @param n
039
     * @return true if prime
040
     * @throws IllegalArgumentException
041
     *             if negative number
042
     *//*
043
    public boolean isPrime(int n) {
044
        if (n < 0) {
045
            throw new IllegalArgumentException("value must be non-zero");
046
        }
047
 
048
        boolean isPrime = sieve[n] == 0;
049
 
050
        return isPrime;
051
    }
052
 
053*/
    /**
054
     * Factorize a number
055
     *
056
     * @FIXME handle n >= sieve.length!
057
     *
058
     * @param n
059
     * @return map of prime divisors (key) and exponent(value)
060
     * @throws IllegalArgumentException
061
     *             if negative number
062
     *//*
063
    private Map<Integer, Integer> factorize(int n) {
064
        if (n < 0) {
065
            throw new IllegalArgumentException("value must be non-zero");
066
        }
067
 
068
        final Map<Integer, Integer> factors = new TreeMap<Integer, Integer>();
069
 
070
        for (int factor = sieve[n]; factor > 0; factor = sieve[n]) {
071
            if (factors.containsKey(factor)) {
072
                factors.put(factor, 1 + factors.get(factor));
073
            } else {
074
                factors.put(factor, 1);
075
            }
076
 
077
            n /= factor;
078
        }
079
 
080
        // must add final term
081
        if (factors.containsKey(n)) {
082
            factors.put(n, 1 + factors.get(n));
083
        } else {
084
            factors.put(n, 1);
085
        }
086
 
087
        return factors;
088
    }
089*/
    /**
091
     * Convert a factorization to a human-friendly string. The format is a
092
     * comma-delimited list where each element is either a prime number p (as
093
     * "p"), or the nth power of a prime number as "p^n".
094
     *
095
     * @param factors
096
     *            factorization
097
     * @return string representation of factorization.
098
     * @throws IllegalArgumentException
099
     *             if negative number
100
     *//*
101
    public String toString(Map factors) {
102
        StringBuilder sb = new StringBuilder(20);
103
 
104
        for (Map.Entry entry : factors.entrySet()) {
105
            sb.append(", ");
106
 
107
            if (entry.getValue() == 1) {
108
                sb.append(String.valueOf(entry.getKey()));
109
            } else {
110
                sb.append(String.valueOf(entry.getKey()));
111
                sb.append("^");
112
                sb.append(String.valueOf(entry.getValue()));
113
            }
114
        }
115
 
116
        return sb.substring(2);
117
    }
118
}*/