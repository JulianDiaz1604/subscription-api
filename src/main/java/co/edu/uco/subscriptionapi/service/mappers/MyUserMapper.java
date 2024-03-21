package co.edu.uco.subscriptionapi.service.mappers;

import co.edu.uco.subscriptionapi.domain.user.MyUser;
import co.edu.uco.subscriptionapi.repository.entity.MyUserEntity;

public class MyUserMapper {
    public MyUser toDTO(MyUserEntity userEntity) {

        MyUser userDTO = new MyUser();
        userDTO.setId(userEntity.getId());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setUsername(userEntity.getUsername());
        userDTO.setToken(userEntity.getToken());
        userDTO.setPersonId(userEntity.getPersonId());
        return userDTO;

    }

    public MyUserEntity toEntity(MyUser userDTO) {

        MyUserEntity userEntity = new MyUserEntity();
        userEntity.setId(userDTO.getId());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setToken(userDTO.getToken());
        userEntity.setPersonId(userDTO.getPersonId());
        return userEntity;
    }
}