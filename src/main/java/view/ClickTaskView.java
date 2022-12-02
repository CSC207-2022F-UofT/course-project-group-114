package view;

import java.awt.*;
import controller.ClickTaskController;
import presenter.ClickTaskPresenter;

import javax.swing.*;

/**
 * The ClickTaskView program creates a JLayeredPane that displays all components
 * needed for the Click Task.
 *
 * @author Siyuan Deng
 * @inheritDoc JLayeredPane
 */
public class ClickTaskView extends JLayeredPane{
    public ClickTaskView(){
        ClickTaskPresenter clickTaskPresenter = new ClickTaskPresenter();
        ClickTaskController.setNeededClicks();
        ClickTaskController.reset();

        // Click Task plane
        setPreferredSize(new Dimension(1280,720));

        // Header settings
        JTextField header = new JTextField("TODO: CLICK TO EAT AND DON'T WASTE FOOD!! \n " +
                "Current Clicks: 0 \n Needed Clicks: " + ClickTaskController.getNeededClicks());
        header.setHorizontalAlignment(JTextField.CENTER);
        header.setEditable(false);
        header.setFont(new java.awt.Font("Serif", Font.ITALIC | Font.BOLD, 20));
        header.setBounds(0,0,1280,80);
        header.setOpaque(false);
        header.setBorder(null);
        header.setMargin(new Insets(0,0,0,0));

        // Set background
        ImageIcon bgImg = new ImageIcon("src/main/java/resources/ClickTask/background.jpg");
        JLabel background = new JLabel(bgImg);
        background.setPreferredSize(new Dimension(1280,720));
        background.setBounds(0,0,1280,720);

        // Read images from folder ClickTask
        ImageIcon full = new ImageIcon("src/main/java/resources/ClickTask/full.png");
        ImageIcon first = new ImageIcon("src/main/java/resources/ClickTask/first.png");
        ImageIcon second = new ImageIcon("src/main/java/resources/ClickTask/second.png");
        ImageIcon third = new ImageIcon("src/main/java/resources/ClickTask/third.png");
        ImageIcon last = new ImageIcon("src/main/java/resources/ClickTask/last.png");

        // Add the fries
        JButton button = new JButton(full);
        button.setContentAreaFilled(false);
        button.setBounds(0,0,full.getIconWidth(), full.getIconHeight());
        button.setPreferredSize(new Dimension(full.getIconWidth(),full.getIconHeight()));
        button.addActionListener(e -> {
            int currentClicks = ClickTaskController.getCurrentClicks() + 1;
            int neededClicks = ClickTaskController.getNeededClicks();

            // Check if time ran out / task was deactivated
            if (!ClickTaskController.getActivatedStatus()) {
                GameMasterView.backToMain(GameMasterView.clickTaskView);
            }

            ClickTaskController.setCurrentClicks(currentClicks);
            header.setText("TODO: CLICK TO EAT AND DON'T WASTE FOOD!! \nCurrent Clicks: " +
                    currentClicks + "\n Needed Clicks: "+ ClickTaskController.getNeededClicks());

            // Change icons as users make more clicks
            if (currentClicks == neededClicks - 1) {
                button.setIcon(last);
            } else if (currentClicks == neededClicks - 2){
                button.setIcon(third);
            } else if (ClickTaskController.getPortion()) {
                button.setIcon(second);
            } else {
                button.setIcon(first);
            }

            boolean success = (neededClicks == currentClicks);
            clickTaskPresenter.endGame(success);
        });

        // Add layers
        add(background, Integer.valueOf(0));
        add(button, Integer.valueOf(1));
        add(header, Integer.valueOf(2));

        // turn the panel visible
        setVisible(true);
    }

    /**
     * This method opens a ClickTaskView, which is the plane of the game.
     */
    public static void main(String[] args) {
        new ClickTaskView();
    }
}