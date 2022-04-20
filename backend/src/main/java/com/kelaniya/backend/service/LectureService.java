package com.kelaniya.backend.service;

import com.kelaniya.backend.entity.Courses;
import com.kelaniya.backend.entity.LecNotes;
import com.kelaniya.backend.repository.CourseRepository;
import com.kelaniya.backend.repository.LecNoteRepository;
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
}
