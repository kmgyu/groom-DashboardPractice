package groom.dashboardpractice.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DashboardService {
    private final DashboardRepository dashboardRepository;

    public Post createPost(Post post) {
        return dashboardRepository.save(post);
    }

    public List<Post> findPostAll() {
        return dashboardRepository.findAll();
    }

//    isPresent 검사 없음.
//    Todo : 조건 분기 추가
    public Post findPostById(int id) {
        return dashboardRepository.findById(id).get();
    }

    public Boolean updatePost(Post post) {
        if (dashboardRepository.existsById(post.getId())) {
            dashboardRepository.save(post);
        }
        return dashboardRepository.existsById(post.getId());
    }

    public Boolean deletePostById(int id) {
        if (dashboardRepository.existsById(id)) {
            dashboardRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
