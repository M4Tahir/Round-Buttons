import javax.swing.*;
import java.awt.*;

/**
 * This is a simple Java swing application to make round JButtons. I have use Graphics2D to make the edges smoother.
 * @author ~MT
 * @version 1.0
 */
public class MyButton extends JButton {
    String btnName;
    Color background,textColor;
    int width,height,arcWidth,arcHeight;

    /**
     *
     * @param btnName Enter the text of the button
     * @param width Enter the width of the button
     * @param height Enter Height of the button
     * @param arcWidth Round in width
     * @param arcHeight Round in Height
     * @param background Background color of button
     * @param textColor Foreground color of button
     */
    public MyButton(String btnName,int width, int height,int arcWidth, int arcHeight, Color background, Color textColor) {
        this.height = height;
        this.width = width;
        this.background=background;
        this.textColor = textColor;
        this.arcHeight=arcHeight;
        this.arcWidth=arcWidth;
        this.btnName = btnName;
        this.setBackground(background);
        this.setForeground(Color.white);
        this.setContentAreaFilled(false); // this to not fill the area other than the round rectangle i.e., remaining edges of the previous rectangle button
        this.setBorderPainted(false); // the border of the button will not be painted
        this.setFocusable(false);
        this.setBounds(250, 180, width, height);
        this.addActionListener(e -> System.exit(0));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getBackground());
        g2d.fillRoundRect(0,0,getWidth(),getHeight(),arcWidth,arcHeight);
        // let's add the name to the button, to center the button in the round rectangle we use FontMetrics.
        g2d.setColor(textColor);
        FontMetrics metrics = g.getFontMetrics(getFont());
        int x = (getWidth() - metrics.stringWidth(btnName)) / 2;
        int y = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
        g2d.drawString(btnName, x, y);

    }
}
