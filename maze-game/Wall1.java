import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A 50x50 pixel image of maze wall.
 * This is used as one standard "building block" of the maze walls
 * It's only still called wall1 so that around 180 lines don't have to be changed in MyWorld
 * 
 * 26/04/2023
 */
public class Wall1 extends Actor
{
    public Wall1()
    {
        setImage("newWall.png");   //sets the image of this actor
        // wall does not need resizing it was made 50x50 pixels (the size of 1 block)
    }
}
