package com.kelaniya.backend.service;


import com.kelaniya.backend.entity.*;
import com.kelaniya.backend.entity.request.GetNotificationsRequestBody;
import com.kelaniya.backend.entity.request.UnenrollFromCourse;
import com.kelaniya.backend.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StudentService {
  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private CourseRepository courseRepository;

  @Autowired
  private StudentsEnrollSubjectsRepository studentsEnrollSubjectsRepository;

  @Autowired
  private LecNoteRepository lecNoteRepository;

  @Autowired
  private AssignmentRepository assignmentRepository;

  @Autowired
  private AnnouncementRepository announcementRepository;

  @Autowired
  private StudentsRecordsRepository studentsRecordsRepository;



  public Students addNewProfile(Students student) {
    return studentRepository.save(student);
  }




  public Courses getSelectedCourseDetails(String courseID){

    return courseRepository.getDetailsAboutSelectedCourseModule(courseID);

  }




  public List<StudentsEnrollSubjects> getEnrollCourses(String userEmail){

    return studentsEnrollSubjectsRepository.getStudentEnrollSubjects(userEmail);

  }


  public List<Courses> getUserDepartmentCourseModules(String departmentName){
    return courseRepository.getUserDepartmentCourseModules(departmentName);
  }

  public List<Courses> getAllCourses(){
    return courseRepository.findAll();
  }


  public List<LecNotes> getCourseLectureNotes(String courseID,String academicYear){
    return lecNoteRepository.getSelectedCourseLecNotes(courseID,academicYear);
  }



  //download lecture notes

  public LecNotes downloadLectureNote(String fileName) throws Exception {
    return lecNoteRepository.findById(fileName).orElseThrow(() -> new Exception("file not found with provide id :" + fileName));
  }



  //downlaod assignment file
  public Assignment downloadAssigment(String fileName) throws Exception {
    return assignmentRepository.findById(fileName).orElseThrow(() -> new Exception("file not found with provide id :" + fileName));
  }





  //enroll new subject
  public StudentsEnrollSubjects enrollSubject(StudentsEnrollSubjects studentsEnrollSubjects){
    return  studentsEnrollSubjectsRepository.save(studentsEnrollSubjects);
  }


  //unenroll new subject
  public UnenrollFromCourse unenrollSubject(UnenrollFromCourse unenrollFromCourse){
     studentsEnrollSubjectsRepository.unenrollFromCourse(unenrollFromCourse.getEnrolled_course_id(),unenrollFromCourse.getStudent_email());
     return unenrollFromCourse;
  }


//  //get notifications
//  public List<Announcement> getNotifications(GetNotificationsRequestBody getNotificationsRequestBody){
//    return announcementRepository.getAnnouncement(getNotificationsRequestBody.getDepartment_name(),
//            getNotificationsRequestBody.getFaculty_name(),getNotificationsRequestBody.getAcademic_year(),"all");
//  }


  public List<StudentsRecords> getStudentsMarksAndGrades(String userEmail){
    return studentsRecordsRepository.getStudentMarksAndGrades(userEmail);
  }

  public List<Students> getAllProfile(){
    return studentRepository.findAll();
  }

}
