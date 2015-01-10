package com.bluestone.bazarscan.dao.impl;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import com.bluestone.bazarscan.dao.BazarScanDao;
import com.bluestone.bazarscan.dto.Product;
import com.bluestone.bazarscan.dto.Product_Header;
import com.bluestone.bazarscan.dto.Product_Supplier;
import com.bluestone.bazarscan.dto.manufacturer;
import com.bluestone.bazarscan.testclient.MobileTestClient;
import com.bluestone.bazarscan.util.Utility;

public class BazarScanImpl implements BazarScanDao{

	private static Session session=null;
	
	private static BazarScanImpl bazarScanImpl;
	private Logger log=Logger.getLogger(MobileTestClient.class.getName());
	
	private BazarScanImpl() {

	}
	
	public static BazarScanImpl getInstance()
	{
		if(bazarScanImpl==null)
		{
			bazarScanImpl =new BazarScanImpl();
		}
		return bazarScanImpl;
	}
	
	public Session getSession()
	{
		if(session==null)
		{
			session=Utility.getSession();
		}
		return session;
	}
	
	@Override
	public long getRowCount(Class obj) {
		log.info("getRowCount Entered");
		Criteria criteria = bazarScanImpl.getSession().createCriteria(obj);
		criteria.setProjection(Projections.rowCount());
		long i=(Long)criteria.uniqueResult();
		log.info("getRowCount total row:"+i);
		return i;
	}
	
	public boolean isManufacturereExists(String manufacturerName)
	{
		Query query=bazarScanImpl.getSession().createQuery("from manufacturer m where m.mfg_name='"+manufacturerName+"'");
		if(query!=null && query.list().size()>0)
		{
			System.out.println("value exist: "+manufacturerName);
			return true;
		}
		return false;
	}

	@Override
	public void storeManufacturer(Set<String> manufacturerList) {
		Session session = bazarScanImpl.getSession();
		Transaction tx = session.beginTransaction();
		long i=bazarScanImpl.getRowCount(manufacturer.class);
		try {
			for (String manufacturerName : manufacturerList) {
				if(!isManufacturereExists(manufacturerName))
				{
					i++;
					manufacturer m = new manufacturer();
					m.setMfg_id("" + i);
					m.setMfg_name(manufacturerName);
					session.save(m);
				}
				
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			
		}
	}

	@Override
	public void storeProduct_header(List<Product> productList) {
		log.info("storeProduct_header Entered");
		Session session = bazarScanImpl.getSession();
		Transaction tx = session.beginTransaction();
		long index=bazarScanImpl.getRowCount(Product_Header.class);
		try {
			for (Product product : productList) {
			//	if(!isProductExists("Mobile",product.getModelName().substring(0, 10)))
				{
				Product_Header ph = new Product_Header();
				ph.setMfg_model_id(product.getModelName().substring(0, 10));
				ph.setProduct_name("Mobile");
				List<manufacturer> result = (List<manufacturer>) session
						.createQuery(
								"from manufacturer where mfg_name='"
										+ product.getMfg() + "'").list();
				if(result !=null)
				{
					manufacturer mm = (manufacturer) result.get(0);
					ph.setMfg_id("" + mm.getMfg_id());
				}
				else
				{
					ph.setMfg_id("");
				}
				ph.setId("" + index);
				ph.setProduct_color("RED");
				ph.setSub_category("mobile");
				session.save(ph);
				index++;
				}
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			
		}
		log.info("storeProduct_header Exited");
		
	}

	@Override
	public void storeProduct_supplier(List<Product> productList) {
		Session session = bazarScanImpl.getSession();
		Transaction tx = session.beginTransaction();
		long index = bazarScanImpl.getRowCount(Product_Supplier.class);
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

	@Override
	public void storesubcategory(List<Product> productList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void storeReviews(List<Product> productList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isProductExists(String product_name, String modelId) {
		Query query=bazarScanImpl.getSession().createQuery("from Product_Header p where p.product_name='"+product_name+"' AND p.mfg_model_id='"+modelId+"'");
		if(query!=null && query.list().size()>0)
		{
			System.out.println("value exist: "+product_name+ "  "+modelId);
			return true;
		}
		return false;
	}
}
