package com.springboot.demo.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class CoursesHardcodedService {
	private static List<Course> courses = new ArrayList<>();
	private static long idCounter = 0;
	
	static {
		courses.add(new Course(++idCounter, "in28minutes", "ler"));
		courses.add(new Course(++idCounter, "in28minutes", "lhade"));
		courses.add(new Course(++idCounter, "in28minutes", "hei"));
	}
	
	public List<Course> findAll(){
		return courses;
	}
	
	public Course findById(long id) {
		for(Course course : courses) {
			if(course.getId() == id) {
				return course;
			}
		}
		return null;
	}
	
	public Course deleteById(long id) {
		Course course = findById(id);
		if (course == null) {
			return null;
		}
		
		if(courses.remove(course)) {
			return course;
		}
		return null;
	}
	
	public Course save(Course course) {
		if(course.getId() == -1 || course.getId() == 0) {
			course.setId(++idCounter);
			courses.add(course);
		} else {
			deleteById(course.getId());
			courses.add(course);
		}
		return course;
	}
}
