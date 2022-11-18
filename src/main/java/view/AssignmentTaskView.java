package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AssignmentTaskView {
        public AssignmentTaskView(){
                taskCtrller = new ClickTaskController();
                setTitle("Click Task v.1.0.0");
                setSize(1920,1080);
                setLocationRelativeTo(null);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(true);
                // 2. JFrame and JPanel difference?
                // 3. Different layout for different pane?
                setLayout(new BorderLayout());
                setContentPane(new JLabel(new ImageIcon("src\\main\\java\\resources\\background.jpg")));
                setLayout(new FlowLayout());
                background = new JLabel();
                full = new ImageIcon("src\\main\\java\\resources\\full.png");
                // Few things I need to fix about the button:
                // 4. Transparent background
                // 5. Adjust position
                button = new JButton(full);
                button.setPreferredSize(new Dimension(192,108));
                button.addActionListener(this);
                printText = new JLabel("Current clicks: 0");
                printNeed = new JLabel("Needed clicks: " + clickTaskController.getNeededClicks());
                add(background);
                add(button);
                // 6. Adjust text positions (not on button, and separate two labels)
                button.add(printText);
                button.add(printNeed);
                setSize(1920,1080);
        }
        public static void main(String[] args) {
                JFrame frame = new JFrame();
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setBounds(100, 100, 500, 500);
                Container cont = frame.getContentPane();
                cont.setLayout(null);
                JTextField txt = new JTextField();
                txt.setBounds(50, 50,150, 40);
                cont.add(txt);
    }
}
