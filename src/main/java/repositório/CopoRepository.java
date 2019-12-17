/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositório;

import MODEL.MoCopo;
import MODEL.MoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author a1628682
 */
@Repository
public interface CopoRepository extends JpaRepository<MoCopo, Long>{

	MoCopo findCopoById(Long id);
        
        public MoCopo findCoposById(Long id);

}