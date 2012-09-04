package com.ingeniousafrica.supperparckvoiture2.activities;

import java.util.Locale;

import com.ingeniousafrica.supperparckvoiture2.R;
import com.ingeniousafrica.supperparckvoiture2.metier.Client;
import com.ingeniousafrica.supperparckvoiture2.metier.DataFabrication;
import android.app.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;

import android.os.Bundle;
import android.preference.PreferenceManager;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;
/**
 * C'est une activité se lance au démmarrage et permet de saisir les informations du client
 * Date de création : 28-08-2012
 * Date de modification : 04-09-2012
 * @author w.begbessou
 * @version 1.0
 */
public class Main extends Activity implements OnClickListener{
	
	private EditText name;
	
	private EditText prenom;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		//Je positionne par défaut la valeur français à mes préférences de langues
		SharedPreferences lPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		Editor lEditeur =lPrefs.edit();
		
		Resources lRes = getResources();
		
		Configuration lConfig = lRes.getConfiguration();
		
		if(lConfig.locale.equals(Locale.FRANCE)){
			lEditeur.putString("lang", getString(R.string.french_string));
		}else{
			lEditeur.putString("lang", getString(R.string.english_string));
		}
		
		lEditeur.commit();
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.activity_client_button_continuer).setOnClickListener(this);
		findViewById(R.id.activity_main_button_parck).setOnClickListener(this);

		name = (EditText)findViewById(R.id.activity_client_name_edit);

		prenom = (EditText)findViewById(R.id.activity_client_prenom_edit);

	}
	    
	    
	  @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, 1000, 0, R.string.menu_params_string);
		return true;
		
	}

	@Override
	protected void onResume() {
		
		super.onResume();
		
	}
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		goToPreferences();
		 return true;
	}
	
	private void goToPreferences(){
		 Intent intent = new Intent(this, PreferActivity.class );

		 startActivity(intent);
		 
		 finish();
	}
	
	
	public void onClick(View v) {
		  switch(v.getId()){

		  case R.id.activity_client_button_continuer:

			  //un objet client pour infos du client
			  Client lClient = new Client();
			  String lNom = name.getText().toString();

			  String lPrenom = prenom.getText().toString();

			  if(!lNom.equals("") && !lPrenom.equals("")){
				  lClient.setmNom(lNom);
				  lClient.setmPrenom(lPrenom);

				  DataFabrication.getInstence().setmClient(lClient);

				  Intent intent = new Intent(this, Fabrication.class );

				  startActivity(intent);
			  }else{
				  Toast.makeText(this, R.string.activity_champ_null_msg, 5000).show();
			  }

			  break;
		  case R.id.activity_main_button_parck:

			  Intent intent = new Intent(this, Parck.class );

			  startActivity(intent);
			  
			  break;

		  }

	  }

}
