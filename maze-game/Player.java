import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.*;  //allows checking signs on integers
/**
 * This is the main player that the user will control.
 * 
 */
public class Player extends Actor
{
    public static boolean wallbreaker = false;
    public Player()   //constructor to resize player to be a better fit for the maze
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
        if(Greenfoot.getKey() == "1")
        {
            if(this.wallbreaker == true)
            {
                //activate wallbreaker on wall
                this.wallbreaker = false;
            }
        }
        if (Greenfoot.isKeyDown("up")) {
            dy = -2;
        }
        if (Greenfoot.isKeyDown("left")) {
            dx = -2;
        }
        if (Greenfoot.isKeyDown("down")) {
            dy = 2;
        }
        if (Greenfoot.isKeyDown("right")) {
            dx = 2;
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
        if (isTouching(Breakable.class))
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
    }
    private void endGame()//removes all actors except the player then displays information and gives player coice to play again or not
    {
        Greenfoot.playSound("victory.mp3");
        World world = getWorld();
        java.util.List<Actor> actors = world.getObjects(null);
        actors.removeAll(world.getObjects(Player.class));
        world.removeObjects(actors);
        String score = " 200 points";
        String time = " 425 seconds";
        world.showText("YOU WIN!!!", 575, 350);
        world.showText("score:" + score, 575, 400);
        world.showText("time:" + time, 575, 450);
        
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
