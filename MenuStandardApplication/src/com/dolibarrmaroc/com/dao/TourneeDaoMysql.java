package com.dolibarrmaroc.com.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.R.integer;
import android.util.Log;

import com.dolibarrmaroc.com.models.Client;
import com.dolibarrmaroc.com.models.Commandeview;
import com.dolibarrmaroc.com.models.Compte;
import com.dolibarrmaroc.com.models.Produit;
import com.dolibarrmaroc.com.models.Tournee;
import com.dolibarrmaroc.com.utils.JSONParser;
import com.dolibarrmaroc.com.utils.URL;

public class TourneeDaoMysql implements TourneeDao{

	private static final String urlData = URL.URL+"json.php";
	private JSONParser parser ;
	
	
	public TourneeDaoMysql(){
		super();
		parser = new JSONParser();
	}
	@Override
	public List<Tournee> consulterMesTournee(Compte c, String dt) {
		// TODO Auto-generated method stub
		
		List<Tournee> tour = new ArrayList<>();
		
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

		nameValuePairs.add(new BasicNameValuePair("user",c.getIduser()+""));//c.getLogin()
		nameValuePairs.add(new BasicNameValuePair("password",c.getPassword()));
		nameValuePairs.add(new BasicNameValuePair("action","android"));
		nameValuePairs.add(new BasicNameValuePair("dt",dt));

			Log.e("send durl mes tournee ",nameValuePairs.toString());

		try {
			String json = parser.makeHttpRequest(urlData, "POST", nameValuePairs);
			
			Log.e("start", json);
			
			//[{"rowid":"1","label":"new task","dates":"2015-09-02","datee":"2015-09-19","color":"#0080ff","secteur":"CA","idsecteur":"18","clients":[],"grp":"vendeur","idgrp":"7","usr":"","recur":["1","3","6"]}]
			String stfomat = json.substring(json.indexOf("["),json.lastIndexOf("]")+1);


			
			//Log.e("json",stfomat);
			JSONArray jsr = new JSONArray(stfomat);

			for (int i = 0; i < jsr.length(); i++) {
				JSONObject obj = jsr.getJSONObject(i);

				Tournee tr = new Tournee();
				
				tr.setRowid(obj.getLong("rowid"));
				tr.setLabel(obj.getString("label"));
				tr.setDebut(obj.getString("dates"));
				tr.setFin(obj.getString("datee"));
				tr.setColor(obj.getString("color"));
				
				tr.setSecteur(obj.getString("secteur"));
				tr.setIdsecteur(obj.getLong("idsecteur"));
				
				
				
				tr.setGrp(obj.getString("grp"));
				tr.setIdgrp(obj.getLong("idgrp"));
				
				JSONArray cl = obj.getJSONArray("clients");
				List<Client> lsclt = new ArrayList<>();
				for (int j = 0; j < cl.length(); j++) {
					JSONObject o = cl.getJSONObject(j);
					Client ct = new Client(o.getInt("rowid"), o.getString("name"), "", o.getString("town"), o.getString("email"), o.getString("phone"), o.getString("address"));
					
					lsclt.add(ct);
				}
				
				tr.setLsclt(lsclt);
				
				JSONArray rc = obj.getJSONArray("recur");
				List<Integer> lsrc = new ArrayList<>();
				for (int j = 0; j < rc.length(); j++) {
					
					lsrc.add(rc.getInt(j));
				}
				
				tr.setRecur(lsrc);
				
				tour.add(tr);
				
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			tour = new ArrayList<>();
			Log.e("load tour error ",e.getMessage()+ "  <<");
		}

		return tour;
	}

}
