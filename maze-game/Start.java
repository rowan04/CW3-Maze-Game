import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * icon for the maze that makes it look a little bit nicer
 * shows the player where the starting area is
 * doesn't do much other than look good
 * 
 */
public class Start extends Actor
{
    public Start()   //constructor to resize start pad to be a better fit for the maze
    {
        setImage("granite-light.jpg");   //sets the image of this actor
        GreenfootImage start = getImage();
        start.scale(100, 100);
    }

    /**
     * Act - do whatever the Start wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
