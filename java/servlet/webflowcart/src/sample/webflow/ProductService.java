package sample.webflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service("productService")
public class ProductService {

	private Map<Integer, Product> products = new HashMap<Integer, Product>();

	public ProductService() {
		products.put(1, new Product(1, "Bulldog", 1000));
		products.put(2, new Product(2, "Chihuahua", 1500));
		products.put(3, new Product(3, "Labrador", 2000));
	}
	

	public List<Product> getProducts() {
		return new ArrayList<Product>(products.values());
	}


	public Product getProduct(int productId) {
		return products.get(productId);
	}

}
