package com.kelaniya.backend.service;

import com.kelaniya.backend.entity.*;
import com.kelaniya.backend.entity.response.CourseResponse;
import com.kelaniya.backend.entity.response.StudentsRecordsResponse;
import com.kelaniya.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LectureService {
    @Autowired
    private LecNoteRepository lecNoteRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentsRecordsRepository studentsRecordsRepository;

    @Autowired
    private AnnouncementRepository announcementRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;




    //upload lecture notes
    public LecNotes saveFile(byte[] data,String subjectID,String description) {

            LecNotes doc = new LecNotes(subjectID,description,data);
            lecNoteRepository.save(doc);
            return doc;

    }






    //get selected file
    public Optional<LecNotes> getFile(String courseID) {

        return lecNoteRepository.findById(courseID);
    }









    //get all uploaded files
    public List<LecNotes> getFiles(){
        return lecNoteRepository.findAll();
    }






    //add new subject
    public Courses addNewCourse(String courseID, String courseName, String  lectureEmail){
        try {
            Courses course = new Courses(courseID,courseName,lectureEmail);
            courseRepository.save(course);
            return course;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    public List<Courses> getSelectedSubjectDetails(String courseID){
        return courseRepository.getDetailsAboutSelectedCourseModule(courseID);
    }








    //delete subject
    public CourseResponse deleteCourseModule(String course_id, String course_name, String lecturer){

         courseRepository.deleteSelectedCourseModule(course_id);

         return new CourseResponse(course_id,course_name,lecturer);

    }






    //add marks and grades
    public StudentsRecords addMarksAndGrades(String student_email,String course_id,double score,String grade){
        try{
            StudentsRecords studentsRecords = new StudentsRecords(student_email,course_id,score,grade);
            studentsRecordsRepository.save(studentsRecords);

            return studentsRecords;


        }catch (Exception e){e.printStackTrace();}

        return null;
    }






    //update students marks and grades
    public StudentsRecordsResponse updateMarksAndGrades(String student_email, String course_id, double score, String grade){

            studentsRecordsRepository.updateMarksAndGrades(student_email,course_id,score,grade);

            return new StudentsRecordsResponse(student_email,course_id,score,grade);

    }




    //make announcement
    public Announcement addAnnouncement(String lecturer_email,String title,String body,String category){
        try{
            Announcement announcement = new Announcement(lecturer_email,title,body,category);
            announcementRepository.save(announcement);
            return announcement;
        }catch(Exception e){e.printStackTrace();}
        return null;
    }





    //upload assignment file and details

    public Assignment saveAssignmentFile(String subject_id, String assignment_name,
                                         String assignment_description, String final_submit_date, byte[] assignment_file) {


        try {
            Assignment assignment = new Assignment(subject_id,assignment_name,assignment_description,final_submit_date,assignment_file);
            assignmentRepository.save(assignment);
            return assignment;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
