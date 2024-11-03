package events;

import cab.CabTypes;
import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CabEvents {

    private UUID driverId;
    private String registrationNumber;
    private CabTypes cabTypes;
}
