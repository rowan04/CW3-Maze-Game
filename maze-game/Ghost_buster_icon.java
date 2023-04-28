import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ghost_buster_icon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ghost_buster_icon extends Actor
{
    public Ghost_buster_icon()   //constructor to resize ghost_buster_icon to be a better fit for the inventory
    {
        setImage("ghostBusters.png");
        GreenfootImage zap = getImage();
        zap.scale(100, 100);
    }

    /**
     * Act - do whatever the ghost_buster_icon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
