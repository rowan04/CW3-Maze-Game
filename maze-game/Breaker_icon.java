import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * inventory icon that appears after picking up wall breaker item from the maze
 * gives a visual message that the player can now activate that item
 * icon dissapears after its activated
 */
public class Breaker_icon extends Actor
{
    public Breaker_icon()   // constructor to resize breaker icon to be a better fit for the maze
    {
        setImage("wallBreaker.png");   //sets the image of this actor
        GreenfootImage icon = getImage();
        icon.scale(98, 98);
        // scaled at 98 to fit on square better, so it doesn't touch edge/walls
    }
}
