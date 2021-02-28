package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

@RestController
public class MyController {
	
	@Autowired
	private CourseService courseService;

@GetMapping("/home")
	public String home(){
		return "Welcome to MY course application"; 
	}


//get all the courses
//@GetMapping("/courses")
@RequestMapping(path="/courses", method=RequestMethod.GET)
public List<Course> getCourses()
{
	return this.courseService.getCourses();
	
}

//single course get
@GetMapping("/courses/{courseId}")
public Course getCourse(@PathVariable String courseId){
	
	return this.courseService.getCourse(Long.parseLong(courseId));
}

//add 1 course
//@PostMapping(path="/courses", consumes="application/json")
@PostMapping("/courses")
public Course addCourse(@RequestBody Course course){
	return this.courseService.addCourse(course);
}

//update the course
@PutMapping("/courses")
public Course updateCourse(@RequestBody Course course){
	return this.courseService.updateCourse(course);
}

//delete the course
/*@DeleteMapping("/courses/{courseId}")
public Course deleteCourse(@PathVariable String courseId){
	return this.courseService.deleteCourse(Long.parseLong(courseId));
}
*/
@DeleteMapping("/courses/{courseId}")
public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
	try{
		this.courseService.deleteCourse(Long.parseLong(courseId));
		return new ResponseEntity<>(HttpStatus.OK);
	} catch(Exception e){
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}





}