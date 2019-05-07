package com.example.bloodapp;

import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.content.*;
import android.app.Activity;
import android.view.Menu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class SearchMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search_main, menu);
		return true;
	}
	public  void searchClick(View v){
		ArrayList<String> x = new ArrayList<String>();
		x.add("Name");
		x.add("Mobile");
		GridView g1 = (GridView ) findViewById(R.id.gridView1);
		Spinner s1 = (Spinner) findViewById(R.id.spinner1);
		Spinner s2 = (Spinner) findViewById(R.id.spinner2);
	     String bg = s1.getSelectedItem().toString();
	     String city = s2.getSelectedItem().toString();
		try{
			ConnectionClass c = new ConnectionClass();
			Connection conn = c.CONN();
			String sql = "Select * from regblood where bgroup='"+bg+"'" +
					" and ucity = '"+city+"'";
			Statement stat=conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next())
			{
				x.add(rs.getString(1));
				x.add(rs.getString(2));
			}
			ArrayAdapter<String> s = new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_1,x);
		g1.setAdapter(s);
		}
		catch(Exception ex){
        Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();			
		}
	
	
	}

}
