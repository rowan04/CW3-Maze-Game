import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * item to be picked up by player
 * allows the player to drag the treasure towards them while holding the m key
 * costs 1 point a second, if there isn't enough points then the magnet stops working
 * is also used as the inventory icon because it worked out quite nice
 */
public class Magnet extends Actor
{
    public Magnet()    //constructor to set information on actor creation
    {
        setImage("magnet.png");   //sets the image of this actor
        GreenfootImage magnet = getImage();
        magnet.scale(48, 48);     //sets image size of this actor
    }
}
