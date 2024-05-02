package task3.space;

import task3.Words;

public class SpaceHole implements Transfer{

    private Location to;
    private Location from;

    public SpaceHole(Location to, Location from) {
        if(to.equals(from)){
            throw new IllegalArgumentException();
        }
        this.to = to;
        this.from = from;
    }

    @Override
    public void transferWords(Words words) {
        if(!words.getLocation().equals(from)){
            throw new IllegalArgumentException();
        }
        else {
            words.changeLocation(to);
        }
    }
}
