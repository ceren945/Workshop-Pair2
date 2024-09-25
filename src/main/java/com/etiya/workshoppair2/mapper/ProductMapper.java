package com.etiya.workshoppair2.mapper;

import com.etiya.workshoppair2.dto.product.*;
import com.etiya.workshoppair2.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    // Target methodIsmi(Source s);
    // Target -> Mapping işleminde elde etmeyi hedeflediğim class
    // Source -> Target'a ulaşmak için kullandığım kaynak.
    // Eğer isimler aynı ise ekstra konfigürasyon gerekmez

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source="categoryId", target = "category.id")
    Product productFromCreateRequest(CreateProductRequest dto);

    CreateProductResponse productFromCreateResponse (Product product);


    Product productFromUpdateRequest(UpdateProductRequest request);

    UpdateProductResponse productFromUpdateResponse(Product product);

    List<GetAllProductResponse> productFromGetAllResponse(List<Product> products);

    GetByIdProductResponse productFromGetByIdResponse(Product product);

    DeleteProductResponse productFromDeleteResponse(Product product);



}
