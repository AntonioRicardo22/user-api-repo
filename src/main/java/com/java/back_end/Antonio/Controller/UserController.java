package com.java.back_end.Antonio.Controller;

import com.java.back_end.Antonio.Dto.UserDto;
import com.java.back_end.Antonio.Service.UserService;
import com.java.back_end.Antonio.UserApplication;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public String getMensagem(){
        return "SpringBoot is Working!";

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto>getUsers() {
        return userService.findAllUsers();

    }
    @GetMapping("/{cpf}/cpf")
    @ResponseStatus(HttpStatus.OK)
    public UserDto filterByCpf(@PathVariable String cpf){
      return  userService.findByCpf(cpf);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createdUser(@RequestBody @Valid UserDto userDto){
        userDto.setDataCadastro(LocalDateTime.now());
        userService.createdUser(userDto);
        return userDto;
    }

    @DeleteMapping("/{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable String cpf){
       userService.deletedUser(cpf);
    }

    @PatchMapping("update/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto updateUser(@PathVariable String cpf, @RequestBody UserDto userDto){
      return   userService.updatedUser(cpf, userDto);
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> queryByName(@RequestParam (name = "nome" , required = true)String nome){
        return userService.queryByNameLike(nome);
    }

    @GetMapping("/Page")
    public Page<UserDto> allUseresPage(Pageable pageable){
        return  userService.findAllUsersPage(pageable);
    }



     /*
    public static List<UserDto> usuarios = new  ArrayList<UserDto>();


   @PostConstruct
    public void initiateList(){
        UserDto userDto1 = new UserDto();

        userDto1.setName("Eduardo");
        userDto1.setCpf("123");
        userDto1.setEndereço(" Rua a");
        userDto1.setEmail("eduardo@email.com");
        userDto1 .setTelefone("1912-2513");
        userDto1.setDataCadastro(LocalDateTime.now());


        UserDto userDto2 = new UserDto();

        userDto2.setName("luiz");
        userDto2.setCpf("456");
        userDto2.setEndereço(" Rua b");
        userDto2.setEmail("luiz@email.com");
        userDto2 .setTelefone("3263-98741");
        userDto2.setDataCadastro(LocalDateTime.now());


        UserDto userDto3 = new UserDto();

        userDto3.setName("bruna");
        userDto3.setCpf("789");
        userDto3.setEndereço(" Rua c");
        userDto3.setEmail("bruna@email.com");
        userDto3 .setTelefone("3263-98741");
        userDto3.setDataCadastro(LocalDateTime.now());

        usuarios.add(userDto1);
        usuarios.add(userDto2);
        usuarios.add(userDto3);

    }
*/

}
