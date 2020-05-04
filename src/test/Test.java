package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Person;
import repository.PersonRepository;

public class Test {
public static void main(String[] args) {
	ApplicationContext context=new ClassPathXmlApplicationContext("spring.jdbc.xml");
    PersonRepository repo=context.getBean(PersonRepository.class);
//	Person person=new Person(5, "fatih", "karakas", 1995);
//	repo.save(person);
//	System.out.println("Veritabanına başarıyla kaydedildi .");
	Person person=new Person(7, "berre", "gül", 2007);
	//repo.save(person);
	repo.update(person);
	System.out.println("Güncellendi");
	
	repo.delete(2);
	
	System.out.println(repo.getPersonById(5));
	
}
}
