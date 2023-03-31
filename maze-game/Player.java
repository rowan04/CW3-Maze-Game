import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.*;  //allows checking signs on integers
/**
 * This is the main player that the user will control.
 * 
 */
public class Player extends Actor
{
    public static boolean hasWallBreaker = false;
    public static boolean freeze = false;
    
    // to clear confusion:
    // - hasSpeedPotion is true when the player picks up the speed potion
    // - useSpeedPotion is true when the player presses 2, regardless of whether they have a speed potion or not
    // - activateSpeedPotion is true when hasSpeedPotion and useSpeedPotion are both true
    public static boolean hasSpeedPotion = false;
    public static boolean useSpeedPotion = false;
    public static boolean activateSpeedPotion = false;
    public static int speedTimer = 300;
    
    /**
     * constructor to resize player to be a better fit for the maze
     */
    public Player()
    {
        GreenfootImage person = getImage();
        int newHeight = (int)person.getHeight()/2;
        int newWidth = (int)person.getWidth()/2;
        person.scale(newWidth, newHeight);
    }

    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        int dx = 0, dy = 0;
        String dir = "none";

        //check if speed potion has been activated - if it has, player moves twice as fast
        if (activateSpeedPotion == true)
        {
            if (Greenfoot.isKeyDown("up"))
            {
                dy = -4;
            }
            if (Greenfoot.isKeyDown("left"))
            {
                dx = -4;
            }
            if (Greenfoot.isKeyDown("down"))
            {
                dy = 4;
            }
            if (Greenfoot.isKeyDown("right"))
            {
                dx = 4;
            }
        }
        // else, speed potion is not being used, so player moves normal speed
        else
        {
            if (Greenfoot.isKeyDown("up"))
            {
                dy = -2;
            }
            if (Greenfoot.isKeyDown("left"))
            {
                dx = -2;
            }
            if (Greenfoot.isKeyDown("down"))
            {
                dy = 2;
            }
            if (Greenfoot.isKeyDown("right"))
            {
                dx = 2;
            }
        }

        if(Greenfoot.isKeyDown("1") == true)
        {
            if(freeze == true)
            {
                timeFrozen();
            }
        }

        if(Greenfoot.isKeyDown("2") == true)
        {
            //useSpeedPotion = true;
            if(hasSpeedPotion == true)
            {
                useSpeedPotion = true;
                // speed potion has been used, so no longer has a speed potion
                hasSpeedPotion = false;
            }
        }
        
        if (useSpeedPotion == true)
        {
            useSpeedPotion(speedTimer);
        }

        setLocation(getX()+dx, getY()+dy);

        if (isTouching(Wall1.class))
        {
            setLocation(getX()-dx, getY()-dy);
        }

        if (isTouching(Wall2.class))
        {
            setLocation(getX()-dx, getY()-dy);
        }

        if (isTouching(Wall3.class))
        {
            setLocation(getX()-dx, getY()-dy);
        }

        if (isTouching(End.class))
        {
            endGame();
        }

        if (isTouching(Quit.class))
        {
            System.exit(0);
        }

        if (isTouching(Again.class))
        {
            Greenfoot.setWorld(new MyWorld());
        }

        /**
         * if touching any of the ghosts, player dies and loses
         */
        if (isTouching(Ghost1.class))
        {
            died();
        }

        if (isTouching(Ghost2.class))
        {
            died();
        }

        if (isTouching(Ghost3.class))
        {
            died();
        }

        if (isTouching(Ghost4.class))
        {
            died();
        }

        /**
         * if touching the wall breaker, call the collectWallBreaker function
         */
        if (isTouching(WallBreaker.class))
        {
            collectWallBreaker();
        }
        
        /**
         * if touching the time freeze, call the collectTimePotion function
         */
        if (isTouching(TimePotion.class))
        {
            collectTimePotion();
        }

        /**
         * if touching a speed potion, call the collectSpeedPotion function
         */
        if (isTouching(SpeedPotion.class))
        {
            collectSpeedPotion();
        }

        /**
         * if is touching a breakable wall, call touchingBreakable function
         */
        if (isTouching(Breakable.class))
        {
            touchingBreakable(hasWallBreaker, dx, dy);
        }
    }

    private void timeFrozen()
    {
        getWorld().removeObjects(getWorld().getObjects(Time_option_1.class));
        Greenfoot.playSound("stop_time.mp3");
        TimeFilter time = new TimeFilter();
        getWorld().addObject(time,575,475);
        
        freeze = false;
    }

    /**
     * if player is touching wallBreaker, collect it, then delete the wallBreaker object
     */
    private void collectWallBreaker()
    {
        hasWallBreaker = true;
        Actor WallBreaker;
        WallBreaker = getOneObjectAtOffset(0, 0, WallBreaker.class);
        World world;
        world = getWorld();
        world.removeObject(WallBreaker);
        
        Breaker_icon breaker = new Breaker_icon();
        world.addObject(breaker,1100,900);
    }

    /**
     * if player is touching time freeze, collect it, then delete the time freeze object
     */
    private void collectTimePotion()
    {
        freeze = true;
        Actor TimePotion;
        TimePotion = getOneObjectAtOffset(0, 0, TimePotion.class);
        World world;
        world = getWorld();
        world.removeObject(TimePotion);
        
        Time_option_1 time = new Time_option_1();
        world.addObject(time,50,900);
    }

    /**
     * if player is touching speed potion, collect it, then delete the speed potion object
     */
    private void collectSpeedPotion()
    {
        hasSpeedPotion = true;
        Actor SpeedPotion;
        SpeedPotion = getOneObjectAtOffset(0, 0, SpeedPotion.class);
        World world;
        world = getWorld();
        world.removeObject(SpeedPotion);
        
        //Breaker_icon breaker = new Breaker_icon();
        //world.addObject(breaker,1100,900);
    }

    /**
     * what happens when speedPotion is used
     */
    private void useSpeedPotion(int speedTimer)
    {
        if (speedTimer > 0)
        {
            activateSpeedPotion = true;
            speedTimer--;
        }
        else
        {
            resetSpeed();
        }
    }
    
    private void resetSpeed()
    {
        useSpeedPotion = false;
        activateSpeedPotion = false;
    }

    /**
     * if player has a wallbreaker, break the breakable wall. Else, be moved away
     */
    private void touchingBreakable(boolean hasWallBreaker, int dx, int dy)
    {
        if (hasWallBreaker) {
            Actor Breakable;
            Breakable = getOneObjectAtOffset(0, 0, Breakable.class);
            World world;
            world = getWorld();
            world.removeObject(Breakable);
            getWorld().removeObjects(getWorld().getObjects(Breaker_icon.class));
        }
        else
        {
            setLocation(getX()-dx, getY()-dy);
        }
    }

    /**
     * player won - removes all actors except the player then displays information and gives player choice to play again or not
     */
    private void endGame()
    {
        ((MyWorld)getWorld()).music.stop();
        Greenfoot.playSound("victory.mp3");
        MyWorld.startTimer = false;
        World world = getWorld();
        java.util.List<Actor> actors = world.getObjects(null);
        actors.removeAll(world.getObjects(Player.class));
        world.removeObjects(actors);
        String score = " 200 Points";
        String time = " " + MyWorld.secondsTimer + " Seconds.";
        world.showText("YOU WIN!!!", 575, 350);
        world.showText("Score:" + score, 575, 400);
        world.showText("Time:" + time, 575, 450);
        
        world.showText("Play again", 875, 675);
        Again again = new Again();
        world.addObject(again,875,725);
        world.showText(null, 925, 875);
        
        world.showText("Quit game", 1075, 475);
        Quit quit = new Quit();
        world.addObject(quit,1075,525);
    }

    /**
     * player died - removes all actors except the player then displays information and gives player choice to play again or not
     */
    private void died()
    {
        ((MyWorld)getWorld()).music.stop();
        Greenfoot.playSound("death.mp3");
        MyWorld.startTimer = false;
        World world = getWorld();
        java.util.List<Actor> actors = world.getObjects(null);
        actors.removeAll(world.getObjects(Player.class));
        world.removeObjects(actors);
        String score = " 200 points";
        String time = " " + MyWorld.secondsTimer + " Seconds.";
        world.showText("YOU DIED", 575, 350);
        world.showText("Score:" + score, 575, 400);
        world.showText("Time:" + time, 575, 450);
        world.showText(null, 925, 875);
        
        world.showText("Play again", 875, 675);
        Again again = new Again();
        world.addObject(again,875,725);
        
        world.showText("Quit game", 1075, 475);
        Quit quit = new Quit();
        world.addObject(quit,1075,525);
    }

    /**
     * defines how the player moves
     */
    public void move(final int distance) {
        super.move(distance);
    }
}
