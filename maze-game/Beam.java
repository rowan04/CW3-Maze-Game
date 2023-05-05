import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * this actor appears when the zapper is used, it travels in a direction until it hits a wall or the edge of the world
 */
public class Beam extends Actor
{
    private int direction, speed;  //creates local variable direction and speed on actor creation
    
    public Beam(int dir)    //on creation sets the information for this actor using the direction it was given by a player input
    {
        setImage("beam.png");   //sets the image of this actor
        GreenfootImage beam = getImage();
        beam.scale(25, 25);
        
        direction = dir;    //player input
        speed = 15;     //speed defined here so can be easily changed if decided we don't want that speed
    }

    /**
     * This method is called when program is ran.
     */
    public void act()
    {
        setRotation(direction); //rotates the beam based on the players input
        move(speed);    //the beam then moves along that line
        
        //checks if hit an obstacle
        if (isTouching(Wall1.class))
        {
            getWorld().removeObject(this);  //if touched a wall then the actor deletes itself
        }
        else if (isAtEdge())
        {
            getWorld().removeObject(this);  //if touched the edge of the world the actor deletes itself
        }
    }
}
