import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * inventory icon that appears after picking up zapper item from the maze
 * gives a visual message that the player can now activate that item
 * icon dissapears after its activated
 */
public class Ghost_buster_icon extends Actor
{
    public Ghost_buster_icon()   //constructor to resize ghost_buster_icon to be a better fit for the inventory
    {
        setImage("ghostBusters.png");   //sets the image of this actor
        GreenfootImage zap = getImage();
        zap.scale(100, 100);   //sets the image size of this actor
    }

    /**
     * Act - do whatever the ghost_buster_icon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
