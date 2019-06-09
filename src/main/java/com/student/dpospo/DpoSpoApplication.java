package com.student.dpospo;

import com.student.dpospo.model.Student;
import com.student.dpospo.repository.StudentCrudRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class DpoSpoApplication implements ApplicationRunner {

    private StudentCrudRepository repository;

    public static final Student STUDENT_1 = new Student("19-40-0001", "Петя", "Петров",
            "Петрович", "petrov@gmail.com", "+7(401)200-70-60", "+7(900)800-70-60",
            "Английский");
    public static final Student STUDENT_2 = new Student("19-40-0002", "Иван", "Иванов",
            "Иванович", "ivanov@gmail.com", "+7(401)900-80-70", "+7(900)500-40-30",
            "Немецкий");

	public static void main(String[] args) {
		SpringApplication.run(DpoSpoApplication.class, args);
	}

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        repository.save(STUDENT_1);
//        repository.save(STUDENT_2);
    }
}
