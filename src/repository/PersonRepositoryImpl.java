package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import model.Person;

public class PersonRepositoryImpl implements PersonRepository {
	private static String INSERT_PERSON="insert into person(id,name,surname,birthYear) values(?,?,?,?)";
	private static String UPDATE="update person set name=?,surname=?,birthYear=?  where id = ?  ";
	private static String DELETE="delete from person where id=?";
	private static String ALL_SELECT="select*from person where id=?";
	 private JdbcTemplate jdbcTemplateObject;
	public void setDataSource(DataSource dataSource) {
		jdbcTemplateObject=new JdbcTemplate(dataSource);
	}

	@Override
	public void save(Person p) {
		Object[] insertParams=new Object[] { p.getId(),p.getName(),p.getSurname(),p.getBirthYear()};
		jdbcTemplateObject.update(INSERT_PERSON, insertParams);
		System.out.println("person inserted " + p);
	}

	@Override
	public void update(Person p) {
		Object[] updateParams=new Object[] {p.getName(),p.getSurname(),p.getBirthYear(),p.getId() };
		jdbcTemplateObject.update(UPDATE, updateParams);
		System.out.println("Person is updated . " + p);
		
	}

	@Override
	public void delete(int id) {
		jdbcTemplateObject.update(DELETE, id);
		System.out.println("Person is deleted" + id);
	}

	@Override
	public Person getPersonById(int id) {
		Object[] selectParams=new Object[] {id};
		Person person=jdbcTemplateObject.queryForObject(ALL_SELECT, selectParams,new PersonRowMapper());
		return person;
	}

	@Override
	public List<Person> getAllPersons() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
