package br.inatel.dm110.interfaces;

import br.inatel.dm110.to.IPAddressTO;


public interface Management {

	void addNewIP(String ip , String mask);

	String listIP(String ip);

}
