package amoa.webservices;

import amoa.domain.Product;
import amoa.domain.Products;
import amoa.exceptions.NoSuchProductException;
//import jdk.internal.access.JavaIOFileDescriptorAccess;

import javax.jws.WebService;
import java.util.ArrayList;

//import static jdk.jfr.internal.instrument.JDKEvents.remove;

@WebService(endpointInterface = "amoa.webservices.ProductsManager")
public class ProductsManagerImpl implements ProductsManager {
    private static Products products = new Products(new ArrayList<>());

    @Override
    public long addProduct(Product product) {
        products.add(product);
        return product.getId();
    }

    @Override
    public Product getProduct(long id) throws NoSuchProductException {
        Product product = products.get(id);

        if (product != null){
            return product;
        } else {
            throw new NoSuchProductException("No such product!");
        }
    }

    @Override
    public double getProductPrice(long id) throws NoSuchProductException {
        Product product = products.get(id);
        if (product!=null){
            return product.getPrice();
        }else {throw new NoSuchProductException("The product is not available!");
        }
    }

    @Override
    public Products getProducts() {
        return products;
    }

    @Override
    public Product updateProduct(Product product) {
        long id = product.getId();
        Product productToBeUpdated = products.get(id);
        if(productToBeUpdated != null){
            productToBeUpdated.setLabel(product.getLabel());
            productToBeUpdated.setPrice(product.getPrice());
        }

        return productToBeUpdated;
    }

    @Override
    public boolean deleteProduct(long id) {
        Product productToDelete = products.get(id);
        if (productToDelete != null){
            products.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAllProducts() {
        products.removeAll();
        return true;
    }
}
