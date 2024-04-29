package com.demo.mapper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.dto.UserDto;
import com.demo.model.Note;
import com.demo.model.User;

@Service
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toUserDto(User user) {
        if (user == null) {
            return null;
        }
        List<UserDto.NoteDto> notes = user.getNotes().stream().map(this::toUserDtoNoteDto).toList();
        return new UserDto(user.getId(), user.getUsername(), user.getName(), user.getEmail(), user.getRole(), notes);
    }

    private UserDto.NoteDto toUserDtoNoteDto(Note note) {
        if (note == null) {
            return null;
        }
        return new UserDto.NoteDto(note.getId(), note.getTitle(), note.getBody());
    }
}