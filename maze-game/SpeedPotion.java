import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpeedPotion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpeedPotion extends Actor
{
    /**
     * constructor to resize player to be a better fit for the maze
     */
    public SpeedPotion()
    {
        GreenfootImage speedPotion = getImage();
        //int newHeight = (int)speedPotion.getHeight()/12;
        //int newWidth = (int)speedPotion.getWidth()/12;
        //speedPotion.scale(newWidth, newHeight);
        speedPotion.scale(50, 50);
    }
    
    /**
     * Act - do whatever the SpeedPotion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
