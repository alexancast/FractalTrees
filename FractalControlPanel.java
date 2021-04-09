import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class FractalControlPanel extends JPanel {

    private FractalDisplay display;

    public FractalControlPanel(FractalDisplay display) {
        this.display = display;
        setBorder(BorderFactory.createTitledBorder("Control panel"));

        add(new JLabel("Angle"));
        JSlider angleSlider = new JSlider(45, 90);
        angleSlider.setValue(0);
        angleSlider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                display.setAngle(angleSlider.getValue());
                display.revalidate();
                display.repaint();

            }
        });
        add(angleSlider);

        add(new JLabel("Angle falloff"));
        JSlider angleFalloff = new JSlider(0, 800);
        angleFalloff.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                display.setAngleFalloff((float) angleFalloff.getValue() / 1000);
                display.revalidate();
                display.repaint();

            }
        });
        add(angleFalloff);

    }
}
