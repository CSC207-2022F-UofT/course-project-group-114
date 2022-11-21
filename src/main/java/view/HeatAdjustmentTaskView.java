package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controller.HeatAdjustmentTaskController;

public class HeatAdjustmentTaskView extends JFrame{
    public static JLayeredPane layers;
    ImageIcon backgroundImage;
    JLabel background;

    ImageIcon upIcon;
    ImageIcon downIcon;
    JLabel upButton;
    JLabel downButton;
    private static int currentTemp;
    private boolean completed;

    public HeatAdjustmentTaskView() {
        // Set the needed and current temperatures of the controller, and update the view's temps as well
        int[] temps = HeatAdjustmentTaskController.initTemps();
        // ignore this warning, temps will be needed in another method later
        int neededTemp = temps[0];
        currentTemp = temps[1];

        layers = new JLayeredPane();

        // Get the image icons and create their corresponding JLabels
        if (currentTemp < neededTemp) {
            backgroundImage = new ImageIcon("src\\main\\java\\resources\\HeatAdjustmentTask\\too cold.jpg");
        } else {
            backgroundImage = new ImageIcon("src\\main\\java\\resources\\HeatAdjustmentTask\\too hot.png");
        }

        Image image = backgroundImage.getImage().getScaledInstance(1280, 720, java.awt.Image.SCALE_SMOOTH);
        backgroundImage = new ImageIcon(image);

        background = new JLabel();
        background.setIcon(backgroundImage);
        upIcon = new ImageIcon("src\\main\\java\\resources\\HeatAdjustmentTask\\up.png");
        Image upImage = upIcon.getImage().getScaledInstance(240, 180, Image.SCALE_SMOOTH);
        upIcon = new ImageIcon(upImage);
        downIcon = new ImageIcon("src\\main\\java\\resources\\HeatAdjustmentTask\\down.png");
        Image downImage = downIcon.getImage().getScaledInstance(240, 180, Image.SCALE_SMOOTH);
        downIcon = new ImageIcon(downImage);
        upButton = new JLabel();
        downButton = new JLabel();
        upButton.setIcon(upIcon);
        downButton.setIcon(downIcon);

        // Resize and position the buttons and background
        upButton.setBounds(300, 200, upIcon.getIconWidth(), upIcon.getIconHeight());
        downButton.setBounds(300, 400, downIcon.getIconWidth(), downIcon.getIconHeight());
        background.setSize(new Dimension(1280, 720));

        // Add the background and buttons to the layered pane
        layers.add(background, Integer.valueOf(0));
        layers.add(downButton, Integer.valueOf(1));
        layers.add(upButton, Integer.valueOf(2));

        layers.setPreferredSize(new Dimension(1280, 720));

        add(layers);

        // Display the layered pane
        setSize(1280,720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        layers.setVisible(true);

        // Add click event for down button
        downButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                completed = HeatAdjustmentTaskController.changeCurrentTemp(-1); // Decrease current temp by 1
                currentTemp--;
            }

            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {
                // do nothing, but must implement
            }
        });

        // Add click event for up button
        upButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                completed = HeatAdjustmentTaskController.changeCurrentTemp(1); // Increase current temp by 1
                currentTemp++;
                if (completed) {
                    GameMasterView.backToMain();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }

    public static void main(String[] args) {
        new HeatAdjustmentTaskView();
    }

}
