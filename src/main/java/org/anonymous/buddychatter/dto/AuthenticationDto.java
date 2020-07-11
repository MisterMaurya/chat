package org.anonymous.buddychatter.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/***
 * @author Pawan Maurya
 * @since July 08, 2020
 */

@NoArgsConstructor
@Getter
@Setter
public class AuthenticationDto {
    private String email;
    private String password;
}
