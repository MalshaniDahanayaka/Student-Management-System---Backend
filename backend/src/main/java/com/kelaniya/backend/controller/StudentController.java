package com.kelaniya.backend.controller;

import com.kelaniya.backend.configuration.auth.JwtRequestFilter;
import com.kelaniya.backend.entity.LecNotes;
import com.kelaniya.backend.entity.Students;
import com.kelaniya.backend.entity.StudentsEnrollSubjects;
import com.kelaniya.backend.entity.Users;
import com.kelaniya.backend.repository.LecNoteRepository;
import com.kelaniya.backend.service.LectureService;
import com.kelaniya.backend.service.StudentService;
import com.kelaniya.backend.service.imgServices.ImageUploadResponse;
import com.kelaniya.backend.utils.ImgFileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@RestController
public class StudentController {


  @Autowired
  private StudentService studentService;

  @Autowired
  private LecNoteRepository lecNoteRepository;

  @Autowired
  private LectureService lectureService;


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

  //Add enrolled course
  @PostMapping("/api/v1/student/enroll-subjects")
  public StudentsEnrollSubjects enrollSubjects(@RequestBody StudentsEnrollSubjects studentsEnrollSubjects){
    return studentService.enrollSubject(studentsEnrollSubjects);
  }


  @GetMapping("/api/v1/docs")
  public List<LecNotes> getNotes(HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession();
    String userEmail = (String) session.getAttribute("userEmail");
    //System.out.println(userEmail);
    return lecNoteRepository.findAll();
  }


  @GetMapping("/api/v1/docs/{id}")
  public Optional<LecNotes> getNote(@PathVariable String id) {

    return lecNoteRepository.findById(id);
  }




//    @GetMapping("/downloadFile/{fileId}")
//    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer fileId){
//      LecNotes doc = lectureService.getFile(fileId).get();
//
//      return ResponseEntity.ok()
//              .header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=")
//              .body(new ByteArrayResource(doc.getData()));
//    }


}
