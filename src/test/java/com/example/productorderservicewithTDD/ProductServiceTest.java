package com.example.productorderservicewithTDD;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class ProductServiceTest {

    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductService();
    }

    @Test
    void 상품등록() {

        final String name = "상품명";
        int price = 1000;
        DiscountPoilicy discountPoilicy = DiscountPoilicy.NONE;
        final AddProductRequest request = new AddProductRequest(name, price, discountPoilicy);
        productService.addProduct(request);

    }

    private class ProductService {
        public void addProduct(AddProductRequest request) {
            throw new UnsupportedOperationException("Unsupported addProduct");
        }
    }
    private record AddProductRequest(String name, int price, DiscountPoilicy discountPoilicy) {
        private AddProductRequest {
            Assert.hasText(name, "상품명은 필수입니다.");
            Assert.isTrue(price > 0, "상품 가격은 0보다 커야 합니다.");
            Assert.notNull(discountPoilicy, "할인 정책은 필수입니다.");
        }

        }
    private enum DiscountPoilicy {
        NONE

    }
}
