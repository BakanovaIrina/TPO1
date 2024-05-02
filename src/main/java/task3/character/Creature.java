package task3.character;

import task3.space.Location;
import task3.war.CanWar;

public class Creature implements CanWar {
    private boolean strange;
    private Location location;
    private boolean warlike = true;

    public Creature(boolean strange, Location location) {
        this.strange = strange;
        this.location = location;
    }

    public Creature(boolean strange, Location location, boolean warlike) {
        this.strange = strange;
        this.location = location;
        this.warlike = warlike;
    }

    @Override
    public boolean getWarlike() {
        return warlike;
    }

}
