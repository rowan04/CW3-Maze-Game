import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Teleport here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Teleport extends Actor
{
    public Teleport()   //constructor to resize Teleport icon to be a better fit for the maze
    {
        setImage("steel-ball.png");
        GreenfootImage teleportBall = getImage();
        teleportBall.scale(50, 50);
    }

    /**
     * Act - do whatever the Teleport wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
