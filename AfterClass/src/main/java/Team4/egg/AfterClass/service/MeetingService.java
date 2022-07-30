package Team4.egg.AfterClass.service;

import Team4.egg.AfterClass.entity.Meeting;
import Team4.egg.AfterClass.repository.MeetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MeetingService {
    private final MeetingRepository meetingRepository;

    @Transactional
    public void createMeeting(Meeting meeting){ //poner validaciones
        meetingRepository.save(meeting);
    }

    @Transactional
    public void updateMeeting(Meeting meeting){ //validaciones
        Meeting meet = meetingRepository.findById(meeting.getId()).get();
        meet.setName(meeting.getName());
        meet.setDescription(meeting.getDescription());
        meet.setDate(meeting.getDate());
        meet.setScheduled(meeting.getScheduled());
        meet.setLink(meeting.getLink());
        meetingRepository.save(meeting);
    }

    @Transactional(readOnly = true)
    public List<Meeting> getAll(){
        return meetingRepository.findAll();
    }

    @Transactional(readOnly = true)//validaciones
    public Meeting getById(int id) {
        return meetingRepository.findById(id).get();
    }

    @Transactional
    public void deleteById(int id){//validaciones
        meetingRepository.deleteById(id);
    }
    //ver funcion del softdelete
// validaciones de que ya exista tal dato
    //realizar metodos para buscar por miembro y grupo
}
