package com.dolibarrmaroc.com.dao;

import java.util.HashMap;
import java.util.List;

import com.dolibarrmaroc.com.models.Client;
import com.dolibarrmaroc.com.models.Compte;
import com.dolibarrmaroc.com.models.Societe;
import com.dolibarrmaroc.com.models.Tournee;

public interface TourneeDao {

	public List<Tournee> consulterMesTournee(Compte cp, String dt);
	
	public HashMap<Integer, List<Integer>> getPromotionClients();
	
	public List<Societe> selectSociete();
}
