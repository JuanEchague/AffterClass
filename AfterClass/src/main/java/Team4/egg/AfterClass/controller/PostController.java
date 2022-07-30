package Team4.egg.AfterClass.controller;

import Team4.egg.AfterClass.entity.Post;
import Team4.egg.AfterClass.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/posts")//arreglar cuando se tenga los formularios
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public ModelAndView getPosts(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("table_post");
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);

        if (inputFlashMap != null) {
            mav.addObject("success", inputFlashMap.get("success"));
        }
        mav.addObject("posts", postService.getAll());
        return mav;
    }


    @GetMapping("/form")//arreglar cuando se tenga los formularios
    public ModelAndView getForm() {
        ModelAndView mav = new ModelAndView("form_post");//ver / Post no tiene formulario en si
        mav.addObject("post", new Post());
        mav.addObject("action", "create");
        return mav;
    }


    @GetMapping("/form/{id}")//arreglar cuando se tenga los formularios
    public ModelAndView getForm(@PathVariable int id) {
        ModelAndView mav = new ModelAndView("form_post");
        mav.addObject("post", postService.getById(id));
        mav.addObject("action", "update");
        return mav;
    }


    @PostMapping("/create")
    public RedirectView create(Post post, RedirectAttributes attributes) {
        RedirectView redirect = new RedirectView("/posts");//arreglar cuando se tenga los formularios
        postService.createPost(post);
        attributes.addFlashAttribute("success", "The operation has been carried out successfully");
        return redirect;
    }


    @PostMapping("/update")
    public RedirectView update(Post post, RedirectAttributes attributes) {
        RedirectView redirect = new RedirectView("/posts");//arreglar cuando se tenga los formularios
        postService.updatePost(post);
        attributes.addFlashAttribute("success", "The operation has been carried out successfully");
        return redirect;
    }


    @PostMapping("/delete/{id}")
    public RedirectView delete(@PathVariable int id, RedirectAttributes attributes) {
        RedirectView redirect = new RedirectView("/posts");
        postService.deleteById(id);
        attributes.addFlashAttribute("success", "The post has been removed successfully");//agregar para el caso de las excepciones
        return redirect;
    }


}
