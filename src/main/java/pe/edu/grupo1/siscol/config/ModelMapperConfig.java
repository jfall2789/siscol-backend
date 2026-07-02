package pe.edu.grupo1.siscol.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig { //contendra las configuraciones del contexto

    @Bean //Un Bean es simplemente un objeto cuya creación y ciclo de vida administra el contenedor de Spring.
    public ModelMapper modelMapper() {

        return new ModelMapper();  //SE REGISTRA EL OBJETO DESDE ESE MOMENTO EXISTE

        //Un Bean es simplemente un objeto cuya creación y ciclo de vida administra el contenedor de Spring.

    }
}
