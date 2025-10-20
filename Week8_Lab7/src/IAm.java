import java.util.Scanner;

public class IAm {

    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        String mySentence;
        String qualityTerms;
        String newQuality;

        qualityTerms = "The qualities are ";

        do{

            mySentence = getSentence();

            if (!mySentence.equals(".")) {

                newQuality = getQualities(mySentence);

                if (!newQuality.equals("")) {

                    qualityTerms += newQuality + ", ";

                }

            }

        } while(!mySentence.equals("."));

        System.out.println(qualityTerms.substring(0,qualityTerms.length() - 2));


    } // end of the main method

    public static String getSentence() {

        System.out.println("Please enter sentences, . to end.");
        String inputSentence = keyboard.nextLine();

        return inputSentence;

    } // end of the getSentence method

    public static String getQualities(String inputSentence) {

        String startOfSentence;
        String qualityTerms;

        startOfSentence = inputSentence.substring(0, 5);

        if (startOfSentence.equals("I am ")) {

            qualityTerms = inputSentence.substring(5);

        }
        else {

            qualityTerms = "";

        }

        return qualityTerms;

    } // end of the getQualities method

} // end of the IAm class
