package groom.dashboardpractice.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DashboardService {
    private final DashboardRepository dashboardRepository;

    public Post createPost(Post post) {
        return null;
    }

    public Post findPostById(int id) {
        return null;
    }

    public Boolean updatePost(Post post) {
        return false;
    }

    public Boolean deletePostById(int id) {
        return false;
    }
}
