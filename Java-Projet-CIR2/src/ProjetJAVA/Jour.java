package ProjetJAVA;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Jour extends JPanel {
    public Color couleur_am;
    public Color couleur_pm;
    public JLabel num_jour;
    public boolean transparent;


    public Jour(){
        this.setLayout(new BorderLayout());
        this.num_jour = new JLabel("",JLabel.LEFT);
        this.add(num_jour,BorderLayout.NORTH);
        this.couleur_am = null;
        this.couleur_pm = null;
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Dimension size = this.getSize();

        if (couleur_am != null){
            Point p1 = new Point(0,0);
            Point p2 = new Point(size.width,0);
            Point p3 = new Point(0,size.height);

            int[] xs = { p1.x, p2.x, p3.x };
            int[] ys = { p1.y, p2.y, p3.y };
            Polygon triangle = new Polygon(xs, ys, xs.length);
            g.setColor(transparent?couleur_am.brighter():couleur_am);
            g.fillPolygon(triangle);
        }

        if(couleur_pm != null) {
            Point p1 = new Point(0,size.height);
            Point p2 = new Point(size.width,0);
            Point p3 = new Point(size.width,size.height);

            int[] xs = { p1.x, p2.x, p3.x };
            int[] ys = { p1.y, p2.y, p3.y };
            Polygon triangle = new Polygon(xs, ys, xs.length);
            g.setColor(transparent?couleur_pm.brighter():couleur_pm);
            g.fillPolygon(triangle);
        }

        num_jour.repaint();
    }

}







