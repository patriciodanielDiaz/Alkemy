package alkemy.challenger.Alkemy.controller;

import alkemy.challenger.Alkemy.model.User;
import alkemy.challenger.Alkemy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserById(@PathVariable Long id) {

        Optional<User> user = userService.findById(id);
        if (user.isEmpty()) return new ResponseEntity(HttpStatus.NOT_FOUND);
        userService.deleteUser(user.get());

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/id/{email}")
    public ResponseEntity getUserByEmail (@PathVariable String email){

        Optional<User> u = userService.findByEmail(email);
        if (u.isEmpty()) return new ResponseEntity(HttpStatus.NOT_FOUND);

        return new  ResponseEntity (u, HttpStatus.OK);
    }
}
