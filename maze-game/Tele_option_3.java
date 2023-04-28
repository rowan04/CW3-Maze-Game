import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tele_option_3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tele_option_3 extends Actor
{
    public Tele_option_3()   //constructor to resize teleporter inventory icon to fit in the inventory
    {
        setImage("steel-ball.png");
        GreenfootImage inv_1 = getImage();
        inv_1.scale(100, 100);
    }

    /**
     * Act - do whatever the Tele_option_3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
