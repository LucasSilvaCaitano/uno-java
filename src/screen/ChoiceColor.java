package screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.List;

public class ChoiceColor extends JDialog implements MouseListener {

    final int SIZE = 400;
    public ChoiceColor(){
        setTitle("Escolha uma cor");
        setSize(SIZE, SIZE);
        setLayout(null);
        setLocationRelativeTo(null);
        init();
        setVisible(true);
    }

    void init(){
        List<Color> colors = List.of(Color.blue, Color.green, Color.red, Color.yellow);

        int colorQuadrantWidth = getWidth()/2;
        int colorQuadrantHeight = getHeight()/2;
        int indexColor = 0;
        for(int x = 0; x<getWidth(); x+=colorQuadrantWidth){

            for(int y = 0; y<getHeight(); y+=colorQuadrantHeight){

                JLabel colorQuadrant = new JLabel();
                colorQuadrant.setBackground(colors.get(indexColor++));
                colorQuadrant.setBounds(x, y, colorQuadrantWidth, colorQuadrantHeight);
                colorQuadrant.setOpaque(true);
                add(colorQuadrant);
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        dispose();
    }

    @Override
    public void mousePressed(MouseEvent e) {

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
}
