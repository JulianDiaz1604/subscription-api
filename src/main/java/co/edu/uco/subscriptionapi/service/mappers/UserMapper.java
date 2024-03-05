package co.edu.uco.subscriptionapi.service.mappers;

import co.edu.uco.subscriptionapi.domain.billing.Billing;
import co.edu.uco.subscriptionapi.domain.user.User;
import co.edu.uco.subscriptionapi.repository.entity.BillingEntity;
import co.edu.uco.subscriptionapi.repository.entity.UserEntity;

public class UserMapper {
    public User toDTO(UserEntity userEntity) {

        User userDTO = new User();
        userDTO.setId(userEntity.getId());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setUsername(userEntity.getUsername());
        userDTO.setToken(userEntity.getToken());
        userDTO.setPerson_id(userEntity.getPersonId());
        return userDTO;

    }

    public UserEntity toEntity(User userDTO) {

        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDTO.getId());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setToken(userDTO.getToken());
        userEntity.setPersonId(userDTO.getPerson_id());
        return userEntity;
    }
}