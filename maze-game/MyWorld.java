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
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1);
        addPlayer();
        prepare();
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
    private void prepare()
    {

        Wall wall = new Wall();
        addObject(wall,194,19);
        Wall wall2 = new Wall();
        addObject(wall2,198,64);
        Wall wall3 = new Wall();
        addObject(wall3,200,119);
        Wall wall4 = new Wall();
        addObject(wall4,196,179);
        Wall wall5 = new Wall();
        addObject(wall5,199,237);
        Wall wall6 = new Wall();
        addObject(wall6,23,232);
        Wall wall7 = new Wall();
        addObject(wall7,80,228);
        Wall wall8 = new Wall();
        addObject(wall8,204,270);
        Wall wall9 = new Wall();
        addObject(wall9,207,322);
        Wall wall10 = new Wall();
        addObject(wall10,216,403);
        Wall wall11 = new Wall();
        addObject(wall11,221,463);
        Wall wall12 = new Wall();
        addObject(wall12,218,351);
        Wall wall13 = new Wall();
        addObject(wall13,227,511);
        Wall wall14 = new Wall();
        addObject(wall14,227,553);
        Wall wall15 = new Wall();
        addObject(wall15,226,595);
        Wall wall16 = new Wall();
        addObject(wall16,183,355);
        wall16.setLocation(157,355);
        Wall wall17 = new Wall();
        addObject(wall17,157,355);
        Wall wall18 = new Wall();
        addObject(wall18,119,355);
        Wall wall19 = new Wall();
        addObject(wall19,83,353);
        Wall wall20 = new Wall();
        addObject(wall20,23,468);
        wall20.setLocation(53,467);
        Wall wall21 = new Wall();
        addObject(wall21,53,467);
        Wall wall22 = new Wall();
        addObject(wall22,102,468);
        wall22.setLocation(110,467);
        Wall wall23 = new Wall();
        addObject(wall23,110,467);
        wall14.setLocation(201,578);
        Wall wall24 = new Wall();
        addObject(wall24,201,578);
        Wall wall25 = new Wall();
        addObject(wall25,163,575);
        wall25.setLocation(142,576);
        Wall wall26 = new Wall();
        addObject(wall26,142,576);
        wall26.setLocation(118,577);
        Wall wall27 = new Wall();
        addObject(wall27,118,577);
        wall27.setLocation(104,578);
        Wall wall28 = new Wall();
        addObject(wall28,104,578);
        Wall wall29 = new Wall();
        addObject(wall29,31,709);
        wall29.setLocation(46,707);
        Wall wall30 = new Wall();
        addObject(wall30,46,707);
        wall29.setLocation(63,707);
        Wall wall31 = new Wall();
        addObject(wall31,63,707);
        wall31.setLocation(94,705);
        Wall wall32 = new Wall();
        addObject(wall32,94,705);
        wall32.setLocation(102,704);
        Wall wall33 = new Wall();
        addObject(wall33,102,704);
        Wall wall34 = new Wall();
        addObject(wall34,233,628);
        wall34.setLocation(231,651);
        Wall wall35 = new Wall();
        addObject(wall35,231,651);
        wall34.setLocation(233,659);
        Wall wall36 = new Wall();
        addObject(wall36,233,659);
        wall36.setLocation(235,682);
        Wall wall37 = new Wall();
        addObject(wall37,235,682);
        wall37.setLocation(233,692);
        Wall wall38 = new Wall();
        addObject(wall38,233,692);
        wall37.setLocation(233,700);
        Wall wall39 = new Wall();
        addObject(wall39,233,700);
        wall34.setLocation(259,611);
        Wall wall40 = new Wall();
        addObject(wall40,259,611);
        Wall wall41 = new Wall();
        addObject(wall41,308,608);
        Wall wall42 = new Wall();
        addObject(wall42,386,605);
        Wall wall43 = new Wall();
        addObject(wall43,419,608);
        Wall wall44 = new Wall();
        addObject(wall44,430,608);
        wall43.setLocation(449,610);
        Wall wall45 = new Wall();
        addObject(wall45,449,610);
        Wall wall46 = new Wall();
        addObject(wall46,480,610);
        Wall wall47 = new Wall();
        addObject(wall47,519,608);
        Wall wall48 = new Wall();
        addObject(wall48,562,606);
        Wall wall49 = new Wall();
        addObject(wall49,619,609);
        Wall wall50 = new Wall();
        addObject(wall50,645,610);
        Wall wall51 = new Wall();
        addObject(wall51,665,610);
        Wall wall52 = new Wall();
        addObject(wall52,350,615);
        wall52.setLocation(351,628);
        Wall wall53 = new Wall();
        addObject(wall53,351,628);
        wall53.setLocation(349,651);
        Wall wall54 = new Wall();
        addObject(wall54,349,651);
        wall54.setLocation(351,669);
        Wall wall55 = new Wall();
        addObject(wall55,351,669);
        wall55.setLocation(353,691);
        Wall wall56 = new Wall();
        addObject(wall56,353,691);
        wall56.setLocation(352,701);
        Wall wall57 = new Wall();
        addObject(wall57,352,701);
        wall56.setLocation(353,709);
        Wall wall58 = new Wall();
        addObject(wall58,353,709);
        Wall wall59 = new Wall();
        addObject(wall59,488,784);
        wall59.setLocation(487,781);
        Wall wall60 = new Wall();
        addObject(wall60,485,752);
        wall60.setLocation(485,750);
        Wall wall61 = new Wall();
        addObject(wall61,485,750);
        wall60.setLocation(482,726);
        Wall wall62 = new Wall();
        addObject(wall62,482,726);
        wall62.setLocation(480,715);
        Wall wall63 = new Wall();
        addObject(wall63,480,715);
        wall62.setLocation(480,710);
        Wall wall64 = new Wall();
        addObject(wall64,480,710);
        Wall wall65 = new Wall();
        addObject(wall65,648,638);
        wall65.setLocation(652,655);
        Wall wall66 = new Wall();
        addObject(wall66,652,655);
        wall65.setLocation(652,666);
        Wall wall67 = new Wall();
        addObject(wall67,652,666);
        wall66.setLocation(651,677);
        Wall wall68 = new Wall();
        addObject(wall68,651,677);
        Wall wall69 = new Wall();
        addObject(wall69,652,695);
        wall64.setLocation(487,703);
        wall63.setLocation(602,587);
        wall62.setLocation(221,410);
        wall22.setLocation(100,470);
        wall22.setLocation(116,467);
        wall11.setLocation(234,454);
        wall10.setLocation(239,420);
        wall10.setLocation(235,393);
        wall13.setLocation(236,506);
        wall11.setLocation(237,480);
        wall62.setLocation(229,437);
        wall10.setLocation(220,401);
        wall10.setLocation(220,411);
        wall10.setLocation(239,399);
        wall62.setLocation(228,428);
        wall10.setLocation(214,281);
        wall46.setLocation(475,585);
        wall43.setLocation(452,588);
        wall43.setLocation(423,601);
        wall43.setLocation(519,570);
        wall47.setLocation(579,566);
        wall48.setLocation(540,561);
        wall64.setLocation(507,678);
        wall60.setLocation(491,718);
        wall60.setLocation(522,730);
        wall59.setLocation(499,768);
        wall45.setLocation(447,585);
        wall44.setLocation(435,590);
        wall44.setLocation(409,596);
        wall42.setLocation(394,593);
        wall42.setLocation(388,608);
        wall49.setLocation(622,623);
        wall49.setLocation(650,639);
        wall64.setLocation(496,716);
        wall46.setLocation(480,596);
        wall46.setLocation(470,545);
    }
}
