import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wall extends Actor
{
    public Wall()   //constructor to resize wall to be a better fit for the maze
    {
        GreenfootImage brick = getImage();
        int newHeight = (int)brick.getHeight()/2;
        int newWidth = (int)brick.getWidth()/2;
        brick.scale(newWidth, newHeight);
    }
    /**
     * Act - do whatever the Wall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
