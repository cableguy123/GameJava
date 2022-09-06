import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
class Player extends JPanel implements KeyListener{
   // 1.Player x,y 좌표 구해서 move메소드 
   // 2.Player Left,Right -> KeyListener (abstract method KeyListener.)
   // 3.Player attack 메소드 
   double x,y,dircetion; 
   double speed;
   Boolean keyUp = false;
   Boolean keyDown = false;
   Boolean keyLeft = false;
   Boolean keyRight = false;

   public Player(int x,int y) {
    this.x = x;
    this.y = y;
    addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);
   }
   public void move() {
    x += speed * Math.cos(Math.toRadians(dircetion));
    y += speed * Math.sin(Math.toRadians(dircetion));

   }
   @Override
   public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    if(key == KeyEvent.VK_LEFT) {
        // 왼쪽으로 움직일시
        // x는 -, y는 그대로 
        x -= speed * Math.cos(Math.toRadians(dircetion));
        
    }else if(key == KeyEvent.VK_RIGHT) {
        x += speed * Math.cos(Math.toRadians(dircetion));

    }if(key == KeyEvent.VK_UP) {
        y += speed * Math.sin(Math.toRadians(dircetion));

    } else if(key == KeyEvent.VK_DOWN) {
        y -= speed * Math.sin(Math.toRadians(dircetion));
    }
 
   }
   @Override
   public void keyReleased(KeyEvent e) {

   }
   @Override
   public void keyTyped(KeyEvent arg0) {

   }
   
   
}
class GamePannel extends JFrame {
    GamePannel() {
        super("ShootGame"); // 창 타이틀
        JPanel jPanel = new JPanel();
        setSize(300,200);
        add(jPanel);

        // setLocation((windowSize.width - frameSize.width) / 2 , (windowSize.height - frameSize.height ) / 2 );
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
public class Game2 extends JFrame {
    Player player;
    Boolean gameRunning = true;
    public static void main(String[] args) {
       
          new Game2();
        
    }
    public Game2() {
        

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
        JFrame frm = new JFrame("슈팅 게임 !"); 
        frm.setSize(350,300); 
        frm.setLocationRelativeTo(null); 
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frm.getContentPane().setLayout(null); 
        JButton btn1 = new JButton("게임 시작"); 
        JButton btn2 = new JButton("종료");
        btn1.setBounds(30,170,122,30); 
        btn2.setBounds(182,170,122,30); 
        frm.getContentPane().add(btn1); 
        frm.getContentPane().add(btn2);
        JLabel lbl = new JLabel(); 
        lbl.setBounds(30,200,274,50); 
        lbl.setText("Welcome shooting game! "); 
        lbl.setHorizontalAlignment(JLabel.CENTER); 
        frm.getContentPane().add(lbl); 
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbl.setText("Game Start");
                frm.dispose(); // frame 닫기 
                new GamePannel();
            }
        });
      
        
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // new GameOverPannel();
                setVisible(false);

            }
        });

        frm.setVisible(true);
            }
        });

    }
    
    
    
}

