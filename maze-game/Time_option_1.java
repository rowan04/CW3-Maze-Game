import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Time_option_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Time_option_1 extends Actor
{
    /**
     * Act - do whatever the Time_option_1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Time_option_1()   //constructor to resize breakable wall to be a better fit for the maze
    {
        GreenfootImage brick = getImage();
        brick.scale(100, 100);
    }
    public void act()
    {
        // Add your action code here.
    }
}
