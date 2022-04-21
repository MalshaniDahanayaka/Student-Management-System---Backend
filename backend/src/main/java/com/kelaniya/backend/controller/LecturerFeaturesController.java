package com.kelaniya.backend.controller;

import com.kelaniya.backend.entity.Courses;
import com.kelaniya.backend.entity.LecNotes;
import com.kelaniya.backend.repository.AssignmentRepository;
import com.kelaniya.backend.repository.LecNoteRepository;
import com.kelaniya.backend.service.LectureService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public String uploadMultipleFiles(@RequestParam("file") MultipartFile file,@RequestParam("subjectID") String subject,
                                      @RequestParam("description") String description) {

        lectureService.saveFile(file,subject,description);

        return "redirect:/uploadFile";
    }









    //create new course
    @PostMapping("/lectures/new_course/")
    public String addNewCourseModule(@RequestParam("course_id") String courseID,@RequestParam("course_name") String courseName,
                                      @RequestParam("lecturer") String lecturerEmail) {

        lectureService.addNewCourse(courseID,courseName,lecturerEmail);

        return "/lectures/new_course/";
    }







    //delete course module
    @DeleteMapping("/drop/{courseID}")
    public String removeCourseModule(@PathVariable String courseID) throws JSONException {

        String course_id = courseID;
        List<Courses> course = lectureService.getSelectedSubjectDetails(courseID);
        String course_name = course.get(0).getCourse_name();
        String lecture_course_conducted = course.get(0).getLecturer();


        lectureService.deleteCourseModule(courseID);

        String response = new JSONObject()
                .put("course_id", course_id)
                .put("course_name", course_name)
                .put("lecture_course Conducted", lecture_course_conducted)
                .toString();

           return response;
    }








    //add marks and grades for students
    @PostMapping("/add/marks_and_grades/")
    public String addMarksAndGrades(@RequestParam("studentEmail") String student_email, @RequestParam("courseID") String course_id,
                                    @RequestParam("score") double score, @RequestParam("grade") String grade){
        lectureService.addMarksAndGrades(student_email,course_id,score,grade);

        return "/add/marks_and_grade/";
    }








    //update marks and grades
    @PatchMapping("/update/marks_and_grades/")
    public String updateMarksAndGrades(@RequestParam("studentEmail") String student_email, @RequestParam("courseID") String course_id,
                                       @RequestParam("score") double score, @RequestParam("grade") String grade){
        lectureService.updateMarksAndGrades(student_email,course_id,score,grade);
        return "/update/marks_and_grades/";

    }





    //create Announcement
    @PostMapping("/lec/Anouncement/")
    public String makeAnnouncement(@RequestParam("lecturer_email") String lecturer_email,@RequestParam("title") String title,
                                   @RequestParam("body") String body,@RequestParam("category") String category){
        lectureService.addAnnouncement(lecturer_email,title,body,category);

        return "/lec/Anouncement/";
    }






    //add new assignment
    @PostMapping("/lecture/new_assignment/")
    public String addNewAssignment(@RequestParam("subject_id") String subject_id,@RequestParam("assignment_name") String assignment_name,
                                     @RequestParam("assignment_description") String assignment_description,
                                   @RequestParam("final_submit_date") String final_submit_date,@RequestParam("assignment_file") MultipartFile file) {


        lectureService.saveAssignmentFile(subject_id,assignment_name,assignment_description,final_submit_date,file);

        return "/lecture/new_assignment/";
    }

}
