package com.dolibarrmaroc.com.business;

import java.util.HashMap;
import java.util.List;

import com.dolibarrmaroc.com.dao.VendeurDao;
import com.dolibarrmaroc.com.models.CategorieCustomer;
import com.dolibarrmaroc.com.models.Client;
import com.dolibarrmaroc.com.models.Compte;
import com.dolibarrmaroc.com.models.Dictionnaire;
import com.dolibarrmaroc.com.models.Facture;
import com.dolibarrmaroc.com.models.Produit;
import com.dolibarrmaroc.com.models.Promotion;
import com.dolibarrmaroc.com.models.Societe;
import com.dolibarrmaroc.com.models.Tournee;

public class DefaultVendeurManager implements VendeurManager {

	private VendeurDao dao;
	
	public DefaultVendeurManager() {
	}

	
	public DefaultVendeurManager(VendeurDao dao) {
		super();
		this.dao = dao;
	}

	public VendeurDao getDao() {
		return dao;
	}


	public void setDao(VendeurDao dao) {
		this.dao = dao;
	}


	@Override
	public int insertFacture(Facture fac) {
		return dao.insertFacture(fac);
	}


	@Override
	public List<Produit> selectAllProduct(Compte c) {
		return dao.selectAllProduct(c);
	}


	@Override
	public Produit selectProduct(String id, Compte c) {
		return dao.selectProduct(id, c);
	}


	@Override
	public List<Client> selectAllClient(Compte c) {
		return dao.selectAllClient(c);
	}


	@Override
	public Dictionnaire getDictionnaire() {
		// TODO Auto-generated method stub
		return dao.getDictionnaire();
	}


	@Override
	public List<Promotion> getPromotions(int idclt, int idprd) {
		return dao.getPromotions(idclt, idprd);
	}


	@Override
	public HashMap<Integer, HashMap<Integer, Promotion>> getPromotionProduits() {
		// TODO Auto-generated method stub
		return dao.getPromotionProduits();
	}


	@Override
	public HashMap<Integer, List<Integer>> getPromotionClients() {
		// TODO Auto-generated method stub
		return dao.getPromotionClients();
	}


	@Override
	public List<CategorieCustomer> getAllCategorieCustomer(Compte c) {
		// TODO Auto-generated method stub
		return dao.getAllCategorieCustomer(c);
	}


	@Override
	public List<Client> selectAllLastClient(Compte c, String in) {
		// TODO Auto-generated method stub
		return dao.selectAllLastClient(c, in);
	}


	@Override
	public List<Societe> selectSociete() {
		// TODO Auto-generated method stub
		return dao.selectSociete();
	}


	@Override
	public List<Tournee> consulterMesTournee(Compte c, String dt) {
		// TODO Auto-generated method stub
		return dao.consulterMesTournee(c, dt);
	}

}
