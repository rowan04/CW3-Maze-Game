import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.*;  //allows checking signs on integers
/**
 * This is the main player that the user will control.
 * 
 */
public class Player extends Actor
{
    public Player()   //constructor to resize player to be a better fit for the maze
    {
        GreenfootImage person = getImage();
        int newHeight = (int)person.getHeight()/2;
        int newWidth = (int)person.getWidth()/2;
        person.scale(newWidth, newHeight);
    }
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        int dx = 0, dy = 0;
        String dir = "none";
        if (Greenfoot.isKeyDown("up")) {
            dy = -2;
        }
        if (Greenfoot.isKeyDown("left")) {
            dx = -2;
        }
        if (Greenfoot.isKeyDown("down")) {
            dy = 2;
        }
        if (Greenfoot.isKeyDown("right")) {
            dx = 2;
        }
        setLocation(getX()+dx, getY()+dy);
        if (isTouching(Wall1.class))
        {
            setLocation(getX()-dx, getY()-dy);
        }
        if (isTouching(Wall2.class))
        {
            setLocation(getX()-dx, getY()-dy);
        }
        if (isTouching(Wall3.class))
        {
            setLocation(getX()-dx, getY()-dy);
        }
    }
    
    /**
     * defines how the player moves
     */
    public void move(final int distance) {
        super.move(distance);
    }
}
