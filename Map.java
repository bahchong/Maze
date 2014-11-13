import java.io.*;
import java.util.*;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Map
{
  private Scanner scan;
  private Player p;
  private String[] positions;
  private Image wall, winner, finish;
  
  public Map()
  {
    ImageIcon img = new ImageIcon("Walls.jpg");
    wall = img.getImage();
    
    //img = new ImageIcon("C:/Users/Brandon/APCS/WinnerImage.jpg");
    //winner = img.getImage();
    
    img = new ImageIcon("Finish Line.jpg");
    finish = img.getImage();
    
    p = MazeFrame.getPlayer();
    positions = new String[20];
    openFile();
    readFile();
    closeFile();
  }
  
  public Image getWall()
  {
    return wall;
  }
  
  /*public Image getWinner()
  {
    return winner;
  }*/
  
  public Image getFinish()
  {
    return finish;
  }
  
  public String getMap(int x, int y)
  {
    String pos = positions[y].substring(x,x+1);
    return pos;
  }
  
  public void openFile()
  {
    try 
    {
    scan = new Scanner (new File("Map.txt"));
    }
    catch (Exception e)
    {
      System.out.println ("Error Loading Maze");
    }
  }
  
  public void readFile()
  {
    while (scan.hasNext())
    {
      for (int i = 0; i < 20; i++)
      {
        positions[i] = scan.next();
      }
    }
  }
  
  public void closeFile()
  {
    scan.close();
  }
}
