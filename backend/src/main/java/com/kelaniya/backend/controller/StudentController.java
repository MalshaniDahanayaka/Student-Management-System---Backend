package com.kelaniya.backend.controller;

import com.kelaniya.backend.entity.Students;
import com.kelaniya.backend.entity.Users;
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

import java.io.IOException;

@RestController
public class StudentController {

  @Autowired
  private StudentService studentService;


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
  public ResponseEntity<ImageUploadResponse> uploadFile(
          @RequestParam("file") MultipartFile multipartFile)
          throws IOException {

    String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
    long size = multipartFile.getSize();

    String filecode = ImgFileUploadUtil.saveImage(fileName, multipartFile);

    ImageUploadResponse response = new ImageUploadResponse();
    response.setFileName(fileName);
    response.setSize(size);
    response.setImgUploadUrl("/downloadFile/" + filecode);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }


}
