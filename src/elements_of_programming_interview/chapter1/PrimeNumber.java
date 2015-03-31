package elements_of_programming_interview.chapter1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jalpanranderi on 11/19/14.
 */
public class PrimeNumber {
    public static void main(String[] args) {
        System.out.println(getPrime(3));
        System.out.println(getPrime(11));
        System.out.println(getPrime(10));
        System.out.println(getPrime(20));
    }


    public static List<Integer> getPrime(int n){
        ArrayList<Integer> primes = new ArrayList<Integer>();
        primes.add(2);

        for(int i = 3; i <= n; i = i+2){
            if(isPrime(i)){
                primes.add(i);
            }
        }
        return primes;
    }

    private static boolean isPrime(int n){
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
