package leet.nums;

import javax.security.auth.login.CredentialException;

public class Fib {
    public static int fib(int n) {
        int a = 0, b = 1, sum = 0;


        for (int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;

            a = b;

            b = sum;
        }
        return a;

    }

    public static void main(String[] args) {
        System.out.println(fib(2));
    }
}
