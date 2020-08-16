import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityTest {
    public static void main(String[] args) {
        // @Autowired
        //	private BCryptPasswordEncoder encoder;
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("111111");
        System.out.println(bCryptPasswordEncoder.matches("111111", encode));
    }
}
