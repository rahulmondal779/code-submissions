class Solution {
    public boolean checkDivisibility(int n) {
        int sumOfDigit = 0;
        int productOfDigit = 1;
        int original = n;
        while (n>0) {
            int digit = n%10;
            n = n/10;

            sumOfDigit+=digit;
            productOfDigit*=digit;
        }

        int sumOfDigitAndProduct = sumOfDigit+productOfDigit;

        return original%sumOfDigitAndProduct==0;
    }
}