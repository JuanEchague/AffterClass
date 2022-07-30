//package Team4.egg.AfterClass.controller;
//
//import Team4.egg.AfterClass.entity.User;
//import Team4.egg.AfterClass.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//import org.springframework.web.servlet.support.RequestContextUtils;
//import org.springframework.web.servlet.view.RedirectView;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Map;
//
//@Controller
//@RequestMapping("/users")//arreglar cuando se tenga los formularios
//@RequiredArgsConstructor
//public class UserController {
//
//    private final UserService userService;
//
//
//    @GetMapping
//    public ModelAndView getUsers(HttpServletRequest request){
//        ModelAndView mav = new ModelAndView("table_user");
//        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
//
//        if (inputFlashMap != null){
//            mav.addObject("success", inputFlashMap.get("success"));
//        }
//
//        mav.addObject("users", userService.getAll());
//        return mav;
//    }
//
//    @GetMapping("/form")//arreglar cuando se tenga los formularios
//    public ModelAndView getForm(){
//        ModelAndView mav = new ModelAndView("form_member");//ver
//        mav.addObject("user", new User());
//        mav.addObject("action", "create");
//        return mav;
//    }
//
//
//    @GetMapping("/form/{id}")
//    public ModelAndView getForm(@PathVariable int id){
//        ModelAndView mav = new ModelAndView("form_member");//ver
//        mav.addObject("user", userService.getById(id));
//        mav.addObject("action", "update");
//        return mav;
//    }
//
//
//    @PostMapping("create")
//    public RedirectView create(User user, RedirectAttributes attributes){
//        RedirectView redirect = new RedirectView("/users");//arreglar cuando se tenga los formularios
//        userService.createUser(user);
//        attributes.addFlashAttribute("success", "The operation has been carried out successfully");
//        return redirect;
//    }
//
//    @PostMapping("/update")
//    public RedirectView update(User user, RedirectAttributes attributes){
//        RedirectView redirect = new RedirectView("/users");//arreglar cuando se tenga los formularios
//        userService.updateUser(user);
//        attributes.addFlashAttribute("success", "The operation has been carried out successfully");
//        return redirect;
//    }
//
//    @PostMapping("/delete/{id}")
//    public RedirectView delete (@PathVariable int id, RedirectAttributes attributes){
//        RedirectView redirect = new RedirectView("/users");//arreglar cuando se tenga los formularios
//        userService.deleteById(id);
//        attributes.addFlashAttribute("success", "The user has been removed successfully");//agregar para el caso de las excepciones
//        return redirect;
//    }
//
//    //ver
//    @PostMapping("/enable/{id}")
//    public RedirectView enable (@PathVariable int id){
//        userService.enableById(id);
//        return new RedirectView("/users");
//    }
//
//}
