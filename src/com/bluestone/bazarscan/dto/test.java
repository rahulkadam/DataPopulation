package com.bluestone.bazarscan.dto;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bluestone.bazarscan.service.Service;
import com.bluestone.bazarscan.util.Utility;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class test {

	/**
	 * @param args
	 * @throws JsonParseException 
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * @throws HibernateException 
	 */
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
		
		String file="/home/rahul/Desktop/jackson_Sample/src/sample.json";
		Service svc=new Service(); 
		Logger log=Logger.getLogger(test.class.getName());
		  log.warn("Warn Message!");
		log.info("printing log");

		List<Product> list=svc.readjson(file);
		//svc.storeManufacturer(list);
		//svc.storeProduct_header(list);
		//svc.storeProduct_supplier(list);
		/*
		 * 
		 */
		// TODO Auto-generated method stub
		ObjectMapper mapper=new ObjectMapper();
		 mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	 	SessionFactory sf;
		Configuration c;
		c=new Configuration().configure();
		sf=c.buildSessionFactory();
		Session s=sf.openSession();
//		Transaction tx=s.beginTransaction();
       Session ss=Utility.getSession();
       Transaction tx=ss.beginTransaction();
	     
       log.trace("Trace Message!");
       log.debug("Debug Message!");
       log.info("Info Message!");
       log.warn("Warn Message!");
       log.error("Error Message!");
       log.fatal("Fatal Message!");
	  //   mapper.writeValue(new File("c:\\user.json"), list);
	     //System.out.println(mapper.writeValueAsString(list)); 
	     /*List<Employee> st = mapper.readValue(new File("c:\\user.json"),  mapper.getTypeFactory().constructCollectionType(
                 List.class, Employee.class));
       System.out.println("Product list    :");
       try{
	     List<Product> st = mapper.readValue(new File("/home/rahul/Desktop/jackson_Sample/src/sample.json"),  mapper.getTypeFactory().constructCollectionType(
                 List.class, Product.class)); 
	    int i=0;
	    Set<String> mfg=new TreeSet<String>();
	    
	     //product info reding and product_header insertion
	   /*  for (Product product : st) {
			i++;
	    	 Product_Header ph=new Product_Header();
	    	 ph.setMfg_model_id(product.getModelName().substring(0, 10));
	    	 mfg.add(product.getMfg());
	    	 ph.setProduct_name("Mobile");
	    	// List q=s.createQuery("from MANUFACTURER").list();
	    	/* List<manufacturer> result = (List<manufacturer>) s.createQuery("from manufacturer where mfg_name='"+product.getMfg()+"'").list();
	    	 manufacturer mm=(manufacturer) result.get(0);
	    	 ph.setMfg_id(""+mm.getMfg_id());
	    	 ph.setId(""+i);
	    	 ph.setProduct_color("RED");
	    	 ph.setSub_category("mobile");
//	    	 s.save(ph);
//	    	s.save(product);
		//}
	     
	     //product_supplier
	     i=0;
	     for (Product product : st) {
				i++;
				Product_Supplier ps=new Product_Supplier();
				ps.setSupplier_id(""+i);
				ps.setProduct_url(product.getUrl());
				if(product.getGiftWrapAvailable()=="Available")
				{
					ps.setGift_wrap('Y');					
				}
				else
				{
					ps.setGift_wrap('N');	
				}
				if(product.getIsInStock()!=null && product.getIsInStock() !="")
				{
					ps.setIn_stock('Y');
				}
				else
				{
					ps.setIn_stock('N');
				}
					ps.setEmi_available(product.getIsEMiAvailable());
					s.save(ps);
	     }
	     
	     //manufacturer
	     i=0;
	     for (String m1 : mfg) {
				i++;
			//	System.out.println("mfg :"+i);
		    manufacturer m=new manufacturer();
		    m.setMfg_id(""+i);
		    m.setMfg_name(m1);
		    //s.save(m);
	     }
	     tx.commit();
	     System.out.println("Product list    :"+st);
	     }catch(Exception e)
	     {
	    	 e.printStackTrace();
	     }
	}
	
	void insertmanucturer()
	{
		
	}
	*/
	}
}
