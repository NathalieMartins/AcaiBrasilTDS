/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviço;

import MODEL.MoCopo;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author a1628682
 */
public interface CopoService {
    
    List<MoCopo> findAll();
	
	Optional<MoCopo> findById(Long id);
	
	MoCopo persist(MoCopo copo);	
	
	void delete(Long id);
	
	MoCopo findOne(Long id);
}
