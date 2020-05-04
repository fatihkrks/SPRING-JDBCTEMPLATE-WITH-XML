package repository;

import java.util.List;

import model.Person;

public interface PersonRepository {
	public void save(Person p);

	public void update(Person p);
	
	public void delete(int id);
	
	public Person getPersonById(int id);
	
	public List<Person> getAllPersons();
}
