import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * this actor is used just as an icon
 * displays this icon if the player has brought the treasure to the end when the game ends
 */
public class Trophy extends Actor
{
    public Trophy()    //constructor to set information on actor creation
    {
        setImage("trophy.png");   //sets the image of this actor
        GreenfootImage trophy = getImage();
        trophy.scale(300, 300);
    }
}
