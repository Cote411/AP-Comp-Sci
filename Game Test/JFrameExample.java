import java.awt.Dimension;
import java.awt.FlowLayout;  
import javax.swing.JButton;  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JPanel;  
import java.awt.KeyEvent; 

public class JFrameExample {  
    public static void main(String s[]) {  
        JFrame frame = new JFrame("JFrame Example");  
        JPanel panel = new JPanel();  
        panel.setLayout(new FlowLayout());  
        JLabel label = new JLabel("JFrame By Example");  
        JButton button = new JButton("Button");  
        Dimension size = label.getPreferredSize();
        
        panel.add(button);  
        frame.add(panel);  
        frame.setSize(800, 480);  
        frame.setLocationRelativeTo(null);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setVisible(true);  
        boolean flag = true;
        KeyEvent e = new KeyEvent();
        int yCoordinate = 150;
        while(flag){
            int keyCode = e.getKeyCode();
            switch( keyCode ) { 
                case KeyEvent.VK_UP:
                    // handle up 
                    yCoordinate++;
                    break;
                case KeyEvent.VK_DOWN:
                    // handle down 
                    break;
                case KeyEvent.VK_LEFT:
                    // handle left
                    break;
                case KeyEvent.VK_RIGHT :
                    // handle right
                    break;
             }
        }
        label.setBounds(150, yCoordinate, size.width, size.height);
        panel.setLayout(null);
        panel.add(label);  
    }  
}  