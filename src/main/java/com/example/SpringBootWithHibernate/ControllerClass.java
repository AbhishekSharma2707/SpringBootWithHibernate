package com.example.SpringBootWithHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.ListJoin;
@RestController
@CrossOrigin("http://localhost:4200")

public class ControllerClass {
     @Autowired
     SessionFactory sf;
	@RequestMapping("/AddBird")
	public void AddBird(String name,String color,int id) {
	
    Session s=sf.openSession();
    Transaction t=s.beginTransaction();
    Bird obj=new Bird();
    obj.idofbird=id;
    obj.nameofbird=name;
    obj.colorofbird=color;
    s.save(obj);
    t.commit();
    //return "Birds Added!";
	}
	
	@RequestMapping("/ReadBirdByID")
	public Bird ReadBirdByID(int id) {
		Session s=sf.openSession();
		Bird obj=s.get(Bird.class, id);
		return obj;
	}
	
	@RequestMapping("/ReadAllBird")
	public List<Bird> ReadAllBird() {
		Session s=sf.openSession();
//		Query q=s.createQuery("select nameofbird,colorofbird from Bird");
		Query q =s.createQuery("select idofbird,nameofbird,colorofbird from Bird");
		return q.getResultList();
     }
	@RequestMapping("/DeleteBird")
	public String DeleteBird(int id) {
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		Bird obj=s.load(Bird.class, id);
		s.delete(obj);
		t.commit();
		return "Bird Freed!";
	}
	@RequestMapping("/DeleteAllBird")
	public String DeleteAllBird() {
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		Query q=s.createQuery("delete from Bird");
		q.executeUpdate();
		t.commit();
		return "All Birds freed!";
	}
	@RequestMapping("/UpdateColorBirdAll")
	public String UpdateColorBirdAll() {
       Session s=sf.openSession();
       Transaction t=s.beginTransaction();
       Query q=s.createQuery("update Bird set colorofbird='colorful'");
       q.executeUpdate();
       t.commit();
       return "Updated color!";
	}
	@RequestMapping("/UpdateColorById")
	public String UpdateColorById(int id,String color) {
	  Session s=sf.openSession();
	  Transaction t=s.beginTransaction();
	  Bird obj=s.load(Bird.class, id);
	  obj.setColorofbird(color);
	  s.update(obj);
	  t.commit();
	  return "updated color!";
	  

	}
	
	
}
