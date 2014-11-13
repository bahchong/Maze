import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

public class MazeFrame extends JPanel implements ActionListener
{
  private Timer timer;
  private static int coin;
  private static Map map;
  private static Player p;
  private static ArrayList<Coin> coins;
  
  public MazeFrame()
  {
    timer = new Timer(10, this);
    timer.start();
    coin = 25;
    map = new Map();
    p = new Player();
    coins = new ArrayList<Coin>();
    addKeyListener(new Control());
    setFocusable(true);
    
    for (int i = 0; i < coin; i++)
    {
      coins.add(new Coin());
    }
  }
  
  public static Player getPlayer()
  {
    return p;
  }
  
  public static Map getMap()
  {
    return map;
  }
  
  public void actionPerformed(ActionEvent event)
  {
    repaint();
  }
  
  public void paint(Graphics g)
  {
    super.paint(g);
    for (int y = 0; y < 20; y++)
    {
      for (int x = 0; x < 40; x++)
      {
        if (map.getMap(x,y).equals("w"))
          g.drawImage(map.getWall(), x*32, y*32, null);
        if (map.getMap(x,y).equals("f"))
          g.drawImage(map.getFinish(), x*32, y*32, null);
      }
      g.drawImage(p.getPlayer(), p.getPosX()*32, p.getPosY()*32, null);
      for (int i = 0; i < coin; i++)
      {
        Coin c = coins.get(i);
        g.drawImage(c.getCoinImg(), c.getX(), c.getY(), null);
      }
    }
    p.checkCollisions();
    g.drawString(getCoinCount(), 1280, 150);
    
    /*if (map.getMap(p.getPosX(), p.getPosY()).equals("f") && p.getCoinCount() == 25)
      g.drawImage(finishGame(), 250, 250, null);*/
  }
  
  public void addCoin(Coin c)
  {
    coins.add(c);
  }
  
  public static ArrayList<Coin> getCoinList()
  {
    return coins;
  }
  
  public static void removeCoin(Coin c)
  {
    coins.remove(c);
  }  
  
  public static void setCoins(int numCoin)
  {
    coin = numCoin;
  }
  
  /*public Image finishGame()
  {
    return map.getWinner();
  }*/

  public String getCoinCount()
  {
    return "Coins: " + p.getCoinCount();
  }
}
