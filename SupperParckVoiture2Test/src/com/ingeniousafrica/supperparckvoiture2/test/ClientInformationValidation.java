/**
 * 
 */
package com.ingeniousafrica.supperparckvoiture2.test;

import com.ingeniousafrica.supperparckvoiture2.R;
import com.ingeniousafrica.supperparckvoiture2.activities.Main;
import com.ingeniousafrica.supperparckvoiture2.metier.DataFabrication;

import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.Button;
import android.widget.EditText;


/**
 * @author w.begbessou
 *
 */
public class ClientInformationValidation extends
		ActivityInstrumentationTestCase2<Main> {
	private static final String NAME_CLIENT = "beg&wi@ssou";
	
	private static final String PRENOM_CLIENT = "Wiyaou";
	
	private EditText mName;
	
	private EditText mPrenom;
	
	private Button mContinuer;
	
	private static Main mMain;
	
	private DataFabrication mData;
	
	private static String mResultName;
	
	private static String mResultPrenom;
	
	
	/**
	 * 
	 */
	public ClientInformationValidation() {
		super("com.ingeniousafrica.supperparckvoiture2", Main.class);
	}

	/* (non-Javadoc)
	 * @see android.test.ActivityInstrumentationTestCase2#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		mMain = getActivity();
		
		mName = (EditText) mMain.findViewById(R.id.activity_client_name_edit);
		
		mPrenom = (EditText) mMain.findViewById(R.id.activity_client_prenom_edit);
		
		mContinuer = (Button) mMain.findViewById(R.id.activity_client_button_continuer);
		
		mData = DataFabrication.getInstence();
		
		
	}
	
	public void testObjNull(){
		assertNotNull(mMain);
		assertNotNull(mName);
		assertNotNull(mPrenom);
		assertNotNull(mContinuer);
		assertNotNull(mData);
	}
	
	@UiThreadTest
	public void testValuesEditext(){


		mMain.getmName().setText("beg&wi@ssou");

		mMain.getmPrenom().setText("Wiyaou");

		//mMain.onClick(mContinuer);
		mContinuer.performClick();
		
		DataFabrication lD = DataFabrication.getInstence();

		mResultName = lD.getmClient().getmNom();;

		mResultPrenom = lD.getmClient().getmPrenom();


		assertEquals(NAME_CLIENT, mResultName);
		assertEquals(PRENOM_CLIENT,mResultPrenom);
		
	}
	
}
