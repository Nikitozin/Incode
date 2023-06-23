package com.testincode.company.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserResponseDto {

    private Long id;
    @NonNull
    private String name;

    @NonNull
    private String email;
}
