package com.kelaniya.backend.service;

import com.kelaniya.backend.entity.Announcement;
import com.kelaniya.backend.entity.Courses;
import com.kelaniya.backend.entity.LecNotes;
import com.kelaniya.backend.entity.StudentsRecords;
import com.kelaniya.backend.repository.AnnouncementRepository;
import com.kelaniya.backend.repository.CourseRepository;
import com.kelaniya.backend.repository.LecNoteRepository;
import com.kelaniya.backend.repository.StudentsRecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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




    //Save uploaded file
    public LecNotes saveFile(MultipartFile file,String subjectID,String description) {
        String docname = file.getOriginalFilename();
        try {
            LecNotes doc = new LecNotes(subjectID,description,file.getBytes(),file.getContentType());
            return lecNoteRepository.save(doc);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }






    //get selected file
    public Optional<LecNotes> getFile(Integer fileId) {

        return lecNoteRepository.findById(fileId);
    }









    //get all uploaded files
    public List<LecNotes> getFiles(){
        return lecNoteRepository.findAll();
    }






    //add new subject
    public Courses addNewCourse(String courseID,String courseName,String  lectureEmail){
        try {
            Courses course = new Courses(courseID,courseName,lectureEmail);
            return courseRepository.save(course);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }








    //delete subject
    public int deleteCourseModule(String courseID){

        return courseRepository.deleteSelectedCourseModule(courseID);
    }






    //add marks and grades
    public StudentsRecords addMarksAndGrades(String student_email,String course_id,double score,String grade){
        try{
            StudentsRecords studentsRecords = new StudentsRecords(student_email,course_id,score,grade);
            return studentsRecordsRepository.save(studentsRecords);
        }catch (Exception e){e.printStackTrace();}

        return null;
    }






    //update students marks and grades
    public int updateMarksAndGrades(String student_email,String course_id,double score,String grade){
        try{
            return studentsRecordsRepository.updateMarksAndGrades(student_email,course_id,score,grade);
        }catch (Exception e){e.printStackTrace();}
        return 0;
    }




    //make announcement
    public Announcement addAnnouncement(String lecturer_email,String title,String body,String category){
        try{
            Announcement announcement = new Announcement(lecturer_email,title,body,category);
            return announcementRepository.save(announcement);
        }catch(Exception e){e.printStackTrace();}
        return null;
    }
}
