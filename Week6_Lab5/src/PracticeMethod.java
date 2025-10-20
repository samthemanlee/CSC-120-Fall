public class PracticeMethod {
    public static void main(String[] args) {

        System.out.println("WEEK 6 - LAB 5 PRACTICE");
        System.out.println(isPrime(5));

    } // end of the main method

    public static boolean isPrime (int givenNumber) {
//
//        int index;
//
//        for (index = 2; index < givenNumber; index++) {
//
//            if (givenNumber % index == 0) {
//                return false;
//            }
//
//        } // end of the for loop

        long divisor = 2;

        while (divisor <= Math.sqrt(givenNumber)) {
            if (givenNumber % divisor == 0) {
                System.out.println(givenNumber + " is divisible by " + divisor);
                return(false);
            }
            divisor++;
        }
        return(true);

    } // end of the isPrime method

    public static boolean isFibonacci (int givenNumber) {

        int previous = 0;
        int current = 1;

        int index;
        int next;

        for (index = 0; index < givenNumber; index++) {

            next = previous + current;

            if (next == givenNumber) {
                return true;
            }

            previous = current;
            current = next;

        } // end of the for loop

        return false;

    } // end of the isFibonacci method

} // end of the Practice class
