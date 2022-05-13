package com.kelaniya.backend.service;

import com.kelaniya.backend.entity.*;
import com.kelaniya.backend.entity.request.SignupRequest;
import com.kelaniya.backend.entity.response.OtpResponse;
import com.kelaniya.backend.repository.*;
import com.kelaniya.backend.utils.email.GmailSMTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private UserRoleRepository userRoleRepository;

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private LecturerRepository lecturerRepository;

  public void initUserRolesAndAdmin(){

    // create lecturer role
    Role lecturerRole = new Role();
    lecturerRole.setRoleName("Lecturer");
    lecturerRole.setRoleDescription("Lecturer role");
    roleRepository.save(lecturerRole);

    // create student role
    Role studentRole = new Role();
    studentRole.setRoleName("Student");
    studentRole.setRoleDescription("Student role");
    roleRepository.save(studentRole);

    // create lecture user
    Users lecture = new Users();
    lecture.setUsername("lecture1@kln.ac.lk");
    lecture.setPassword(getEncodePassword("lecture123"));
    Set<Role> lectureUserRoles = new HashSet<>();
    lectureUserRoles.add(lecturerRole);
    lecture.setRole(lectureUserRoles);
    userRepository.save(lecture);

    // create student user
    Users student = new Users();
    student.setUsername("student1@kln.ac.lk");
    student.setPassword(getEncodePassword("student123"));
    Set<Role> studentUserRoles = new HashSet<>();
    studentUserRoles.add(studentRole);
    student.setRole(studentUserRoles);
    userRepository.save(student);
  }

  public String getEncodePassword(String password) {
    return passwordEncoder.encode(password);
  }

  public Optional<UsersRole> getUserRole(String userEmail){
    return userRoleRepository.findById(userEmail);
  }

  public Students getUserStudentDetails(String std_email){
    return studentRepository.getUserStudentDetails(std_email);
  }

  public OtpResponse verifyUserEmail(String user_email){
    int min = 1000;
    int max = 9999;

    // generate random number
    int otp = (int)(Math.random()*(max-min+1)+min);

    // send otp via email
    GmailSMTP gmailSMTP = new GmailSMTP(user_email, otp);
    gmailSMTP.start();

    OtpResponse otpResponse = new OtpResponse();
    otpResponse.setEmail(user_email);
    otpResponse.setOtp(otp);
    return otpResponse;
  }

  public Users signup(SignupRequest signupRequest){
    Role userRole = null;
    System.out.println(signupRequest.getPassword());
    if(Objects.equals(signupRequest.getRole(), "Student")){
      Students student = new Students();
      student.setFirst_name(signupRequest.getFirstName());
      student.setLast_name(signupRequest.getLastName());
      student.setStudent_id(signupRequest.getId());
      student.setStudent_email(signupRequest.getEmail());
      student.setDepartment(signupRequest.getDepartment());
      student.setProfile_pic(signupRequest.getProfilePic());

      studentRepository.save(student);

      userRole = roleRepository.findById("Student").get();
    }

    if(Objects.equals(signupRequest.getRole(), "Lecturer")){
      Lecturers lecturer = new Lecturers();
      lecturer.setLecturer_email(signupRequest.getEmail());
      lecturer.setFirst_name(signupRequest.getFirstName());
      lecturer.setLast_name(signupRequest.getLastName());
      lecturer.setDepartment(signupRequest.getDepartment());
      lecturer.setProfile_pic(signupRequest.getProfilePic());

      lecturerRepository.save(lecturer);

      userRole = roleRepository.findById("Lecturer").get();

    }
    Users user = new Users();

    user.setUsername(signupRequest.getEmail());

    // set user role
    Set<Role> roles = new HashSet<>();
    roles.add(userRole);
    user.setRole(roles);

    user.setPassword(getEncodePassword((signupRequest.getPassword())));;
    return userRepository.save(user);
  }
}
