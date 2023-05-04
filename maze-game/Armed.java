import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * this button appears to tell the player that the ghost zapper is ready to launch
 * is displayed when the key 4 is held
 * is deleted when 4 is not pressed
 */
public class Armed extends Actor
{
    //sets image and size on creation
    public Armed()
    {
        //setImage("Armed_image.jpeg"); //sets image but doesn't work because it crashes with this 1 line
        GreenfootImage armed = getImage();
        armed.scale(25, 25);    //sets image size
    }
    /**
     * Act - do whatever the Armed wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
