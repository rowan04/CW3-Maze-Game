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
        // Create a new world with 1150x950 cells with a cell size of 1x1 pixels.
        super(1150, 950, 1);
        setPaintOrder(Player.class);
        addPlayer();
        prepareMaze();
        
        // add ghosts (after maze, so they show over the walls)
        addGhost1();
        addGhost2();
        addGhost3();
        addGhost4();
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
     * adds the first ghost
     */
    private void addGhost1()
    {
        // where the ghost will spawn
        int x = 675;
        int y = 175;
        
        // creating the limits for the area the ghost will move in
        Ghost1.lower_x = 575;
        Ghost1.upper_x = 775;
        Ghost1.lower_y = 75;
        Ghost1.upper_y = 275;
        
        // creating the ghost
        Ghost1 Ghost1 = new Ghost1();
        addObject(Ghost1, x, y);
        Ghost1.turn(Greenfoot.getRandomNumber(360));
    }
    
    /**
     * adds the second ghost
     */
    private void addGhost2()
    {
        // where the ghost will spawn
        int x = 225;
        int y = 475;
        
        // creating the limits for the area the ghost will move in
        Ghost2.lower_x = 125;
        Ghost2.upper_x = 325;
        Ghost2.lower_y = 375;
        Ghost2.upper_y = 575;
        
        // creating the ghost
        Ghost2 Ghost2 = new Ghost2();
        addObject(Ghost2, x, y);
        Ghost2.turn(Greenfoot.getRandomNumber(360));
    }
    
    /**
     * adds the third ghost
     */
    private void addGhost3()
    {
        // where the ghost will spawn
        int x = 625;
        int y = 575;
        
        // creating the limits for the area the ghost will move in
        Ghost3.lower_x = 525;
        Ghost3.upper_x = 725;
        Ghost3.lower_y = 475;
        Ghost3.upper_y = 675;
        
        // creating the ghost
        Ghost3 Ghost3 = new Ghost3();
        addObject(Ghost3, x, y);
        Ghost3.turn(Greenfoot.getRandomNumber(360));
    }
    
    /**
     * adds the fourth ghost
     */
    private void addGhost4()
    {
        // where the ghost will spawn
        int x = 1025;
        int y = 375;
        
        // creating the limits for the area the ghost will move in
        Ghost4.lower_x = 925;
        Ghost4.upper_x = 1125;
        Ghost4.lower_y = 275;
        Ghost4.upper_y = 475;
        
        // creating the ghost
        Ghost4 Ghost4 = new Ghost4();
        addObject(Ghost4, x, y);
        Ghost4.turn(Greenfoot.getRandomNumber(360));
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
    
    /**
     * create the walls
     */
    private void create_walls()
    {
        //discance from 2 midpoint = 50
        //distance from wall = 25
        //when using walls 2 and 3 must be 1 less on x axis ending with 5 idk why
        
        Wall2 wall = new Wall2();
        addObject(wall,124,100);
        wall.setRotation(90);
        
        Wall3 wall2 = new Wall3();
        addObject(wall2,74,175);
        wall2.setRotation(90);
        
        Wall2 wall3 = new Wall2();
        addObject(wall3,149,225);
        
        Wall3 wall4 = new Wall3();
        addObject(wall4,275,25);
        
        Wall3 wall5 = new Wall3();
        addObject(wall5,275,125);
        
        Wall3 wall6 = new Wall3();
        addObject(wall6,225,325);
        
        Wall3 wall7 = new Wall3();
        addObject(wall7,274,225);
        wall7.setRotation(90);
        
        Wall1 wall8 = new Wall1();
        addObject(wall8,175,375);
        
        Wall2 wall9 = new Wall2();
        addObject(wall9,50,325);
        
        Wall3 wall10 = new Wall3();
        addObject(wall10,74,425);
        wall10.setRotation(90);
        
        Wall2 wall11 = new Wall2();
        addObject(wall11,150,475);
        
        Wall3 wall12 = new Wall3();
        addObject(wall12,125,575);
        
        Wall3 wall13 = new Wall3();
        addObject(wall13,174,675);
        wall13.setRotation(90);
        
        Wall2 wall14 = new Wall2();
        addObject(wall14,100,725);
        
        Wall2 wall15 = new Wall2();
        addObject(wall15,250,725);
        
        Wall1 wall16 = new Wall1();
        addObject(wall16,75,675);
        
        Wall1 wall17 = new Wall1();
        addObject(wall17,175,775);
        
        Wall3 wall18 = new Wall3();
        addObject(wall18,424,125);
        wall18.setRotation(90);
        
        Wall2 wall19 = new Wall2();
        addObject(wall19,400,225);
        
        Wall3 wall20 = new Wall3();
        addObject(wall20,274,575);
        wall20.setRotation(90);
        
        Wall1 wall21 = new Wall1();
        addObject(wall21,325,625);
        
        Wall2 wall22 = new Wall2();
        addObject(wall22,400,725);
        
        Wall3 wall23 = new Wall3();
        addObject(wall23,424,625);
        wall23.setRotation(90);
        
        Wall2 wall24 = new Wall2();
        addObject(wall24,400,525);
        
        Wall2 wall25 = new Wall2();
        addObject(wall25,374,450);
        wall25.setRotation(90);
        
        Wall2 wall26 = new Wall2();
        addObject(wall26,300,425);
        
        Wall3 wall27 = new Wall3();
        addObject(wall27,525,625);
        
        Wall2 wall28 = new Wall2();
        addObject(wall28,524,750);
        wall28.setRotation(90);
        
        Wall3 wall29 = new Wall3();
        addObject(wall29,425,325);
        
        Wall2 wall30 = new Wall2();
        addObject(wall30,524,300);
        wall30.setRotation(90);
        
        Wall2 wall31 = new Wall2();
        addObject(wall31,600,275);
        
        Wall3 wall32 = new Wall3();
        addObject(wall32,624,375);
        wall32.setRotation(90);
        
        Wall2 wall33 = new Wall2();
        addObject(wall33,500,425);
        
        Wall2 wall34 = new Wall2();
        addObject(wall34,550,525);
        
        Wall1 wall35 = new Wall1();
        addObject(wall35,525,475);
        
        Wall3 wall36 = new Wall3();
        addObject(wall36,524,125);
        wall36.setRotation(90);
        
        Wall2 wall37 = new Wall2();
        addObject(wall37,600,175);
        
        Wall1 wall38 = new Wall1();
        addObject(wall38,625,125);
        
        Wall3 wall39 = new Wall3();
        addObject(wall39,675,25);
        
        Wall2 wall40 = new Wall2();
        addObject(wall40,624,750);
        wall40.setRotation(90);
        
        Wall2 wall41 = new Wall2();
        addObject(wall41,700,725);
        
        Wall2 wall42 = new Wall2();
        addObject(wall42,674,650);
        wall42.setRotation(90);
        
        Wall2 wall43 = new Wall2();
        addObject(wall43,750,125);
        
        Wall2 wall44 = new Wall2();
        addObject(wall44,900,125);
        
        Wall1 wall45 = new Wall1();
        addObject(wall45,725,175);
        
        Wall3 wall46 = new Wall3();
        addObject(wall46,824,125);
        wall46.setRotation(90);
        
        Wall3 wall47 = new Wall3();
        addObject(wall47,874,275);
        wall47.setRotation(90);
        
        Wall3 wall48 = new Wall3();
        addObject(wall48,974,375);
        wall48.setRotation(90);
        
        Wall1 wall49 = new Wall1();
        addObject(wall49,825,225);
        
        Wall1 wall50 = new Wall1();
        addObject(wall50,925,325);
        
        Wall3 wall51 = new Wall3();
        addObject(wall51,1075,25);
        
        Wall3 wall52 = new Wall3();
        addObject(wall52,1025,225);
        
        Wall3 wall53 = new Wall3();
        addObject(wall53,1024,125);
        wall53.setRotation(90);
        
        Wall2 wall54 = new Wall2();
        addObject(wall54,950,25);
        
        Wall1 wall55 = new Wall1();
        addObject(wall55,1125,125);
        
        Wall2 wall56 = new Wall2();
        addObject(wall56,1100,325);
        
        Wall2 wall57 = new Wall2();
        addObject(wall57,750,325);
        
        Wall1 wall58 = new Wall1();
        addObject(wall58,725,275);
        
        Wall2 wall59 = new Wall2();
        addObject(wall59,824,750);
        wall59.setRotation(90);
        
        Wall3 wall60 = new Wall3();
        addObject(wall60,1074,475);
        wall60.setRotation(90);
        
        Wall2 wall61 = new Wall2();
        addObject(wall61,1124,550);
        wall61.setRotation(90);
        
        Breakable break1 = new Breakable();
        addObject(break1,1125,675);
        
        Breakable break2 = new Breakable();
        addObject(break2,1075,675);
        
        Breakable break3 = new Breakable();
        addObject(break3,1025,725);
        
        Breakable break4 = new Breakable();
        addObject(break4,1025,775);
        
        Wall2 wall62 = new Wall2();
        addObject(wall62,1024,650);
        wall62.setRotation(90);
        
        Wall3 wall63 = new Wall3();
        addObject(wall63,924,675);
        wall63.setRotation(90);
        
        Wall1 wall64 = new Wall1();
        addObject(wall64,975,675);
        
        Wall3 wall65 = new Wall3();
        addObject(wall65,725,525);
        
        Wall3 wall66 = new Wall3();
        addObject(wall66,925,525);
        
        Wall1 wall67 = new Wall1();
        addObject(wall67,825,525);
        
        Wall2 wall68 = new Wall2();
        addObject(wall68,750,425);
        
        Wall2 wall69 = new Wall2();
        addObject(wall69,800,625);
        
        Wall2 wall70 = new Wall2();
        addObject(wall70,874,450);
        wall70.setRotation(90);
        
        Wall1 wall71 = new Wall1();
        addObject(wall71,725,475);
        
        Wall1 wall72 = new Wall1();
        addObject(wall72,775,575);
        
        Wall3 wall73 = new Wall3();
        addObject(wall73,75,825);
        
        Wall3 wall74 = new Wall3();
        addObject(wall74,225,825);
        
        Wall3 wall75 = new Wall3();
        addObject(wall75,375,825);
        
        Wall3 wall76 = new Wall3();
        addObject(wall76,525,825);
        
        Wall3 wall77 = new Wall3();
        addObject(wall77,675,825);
        
        Wall3 wall78 = new Wall3();
        addObject(wall78,825,825);
        
        Wall3 wall79 = new Wall3();
        addObject(wall79,975,825);
        
        Wall2 wall80 = new Wall2();
        addObject(wall80,1100,825);
    }
    
    /**
     * create the start
     */
    private void create_start()
    {
        Start start = new Start();
        addObject(start,50,50);
    }
    
    /**
     * create the end
     */
    private void create_end()
    {
        End end = new End();
        addObject(end,1100,750);
    }
}
