package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HeatAdjustmentTaskView extends JFrame implements ActionListener{
    JLayeredPane layers;
    ImageIcon backgroundImage;
    JLabel background;
    JLabel currTemperatureText;
    JLabel neededTemperatureText;

    ImageIcon upIcon;
    ImageIcon downIcon;
    JLabel upButton;
    JLabel downButton;

    public HeatAdjustmentTaskView() {
        layers = new JLayeredPane();

        // Get the image icons and create their corresponding JLabels
        backgroundImage = new ImageIcon("src\\main\\java\\resources\\HeatAdjustmentTask\\too cold.jpg");
        background = new JLabel();
        background.setIcon(backgroundImage);
        upIcon = new ImageIcon("src\\main\\java\\resources\\HeatAdjustmentTask\\up.png");
        downIcon = new ImageIcon("src\\main\\java\\resources\\HeatAdjustmentTask\\down.png");
        upButton = new JLabel();
        downButton = new JLabel();
        upButton.setIcon(upIcon);
        downButton.setIcon(downIcon);

        // Resize and position the buttons and background
        upButton.setBounds(500, 300, upIcon.getIconWidth(), upIcon.getIconHeight());
        downButton.setBounds(500, 600, downIcon.getIconWidth(), downIcon.getIconHeight());
        background.setSize(new Dimension(1920,1080));

        // Add the background and buttons to the layered pane
        layers.add(background, Integer.valueOf(0));
        layers.add(downButton, Integer.valueOf(1));
        layers.add(upButton, Integer.valueOf(2));

        layers.setPreferredSize(new Dimension(1920, 1080));

        add(layers);

        // Display the layered pane
        setSize(1920,1080);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        layers.setVisible(true);
    }

    public static void main(String[] args) {
        new HeatAdjustmentTaskView();
    }

    public void actionPerformed(ActionEvent e) {
        // code here
    }
}
