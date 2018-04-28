package com.github.ajanthan.tracing.spring.data.tracingdemodata.repo;

import com.github.ajanthan.tracing.spring.data.tracingdemodata.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductDataLoader implements ApplicationRunner {
    @Autowired
    private ProductRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        addProduct(repository, "Chair", 65.15, "Chair for living room", new String[]{ "furniture", "living" });
        addProduct(repository, "Sun Glass", 34.69, "Summer sun glass", new String[]{ "clothe", "fashion" });
        addProduct(repository, "Hat", 30.50, "Hat for men", new String[]{ "clothes", "fashion" });
        addProduct(repository, "Running Shoe", 69.90, "Durable running shoe", new String[]{ "clothe", "sport" });
        addProduct(repository, "Watch", 55.50, "Watch for men", new String[]{ "clothe", "fashion" });
    }

    private void addProduct(ProductRepository repository, String name, double price, String description, String[] tags) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        product.setTags(tags);
        repository.save(product);
    }
}
