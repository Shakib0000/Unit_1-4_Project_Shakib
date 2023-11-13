import java.util.Scanner;

public class SurviveMrDasRunner {

    public static String askQuestion(String question) {
        Scanner s = new Scanner(System.in);
        System.out.print(question);
        return s.nextLine();
    }

    public static void main(String[] args) {
        String name = askQuestion("""
        Welcome to Survive Mr. Das!
        Turn your lights on if you aren't fond of spooks, because what may seem simple and harmless may just bring about your doom.
        
        Here are the rules of the game:
        1. To win the game by surviving Mr. Das' AP CSA class, you must complete four specific tasks: scrolling through Instagram, watching Fortnite videos, playing Among Us, and cartwheeling across the room. Each turn spent working on tasks will increase the task's progress by 25%.
        2. When you are completing your four tasks, Mr. Das will move towards you by a random number of feet from 1-5. He is 20 feet away from you at the start of the game. If his distance from you reaches 0, you lose the game.
        3. During the duration of the game, a timer will count down from 30 minutes by 1 minute each turn, and if it reaches 0, you will fall asleep and lose the game. There is also a 20% chance you will fall out of your chair and 2 minutes will pass instead of 1.
        4. If you work on AP CSA work, Mr. Das will move away from you by a random number of feet from 1-5. Also, if he is 5 or less feet away from you when you decide to work on AP CSA work, there is a chance he sees you alt-tabbing and catches you anyway.
        5. If you look behind you, you will find out how many feet away Mr. Das is from you. When looking behind yourself, he still moves towards you so be wary with how often you look behind you. Hint: Just don't look behind you.
        
        I sincerely hope you enjoy your final 30 minutes of breathing.
        Enter your name:""");
        SurviveMrDas gameManager = new SurviveMrDas(name);

        while (gameManager.getTimer() > 0 && gameManager.getTasksCompleted() < 4 && gameManager.getDasLocation() > 0) {
            gameManager.moveDas();

            String action = askQuestion("\nYou are " + gameManager.getTimer() + " minutes away from falling asleep.\nWhat do you want to do? Enter one of the following 6 choices:\n\"1\" to scroll through Instagram\n\"2\" to watch Fortnite videos\n\"3\" to play Among Us\n\"4\" to cartwheel across the room\n\"5\" to work on boring, AP CSA work\n\"6\" to look behind you\n");
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
