package com.aprendec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.aprendec.commons.GenericServiceImpl;
import com.aprendec.dao.MusicoDao;
import com.aprendec.model.musico_pruebas;
import com.aprendec.service.MusicoService;

@Service
public class MusicoServiceImpl extends GenericServiceImpl<musico_pruebas, Long> implements MusicoService {

	@Autowired(required=true)
	private MusicoDao musicoDao;

	@Override
	public CrudRepository<musico_pruebas, Long> getDao() {
		return musicoDao;
	}

}