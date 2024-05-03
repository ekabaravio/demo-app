package com.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.demo.dto.CreateNoteRequest;
import com.demo.dto.NoteDto;
import com.demo.exception.NoteNotFoundException;
import com.demo.mapper.NoteMapper;
import com.demo.model.Note;
import com.demo.model.User;
import com.demo.repository.NoteRepository;
import com.demo.security.CustomUserDetails;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final NoteMapper noteMapper;
    private final UserService userService;

    @Override
    public List<NoteDto> getNotesList() {
    	List<Note> notes = noteRepository.findAllOrderById();
        return notes.stream()
                .map(noteMapper::toNoteDto)
                .collect(Collectors.toList());
    }
    
	@Override
    public NoteDto getNoteById(Long id) {
    	Note note = noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(String.format("Note with id %s not found", id)));
    	return noteMapper.toNoteDto(note);
    }
    
    @Override
    public NoteDto createNote(CustomUserDetails currentUser, CreateNoteRequest createNoteRequest) {
    	 User user = userService.validateAndGetUserByUsername(currentUser.getUsername());
         Note note = noteMapper.toNote(createNoteRequest);
         note.setUser(user);
         return noteMapper.toNoteDto(noteRepository.save(note));
    }
    
    @Override
    public NoteDto updateNote(CustomUserDetails currentUser, CreateNoteRequest createNoteRequest, Long id) {
	    User user = userService.validateAndGetUserByUsername(currentUser.getUsername());
	    Note note = noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(String.format("Note with id %s not found", id)));
	    NoteDto noteDto = null;
	    
	    if(note != null) {
	    	Note updateNote = noteMapper.toNote(createNoteRequest);
	    	updateNote.setId(id);
	    	updateNote.setUser(user);
	    	noteDto = noteMapper.toNoteDto(noteRepository.save(updateNote));
	    }
	    return noteDto;
	}

    @Override
    public NoteDto deleteNote(Long id) {
    	Note note = noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(String.format("Note with id %s not found", id)));
    	noteRepository.delete(note);
        return noteMapper.toNoteDto(note);
    }

}
