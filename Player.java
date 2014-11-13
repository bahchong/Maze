import java.awt.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Player
{
  private int posX, posY, coin;
  private Image player, winner;
  
  public Player()
  {
    ImageIcon img = new ImageIcon("player.jpg");
    player = img.getImage();
    
    coin = 0;
        
    posX = 1;
    posY = 1;
  }
  
  public Image getPlayer()
  {
    return player;
  }
  
  public Image getWinner()
  {
    return winner;
  }
  
  public int getPosX()
  {
    return posX;
  }
  
  public int getPosY()
  {
    return posY;
  }
  
  public void move(int posXChange, int posYChange)
  {   
    posX += posXChange;
    posY += posYChange;
  }
  
  public void checkCollisions()
  {
    ArrayList<Coin> coins = MazeFrame.getCoinList();
    
    for (int i = 0; i < coins.size(); i++)
    {
      if (MazeFrame.getPlayer().getBounds().intersects(coins.get(i).getBounds()))
      {
        MazeFrame.removeCoin(coins.get(i));
        i--;
        MazeFrame.setCoins(coins.size());
        coin++;
      }
    }
  }
  
  public Rectangle getBounds()
  {
    return new Rectangle(posX*32, posY*32, getPlayer().getWidth(null), getPlayer().getHeight(null));
  }
  
  public int getCoinCount()
  {
    return coin;
  }
}
