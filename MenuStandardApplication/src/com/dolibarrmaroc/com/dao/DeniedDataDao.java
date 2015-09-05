package com.dolibarrmaroc.com.dao;

import java.util.List;

import com.dolibarrmaroc.com.models.Compte;

public interface DeniedDataDao {

	public List<String> sendMyErrorData(List<String> in,Compte cp,String tp);
}
