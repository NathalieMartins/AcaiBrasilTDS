/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import MODEL.MoItem;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositório.ItemRepository;
import serviço.ItemService;

/**
 *
 * @author a1628682
 */
@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	ItemRepository ItemRepository;
	
	@Override
	public List<MoItem> findAll() {
		
		return ItemRepository.findAll();
	}

	@Override
	public Optional<MoItem> findById(Long id) {
		
		return ItemRepository.findById(id);
	}

	@Override
	public MoItem persist(MoItem item) {
		
		return ItemRepository.save(item);
	}

	@Override
	public void delete(Long id) {
		ItemRepository.deleteById(id);		
	}

	@Override
	public MoItem findOne(Long id) {
		
		return ItemRepository.findItemById(id);
	}
}
