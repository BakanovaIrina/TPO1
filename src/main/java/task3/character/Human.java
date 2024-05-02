package task3.character;

import lombok.Getter;
import task3.Words;
import task3.space.Location;
import task3.war.CanWar;

import java.util.List;

public class Human implements CanWar {
    private String name;
    private int health;

    public static final int MAX_HEALTH = 100;
    public static final int MIN_HEALTH = 0;
    private List<Lifestyle> problems;
    @Getter
    private Location location;

    private boolean warlike = false;

    public Human(String name, int health, List<Lifestyle> problems, Location location) {
        if(health > MAX_HEALTH || health < MIN_HEALTH){
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.health = health;
        this.problems = problems;
        this.location = location;
    }

    public Human(String name, int health, List<Lifestyle> problems, Location location, boolean warlike) {
        this.name = name;
        this.health = health;
        this.problems = problems;
        this.location = location;
        this.warlike = warlike;
    }

    public int getHealth() {
        int curr_health = health;
        if(problems == null){
            return curr_health;
        }
        for (Lifestyle problem: problems) {
            if(problem.isGood()){
                curr_health += problem.getLifestylePoints();
            }
            else {
                curr_health -= problem.getLifestylePoints();
            }
        }

        if(curr_health > MAX_HEALTH){
            return MAX_HEALTH;
        }

        if(curr_health < MIN_HEALTH){
            return MIN_HEALTH;
        }

        return curr_health;
    }

    public Words wordsAboutHealth() {
        int cur_health = getHealth();
        if(cur_health < 50){
            return new Words("А у меня, кажется, большие проблемы с образом жизни", this.location);
        }
        else
            return new Words("А у меня, кажется, нет больших проблем с образом жизни", this.location);
    }


    @Override
    public boolean getWarlike() {
        return warlike;
    }

}
