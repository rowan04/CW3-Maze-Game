import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Time_option_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Time_option_1 extends Actor
{
    public Time_option_1()   //constructor to resize time stop inventory icon to fit in the inventory
    {
        setImage("1_time_freeze_icon.jpeg");
        GreenfootImage inv_1 = getImage();
        inv_1.scale(100, 100);
    }

    /**
     * Act - do whatever the Time_option_1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
