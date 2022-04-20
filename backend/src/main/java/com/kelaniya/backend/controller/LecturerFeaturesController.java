package com.kelaniya.backend.controller;

import com.kelaniya.backend.entity.LecNotes;
import com.kelaniya.backend.repository.LecNoteRepository;
import com.kelaniya.backend.service.LectureService;
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
    @PostMapping("/lecture/new_course/")
    public String addNewCourseModule(@RequestParam("course_id") String courseID,@RequestParam("course_name") String courseName,
                                      @RequestParam("lecturer") String lecturerEmail) {

        lectureService.addNewCourse(courseID,courseName,lecturerEmail);

        return "/lecture/new_course/";
    }







    //delete course module
    @DeleteMapping("/drop/{courseID}")
    public String removeCourseModule(@PathVariable String courseID){

        lectureService.deleteCourseModule(courseID);

           return "/drop/{courseID}";
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




}
