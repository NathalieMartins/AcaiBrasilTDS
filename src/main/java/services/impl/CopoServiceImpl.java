/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import MODEL.MoCopo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositório.CopoRepository;
import serviço.CopoService;

/**
 *
 * @author a1628682
 */


@Service
public class CopoServiceImpl implements CopoService{

	@Autowired
	CopoRepository CopoRepository;
	
	@Override
	public List<MoCopo> findAll() {
		
		return CopoRepository.findAll();
	}

	@Override
	public Optional<MoCopo> findById(Long id) {
		
		return CopoRepository.findById(id);
	}

	@Override
	public MoCopo persist(MoCopo copo) {
		
		return CopoRepository.save(copo);
	}

	@Override
	public void delete(Long id) {
		CopoRepository.deleteById(id);		
	}

	@Override
	public MoCopo findOne(Long id) {
		
		return CopoRepository.findCopoById(id);
	}
}


