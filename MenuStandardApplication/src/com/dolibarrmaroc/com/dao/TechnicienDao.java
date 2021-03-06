package com.dolibarrmaroc.com.dao;

import java.util.List;

import com.dolibarrmaroc.com.models.BordereauGps;
import com.dolibarrmaroc.com.models.BordreauIntervention;
import com.dolibarrmaroc.com.models.Client;
import com.dolibarrmaroc.com.models.Compte;
import com.dolibarrmaroc.com.models.GpsTracker;
import com.dolibarrmaroc.com.models.ImageTechnicien;
import com.dolibarrmaroc.com.models.Services;

public interface TechnicienDao {

	public String insertBordereau(BordreauIntervention bi,Compte c,GpsTracker gps,String imei,String num,String battery);
	public String insertBordereauoff(BordreauIntervention bi, Compte c);
	
	public List<BordereauGps> selectAllBordereau(Compte c);
	
	public List<Services> allServices(Compte c);
	public void inesrtImage(List<ImageTechnicien> imgs,String lien);
	
	public List<Client> selectAllClient(Compte c);

}
