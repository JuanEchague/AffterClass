package Team4.egg.AfterClass.controller;

import Team4.egg.AfterClass.entity.StudyGroup;
import Team4.egg.AfterClass.service.StudyGroupService;
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
@RequestMapping("/studyGroups")//arreglar cuando se tenga los formularios
@RequiredArgsConstructor
public class StudyGroupController {
    private final StudyGroupService studyGroupService;
    private final SubjectService subjectService;

    @GetMapping
    public ModelAndView getStudyGroups(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("table_sGroup");//arreglar cuando se tenga los formularios
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);

        if(inputFlashMap != null){
            mav.addObject("success", inputFlashMap.get("success"));//agregar para el caso de las excepciones
        }

        mav.addObject("studyGroups", studyGroupService.getAll());
        return mav;
    }

    @GetMapping("/form")//arreglar cuando se tenga los formularios
    public ModelAndView getForm() {
        ModelAndView mav = new ModelAndView("form_sGroup");
        mav.addObject("studyGroup",new StudyGroup());
        mav.addObject("subjects",subjectService.getAll());
        mav.addObject("action","create");
        return mav;
    }

    @GetMapping("/form/{id}")//arreglar cuando se tenga los formularios
    public ModelAndView getForm(@PathVariable int id) {
        ModelAndView mav = new ModelAndView("form_sGroup");
        mav.addObject("studyGroup", studyGroupService.getById(id));
        mav.addObject("subjects",subjectService.getAll());
        mav.addObject("action", "update");
        return mav;
    }

    @PostMapping("/create")
    public RedirectView create(StudyGroup studyGroup, RedirectAttributes attributes){
        RedirectView redirect = new RedirectView("/studyGroups");//arreglar cuando se tenga los formularios
        studyGroupService.createStudyGroup(studyGroup);
        attributes.addFlashAttribute("success", "The operation has been carried out successfully");//agregar para el caso de las excepciones
        return redirect;
    }

    @PostMapping("/update")
    public RedirectView update(StudyGroup studyGroup, RedirectAttributes attributes){
        RedirectView redirect = new RedirectView("/studyGroups");//arreglar cuando se tenga los formularios
        studyGroupService.updateStudyGroup(studyGroup);
        attributes.addFlashAttribute("success", "The operation has been carried out successfully");//agregar para el caso de las excepciones
        return redirect;
    }

    @PostMapping("/delete/{id}")
    public RedirectView delete(@PathVariable int id,  RedirectAttributes attributes){
        RedirectView redirect = new RedirectView("/studyGroups");//arreglar cuando se tenga los formularios
        studyGroupService.deleteById(id);
        attributes.addFlashAttribute("success", "The study group has been removed successfully");//agregar para el caso de las excepciones
        return redirect;
    }
}
