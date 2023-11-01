public class SurviveMrDas {

    // Instance Variables
    private String name;
    private int dasLocation = 20; // The distance in feet from the player.
    private int timer = 60; // The amount of time left in minutes.
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

    // Methods

    public void passTime(int minutes) {
        timer -= minutes;
    }

    public int getTimer() {
        return timer;
    }

    public void moveDas(int amount) {
        dasLocation += amount;
    }

    public String fulfillTask(int task) {
        if (task == 1 & useInstagramProgress != 100) {
            finishingTasks = true;
            useInstagramProgress += 25;
            return "Your progress on scrolling through Instagram is: " + useInstagramProgress + "%";
        }
        else if (task == 1 & useInstagramProgress == 100) {
            return "You have already finished scrolling through Instagram.";
        }
        else if (task == 2 & watchFortniteProgress != 100) {
            finishingTasks = true;
            watchFortniteProgress += 25;
            return "Your progress on watching Fortnite videos is: " + watchFortniteProgress + "%";
        }
        else if (task == 2 & useInstagramProgress == 100) {
            return "You have already finished watching Fortnite videos.";
        }
        else if (task == 3 & playAmongUsProgress != 100) {
            finishingTasks = true;
            playAmongUsProgress += 25;
            return "Your progress on watching Fortnite videos is: " + playAmongUsProgress + "%";
        }
        else if (task == 3 & playAmongUsProgress == 100) {
            return "You have already finished playing Among Us.";
        }
        else if (task == 4 & cartwheelProgress != 100) {
            finishingTasks = true;
            cartwheelProgress += 25;
            return "Your progress on cartwheeling across the room is: " + cartwheelProgress + "%";
        }
        else if (task == 4 & cartwheelProgress == 100) {
            return "You have already finished cartwheeling across the room.";
        }
        return "There was an error.";
    }




}
