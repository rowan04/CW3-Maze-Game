import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * inventory icon that appears after picking up TimePotion item from the maze
 * gives a visual message that the player can now activate that item
 * icon dissapears after its activated
 * 
 */
public class Time_option_1 extends Actor
{
    public Time_option_1()   //constructor to resize time stop inventory icon to fit in the inventory
    {
        setImage("1_time_freeze_icon.jpeg");   //sets the image of this actor
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
