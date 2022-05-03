package com.kelaniya.backend.controller;

import com.kelaniya.backend.entity.*;
import com.kelaniya.backend.entity.request.*;
import com.kelaniya.backend.entity.response.CourseResponse;
import com.kelaniya.backend.entity.response.LectureNotesResponse;
import com.kelaniya.backend.entity.response.StudentsRecordsResponse;
import com.kelaniya.backend.repository.AssignmentRepository;
import com.kelaniya.backend.repository.LecNoteRepository;
import com.kelaniya.backend.service.LectureService;
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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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








    //add marks and grades for students
    @PostMapping("/add/marks_and_grades/")
    public StudentsRecords addMarksAndGrades(@RequestBody StudentsRecordsRequest studentsRecordsRequest) throws JSONException {

        return lectureService.addMarksAndGrades(studentsRecordsRequest.getStudent_email(), studentsRecordsRequest.getCourse_id(),
                studentsRecordsRequest.getScore(), studentsRecordsRequest.getGrade());

    }








    //update marks and grades
    @PatchMapping("/update/marks_and_grades/")
    public StudentsRecordsResponse updateMarksAndGrades(@RequestBody StudentsRecordsRequest studentsRecordsRequest) throws JSONException {

        return lectureService.updateMarksAndGrades(studentsRecordsRequest.getStudent_email(), studentsRecordsRequest.getCourse_id(),
                studentsRecordsRequest.getScore(), studentsRecordsRequest.getGrade());

    }





//    //create Announcement
//    @PostMapping("/lec/Anouncement/")
//    public Announcement makeAnnouncement(@RequestBody AnnouncementRequest announcementRequest ,HttpServletRequest request) throws JSONException {
//
//        HttpSession session = request.getSession();
//        String userEmail = (String) session.getAttribute("userEmail");
//
//
//        return lectureService.addAnnouncement(announcementRequest.getLecturer_email(),announcementRequest.getTitle(),
//                announcementRequest.getBody(),announcementRequest.getCategory());
//    }








    //add new assignment
    @PostMapping("/lecture/new_assignment/")
    public Assignment addNewAssignment(@RequestBody AssignmentRequest assignmentRequest) throws JSONException {


       return lectureService.saveAssignmentFile(assignmentRequest.getSubject_id(),assignmentRequest.getAssignment_name(),
                assignmentRequest.getAssignment_description(),assignmentRequest.getFinal_submit_date(),assignmentRequest.getAssignment_file());




    }

}
