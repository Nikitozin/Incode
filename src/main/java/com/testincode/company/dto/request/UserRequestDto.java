package com.testincode.company.dto.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserRequestDto {

    @NonNull
    private String name;

    @NonNull
    private String email;
}
