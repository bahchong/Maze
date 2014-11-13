Maze
====
import javax.swing.JFrame;

public class Maze
{
  public Maze()
  {
    JFrame frame = new JFrame();
    frame.setTitle("Maze Game");
    frame.setSize(500,400);
    frame.setLocationRelativeTo(null);
    frame.add(new MazeFrame());
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
