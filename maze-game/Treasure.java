import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The treasure is a moveable entity
 * The player can move it around the maze
 * It can't go through walls
 * If the player gets it to the end, they get 300 extra points
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Treasure extends Actor
{
    public static int timer = 0;
    
    /**
     * constructor to resize treasure to be small so manovering around the maze isn't impossible
     */
    public Treasure()
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
        
        int dx = Player.dx;
        int dy = Player.dy;
        
        if (isTouching(Wall1.class))
        {
            setLocation(getX()-dx, getY()-dy);
        }
        
        
        if(Player.magState == true)
        {
            timer += 1;
        
            if(timer == 60)
            {
                Player.score -= 1;
                timer = 0;
            }
            
            if(Player.score != 0)
            {
                java.util.List actors = getWorld().getObjects(Player.class);
                Player actor = (Player)actors.get(0);
                turnTowards(actor.getX(), actor.getY());
                if (! isTouching(Wall1.class))
                {
                    move(3);
                }
            }
            else
            {
                Player.magState = false;
                getWorld().showText("Mag off", 1005, 920);
            }
        }
    }
}
