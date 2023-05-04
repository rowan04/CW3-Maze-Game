import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The ghost is the enemy of the game.
 * 
 * It moves around randomly in a set area.
 * And if it touches the player, the player
 * 'dies' and loses the game.
 * 
 */
public class Ghost2 extends Actor
{
    /**
     * these values keep each ghost within their set area
     */
    public static int lower_x;
    public static int upper_x;
    public static int lower_y;
    public static int upper_y;
    
    /**
     * constructor to resize player to be a better fit for the maze
     */
    public Ghost2()   //constructor to resize the ghost to fit the maze and set the image
    {
        setImage("ghost1.png");
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
        //if the stop variable is not true (time freeze not in effect) then calls the move method to move the ghost
        if(MyWorld.stop == false)
        {
            move();
        }
        //if the ghost is touching the beam from the ghost zapper then it spawns the treasure and dies adding score and playing a sound effect
        if (isTouching(Beam.class))
        {
            getWorld().addObject(new Treasure(), getX(), getY());   //spawns treasure
            getWorld().removeObject(this);  //destroys "this" ghost
            Greenfoot.playSound("ghost_gone.mp3");  //ghost death sound effect
            Player.score += 200;    //increases score by 200
        }
    }
    
    /**
     * how the ghost moves
     */
    public void move()
    {
        //moves the ghost dependent on the difficulty setting
        move(MyWorld.difficulty_setting);
        
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
