package task3.character;

import lombok.Getter;

public class Lifestyle {
    private String name;
    @Getter
    private int lifestylePoints;
    @Getter
    private boolean isGood;

    public Lifestyle(String name, int lifestylePoints, boolean isGood) {
        this.name = name;
        this.lifestylePoints = lifestylePoints;
        this.isGood = isGood;
    }
}
