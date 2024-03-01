import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tugas5 extends JPanel implements ActionListener {
    private int lineY; // Koordinat y dari garis
    private int deltaX = 2; // Jumlah perubahan untuk koordinat x pada setiap iterasi
    private boolean movingLeft = true; // Flag untuk menentukan arah pergerakan
   
    private Timer timer;

    Tugas5() {
        timer = new Timer(10, this); // 10 milliseconds delay antara setiap update
        timer.start();

        // Menghitung posisi awal untuk menempatkan garis di kanan atas jendela
        lineY = 0;
    }

    public void actionPerformed(ActionEvent e) {
        // Perbarui posisi garis
        if (movingLeft) {
            lineY += deltaX;
        } else {
            lineY -= deltaX;
        }

        // Membalik arah pergerakan jika garis mencapai batas atas atau bawah jendela
        if (lineY >= getHeight() || lineY <= 0) {
            movingLeft = !movingLeft;
        }

        // Menghasilkan detak jantung acak antara 60 dan 100
       

        repaint(); // Memperbarui tampilan untuk menampilkan perubahan garis
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Gambar garis
        g2d.setColor(Color.GREEN);
        g2d.setStroke(new BasicStroke(4)); // Set ketebalan garis
        g2d.drawLine(getWidth(), lineY, 0, lineY); // Dari kanan ke kiri, di tengah jendela


        // Tampilkan nilai detak jantung
        g2d.setColor(Color.BLACK);
   
    }

    public static void main(String[] argv) {
        JFrame f = new JFrame("Titttt");
        Tugas5 patientMonitor = new Tugas5();
        f.add(patientMonitor);
        f.setSize(500, 300);
        f.setLocationRelativeTo(null); // Menempatkan frame di tengah layar
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
