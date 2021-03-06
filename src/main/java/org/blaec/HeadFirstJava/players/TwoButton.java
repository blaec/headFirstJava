package org.blaec.HeadFirstJava.players;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TwoButton {
    JFrame frame;
    JLabel label;
    private int x = 70;
    private int y = 70;

    public static void main(String[] args) {
        TwoButton gui = new TwoButton();
        gui.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton labelButton = new JButton("Change label");
        labelButton.addActionListener(new LabelListener());

        JButton colorButton = new JButton("Change Circle");
        colorButton.addActionListener(new ColorListener());

        label = new JLabel("I'm a label");
        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);

        frame.setSize(500, 300);
        frame.setVisible(true);
    }

    private class MyDrawPanel extends JPanel {
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;

            g2d.setPaint(new GradientPaint(70, 70, getRandomColor(), 150, 150, getRandomColor()));
            g.fillOval(x, y, 100, 100);
        }

        private int getRandomHue() {
            return (int) (Math.random() * 255);
        }

        private Color getRandomColor() {
            int red = getRandomHue();
            int green = getRandomHue();
            int blue = getRandomHue();

            return new Color(red, green, blue);
        }
    }

    private class LabelListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            label.setText("Ouch!");
        }
    }

    private class ColorListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            x++;
            y++;
            frame.repaint();
        }
    }
}
