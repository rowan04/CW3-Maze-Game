import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * inventory icon that appears after picking up TimePotion item from the maze
 * gives a visual message that the player can now activate that item
 * icon dissapears after its activated
 */
public class Time_option_1 extends Actor
{
    public Time_option_1()   //constructor to resize time stop inventory icon to fit in the inventory
    {
        setImage("timeFreeze.png");   //sets the image of this actor
        GreenfootImage inv_1 = getImage();
        inv_1.scale(100, 100);
    }
}
