import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * item to be picked up by player
 * allows the player to shoot a beam to kill ghosts
 * this reveals the treasure
 */
public class Zapper extends Actor
{
    public Zapper()   //constructor to resize Zapper icon to be the size of a block
    {
        setImage("ghostZapper2000.jpeg");   //sets the image of this actor
        GreenfootImage zap = getImage();
        zap.scale(50, 50);
    }
    /**
     * Act - do whatever the Zapper wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
