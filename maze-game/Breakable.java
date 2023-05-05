import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * the same as a wall block but the wall breaker can be used to destroy it
 */
public class Breakable extends Actor
{
    public Breakable()   //constructor to resize breakable wall to be a better fit for the maze
    {
        setImage("crackedWall.png");   //sets the image of this actor
        GreenfootImage crackedWall = getImage();
        crackedWall.scale(50, 50);   //sets the image size of this actor
    }
}
