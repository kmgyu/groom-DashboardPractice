package groom.dashboardpractice.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class DashboardController {
    private final DashboardService dashboardService;

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public Post createPost(Post post) {
        return dashboardService.createPost(post);
    }

    @RequestMapping(value = "/post", method = RequestMethod.PATCH)
    public Boolean updatePost(Post post) {
        return dashboardService.updatePost(post);
    }

    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public List<Post> getPostList(Post post) {
        return dashboardService.findPostAll();
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public Post getPost(@PathVariable int id) {
        return dashboardService.findPostById(id);
    }

    @RequestMapping(value = "/post", method = RequestMethod.DELETE)
    public Boolean deletePost(@PathVariable int id) {
        return dashboardService.deletePostById(id);
    }
}
