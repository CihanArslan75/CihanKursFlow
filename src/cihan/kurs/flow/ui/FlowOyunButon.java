package cihan.kurs.flow.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cihan.kurs.flow.dao.FlowDAO;
import cihan.kurs.flow.model.Flow;
import cihan.kurs.flow.ui.FlowOyun;
import cihan.kurs.runner.Runner;

public class FlowOyunButon extends JButton implements ActionListener {
	
	public JButton[] buttons= new JButton[Runner.oyunSeviye*Runner.oyunSeviye];
	private String[] renk;
    private Container cc;			
	public FlowOyunButon(Container c) {
		buttonInitialize();
		this.cc=c;
	
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
				buttons[flow.get(i).getFlowposition()].setText("O");
				buttons[flow.get(i).getFlowposition()].setBackground( new Color (flow.get(i).getRenk1(),flow.get(i).getRenk2(),flow.get(i).getRenk3()));	
				buttons[flow.get(i).getFlowposition()].setActionCommand(flow.get(i).getFlowposition()+";"+flow.get(i).getRenk1()+";"+flow.get(i).getRenk2()+";"+flow.get(i).getRenk3());
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
				 
		String[] renkKod = e.getActionCommand().split(";");
		Integer renk1=Integer.parseInt(renkKod[1]);
		Integer renk2=Integer.parseInt(renkKod[2]);
		Integer renk3=Integer.parseInt(renkKod[3]);
		
		Integer renk11 = null;
		Integer renk22 = null;
		Integer renk33 = null;
		
		if(renk!=null) {
			renk11=Integer.parseInt(renk[1]);
			renk22=Integer.parseInt(renk[2]);
			renk33=Integer.parseInt(renk[3]);
		}

		if(renk1==192 && renk2==192 && renk3==192) {
			buttons[Integer.parseInt(renkKod[0])].setBackground(new Color (renk11,renk22,renk33));
		}
		else
		{  
			renk = e.getActionCommand().split(";");
		}
		
		int oyunSonu=oyunKontrol();
		if(oyunSonu==1) {
			JOptionPane.showMessageDialog(FlowOyunButon.this, "Level Atladınız");
			
			if(Runner.oyunLevel==2) 
			{
				Runner.oyunLevel=1;
				Runner.oyunSeviye++;
			}
			else 
			{
				Runner.oyunLevel++;
			}
			
//			FlowOyun f = new FlowOyun();
//			f.Initialize();
		    cc.removeAll();
		    cc.repaint();
			FlowOyunPanel  p = new FlowOyunPanel();
			FlowOyunButon b=new FlowOyunButon(cc);
			
	        cc.add(p.getbPanel());
			for (int i = 0; i <b.buttons.length; i++) {
				p.getbPanel().add(b.buttons[i]);
			}
			
		}
	}
	
	public int oyunKontrol() {
		int sayi=0;
		int oyunSonu=0;
		for (int i = 0; i < buttons.length; i++) {
			if(buttons[i].getBackground().getRGB()==-4144960) sayi++;
			
		}
		if(sayi==0) 
			{  
			    oyunSonu=1;
			}
	
		return oyunSonu;
	}
	
	
	

	
	

}
