package com.franquicias.service;
import com.franquicias.dtos.SucursalRequestDto;
import com.franquicias.dtos.SucursalResponseDto;

public interface ISucursalService {
    SucursalResponseDto nuevaSucursal(SucursalRequestDto sucursalRequestDto, Long idFranquicia);

}
