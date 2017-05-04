package ru.kpfu.celect.dao.Impl.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.celect.dao.CaseDao;
import ru.kpfu.celect.dao.repository.CaseRepository;
import ru.kpfu.celect.model.CelectCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samat Khairutdinov on 13.04.17 15:12.
 * celect
 */
@Repository
public class CaseDaoJpaImpl implements CaseDao {

    @Autowired
    CaseRepository caseRepository;

    @Override
    public List<CelectCase> findAll() {
        List<CelectCase> result = new ArrayList();
        caseRepository.findAll().iterator().forEachRemaining(result::add);
        return result;
    }

    @Override
    public CelectCase findById(int id) {
        return caseRepository.findOne(id);
    }

    @Override
    public void insert(CelectCase aCelectCase) {
        caseRepository.save(aCelectCase);
    }

    @Override
    public void update(CelectCase aCelectCase) {
        caseRepository.save(aCelectCase);
    }

    @Override
    public void delete(int id) {
        caseRepository.delete(new CelectCase(id, null, null, null));
    }

    @Override
    public List<CelectCase> findByInterview(int interviewId) {
//        return caseRepository.findByInterview(interviewId);
            return null;
    }

}
