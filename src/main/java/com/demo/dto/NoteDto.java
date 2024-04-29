package com.demo.dto;

public record NoteDto(Long id, String title, String body, NoteDto.UserDto user) {

    public record UserDto(String username) {
    }
}
