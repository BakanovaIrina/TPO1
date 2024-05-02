package task3.space;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

public class Location {

    public Location(Date time, String place) {
        this.time = time;
        this.place = place;
    }
    Date time;
    String place;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(time, location.time) && Objects.equals(place, location.place);
    }
}
