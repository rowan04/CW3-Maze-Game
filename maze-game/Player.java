import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.*;  //allows checking signs on integers

/**
 * This is the main player that the user will control.
 */
public class Player extends Actor
{
    //sets up all public variables accessed by all classes to control items, score, speed and Player position
    
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
    // making score a player attribute
    public static int score;
    public static int speed = 2;
    
    //private variable checking if the m key is being held
    private boolean mDown;
    
    
    /**
     * constructor to resize player to be a better fit for the maze
     */
    public Player() //sets image and size of this actor
    {
        setImage("player.png");
        GreenfootImage person = getImage();
        int newHeight = (int)person.getHeight()/16;
        int newWidth = (int)person.getWidth()/16;
        person.scale(newWidth, newHeight);
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //sets up the movement variables
        dx = 0;
        dy = 0;
        String dir = "none";

        //check if speed potion has been activated - if it has, player moves twice as fast
        
        if (activateSpeedPotion == true)
        {
            speed = 4;
        }
        // if speed potion active their speed is 4 if not its the default of 2
        //when the player presses an arrow key then teh d value is set to a number
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
        
        //if m is pressed and they have the magnet then call toggleMagnet method
        //when m is pressed it uses the mDown variable to determin if m has been presses so it doesn't repetedly activate the magnet
        if(mDown != Greenfoot.isKeyDown("m"))
        {
            if(hasMagnet == true)
            {
                toggleMagnet();
            }
            mDown = !mDown;
        }
        
        //if 1 is pressed and the have the time freeze item, timeFrozen method is called
        if(Greenfoot.isKeyDown("1") == true)
        {
            if(freeze == true)
            {
                timeFrozen();
            }
        }

        //if 2 is pressed and the have the speed potion item, 2 ariables are changed
        //one tells program there is no longer a speed potion in the inventory
        //the other tells the program that the speed potion has been used
        if(Greenfoot.isKeyDown("2") == true)
        {
            if(hasSpeedPotion == true)
            {
                useSpeedPotion = true;
                // speed potion has been used, so no longer has a speed potion
                hasSpeedPotion = false;
            }
        }

        //if 3 is pressed and the have the teleport item, teleport method is called
        if(Greenfoot.isKeyDown("3") == true)
        {
            if(hasTeleport == true)
            {
                teleport();
            }
        }
        
        //if 4 is held and the have the ghost zapper item, an Armed actor appears in the set location to tell the user the gun is ready to fire
        //and zap method is called
        if(Greenfoot.isKeyDown("4") == true)
        {
            if(hasZapper == true)
            {
                Armed armed = new Armed();
                getWorld().addObject(armed,412,895);
                zap();
            }
        }
        //if 4 isn't pressed, it removes all Armed actors
        if(Greenfoot.isKeyDown("4") == false)
        {
            getWorld().removeObjects(getWorld().getObjects(Armed.class));
        }

        //if the variable is true it calls the method
        if (useSpeedPotion == true)
        {
            useSpeedPotion();
        }

        //moves the Player
        setLocation(getX()+dx, getY()+dy);

        //if the player is touching a wall they move backwards (opposit direction so they don't move at all)
        if (isTouching(Wall1.class))
        {
            setLocation(getX()-dx, getY()-dy);
        }
        
        //if they are touching a Treasure actor then it moves that actor the same direction as the player
        if (isTouching(Treasure.class))
        {
            Actor treasure = getOneIntersectingObject(Treasure.class);  //gets touching Treasure actor
            treasure.setLocation(treasure.getX()+dx, treasure.getY()+dy);   //moves treasure
            setLocation(getX()-dx, getY()-dy);  //moves player back so they don't clip throgh the treasure
        }

        //if they made it to the end call the endGame method
        if (isTouching(End.class))
        {
            endGame();
        }

        //if they touched the quit button then exits the game
        if (isTouching(Quit.class))
        {
            System.exit(0);
        }

        //if they touched teh play again button then resets the maze
        if (isTouching(Again.class))
        {
            Greenfoot.setWorld(new MyWorld());
        }

        /**
         * if touching any of the ghosts, player dies and loses
         */
        if (isTouching(Ghost1.class) || isTouching(Ghost2.class) || isTouching(Ghost3.class) || isTouching(Ghost4.class))
        {
            if(hasTeleport == true)
            {
                teleport(); //if they have the teleport item, call teleport method instead of loosing
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
         * if touching the teleporter, call the collectTeleporter function
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
    }

    /**
     * time freeze functionality
     */
    private void timeFrozen()
    {
        getWorld().removeObjects(getWorld().getObjects(Time_option_1.class));   //deletes icon from inventory
        Greenfoot.playSound("stop_time.mp3");   //cool sound effect is played
        TimeFilter time = new TimeFilter();
        getWorld().addObject(time,575,475); //creates cool filter that counts how long the time freeze is in effect
        
        freeze = false;     //makes it impossible to freeze time again
    }

    /**
     * if player is touching wallBreaker, collect it, then delete the wallBreaker object
     * increases score by 10
     * creates icon in inventory to show its been picked up
     * changes variable so that code knows the Player has the item
     */
    private void collectWallBreaker()
    {
        score += 10;
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
     * increases score by 10
     * creates icon in inventory to show its been picked up
     * changes variable so that code knows the Player has the item
     */
    private void collectZapper()
    {
        score += 10;
        hasZapper = true;
        Actor Zapper;
        Zapper = getOneIntersectingObject(Zapper.class);
        World world;
        world = getWorld();
        world.removeObject(Zapper);
        
        Ghost_buster_icon busters = new Ghost_buster_icon();
        world.addObject(busters,350,900);
        
        Greenfoot.playSound("ghost_busters.mp3");   //plays cool sound effect
    }
    
    /**
     * if player is touching magnet, collect it, then delete the magnet object
     * increases score by 10
     * creates icon in inventory to show its been picked up
     * changes variable so that code knows the Player has the item
     * displays text telling the player if the magnet is on or not
     */
    private void collectMagnet()
    {
        score += 10;
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
     * sets variable to false so can't teleport again
     * deletes icon from inventory
     * plays cool sound effect
     * moves the Player
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
     * increases score by 10
     * creates icon in inventory to show its been picked up
     * changes variable so that code knows the Player has the item
     */
    private void collectTeleporter()
    {
        score += 10;
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
     * increases score by 10
     * creates icon in inventory to show its been picked up
     * changes variable so that code knows the Player has the item
     */
    private void collectTimePotion()
    {
        score += 10;
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
     * increases score by 10
     * creates icon in inventory to show its been picked up
     * changes variable so that code knows the Player has the item
     */
    private void collectSpeedPotion()
    {
        hasSpeedPotion = true;
        Actor SpeedPotion;
        SpeedPotion = getOneIntersectingObject(SpeedPotion.class);
        score += 10;
        World world;
        world = getWorld();
        world.removeObject(SpeedPotion);
        
        SpeedPotion_option_1 speed = new SpeedPotion_option_1();
        world.addObject(speed,150,900);
    }

    /**
     * when 4 is pressed and they have the ghost zapper, it fires a beam to destroy the ghosts
     * they must first press one of teh arrow keys to choose a direction to fire or it won't work
     * when it works, it sets variable to false so can't be fired again
     * plays cool sound effect
     * spawns Beam actor that moves in a direction according to the Beam class rules
     * removes inventory icon
     * removes Armed actor (so looks more smooth)
     */
    private void zap()
    {
        int direction = 9001;
        if(Greenfoot.isKeyDown("up") == true)
        {
            direction = -90;
        }
        else if(Greenfoot.isKeyDown("down") == true)
        {
            direction = 90;
        }
        else if(Greenfoot.isKeyDown("left") == true)
        {
            direction = 180;
        }
        else if(Greenfoot.isKeyDown("right") == true)
        {
            direction = 0;
        }
        if(direction != 9001)
        {
            hasZapper = false;
            getWorld().removeObjects(getWorld().getObjects(Ghost_buster_icon.class));
            Greenfoot.playSound("zap.mp3");
            
            getWorld().addObject(new Beam(direction), getX(), getY());
            getWorld().removeObjects(getWorld().getObjects(Armed.class));
        }
    }
    
    /**
     * what happens when speedPotion is used
     * removes inventory icon
     * starts speed potion timer
     * the speed remains increased while the timer isn't zero
     * runs the resetSpeed method when timer runs out
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
    
    //sets all speed related variables to false and resets speed back to 2
    private void resetSpeed()
    {
        useSpeedPotion = false;
        activateSpeedPotion = false;
        speed = 2;
    }
    
    private void toggleMagnet()
    {
        if(magState == false)
        {
            //only activates if score is over 0 so they can't cheat the system
            if(score != 0)
            {
                score -= 1;     //instantly decreases score by 1 so they can't spam the magnet and use it for free
                Treasure.timer = 0; //sets the timer to zero to stop the time being the same every time the timer is pressed leading to 2 points being lost a second
                magState = true;   //tells program the magnet is on
                getWorld().showText("Mag on", 1005, 920);   //changes text to show this
            }
            else
            {
                //if score is 0 then doesn't work and shows magnet is off
                magState = false;
                getWorld().showText("Mag off", 1005, 920);
            }
        }
        else if(magState == true)
        {
            //resets magnet state when player is no longer holding m
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
            Actor Breakable = getOneIntersectingObject(Breakable.class);
            World world;
            world = getWorld();
            world.removeObject(Breakable);
        }
        else
        {
            setLocation(getX()-dx, getY()-dy);
        }
    }

    /**
     * player won - removes all actors and words except the player then displays information 
     * and gives player choice to play again or quit
     * resets variables
     * plays sound effect
     * calculates score dependent on time and difficulty
     * incerases speed to easily press the buttons
     * if the player got the treasure it displays the trophy as a reward for all their hard work
     */
    private void endGame()
    {
        ((MyWorld)getWorld()).music.stop();
        Greenfoot.playSound("victory.mp3");
        MyWorld.startTimer = false;
        hasMagnet = false;
        
        score += 400;
        
        if (MyWorld.secondsTimer < 30)          //these are meant to stack
        {
            score += 50;
        }
        if (MyWorld.secondsTimer < 60)
        {
            score += 25;
        }
        if (MyWorld.secondsTimer < 120)
        {
            score += 10;
        }
        
        speed = 6;
        
        World world = getWorld();
        java.util.List<Actor> actors = world.getObjects(null);
        actors.removeAll(world.getObjects(Player.class));
        world.removeObjects(actors);
        String scoreString = " " + (score * (MyWorld.difficulty_multiplyer));
        String timeString = " " + MyWorld.secondsTimer + " Seconds.";
        world.showText("YOU WIN!!!", 575, 350);
        world.showText("Score:" + scoreString, 575, 400);
        world.showText("Time:" + timeString, 575, 450);
        
        world.showText("difficulty multiplyer: " + MyWorld.difficulty_multiplyer, 575, 900);
        
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
     * player died - removes all actors and words except the player then displays information 
     * and gives player choice to play again or quit
     * plays cool death sound effect
     * resets variables
     * calculates score dependent on time and difficulty
     * incerases speed to easily press the buttons
     * even if the player got the treasure they don't get the trophy because they died and didn't reach the end for some reason
     * (they must have gone back for their hat enen though they were next to the exit)
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
        String scoreString = " " + (score * (MyWorld.difficulty_multiplyer));
        String timeString = " " + MyWorld.secondsTimer + " Seconds.";
        world.showText("YOU DIED", 575, 350);
        world.showText("Score:" + scoreString, 575, 400);
        world.showText("Time:" + timeString, 575, 450);
        world.showText(null, 925, 875);
        world.showText(null, 825, 875);
        
        speed = 6;
        
        world.showText("difficulty multiplyer: " + MyWorld.difficulty_multiplyer, 575, 900);
        
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
