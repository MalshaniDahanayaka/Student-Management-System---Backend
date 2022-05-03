package com.kelaniya.backend.service;

import com.kelaniya.backend.entity.*;
import com.kelaniya.backend.entity.request.CourseDeleteRequest;
import com.kelaniya.backend.entity.request.CourseRequest;
import com.kelaniya.backend.entity.request.LectureNotesRequestBody;
import com.kelaniya.backend.entity.response.CourseResponse;
import com.kelaniya.backend.entity.response.StudentsRecordsResponse;
import com.kelaniya.backend.repository.*;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    public LecNotes saveFile(LectureNotesRequestBody lectureNotesRequestBody) throws Exception {


            MultipartFile file = lectureNotesRequestBody.getFile();
            String file_name = file.getOriginalFilename();
            long file_size = file.getSize();
            String subjectName = lectureNotesRequestBody.getSubjectName();
            String description = lectureNotesRequestBody.getDescription();
            String academicYear = lectureNotesRequestBody.getAcademic_year();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String date = now.toString();
        try {
            if(file_name.contains("..")) {
                throw  new Exception("Filename contains invalid path sequence "
                        + file_name);
            }



            LecNotes lecNotes
                    = new LecNotes(subjectName,description,file_name,
                    file.getContentType(),academicYear,
                    file.getBytes(),file_size,date);
            return lecNoteRepository.save(lecNotes);

        } catch (Exception e) {
            throw new Exception("Could not save File: " + file_name);
        }

    }


    //download lecture notes

    public LecNotes downloadLectureNote(String fileName) throws Exception {
        return lecNoteRepository.findById(fileName).orElseThrow(()->new Exception("file not found with provide id :"+fileName));
    }






    //add new subject
    public Courses addNewCourse(CourseRequest courseRequest,String userEmail){
        try {
            Courses course = new Courses(courseRequest.getCourse_id(),courseRequest.getCourse_name(),userEmail,
                    courseRequest.getCourse_description(),courseRequest.getFaculty_name(),courseRequest.getDepartment_name(),
                    courseRequest.getLevel(),courseRequest.getAcademic_year(),courseRequest.getSemester());
            courseRepository.save(course);
            return course;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }




    //delete subject
    public CourseResponse deleteCourseModule(CourseDeleteRequest courseDeleteRequest){

        courseRepository.deleteSelectedCourseModule(courseDeleteRequest.getCourse_id(),courseDeleteRequest.getAcademic_year());

        return new CourseResponse(courseDeleteRequest.getCourse_id(),courseDeleteRequest.getAcademic_year());

    }








    //get all uploaded files
    public List<LecNotes> getFiles(){
        return lecNoteRepository.findAll();
    }










    public Courses getSelectedSubjectDetails(String courseID){
        return courseRepository.getDetailsAboutSelectedCourseModule(courseID);
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
//    public Announcement addAnnouncement(String lecturer_email,String title,String body,String category){
//        try{
//            Announcement announcement = new Announcement(lecturer_email,title,body,category);
//            announcementRepository.save(announcement);
//            return announcement;
//        }catch(Exception e){e.printStackTrace();}
//        return null;
//    }





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
