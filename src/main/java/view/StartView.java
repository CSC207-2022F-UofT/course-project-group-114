package view;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class StartView extends JFrame{
    private ImageIcon image;
    private JLabel label;

    public void view(){
        setLayout(new FlowLayout());

        image = new ImageIcon(Objects.requireNonNull(getClass().getResource("view/start.jpg")));
        label = new JLabel(image);
        label.setSize(1920,1080);
        add(label);
    }

    public static void main(String[] args){
        StartView gui = new StartView();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        gui.setSize(1920, 1080);
        gui.setTitle("Phone Number Task");
    }
}
