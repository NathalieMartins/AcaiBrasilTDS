/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviço;

import MODEL.MoItem;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author a1628682
 */

public interface ItemService {
	
	List<MoItem> findAll();
	
	Optional<MoItem> findById(Long id);
	
	MoItem persist(MoItem item);	
	
	void delete(Long id);
	
	MoItem findOne(Long id);
}
