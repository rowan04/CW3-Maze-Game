import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TimeFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TimeFilter extends Actor
{
    private int timer;

    public TimeFilter()   //constructor to resize the time filter to fit the maze
    {
        setImage("granite-light.jpg");
        GreenfootImage filter = getImage();
        filter.scale(1150, 950);
        filter.setTransparency(80);
    }

    /**
     * Act - do whatever the TimeFilter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        timer ++;
        if(timer<=500)
        {
            MyWorld.stop = true;
            //stop
        }
            
        if(timer>300)
        {
            MyWorld.stop = false;
            
            getWorld().removeObjects(getWorld().getObjects(TimeFilter.class));
        }
    }
}
