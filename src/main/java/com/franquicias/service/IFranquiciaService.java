package com.franquicias.service;
import com.franquicias.dtos.FranquiciaRequestDto;
import com.franquicias.dtos.FranquinciaResponseDto;

public interface IFranquiciaService {

    FranquinciaResponseDto agregarFranquicia(FranquiciaRequestDto franquiciaDto);

}
