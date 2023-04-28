import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WallBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WallBreaker extends Actor
{
    public WallBreaker()
    {
        setImage("wallBreaker.png");
        GreenfootImage wallBreaker = getImage();
        wallBreaker.scale(48, 48);
        // scaled at 48 so that it fits in square nicer (doesn't touch walls)
    }
    /**
     * Act - do whatever the WallBreaker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
