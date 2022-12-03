package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


        @Autowired
        StudentRepository repository;


        public void addStudent(Student student) {

            repository.saveStudent(student);
        }

        public void addTeacher(Teacher teacher) {

            repository.saveTeacher(teacher);
        }

        public void addTeacherStudent(String teach,String stud) {

            repository.SaveTeacherStudent(teach,stud);
        }

    public Student findStudentByName(String student)
    {

        return repository.getStudent(student);
    }


    public Teacher findTeacherByName(String teacher)
    {

        return repository.getTeacher(teacher);
    }

     public List<String> getStudentTeacher(String teach)
    {

        return repository.findStudyTeacher(teach) ;

    }
   public List<String> getAllStudents()
   {
      return repository.getAllStudents();
   }


    public void delTeacherByName(String teacher)
    {

        repository.deleteTeacher(teacher);
    }

    public void dellTeachers()
    {

        repository.deleteAllTeachers();
    }
}