package com.ingeniousafrica.supperparckvoiture2.activities;


import android.app.Activity;

import android.app.Dialog;

import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;


import com.ingeniousafrica.supperparckvoiture2.R;


/**
 * C'est une activité permet de gere la fabrication de voitures
 * Date de création : 29-08-2012
 * Date de modification : 29-08-2012
 * @author w.begbessou
 * @version 1.0
 */
public class Parck extends Activity implements OnClickListener, OnItemClickListener{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_parck);
		
	}

	public void onClick(View v) {
		switch(v.getId()){


    	}
	}
	
	
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		
		return super.onCreateDialog(id);
	}
	
	/**
	 * Cette methode sera appeller à chaque fois que la listview doit etre raffraichit
	 */
	public void afficherClients(){
		

	}

}
