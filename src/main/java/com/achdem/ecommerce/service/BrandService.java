package com.achdem.ecommerce.service;

import com.achdem.ecommerce.entity.Brand;
import com.achdem.ecommerce.exception.ResourceNotFoundException;
import com.achdem.ecommerce.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public Brand getById(Long id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Brand not found"));
    }

    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    public Brand create(Brand brand) {
        return brandRepository.save(brand);
    }

    public Brand update(Long id, Brand updated) {
        Brand brand = getById(id);
        brand.setName(updated.getName());
        return brandRepository.save(brand);
    }

    public void delete(Long id) {
        if (!brandRepository.existsById(id)) {
            throw new ResourceNotFoundException("Brand not found");
        }
        brandRepository.deleteById(id);
    }
}