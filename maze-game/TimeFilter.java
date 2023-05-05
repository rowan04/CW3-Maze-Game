import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * on creation of this actor when the player selects this power from the inventory
 * the actor covers the screen to create a cool look
 * this actor then counts how long the time stop effects will last then it resets the stop variable
 * it the removes itself to show the effect has ended
 */
public class TimeFilter extends Actor
{
    private int timer;  //creates local variable timer on actor creation

    public TimeFilter()   //constructor to resize the time filter to fit the maze
    {
        setImage("granite-light.jpg");   //sets the image of this actor
        GreenfootImage filter = getImage();
        filter.scale(1150, 950);
        filter.setTransparency(80);     //makes this actor slightly transparent to make a cool visual effect
    }

    /**
     * called when program is ran
     */
    public void act()
    {
        //this actor is only thtere when the player uses the time stop ability so this is what controls its effects
        
        timer ++;   //increases the timer variable every tick
        
        //while timer is less than 500 it sets the world variable stop to true which then activates the effects
        if(timer<=500)
        {
            MyWorld.stop = true;
        }
        
        //when the timer is over 300 the effect ends, stop is set to false and this actor is deleted returning the screen to normal
        if(timer>300)
        {
            MyWorld.stop = false;
            
            getWorld().removeObjects(getWorld().getObjects(TimeFilter.class));
        }
    }
}
