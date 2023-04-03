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
    public static boolean hasTeleport = false;
    
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
        if(Greenfoot.isKeyDown("1") == true)
        {
            if(freeze == true)
            {
                timeFrozen();
            }
        }
        
        
        if(Greenfoot.isKeyDown("3") == true)
        {
            if(hasTeleport == true)
            {
                teleport();
            }
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
         * if touching the teleporter, call the collectTeleporter function
         */
        if (isTouching(Teleport.class))
        {
            collectTeleporter();
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
    
    private void teleport()
    {
        getWorld().removeObjects(getWorld().getObjects(Tele_option_3.class));
        Greenfoot.playSound("teleport.mp3");
        setLocation(15, 30);
    }
    /**
     * if player is touching teleport item, collect it, then delete the teleport item on thte maze
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
     * if player is touching wallBreaker, collect it, then delete the wallBreaker object
     */
    private void collectWallBreaker()
    {
        MyWorld.score += 10;
        hasWallBreaker = true;
        Actor WallBreaker = getOneIntersectingObject(WallBreaker.class);
        World world;
        world = getWorld();
        world.removeObject(WallBreaker);
        
        Breaker_icon breaker = new Breaker_icon();
        world.addObject(breaker,1100,900);
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
        
        MyWorld.score += 100;
        
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
        
        world.showText("Play again", 875, 675);
        Again again = new Again();
        world.addObject(again,875,725);
        world.showText(null, 925, 875);
        world.showText(null, 825, 875);
        
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
