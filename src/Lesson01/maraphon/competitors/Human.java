package Lesson01.maraphon.competitors;

public class Human implements Competitor
{
    String name;

    int maxRunDistance;
    int maxJumpHeight;

    boolean active;

    public Human( String name, int maxRunDistance, int maxJumpHeight ) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.active = true;
    }

    public Human(String name) {
        this(name,2000,3);

    }

    @Override
    public void run(int dist)
    {
        if (dist <= maxRunDistance)
        {
            System.out.println("Человек " + name + " успешно пробежал");
        }
        else
        {
            System.out.println("Человек " + name + " провалил тест на бег");
            active = false;
        }
    }

    @Override
    public void jump(int height)
    {
        if (height <= maxJumpHeight) {
            System.out.println("Человек " + name + " успешно перепрыгнул");
        } else {
            System.out.println("Человек " + name + " провалил тест на прыжок");
            active = false;
        }
    }

    @Override
    public boolean onDistance()
    {
        return active;
    }

    @Override
    public void info()
    {
        System.out.println( "Человек " + name + " "+ active);
    }
}
