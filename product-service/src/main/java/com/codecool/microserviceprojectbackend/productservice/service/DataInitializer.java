package com.codecool.microserviceprojectbackend.productservice.service;

import com.codecool.microserviceprojectbackend.productservice.dao.ProductDao;
import com.codecool.microserviceprojectbackend.productservice.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class DataInitializer {

    private ProductDao productDao;

    @PostConstruct
    public void init() {
        productDao.addProduct(
                Product.builder()
                        .name("BMW")
                        .category("car")
                        .description("This is a very good car.")
                        .price(new BigDecimal(2000))
                        .userId(1L)
                        .imageUrl("https://images.ctfassets.net/ro7z507xvlp4/4dT8bB4V612jeKhfuD3JlY/8b9c5980d9348449a6388103eecc561a/column_cgi_0019_bmw_1er_f40.png?q=80&fm=png")
                        .build()
        );

        productDao.addProduct(
                Product.builder()
                        .name("Old car")
                        .category("car")
                        .description("This is an old car but it still works.")
                        .price(new BigDecimal(500))
                        .userId(1L)
                        .imageUrl("https://i0.wp.com/write.co.nz/wp-content/uploads/2017/12/broken-car-vintage.jpg?fit=640%2C426&ssl=1")
                        .build()
        );

        productDao.addProduct(
                Product.builder()
                        .name("Old table")
                        .category("furniture")
                        .description("This is my old table.")
                        .price(new BigDecimal(8000))
                        .userId(2L)
                        .imageUrl("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.turbosquid.com%2F3d-models%2Fold-table-3d-model-1219085&psig=AOvVaw3mbVPEVgaZGMQJkdB4pYe0&ust=1599232760805000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCKjJgb2lzesCFQAAAAAdAAAAABAD")
                        .build()
        );

    }

}
