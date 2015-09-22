package com.dolibarrmaroc.com.dao;

import java.util.List;

import com.dolibarrmaroc.com.models.Compte;
import com.dolibarrmaroc.com.models.Tournee;

public interface TourneeDao {

	public List<Tournee> consulterMesTournee(Compte cp, String dt);
}
