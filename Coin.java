import java.util.*;
import java.awt.*;
import javax.swing.ImageIcon;

public class Coin
{
  private Image coin;
  private Map map;
  private int x, y;
  private Random rand;
  
  public Coin()
  {
    ImageIcon img = new ImageIcon("coin.gif");
    coin = img.getImage();
    rand = new Random();
    map = new Map();
    int remainder;
    
    x = rand.nextInt(1280);
    y = rand.nextInt(640);
          
      if (x % 32 != 0)
      {
        remainder = x%32;
        x -= remainder;
      }
      
      if (y%32 != 0)
      {
        remainder = y%32;
        y -= remainder;
      }
    
    
    while (map.getMap(x/32, y/32).equals("w"))
    {
      x = rand.nextInt(1280);
      y = rand.nextInt(640);
      
      if (x % 32 != 0)
      {
        remainder = x%32;
        x -= remainder;
      }
      
      if (y%32 != 0)
      {
        remainder = y%32;
        y -= remainder;
      }
    }
  }
  
  public Image getCoinImg()
  {
    return coin;
  }
  
  public int getX()
  {
    return x;
  }
  
  public int getY()
  {
    return y;
  }
  
  public Rectangle getBounds()
  {
    return new Rectangle(x,y, getCoinImg().getWidth(null), getCoinImg().getHeight(null));
  }
  
  public void draw(Graphics2D g2d)
  {
    g2d.draw(getBounds());
  }
  
  public void getCollision()
  {
    ArrayList<Coin> coins = MazeFrame.getCoinList();
  }
}
