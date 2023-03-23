import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wall3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wall3 extends Actor
{
    /**
     * Act - do whatever the Wall3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Wall3()   //constructor to resize wall to be a better fit for the maze
    {
        GreenfootImage brick = getImage();
        brick.scale(150, 50);
    }
    public void act()
    {
        // Add your action code here.
    }
}
