package hello.hellospring;/*이 패키지 하위만 컴포넌트 스캔을 하도록 설정되어 있다.*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {
	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}
}
