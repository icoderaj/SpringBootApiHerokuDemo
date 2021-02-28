package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService{

	//List<Course> list;
	
	
	
	
	
	/*public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Course(100,"Java core course", "contains java basics"));
		list.add(new Course(200,"Java advance course", "contains java advanced"));
		list.add(new Course(300,"C  course", "contains C "));
		list.add(new Course(400,"C++  course", "contains C++ "));
		
	}*/

	@Autowired
	private CourseDao courseDao;

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return courseDao.findAll();
	}



	@Override
	public Course getCourse(long courseId) {
		// TODO Auto-generated method stub
		
		/*Course c = null;
		for(Course course:list)
		{
			if(course.getId()==courseId){
				c = course;
				break;
			}
		}*/
//		return courseDao.getOne(courseId);
		return courseDao.findById(courseId).get();
	}



	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		
		/*list.add(course);*/
		courseDao.save(course);
		return course;
	}



	@Override
	public Course deleteCourse(long courseId) {
		// TODO Auto-generated method stub
		
		/*Course c = null;
		for(Course course:list)
		{
			if(course.getId()==courseId){
				c=course;
				list.remove(course);
				break;
			}
		}*/
		
		Course entity = courseDao.getOne(courseId);
		courseDao.delete(entity);
		return entity;
	}



	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		/*list.forEach(e->
		{if(e.getId()==course.getId())
			{
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
			});*/
		courseDao.save(course);
		
		return course;
	}

}
