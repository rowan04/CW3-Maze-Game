import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * goes into inventory
 */
public class SpeedPotion_option_1 extends Actor
{
    /**
     * constructor to resize player to be a better fit for the maze
     */
    public SpeedPotion_option_1()
    {
        GreenfootImage inv_1 = getImage();
        // 95 scale fits better in inventory than 100 scale
        inv_1.scale(95, 95);
    }

    /**
     * Act - do whatever the SpeedPotion_option_1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
    }
}
