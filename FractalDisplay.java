import javax.swing.JPanel;
import java.awt.*;
import java.util.Random;

public class FractalDisplay extends JPanel {

    private float angle;
    private float angleFalloff;

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public void setAngleFalloff(float angleFalloff) {
        this.angleFalloff = angleFalloff;
    }

    public void FractalDisplay() {

    }

    @Override
    public void paintComponent(Graphics graphics) {

        Graphics2D g = (Graphics2D) graphics;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.scale(1, -1);
        g.translate(0, -getHeight());
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.WHITE);

        drawLine(g, getWidth() / 2, 0, 0, angleFalloff * (getHeight() / 4), 50);

    }

    private Random random = new Random();

    public void drawLine(Graphics2D g, int pivotX, int pivotY, float angle, float length, float stroke) {

        double rad = -angle * Math.PI / 180;

        double x = Math.cos(rad) - length * Math.sin(rad);
        double y = Math.sin(rad) + length * Math.cos(rad);

        g.setStroke(new BasicStroke(stroke));
        g.drawLine(pivotX, pivotY, (int) x + pivotX, (int) y + pivotY);

        if (length >= 4) {

            drawLine(g, (int) x + pivotX, (int) y + pivotY, angle + this.angle, length * angleFalloff, stroke * 0.7f);
            drawLine(g, (int) x + pivotX, (int) y + pivotY, angle - this.angle, length * angleFalloff, stroke * 0.7f);

        }

    }
}
