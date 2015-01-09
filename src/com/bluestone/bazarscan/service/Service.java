package com.bluestone.bazarscan.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import com.bluestone.bazarscan.dao.impl.BazarScanImpl;
import com.bluestone.bazarscan.dto.Product;
import com.bluestone.bazarscan.dto.Product_Header;
import com.bluestone.bazarscan.dto.Product_Supplier;
import com.bluestone.bazarscan.dto.manufacturer;
import com.bluestone.bazarscan.util.Utility;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Service {
	
	

	public List<Product> readjson(String filename) throws JsonParseException,
			JsonMappingException, IOException {
		ObjectMapper obj = new ObjectMapper();
		obj.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		List<Product> st = obj.readValue(
				new File(filename),
				obj.getTypeFactory().constructCollectionType(List.class,
						Product.class));
		return st;

	}
	
	public boolean isManufacturereExists(String mfgName)
	{
		Session s = Utility.getSession();
		Query query=s.createQuery("from manufacturer m where m.mfg_name='"+mfgName+"'");
		if(query.list().size()>0)
		{
			System.out.println("value exist: "+mfgName);
			return true;
		}
		return false;
	}

	//To store manufacturer List in DB
	public void storeManufacturer(List<Product> productList) {
		Session s = Utility.getSession();
		Transaction tx = s.beginTransaction();
		Set<String> manufacturerList = new TreeSet<String>();
		for (Product product : productList) {
			manufacturerList.add(product.getMfg());
		}
		Criteria crit = s.createCriteria(manufacturer.class);
		crit.setProjection(Projections.rowCount());
		//long i=(Long)crit.uniqueResult();
		BazarScanImpl bs=new BazarScanImpl();
		long i=bs.getRowCount(manufacturer.class);
		System.out.println("I "+i);
		/*try {
			for (String m1 : manufacturerList) {
				if(!isManufacturereExists(m1))
				{
					i++;
					manufacturer m = new manufacturer();
					m.setMfg_id("" + i);
					m.setMfg_name(m1);
					s.save(m);
				}
				
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}*/
	}

	public void storeProduct_header(List<Product> productList) {
		Session session = Utility.getSession();
		Transaction tx = session.beginTransaction();
	/*	List<Product_Header> list = (List<Product_Header>) session.createQuery(
				"from Product_Header").list();*/
		BazarScanImpl bs=new BazarScanImpl();
		long index=bs.getRowCount(Product_Header.class);
		/*
		 * Criteria c=session.createCriteria("Product_Header");
		 * c.setProjection(Projections.rowCount()); int index1=(Integer)
		 * c.uniqueResult(); System.out.println("index :"+index +
		 * "  index1  ::"+index1);
		 */

		try {
			for (Product product : productList) {
				Product_Header ph = new Product_Header();
				ph.setMfg_model_id(product.getModelName().substring(0, 10));
				ph.setProduct_name("Mobile");
				List<manufacturer> result = (List<manufacturer>) session
						.createQuery(
								"from manufacturer where mfg_name='"
										+ product.getMfg() + "'").list();
				manufacturer mm = (manufacturer) result.get(0);
				ph.setMfg_id("" + mm.getMfg_id());
				ph.setId("" + index);
				ph.setProduct_color("RED");
				ph.setSub_category("mobile");
				session.save(ph);
				index++;
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			session.close();
		}
	}

	public void storeProduct_supplier(List<Product> productList) {
		Session session = Utility.getSession();
		Transaction tx = session.beginTransaction();
		// List<Product_Supplier> list=(List<Product_Supplier>)
		// session.createQuery("from Product_Supplier").list();
		int index = 0;// list.size();
		// Criteria c=session.createCriteria("Product_Supplier");
		// c.setProjection(Projections.rowCount());
		// int index1=(Integer) c.uniqueResult();
		// System.out.println("index :"+index + "  index1  ::"+index1);

		try {
			for (Product product : productList) {
				index++;
				Product_Supplier ps = new Product_Supplier();
				ps.setSupplier_id("" + index);
				ps.setProduct_id("" + index);
				ps.setProduct_url(product.getUrl());
				if (product.getGiftWrapAvailable() == "Available") {
					ps.setGift_wrap('Y');
				} else {
					ps.setGift_wrap('N');
				}
				if (product.getIsInStock() != null
						&& product.getIsInStock() != "") {
					ps.setIn_stock('Y');
				} else {
					ps.setIn_stock('N');
				}
				ps.setEmi_available(product.getIsEMiAvailable());
				session.save(ps);
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			tx.rollback();
			session.close();
		}
	}

	public void storesubcategory(List<Product> productList) {

	}

	public void storeReviews(List<Product> productList) {

	}


}
