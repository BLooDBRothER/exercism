import java.util.ArrayList;
import java.util.Arrays;

class PrimeCalculator {
    boolean[] isPrime;
    int MAX_SIZE = 1000000;
    
    public PrimeCalculator() {
        isPrime = new boolean[MAX_SIZE];
        Arrays.fill(isPrime, true);
    }

    int nth(int nth) {
        if(nth == 0)
            throw new IllegalArgumentException();

        int nthPrime = 2, count = 0;
        for(int i=2; i <MAX_SIZE; i++){
            if(isPrime[i]){
                count++;
                nthPrime = i;
                if(count == nth) break;

                for(int j=i*i; j<MAX_SIZE; j+=i){
                    if(j % i == 0)
                        isPrime[j] = false;
                }
            }
        }
        return nthPrime;
    }

}
