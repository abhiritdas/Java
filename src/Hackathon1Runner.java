import java.util.Arrays;
import java.util.Scanner;

public class Hackathon1Runner {
    public static void main (String [] args)    {

        Scanner kb = new Scanner(System.in);
            String wordBank = ("Key of words: \"runny nose\", \"stuffy nose\", \"cough\", \"congestion\", \"mild headache\", \"sneezing\", \"fever\", \"nausea\", \"vomiting\", \"diarrhea\", \"abdominal pains\", \"cramps\", \"fever\", \"painful swallowing\", \"swollen tonsils\", \"headache\", \"rash\", \"body aches\"");
            System.out.println(wordBank + "\n");

            System.out.print("Input patient's symptoms here in a line: ");
            String symptoms = kb.nextLine();
            symptoms = symptoms.toLowerCase();

            Diagnosis word = new Diagnosis();
            System.out.println(word.determiner(symptoms));
     }
}

class Diagnosis {
    private static String[] commonColdSymptoms = {"runny nose", "stuffy nose", "cough", "congestion", "mild headache", "sneezing", "fever"};
    private static String[] foodPoisoningSymptoms = {"nausea", "vomiting", "diarrhea", "diarrhea", "abdominal pains", "cramps", "fever"};
    private static String[] strepThroatSymptoms = {"painful swallowing", "swollen tonsils", "headache", "rash", "body aches"};

    public Diagnosis(){
    }

    public String determiner(String symptoms) {
        if (Arrays.stream(commonColdSymptoms).anyMatch(symptoms::contains))
            return "You probably have a common cold...";
        else if (Arrays.stream(foodPoisoningSymptoms).anyMatch(symptoms::contains))
            return "You probably had a food poisoning...";
        else if (Arrays.stream(strepThroatSymptoms).anyMatch(symptoms::contains))
            return "You probably have strep throat...";
        else
            return "It seems as though you have no common health issue...";
    }

}