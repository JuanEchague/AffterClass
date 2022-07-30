package Team4.egg.AfterClass.service;

import Team4.egg.AfterClass.entity.Subject;
import Team4.egg.AfterClass.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;


    @Transactional
    public void createSubject(Subject newSubject) {
        Subject subject = new Subject();

        subject.setName(newSubject.getName());
        subject.setCareer(newSubject.getCareer());
        subjectRepository.save(subject);
    }

    @Transactional
    public void updateSubject(Subject modifiedSubject) {
        Subject subject = subjectRepository.findById(modifiedSubject.getId()).get();
        subject.setName(modifiedSubject.getName());
        subject.setCareer(modifiedSubject.getCareer());
        subjectRepository.save(subject);
    }

    @Transactional(readOnly = true)
    public Subject getById(Integer id) {
        return subjectRepository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public List<Subject> getAll() {return subjectRepository.findAll();}

//    @Transactional
//    public void enableById(Integer id) {
//        subjectRepository.enableById(id);
//    }

    @Transactional
    public void deleteById(Integer id) {
        subjectRepository.deleteById(id);
    }
}
