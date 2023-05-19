package View;

import Model.CircleModel;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class DrawingPanel extends JPanel {
    private CircleModel circle;

    public DrawingPanel(CircleModel circle) {
        this.circle = circle;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(circle.getColor());
        Ellipse2D circle = this.circle.getShape();
        g2.fill(circle);
    }
}
