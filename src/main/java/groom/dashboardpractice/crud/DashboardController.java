package groom.dashboardpractice.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class DashboardController {
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public Post createPost(Post post) {
        return null;
    }
}
