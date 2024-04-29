package com.demo.mapper;

import com.demo.dto.CreateNoteRequest;
import com.demo.dto.NoteDto;
import com.demo.model.Note;

public interface NoteMapper {

    Note toNote(CreateNoteRequest createNoteRequest);

    NoteDto toNoteDto(Note note);
}
