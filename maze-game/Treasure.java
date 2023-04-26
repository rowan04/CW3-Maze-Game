import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Moveable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Treasure extends Actor
{
    public Treasure()   //constructor to resize treasure to be slightly bigger than the maze wall to make moveing it not impossible
    {
        GreenfootImage brick = getImage();
        brick.scale(51, 51);
    }
    /**
     * Act - do whatever the Moveable wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
    }
}
