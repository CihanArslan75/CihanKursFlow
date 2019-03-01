package cihan.kurs.flow.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;

import cihan.kurs.flow.dao.FlowDAO;
import cihan.kurs.flow.model.Flow;
import cihan.kurs.runner.Runner;

public class FlowOyunButon extends JButton implements ActionListener{
	
	public JButton[] buttons= new JButton[Runner.oyunSeviye*Runner.oyunSeviye];
	private String renk;
			
	public FlowOyunButon() {
		buttonInitialize();
	}

	public JButton[] getButtons() {
		return buttons;
	}

	public void setButtons(JButton[] buttons) {
		this.buttons = buttons;
	}

	
	private void buttonInitialize() {
		int butonBas=150;
		int k=0;
		int j=0;
		for (int i = 0; i < buttons.length; i++) {
			
			if((i%Runner.oyunSeviye)==0 && i!=0) {
				k++;
				j=0;
			}
			buttons[i]= new JButton("");
			buttons[i].setBounds((butonBas+(j*70)),(butonBas+(k*70)),70,70);
			buttons[i].setVisible(true);
			j++;
			buttons[i].addActionListener((ActionListener) this);
			buttons[i].setActionCommand(""+i+";192;192;192");
			buttons[i].setBackground(new Color (192,192,192));

		}
		
		renkleriYerlestir();
	}
	
	public int butonBasHesapla(int panelBoyut) {
		return ( panelBoyut -  (70*Runner.oyunSeviye)) /2;
	}

	public void renkleriYerlestir()  {
		FlowDAO flowDao=new FlowDAO();
		List<Flow> flow;
		try {
			flow = flowDao.getAllFlowLevel();
			for (int i = 0; i < flow.size(); i++) {
				buttons[flow.get(i).getFlowposition()].setBackground( new Color (flow.get(i).getRenk1(),flow.get(i).getRenk2(),flow.get(i).getRenk3()));	
				buttons[flow.get(i).getFlowposition()].setActionCommand(flow.get(i).getFlowposition()+";"+flow.get(i).getRenk1()+";"+flow.get(i).getRenk2()+";"+flow.get(i).getRenk3());
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String[] renkKod= e.getActionCommand().split(";");
		buttons[Integer.parseInt(renkKod[0])].setBackground(new Color (Integer.parseInt(renkKod[1]),Integer.parseInt(renkKod[2]),Integer.parseInt(renkKod[3])));
	}
	
	

	
	

}
