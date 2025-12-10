package com.java.back_end.Antonio.Service;

import com.java.back_end.Antonio.Dto.UserDto;
import com.java.back_end.Antonio.Repository.UserRepository;
import com.java.back_end.Antonio.mappers.UserMappers;
import com.java.back_end.Antonio.model.User;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMappers userMappers;
    private final UserRepository userRepository;


    public User createdUser(UserDto userDto){
        User userSave = userMappers.userDtoToUser(userDto);
        userRepository.save(userSave);
        return userSave; // analisar o melhor tipo de objeto para retornar
    }

    public  void deletedUser(String cpf){
        User user = userRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Cadastro não encontrado!"));
        userRepository.delete(user);
    }

    public UserDto findByCpf(String cpf){
        User user = userRepository.findByCpf(cpf).
                orElseThrow(() -> new RuntimeException("Cadastro não encontrado!"));
        return userMappers.userToUserDto(user);
    }

    public List<UserDto> findAllUsers(){
        List<User> allUsers = userRepository.findAll();
        return userMappers.toUsersDtoList(allUsers);
    }

   public UserDto updatedUser(String cpf, UserDto userDto ){
        User entityToUpdated = userRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Cadastro não encontrado!"));
          userMappers.updateUserTarget(userDto,entityToUpdated);
          userRepository.save(entityToUpdated);

          return userMappers.userToUserDto(entityToUpdated);
    }

    public List<UserDto> queryByNameLike(String name){
       List<User> listUser =  userRepository.queryByNameLike(name)
               .orElseThrow(() -> new RuntimeException("Nenhum dado encontrado"));
        return userMappers.toUsersDtoList(listUser);
    }

    public Page<UserDto> findAllUsersPage(Pageable pageable){
        Page<User> allUsers = userRepository.findAll( pageable);
        Page<UserDto> pageUserDto = allUsers.map(userMappers::userToUserDto);
        return pageUserDto;
    }

}
