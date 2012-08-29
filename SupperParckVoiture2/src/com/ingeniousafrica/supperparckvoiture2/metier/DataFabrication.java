/**
 * 
 */
package com.ingeniousafrica.supperparckvoiture2.metier;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Application;

import com.ingeniousafrica.supperparckvoiture2.utilitaire.DataManeger;


/**
 * Elle permet regroupe les informations de fabrication de voitue
 * Date de création : 28-08-2012
 * Date de modification : 28-08-2012
 * @author w.begbessou
 * @version 1.0
 * @see Client
 * @see Voiture
 *
 */
public class DataFabrication extends Application{
	
	private Client mClient;
	private ArrayList<Voiture> mVoitures = new ArrayList<Voiture>();
	private HashMap<Client, ArrayList<Voiture>> mParckVoitureClient;
	
	private static DataFabrication mSingletonObj;
	
	/**
	 * Cette methode permet le retour d'un seul obj de notre classe
	 * @author w.begbessou
	 * @return DataFabrication
	 */
	public static DataFabrication getInstence(){
		return mSingletonObj;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void onCreate() {
	
		super.onCreate();
		mSingletonObj = this;
		//je déserialise puis recupère les données sur le lient et les vehicules
		mParckVoitureClient = (HashMap<Client, ArrayList<Voiture>>) DataManeger.readData(this, "donnees");
	
	}
	
	public Client getmClient() {
		return mClient;
	}
	public void setmClient(Client mClient) {
		this.mClient = mClient;
	}
	
	public ArrayList<Voiture> getmVoitures() {
		return mVoitures;
	}


	public void setmVoitures(ArrayList<Voiture> mVoitures) {
		this.mVoitures = mVoitures;
	}


	public HashMap<Client, ArrayList<Voiture>> getmParckVoitureClient() {
		return mParckVoitureClient;
	}
	public void setmParckVoitureClient(
			HashMap<Client, ArrayList<Voiture>> mParckVoitureClient) {
		this.mParckVoitureClient = mParckVoitureClient;
	}
	
	
}
