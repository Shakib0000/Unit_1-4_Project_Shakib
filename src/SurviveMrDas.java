public class SurviveMrDas {

    // Instance Variables
    
    private String name;
    private int dasLocation; // The distance in feet from the player.
    private int timer; // The amount of time left in minutes.
    private int tasksCompleted; // The number of tasks completed.
    private int useInstagramProgress; // Percentage progress of scrolling through Instagram.
    private int watchFortniteProgress; // Percentage progress of watching Fortnite videos.
    private int playAmongUsProgress; // Percentage progress of playing Among Us.
    private int cartwheelProgress; // Percentage progress of cartwheeling across the room.
    private boolean finishingTasks; // Current status of the player, false if not in the process of completing tasks, true otherwise.

    // Constructor

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

    // Getter Methods

    public String getName() {
        return name;
    }
    
    public int getTimer() {
        return timer;
    }

    public int getTasksCompleted() {
        return tasksCompleted;
    }

    public int getDasLocation() {
        return dasLocation;
    }

    public boolean getFinishingTasks() {
        return finishingTasks;
    }

    // Methods for Game Mechanics

    public int randomNumberGenerator(int min, int max) {
        return (int) (Math.random() * max) + min;
    }

    public int passTime() {
        int randomNum = randomNumberGenerator(1,5);
        if (randomNum == 5 && timer >= 2) {
            timer -= 2;
        }
        else {
            timer -= 1;
        }
        return randomNum;
    }

    public void moveDas() {
        int randomNum = randomNumberGenerator(1,5);
        if (finishingTasks) {
            randomNum *= -1;
        }
        if (randomNum < 0 && (Math.abs(randomNum) > dasLocation)) {
            dasLocation = 0;
        }
        else if (randomNum > 0 && (randomNum + dasLocation > 30)) {
            dasLocation = 30;
        }
        else {
            dasLocation += randomNum;
        }
    }

    public String fulfillTask(String task) {
        if (task.equals("1") && useInstagramProgress != 100) {
            finishingTasks = true;
            useInstagramProgress += 25;
            if (useInstagramProgress == 100) {
                tasksCompleted += 1;
            }
            return "\nYour progress on scrolling through Instagram is: " + useInstagramProgress + "%";
        }
        else if (task.equals("1") && useInstagramProgress == 100) {
            return "\nYou have already finished scrolling through Instagram.";
        }
        else if (task.equals("2") && watchFortniteProgress != 100) {
            finishingTasks = true;
            watchFortniteProgress += 25;
            if (watchFortniteProgress == 100) {
                tasksCompleted += 1;
            }
            return "\nYour progress on watching Fortnite videos is: " + watchFortniteProgress + "%";
        }
        else if (task.equals("2") && watchFortniteProgress == 100) {
            return "\nYou have already finished watching Fortnite videos.";
        }
        else if (task.equals("3") && playAmongUsProgress != 100) {
            finishingTasks = true;
            playAmongUsProgress += 25;
            if (playAmongUsProgress == 100) {
                tasksCompleted += 1;
            }
            return "\nYour progress on playing Among Us is: " + playAmongUsProgress + "%";
        }
        else if (task.equals("3") && playAmongUsProgress == 100) {
            return "\nYou have already finished playing Among Us.";
        }
        else if (task.equals("4") && cartwheelProgress != 100) {
            finishingTasks = true;
            cartwheelProgress += 25;
            if (cartwheelProgress == 100) {
                tasksCompleted += 1;
            }
            return "\nYour progress on cartwheeling across the room is: " + cartwheelProgress + "%";
        }
        else if (task.equals("4") && cartwheelProgress == 100) {
            return "\nYou have already finished cartwheeling across the room.";
        }
        else if (task.equals("4") && cartwheelProgress == 100) {
            return "\nYou have already finished cartwheeling across the room.";
        }
        else if (task.equals("5")) {
            finishingTasks = false;
            return "\nYou have begun doing extremely boring AP CSA work... keep in mind that you are fighting the urge to sleep.";
        }
        else if (task.equals("6")) {
            finishingTasks = true;
            return "\nMr. Das is " + dasLocation + " feet away from you.";
        }
        return "\nThere was an error.";
    }

}
