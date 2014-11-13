import java.awt.event.*;
import java.util.*;

public class Control extends KeyAdapter
{
  
  public void keyPressed(KeyEvent e)
  {
    int keyCode = e.getKeyCode();
    
    if (keyCode == KeyEvent.VK_W)
    {
      if (!(MazeFrame.getMap().getMap(MazeFrame.getPlayer().getPosX(),MazeFrame.getPlayer().getPosY()-1).equals("w")))
        MazeFrame.getPlayer().move(0, -1);
    }
    
    if (keyCode == KeyEvent.VK_S)
    {
      if (!(MazeFrame.getMap().getMap(MazeFrame.getPlayer().getPosX(), MazeFrame.getPlayer().getPosY()+1).equals("w")))
        MazeFrame.getPlayer().move(0, 1);
    }
    
    if (keyCode == KeyEvent.VK_A)
    {
      if (!(MazeFrame.getMap().getMap(MazeFrame.getPlayer().getPosX()-1, MazeFrame.getPlayer().getPosY()).equals("w")))
        MazeFrame.getPlayer().move(-1, 0);
    }
    
    if (keyCode == KeyEvent.VK_D)
    {
      if (!(MazeFrame.getMap().getMap(MazeFrame.getPlayer().getPosX()+1, MazeFrame.getPlayer().getPosY()).equals("w")))
        MazeFrame.getPlayer().move(1, 0);
    }
  }
  
  public void keyReleased(KeyEvent e)
  {
  }
  
    
}
