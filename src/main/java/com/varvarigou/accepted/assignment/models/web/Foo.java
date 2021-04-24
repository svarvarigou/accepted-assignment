package com.varvarigou.accepted.assignment.models.web;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Foo {

    @NonNull String firstname;
    String lastname;

}
