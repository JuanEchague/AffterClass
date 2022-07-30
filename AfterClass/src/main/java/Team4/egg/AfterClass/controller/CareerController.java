package Team4.egg.AfterClass.controller;

import Team4.egg.AfterClass.entity.Career;
import Team4.egg.AfterClass.service.CareerService;
import Team4.egg.AfterClass.service.UniversityService;
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
@RequestMapping("/careers")//arreglar cuando se tenga los formularios
@RequiredArgsConstructor
public class CareerController {
    private final CareerService careerService;
    private final UniversityService universityService;

    @GetMapping
    public ModelAndView getCareers(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("table_career");
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);

        if (inputFlashMap != null){
            mav.addObject("success", inputFlashMap.get("success"));//agregar para el caso de las excepciones
        }
        mav.addObject("careers", careerService.getAll());
        return mav;
    }


    @GetMapping("/form")//arreglar cuando se tenga los formularios
    public ModelAndView getForm(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("form_career");
        mav.addObject("career", new Career());
        mav.addObject("universities", universityService.getAll());
        mav.addObject("action", "create");
        return mav;
    }


    @GetMapping("/form/{id}")//arreglar cuando se tenga los formularios
    public ModelAndView getForm(@PathVariable Integer id) {
        ModelAndView mav = new ModelAndView("form_career");
        mav.addObject("career", careerService.getById(id));
        mav.addObject("universities", universityService.getAll());
        mav.addObject("action", "update");
        return mav;
    }


    @PostMapping("/create")
    public RedirectView create(Career career, RedirectAttributes attributes) {
        RedirectView redirect = new RedirectView("/careers");//arreglar cuando se tenga los formularios
        careerService.createCareer(career);
        attributes.addFlashAttribute("success", "The operation has been carried out successfully");
        return redirect;
    }


    @PostMapping("/update")
    public RedirectView update(Career career, RedirectAttributes attributes) {
        RedirectView redirect = new RedirectView("/careers");//arreglar cuando se tenga los formularios
        careerService.updateCareer(career);
        attributes.addFlashAttribute("success", "The operation has been carried out successfully");
        return redirect;
    }

    @PostMapping("/delete/{id}")
    public RedirectView delete(@PathVariable int id, RedirectAttributes attributes) {
        RedirectView redirect = new RedirectView("/careers");//arreglar cuando se tenga los formularios
        careerService.deleteById(id);
        attributes.addFlashAttribute("success", "The career has been removed successfully");//agregar para el caso de las excepciones
        return redirect;
    }

}
