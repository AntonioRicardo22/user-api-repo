package com.java.back_end.Antonio.mappers;


import com.java.back_end.Antonio.Dto.UserDto;
import com.java.back_end.Antonio.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.lang.annotation.Target;
import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface UserMappers {

    User  userDtoToUser(UserDto userDto);

    UserDto userToUserDto (User user);

    List <User> toUserList(List <UserDto> usersdtos);

    List <UserDto> toUsersDtoList (List <User> users);

 //  @Mapping(target = "id", ignore = true)
  // @Mapping(target = "dataCadastro", ignore = true)
   void updateUserTarget(UserDto source, @MappingTarget User target);
}
