import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends Actor
{
    /**
     * Act - do whatever the Start wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Start()   //constructor to resize start pad to be a better fit for the maze
    {
        GreenfootImage start = getImage();
        start.scale(100, 100);
    }
    public void act()
    {
        // Add your action code here.
    }
}
