package services;

import javax.ejb.Local;

import entities.Produit;
import misc.enums.FormatImageEnum;

@Local
public interface ImageService {
	
	public boolean attachImageToProduit(Produit produit);
	
	public byte[] getImage(String ean, FormatImageEnum format);

}
