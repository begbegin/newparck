package com.ingeniousafrica.supperparckvoiture2.utilitaire;

import java.util.List;


import com.ingeniousafrica.supperparckvoiture2.metier.Voiture;

import com.ingeniousafrica.supperparckvoiture2.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class VoitureAdapter extends ArrayAdapter<Voiture>{
	
	private int mRessources;
	private LayoutInflater inflateur;

	public VoitureAdapter(Context context, int textViewResourceId,
			List<Voiture> objects) {
		super(context, textViewResourceId, objects);
		inflateur = LayoutInflater.from(context);
		mRessources = textViewResourceId;
		
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if(convertView == null){
			convertView = inflateur.inflate(mRessources, null);
			
			
		}
		
		Voiture vehicule = getItem(position);
		
		TextView marque = (TextView)convertView.findViewById(R.id.item_nouveau_voiture_marque_text);
		TextView model = (TextView)convertView.findViewById(R.id.item_nouveau_voiture_model_text);
		TextView carrosserie = (TextView)convertView.findViewById(R.id.item_nouveau_voiture_carrosserie_text);
		TextView moteur = (TextView)convertView.findViewById(R.id.item_nouveau_voiture_moteur_text);
		TextView annee = (TextView)convertView.findViewById(R.id.item_nouveau_voiture_annee_text);
		TextView description = (TextView)convertView.findViewById(R.id.item_nouveau_voiture_description_text);
		
		marque.setText(vehicule.getmMarque());
		model.setText(vehicule.getmModel());
		carrosserie.setText(vehicule.getmCarrosserie());
		moteur.setText(vehicule.getmMoteur());
		annee.setText(vehicule.getmAnnee());
		description.setText(vehicule.getmDescription());

		return convertView;
	}
	
	

}
