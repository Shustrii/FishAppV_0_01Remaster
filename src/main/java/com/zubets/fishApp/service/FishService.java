package com.zubets.fishApp.service;

import com.zubets.fishApp.entity.FishClass;

import java.util.List;

public interface FishService {
    public List<FishClass> getAllFish();

    public void saveFish(FishClass fish);

    public FishClass getFish(int id);

    public void deleteFish(int id);
}
