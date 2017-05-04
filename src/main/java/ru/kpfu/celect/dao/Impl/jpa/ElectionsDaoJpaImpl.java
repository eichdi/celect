package ru.kpfu.celect.dao.Impl.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import ru.kpfu.celect.dao.ElectionsDao;
import ru.kpfu.celect.dao.repository.ElectionsRepository;
import ru.kpfu.celect.model.Elections;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samat Khairutdinov on 14.04.17 12:16.
 * celect
 */
public class ElectionsDaoJpaImpl implements ElectionsDao {

    @Autowired
    private ElectionsRepository electionsRepository;

    @Override
    public List<Elections> findAll() {
        List<Elections> result = new ArrayList();
        electionsRepository.findAll().iterator().forEachRemaining(result::add);
        return result;
    }

    @Override
    public Elections findById(int id) {
        return electionsRepository.findOne(id);
    }

    @Override
    public int countOfCase(int caseId) {
//        return electionsRepository.countOfCase(caseId);
        return 0;
    }


    @Override
    public int countOfInterview(int interviewId) {
        return 0;
    }

    @Override
    public void insert(Elections elections) {
        electionsRepository.save(elections);
    }

    @Override
    public void insert(int interviewId, int caseId, int userId) {
//        electionsRepository.
    }
}
