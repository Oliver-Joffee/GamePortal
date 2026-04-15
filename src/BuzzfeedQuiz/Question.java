/* Irene Feng 10/12/2022
A question class with Answers.
*/ 
import java.util.ArrayList;
import java.util.Scanner;

public class Question {
    // Fields
    String label;
    Answer[] possibleAnswers = new Answer[4];

    Question(String label) {
        this.label = label;
    }

    // ask a question, and return the category that corresponds to the answer
    Category ask(Scanner sc) {
        
        
        System.out.println(this.label);
        // prints out all the answer choices
        for (int i = 0; i < this.possibleAnswers.length; i++) {
            String choice = Integer.toString(i + 1);
            System.out.println("[" + choice + "]:" +
                    this.possibleAnswers[i].label);
        }
        
        int ans = 0;

        if (sc.hasNextInt()) {
            ans = sc.nextInt();
            if (ans <= 4 && ans >= 1) {
                return possibleAnswers[ans - 1].cat;
            }
        }
        System.out.println("Please follow the instuctions and choose an answer 1-4.");
        sc.next();
        return(ask(sc));
        // String ans = sc.next();
        // System.out.println((ans == "1" || ans == "2" || ans == "3" || ans == "4"));
        // if (ans == "1" || ans == "2" || ans == "3" || ans == "4") {
        //     System.out.println("that was a number");
        //     return possibleAnswers[Integer.parseInt(ans) - 1].cat;
        // }
        
        // return possibleAnswers[0].cat;
    }

    Category tie(Scanner sc, ArrayList<Answer> answers) {
        System.out.println(this.label);
        //System.out.println("the amount of ansers is "+ Integer.toString(answers.size()));
        //System.out.println("IM TYING AHHHHH");
        for (int i = 0; i < answers.size(); i++) {
            
            //System.out.println("ACTIAVATED");
            String choice = Integer.toString(i + 1);
            System.out.println("[" + choice + "]:" +
                answers.get(i).label);
        }

        int ans = 0;

        if (sc.hasNextInt()) {
            ans = sc.nextInt();
            if (ans <= answers.size() || ans >= 1) {
                return answers.get(ans - 1).cat;
            }
        }
        System.out.println("Please follow the instuctions and choose an answer 1-4.");
        sc.next();
        return(tie(sc, answers));
    }
}
