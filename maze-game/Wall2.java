import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wall2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wall2 extends Actor
{
    /**
     * Act - do whatever the Wall2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Wall2()   //constructor to resize wall to be a better fit for the maze
    {
        GreenfootImage brick = getImage();
        brick.scale(100, 50);
    }
    public void act()
    {
        // Add your action code here.
    }
}
