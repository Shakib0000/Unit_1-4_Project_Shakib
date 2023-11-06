public class SurviveMrDas {

    // Instance Variables
    private String name;
    private int dasLocation = 20; // The distance in feet from the player.
    private int timer = 30; // The amount of time left in minutes.
    private int tasksCompleted = 0; // The number of tasks completed.
    private int useInstagramProgress = 0; // Percentage progress of scrolling through Instagram.
    private int watchFortniteProgress = 0; // Percentage progress of watching Fortnite videos.
    private int playAmongUsProgress = 0; // Percentage progress of playing Among Us.
    private int cartwheelProgress = 0; // Percentage progress of cartwheeling across the room.
    private boolean finishingTasks = false; // Current status of the player, false if not in the process of completing tasks, true otherwise.

    // Constructor

    public String getName() {
        return name;
    }

    public SurviveMrDas(String name) {
        this.name = name;
    }

    // Getter Methods

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

    public void passTime(int minutes) {
        timer -= minutes;
    }

    public void moveDas(int amount) {
        dasLocation += amount;
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
        return "\nThere was an error.";
    }




}
