package Lesson01.maraphon.competitors;

public class Cat implements Competitor
{
    String name;

    int maxRunDistance;
    int maxJumpHeight;

    boolean active;

    public Cat( String name, int maxRunDistance, int maxJumpHeight ) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.active = true;
    }

    public Cat(String name) {
        this(name,100,2);

    }

    @Override
    public void run(int dist)
    {
        if (dist <= maxRunDistance)
        {
            System.out.println("Кот " + name + " успешно пробежал");
        }
        else
        {
            System.out.println("Кот " + name + " провалил тест на бег");
            active = false;
        }
    }

    @Override
    public void jump(int height)
    {
        if (height <= maxJumpHeight) {
            System.out.println("Кот " + name + " успешно перепрыгнул");
        } else {
            System.out.println("Кот " + name + " провалил тест на прыжок");
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
        System.out.println( "Кот " + name + " "+ active);
    }
}
