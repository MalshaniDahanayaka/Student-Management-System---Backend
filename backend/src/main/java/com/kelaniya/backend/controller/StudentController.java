package com.kelaniya.backend.controller;


import com.kelaniya.backend.entity.*;
import com.kelaniya.backend.entity.request.*;
import com.kelaniya.backend.repository.AnnouncementRepository;
import com.kelaniya.backend.repository.CourseRepository;

import com.kelaniya.backend.repository.LecNoteRepository;
import com.kelaniya.backend.repository.UserRoleRepository;
import com.kelaniya.backend.service.LectureService;
import com.kelaniya.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class StudentController {


  @Autowired
  private StudentService studentService;

  @Autowired
  private LecNoteRepository lecNoteRepository;

  @Autowired
  private CourseRepository courseRepository;

  @Autowired
  private LectureService lectureService;

  @Autowired
  private UserRoleRepository userRoleRepository;

  @Autowired
  private AnnouncementRepository announcementRepository;


  @GetMapping("/api/v1/student")
  @PreAuthorize("hasRole('Student')")
  public String user(){
    return "For Student";
  }

  @PostMapping("/api/v1/student/update-details")
  public Students updateDetails(@RequestBody Students student){
      return studentService.addNewProfile(student);
  }







  //get selected Course details
  @GetMapping("/api/v1/Courses/{courseID}")
  public Courses getSelectedCourse(@PathVariable String courseID ){
    return studentService.getSelectedCourseDetails(courseID);
  }







 // get enrolled courses list
  @GetMapping("/api/v1/Courses/enrolledCourses")
  public List<StudentsEnrollSubjects> getEnrolledCourses(HttpServletRequest request){
    HttpSession session = request.getSession();
    String userEmail = (String) session.getAttribute("userEmail");

    return studentService.getEnrollCourses(userEmail);
  }






  //get department Courses list
  @GetMapping("/api/v1/Courses/department_courses/{department}")
  public List<Courses> getDepartmentCourses(@PathVariable String department){

      return studentService.getUserDepartmentCourseModules(department);
  }









 // @get all Courses list
  @GetMapping("/api/v1/Courses/all")
  public List<Courses> getAllCourses(){
      return studentService.getAllCourses();
  }







  //get course details
    @GetMapping("/api/enrolled_course_details/")
    public List<LecNotes> getCourseLectureNotes(@RequestBody GetLectureNotesRequest getLectureNotesRequest){
      return studentService.getCourseLectureNotes(getLectureNotesRequest.getSubject_name(),getLectureNotesRequest.getAcademic_year());
    }







    //download lecture notes file
    @GetMapping("/download_lecture_notes/{fileName}")
    public ResponseEntity<Resource> downloadLectureNoteFile(@PathVariable String fileName) throws Exception {
        LecNotes lecNotes = null;
        lecNotes = studentService.downloadLectureNote(fileName);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(lecNotes.getFile_type()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + lecNotes.getFile_name()
                                + "\"")
                .body(new ByteArrayResource(lecNotes.getData()));

    }




    //download assignment file
    @GetMapping("/download/course_assignment/{fileName}")
    public ResponseEntity<Resource> downloadAssignmentFile(@PathVariable String fileName) throws Exception {
        Assignment assignment = null;
        assignment = studentService.downloadAssigment(fileName);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(assignment.getFile_type()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + assignment.getFile_name()
                                + "\"")
                .body(new ByteArrayResource(assignment.getData()));

    }





    //Add enrolled course
    @PostMapping("/api/v1/student/enroll-subjects")
    public StudentsEnrollSubjects enrollSubjects(@RequestBody StudentsEnrollSubjects studentsEnrollSubjects){
               StudentsRecordsRequest studentsRecordsRequest = new StudentsRecordsRequest(studentsEnrollSubjects.getStudent_email(),studentsEnrollSubjects.getEnrolled_course_id(), 0.00,"No");
               lectureService.addMarksAndGrades(studentsRecordsRequest);
        return studentService.enrollSubject(studentsEnrollSubjects);
    }


    //unrolled from course
    @DeleteMapping("/api/v1/student/unroll-from-subjects/")
    public UnenrollFromCourse unenrollSubjects(@RequestBody UnenrollFromCourse unenrollFromCourse){
        return studentService.unenrollSubject(unenrollFromCourse);
    }


//    //get announcement
//    @GetMapping("/api/notifications/")
//    public List<Announcement> getNotifications(@RequestBody GetNotificationsRequestBody getNotificationsRequestBody){
//        return studentService.getNotifications(getNotificationsRequestBody);
//  }



    //get students marks and grades
    @GetMapping("/api/student_marks_grades/")
    public List<StudentsRecords> getStudentsMarksAndGrades(HttpServletRequest request){
        HttpSession session = request.getSession();
        String userEmail = (String) session.getAttribute("userEmail");
        return studentService.getStudentsMarksAndGrades(userEmail);
    }


    //Add new student profile
    @PostMapping("/api/v1/student/add-profile")
    public Students addNewProfile(@RequestBody  Students student){
        return studentService.addNewProfile(student);
    }

    //get all students profile
    @GetMapping("/api/v1/student/get-all-profiles")
    public List<Students> getAllProfile(){
      return studentService.getAllProfile();
    }

    @PostMapping("/api/v1/course/announcement")
    public List<Announcement> getAnnouncementForCourse(
            @RequestBody GetAnnouncementForCourseRequest getAnnouncementForCourseRequest){
      return announcementRepository.getAnnouncementForCourse(
              getAnnouncementForCourseRequest.getCategory(), getAnnouncementForCourseRequest.getAcademicYear());
    }
}
