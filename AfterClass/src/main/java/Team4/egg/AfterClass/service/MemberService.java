package Team4.egg.AfterClass.service;

import Team4.egg.AfterClass.entity.Member;
import Team4.egg.AfterClass.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public void createMember(Member member){ //poner validaciones
        memberRepository.save(member);
    }

    @Transactional
    public void updateMember(Member member){
        Member memb = memberRepository.findById(member.getId()).get();
        memb.setFull_name(member.getFull_name());
        memb.setBirth_date(member.getBirth_date());
        memb.setGender(member.getGender());
        memb.setOccupation(member.getOccupation());
        memberRepository.save(memb);
    }

    @Transactional(readOnly = true)
    public List<Member> getAll(){
        return memberRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Member getById(int id) {
        return memberRepository.findById(id).get();
    }

    @Transactional
    public void deleteById(int id){//validaciones
        memberRepository.deleteById(id);
    }
}
