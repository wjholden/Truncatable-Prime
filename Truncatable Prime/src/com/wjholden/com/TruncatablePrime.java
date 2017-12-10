package com.wjholden.com;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author William John Holden (wjholden@gmail.com)
 */
public class TruncatablePrime {
    
    // command-line argument should be "left" or "right"
    public static void main(String[] args) {
        int digits[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        Queue<BigInteger> q = new LinkedList<>();
        q.offer(BigInteger.ZERO);
        
        while (!q.isEmpty()) {
            BigInteger x = q.poll();
            for (int d : digits) {
                BigInteger y;
                
                if (args.length == 0 || args[0].contains("right")) {
                    // right-truncatable primes
                    y = (x.multiply(BigInteger.valueOf(10))).add(BigInteger.valueOf(d));
                } else {
                    // left-truncatable primes
                    y = new BigInteger(Integer.toString(d) + 
                        (x.equals(BigInteger.ZERO) ? "" : x.toString()));
                }
                
                if (y.isProbablePrime(100)) {
                    System.out.println(y);
                    q.add(y);
                }
            }
        }
    }
}
