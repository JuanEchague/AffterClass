package Team4.egg.AfterClass.controller;

import Team4.egg.AfterClass.entity.Member;
import Team4.egg.AfterClass.service.MemberService;
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
@RequestMapping("/members")//arreglar cuando se tenga los formularios
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping
    public ModelAndView getMembers(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("table_member");//arreglar cuando se tenga los formularios

        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);

        if(inputFlashMap != null){
            mav.addObject("success", inputFlashMap.get("success"));//agregar para el caso de las excepciones
        }

        mav.addObject("members", memberService.getAll());
        return mav;
    }

    @GetMapping("/form")//arreglar cuando se tenga los formularios
    public ModelAndView getForm() {
        ModelAndView mav = new ModelAndView("form_member");
        mav.addObject("member",new Member());
        mav.addObject("action","create");
        return mav;
    }

    @GetMapping("/form/{id}")//arreglar cuando se tenga los formularios
    public ModelAndView getForm(@PathVariable int id) {
        ModelAndView mav = new ModelAndView("form_member");
        mav.addObject("member", memberService.getById(id));
        mav.addObject("action", "update");
        return mav;
    }

    @PostMapping("/create")
    public RedirectView create(Member member, RedirectAttributes attributes){
        RedirectView redirect = new RedirectView("/members");//arreglar cuando se tenga los formularios
        memberService.createMember(member);
        attributes.addFlashAttribute("success", "The operation has been carried out successfully");//agregar para el caso de las excepciones
        return redirect;
    }

    @PostMapping("/update")
    public RedirectView update(Member member, RedirectAttributes attributes){
        RedirectView redirect = new RedirectView("/members");//arreglar cuando se tenga los formularios
        memberService.updateMember(member);
        attributes.addFlashAttribute("success", "The operation has been carried out successfully");//agregar para el caso de las excepciones
        return redirect;
    }

    @PostMapping("/delete/{id}")
    public RedirectView delete(@PathVariable int id,  RedirectAttributes attributes){
        RedirectView redirect = new RedirectView("/members");//arreglar cuando se tenga los formularios
        memberService.deleteById(id);
        attributes.addFlashAttribute("success", "The member has been removed successfully");//agregar para el caso de las excepciones
        return redirect;
    }
}
