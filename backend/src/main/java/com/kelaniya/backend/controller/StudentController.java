package com.kelaniya.backend.controller;

import com.kelaniya.backend.entity.*;
import com.kelaniya.backend.repository.CourseRepository;
import com.kelaniya.backend.repository.LecNoteRepository;
import com.kelaniya.backend.repository.UserRoleRepository;
import com.kelaniya.backend.service.LectureService;
import com.kelaniya.backend.service.StudentService;
import com.kelaniya.backend.service.imgServices.ImageUploadResponse;
import com.kelaniya.backend.utils.ImgFileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

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




  @GetMapping("/api/v1/student")
  @PreAuthorize("hasRole('Student')")
  public String user(){
    return "For Student";
  }



  @PostMapping("/api/v1/auth/signup-student")
  public Users addUser(@RequestBody Users users){
    return  studentService.signupStudent(users);
  }




  @PostMapping("/api/v1/student/update-details")
  public Students updateDetails(@RequestBody Students student){
      return studentService.updateDetails(student);
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









  @GetMapping("/api/v1/docs/{id}")
  public Optional<LecNotes> getNote(@PathVariable String id) {

    return lecNoteRepository.findById(id);
  }




  @PostMapping("/api/v1/student/update-details/uploadImageFile")
  public ResponseEntity<ImageUploadResponse> uploadFile(@RequestParam("file") MultipartFile multipartFile,
                                                        @RequestParam("description") String description) throws IOException {
    System.out.println(description);

    String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
    System.out.println(fileName);
    long size = multipartFile.getSize();

    String fileCode = ImgFileUploadUtil.saveImage(fileName, multipartFile);


    ImageUploadResponse response = new ImageUploadResponse();
    response.setFileName(fileName);
    response.setSize(size);
    response.setImgUploadUrl("/downloadFile/" + fileCode);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }



}
