package com.kelaniya.backend.controller;

import com.kelaniya.backend.entity.LecNotes;
import com.kelaniya.backend.repository.LecNoteRepository;
import com.kelaniya.backend.service.LectureNotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class LecturerFeaturesController {


    @Autowired
    private LecNoteRepository lecNoteRepository;

    @Autowired
    private LectureNotesService lectureNotesService;


    @GetMapping("/api/v1/sub/docs")
    public List<LecNotes> getNotes() {

        return lecNoteRepository.findAll();
    }

    @PostMapping("/lec_notes/uploadFile")
    public String uploadMultipleFiles(@RequestParam("file") MultipartFile file,@RequestParam("subjectID") String subject,
                                      @RequestParam("description") String description) {


            lectureNotesService.saveFile(file,subject,description);




        return "redirect:/uploadFile";
    }

}
