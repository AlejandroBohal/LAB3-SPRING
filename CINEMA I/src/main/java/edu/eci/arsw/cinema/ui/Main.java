/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.ui;

import edu.eci.arsw.cinema.model.Cinema;
import edu.eci.arsw.cinema.model.CinemaFunction;
import edu.eci.arsw.cinema.persistence.CinemaException;
import edu.eci.arsw.cinema.persistence.CinemaPersistenceException;
import edu.eci.arsw.cinema.services.CinemaServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 *
 * @author hcadavid
 */
public class Main {

    public static void main(String a[]) throws CinemaException, CinemaPersistenceException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        CinemaServices cs = ac.getBean(CinemaServices.class);
        Cinema c = cs.getCinemaByName("cinemaX");
        System.out.println(c.getName());
        System.out.println();
        List<CinemaFunction> t = cs.getFunctionsByCinemaAndDate("cinemaX", "2018-12-18 15:30");
        CinemaFunction xd = null;
        for (CinemaFunction w : t) {
            xd = w;
            System.out.println(w.getMovie().getName());
        }
        System.out.println();
        for (List<Boolean> l : xd.getSeats()) {
            System.out.println(l);
        }

        System.out.println();
        cs.buyTicket(1,1,"cinemaX","2018-12-18 15:30",xd.getMovie().getName());
        for (List<Boolean> l : xd.getSeats()) {
            System.out.println(l);
        }
        System.out.println(xd.movieAvailability());







    }

}
