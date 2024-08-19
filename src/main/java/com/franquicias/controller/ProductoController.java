package com.franquicias.controller;
import com.franquicias.dtos.ProductoRequestDto;
import com.franquicias.dtos.ProductoResponseDto;
import com.franquicias.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @RequestMapping(value = "api/sucursal/{id}/producto", method = RequestMethod.POST)
    public ProductoResponseDto agregarProducto(@PathVariable("id") Long idSucursal, @RequestBody ProductoRequestDto productoRequestDto){
        return productoService.nuevoProducto(productoRequestDto, idSucursal);
    }

    /*
    @RequestMapping(value = "api/sucursal/{id}/producto/{id}", method = RequestMethod.DELETE)
    public ProductoResponseDto eliminarProducti(@PathVariable("id") Long idSucursal, @PathVariable("id") Long idProducto, @RequestBody ProductoRequestDto productoRequestDto){
        return productoService.eliminarProducto(productoRequestDto, idSucursal, idProducto);
    }*/
}
