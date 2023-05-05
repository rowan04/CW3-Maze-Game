import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * this button appears to tell the player that the ghost zapper is ready to launch
 * is displayed when the key 4 is held
 * is deleted when 4 is not pressed
 */
public class Armed extends Actor
{
    /**
     * sets image and size on creation
     */
    public Armed()
    {
        setImage("armed.png");
        GreenfootImage armed = getImage();
        armed.scale(25, 25);    //sets image size
    }
}
