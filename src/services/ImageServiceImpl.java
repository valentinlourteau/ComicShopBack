package services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import entities.Produit;
import misc.PropertiesReader;
import misc.enums.FormatImageEnum;

@Stateless
@LocalBean
public class ImageServiceImpl implements ImageService {

	@Override
	public boolean attachImageToProduit(Produit produit) {
		if (produit.getProduitImage() != null) {
			// Path path = Paths.get("/var/www/html/static/img/products/" +
			// produit.getImage().getProdImageFront());
			Path path = Paths.get("/html/static/img/products/" + produit.getProduitImage().getProdImageFront());
			try {
				produit.getProduitImage().setImage(Files.readAllBytes(path));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		return false;
	}

	@Override
	public byte[] getImage(String ean, FormatImageEnum format) {
		String pathToPicturesFolder = PropertiesReader.getPropertie("pathToPicturesFolder");
		try {
			File file = null;
			if (pathToPicturesFolder != null) {
			file = Files.walk(Paths.get(pathToPicturesFolder)).filter(Files::isRegularFile).map(Path::toFile)
					.filter(item -> item.getName().startsWith(ean + "_1_"
							+ PropertiesReader.getPropertie(format.toString())))
					.findFirst().orElse(null);
			}
			if (file != null) {
				System.out.println(file);
				return Files.readAllBytes(Paths.get(file.getPath()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
