package com.demo.mapper;

import org.springframework.stereotype.Service;

import com.demo.dto.CreateNoteRequest;
import com.demo.dto.NoteDto;
import com.demo.model.Note;

@Service
public class NoteMapperImpl implements NoteMapper {

    @Override
    public Note toNote(CreateNoteRequest createNoteRequest) {
        if (createNoteRequest == null) {
            return null;
        }
        return new Note(createNoteRequest.getTitle(), createNoteRequest.getBody());
    }

    @Override
    public NoteDto toNoteDto(Note note) {
        if (note == null) {
            return null;
        }
        NoteDto.UserDto userDto = new NoteDto.UserDto(note.getUser().getUsername());
        return new NoteDto(note.getId(), note.getTitle(), note.getBody(), userDto);
    }
}
