package sai_rest_apis.sai;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/users")
public class Controller {
	
	
	Map<String, RestUser> allUsers = new HashMap<>();

	
    @GetMapping
    public Collection<RestUser> getUsers() {
        return allUsers.values();
    }
    
    @PostMapping
    public String postUsers(@RequestBody RestUser userDetails) {
    	 // Add the new user
        RestUser addValue = new RestUser();
        addValue.setUserId(userDetails.getUserId());
        addValue.setName(userDetails.getName());
        addValue.setEmailId(userDetails.getEmailId());
        allUsers.put(userDetails.getUserId(), addValue);

        return "User added successfully!";
    }
    
    @PutMapping(path = "/{userId}")
    public String putUsers(@PathVariable String userId, @RequestBody RestUser userDetails ) {
    	 
    	if(allUsers.containsKey(userId)) {
    		// Update user
            RestUser addValue = new RestUser();
            addValue.setUserId(userDetails.getUserId());
            addValue.setName(userDetails.getName());
            addValue.setEmailId(userDetails.getEmailId());
            allUsers.put(userId, addValue);
            return "User Updated";
    	}
    	else {
    		return "user not exists";
    	}
    	
    }
    
    @DeleteMapping(path = "/{userId}")
    public String deleteUsers(@PathVariable String userId) {
    	if(allUsers.containsKey(userId)) {
    		allUsers.remove(userId);
    	}
    	else {
    		return "UserId not exists";
    	}
    	return "Delete method called";
    }
}

