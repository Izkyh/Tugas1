import javax.swing.*;
import java.awt.*;

public class Tugas6 extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Menggambar huruf "R"
        g2d.setColor(Color.BLACK);
        g2d.drawLine(50, 50, 50, 150);
        g2d.drawLine(50, 50, 100, 50);
        g2d.drawLine(100, 50, 100, 100);
        g2d.drawLine(100, 100, 50, 100);
        g2d.drawLine(50, 100, 100, 150);

        // Menggambar huruf "H"
        g2d.drawLine(150, 50, 150, 150);
        g2d.drawLine(150, 100, 200, 100);
        g2d.drawLine(200, 50, 200, 150);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("r h");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.getContentPane().add(new Tugas6());
        frame.setVisible(true);
    }
}
