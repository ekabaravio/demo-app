package com.demo.dto;

import java.util.List;

public record UserDto(Long id, String username, String name, String email, String role, List<NoteDto> notes) {

    public record NoteDto(Long id, String title, String body) {
    }
}
