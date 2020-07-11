package org.anonymous.buddychatter.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Message {
    private Long id;
    private String msg;
}
