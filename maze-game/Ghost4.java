import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The ghost is the enemy of the game.
 * 
 * It moves around randomly in a set area.
 * And if it touches the player, the player
 * 'dies' and loses the game.
 * 
 */
public class Ghost4 extends Actor
{
    /**
     * these values keep the ghost within their set area
     */
    public static int lower_x;
    public static int upper_x;
    public static int lower_y;
    public static int upper_y;
    
    /**
     * constructor to resize player to be a better fit for the maze
     */
    public Ghost4()
    {
        GreenfootImage ghost = getImage();
        int newHeight = (int)ghost.getHeight()/5;
        int newWidth = (int)ghost.getWidth()/5;
        ghost.scale(newWidth, newHeight);
    }

    /**
     * what the ghost will do when program is ran
     */
    public void act()
    {
        if(MyWorld.stop == false)
        {
            move();
        }
    }
    
    /**
     * how the ghost moves
     */
    public void move()
    {
        move(2);
        
        /**
         * allow the ghost to change direction randomly (3% chance)
         */
        if (Greenfoot.getRandomNumber(100) < 3) {
            turn(Greenfoot.getRandomNumber(361)-180);
        }
        
        // get ghosts coordinates
        int x = getX();
        int y = getY();
        
        /**
         * make it so that the ghost can't leave its specified area
         */
        if (x <= lower_x)
        {
            setLocation(getX()+2, getY());
            turn(Greenfoot.getRandomNumber(360));
        }
        
        if (x >= upper_x)
        {
            setLocation(getX()-2, getY());
            turn(Greenfoot.getRandomNumber(360));
        }
        
        if (y <= lower_y)
        {
            setLocation(getX(), getY()+2);
            turn(Greenfoot.getRandomNumber(360));
        }
        
        if (y >= upper_y)
        {
            setLocation(getX(), getY()-2);
            turn(Greenfoot.getRandomNumber(360));
        }
    }
}
