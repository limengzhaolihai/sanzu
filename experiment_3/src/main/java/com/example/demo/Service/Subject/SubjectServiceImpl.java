package com.example.demo.Service.Subject;

import com.example.demo.Dao.SubjectMapper;
import com.example.demo.Pojo.Subject300;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
     SubjectMapper subjectMapper;

    @Override
    public int addSubject(Subject300 subject300) {
        int result = subjectMapper.addSubject(subject300);
        return result;

    }
}
