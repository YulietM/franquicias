package com.franquicias.service;
import com.franquicias.dtos.ProductoRequestDto;
import com.franquicias.dtos.ProductoResponseDto;

public interface IProductoService {

    ProductoResponseDto nuevoProducto(ProductoRequestDto producto, Long idsucursal);
    //ProductoResponseDto eliminarProducto(ProductoRequestDto producto, Long idsucursal, Long idproducto);

}
