package com.franquicias.service;

import com.franquicias.dtos.ProductoRequestDto;
import com.franquicias.dtos.ProductoResponseDto;
import com.franquicias.exception.ProductoException;
import com.franquicias.model.entity.Producto;
import com.franquicias.model.entity.Sucursal;
import com.franquicias.repository.ProductoRepository;
import com.franquicias.repository.SucursalRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Transactional

public class ProductoService implements IProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private SucursalRepository sucursalRepository;

    public ProductoResponseDto mapSucursalDto(Producto producto) {
        ProductoResponseDto productoResponseDto = new ProductoResponseDto();
        productoResponseDto.setId(producto.getId());
        productoResponseDto.setNombre(producto.getNombre());
        return productoResponseDto;
    }

    public Producto mapSucursal(ProductoRequestDto productoRequestDto) {
        Producto producto = new Producto();
        producto.setNombre(productoRequestDto.getNombre());
        return producto;
    }

    @Override
    public ProductoResponseDto nuevoProducto(ProductoRequestDto producto, Long idsucursal) {
        Optional<Sucursal> sucursal = sucursalRepository.findById(idsucursal);
        if (sucursal.isPresent()) {
            Sucursal sucursalActual = sucursal.get();
        Optional<Producto> productos = sucursalActual.getProductos().stream().filter(producto1 -> producto1.getNombre().equalsIgnoreCase(producto.getNombre())).findFirst();
            if (productos.isPresent()) {
                 throw new ProductoException("el producto ya existe");
            } else {
                Producto nuevoProducto = this.mapSucursal(producto);
                nuevoProducto.getSucursales().add(sucursalActual);
                sucursalActual.getProductos().add(nuevoProducto);
                Producto save = productoRepository.save(nuevoProducto);
                ProductoResponseDto sucursalrespons = this.mapSucursalDto(save);
                return sucursalrespons;
            }
        }else {
                throw new ProductoException("la sucursal con id " + idsucursal + " no existe");
        }
    }

    /*
    @Override
    public ProductoResponseDto eliminarProducto(ProductoRequestDto producto, Long idSucursal, Long idProducto) {
        Optional<Sucursal> sucursal = sucursalRepository.findById(idSucursal);
        Optional<Producto> productoVigente = productoRepository.findById(idProducto);
        List<Producto> productos = productoRepository.findByNombre(producto.getNombre());
        if(sucursal.isPresent() && productoVigente.isPresent()){


        }
        return null;
    }

     */
}
