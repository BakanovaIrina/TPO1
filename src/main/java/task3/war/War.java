package task3.war;

import java.util.List;
import java.util.Set;

public class War {
    WarStages warStages;
    WarStatus warStatus;
    Set<CanWar> parties;

    public War(WarStages warStages, WarStatus warStatus, Set<CanWar> parties) {
        for (CanWar part: parties) {
            if(part.getWarlike() != true){
                throw new IllegalArgumentException();
            }
        }
        this.warStages = warStages;
        this.warStatus = warStatus;
        this.parties = parties;
    }
}
