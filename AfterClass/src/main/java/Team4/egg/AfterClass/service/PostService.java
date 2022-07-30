package Team4.egg.AfterClass.service;


import Team4.egg.AfterClass.entity.Post;
import Team4.egg.AfterClass.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    public final PostRepository postRepository;

    @Transactional
    public void createPost(Post newPost){
        Post post = new Post();

        post.setTittle(newPost.getTittle());
        post.setContent(newPost.getContent());
        post.setFile(newPost.getFile());
        post.setMember(newPost.getMember());
        post.setStudyGroup(newPost.getStudyGroup());
        postRepository.save(post);
    }

    @Transactional
    public void updatePost(Post modifiedPost) {
        Post post = postRepository.findById(modifiedPost.getId()).get();

        post.setTittle(modifiedPost.getTittle());
        post.setContent(modifiedPost.getContent());
        post.setFile(modifiedPost.getFile());
        postRepository.save(post);
    }

    @Transactional(readOnly = true)
    public Post getById(Integer id) {
        return postRepository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public List<Post> getAll() {return postRepository.findAll(); }

//    @Transactional
//    public void enableById(Integer id) {
//        postRepository.enableById(id);
//    }

    @Transactional
    public void deleteById(Integer id) { postRepository.deleteById(id);}

}
