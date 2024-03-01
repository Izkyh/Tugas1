import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

public class Tugas4 extends Frame implements ActionListener {
    private int sunX; // x-coordinate of the sun
    private int sunY; // y-coordinate of the sun
    private int planetRadius = 10;
    private int orbitRadius = 100;
    private int angle = 0;
    private Timer timer;

    Tugas4() {
        addWindowListener(new MyFinishWindow());
        timer = new Timer(5, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        angle++;
        repaint();
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        BasicStroke bs = new BasicStroke(3.0f);
        g2d.setStroke(bs);

        // Get the width and height of the window
        int width = getWidth();
        int height = getHeight();

        // Calculate the center of the window
        sunX = width / 2;
        sunY = height / 2;

        // Draw the sun (color: yellow)
        g2d.setColor(Color.RED);
        g2d.fillOval(sunX - 20, sunY - 20, 60, 60);

        // Calculate planet's position
        double planetX = sunX + orbitRadius * Math.cos(Math.toRadians(angle));
        double planetY = sunY + orbitRadius * Math.sin(Math.toRadians(angle));

        // Draw the planet (color: green)
        g2d.setColor(Color.pink);
        g2d.fillOval((int) (planetX - planetRadius), (int) (planetY - planetRadius), 2 * planetRadius,
                2 * planetRadius);

        // Calculate the point on the planet closest to the sun after one third of its orbit
        double pointX = sunX + orbitRadius * Math.cos(Math.toRadians(angle + 120));
        double pointY = sunY + orbitRadius * Math.sin(Math.toRadians(angle + 120));

        // Draw a small circle at the point closest to the sun after one third of its orbit (color: red)
        g2d.setColor(Color.black);
        g2d.fillOval((int) (pointX - 3), (int) (pointY - 3), 6, 6);
    }

    public static void main(String[] argv) {
        Tugas4 f = new Tugas4();
        f.setTitle("orbit system");
        f.setSize(500, 500);
        f.setVisible(true);
    }
}
