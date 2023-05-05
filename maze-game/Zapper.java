import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * item to be picked up by player
 * allows the player to shoot a beam to kill ghosts
 * this reveals the treasure
 */
public class Zapper extends Actor
{
    /**
     * constructor to resize Zapper icon to be the right size
     */
    public Zapper()
    {
        setImage("zapper.png");   //sets the image of this actor
        GreenfootImage zap = getImage();
        zap.scale(48, 48);
    }
}
