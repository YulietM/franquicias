package com.franquicias.service;
import com.franquicias.dtos.FranquiciaRequestDto;
import com.franquicias.dtos.FranquinciaResponseDto;
import com.franquicias.exception.FranquiciaExisteException;
import com.franquicias.model.entity.Franquicia;
import com.franquicias.repository.FranquiciaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@Transactional

public class FranquiciaService implements IFranquiciaService {

    @Autowired
    public FranquiciaRepository franquiciaRepository;

    public FranquinciaResponseDto mapUsuarioToFranquiciaDto(Franquicia franquicia) {
        FranquinciaResponseDto franquiciaRegreso = new FranquinciaResponseDto();
        franquiciaRegreso.setNombreFranquicia(franquicia.getNombreFranquicia());
        return franquiciaRegreso;
    }

    public Franquicia mapUsuarioDtoToFranquicia(FranquiciaRequestDto franquiciaDto) {
        Franquicia franquiciaRegreso = new Franquicia();
        franquiciaRegreso.setNombreFranquicia(franquiciaDto.getNombreFranquicia());
        return franquiciaRegreso;
    }

    @Override
    public FranquinciaResponseDto agregarFranquicia(FranquiciaRequestDto franquiciaDto) {
        List<Franquicia> franquicias = franquiciaRepository.findBynombreFranquicia(franquiciaDto.getNombreFranquicia());
        try{
            if(franquicias.size() == 0){
                Franquicia entity = this.mapUsuarioDtoToFranquicia(franquiciaDto);
                Franquicia save = franquiciaRepository.save(entity);
                FranquinciaResponseDto franquiciaRequestDto = this.mapUsuarioToFranquiciaDto(save);
                return franquiciaRequestDto;
            }else{
                throw new FranquiciaExisteException("la Franquicia ya existe");
            }
        }catch (Exception e){
            throw new FranquiciaExisteException("error creando la franquicia");
        }
    }
}
