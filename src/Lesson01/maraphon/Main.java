package Lesson01.maraphon;

import Lesson01.maraphon.competitors.Robot;
import Lesson01.maraphon.obstacle.Cross;
import Lesson01.maraphon.obstacle.Wall;
import Lesson01.maraphon.competitors.Cat;
import Lesson01.maraphon.competitors.Competitor;
import Lesson01.maraphon.competitors.Human;
import Lesson01.maraphon.obstacle.Obstacle;

public class Main
{
    public static void main(String[] args)
    {
        Competitor[] competitors ={
                new Human("Vasia"),
                new Cat("Barsik"),
                new Robot("Android"),
                new Cat("Murka")
        };
        Obstacle[] obstacles ={
                new Wall(1),
                new Wall(2),
                new Wall(5),
                new Cross(50),
                new Cross(500),
                new Cross(5000)
        };
        for ( Competitor c:competitors )
            for (Obstacle o:obstacles )
            {
                o.doIt(c);
                if(!c.onDistance())
                    break;
            }

        for (Competitor c:competitors)
        {
            c.info();
        }
    }
}
