import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * if the player touches this then it trigures the victory
 * if the treasure touches this then it adds it to the score
 */
public class End extends Actor
{
    public End()   //constructor to resize end pad to be a better fit for the maze
    {
        setImage("endportal.png");   //sets the image of this actor
        GreenfootImage end = getImage();
        end.scale(100, 100);   //sets the image size of this actor
    }
    
    /**
     * Called when program is run
     * constantly checks if the treasure is touching it
     * if it is it calls score_treasure method
     */
    public void act()
    {
        if (isTouching(Treasure.class))
        {
            score_treasure();
        }
    }
    
    /**
     * if called from act method then deletes the treasure that is touching it, increases the score and enables the fancy trophy at the end
     */
    private void score_treasure()
    {
        Actor Treasure;
        Treasure = getOneIntersectingObject(Treasure.class);    //gets Treasure actor touching it
        Player.score += 350;    //increases score by 350
        World world;
        world = getWorld();
        world.removeObject(Treasure);   //deletes Treasure actor
        
        //enables trophy at the end
        MyWorld.trophy = true;
    }
}
