/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.math.BigDecimal;
import java.util.List;
import model.edunova.model.Course;
import model.edunova.model.Group;
import util.CatchException;

/**
 *
 * @author frank
 */
public class ProcessCourse extends Process<Course> {

    @Override
    public List<Course> read() {
        return session.createQuery("from Course a order by a.name").list();
    }

    @Override
    protected void controlCreate() throws CatchException {
        controlName();
        controlDuration();
        
    }

    @Override
    protected void controlUpdate() throws CatchException {

    }

    @Override
    protected void controlDelete() throws CatchException {
        if(entity.getGroups()!=null && entity.getGroups().size()>0){
            
            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            for(Group g:entity.getGroups()){
                sb.append(g.getName());
                sb.append("\n");
            }
            
            throw new CatchException("This course can not be deleted because it contains a group: " + sb.toString().toUpperCase());
        }
    }

    private void controlName() throws CatchException {
        if (entity.getName() == null || entity.getName().trim().isEmpty()) {
            throw new CatchException("Name of the course is required.");
        }
        if (entity.getName().trim().length() > 50) {
            throw new CatchException("Name for the course can not have more then 50 characters.");
        }

    }

    private void controlDuration()throws CatchException {
       if(entity.getDuration()==null || entity.getDuration()<0){
           throw new CatchException("Duration is required.");
       }
    }
    
    private void controlPrice()throws CatchException {
        if(entity.getPrice()==null){
            throw new CatchException("Price is required.");
        }
        if(entity.getPrice().compareTo(BigDecimal.ZERO)<0 || entity.getPrice().compareTo(new BigDecimal(10000))>0){
            throw new CatchException("Price has to be higher then 0 and 10000 ");
        }
    }

}
