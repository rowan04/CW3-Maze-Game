import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The treasure is a moveable entity
 * The player can move it around the maze
 * It can't go through walls
 * If the player gets it to the end, they get extra points
 * 
 */
public class Treasure extends Actor
{
    public static int timer = 0;    //sets timer variable to equal 0 on actor creation
    
    /**
     * constructor to resize treasure to be small so manovering around the maze isn't impossible
     */
    public Treasure()   //sets size and image on actor creation
    {
        setImage("treasure_image.jpeg");
        GreenfootImage treasure = getImage();
        treasure.scale(15, 15);
    }

    /**
     * The treasure should be unable to go through walls
     * to do this, it needs the dx and dy value from the player
     * it will then be pushed in the opposite direction
     */
    public void act()
    {
        //gets coordinates of player
        int dx = Player.dx;
        int dy = Player.dy;
        
        //if this actor is touching a wall it teleports back (prevents going into wall)
        if (isTouching(Wall1.class))
        {
            setLocation(getX()-dx, getY()-dy);
        }
        
        //checks if magnet is on using magState variable in Player class
        if(Player.magState == true)
        {
            //adds 1 to timer to count how many points should be deducted
            timer += 1;
        
            //every 60 ticks (1 second) one point is deducted from the score and the timer is reset
            if(timer == 60)
            {
                Player.score -= 1;
                timer = 0;
            }
            
            //if the players score isn't 0 then the treasure moves towards the Player
            if(Player.score != 0)
            {
                //gets Player actor as a variable
                java.util.List actors = getWorld().getObjects(Player.class);
                Player actor = (Player)actors.get(0);
                
                //turns to ward Player actor
                turnTowards(actor.getX(), actor.getY());
                
                //if this actor isn't touching a wall it moves toward the Player
                if (! isTouching(Wall1.class))
                {
                    move(3);
                }
            }
            //if score is 0 then it automatically switches the magnet off because it can't be powered
            else
            {
                Player.magState = false;
                getWorld().showText("Mag off", 1005, 920);
            }
        }
    }
}
