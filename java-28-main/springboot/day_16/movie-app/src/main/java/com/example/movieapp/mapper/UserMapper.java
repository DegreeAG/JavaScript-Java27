package com.example.movieapp.mapper;

import com.example.movieapp.entity.User;
import com.example.movieapp.model.dto.UserDTO;

public class UserMapper {
    public static UserDTO toDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .displayName(user.getDisplayName())
                .email(user.getEmail())
                .avatar(user.getAvatar())
                .phone(user.getPhone())
                .role(user.getRole())
                .build();
    }
}
