package com.dolibarrmaroc.com.business;

import java.util.List;
import java.util.Map;

import com.dolibarrmaroc.com.models.Commandeview;
import com.dolibarrmaroc.com.models.Compte;
import com.dolibarrmaroc.com.models.FactureGps;
import com.dolibarrmaroc.com.models.Produit;
import com.dolibarrmaroc.com.models.Remises;

public interface CommandeManager {

	public List<Commandeview> charger_commandes(Compte c);
	public List<Commandeview> charger_commandesLast(Compte c,String in);
	public String insertCommande(List<Produit> prd, String idclt,  Compte compte, Map<String, Remises> allremises);
	public String CmdToFacture(Commandeview cv,Compte cp);
	public String GetNumCommande();
	public List<FactureGps> charger_commandes_gps(Compte c,String imei);
	public String updateCommande(List<Produit> prds, String cmd, Compte compte);
	public String CancelCmd(Commandeview cv, Compte c);
}
