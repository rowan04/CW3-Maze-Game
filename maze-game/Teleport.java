import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * item to be picked up by player
 * allows the player to use it at will to teleport to the start
 * or uses automatically when a ghost gets them instead of loosing
 */
public class Teleport extends Actor
{
    public Teleport()   //constructor to resize Teleport icon to be a better fit for the maze
    {
        setImage("teleporter.png");   //sets the image of this actor
        GreenfootImage teleportBall = getImage();
        teleportBall.scale(50, 50);
    }
}
