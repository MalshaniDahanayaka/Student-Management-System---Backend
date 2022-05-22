package com.kelaniya.backend.utils.email.mailgun;

import com.kelaniya.backend.entity.StudentsEnrollSubjects;
import com.kelaniya.backend.entity.StudentsRecords;
import com.kelaniya.backend.entity.request.AnnouncementRequest;
import com.kelaniya.backend.entity.request.StudentsRecordsRequest;
import com.kelaniya.backend.service.LectureService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class SendEmailsToStudents {




    private AnnouncementRequest announcementRequest;
    private String userEmail;
    private List<StudentsEnrollSubjects> enrollStudents;
    public SendEmailsToStudents(AnnouncementRequest announcementRequest, String userEmail, List<StudentsEnrollSubjects> enrollStudents) throws UnirestException {
        this.announcementRequest = announcementRequest;
        this.userEmail = userEmail;
        this.enrollStudents = enrollStudents;

        sendAnnouncement();
    }
    
    
    

    private void sendAnnouncement() throws UnirestException {

        List list = new ArrayList();

        for(StudentsEnrollSubjects std: enrollStudents){
            if(std.getStudent_email() == "skasunmk982@gmail.com" || std.getStudent_email() == "mekaladahanayaka80@gmail.com"){
                 list.add(std.getStudent_email());
            }
        }
        int length = list.size();
        for(int i = length;i<5;i++){
            list.add("null");
        }

        new MGSample().sendSimpleMessage(list,announcementRequest,userEmail);


    }





}
