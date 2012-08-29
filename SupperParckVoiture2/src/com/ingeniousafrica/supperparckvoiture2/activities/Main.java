package com.ingeniousafrica.supperparckvoiture2.activities;



import java.util.ArrayList;
import java.util.HashMap;

import com.ingeniousafrica.supperparckvoiture2.R;
import com.ingeniousafrica.supperparckvoiture2.metier.Client;
import com.ingeniousafrica.supperparckvoiture2.metier.DataFabrication;
import com.ingeniousafrica.supperparckvoiture2.metier.Voiture;
import com.ingeniousafrica.supperparckvoiture2.utilitaire.DataManeger;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Main extends Activity implements OnClickListener{
	
	private EditText name;
	
	private EditText prenom;
	
	private LayoutInflater inflateur;
	
	private static final int AFFICHER_LIST_VOITURE = 1;
	
	private ListView listV;
	
	  @Override
	    public void onCreate(Bundle savedInstanceState) {
	       super.onCreate(savedInstanceState);
	       setContentView(R.layout.activity_main);
	       inflateur = LayoutInflater.from(this);
	       findViewById(R.id.activity_client_button_continuer).setOnClickListener(this);
	       findViewById(R.id.activity_client_button_list_voiture).setOnClickListener(this);
	       
	     
	       name = (EditText)findViewById(R.id.activity_client_name_edit);
	       
	       prenom = (EditText)findViewById(R.id.activity_client_prenom_edit);
  
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
	    			Toast.makeText(this, "Les champs ne doivent pas être nulls", 5000).show();
	    		}
	    		
	    		
	    		break;

	    	case R.id.activity_client_button_list_voiture:
	    	
	    		
	    		//showDialog(AFFICHER_LIST_VOITURE);
	    		
	    		break;

	    	}

	    }

}
