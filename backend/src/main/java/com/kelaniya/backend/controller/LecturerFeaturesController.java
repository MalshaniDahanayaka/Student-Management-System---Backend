package com.kelaniya.backend.controller;

import com.kelaniya.backend.entity.*;
import com.kelaniya.backend.entity.request.*;
import com.kelaniya.backend.entity.response.CourseResponse;
import com.kelaniya.backend.entity.response.StudentsRecordsResponse;
import com.kelaniya.backend.repository.AssignmentRepository;
import com.kelaniya.backend.repository.LecNoteRepository;
import com.kelaniya.backend.service.LectureService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public LecNotes uploadMultipleFiles(@RequestBody UploadLectureNoteRequest uploadLectureNoteRequest) throws JSONException {

       return lectureService.saveFile(uploadLectureNoteRequest.getData(),uploadLectureNoteRequest.getSubjectName(),
          uploadLectureNoteRequest.getDescription());

    }









    //create new course
    @PostMapping("/lectures/new_course/")
    public Courses addNewCourseModule(@RequestBody CourseRequest courseRequest, HttpServletRequest request) throws JSONException {

        HttpSession session = request.getSession();
        String userEmail = (String) session.getAttribute("userEmail");


        return lectureService.addNewCourse(courseRequest.getCourse_id(),
                courseRequest.getCourse_name(), courseRequest.getLecturer());

    }







    //delete course module
    @DeleteMapping("/drop/{courseID}")
    public CourseResponse removeCourseModule(@PathVariable String courseID, HttpServletRequest request) throws JSONException {

        String course_id = courseID;
        List<Courses> course = lectureService.getSelectedSubjectDetails(courseID);
        String course_name = course.get(0).getCourse_name();
        String lecture_course_conducted = course.get(0).getLecturer();


        return lectureService.deleteCourseModule(courseID,course_name,lecture_course_conducted);

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





    //create Announcement
    @PostMapping("/lec/Anouncement/")
    public Announcement makeAnnouncement(@RequestBody AnnouncementRequest announcementRequest ,HttpServletRequest request) throws JSONException {

        HttpSession session = request.getSession();
        String userEmail = (String) session.getAttribute("userEmail");


        return lectureService.addAnnouncement(announcementRequest.getLecturer_email(),announcementRequest.getTitle(),
                announcementRequest.getBody(),announcementRequest.getCategory());
    }








    //add new assignment
    @PostMapping("/lecture/new_assignment/")
    public Assignment addNewAssignment(@RequestBody AssignmentRequest assignmentRequest) throws JSONException {


       return lectureService.saveAssignmentFile(assignmentRequest.getSubject_id(),assignmentRequest.getAssignment_name(),
                assignmentRequest.getAssignment_description(),assignmentRequest.getFinal_submit_date(),assignmentRequest.getAssignment_file());




    }

}
