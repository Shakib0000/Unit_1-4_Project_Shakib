import java.util.Scanner;

public class SurviveMrDasRunner {
    public static String askQuestion(String question) {
        Scanner s = new Scanner(System.in);
        System.out.print(question);
        return s.nextLine();
    }

    public static void main(String[] args) {
        String name = askQuestion("Welcome to Survive Mr. Das!\nTurn your lights on if you aren't fond of spooks, because what may seem simple and harmless may just bring about your doom.\nTo survive, you must complete four specific tasks before class ends.\nIf you fail to complete the tasks by the end of class or if you are caught by Mr. Das while doing your tasks, you will not be a happy person.\nJust keep that in mind.\n\nAnyways, enter your name: ");
        SurviveMrDas gameManager = new SurviveMrDas(name);


    }

}
