package snakayima.miu.edu.dentalhospitalmgmtsystem.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<ApplicationUser, Long> {

    ApplicationUser findByUsername(String username);


}
