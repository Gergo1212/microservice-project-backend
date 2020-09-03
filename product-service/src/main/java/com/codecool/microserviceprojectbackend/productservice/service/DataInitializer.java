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
                        .name("USB Typewriter")
                        .category("Electronics")
                        .description("The weighty feel of the springloaded keys, the motor-car styling, and the beautiful marks they print on the page all make for a rich writing experience that can make writer’s block melt away.")
                        .price(new BigDecimal(10))
                        .userId(1L)
                        .imageUrl("https://s3.amazonaws.com/noupe/trans/wp-content/uploads/2010/09/unusualphotos11.jpg")
                        .build()
        );

        productDao.addProduct(
                Product.builder()
                        .name("Bizarre Floating Phone Helmet")
                        .category("Electronics")
                        .description("The Isophone – an underwater telephone system means you can communicate with other swimmers while splashing around in the pool.")
                        .price(new BigDecimal(60))
                        .userId(1L)
                        .imageUrl("https://s3.amazonaws.com/noupe/trans/wp-content/uploads/2010/09/unusualphotos18.jpg")
                        .build()
        );

        productDao.addProduct(
                Product.builder()
                        .name("Rejuvenique Face Mask")
                        .category("Beauty Products")
                        .description("This creepy mask was intended to tighten facial muscles with... shock therapy. Consumers revealed that it feels as bad as it sounds.")
                        .price(new BigDecimal(20))
                        .userId(2L)
                        .imageUrl("https://static.boredpanda.com/blog/wp-content/uploads/2018/07/failed-products-innovations-technology-5b4765aad9b16__700.jpg")
                        .build()
        );

    }

}
