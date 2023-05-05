import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * page of story and information displayed on game start
 */
public class Intro extends Actor
{
    public Intro()   //constructor to resize intro text to be a better fit for the maze
    {
        setImage("Intro.png");     //sets the image of this actor
        GreenfootImage intro = getImage();
        intro.scale(1150, 700);     //sets image size of this actor
    }
}
