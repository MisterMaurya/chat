package org.anonymous.buddychatter.controller.views;

import org.anonymous.buddychatter.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * @author Pawan Maurya
 * @since July 06, 2020
 */

@Controller
public class Registration {

    @RequestMapping("/home")
    public String registration(Model model, User user) {
        return "register";
    }


}
