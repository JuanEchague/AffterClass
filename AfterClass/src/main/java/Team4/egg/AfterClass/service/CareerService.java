package Team4.egg.AfterClass.service;

import Team4.egg.AfterClass.entity.Career;

import Team4.egg.AfterClass.entity.University;
import Team4.egg.AfterClass.repository.CareerRepository;
import Team4.egg.AfterClass.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CareerService {

    private final CareerRepository careerRepository;


    @Transactional
    public void createCareer(Career newCareer){
        Career career = new Career();
        career.setName(newCareer.getName());
        career.setUniversity(newCareer.getUniversity());
        careerRepository.save(career);
    }

    @Transactional
    public void updateCareer(Career updateCareer) {
        Career career = careerRepository.findById(updateCareer.getId()).get();
        career.setName(updateCareer.getName());
        career.setUniversity(updateCareer.getUniversity());
        careerRepository.save(career);
    }

    @Transactional(readOnly = true)
    public Career getById(Integer id) {
        return careerRepository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public List<Career> getAll(){
        return careerRepository.findAll();
    }

    @Transactional(readOnly = true)//ver despues
    public List<Career> getAllByUniversity(University uni){
       return careerRepository.findAllByUniversity(uni.getId());
    }
//    //ver
//    @Transactional
//    public void enableById(Integer id) {careerRepository.enableById(id); }

    @Transactional
    public void deleteById(Integer id) { careerRepository.deleteById(id);}


}
