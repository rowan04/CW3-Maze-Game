import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * Creates the world the greenfoot program runs in
 */
public class MyWorld extends World
{
    public static boolean stop = false;
    private int timer;
    public static int secondsTimer;
    public static boolean startTimer;
    public static boolean trophy = false;
    public GreenfootSound music = new GreenfootSound("music1.mp3");
    /**
     * Constructor for objects of class MyWorld.
     */
    public MyWorld()
    {
        // Create a new world with 1150x950 cells with a cell size of 1x1 pixels.
        super(1150, 950, 1);
        
        GreenfootImage bg = new GreenfootImage("greyBackground.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);

        addObject(new Intro(),575,475);

        // ensure startTimer is set to false
        // as otherwise, stays as true when world resets
        startTimer = false;
    }

    /**
     * What happens when program is run
     */
    public void act()
    {
        if (Greenfoot.getKey() == "enter")
        {
            Player.score = 0;
            stop = false;
            trophy = false;
            removeObjects(getObjects(null));
            setPaintOrder(Player.class, Ghost1.class, Ghost2.class, Ghost3.class, Ghost4.class);
            addPlayer();
            prepareMaze();

            // ensure time freeze, teleport, player having/using speed potion and player having the wallBreaker are set to false, this was an issue after resets
            Player.hasWallBreaker = false;
            Player.freeze = false;
            Player.hasTeleport = false;
            Player.hasZapper = false;
            Player.hasMagnet = false;
            stop = false;
            Player.hasWallBreaker = false;
            Player.hasSpeedPotion = false;
            Player.useSpeedPotion = false;
            Player.activateSpeedPotion = false;
            Player.magState = false;
            Player.speedTimer = 300;
            
            showText(null, 575, 350);
            showText(null, 575, 400);
            showText(null, 575, 450);
            showText(null, 875, 675);
            showText(null, 1075, 475);

            // add ghosts (after maze, so they show over the walls)
            addGhost1();
            addGhost2();
            addGhost3();
            addGhost4();

            // add in items
            addItems();
            

            // start the timer, setting it to 0
            timer = 0;
            startTimer = true;

            // play music
            music.playLoop();
        }
        
        
        // display timer if startTimer is true and stop is false
        if (startTimer == true)
        {
            if (stop == false)
            {
                timer ++;
                showTimer(timer);
                showText("score: " + Player.score, 725, 875);
            }
        }
    }

    /**
     * loops background music
     */
    private void playMusic()                //not in use
    {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3);
        Collections.shuffle(numbers);
        
        List<String> songs = Arrays.asList("music1.mp3", "music2.mp3", "music3.mp3", "music4.mp3");
        
        Greenfoot.playSound(songs.get(numbers.get(0)));
        Greenfoot.playSound(songs.get(numbers.get(1)));
        Greenfoot.playSound(songs.get(numbers.get(2)));
        Greenfoot.playSound(songs.get(numbers.get(3)));
    }

    /**
     * adds the player
     */
    private void addPlayer()
    {
        int x = 20;
        int y = 20;
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
     * adds coordinate decoding for random numbers
     */
    private int[] decodeNumber(int spawn_point)
    {
        int[] result = new int[2];
        if (spawn_point == 1)
        {
            result[0] = 25;
            result[1] = 375;
            return(result);
        }
        if (spawn_point == 2)
        {
            result[0] = 125;
            result[1] = 675;
            return(result);
        }
        if (spawn_point == 3)
        {
            result[0] = 125;
            result[1] = 775;
            return(result);
        }
        if (spawn_point == 4)
        {
            result[0] = 225;
            result[1] = 775;
            return(result);
        }
        if (spawn_point == 5)
        {
            result[0] = 575;
            result[1] = 325;
            return(result);
        }
        if (spawn_point == 6)
        {
            result[0] = 575;
            result[1] = 775;
            return(result);
        }
        if (spawn_point == 7)
        {
            result[0] = 675;
            result[1] = 775;
            return(result);
        }
        if (spawn_point == 8)
        {
            result[0] = 775;
            result[1] = 175;
            return(result);
        }
        if (spawn_point == 9)
        {
            result[0] = 775;
            result[1] = 475;
            return(result);
        }
        if (spawn_point == 10)
        {
            result[0] = 875;
            result[1] = 175;
            return(result);
        }
        if (spawn_point == 11)
        {
            result[0] = 1125;
            result[1] = 75;
            return(result);
        }
        if (spawn_point == 12)
        {
            result[0] = 1125;
            result[1] = 475;
            return(result);
        }
        return(result);
    }

    /**
     * random number generator that excludes numbers, so items can't spawn in the same place
     */
    public int getRandomWithExclusion(Random rnd, int start, int end, Integer[] exclude)
    {
        if (exclude == null)
        {
            int random = 0;
            while (true)
            {
                random = rnd.nextInt(13);
                if(random !=0) break;
            }
            return random;
        }
        else
        {
            int random = start + rnd.nextInt(end - start + 1 - exclude.length);
            for (int ex : exclude) {
                if (random < ex) {
                    break;
                }
                random++;
            }
            return random;
        }
    }

    /**
     * the items will each spawn at one of the selected spawn points, at random
     * they can't spawn at the same spawn point as another item
     */
    private void addItems()
    {
        List<Integer> ex_list = new ArrayList<Integer>();
        Integer[] ex = null;
        // ex must have different numbers
        
        Random rnd = new Random();
        int spawn_breaker = getRandomWithExclusion(rnd, 1, 12, ex);
        ex_list.add(spawn_breaker);
        
        Collections.sort(ex_list);
        ex = ex_list.toArray(new Integer[ex_list.size()]);
        int spawn_time = getRandomWithExclusion(rnd, 1, 12, ex);
        ex = null;
        ex_list.add(spawn_time);

        Collections.sort(ex_list);
        ex = ex_list.toArray(new Integer[ex_list.size()]);
        int spawn_speed = getRandomWithExclusion(rnd, 1, 12, ex);
        ex = null;
        ex_list.add(spawn_speed);

        Collections.sort(ex_list);
        ex = ex_list.toArray(new Integer[ex_list.size()]);
        int spawn_tele = getRandomWithExclusion(rnd, 1, 12, ex);
        ex = null;
        ex_list.add(spawn_tele);
        
        Collections.sort(ex_list);
        ex = ex_list.toArray(new Integer[ex_list.size()]);
        int spawn_gun = getRandomWithExclusion(rnd, 1, 12, ex);
        ex = null;
        ex_list.add(spawn_gun);
        
        Collections.sort(ex_list);
        ex = ex_list.toArray(new Integer[ex_list.size()]);
        int spawn_mag = getRandomWithExclusion(rnd, 1, 12, ex);
        ex = null;
        ex_list.add(spawn_mag);
        
        int[] result1 = decodeNumber(spawn_breaker);
        int[] result2 = decodeNumber(spawn_time);
        int[] result3 = decodeNumber(spawn_speed);
        int[] result4 = decodeNumber(spawn_tele);
        int[] result5 = decodeNumber(spawn_gun);
        int[] result6 = decodeNumber(spawn_mag);
        
        addObject(new WallBreaker(), result1[0], result1[1]);
        addObject(new TimePotion(), result2[0], result2[1]);
        addObject(new SpeedPotion(), result3[0], result3[1]);
        addObject(new Teleport(), result4[0], result4[1]);
        addObject(new Zapper(), result5[0], result5[1]);
        addObject(new Magnet(), result6[0], result6[1]);

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
     * adds the timer
     */
    private void showTimer(int timer)
    {
        // divide timer by 60, to turn it into seconds
        // secondsTimer being set to int is fine - 
        // it only shows whole seconds, not decimals
        secondsTimer = timer/60;
        
        // show how much time has passed
        showText("Time: " + secondsTimer, 925, 875);
    }
    
    /**
     * creates the walls of the maze
     * creates the breakable walls surrounding the exit
     * includes the bottom border seperating the inventory from the maze
     */
    private void create_walls()
    {
        // placing the breakable walls that surround the exit

        Breakable break1 = new Breakable();
        addObject(break1,1125,675);

        Breakable break2 = new Breakable();
        addObject(break2,1075,675);

        Breakable break3 = new Breakable();
        addObject(break3,1025,725);

        Breakable break4 = new Breakable();
        addObject(break4,1025,775);

        // creating the walls that make the maze
        // each wall is 50x50 pixels

        Wall1 wall = new Wall1();
        addObject(wall,125,75);

        Wall1 wall2 = new Wall1();
        addObject(wall2,75,125);

        Wall1 wall3 = new Wall1();
        addObject(wall3,75,175);
        
        Wall1 wall4 = new Wall1();
        addObject(wall4,75,225);
        
        Wall1 wall5 = new Wall1();
        addObject(wall5,125,125);
        
        Wall1 wall6 = new Wall1();
        addObject(wall6,125,225);
        
        Wall1 wall7 = new Wall1();
        addObject(wall7,175,225);
        
        Wall1 wall8 = new Wall1();
        addObject(wall8,225,25);
        
        Wall1 wall9 = new Wall1();
        addObject(wall9,275,25);
        
        Wall1 wall10 = new Wall1();
        addObject(wall10,325,25);
        
        Wall1 wall11 = new Wall1();
        addObject(wall11,225,125);
        
        Wall1 wall12 = new Wall1();
        addObject(wall12,275,125);
        
        Wall1 wall13 = new Wall1();
        addObject(wall13,325,125);
        
        Wall1 wall14 = new Wall1();
        addObject(wall14,275,175);
        
        Wall1 wall15 = new Wall1();
        addObject(wall15,275,225);
        
        Wall1 wall16 = new Wall1();
        addObject(wall16,275,275);
        
        Wall1 wall17 = new Wall1();
        addObject(wall17,275,325);
        
        Wall1 wall18 = new Wall1();
        addObject(wall18,25,325);
        
        Wall1 wall19 = new Wall1();
        addObject(wall19,75,325);
        
        Wall1 wall20 = new Wall1();
        addObject(wall20,175,325);
        
        Wall1 wall21 = new Wall1();
        addObject(wall21,225,325);
        
        Wall1 wall22 = new Wall1();
        addObject(wall22,75,375);
        
        Wall1 wall23 = new Wall1();
        addObject(wall23,75,425);
        
        Wall1 wall24 = new Wall1();
        addObject(wall24,75,475);
        
        Wall1 wall25 = new Wall1();
        addObject(wall25,125,475);
        
        Wall1 wall26 = new Wall1();
        addObject(wall26,175,475);
        
        Wall1 wall27 = new Wall1();
        addObject(wall27,175,375);
        
        Wall1 wall28 = new Wall1();
        addObject(wall28,425,75);
        
        Wall1 wall29 = new Wall1();
        addObject(wall29,425,125);
        
        Wall1 wall30 = new Wall1();
        addObject(wall30,425,175);
        
        Wall1 wall31 = new Wall1();
        addObject(wall31,425,225);
        
        Wall1 wall32 = new Wall1();
        addObject(wall32,375,225);
        
        Wall1 wall33 = new Wall1();
        addObject(wall33,375,325);
        
        Wall1 wall34 = new Wall1();
        addObject(wall34,425,325);
        
        Wall1 wall35 = new Wall1();
        addObject(wall35,475,325);
        
        Wall1 wall36 = new Wall1();
        addObject(wall36,525,75);
        
        Wall1 wall37 = new Wall1();
        addObject(wall37,525,125);
        
        Wall1 wall38 = new Wall1();
        addObject(wall38,525,175);
        
        Wall1 wall39 = new Wall1();
        addObject(wall39,525,275);
        
        Wall1 wall40 = new Wall1();
        addObject(wall40,525,325);
        
        Wall1 wall41 = new Wall1();
        addObject(wall41,575,175);
        
        Wall1 wall42 = new Wall1();
        addObject(wall42,625,125);
        
        Wall1 wall43 = new Wall1();
        addObject(wall43,625,175);
        
        Wall1 wall44 = new Wall1();
        addObject(wall44,575,275);
        
        Wall1 wall45 = new Wall1();
        addObject(wall45,625,275);
        
        Wall1 wall46 = new Wall1();
        addObject(wall46,625,325);
        
        Wall1 wall47 = new Wall1();
        addObject(wall47,625,375);
        
        Wall1 wall48 = new Wall1();
        addObject(wall48,625,425);
        
        Wall1 wall49 = new Wall1();
        addObject(wall49,625,25);
        
        Wall1 wall50 = new Wall1();
        addObject(wall50,675,25);
        
        Wall1 wall51 = new Wall1();
        addObject(wall51,725,25);
        
        Wall1 wall52 = new Wall1();
        addObject(wall52,275,425);
        
        Wall1 wall53 = new Wall1();
        addObject(wall53,325,425);
        
        Wall1 wall54 = new Wall1();
        addObject(wall54,375,425);
        
        Wall1 wall55 = new Wall1();
        addObject(wall55,475,425);
        
        Wall1 wall56 = new Wall1();
        addObject(wall56,525,425);
        
        Wall1 wall57 = new Wall1();
        addObject(wall57,375,475);
        
        Wall1 wall58 = new Wall1();
        addObject(wall58,525,475);
        
        Wall1 wall59 = new Wall1();
        addObject(wall59,725,275);
        
        Wall1 wall60 = new Wall1();
        addObject(wall60,725,325);
        
        Wall1 wall61 = new Wall1();
        addObject(wall61,775,325);
        
        Wall1 wall62 = new Wall1();
        addObject(wall62,725,125);
        
        Wall1 wall63 = new Wall1();
        addObject(wall63,725,175);
        
        Wall1 wall64 = new Wall1();
        addObject(wall64,775,125);
        
        Wall1 wall65 = new Wall1();
        addObject(wall65,825,75);
        
        Wall1 wall66 = new Wall1();
        addObject(wall66,825,125);
        
        Wall1 wall67 = new Wall1();
        addObject(wall67,825,175);
        
        Wall1 wall68 = new Wall1();
        addObject(wall68,825,225);
        
        Wall1 wall69 = new Wall1();
        addObject(wall69,875,125);
        
        Wall1 wall70 = new Wall1();
        addObject(wall70,875,225);
        
        Wall1 wall71 = new Wall1();
        addObject(wall71,875,275);
        
        Wall1 wall72 = new Wall1();
        addObject(wall72,875,325);
        
        // the following walls form the bottom border

        Wall1 wall73 = new Wall1();
        addObject(wall73,25,825);
        
        Wall1 wall74 = new Wall1();
        addObject(wall74,75,825);
        
        Wall1 wall75 = new Wall1();
        addObject(wall75,125,825);
        
        Wall1 wall76 = new Wall1();
        addObject(wall76,175,825);
        
        Wall1 wall77 = new Wall1();
        addObject(wall77,225,825);
        
        Wall1 wall78 = new Wall1();
        addObject(wall78,275,825);
        
        Wall1 wall79 = new Wall1();
        addObject(wall79,325,825);
        
        Wall1 wall80 = new Wall1();
        addObject(wall80,375,825);
        
        Wall1 wall81 = new Wall1();
        addObject(wall81,425,825);
        
        Wall1 wall82 = new Wall1();
        addObject(wall82,475,825);
        
        Wall1 wall83 = new Wall1();
        addObject(wall83,525,825);

        Wall1 wall84 = new Wall1();
        addObject(wall84,575,825);
        
        Wall1 wall85 = new Wall1();
        addObject(wall85,625,825);
        
        Wall1 wall86 = new Wall1();
        addObject(wall86,675,825);
        
        Wall1 wall87 = new Wall1();
        addObject(wall87,725,825);
        
        Wall1 wall88 = new Wall1();
        addObject(wall88,775,825);
        
        Wall1 wall89 = new Wall1();
        addObject(wall89,825,825);
        
        Wall1 wall90 = new Wall1();
        addObject(wall90,875,825);
        
        Wall1 wall91 = new Wall1();
        addObject(wall91,925,825);
        
        Wall1 wall92 = new Wall1();
        addObject(wall92,975,825);
        
        Wall1 wall93 = new Wall1();
        addObject(wall93,1025,825);
        
        Wall1 wall94 = new Wall1();
        addObject(wall94,1075,825);
        
        Wall1 wall95 = new Wall1();
        addObject(wall95,1125,825);
        
        // the following walls no longer form the bottom border again

        Wall1 wall96 = new Wall1();
        addObject(wall96,925,25);
        
        Wall1 wall97 = new Wall1();
        addObject(wall97,925,125);
        
        Wall1 wall98 = new Wall1();
        addObject(wall98,925,325);
        
        Wall1 wall99 = new Wall1();
        addObject(wall99,975,25);
        
        Wall1 wall100 = new Wall1();
        addObject(wall100,1025,25);
        
        Wall1 wall101 = new Wall1();
        addObject(wall101,1075,25);
        
        Wall1 wall102 = new Wall1();
        addObject(wall102,1125,25);
        
        Wall1 wall103 = new Wall1();
        addObject(wall103,1025,75);
        
        Wall1 wall104 = new Wall1();
        addObject(wall104,1025,125);
        
        Wall1 wall105 = new Wall1();
        addObject(wall105,1025,175);
        
        Wall1 wall106 = new Wall1();
        addObject(wall106,975,225);
        
        Wall1 wall107 = new Wall1();
        addObject(wall107,1025,225);
        
        Wall1 wall108 = new Wall1();
        addObject(wall108,1075,225);
        
        Wall1 wall109 = new Wall1();
        addObject(wall109,1125,125);
        
        Wall1 wall110 = new Wall1();
        addObject(wall110,975,325);
        
        Wall1 wall111 = new Wall1();
        addObject(wall111,975,375);
        
        Wall1 wall112 = new Wall1();
        addObject(wall112,975,425);
        
        Wall1 wall113 = new Wall1();
        addObject(wall113,1075,325);
        
        Wall1 wall114 = new Wall1();
        addObject(wall114,1125,325);
        
        Wall1 wall115 = new Wall1();
        addObject(wall115,725,425);
        
        Wall1 wall116 = new Wall1();
        addObject(wall116,775,425);
        
        Wall1 wall117 = new Wall1();
        addObject(wall117,725,475);
        
        Wall1 wall118 = new Wall1();
        addObject(wall118,875,425);
        
        Wall1 wall119 = new Wall1();
        addObject(wall119,875,475);
        
        Wall1 wall120 = new Wall1();
        addObject(wall120,1075,425);
        
        Wall1 wall121 = new Wall1();
        addObject(wall121,1075,475);
        
        Wall1 wall122 = new Wall1();
        addObject(wall122,75,575);
        
        Wall1 wall123 = new Wall1();
        addObject(wall123,125,575);
        
        Wall1 wall124 = new Wall1();
        addObject(wall124,175,575);
        
        Wall1 wall125 = new Wall1();
        addObject(wall125,175,625);
        
        Wall1 wall126 = new Wall1();
        addObject(wall126,175,675);
        
        Wall1 wall127 = new Wall1();
        addObject(wall127,175,725);
        
        Wall1 wall128 = new Wall1();
        addObject(wall128,175,775);
        
        Wall1 wall129 = new Wall1();
        addObject(wall129,75,675);
        
        Wall1 wall130 = new Wall1();
        addObject(wall130,75,725);
        
        Wall1 wall131 = new Wall1();
        addObject(wall131,125,725);
        
        Wall1 wall132 = new Wall1();
        addObject(wall132,225,725);
        
        Wall1 wall133 = new Wall1();
        addObject(wall133,275,725);
        
        Wall1 wall134 = new Wall1();
        addObject(wall134,275,525);
        
        Wall1 wall135 = new Wall1();
        addObject(wall135,275,575);
        
        Wall1 wall136 = new Wall1();
        addObject(wall136,275,625);
        
        Wall1 wall137 = new Wall1();
        addObject(wall137,325,625);
        
        Wall1 wall138 = new Wall1();
        addObject(wall138,375,525);
        
        Wall1 wall139 = new Wall1();
        addObject(wall139,425,525);
        
        Wall1 wall140 = new Wall1();
        addObject(wall140,425,575);
        
        Wall1 wall141 = new Wall1();
        addObject(wall141,425,625);
        
        Wall1 wall142 = new Wall1();
        addObject(wall142,425,675);
        
        Wall1 wall143 = new Wall1();
        addObject(wall143,425,725);
        
        Wall1 wall144 = new Wall1();
        addObject(wall144,375,725);
        
        Wall1 wall145 = new Wall1();
        addObject(wall145,475,625);
        
        Wall1 wall146 = new Wall1();
        addObject(wall146,525,625);
        
        Wall1 wall147 = new Wall1();
        addObject(wall147,575,625);
        
        Wall1 wall148 = new Wall1();
        addObject(wall148,525,525);
        
        Wall1 wall149 = new Wall1();
        addObject(wall149,575,525);
        
        Wall1 wall150 = new Wall1();
        addObject(wall150,525,725);
        
        Wall1 wall151 = new Wall1();
        addObject(wall151,525,775);
        
        Wall1 wall152 = new Wall1();
        addObject(wall152,675,625);
        
        Wall1 wall153 = new Wall1();
        addObject(wall153,675,675);
        
        Wall1 wall154 = new Wall1();
        addObject(wall154,675,725);
        
        Wall1 wall155 = new Wall1();
        addObject(wall155,625,725);
        
        Wall1 wall156 = new Wall1();
        addObject(wall156,625,775);
        
        Wall1 wall157 = new Wall1();
        addObject(wall157,725,725);
        
        Wall1 wall158 = new Wall1();
        addObject(wall158,825,725);
        
        Wall1 wall159 = new Wall1();
        addObject(wall159,825,775);
        
        Wall1 wall160 = new Wall1();
        addObject(wall160,675,525);
        
        Wall1 wall161 = new Wall1();
        addObject(wall161,725,525);
        
        Wall1 wall162 = new Wall1();
        addObject(wall162,775,525);
        
        Wall1 wall163 = new Wall1();
        addObject(wall163,775,575);
        
        Wall1 wall164 = new Wall1();
        addObject(wall164,775,625);
        
        Wall1 wall165 = new Wall1();
        addObject(wall165,825,625);
        
        Wall1 wall166 = new Wall1();
        addObject(wall166,825,525);
        
        Wall1 wall167 = new Wall1();
        addObject(wall167,875,525);
        
        Wall1 wall168 = new Wall1();
        addObject(wall168,925,525);
        
        Wall1 wall169 = new Wall1();
        addObject(wall169,975,525);
        
        Wall1 wall170 = new Wall1();
        addObject(wall170,1075,525);
        
        Wall1 wall171 = new Wall1();
        addObject(wall171,1125,525);
        
        Wall1 wall172 = new Wall1();
        addObject(wall172,1125,575);
        
        Wall1 wall173 = new Wall1();
        addObject(wall173,925,625);
        
        Wall1 wall174 = new Wall1();
        addObject(wall174,925,675);
        
        Wall1 wall175 = new Wall1();
        addObject(wall175,925,725);
        
        Wall1 wall176 = new Wall1();
        addObject(wall176,975,675);
        
        Wall1 wall177 = new Wall1();
        addObject(wall177,1025,625);
        
        Wall1 wall178 = new Wall1();
        addObject(wall178,1025,675);
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
