package com.dolibarrmaroc.com.business;

import java.util.List;

import com.dolibarrmaroc.com.models.Compte;
import com.dolibarrmaroc.com.models.ProspectData;
import com.dolibarrmaroc.com.models.Prospection;
import com.dolibarrmaroc.com.models.Societe;

public interface CommercialManager {
	public String insert(Compte c,Prospection prospect);
	public ProspectData getInfos(Compte c);
	public List<Societe> getAll(Compte c);
	public String update(Compte c,Prospection p); 
	public String insertWithImage(Compte compte, Prospection client,
			String ba1, String lieux);
}
