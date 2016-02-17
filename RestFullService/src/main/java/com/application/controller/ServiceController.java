package com.application.controller;


import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.jdbc.connections.internal.UserSuppliedConnectionProviderImpl;
import org.hibernate.transform.Transformers;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.bean.UserLogin;
import com.application.bean.Users;



/**
 * Handles requests for the application home page.
 */
@Controller
public class ServiceController {
	
	private static final Logger logger = LoggerFactory.getLogger(ServiceController.class);
//	@Autowired
//	private DataSource myDataSource;
	@Autowired 
	private SessionFactory sessionFactory;
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws JSONException 
	 */
	@RequestMapping(value = "/val", method = RequestMethod.POST, produces = "application/json")
	
	public @ResponseBody String home(@RequestParam("user") String user,@RequestParam("pass") String pwd) throws JSONException {

		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(UserLogin.class);
		System.out.println("user :"+user);
		System.out.println("Pass :"+pwd);
		criteria.add(Restrictions.eq("userName", user));
		criteria.add(Restrictions.eq("password", pwd));
		UserLogin usr=(UserLogin) criteria.uniqueResult();
		JSONObject obj=new JSONObject();
		System.out.println("usr obj : "+usr);
		if(usr!=null){
		obj.put("status","success");
		}else{
			obj.put("status","Failed");
		}
		
		
		
		return obj.toString();
	}
@RequestMapping(value = "/signup", method = RequestMethod.POST, produces = "application/json")
	
	public @ResponseBody String signup(@RequestParam("user") String user,@RequestParam("password") String pwd,@RequestParam("type") String type) throws JSONException {
	    boolean isSaved = false;
	    try{
		Session session = sessionFactory.openSession();
//		Criteria criteria = session.createCriteria(Users.class);
		UserLogin login=new UserLogin();
		login.setUserName(user);
		login.setPassword(pwd);
		login.setCreatedTime(new Date());
		login.setActive(true);
		login.setLastActiveTime(new Date());
		login.setUpdatedTime(new Date());
		Transaction trans = session.beginTransaction();
		
	     isSaved = true;
		session.saveOrUpdate(login);
		trans.commit();
	    }catch(Exception ex){
	    	isSaved=false;
	    }
		JSONObject obj=new JSONObject();
		if(isSaved){
		obj.put("status","success");
		}else{
			obj.put("status","Failed");
		}
		
		
		
		return obj.toString();
	}
	
   @RequestMapping(value="/")
   public String hme1(Model model){
	   Session session = sessionFactory.openSession();
	   Criteria criteria = session.createCriteria(Users.class)
			   .setProjection(Projections.projectionList()
					      .add(Projections.property("userName"), "userName")
					      .add(Projections.property("password"), "password"))
			              .setResultTransformer(Transformers.aliasToBean(Users.class))
			               ;
	   criteria.add(Restrictions.eq("userName", "dinesh"));
	   Users usr=(Users) criteria.uniqueResult();
	   System.out.println("For Reference: "+usr.getUserName());
	   System.out.println("For Reference: "+usr.getCreatedTime());
	   model.addAttribute("serverTime",new Date());
	   return "home";
   }





	
}
