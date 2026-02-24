package com.arka.market.persistence;

import com.arka.market.domain.dto.ProductDTO;
import com.arka.market.domain.repository.ProductDTORepository;
import com.arka.market.persistence.crud.ProductCRUDRepository;
import com.arka.market.persistence.entity.Product;
import com.arka.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements ProductDTORepository {
    private final ProductCRUDRepository productCRUDRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductRepository(ProductCRUDRepository productCRUDRepository, ProductMapper productMapper) {
        this.productCRUDRepository = productCRUDRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDTO> getAll() {
        List<Product> products = (List<Product>) productCRUDRepository.findAll();
        return productMapper.toProductsDTO(products);
    }

    @Override
    public Optional<List<ProductDTO>> getByCategory(int categoryId) {
        List<Product> products = productCRUDRepository.findByCategory_IdCategoryOrderByNameAsc(categoryId);
        // Si el mapper devuelve List<ProductDTO>, esto funcionará correctamente
        return Optional.of(productMapper.toProductsDTO(products));
    }

    @Override
    public Optional<List<ProductDTO>> getScarseProducts(int quantity) {
        // 2. Uso de .map() para manejar el Optional de forma más limpia
        return productCRUDRepository.findBystockLessThanAndStatus(quantity, true)
                .map(products -> productMapper.toProductsDTO(products));
    }

    @Override
    public Optional<ProductDTO> getProduct(int productId) {
        return productCRUDRepository.findById(productId)
                .map(product -> productMapper.toProductDTO(product));
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product productToSave = productMapper.toProduct(productDTO);
        return productMapper.toProductDTO(productCRUDRepository.save(productToSave));
    }

    @Override
    public void delete(int productId) {
        productCRUDRepository.deleteById(productId);
    }
}