package com.kelaniya.backend.controller;

import com.kelaniya.backend.entity.*;
import com.kelaniya.backend.entity.request.*;
import com.kelaniya.backend.entity.response.*;
import com.kelaniya.backend.repository.AssignmentRepository;
import com.kelaniya.backend.repository.LecNoteRepository;
import com.kelaniya.backend.service.LectureService;
import com.kelaniya.backend.utils.data.DataApi;
import com.kelaniya.backend.utils.email.mailgun.SendEmailsToStudents;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@RestController
public class LecturerFeaturesController {


    @Autowired
    private LecNoteRepository lecNoteRepository;

    @Autowired
    private LectureService lectureService;

    @Autowired
    private AssignmentRepository assignmentRepository;


    //get all subject details
    @GetMapping("/api/v1/sub/docs")
    public List<LecNotes> getNotes() {

        return lecNoteRepository.findAll();
    }



    //upload lecture notes
    @PostMapping("/lec_notes/uploadFile")
    public LectureNotesResponse uploadLectureNotes(@RequestPart("subjectName") String subjectName,@RequestPart("description") String description
            ,@RequestPart("academic_year") String academic_year,@RequestPart("file") MultipartFile file) throws Exception {
       LecNotes lecNotes = null;
       String download_URL = "";
       LectureNotesRequestBody lectureNotesRequestBody = new LectureNotesRequestBody(subjectName,description,academic_year
       ,file);
       lecNotes = lectureService.saveFile(lectureNotesRequestBody);


       download_URL = ServletUriComponentsBuilder.fromCurrentContextPath()
               .path("/download/")
               .path(lecNotes.getFile_name())
               .toUriString();

       return new LectureNotesResponse(lecNotes.getSubjectName(),lecNotes.getDescription(),
               lecNotes.getAcademic_year(),lecNotes.getFile_name(),download_URL,lecNotes.getFile_size(),lecNotes.getDate());


    }





    //download file
    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> downloadLectureNoteFile(@PathVariable String fileName) throws Exception {
        LecNotes lecNotes = null;
        lecNotes = lectureService.downloadLectureNote(fileName);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(lecNotes.getFile_type()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + lecNotes.getFile_name()
                                + "\"")
                .body(new ByteArrayResource(lecNotes.getData()));

    }









 //   create new course
    @PostMapping("/lectures/new_course/")
    public Courses addNewCourseModule(@RequestBody CourseRequest courseRequest, HttpServletRequest request) throws JSONException {

        HttpSession session = request.getSession();
        String userEmail = (String) session.getAttribute("userEmail");

        return lectureService.addNewCourse(courseRequest,userEmail);
    }





    //delete course module
    @DeleteMapping("/drop/course/")
    public CourseResponse removeCourseModule(@RequestBody CourseDeleteRequest courseDeleteRequest, HttpServletRequest request) throws JSONException {

        return lectureService.deleteCourseModule(courseDeleteRequest);

    }




    //view lecturer teaching  courses
    @GetMapping("/lecturer/courses")
    public List<Courses> getLecturerTeachingCourses(HttpServletRequest request){

        HttpSession session = request.getSession();
        String userEmail = (String) session.getAttribute("userEmail");

        return lectureService.lecturerTeachingCourses(userEmail);

    }





    //add marks and grades for students
    @PostMapping("/add/marks_and_grades/")
    public StudentsRecords addMarksAndGrades(@RequestBody StudentsRecordsRequest studentsRecordsRequest) throws JSONException {

        return lectureService.addMarksAndGrades(studentsRecordsRequest);

    }




    //update marks and grades
    @PatchMapping("/update/marks_and_grades/")
    public StudentsRecordsResponse updateMarksAndGrades(@RequestBody StudentsRecordsRequest studentsRecordsRequest) throws JSONException {

        return lectureService.updateMarksAndGrades(studentsRecordsRequest.getStudent_email(), studentsRecordsRequest.getCourse_id(),
                studentsRecordsRequest.getScore(), studentsRecordsRequest.getGrade());

    }






    //show enroll students with marks
    @GetMapping("/lecturer/course_marks_and_grades/{course_id}")
    public List<StudentsMarksForLecturer> getSelectedCourseStudentsMarksAndGrades(@PathVariable String course_id) throws SQLException {
        return new DataApi().getData(course_id);
    }









    //create Announcement
    @PostMapping("/lec/create_announcement/")
    public Announcement makeAnnouncement(@RequestBody AnnouncementRequest announcementRequest ,HttpServletRequest request) throws  UnirestException {

        HttpSession session = request.getSession();
        String userEmail = (String) session.getAttribute("userEmail");
        List<StudentsEnrollSubjects> enrollStudents = lectureService.getEnrollStudentsList(announcementRequest.getCategory(),
                announcementRequest.getAcademic_year());
        new SendEmailsToStudents(announcementRequest,userEmail,enrollStudents);


        return lectureService.addAnnouncement(announcementRequest,userEmail);
    }










    //get all announcement for particular lecturer email
    @GetMapping("/lecturer/announcements")
    public List<Announcement> getLecturerTAnnouncements(HttpServletRequest request){

        HttpSession session = request.getSession();
        String userEmail = (String) session.getAttribute("userEmail");

        return lectureService.lecturerAnnouncement(userEmail);

    }






    //delete Announcement
    @DeleteMapping("/lec/delete_announcement/")
    public DeleteAnnouncementResponse deleteAnnouncement(@RequestBody DeleteAnnouncementRequest deleteAnnouncementRequest , HttpServletRequest request) throws JSONException {

        HttpSession session = request.getSession();
        String userEmail = (String) session.getAttribute("userEmail");

        return lectureService.deleteAnnouncement(deleteAnnouncementRequest,userEmail);
    }















    //upload new  assignment
    @PostMapping("/lecture/add_new_assignment")
    public AssignmentResponse uploadNewAssignment(@RequestPart("subject_id") String subject_id,@RequestPart("assignment_name") String assignment_name
            ,@RequestPart("assignment_description") String assignment_description,
                                                  @RequestPart("final_submit_date") String final_submit_date,@RequestPart("file") MultipartFile file) throws Exception {
        Assignment assignment = null;
        String download_URL = "";
        AssignmentRequest assignmentRequest = new AssignmentRequest(subject_id,assignment_name,assignment_description,final_submit_date
                ,file);
        assignment = lectureService.saveAssignmentFile(assignmentRequest);


        download_URL = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(assignment.getFile_name())
                .toUriString();



        return new AssignmentResponse(assignment.getFile_name(),assignment.getSubject_id(),
                assignment.getAssignment_name(),assignment.getAssignment_description(),assignment.getFinal_submit_date(),download_URL,assignment.getFile_size(),assignment.getDate());


    }









    //download assignment file
    @GetMapping("/download/assignment/{fileName}")
    public ResponseEntity<Resource> downloadAssignmentFile(@PathVariable String fileName) throws Exception {
        Assignment assignment = null;
        assignment = lectureService.downloadAssigment(fileName);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(assignment.getFile_type()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + assignment.getFile_name()
                                + "\"")
                .body(new ByteArrayResource(assignment.getData()));

    }



    @GetMapping("/api/v1/lecturer/note-details/{courseName}/{academicYear}")
    public List<LecturerNoteDetailsResponse> getNoteDetails(@PathVariable String courseName, @PathVariable String academicYear) throws SQLException {
      return new DataApi().getLecturerNoteDetails(courseName, academicYear);
    }


}
