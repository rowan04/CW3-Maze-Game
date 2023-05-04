import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * inventory icon that appears after picking up Teleport item from the maze
 * gives a visual message that the player can now activate that item
 * icon dissapears after its activated
 */
public class Tele_option_3 extends Actor
{
    public Tele_option_3()   //constructor to resize teleporter inventory icon to fit in the inventory
    {
        setImage("steel-ball.png");   //sets the image of this actor
        GreenfootImage inv_1 = getImage();
        inv_1.scale(100, 100);
    }

    /**
     * Act - do whatever the Tele_option_3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
