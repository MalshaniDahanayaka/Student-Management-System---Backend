package com.kelaniya.backend.utils.data;

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


}
