package sai_rest_apis.sai;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class Controller {
    @GetMapping
    public String getUsers() {
        return "Hello world";
    }
    
    @PostMapping
    public String postUsers() {
    	return "Post method called";
    }
    
    @PutMapping
    public String putUsers() {
    	return "Put method called";
    }
    
    @DeleteMapping
    public String deleteUsers() {
    	return "Delete method called";
    }
}

