package com.example.demo.Service.Quest;

import com.example.demo.Dao.QuestMapper;
import com.example.demo.Pojo.Po.Quest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wzz
 * @date 2022/10/30-10:02
 */
@Service
public class QuestServiceImpl implements QuestService{
    @Autowired
    QuestMapper questMapper;

    @Override
    public int addQuest(Quest quest) {
        int quests = questMapper.addQuest(quest);
        return quests;
    }
}
