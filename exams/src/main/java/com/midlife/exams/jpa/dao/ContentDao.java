package com.midlife.exams.jpa.dao;

import com.midlife.exams.jpa.entities.Content;
import com.midlife.exams.jpa.repo.ContentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import java.util.List;

@Component
public class ContentDao {

    @Autowired
    private ContentRepo contentRepo;

    @Nonnull
    public List<Content> getAllGroups(){
        return contentRepo.getAllByType(Content.TestContentType.GROUP);
    }

    @Nonnull
    public List<Content> getAll(){
        return contentRepo.findAll();
    }

    @CheckForNull
    public Content getbyId(long contentId){
       return contentRepo.findById(contentId).orElse(null);
    }

    @Nonnull
    public List<Content> searchContentByNameOrDescription(String query) {
        return contentRepo.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(query,query);
    }
}
