package com.zubets.fishApp.service;

import com.zubets.fishApp.dao.FishDAO;
import com.zubets.fishApp.entity.FishClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FishServiceImpl implements FishService{

    @Autowired
    private FishDAO fishDAO;

    @Override
    @Transactional
    public List<FishClass> getAllFish() {
        return fishDAO.getAllFish();
    }

    @Override
    @Transactional
    public void saveFish(FishClass fish) {
        fishDAO.saveFish(fish);
    }

    @Override
    @Transactional
    public FishClass getFish(int id) {
        return fishDAO.getFish(id);
    }

    @Override
    @Transactional
    public void deleteFish(int id) {
        fishDAO.deleteFish(id);
    }
}
