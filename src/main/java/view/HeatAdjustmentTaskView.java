package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controller.HeatAdjustmentTaskController;
import presenter.HeatAdjustmentTaskPresenter;

/**
 * A class representing the HeatAdjustmentTaskView, which is responsible for the UI of the HeatAdjustmentTask as well
 * as communicating with the task's controller and presenter classes to update the UI and temperature values.
 *
 * @author Elena Scobici
 */
public class HeatAdjustmentTaskView extends JLayeredPane{
    ImageIcon backgroundImage;
    JLabel background;

    ImageIcon upIcon;
    ImageIcon downIcon;
    JLabel upButton;
    JLabel downButton;
    ImageIcon upActiveIcon;
    ImageIcon downActiveIcon;
    JLabel currentTempDisplay;

    /**
     * Constructor for the HeatAdjustmentTaskView, which creates all the needed images and buttons as well as the
     * mouse events.
     */
    public HeatAdjustmentTaskView() {
        currentTempDisplay = new JLabel(Integer.toString(HeatAdjustmentTaskPresenter.getCurrentTemp()));
        currentTempDisplay.setBounds(0, 0, 100, 100);

        // Get the image icons and create their corresponding JLabels
        if (HeatAdjustmentTaskPresenter.getCurrentTemp() < HeatAdjustmentTaskPresenter.getAnswerTemp()) {
            backgroundImage = new ImageIcon("src/main/java/resources/HeatAdjustmentTask/too cold.jpg");
        } else {
            backgroundImage = new ImageIcon("src/main/java/resources/HeatAdjustmentTask/too hot.png");
        }

        Image image = backgroundImage.getImage().getScaledInstance(1280, 720, java.awt.Image.SCALE_SMOOTH);
        backgroundImage = new ImageIcon(image);

        background = new JLabel();
        background.setIcon(backgroundImage);
        upIcon = new ImageIcon("src/main/java/resources/HeatAdjustmentTask/up.png");
        Image upImage = upIcon.getImage().getScaledInstance(240, 180, Image.SCALE_SMOOTH);
        upIcon = new ImageIcon(upImage);
        downIcon = new ImageIcon("src/main/java/resources/HeatAdjustmentTask/down.png");
        Image downImage = downIcon.getImage().getScaledInstance(240, 180, Image.SCALE_SMOOTH);
        downIcon = new ImageIcon(downImage);
        upButton = new JLabel();
        downButton = new JLabel();
        upButton.setIcon(upIcon);
        downButton.setIcon(downIcon);

        upActiveIcon = new ImageIcon("src/main/java/resources/HeatAdjustmentTask/upActive.png");
        Image upActiveImage = upActiveIcon.getImage().getScaledInstance(240, 180, Image.SCALE_SMOOTH);
        upActiveIcon = new ImageIcon(upActiveImage);

        downActiveIcon = new ImageIcon("src/main/java/resources/HeatAdjustmentTask/downActive.png");
        Image downActiveImage = downActiveIcon.getImage().getScaledInstance(240, 180, Image.SCALE_SMOOTH);
        downActiveIcon = new ImageIcon(downActiveImage);


        // Resize and position the buttons and background
        upButton.setBounds(300, 200, upIcon.getIconWidth(), upIcon.getIconHeight());
        downButton.setBounds(300, 400, downIcon.getIconWidth(), downIcon.getIconHeight());
        background.setSize(new Dimension(1280, 720));

        // Add the background and buttons to the layered pane
        add(background, Integer.valueOf(0));
        add(downButton, Integer.valueOf(1));
        add(upButton, Integer.valueOf(2));

        setPreferredSize(new Dimension(1280, 720));

        setVisible(true);

        downButton.addMouseListener(new MouseListener() {
            /**
             * Click event for the down button, which uses the HeatAdjustmentTaskController to update the
             * current temperature, completion and activation statuses as needed, and also goes back to the main
             * view if the task has been completed or deactivated.
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                currentTempDisplay.setText(Integer.toString(HeatAdjustmentTaskPresenter.getCurrentTemp()));
                if (HeatAdjustmentTaskController.changeCurrentTemp(-1)) {
                    HeatAdjustmentTaskController.setCompletionStatus(true);
                    HeatAdjustmentTaskController.setActivationStatus(false);
                    GameMasterView.backToMain(GameMasterView.heatTaskView);
                } else if (!HeatAdjustmentTaskPresenter.getActivatedStatus()) { // automatically back to main,
                    GameMasterView.backToMain(GameMasterView.heatTaskView); // time ran out during task
                }
            }

            /**
             * Press event for the down button, which changes the down button's icon to make it blue.
             * @param e the event to be processed
             */
            @Override
            public void mousePressed(MouseEvent e) {
                downButton.setIcon(downActiveIcon);
            }

            /**
             * Release event for the down button, which changes the down button's icon to make it go back to its
             * original colour.
             * @param e the event to be processed
             */
            @Override
            public void mouseReleased(MouseEvent e) {
                downButton.setIcon(downIcon);
            }
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {
                // do nothing, but must implement
            }
        });

        upButton.addMouseListener(new MouseListener() {
            /**
             * Click event for the down button, which uses the HeatAdjustmentTaskController to update the
             * current temperature, completion and activation statuses as needed, and also goes back to the main
             * view if the task has been completed or deactivated.
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                currentTempDisplay.setText(Integer.toString(HeatAdjustmentTaskPresenter.getCurrentTemp()));
                if (HeatAdjustmentTaskController.changeCurrentTemp(1)) {
                    HeatAdjustmentTaskController.setCompletionStatus(true);
                    HeatAdjustmentTaskController.setActivationStatus(false);
                    GameMasterView.backToMain(GameMasterView.heatTaskView);
                } else if (!HeatAdjustmentTaskPresenter.getActivatedStatus()) { // automatically back to main,
                    GameMasterView.backToMain(GameMasterView.heatTaskView); // time ran out during task
                }
            }

            /**
             * Press event for the up button, which changes the up button's icon to make it red.
             * @param e the event to be processed
             */
            @Override
            public void mousePressed(MouseEvent e) {
                upButton.setIcon(upActiveIcon);
            }

            /**
             * Release event for the up button, which changes the up button's icon to make it go back to its
             * original colour.
             * @param e the event to be processed
             */
            @Override
            public void mouseReleased(MouseEvent e) {
                upButton.setIcon(upIcon);
            }
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }

    /**
     * Main method for testing purposes.
     * @param args Method call arguments
     */
    public static void main(String[] args) {
        new HeatAdjustmentTaskView();
    }

}
