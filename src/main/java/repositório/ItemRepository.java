/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositório;

import MODEL.MoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



/**
 *
 * @author a1628682
 */
@Repository
public interface ItemRepository extends JpaRepository<MoItem, Long>{

	MoItem findItensById(Long id);

    public MoItem findItemById(Long id);
	
}