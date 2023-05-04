import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * page of story and information displayed on game start
 */
public class Intro extends Actor
{
    public Intro()   //constructor to resize intro text to be a better fit for the maze
    {
        setImage("Intro.png");     //sets the image of this actor
        GreenfootImage intro = getImage();
        intro.scale(1150, 700);     //sets image size of this actor
    }
    
    /**
     * Act - do whatever the Intro wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
