package com.kelaniya.backend.service;

import com.kelaniya.backend.entity.LecNotes;
import com.kelaniya.backend.repository.LecNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class LectureNotesService {
    @Autowired
    private LecNoteRepository lecNoteRepository;


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


    public Optional<LecNotes> getFile(Integer fileId) {

        return lecNoteRepository.findById(fileId);
    }
    public List<LecNotes> getFiles(){
        return lecNoteRepository.findAll();
    }
}
