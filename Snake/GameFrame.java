package Snake;
import javax.swing.JFrame;

public class GameFrame extends JFrame{
    
    GameFrame(){
        this.add(new GamePanel(45,180,0));
        this.setTitle("Awesome Snake Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
}
