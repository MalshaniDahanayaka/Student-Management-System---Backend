package com.kelaniya.backend.repository;

import com.kelaniya.backend.entity.Announcement;
import com.kelaniya.backend.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM announcement WHERE lecturer_email = ?1 AND academic_year = ?2 AND title = ?3")
    int deleteAnnouncement(String lecturer_email,String academic_year,String title);

    @Transactional
    @Query("FROM announcement WHERE lecturer_email = ?1")
    List<Announcement> getLecturerAnnouncement(String lecturer_email);

//    @Transactional
//    @Query("From announcement WHERE (category = ?1 or category = ?2 or category = ?4) AND academic_year = ?3")
//    public List<Announcement> getAnnouncement(String department_name, String faculty_name, String academic_year,String all);
}
