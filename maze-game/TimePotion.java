import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TimePotion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TimePotion extends Actor
{
    public TimePotion()   //constructor to resize time freeze to be a better fit for the maze
    {
        setImage("time_freeze_icon.jpeg");
        GreenfootImage size = getImage();
        size.scale(50, 50);
    }

    /**
     * Act - do whatever the TimePotion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
    }
}
