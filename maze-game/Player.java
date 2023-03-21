import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the main player that the user will control.
 * 
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("right"))
        {
            setRotation(0);
            move(2);
        }
        
        if(Greenfoot.isKeyDown("down"))
        {
            setRotation(90);
            move(2);
        }
        
        if(Greenfoot.isKeyDown("left"))
        {
            setRotation(180);
            move(2);
        }
                
        if(Greenfoot.isKeyDown("up"))
        {
            setRotation(270);
            move(2);
        }
    }
    
    /**
     * defines how the player moves
     */
    public void move(final int distance) {
        super.move(distance);
    }
}
