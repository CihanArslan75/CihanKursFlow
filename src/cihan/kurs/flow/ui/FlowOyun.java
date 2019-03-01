package cihan.kurs.flow.ui;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import javax.swing.JButton;

public class FlowOyun extends JFrame{
	private Container c=getContentPane();
	
	public FlowOyun() {
		
	    Initialize();
	}

   public void Initialize() {
		FlowOyunPanel  p = new FlowOyunPanel();
		FlowOyunButon b=new FlowOyunButon(c);
		
        c.add(p.getbPanel());
		for (int i = 0; i <b.buttons.length; i++) {
			p.getbPanel().add(b.buttons[i]);
		}
		
		setTitle("F L O W");
		setBounds(500, 150, 800, 800);
		getContentPane().setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
}
