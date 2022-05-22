package com.kelaniya.backend.utils.data;

import com.kelaniya.backend.entity.response.LectureNotesResponse;
import com.kelaniya.backend.entity.response.LecturerNoteDetailsResponse;
import com.kelaniya.backend.entity.response.StudentsMarksForLecturer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataApi {

    public List<StudentsMarksForLecturer> getData(String courseID) throws SQLException {
        Connection connection = new DataRetriever().getDatabaseConnection();
        List stdList = new ArrayList<StudentsMarksForLecturer>();



        String sql = "SELECT students.student_email, students.student_id,students.first_name,students.last_name,students_records.course_id, students_records.score, students_records.grade\n" +
                "    FROM students_records\n" +
                "    INNER JOIN students ON students_records.student_email=students.student_email WHERE students_records.course_id = ?";


        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, courseID);
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
           StudentsMarksForLecturer studentsMarksForLecturer = new StudentsMarksForLecturer(
                   rs.getString("student_email"),
                   rs.getString("student_id"),
                   rs.getString("first_name"),
                   rs.getString("last_name"),
                   rs.getString("course_id"),
                   rs.getDouble("score"),
                   rs.getString("grade")
           );

           stdList.add(studentsMarksForLecturer);

        }

        return stdList;
    }

  public List<LecturerNoteDetailsResponse> getLecturerNoteDetails(String courseName, String academicYear) throws SQLException{
    Connection connection = new DataRetriever().getDatabaseConnection();
    List<LecturerNoteDetailsResponse> noteDetails = new ArrayList<>();

    String sql = "SELECT subject_name, date, description, file_name, academic_year, file_size, file_type \n" +
            "FROM lecture_notes WHERE subject_name = ? AND academic_year = ?";

    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1, courseName);
    preparedStatement.setString(2, academicYear);
    ResultSet rs = preparedStatement.executeQuery();

    while (rs.next()){
      LecturerNoteDetailsResponse lecturerNoteDetailsResponse = new LecturerNoteDetailsResponse(
        rs.getString("subject_name"),
        rs.getString("description"),
        rs.getString("academic_year"),
        rs.getString("file_name"),
        rs.getLong("file_size"),
        rs.getTimestamp("date").toString(),
        rs.getString("file_type")
      );

      noteDetails.add(lecturerNoteDetailsResponse);

    }

    return noteDetails;
  }
}
