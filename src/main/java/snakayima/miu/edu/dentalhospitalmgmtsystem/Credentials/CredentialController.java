package snakayima.miu.edu.dentalhospitalmgmtsystem.Credentials;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CredentialController {

    @GetMapping("/admin")
    public String adminAccess() {
        return "Welcome, Admin!";
    }

    @GetMapping("/user")
    public String userAccess() {
        return "Welcome, User!";
    }

    @GetMapping("/public")
    public String publicAccess() {
        return "This is a public endpoint accessible to anyone.";
    }
}
