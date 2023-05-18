package lv.venta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lv.venta.models.Degree;
import lv.venta.repos.ICourseRepo;
import lv.venta.repos.IGradeRepo;
import lv.venta.repos.IProfessorRepo;
import lv.venta.repos.IStudentRepo;

@SpringBootApplication
public class JavaSeminar62023Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaSeminar62023Application.class, args);
	}
	
	//@Bean
	public CommandLineRunner testModel(IProfessorRepo prRepo,
			IStudentRepo stRepo, ICourseRepo coRepo, IGradeRepo grRepo) {
		
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				
				Professor p1 = new Professor("Juris", "Zagars", Degree.pgh);
				Professor p2 = new Professor("Dmitrijs", "Smirnovs", Degree.pgh);
				prRepo.save(p1);
				prRepo.save(p2);
				
				Student s1 = new Student("Janis", "Berzins");
				Student s2 = new Student("Baiba", "Kalnina");
				stRepo.save(s1);
				stRepo.save(s2);
				
				Course c1 = new Course("Haosa teorija", 4, p1);
				Course c2 = new Course("Ekonomikas pamati", 2, p2);
				coRepo.save(c1);
				coRepo.save(c2);
				
				//Grade gr1 = new Grade(5, s1, c1);//Janis got 5 in Haoss
				grRepo.save(new Grade(5, s1, c1);//Janis got 5 in Haoss
				grRepo.save(new Grade(5, s1, c1);//Janis got 5 in Haoss
				grRepo.save(new Grade(5, s1, c1);//Janis got 5 in Haoss
				grRepo.save(new Grade(5, s1, c1);//Janis got 5 in Haoss
			}
		};
	}

}
