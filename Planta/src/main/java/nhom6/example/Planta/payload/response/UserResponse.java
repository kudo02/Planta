package nhom6.example.Planta.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

	private String name;
	private String phone;
	private String address;
	private String email;
	private String token;
}
