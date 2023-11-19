/**
 * The SurviveMrDas class represents the game "Survive Mr. Das".
 * SurviveMrDas has the following properties: name, dasLocation, timer, tasksCompleted,
 * useInstagramProgress, watchFortniteProgress, playAmongUsProgress, cartwheelProgress,
 * finishingTasks.
 */
public class SurviveMrDas {
    // Creating instance variables to serve as game properties
    private String name; // The name of the player.
    private int dasLocation; // The distance in feet from the player.
    private int timer; // The amount of time left in minutes.
    private int tasksCompleted; // The number of tasks completed.
    private int useInstagramProgress; // Percentage progress of scrolling through Instagram.
    private int watchFortniteProgress; // Percentage progress of watching Fortnite videos.
    private int playAmongUsProgress; // Percentage progress of playing Among Us.
    private int cartwheelProgress; // Percentage progress of cartwheeling across the room.
    private boolean finishingTasks; // Current status of the player, false if not in the process of completing tasks, true otherwise.

    /**
     * Constructor for the SurviveMrDas class. This creates a new game of Survive Mr. Das
     * as an instance given the below parameters.
     *
     * @param name represents the name of the player
     */
    public SurviveMrDas(String name) {
        this.name = name;
        this.dasLocation = 20;
        this.timer = 30;
        this.tasksCompleted = 0;
        this.useInstagramProgress = 0;
        this.watchFortniteProgress = 0;
        this.playAmongUsProgress = 0;
        this.cartwheelProgress = 0;
        this.finishingTasks = false;
    }

    // Getter Methods for the SurviveMrDas class

    /**
     * getName is a getter method for the SurviveMrDas class. This method will return a String
     * containing the name of the player.
     *
     * @return returns the String instance variable "name"
     */
    public String getName() {
        return name;
    }

    /**
     * getTimer is a getter method for the SurviveMrDas class. This method will return an integer
     * containing the time remaining before the player falls asleep.
     *
     * @return returns the integer instance variable "timer"
     */
    public int getTimer() {
        return timer;
    }

    /**
     * getTasksCompleted is a getter method for the SurviveMrDas class. This method will return an integer
     * containing the amount of tasks the player has completed.
     *
     * @return returns the integer instance variable "tasksCompleted"
     */
    public int getTasksCompleted() {
        return tasksCompleted;
    }

    /**
     * getDasLocation is a getter method for the SurviveMrDas class. This method will return an integer
     * containing the distance between Mr. Das and the player.
     *
     * @return returns the integer instance variable "dasLocation"
     */
    public int getDasLocation() {
        return dasLocation;
    }

    // Methods for Game Mechanics

    /**
     * The randomNumberGenerator method will generate a random number given a minimum integer and a
     * maximum integer.
     *
     * @param min integer representing the lowest number that can be generated
     * @param max integer representing the highest number that can be generated
     * @return an integer representing the randomly generated number
     */
    public int randomNumberGenerator(int min, int max) {
        return (int) (Math.random() * max) + min;
    }

    /**
     * The passTime method will count down the timer by either 1 or 2. There will be a 20% chance
     * that it counts down by 2, otherwise it will always count down by 1.
     *
     * @return an integer representing the random number generated so the Runner class can determine
     * whether to print the corresponding output for 2 minutes passed or 1 minute passed
     */
    public int passTime() {
        int randomNum = randomNumberGenerator(1,5);
        if (randomNum == 5 && timer >= 2) { // 5 represents the 20% chance of falling off the chair, resulting in timer decreasing by 2
            timer -= 2;
        }
        else {
            timer -= 1;
        }
        return randomNum;
    }

    /**
     * The moveDas method will move Mr. Das’ location either towards the player or away from the player
     * depending on whether the player is working on their personal tasks or not. If the player is working
     * on their personal tasks, Mr. Das moves closer to the player by a random number from 1-5, and this
     * number is subtracted from the dasLocation variable that represents distance away from the player.
     * If the player is not working on their personal tasks, the opposite occurs. The method also checks
     * that dasLocation does not go over 30 or below 0.
     */
    public void moveDas() {
        int randomNum = randomNumberGenerator(1,5);
        if (finishingTasks) {
            randomNum *= -1;    // Adding a negative later on, making Mr. Das' distance from the player decrease
        }
        if (randomNum < 0 && (Math.abs(randomNum) > dasLocation)) {
            dasLocation = 0;    // Mr. Das' distance went below 0 so set it back to the minimum value of 0.
        }
        else if (randomNum > 0 && (randomNum + dasLocation > 30)) {
            dasLocation = 30;   // Mr. Das' distance went above 30 so set it back to the maximum value of 30.
        }
        else {
            dasLocation += randomNum;
        }
    }

    /**
     * The fulfillTask method manages a main gameplay mechanic of the game which is completing personal tasks.
     * You can choose which personal task to fulfill or to work on AP CSA work or to look behind you in order
     * to check Mr. Das’ location and this method will handle it all using if statements.
     *
     * @param task String representing the input by the player
     * @return a String representing the outcome of the player's choice in a properly formatted sentence
     */
    public String fulfillTask(String task) {
        if (task.equals("1") && useInstagramProgress != 100) { // User wants to scroll through Instagram and the task is incomplete
            finishingTasks = true;
            useInstagramProgress += 25;
            if (useInstagramProgress == 100) {
                tasksCompleted += 1;
            }
            return "\nYour progress on scrolling through Instagram is: " + useInstagramProgress + "%";
        }
        else if (task.equals("1") && useInstagramProgress == 100) { // User wants to scroll through Instagram but the task is already completed
            return "\nYou have already finished scrolling through Instagram.";
        }
        else if (task.equals("2") && watchFortniteProgress != 100) { // User wants to watch Fortnite and the task is incomplete
            finishingTasks = true;
            watchFortniteProgress += 25;
            if (watchFortniteProgress == 100) {
                tasksCompleted += 1;
            }
            return "\nYour progress on watching Fortnite videos is: " + watchFortniteProgress + "%";
        }
        else if (task.equals("2") && watchFortniteProgress == 100) { // User wants to watch Fortnite but the task is already completed
            return "\nYou have already finished watching Fortnite videos.";
        }
        else if (task.equals("3") && playAmongUsProgress != 100) { // User wants to play Among Us and the task is incomplete
            finishingTasks = true;
            playAmongUsProgress += 25;
            if (playAmongUsProgress == 100) {
                tasksCompleted += 1;
            }
            return "\nYour progress on playing Among Us is: " + playAmongUsProgress + "%";
        }
        else if (task.equals("3") && playAmongUsProgress == 100) { // User wants to play Among Us but the task is already completed
            return "\nYou have already finished playing Among Us.";
        }
        else if (task.equals("4") && cartwheelProgress != 100) { // User wants to cartwheel across the room and the task is incomplete
            finishingTasks = true;
            cartwheelProgress += 25;
            if (cartwheelProgress == 100) {
                tasksCompleted += 1;
            }
            return "\nYour progress on cartwheeling across the room is: " + cartwheelProgress + "%";
        }
        else if (task.equals("4") && cartwheelProgress == 100) { // User wants to cartwheel across the room but the task is already completed
            return "\nYou have already finished cartwheeling across the room.";
        }
        else if (task.equals("5")) { // User wants to do AP CSA work, this makes Mr. Das start moving away from the player until the player begins doing their own tasks again
            finishingTasks = false;
            return "\nYou have begun doing extremely boring AP CSA work... keep in mind that you are fighting the urge to sleep.";
        }
        else if (task.equals("6")) { // User wants to look behind them to check Mr. Das' location
            finishingTasks = true;
            return "\nMr. Das is " + dasLocation + " feet away from you.";
        }
        return "\nThere was an error."; // Prevents code from breaking, helps debug
    }
}
