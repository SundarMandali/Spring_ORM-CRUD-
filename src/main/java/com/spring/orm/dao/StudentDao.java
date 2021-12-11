package com.spring.orm.dao;



import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.entities.Student;

public class StudentDao {
private HibernateTemplate hibernateTemplate;

//save Student
@Transactional
public int insert(Student student)
{
	
	Integer i=(Integer)this.hibernateTemplate.save(student);
	return i;
	
}

//get one student object
public Student getStudent(int studentId)
{
	Student obj=this.hibernateTemplate.get(Student.class, studentId);
	return obj;
}

//get all student objects
public List<Student> getAllStudents()
{
	List<Student> students=this.hibernateTemplate.loadAll(Student.class);
	return students;
}
public HibernateTemplate getHibernateTemplate() {
	return hibernateTemplate;
}

//delete the student object
@Transactional
public void deleteStudent(int studentId)
{
	Student obj=this.hibernateTemplate.get(Student.class,studentId);
	this.hibernateTemplate.delete(obj);
}

//update the Student
@Transactional
public void updateStudent(Student student)
{
	this.hibernateTemplate.update(student);
}
public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	this.hibernateTemplate = hibernateTemplate;
}

}
