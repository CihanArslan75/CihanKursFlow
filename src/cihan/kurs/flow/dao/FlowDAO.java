package cihan.kurs.flow.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cihan.kurs.flow.model.Flow;
import cihan.kurs.runner.Runner;

public class FlowDAO {
	
	public List<Flow> getAllFlowLevel() throws SQLException {
		ConnectionManager mng=ConnectionManager.getIntance();
		Connection conn=mng.getConnection();
		Statement stmt=conn.createStatement(); 
		String sql="select flowseviye, flowlevel, flowrenk, flowposition,renk1,renk2,renk3"
				+ " from flow.flow where flowseviye="+Runner.oyunSeviye +" and flowlevel="+Runner.oyunLevel;
		ResultSet rs=stmt.executeQuery(sql);
		List<Flow> flowListe=new ArrayList<Flow>();
		while(rs.next()) {
			Flow flow=new Flow();
			flow.setFlowlevel(rs.getInt("flowlevel"));
			flow.setFlowseviye(rs.getInt("flowseviye"));
			flow.setFlowposition(rs.getInt("flowposition"));
			flow.setFlowrenk(rs.getString("flowrenk"));
			flow.setRenk1(rs.getInt("renk1"));
			flow.setRenk2(rs.getInt("renk2"));
			flow.setRenk3(rs.getInt("renk3"));
			flowListe.add(flow);
		}
		return flowListe;
		
	}
	
}


