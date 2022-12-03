package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {




        private Map<String, Student> Studentmap;
        private Map<String, Teacher> Teachermap;
        private Map<String, List<String>> studteachmap;


        public StudentRepository() {


            this.Studentmap = new HashMap<String, Student>();
            this.Teachermap = new HashMap<String, Teacher>();
            this.studteachmap = new HashMap<String, List<String>>();
        }

        public void saveStudent(Student student) {

            this.Studentmap.put(student.getName(), student);
        }

        public void saveTeacher(Teacher teacher) {

            this.Teachermap.put(teacher.getName(), teacher);
        }

        public void SaveTeacherStudent(String stud, String teach) {
            if (Studentmap.containsKey(stud) && Teachermap.containsKey(teach)) {
                List<String> students = new ArrayList<String>();

                if (studteachmap.containsKey(teach))
                students = studteachmap.get(teach);
               students.add(stud);
               studteachmap.put(teach,students);

            }
        }


     public Student getStudent(String name)
     {

         return Studentmap.get(name);
     }

    public Teacher getTeacher(String name)
    {

        return Teachermap.get(name);
    }

    public List<String> findStudyTeacher(String teacher)
    {
        List<String> lis = new ArrayList<>();
        if (studteachmap.containsKey(teacher))
            lis = studteachmap.get(teacher);
        return lis;
    }



    public List<String> getAllStudents() {

        return new ArrayList<>(Studentmap.keySet());
    }

  public void deleteTeacher(String teacher)
  {
      List<String> studs=new ArrayList<>();
      if(Teachermap.containsKey(teacher))
      {
          studs = studteachmap.get(teacher);
          for (String student : studs)
          {
              if (Studentmap.containsKey(student)){
                  Studentmap.remove(student);
          }
      }

      studteachmap.remove(teacher) ;

  }

      if(Teachermap.containsKey(teacher))
          Teachermap.remove(teacher);
}

  public void deleteAllTeachers()
  {


      HashSet<String> set=new HashSet<String>();

      for (String student : studteachmap.keySet())
      {
          for (String stud : studteachmap.get(student))
          {
              set.add(stud);
          }
      }

      for(String student : set)
      {
          if(Studentmap.containsKey(student))
              Studentmap.remove(student);
      }

  }

}

