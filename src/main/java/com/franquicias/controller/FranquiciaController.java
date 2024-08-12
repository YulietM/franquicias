package com.franquicias.controller;
import com.franquicias.dtos.FranquiciaRequestDto;
import com.franquicias.dtos.FranquinciaResponseDto;
import com.franquicias.service.IFranquiciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FranquiciaController {

    @Autowired
    private IFranquiciaService franquiciaService;

    @RequestMapping(value = "api/crearFranquicia", method = RequestMethod.POST)
    public FranquinciaResponseDto crearFranquicia(@RequestBody FranquiciaRequestDto franquiciaDto) {
        return franquiciaService.agregarFranquicia(franquiciaDto);
    }
}
