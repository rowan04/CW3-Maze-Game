import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Beam here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Beam extends Actor
{
    private int direction, speed;
    
    public Beam(int dir)
    {
        setImage("beam.jpeg");
        GreenfootImage beam = getImage();
        beam.scale(15, 15);
        
        direction = dir;
        speed = 15;
    }

    /**
     * Act - do whatever the Beam wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setRotation(direction);
        move(speed);
        if (isTouching(Wall1.class))
        {
            getWorld().removeObject(this);
        }
        else if (isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
}
