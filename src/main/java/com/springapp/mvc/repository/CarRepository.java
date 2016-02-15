package com.springapp.mvc.repository;

import com.springapp.mvc.domain.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dn070290gsn on 23.06.2015.
 */

@Repository
@Transactional

public class CarRepository {

@Autowired
    private SessionFactory sessionFactory;

    public void addCar(Car car){
        this.sessionFactory.getCurrentSession().save(car);

    }

    public List<Car> listAll(){
        return this.sessionFactory.getCurrentSession().createQuery("from Car").list();
    }

    public void removeCar(Integer id){
        Car current =  (Car) this.sessionFactory.getCurrentSession().load(Car.class,id);
        if (null !=current)
        {
            this.sessionFactory.getCurrentSession().delete(current);
        }
    }
}
