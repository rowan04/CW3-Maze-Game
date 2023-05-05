import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * marks the spawnpoint of a ghost
 * lets the player know that staying near it is probably a bad idea
 */
public class Skull extends Actor
{
    public Skull()    //constructor to set information on actor creation
    {
        setImage("Skull.png");   //sets the image of this actor
        GreenfootImage skull = getImage();
        skull.scale(30, 30);     //sets image size of this actor
    }
}
