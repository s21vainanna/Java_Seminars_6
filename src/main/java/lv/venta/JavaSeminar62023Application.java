package lv.venta;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.models.Course;
import lv.venta.models.Degree;
import lv.venta.models.Grade;
import lv.venta.models.Professor;
import lv.venta.models.Student;
import lv.venta.repos.ICourseRepo;
import lv.venta.repos.IGradeRepo;
import lv.venta.repos.IProfessorRepo;
import lv.venta.repos.IStudentRepo;

@SpringBootApplication
public class JavaSeminar62023Application {


	//TODO create adding functions for both Collections
	//TODO change testModel function to add 2 courses for Zagars and 2 professors for Ekonomika
	
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(JavaSeminar62023Application.class, args);
	}
	
	@Bean
	public CommandLineRunner testModel(IProfessorRepo prRepo, 
			IStudentRepo stRepo, ICourseRepo coRepo, IGradeRepo grRepo) {
		
		
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
			
				
				Professor p1 = new Professor("Juris", "Zagars", Degree.pgh);
				Professor p2 = new Professor("Dmitrijs", "Smirnovs", Degree.pgh);
				Professor p3 = new Professor("Karina", "Skirmante", Degree.mg);
				
				prRepo.save(p1);
				prRepo.save(p2);
				prRepo.save(p3);
				
				Student s1 = new Student("Janis", "Berzins");
				Student s2 = new Student("Baiba", "Kalnina");
				stRepo.save(s1);
				stRepo.save(s2);
				
				
				//TODO one course has to professors
				//TODO one professor has two courses
				Course c1 = new Course("Haosa teorija", 4, new ArrayList<>(Arrays.asList(p1)));
				Course c2 = new Course("Ekonomikas pamati", 2, new ArrayList<>(Arrays.asList(p2)));
				Course c3 = new Course("Dabaszinatnu pamati", 2, new ArrayList<>(Arrays.asList(p1)));
				Course c4 = new Course("Java", 4, new ArrayList<>(Arrays.asList(p2, p3)));
				coRepo.save(c1);
				coRepo.save(c2);
				coRepo.save(c3);
				coRepo.save(c4);
				
				c1.addProfessor(p1);
				c2.addProfessor(p2);
				c3.addProfessor(p1);
				c4.addProfessor(p2);
				c4.addProfessor(p3);
				
				coRepo.save(c1);
				coRepo.save(c2);
				coRepo.save(c3);
				coRepo.save(c4);
				
				
				
				
				grRepo.save(new Grade(5, s1, c1));//Janis got 5 in Haoss
				grRepo.save(new Grade(7, s1, c2));//Janis got 7 in Ekonomika
				grRepo.save(new Grade(10, s2, c1));//Baiba got 10 in Haoss
				grRepo.save(new Grade(8, s2, c2));//Baiba got 8 in Ekonomika
				
			}
		};
		
		
	}

}