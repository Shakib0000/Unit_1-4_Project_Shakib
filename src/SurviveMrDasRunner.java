import java.util.Scanner;

public class SurviveMrDasRunner {

    public static String askQuestion(String question) {
        Scanner s = new Scanner(System.in);
        System.out.print(question);
        return s.nextLine();
    }

    public static void main(String[] args) {
        String name = askQuestion("Welcome to Survive Mr. Das!\nTurn your lights on if you aren't fond of spooks, because what may seem simple and harmless may just bring about your doom.\nTo survive, you must complete four specific tasks before you end up falling asleep or being caught doing those tasks by Mr. Das.\nIf you are caught asleep or if you are caught by Mr. Das while doing your tasks, you will not be a happy person.\nJust keep that in mind.\n\nAnyways, enter your name: ");
        SurviveMrDas gameManager = new SurviveMrDas(name);

        while (gameManager.getTimer() > 0 && gameManager.getTasksCompleted() < 4 && gameManager.getDasLocation() > 0) {
            gameManager.moveDas();

            String action = askQuestion("\nYou are " + gameManager.getTimer() + " minutes away from falling asleep.\nWhat do you want to do? Enter one of the following 4 choices:\n\"1\" to scroll through Instagram\n\"2\" to watch Fortnite videos\n\"3\" to play Among Us\n\"4\" to cartwheel across the room\n\"5\" to work on boring, AP CSA work\n\"6\" to look behind you\n");
            System.out.println(gameManager.fulfillTask(action));

            int passTimeResult = gameManager.passTime();
            if (passTimeResult == 5) {
                System.out.println("Whoops! You doze off for a second and almost fall out of your chair. Time is ticking, get yourself together!");
            }
        }

        if (gameManager.getTimer() > 0 && gameManager.getTasksCompleted() == 4 && gameManager.getDasLocation() > 0) {
            System.out.println("\nYou have managed to stay awake and you were not caught off-task during Mr. Das' class.");
            System.out.println("Mr. Das: Impressive, " + gameManager.getName() + ". You managed to survive my class. You get to live yet another day. Let's see if you can survive tomorrow as well...\n*You leave AP CSA class in one piece*\nYOU WIN!");
        }
        else if (gameManager.getDasLocation() <= 0) {
            System.out.println("\nMr. Das is looking right down at you. You look up, your face filled with terror.");
            askQuestion("Mr. Das: " + gameManager.getName() + ", HOW DARE YOU BE OFF-TASK IN MY CLASS!!!!!!!!!!!! YOU ABSOLUTE BUFFOON. DO YOU HAVE ANY LAST WORDS? ");
            System.out.println("Mr. Das: OK. I PROBABLY WON'T EVEN BOTHER PUTTING THEM ON YOUR GRAVESTONE. SEE YOU IN THE AFTERLIFE BUDDY! \n*You perish under Mr. Das' wrath*\nGAME OVER!");
        }
        else if (gameManager.getTimer() <= 0) {
            System.out.println("\nYou fall asleep from boredom. You are woken up by Mr. Das' violent footsteps behind you.");
            askQuestion("Mr. Das: " + gameManager.getName() + ", HOW DARE YOU FALL ASLEEP IN MY CLASS!!!!!!!!!!!! YOU ABSOLUTE BUFFOON. DO YOU HAVE ANY LAST WORDS? ");
            System.out.println("Mr. Das: OK. I PROBABLY WON'T EVEN BOTHER PUTTING THEM ON YOUR GRAVESTONE. SEE YOU IN THE AFTERLIFE BUDDY! \n*You perish under Mr. Das' wrath*\nGAME OVER!");
        }
        else {
            System.out.println("If you are seeing this message, somehow the game broke?!?!?!");
        }
    }

}
