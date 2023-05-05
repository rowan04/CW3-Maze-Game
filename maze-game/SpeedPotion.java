import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * item to be picked up by player
 * allows the player to use it to boost their speed for a limited duration
 */
public class SpeedPotion extends Actor
{
    /**
     * constructor to resize speed potion to be a better fit for the maze
     */
    public SpeedPotion()
    {
        setImage("speed.png");   //sets the image of this actor
        GreenfootImage speedPotion = getImage();
        speedPotion.scale(48, 48);
    }
}
