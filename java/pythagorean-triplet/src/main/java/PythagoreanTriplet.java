import java.util.ArrayList;
import java.util.List;

class PythagoreanTriplet {
    int a, b, c;

    PythagoreanTriplet(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    static TripletListBuilder makeTripletsList() {
        return new TripletListBuilder();
    }

    static class TripletListBuilder {
        private int sum, factorLimit = 0;
        TripletListBuilder thatSumTo(int sum) {
            this.sum = sum;
            return this;
        }

        TripletListBuilder withFactorsLessThanOrEqualTo(int maxFactor) {
            this.factorLimit = maxFactor;
            return this;
        }

        List<PythagoreanTriplet> build() {
            List<PythagoreanTriplet> triplets = new ArrayList<>();
            List<PythagoreanTriplet> triplets2 = new ArrayList<>();
             /*
               a + b + c = n ---------> 1
               a^2 + b^2 = c^2 -------> 2

               c = n - a - b --------> 3
                subs 3 in 2
               a^2 + b^2 = (n - a - b)^2

               b = ( n ( 2 * a - n ) ) / ( 2 * ( a - n ) )
             */
            for(int a = 1; a < this.sum; a++){
                int b = (this.sum * (2 * a - this.sum)) / (2 * (a - this.sum));
                int c = this.sum - a - b;
                if(isPythagorean(a, b, c)){
                    if(isUnderFactorLimit(b, c, a)) {
                        triplets.add(new PythagoreanTriplet(a, b, c));
                    }
                }
            }
            for (int i = 0; i < triplets.size()/2; i++) {
                triplets2.add(triplets.get(i));
            }
            return triplets2;
        }

        private boolean isUnderFactorLimit(int b, int c, int a) {
            return (this.factorLimit == 0 && b > 0 && c > 0) || (a > 0 && b > 0 && c > 0 && a <= this.factorLimit && b <= this.factorLimit && c <= this.factorLimit);
        }

        private static boolean isPythagorean(int a, int b, int c) {
            return (a * a) + (b * b) == (c * c);
        }

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.a;
        hash = 53 * hash + this.b;
        hash = 53 * hash + this.c;
        return hash;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PythagoreanTriplet other = (PythagoreanTriplet) obj;
        if (this.a != other.a) {
            return false;
        }
        if (this.b != other.b) {
            return false;
        }
        return this.c == other.c;
    }

}