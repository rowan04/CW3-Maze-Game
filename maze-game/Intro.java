import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Intro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Intro extends Actor
{
    /**
     * Act - do whatever the Intro wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Intro()   //constructor to resize intro text to be a better fit for the maze
    {
        GreenfootImage intro = getImage();
        intro.scale(1150, 467);
    }
    public void act()
    {
        // Add your action code here.
    }
}
