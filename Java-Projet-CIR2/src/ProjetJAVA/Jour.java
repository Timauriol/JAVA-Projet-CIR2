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
    private Color couleur_am;
    private Color couleur_pm;
    JLabel num_jour;
    
  
    public Jour(Color couleur_am,Color couleur_pm,int jour){
        this.num_jour = new JLabel(String.valueOf(jour),JLabel.LEFT);
        this.add(num_jour,BorderLayout.NORTH);
        this.couleur_am = couleur_am;
        this.couleur_pm = couleur_pm;
       
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
            g.setColor(couleur_am );
            g.fillPolygon(triangle);
        }
        
        if(couleur_pm != null) {
            Point p1 = new Point(0,size.height);
            Point p2 = new Point(size.width,0);
            Point p3 = new Point(size.width,size.height);

            int[] xs = { p1.x, p2.x, p3.x };
            int[] ys = { p1.y, p2.y, p3.y };
            Polygon triangle = new Polygon(xs, ys, xs.length);
            g.setColor(couleur_pm);
            g.fillPolygon(triangle);  
        }
        
        num_jour.repaint();
	}
       
}
    






