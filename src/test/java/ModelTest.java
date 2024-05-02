import org.junit.jupiter.api.Test;
import task3.Words;
import task3.character.Creature;
import task3.character.Human;
import task3.character.Lifestyle;
import task3.space.Location;
import task3.space.SpaceHole;
import task3.war.CanWar;
import task3.war.War;
import task3.war.WarStages;
import task3.war.WarStatus;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ModelTest {

    @Test
    void checkTransferIdenticalLocations(){
        Location location1 = new Location(new Date(), "космический корабль");
        Location location2 = new Location(new Date(), "космический корабль");
        assertThrows(IllegalArgumentException.class, () -> new SpaceHole(location1, location2));
    }

    @Test
    void checkTransferOneLocations(){
        Location location1 = new Location(new Date(), "космический корабль");
        assertThrows(IllegalArgumentException.class, () -> new SpaceHole(location1, location1));
    }

    @Test
    void checkTransferWrongLocationWords(){
        Location location1 = new Location(new Date(), "космический корабль");
        Location location2 = new Location(new Date(), "планета");
        Location location3 = new Location(new Date(), "галактика X");
        Words words = new Words("Я люблю кофе", location1);
        SpaceHole spaceHole = new SpaceHole(location2, location3);
        assertThrows(IllegalArgumentException.class, () -> spaceHole.transferWords(words));
    }

    @Test
    void checkWordsChangeLocation(){
        Location location1 = new Location(new Date(), "космический корабль");
        Location location2 = new Location(new Date(), "планета");
        Words words1 = new Words("Я люблю чай", location1);
        Words words2 = new Words("Я люблю кофе", location1);
        words1.changeLocation(location1);
        words2.changeLocation(location2);

        assertEquals(words1.getLocation(), location1);
        assertEquals(words2.getLocation(), location2);
    }


    @Test
    void checkTransferLocationWords(){
        Location location1 = new Location(new Date(), "космический корабль");
        Location location2 = new Location(new Date(), "планета");
        Words words = new Words("Я люблю кофе", location1);
        SpaceHole spaceHole = new SpaceHole(location2, location1);
        spaceHole.transferWords(words);

        assertEquals(words.getLocation(), location2);
    }

    @Test
    void checkHumanWordsLocation(){
        Location location1 = new Location(new Date(), "космический корабль");
        Human human = new Human("Alex", 60, null, location1);
        Words words = human.wordsAboutHealth();

        assertEquals(words.getLocation(), human.getLocation());
    }

    @Test
    void checkHumanConstructorHealth(){
        assertThrows(IllegalArgumentException.class, () -> new Human("Alex", -10, null, new Location(new Date(), "комната")));
        assertThrows(IllegalArgumentException.class, () -> new Human("Alex", 1000, null, new Location(new Date(), "комната")));
    }

    @Test
    void checkHumanHealth(){
        List<Lifestyle> problems = new ArrayList<>();
        problems.add(new Lifestyle("курение", 30, false));
        problems.add(new Lifestyle("малоподвижный образ жизни", 30, false));

        List<Lifestyle> goodLifestyle = new ArrayList<>();
        goodLifestyle.add(new Lifestyle("йога", 30, true));
        goodLifestyle.add(new Lifestyle("хорошая гигиена", 40, true));

        Human human1 = new Human("Alex", 50, problems, new Location(new Date(), "комната"));
        Human human2 = new Human("Ira", 50, goodLifestyle, new Location(new Date(), "комната"));
        Human human3 = new Human("Valentine", 10, goodLifestyle, new Location(new Date(), "комната"));

        assertEquals(Human.MIN_HEALTH, human1.getHealth());
        assertEquals(Human.MAX_HEALTH, human2.getHealth());
        assertEquals(80, human3.getHealth());

    }

    @Test
    void checkHumansWordsTruth(){
        List<Lifestyle> problems = new ArrayList<>();
        problems.add(new Lifestyle("курение", 30, false));
        problems.add(new Lifestyle("малоподвижный образ жизни", 30, false));

        List<Lifestyle> goodLifestyle = new ArrayList<>();
        goodLifestyle.add(new Lifestyle("йога", 30, true));
        goodLifestyle.add(new Lifestyle("хорошая гигиена", 40, true));

        Human human1 = new Human("Alex", 50, problems, new Location(new Date(), "комната"));
        Human human2 = new Human("Ira", 50, goodLifestyle, new Location(new Date(), "комната"));

        assertEquals(human1.wordsAboutHealth(), new Words("А у меня, кажется, большие проблемы с образом жизни",
                human1.getLocation()));
        assertEquals(human2.wordsAboutHealth(), new Words("А у меня, кажется, нет больших проблем с образом жизни",
                human1.getLocation()));

    }

    @Test
    void checkNotWarlikeWar(){
        Human human = new Human("Alex", 50, null, new Location(new Date(), "комната"));
        Creature creature = new Creature(true, new Location(new Date(), "комната"));
        Set<CanWar> canWarSet = new HashSet<>();
        canWarSet.add(human);
        canWarSet.add(creature);

        assertThrows(IllegalArgumentException.class, () -> new War(WarStages.beforeWar, WarStatus.interstellar, canWarSet));
    }

    @Test
    void checkWarlikeWar(){
        Human human = new Human("Alex", 50, null, new Location(new Date(), "комната"), true);
        Creature creature = new Creature(true, new Location(new Date(), "комната"));
        Creature creature1 = new Creature(true, new Location(new Date(), "комната"), true);

        Set<CanWar> canWarSet = new HashSet<>();
        canWarSet.add(human);
        canWarSet.add(creature);
        canWarSet.add(creature1);

        assertDoesNotThrow(() -> new War(WarStages.beforeWar, WarStatus.interstellar, canWarSet));
    }
}
