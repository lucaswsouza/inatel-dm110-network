package br.inatel.dm110.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.inatel.dm110.entities.IPAddress;
import br.inatel.dm110.to.IPAddressTO;

@Stateless
public class AddressDAO {

	@PersistenceContext(unitName = "poll")
	private EntityManager em;

	public void insert(IPAddress ipAddress) {	
		em.merge(ipAddress);
	}

	public String find(String ip) {
	    
		String retorno;

		if ((em.createQuery("from IPAddress a where a.ip=:ip", IPAddress.class).setParameter("ip", ip).getResultList()).size() == 0){
			retorno = "IP não encontrado";
		}else{
			if (em.createQuery("from IPAddress a where a.ip=:ip", IPAddress.class).setParameter("ip", ip).getResultList().get(0).isAtivo()){
				retorno = "IP Ativo"; 						
			}else{
				retorno = "IP Inativo";
			}
				
		}
		
		return retorno;
	}

}
