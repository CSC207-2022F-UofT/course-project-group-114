package view;
import java.awt.*;
import java.awt.event.*;
import javax.sound.midi.Soundbank;
import javax.swing.*;
import controller.WireTaskController;
import presenter.WireTaskPresenter;
import usecases.WireTask;

/**
 * A class representing WireTaskView, which has the role of creating the UI for WireTask.
 *
 * @author Roy
 */

public class WireTaskView extends JLayeredPane{

    ImageIcon backgroundImage;
    JLabel background;
    ImageIcon r1;
    ImageIcon g1;
    ImageIcon b1;
    ImageIcon r2;
    ImageIcon g2;
    ImageIcon b2;
    JLabel r1button;
    JLabel g1button;
    JLabel b1button;
    JLabel r2button;
    JLabel g2button;
    JLabel b2button;
    Point PreviousClick = new Point(0, 0);

    /**
     * Constructor for WireTaskView.
     */
    public WireTaskView() {

        JTextField instructions = new JTextField("CONNECT THE WIRES IN THE FOLLOWING ORDER: BLUE, GREEN, RED (CLICK THE SAME COLOUR)");
        instructions.setHorizontalAlignment(JTextField.CENTER);
        instructions.setEditable(false);
        instructions.setFont(new java.awt.Font("Serif", Font.ITALIC | Font.BOLD, 20));
        instructions.setBounds(0,0,1280,80);
        instructions.setOpaque(false);
        instructions.setBorder(null);
        instructions.setMargin(new Insets(0,0,0,0));

        // Set the Background
        backgroundImage = new ImageIcon("src/main/java/resources/WireTask/wire background.jpg");
        Image image = backgroundImage.getImage().getScaledInstance(1280, 720, java.awt.Image.SCALE_SMOOTH);
        backgroundImage = new ImageIcon(image);
        background = new JLabel(backgroundImage);
        background.setBounds(0, 0, 1280, 720);

        // Set wiring image and button for each colour (red, green, blue)
        // RED INPUT AND OUTPUT
        r1 = new ImageIcon("src/main/java/resources/WireTask/red input.png");
        Image r1image = r1.getImage().getScaledInstance(640, 580, Image.SCALE_SMOOTH);
        r1 = new ImageIcon(r1image);

        r1button = new JLabel();
        r1button.setIcon(r1);

        r2 = new ImageIcon("src/main/java/resources/WireTask/red output.png");
        Image r2image = r2.getImage().getScaledInstance(640, 580, Image.SCALE_SMOOTH);
        r2 = new ImageIcon(r2image);

        r2button = new JLabel();
        r2button.setIcon(r2);

        // GREEN INPUT AND OUTPUT
        g1 = new ImageIcon("src/main/java/resources/WireTask/green input.png");
        Image g1image = g1.getImage().getScaledInstance(640, 580, Image.SCALE_SMOOTH);
        g1 = new ImageIcon(g1image);

        g1button = new JLabel();
        g1button.setIcon(g1);

        g2 = new ImageIcon("src/main/java/resources/WireTask/green output.png");
        Image g2image = g2.getImage().getScaledInstance(640, 580, Image.SCALE_SMOOTH);
        g2 = new ImageIcon(g2image);

        g2button = new JLabel();
        g2button.setIcon(g2);


        // BLUE INPUT AND OUTPUT
        b1 = new ImageIcon("src/main/java/resources/WireTask/blue input.png");
        Image b1image = b1.getImage().getScaledInstance(640, 580, Image.SCALE_SMOOTH);
        b1 = new ImageIcon(b1image);

        b1button = new JLabel();
        b1button.setIcon(b1);

        b2 = new ImageIcon("src/main/java/resources/WireTask/blue output.png");
        Image b2image = b2.getImage().getScaledInstance(640, 580, Image.SCALE_SMOOTH);
        b2 = new ImageIcon(b2image);

        b2button = new JLabel();
        b2button.setIcon(b2);

        // ADJUSTMENTS TO BACKGROUND + BUTTONS
        r1button.setBounds(200, 75, r1.getIconWidth(), r1.getIconHeight());
        r2button.setBounds(300, 75, r2.getIconWidth(), r2.getIconHeight());
        g1button.setBounds(200, 85, g1.getIconWidth(), g1.getIconHeight());
        g2button.setBounds(300, 85, g2.getIconWidth(), g2.getIconHeight());
        b1button.setBounds(200, 95, b1.getIconWidth(), b1.getIconHeight());
        b2button.setBounds(300, 95, b2.getIconWidth(), b2.getIconHeight());
        background.setSize(new Dimension(1280, 720));

        // Add to JLayeredPane
        add(background, Integer.valueOf(0));
        add(r1button, Integer.valueOf(1) );
        add(r2button, Integer.valueOf(2) );
        add(g1button, Integer.valueOf(3) );
        add(g2button, Integer.valueOf(4) );
        add(b1button, Integer.valueOf(5) );
        add(b2button, Integer.valueOf(6) );
        add(instructions, Integer.valueOf(7));

        setPreferredSize(new Dimension(1280, 720));
        setVisible(true);


        /*
        MOUSE EVENTS
         */

        //RED BUTTONS
        r1button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
            @Override
            public void mousePressed(MouseEvent e) {
                if (PreviousClick.x > 512 & PreviousClick.x < 580 & PreviousClick.y > 430 &
                        PreviousClick.y < 475){
                    r1button.setVisible(false);
                    r2button.setVisible(false);
                }

                PreviousClick.setLocation(e.getX(), e.getY());
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        r2button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (PreviousClick.x > 0 & PreviousClick.x < 99 & PreviousClick.y < 155 & PreviousClick.y > 115) {
                    r1button.setVisible(false);
                    r2button.setVisible(false);
                }
                PreviousClick.setLocation(e.getX(), e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        // GREEN BUTTONS
        g1button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
                if (PreviousClick.x > 512 & PreviousClick.x < 580 & PreviousClick.y < 155 & PreviousClick.y > 115){
                    g1button.setVisible(false);
                    g2button.setVisible(false);
                }
                PreviousClick.setLocation(e.getX(), e.getY());
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        g2button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
                if (PreviousClick.x > 0 & PreviousClick.x < 99 & PreviousClick.y > 435 &
                        PreviousClick.y < 475){
                    g1button.setVisible(false);
                    g2button.setVisible(false);
                }
                PreviousClick.setLocation(e.getX(), e.getY());
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        // BLUE BUTTONS
        b1button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
                if (PreviousClick.x > 512 & PreviousClick.x < 580 & PreviousClick.y < 262 &
                        PreviousClick.y > 220){
                    b1button.setVisible(false);
                    b2button.setVisible(false);
                }
                PreviousClick.setLocation(e.getX(), e.getY());
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        b2button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
                if (PreviousClick.x > 0 & PreviousClick.x < 99 & PreviousClick.y > 325 &
                        PreviousClick.y < 368){
                    b1button.setVisible(false);
                    b2button.setVisible(false);
                }
                PreviousClick.setLocation(e.getX(), e.getY());
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }
    public void taskFinished(){}




    public static void main(String[] args) {
        new WireTaskView();
    }
}
