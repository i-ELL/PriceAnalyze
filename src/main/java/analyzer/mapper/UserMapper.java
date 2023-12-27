package analyzer.mapper;



import analyzer.domain.dto.UserRegisterDTO;
import analyzer.domain.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.password.PasswordEncoder;
import groovy.lang.Lazy;
import jdk.jfr.Label;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
@Mapper(componentModel = "spring")
public abstract class UserMapper {

    @Autowired
    protected PasswordEncoder passwordEncoder;

//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "password", expression = "java(passwordEncoder.encode(userRegisterDTO.getPassword()))")
//    @Mapping(target = "role", constant = "ROLE_USER")
    public abstract User registerDTOToUser(UserRegisterDTO userRegisterDTO);
}