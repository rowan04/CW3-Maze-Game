import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     */
    public MyWorld()
    {    
        // Create a new world with 1150x800 cells with a cell size of 1x1 pixels.
        super(1150, 800, 1);
        setPaintOrder(Player.class);
        addPlayer();
        prepareMaze();
    }

    /**
     * adds the player
     */
    private void addPlayer()
    {
        int x = 15;
        int y = 30;
        addObject(new Player(), x, y);
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepareMaze()
    {
        //discance from 2 midpoint = 50
        //distance from wall = 25
        //23 blocks wide
        //16 blocks high
        create_start();
        create_end();
        create_walls();
        
    }
    private void create_walls()
    {
        //discance from 2 midpoint = 50
        //distance from wall = 25
        //when using walls 2 and 3 x must be 1 less then normal for some reason
        
        Wall2 wall = new Wall2();
        addObject(wall,124,100);
        wall.setRotation(90);
        
        Wall3 wall2 = new Wall3();
        addObject(wall2,74,175);
        wall2.setRotation(90);
        
        Wall2 wall3 = new Wall2();
        addObject(wall3,149,225);
        
        Wall3 wall4 = new Wall3();
        addObject(wall4,274,25);
        
        Wall3 wall5 = new Wall3();
        addObject(wall5,274,125);
        
        Wall3 wall6 = new Wall3();
        addObject(wall6,224,325);
    }
    private void create_start()
    {
        Start start = new Start();
        addObject(start,50,50);
    }
    private void create_end()
    {
        End end = new End();
        addObject(end,1100,750);
    }
}
