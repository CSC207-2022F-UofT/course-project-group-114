package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controller.HeatAdjustmentTaskController;

public class HeatAdjustmentTaskView extends JFrame implements ActionListener{
    JLayeredPane layers;
    ImageIcon backgroundImage;
    JLabel background;

    ImageIcon upIcon;
    ImageIcon downIcon;
    JLabel upButton;
    JLabel downButton;
    private static int neededTemp; // ignore this warning, temps will be needed in another method later
    private static int currentTemp;

    public HeatAdjustmentTaskView() {
        // Set the needed and current temperatures of the controller, and update the view's temps as well
        int[] temps = HeatAdjustmentTaskController.initTemps();
        neededTemp = temps[0];
        currentTemp = temps[1];

        layers = new JLayeredPane();

        // Get the image icons and create their corresponding JLabels
        if (currentTemp < neededTemp) {
            backgroundImage = new ImageIcon("src\\main\\java\\resources\\entities.HeatAdjustmentTask\\too cold.jpg");
        } else {
            backgroundImage = new ImageIcon("src\\main\\java\\resources\\entities.HeatAdjustmentTask\\too hot.png");
        }

        background = new JLabel();
        background.setIcon(backgroundImage);
        upIcon = new ImageIcon("src\\main\\java\\resources\\entities.HeatAdjustmentTask\\up.png");
        downIcon = new ImageIcon("src\\main\\java\\resources\\entities.HeatAdjustmentTask\\down.png");
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
