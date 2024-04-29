package com.demo.controller;

import static com.demo.config.SwaggerConfig.BEARER_KEY_SECURITY_SCHEME;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.CreateNoteRequest;
import com.demo.dto.NoteDto;
import com.demo.security.CustomUserDetails;
import com.demo.service.NoteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;

    @Operation(security = {@SecurityRequirement(name = BEARER_KEY_SECURITY_SCHEME)})
    @GetMapping
    public List<NoteDto> getNotes() {
    	return noteService.getNotesList();
        
    }
    
    @Operation(security = {@SecurityRequirement(name = BEARER_KEY_SECURITY_SCHEME)})
    @GetMapping("/{id}")
    public NoteDto getNoteById(@PathVariable Long id) {
    	return noteService.getNoteById(id);
        
    }

    @Operation(security = {@SecurityRequirement(name = BEARER_KEY_SECURITY_SCHEME)})
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public NoteDto createNote(@AuthenticationPrincipal CustomUserDetails currentUser,
                                @Valid @RequestBody CreateNoteRequest createNoteRequest) {
        return noteService.createNote(currentUser, createNoteRequest);
    }
    
    @Operation(security = {@SecurityRequirement(name = BEARER_KEY_SECURITY_SCHEME)})
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public NoteDto updateNote(@AuthenticationPrincipal CustomUserDetails currentUser,
                                @Valid @RequestBody CreateNoteRequest createNoteRequest,
                                @PathVariable Long id) {
        return noteService.updateNote(currentUser, createNoteRequest, id);
    }

    @Operation(security = {@SecurityRequirement(name = BEARER_KEY_SECURITY_SCHEME)})
    @DeleteMapping("/{id}")
    public NoteDto deleteNote(@PathVariable Long id) {
        return noteService.deleteNote(id);
    }
}
