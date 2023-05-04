import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * inventory icon that appears after picking up speed potion item from the maze
 * gives a visual message that the player can now activate that item
 * icon dissapears after its activated
 */
public class SpeedPotion_option_1 extends Actor
{
    /**
     * constructor to resize speed potion icon to be a better fit for the maze
     */
    public SpeedPotion_option_1()
    {
        setImage("speed.png");   //sets the image of this actor
        GreenfootImage speedPotionInv = getImage();
        // 95 scale fits better in inventory than 100 scale
        speedPotionInv.scale(95, 95);
    }

    /**
     * Act - do whatever the SpeedPotion_option_1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
    }
}
