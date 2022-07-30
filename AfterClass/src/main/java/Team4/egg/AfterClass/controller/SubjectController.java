package Team4.egg.AfterClass.controller;

import Team4.egg.AfterClass.entity.Subject;
import Team4.egg.AfterClass.service.CareerService;
import Team4.egg.AfterClass.service.SubjectService;
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
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;
    private final CareerService careerService;

    @GetMapping
    public ModelAndView getSubjects(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("table_subject");
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);

        if (inputFlashMap != null){
            mav.addObject("success", inputFlashMap.get("success"));//agregar para el caso de las excepciones
        }

        mav.addObject("subjects", subjectService.getAll());
        return mav;
    }


    @GetMapping("/form")//arreglar cuando se tenga los formularios
    public ModelAndView getForm(){
        ModelAndView mav = new ModelAndView("form_subject");
        mav.addObject("subject", new Subject());
        mav.addObject("careers",careerService.getAll());
        mav.addObject("action", "create");
        return mav;
    }

    @GetMapping("/form/{id}")
    public ModelAndView getForm(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("form_subject");
        mav.addObject("subject", subjectService.getById(id));
        mav.addObject("careers",careerService.getAll());
        mav.addObject("action", "update");
        return mav;
    }

    @PostMapping("/create")
    public RedirectView create(Subject subject, RedirectAttributes attributes){
            RedirectView redirect = new RedirectView("/subjects");//arreglar cuando se tenga los formularios
            subjectService.createSubject(subject);
            attributes.addFlashAttribute("success", "The operation has been carried out successfully");//agregar para el caso de las excepciones
            return redirect;

    }

    @PostMapping("/update")
    public RedirectView update(Subject subject, RedirectAttributes attributes){
        RedirectView redirect = new RedirectView("/subjects");//arreglar cuando se tenga los formularios
        subjectService.updateSubject(subject);
        attributes.addFlashAttribute("success", "The operation has been carried out successfully");//agregar para el caso de las excepciones
        return redirect;
    }

    @PostMapping("/delete/{id}")
    public RedirectView delete(@PathVariable int id,  RedirectAttributes attributes) {
        RedirectView redirect = new RedirectView("/subjects");//arreglar cuando se tenga los formularios
        subjectService.deleteById(id);
        attributes.addFlashAttribute("success", "The subject has been removed successfully");//agregar para el caso de las excepciones
        return redirect;
    }
}


