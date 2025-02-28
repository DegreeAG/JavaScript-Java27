package com.example.demo.controller;

import com.example.demo.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Product;

import java.util.ArrayList;
import java.util.List;

@RestController

public class ProductController {
    private List<Product> products = new ArrayList<>(List.of(
            new Product("010", "MacBook Air 13 inch M1", "8GB/256GB (MGN63SA/A)", 1769, "Apple"),
            new Product("011", "Laptop Acer Aspire 16 AI", "A16 71M 59L5 Ultra 5 125H/16GB/512GB/Win11 (NX.J4YSV.001)", 1869, "Acer"),
            new Product("012", "Laptop Asus Vivobook 15", "X1504ZA i5 1235U/16GB/512GB/Win11 (NJ1608W)", 1469, "Asus"),
            new Product("013", "Laptop HP 240 G9", "i5 1235U/16GB/512GB/Win11 (AG2J7AT)", 1569, "Asus"),
            new Product("014", "MacBook Air 13 inch M2", "16GB/256GB ", 2469, "Apple")
    ));

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return products;
    }

//1. Lấy thông tin chi tiết của một sản phẩm
//API: GET /products/{id}
//Mô tả: Trả về chi tiết của sản phẩm dựa trên id được cung cấp.

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable String id){
        for(Product product: products){
            if(product.getId().equals(id)){
                return product;
            }
        }
        return null;
    }

//2. Lấy sản phẩm với tên bắt đầu bằng prefix nào đó
//API: GET /products/name-starts/{prefix}
//Mô tả: Trả về danh sách sản phẩm có tên bắt đầu bằng nào đó.

@GetMapping("/products/name-starts/{prefix}")
public ResponseEntity<List<Product>> getProductByPrefix(@PathVariable String prefix){
    List<Product> rs = new ArrayList<>();
    for(Product product: products){
        if(product.getName().toLowerCase().contains(prefix.toLowerCase())){
            rs.add(product);
        }
    }
    return ResponseEntity.ok(rs);
}

//3. Lọc sản phẩm theo khoảng giá
//API: GET /products/price/{min}/{max}
//Mô tả: Trả về danh sách sản phẩm có giá nằm trong khoảng từ min đến max.
@GetMapping("/products/price/minPrice/{min}/maxPrice/{max}")
public ResponseEntity <List<Product>> getProductByPrice(@PathVariable int min, @PathVariable int max){
    List<Product> rs = new ArrayList<>();
    for (Product product: products){
        if(product.getPrice() >= min && product.getPrice() <= max){
            rs.add(product);
        }
    }
    return ResponseEntity.ok(rs);
}

//4. Lấy sản phẩm theo thương hiệu
//API: GET /products/brand/{brand}
//Mô tả: Trả về danh sách sản phẩm thuộc thương hiệu được chỉ định.
@GetMapping("/products/brand/{brand}")
public ResponseEntity <List<Product>> getProductByBrand(@PathVariable String brand){
    List<Product> rs = new ArrayList<>();
    for (Product product: products){
        if (product.getBrand().toLowerCase().contains(brand.toLowerCase())){
            rs.add(product);
        }
    }
    return ResponseEntity.ok(rs);
}

//5. Lấy sản phẩm có giá cao nhất
//API: GET /products/brand/{brand}/max-price
//Mô tả: Trả về sản phẩm có giá cao nhất theo brand được chỉ định.
@GetMapping("/products/brand/{brand}/max-price")
public ResponseEntity<Product> getMaxPriceProductByBrand(@PathVariable String brand) {
    if (products == null || products.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    Product maxPrice = null;
    for (Product product : products) {
        if (product.getBrand().toLowerCase().contains(brand.toLowerCase())) {
            if (maxPrice == null || product.getPrice() > maxPrice.getPrice()) {
                maxPrice = product;
            }
        }
    }

    if (maxPrice == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    return ResponseEntity.ok(maxPrice);
}

}
