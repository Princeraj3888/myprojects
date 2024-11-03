package driver;


import cab.CabDTO;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class DriverDTO {

    private String driverName;

    private String driverEmail;

    private String driverLocation;

    private CabDTO cabDTO;
}
