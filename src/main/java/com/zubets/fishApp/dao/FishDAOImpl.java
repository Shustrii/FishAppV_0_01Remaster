package com.zubets.fishApp.dao;

import com.zubets.fishApp.entity.FishClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FishDAOImpl implements FishDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<FishClass> getAllFish() {
        Session session = sessionFactory.getCurrentSession();
        List<FishClass> allFish = session.createQuery("from FishClass ", FishClass.class).getResultList();


        return allFish;
    }

    @Override
    public void saveFish(FishClass fish) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(fish);
    }

    @Override
    public FishClass getFish(int id) {
    Session session= sessionFactory.getCurrentSession();
    FishClass fish= session.get(FishClass.class, id);
    return fish;
    }

    @Override
    public void deleteFish(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<FishClass> query = session.createQuery("delete from FishClass "+""+
                "where id =: fishId");
        query.setParameter("fishId", id);
        query.executeUpdate();

    }
}
