import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class End here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class End extends Actor
{
    public End()   //constructor to resize end pad to be a better fit for the maze
    {
        setImage("endportal.png");
        GreenfootImage end = getImage();
        end.scale(100, 100);
    }
    
    /**
     * Act - do whatever the End wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (isTouching(Treasure.class))
        {
            score_treasure();
        }
    }
    
    private void score_treasure()
    {
        Actor Treasure;
        Treasure = getOneIntersectingObject(Treasure.class);
        Player.score += 350;
        World world;
        world = getWorld();
        world.removeObject(Treasure);
        
        MyWorld.trophy = true;
    }
}
