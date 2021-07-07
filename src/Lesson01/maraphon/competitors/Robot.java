package Lesson01.maraphon.competitors;

public class Robot implements Competitor
{
    String name;

    int maxRunDistance;
    int maxJumpHeight;

    boolean active;

    public Robot( String name, int maxRunDistance, int maxJumpHeight ) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.active = true;
    }

    public Robot(String name) {
        this(name,10000,10);

    }

    @Override
    public void run(int dist)
    {
        if (dist <= maxRunDistance)
        {
            System.out.println("Робот " + name + " успешно пробежал");
        }
        else
        {
            System.out.println("Робот " + name + " провалил тест на бег");
            active = false;
        }
    }

    @Override
    public void jump(int height)
    {
        if (height <= maxJumpHeight) {
            System.out.println("Робот " + name + " успешно перепрыгнул");
        } else {
            System.out.println("Робот " + name + " провалил тест на прыжок");
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
        System.out.println( "Робот " + name + " "+ active);
    }
}
