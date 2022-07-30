package Team4.egg.AfterClass.service;

import Team4.egg.AfterClass.entity.StudyGroup;
import Team4.egg.AfterClass.repository.StudyGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudyGroupService {
    private final StudyGroupRepository studyGroupRepository;

    @Transactional
    public void createStudyGroup(StudyGroup studyGroup){ //poner validaciones
        studyGroup.setCreation_date(LocalDate.now());
        studyGroupRepository.save(studyGroup);
    }

    @Transactional
    public void updateStudyGroup(StudyGroup studyGroup){ //validaciones
        StudyGroup sgroup = studyGroupRepository.findById(studyGroup.getId()).get();
        sgroup.setName(studyGroup.getName());
        sgroup.setSubject(studyGroup.getSubject());
        sgroup.setLimit_people(studyGroup.getLimit_people());
        studyGroupRepository.save(sgroup);
    }

    @Transactional(readOnly = true)
    public List<StudyGroup> getAll(){
        return studyGroupRepository.findAll();
    }

    @Transactional(readOnly = true)//validaciones
    public StudyGroup getById(int id) {
        return studyGroupRepository.findById(id).get();
    }

    @Transactional
    public void deleteById(int id){//validaciones
        studyGroupRepository.deleteById(id);
    }
}
