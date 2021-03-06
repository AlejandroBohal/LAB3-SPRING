/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.persistence.impl;

import edu.eci.arsw.cinema.model.Cinema;
import edu.eci.arsw.cinema.model.CinemaFunction;
import edu.eci.arsw.cinema.model.Movie;
import edu.eci.arsw.cinema.persistence.CinemaException;
import edu.eci.arsw.cinema.persistence.CinemaPersistenceException;
import edu.eci.arsw.cinema.persistence.CinemaPersitence;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 *
 * @author cristian
 */
@Component
@Qualifier("inMemoryCP")
public class InMemoryCinemaPersistence implements CinemaPersitence{
    
    private final Map<String,Cinema> cinemas=new HashMap<>();

    public InMemoryCinemaPersistence() {
        //load stub data
        String functionDate = "2018-12-18 15:30";
        List<CinemaFunction> functions= new ArrayList<>();
        CinemaFunction funct1 = new CinemaFunction(new Movie("SuperHeroes Movie","Action"),functionDate);
        CinemaFunction funct2 = new CinemaFunction(new Movie("The Night","Horror"),functionDate);
        functions.add(funct1);
        functions.add(funct2);
        Cinema c=new Cinema("cinemaX",functions);
        cinemas.put("cinemaX", c);
    }    

    @Override
    public void buyTicket(int row, int col, String cinema, String date, String movieName) throws CinemaException {
        Cinema cinemaTicket = this.cinemas.get(cinema);
        List<CinemaFunction> functionsOfOurCinema=cinemaTicket.getFunctions();
        boolean functionFound=false;
        for (CinemaFunction cf: functionsOfOurCinema) {
            if(cf.getMovie().getName().equals(movieName) && cf.getDate().equals(date)){
                cf.buyTicket(row,col);
                functionFound=true;
            }
        }
        if (!functionFound){
            throw new CinemaException("No se encontraron funciones con los parametros indicados.");
        }
    }

    @Override
    public List<CinemaFunction> getFunctionsbyCinemaAndDate(String cinema, String date) {
        List<CinemaFunction> functions = new LinkedList<CinemaFunction>();
        Cinema cinemaTicket = this.cinemas.get(cinema);
        List<CinemaFunction> functionsOfOurCinema=cinemaTicket.getFunctions();

        for (CinemaFunction cf: functionsOfOurCinema) {
            if(cf.getDate().equals(date)){
               functions.add(cf);
            }
        }
        return functions;

    }

    @Override
    public void saveCinema(Cinema c) throws CinemaPersistenceException {
        if (cinemas.containsKey(c.getName())){
            throw new CinemaPersistenceException("The given cinema already exists: "+c.getName());
        }
        else{
            cinemas.put(c.getName(),c);
        }   
    }

    @Override
    public Cinema getCinema(String name) throws CinemaPersistenceException {
        return cinemas.get(name);
    }

}
