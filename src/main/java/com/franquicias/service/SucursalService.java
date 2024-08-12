package com.franquicias.service;
import com.franquicias.dtos.SucursalRequestDto;
import com.franquicias.dtos.SucursalResponseDto;
import com.franquicias.exception.FranquiciaNoExiste;
import com.franquicias.model.entity.Franquicia;
import com.franquicias.model.entity.Sucursal;
import com.franquicias.repository.FranquiciaRepository;
import com.franquicias.repository.SucursalRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
@Transactional

public class SucursalService implements ISucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    @Autowired //inyectar la dependencia
    private FranquiciaRepository franquiciaRepository;


    public SucursalResponseDto mapSucursalToRequestDto(Sucursal sucursal) {
        SucursalResponseDto sucursalDto = new SucursalResponseDto();
        sucursalDto.setId(sucursal.getId());
        sucursalDto.setNombre(sucursal.getNombre());
        return sucursalDto;
    }

    public Sucursal mapRequestDtoToSucursal(SucursalRequestDto sucursalRequestDto) {
        Sucursal sucursal = new Sucursal();
        sucursal.setNombre(sucursalRequestDto.getNombre());
        return sucursal;
    }

    @Override
    public SucursalResponseDto nuevaSucursal(SucursalRequestDto requestDto, Long idFranquicia) {
        Optional<Franquicia> franquicia = franquiciaRepository.findById(idFranquicia);
        if(franquicia.isPresent()){
            Sucursal sucursal = this.mapRequestDtoToSucursal(requestDto);
            Sucursal save = sucursalRepository.save(sucursal);
            SucursalResponseDto sucursalRes = this.mapSucursalToRequestDto(save);
            return sucursalRes;
        }else{
            throw new FranquiciaNoExiste("No exite la franquicia");
        }
    }
}
