import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * item to be picked up by player
 * allows the player to break breakable walls around the maze exit to win the game
 */
public class WallBreaker extends Actor
{
    public WallBreaker()    //constructor to set the information for the wall breaker
    {
        setImage("wallBreaker.png");   //sets the image of this actor
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
