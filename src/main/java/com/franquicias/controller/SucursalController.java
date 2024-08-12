package com.franquicias.controller;
import com.franquicias.dtos.SucursalRequestDto;
import com.franquicias.dtos.SucursalResponseDto;
import com.franquicias.service.ISucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SucursalController {

    @Autowired
    private ISucursalService sucursalService;

    @RequestMapping(value = "api/franquicia/{id}/sucursal", method = RequestMethod.GET)
    public SucursalResponseDto crearSucursal(@PathVariable("id") Long idFranquicia, @RequestBody SucursalRequestDto sucursalRequestDto){
        return sucursalService.nuevaSucursal(sucursalRequestDto, idFranquicia);
    }

}
