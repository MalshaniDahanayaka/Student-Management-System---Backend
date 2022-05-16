package com.kelaniya.backend.service;

import com.kelaniya.backend.entity.*;
import com.kelaniya.backend.entity.request.*;
import com.kelaniya.backend.entity.response.CourseEnrollStudentsMarksAndGrades;
import com.kelaniya.backend.entity.response.CourseResponse;
import com.kelaniya.backend.entity.response.DeleteAnnouncementResponse;
import com.kelaniya.backend.entity.response.StudentsRecordsResponse;
import com.kelaniya.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import javax.persistence.Id;
import javax.persistence.Lob;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
    private StudentsEnrollSubjectsRepository studentsEnrollSubjectsRepository;

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
            if (file_name.contains("..")) {
                throw new Exception("Filename contains invalid path sequence "
                        + file_name);
            }


            LecNotes lecNotes
                    = new LecNotes(subjectName, description, file_name,
                    file.getContentType(), academicYear,
                    file.getBytes(), file_size, date);
            return lecNoteRepository.save(lecNotes);

        } catch (Exception e) {
            throw new Exception("Could not save File: " + file_name);
        }

    }









    //download lecture notes

    public LecNotes downloadLectureNote(String fileName) throws Exception {
        return lecNoteRepository.findById(fileName).orElseThrow(() -> new Exception("file not found with provide id :" + fileName));
    }









    //add new subject
    public Courses addNewCourse(CourseRequest courseRequest, String userEmail) {
        try {
            Courses course = new Courses(courseRequest.getCourse_id(), courseRequest.getCourse_name(), userEmail,
                    courseRequest.getCourse_description(), courseRequest.getFaculty_name(), courseRequest.getDepartment_name(),
                    courseRequest.getLevel(), courseRequest.getAcademic_year(), courseRequest.getSemester());
            courseRepository.save(course);
            return course;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }









    //delete subject
    public CourseResponse deleteCourseModule(CourseDeleteRequest courseDeleteRequest) {

        courseRepository.deleteSelectedCourseModule(courseDeleteRequest.getCourse_id(), courseDeleteRequest.getAcademic_year());

        return new CourseResponse(courseDeleteRequest.getCourse_id(), courseDeleteRequest.getAcademic_year());

    }









    //add marks and grades
    public StudentsRecords addMarksAndGrades(StudentsRecordsRequest studentsRecordsRequest) {
        try {
            StudentsRecords studentsRecords = new StudentsRecords(studentsRecordsRequest.getStudent_email(), studentsRecordsRequest.getCourse_id(),
                    studentsRecordsRequest.getScore(), studentsRecordsRequest.getGrade());
            studentsRecordsRepository.save(studentsRecords);

            return studentsRecords;


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }










    //update students marks and grades
    public StudentsRecordsResponse updateMarksAndGrades(String student_email, String course_id, double score, String grade) {

        studentsRecordsRepository.updateMarksAndGrades(student_email, course_id, score, grade);

        return new StudentsRecordsResponse(student_email, course_id, score, grade);

    }










    //show lecturer teaching courses
    public List<Courses> lecturerTeachingCourses(String lectureEmail) {
        return courseRepository.getLectureTeachingCourses(lectureEmail);
    }










    //make announcement
    public Announcement addAnnouncement(AnnouncementRequest announcementRequest,String userEmail) {
        try {
            Announcement announcement = new Announcement(userEmail, announcementRequest.getTitle(),
                    announcementRequest.getBody(), announcementRequest.getCategory(), announcementRequest.getAcademic_year());
            announcementRepository.save(announcement);
            return announcement;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //show lecturer added announcements
    public List<Announcement> lecturerAnnouncement(String lecturerEmail) {
        return announcementRepository.getLecturerAnnouncement(lecturerEmail);
    }











    //delete announcement
    public DeleteAnnouncementResponse deleteAnnouncement(DeleteAnnouncementRequest deleteAnnouncementRequest,String userEmail){

        announcementRepository.deleteAnnouncement(userEmail,deleteAnnouncementRequest.getAcademic_year(),
                deleteAnnouncementRequest.getTitle());

        return new DeleteAnnouncementResponse(userEmail,
                deleteAnnouncementRequest.getTitle()
                ,deleteAnnouncementRequest.getAcademic_year());

    }





    //upload assignment
    public Assignment saveAssignmentFile(AssignmentRequest assignmentRequest) throws Exception {


        MultipartFile file = assignmentRequest.getFile();
        String file_name = file.getOriginalFilename();
        long file_size = file.getSize();
        String subjectId = assignmentRequest.getSubject_id();
        String assignmentName = assignmentRequest.getAssignment_name();
        String assignment_description = assignmentRequest.getAssignment_description();
        String finalSubmitDate = assignmentRequest.getFinal_submit_date();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String date = now.toString();
        try {
            if (file_name.contains("..")) {
                throw new Exception("Filename contains invalid path sequence "
                        + file_name);
            }


            Assignment assignment
                    = new Assignment(file_name, subjectId, assignmentName,assignment_description,finalSubmitDate,
                    file.getContentType(), file_size,
                    file.getBytes(), date);
            return assignmentRepository.save(assignment);

        } catch (Exception e) {
            throw new Exception("Could not save File: " + file_name);
        }

    }



    //downlaod assignment file
    public Assignment downloadAssigment(String fileName) throws Exception {
        return assignmentRepository.findById(fileName).orElseThrow(() -> new Exception("file not found with provide id :" + fileName));
    }









    //get course enroll students marks and grades
    public List<CourseEnrollStudentsMarksAndGrades> getEnrollStudentsMarksAndGrades(String course_id){

        return studentsEnrollSubjectsRepository.getEnrollStudentsMarksAndGrades(course_id);
    }







}






