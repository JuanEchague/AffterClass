package Team4.egg.AfterClass.service;

import Team4.egg.AfterClass.entity.University;
import Team4.egg.AfterClass.repository.UniversityRepository;
import Team4.egg.AfterClass.utility.ErrorService;
import Team4.egg.AfterClass.utility.StringsMethods;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversityService implements StringsMethods {
    private final UniversityRepository universityRepository;

    @Transactional
    public void createUniversity(University university) throws ErrorService { //poner validaciones
        university.setName(deleteSpaces(university.getName()));
        if (!university.getName().isEmpty()) {
            if (ExitsUniversity(university)) {
                universityRepository.save(university);
            } else {
                throw new ErrorService("ERROR: There is already a university registered under that name");
            }
        } else {
            throw new ErrorService("ERROR: Invalid name");
        }
    }

    @Transactional
    public void updateUniversity(University university) throws ErrorService { //validaciones
        University uni = universityRepository.findById(university.getId()).get();
        university.setName(deleteSpaces(university.getName()));
        if (!university.getName().isEmpty()) {
            if (ExitsUniversity(university)) {
                uni.setName(university.getName());
                universityRepository.save(uni);
            } else {
                throw new ErrorService("ERROR: There is already a university registered under that name");
            }
        } else {
            throw new ErrorService("ERROR: Invalid name");
        }
    }

    @Transactional(readOnly = true)
    public List<University> getAll() {
        return universityRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));//se utiliza para ORDENAR la lista
    }

    @Transactional(readOnly = true)//validaciones
    public University getById(int id) {
        return universityRepository.findById(id).get();
    }

    @Transactional
    public void deleteById(int id) {//validaciones
        universityRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Boolean ExitsUniversity(University uni) {
        return universityRepository.findByName(uni.getName()) == null;
    }
}
