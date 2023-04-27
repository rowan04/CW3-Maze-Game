import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.*;  //allows checking signs on integers

/**
 * This is the main player that the user will control.
 */
public class Player extends Actor
{
    public static boolean hasWallBreaker = false;
    public static boolean freeze = false;
    public static boolean hasTeleport = false;
    public static boolean hasZapper = false;
    public static boolean hasMagnet = false;
    public static boolean magState = false;
    private MyWorld myworld;
    // to clear confusion:
    // - hasSpeedPotion is true when the player picks up the speed potion
    // - useSpeedPotion is true when the player presses 2, regardless of whether they have a speed potion or not
    // - activateSpeedPotion is true when hasSpeedPotion and useSpeedPotion are both true
    public static boolean hasSpeedPotion = false;
    public static boolean useSpeedPotion = false;
    public static boolean activateSpeedPotion = false;
    public static int speedTimer = 300;
    public static int dx;
    public static int dy;
    
    private boolean mDown;
    
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
        dx = 0;
        dy = 0;
        String dir = "none";

        //check if speed potion has been activated - if it has, player moves twice as fast
        int speed = 2;
        
        if (activateSpeedPotion == true)
        {
            speed = 4;
        }
        // if speed potion active their speed is 4 if not its the default of 2
        if (Greenfoot.isKeyDown("up"))
        {
            dy = -speed;
        }
        if (Greenfoot.isKeyDown("left"))
        {
            dx = -speed;
        }
        if (Greenfoot.isKeyDown("down"))
        {
            dy = speed;
        }
        if (Greenfoot.isKeyDown("right"))
        {
            dx = speed;
        }

        if(mDown != Greenfoot.isKeyDown("m"))
        {
            if(hasMagnet == true)
            {
                toggleMagnet();
            }
            mDown = !mDown;
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
            if(hasSpeedPotion == true)
            {
                useSpeedPotion = true;
                // speed potion has been used, so no longer has a speed potion
                hasSpeedPotion = false;
            }
        }

        if(Greenfoot.isKeyDown("3") == true)
        {
            if(hasTeleport == true)
            {
                teleport();
            }
        }
        
        if(Greenfoot.isKeyDown("4") == true)
        {
            if(hasZapper == true)
            {
                zap();
            }
        }

        if (useSpeedPotion == true)
        {
            useSpeedPotion();
        }

        setLocation(getX()+dx, getY()+dy);

        if (isTouching(Wall1.class))
        {
            setLocation(getX()-dx, getY()-dy);
        }
        
        if (isTouching(Treasure.class))
        {
            Actor treasure = getOneIntersectingObject(Treasure.class);
            treasure.setLocation(treasure.getX()+dx, treasure.getY()+dy);
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
            if(hasTeleport == true)
            {
                teleport();
            }
            else
            {
                died();
            }
        }

        if (isTouching(Ghost2.class))
        {
            if(hasTeleport == true)
            {
                teleport();
            }
            else
            {
                died();
            }
        }

        if (isTouching(Ghost3.class))
        {
            if(hasTeleport == true)
            {
                teleport();
            }
            else
            {
                died();
            }
        }

        if (isTouching(Ghost4.class))
        {
            if(hasTeleport == true)
            {
                teleport();
            }
            else
            {
                died();
            }
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
         * if touching the magnet, call the collectMagnet function
         */
        if (isTouching(Magnet.class))
        {
            collectMagnet();
        }
        
        /**
         * if touching the magnet, call the collectTeleporter function
         */
        if (isTouching(Teleport.class))
        {
            collectTeleporter();
        }

        /**
         * if touching a speed potion, call the collectSpeedPotion function
         */
        if (isTouching(SpeedPotion.class))
        {
            collectSpeedPotion();
        }
        
        /**
         * if touching a ghost zapper, call the collectZapper function
         */
        if (isTouching(Zapper.class))
        {
            collectZapper();
        }

        /**
         * if is touching a breakable wall, call touchingBreakable function
         */
        if (isTouching(Breakable.class))
        {
            touchingBreakable(hasWallBreaker, dx, dy);
        }
        
        //if touching the send to puzzel room 1 actor they are sent to that room
        if (isTouching(Puzzel_world_1_tp.class))
        {
            //teleport to other world (save current world and when going back make sure player doesn't get caught in a teleport loop between the 2 worlds)
        }
    }

    /**
     * time freeze functionality
     */
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
        MyWorld.score += 10;
        hasWallBreaker = true;
        Actor WallBreaker;
        WallBreaker = getOneIntersectingObject(WallBreaker.class);
        World world;
        world = getWorld();
        world.removeObject(WallBreaker);
        
        Breaker_icon breaker = new Breaker_icon();
        world.addObject(breaker,1100,900);
    }
    
    /**
     * if player is touching Zapper, collect it, then delete the Zapper object
     */
    private void collectZapper()
    {
        MyWorld.score += 10;
        hasZapper = true;
        Actor Zapper;
        Zapper = getOneIntersectingObject(Zapper.class);
        World world;
        world = getWorld();
        world.removeObject(Zapper);
        
        Ghost_buster_icon busters = new Ghost_buster_icon();
        world.addObject(busters,350,900);
        
        Greenfoot.playSound("ghost_busters.mp3");
    }
    
    /**
     * if player is touching magnet, collect it, then delete the magnet object
     */
    private void collectMagnet()
    {
        MyWorld.score += 10;
        hasMagnet = true;
        Actor Magnet;
        Magnet = getOneIntersectingObject(Magnet.class);
        World world;
        world = getWorld();
        world.removeObject(Magnet);
        
        Magnet mag = new Magnet();
        world.addObject(mag,1025,875);
        world.showText("Mag off", 1005, 920);
    }

    /**
     * teleport functionality
     */
    private void teleport()
    {
        hasTeleport = false;
        getWorld().removeObjects(getWorld().getObjects(Tele_option_3.class));
        Greenfoot.playSound("teleport.mp3");
        setLocation(15, 30);
    }

    /**
     * if player is touching teleport item, collect it, then delete the teleport item on the maze
     */
    private void collectTeleporter()
    {
        MyWorld.score += 10;
        hasTeleport = true;
        Actor Teleport = getOneIntersectingObject(Teleport.class);
        World world;
        world = getWorld();
        world.removeObject(Teleport);
        
        Tele_option_3 tele = new Tele_option_3();
        world.addObject(tele,250,900);
    }

    /**
     * if player is touching time freeze, collect it, then delete the time freeze object
     */
    private void collectTimePotion()
    {
        MyWorld.score += 10;
        freeze = true;
        Actor TimePotion = getOneIntersectingObject(TimePotion.class);
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
        SpeedPotion = getOneIntersectingObject(SpeedPotion.class);
        MyWorld.score += 10;
        World world;
        world = getWorld();
        world.removeObject(SpeedPotion);
        
        SpeedPotion_option_1 speed = new SpeedPotion_option_1();
        world.addObject(speed,150,900);
    }

    /**
     * when 4 is pressed and they have the ghost zapper, it fires a beam to destroy the ghosts
     */
    private void zap()
    {
        if(Greenfoot.isKeyDown("up") == true)
        {
            hasZapper = false;
            getWorld().removeObjects(getWorld().getObjects(Ghost_buster_icon.class));
            Greenfoot.playSound("zap.mp3");
            
            getWorld().addObject(new Beam(-90), getX(), getY());
        }
        if(Greenfoot.isKeyDown("down") == true)
        {
            hasZapper = false;
            getWorld().removeObjects(getWorld().getObjects(Ghost_buster_icon.class));
            Greenfoot.playSound("zap.mp3");
            
            getWorld().addObject(new Beam(90), getX(), getY());
        }
        if(Greenfoot.isKeyDown("left") == true)
        {
            hasZapper = false;
            getWorld().removeObjects(getWorld().getObjects(Ghost_buster_icon.class));
            Greenfoot.playSound("zap.mp3");
            
            getWorld().addObject(new Beam(180), getX(), getY());
        }
        if(Greenfoot.isKeyDown("right") == true)
        {
            hasZapper = false;
            getWorld().removeObjects(getWorld().getObjects(Ghost_buster_icon.class));
            Greenfoot.playSound("zap.mp3");
            
            getWorld().addObject(new Beam(0), getX(), getY());
        }
    }
    
    /**
     * what happens when speedPotion is used
     */
    private void useSpeedPotion()
    {
        getWorld().removeObjects(getWorld().getObjects(SpeedPotion_option_1.class));
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
    
    private void toggleMagnet()
    {
        if(magState == false)
        {
            if(MyWorld.score != 0)
            {
                MyWorld.score -= 1;
                Treasure.timer = 0;
                magState = true;
                getWorld().showText("Mag on", 1005, 920);
            }
            else
            {
                magState = false;
                getWorld().showText("Mag off", 1005, 920);
            }
        }
        else if(magState == true)
        {
            magState = false;
            getWorld().showText("Mag off", 1005, 920);
        }
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
            Greenfoot.playSound("break.mp3");
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
        hasMagnet = false;
        
        MyWorld.score += 400;
        
        if (MyWorld.secondsTimer < 30)          //these are meant to stack
        {
            MyWorld.score += 50;
        }
        if (MyWorld.secondsTimer < 60)
        {
            MyWorld.score += 25;
        }
        if (MyWorld.secondsTimer < 120)
        {
            MyWorld.score += 10;
        }
        
        World world = getWorld();
        java.util.List<Actor> actors = world.getObjects(null);
        actors.removeAll(world.getObjects(Player.class));
        world.removeObjects(actors);
        String score = " " + MyWorld.score;
        String time = " " + MyWorld.secondsTimer + " Seconds.";
        world.showText("YOU WIN!!!", 575, 350);
        world.showText("Score:" + score, 575, 400);
        world.showText("Time:" + time, 575, 450);
        
        world.showText(null, 1005, 920);
        
        world.showText("Play again", 875, 675);
        Again again = new Again();
        world.addObject(again,875,725);
        world.showText(null, 925, 875);
        world.showText(null, 825, 875);
        
        world.showText("Quit game", 1075, 475);
        Quit quit = new Quit();
        world.addObject(quit,1075,525);
        
        world.showText(null, 725, 875);
        
        if (MyWorld.trophy == true)
        {
            Trophy award = new Trophy();
            world.addObject(award,286,507);
        }
    }

    /**
     * player died - removes all actors except the player then displays information and gives player choice to play again or not
     */
    private void died()
    {
        ((MyWorld)getWorld()).music.stop();
        Greenfoot.playSound("death.mp3");
        MyWorld.startTimer = false;
        hasMagnet = false;
        World world = getWorld();
        java.util.List<Actor> actors = world.getObjects(null);
        actors.removeAll(world.getObjects(Player.class));
        world.removeObjects(actors);
        String score = " " + MyWorld.score;
        String time = " " + MyWorld.secondsTimer + " Seconds.";
        world.showText("YOU DIED", 575, 350);
        world.showText("Score:" + score, 575, 400);
        world.showText("Time:" + time, 575, 450);
        world.showText(null, 925, 875);
        world.showText(null, 825, 875);
        
        world.showText("Play again", 875, 675);
        Again again = new Again();
        world.addObject(again,875,725);
        
        world.showText(null, 725, 875);
        world.showText(null, 1005, 920);
        
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
