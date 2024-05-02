package task3;

import lombok.Getter;
import task3.space.Location;

import java.util.Objects;

public class Words {

    public Words(String words, Location location) {
        this.words = words;
        this.location = location;
    }

    private String words;

    @Getter
    private Location location;

    public void changeLocation(Location to){
        if(!to.equals(location)){
            this.location = to;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Words words1 = (Words) o;
        return Objects.equals(words, words1.words) && Objects.equals(location, words1.location);
    }

}
