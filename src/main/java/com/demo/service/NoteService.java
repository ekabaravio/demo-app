package com.demo.service;

import java.util.List;

import com.demo.dto.CreateNoteRequest;
import com.demo.dto.NoteDto;
import com.demo.security.CustomUserDetails;

public interface NoteService {
    
    List<NoteDto> getNotesList();
    
    NoteDto getNoteById(Long id);

    NoteDto createNote(CustomUserDetails currentUser, CreateNoteRequest createNoteRequest);
    
    NoteDto updateNote(CustomUserDetails currentUser, CreateNoteRequest createNoteRequest, Long id);

    NoteDto deleteNote(Long id);
    
}
