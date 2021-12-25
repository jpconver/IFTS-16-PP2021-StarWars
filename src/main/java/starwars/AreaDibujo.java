package starwars;

import java.awt.*;
import java.util.ArrayList;

import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class AreaDibujo extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Dibujable> objs;
	private Clip sonido;
	
	public AreaDibujo(String titulo, int ancho, int alto){
		
		objs = new ArrayList <Dibujable>();
		
		this.setDoubleBuffered(true);
		this.setPreferredSize(new Dimension(ancho,alto));
		this.setBackground(new Color(255,255,255));
		
		JFrame marco = new JFrame(titulo);
		marco.setResizable(false);
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.add(this);
		marco.pack();
		
		this.requestFocus();
		sonido= Sonido.LoadSound("kitsound.wav");
	    sonido.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void add(Dibujable obj){
		objs.add(obj);
	}
	
	public void vacia(){
		objs.clear();
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		for(Dibujable obj : objs){
			obj.dibuja(g);
		}
	}

	public void remove(Dibujable obj) {
		objs.remove(obj);
	}

}
