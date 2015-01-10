package com.bluestone.bazarscan.dao.impl;

import java.util.List;

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

public class BazarScanDaoImpl implements BazarScanDao{

	private static Session session=null;
	
	private static BazarScanDaoImpl bazarScanImpl;
	private Logger log=Logger.getLogger(MobileTestClient.class.getName());
	
	private BazarScanDaoImpl() {

	}
	
	public static BazarScanDaoImpl getInstance()
	{
		if(bazarScanImpl==null)
		{
			bazarScanImpl =new BazarScanDaoImpl();
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
	public void storeManufacturer(manufacturer manufactr) {
		log.info("storeManufacturer Entered "+manufactr);
		Session session = bazarScanImpl.getSession();
		try {
				//if(!isManufacturereExists(manufactr.getMfg_name()))
				{
					Transaction tx = session.beginTransaction();
					session.save(manufactr);
					tx.commit();
			}
		} catch (Exception e) {
			log.info("storeManufacturer catch error occure");
			e.printStackTrace();
		} finally {
			log.info("storeManufacturer EXITED");
		}
	}

	@Override
	public void storeProduct_header(Product_Header product_Header) {
		log.info("storeProduct_header Entered");
		Session session = bazarScanImpl.getSession();
		try {
//			if(!isProductExists(product_Header.getProduct_name(),product_Header.getSub_category()))
			{
				Transaction tx = session.beginTransaction();
				session.save(product_Header);
				tx.commit();
			}
		} catch (Exception e) {
			log.info("storeProduct_header Catch Error occure");
			e.printStackTrace();
		}
		log.info("storeProduct_header Exited");
	}

	
	@Override
	public void storeProduct_supplier(Product_Supplier product_Supplier) {
		Session session = bazarScanImpl.getSession();
		try {
				Transaction tx = session.beginTransaction();
				session.save(product_Supplier);
				tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
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

	

	@Override
	public String getManufacturerIdFromName(String productName) {

		List<manufacturer> result = (List<manufacturer>) bazarScanImpl.getSession()
		.createQuery(
				"from manufacturer where mfg_name='"
						+ productName + "'").list();
		String mfg_id="";
		if(result !=null)
		{
			manufacturer mm = (manufacturer) result.get(0);
			mfg_id=mm.getMfg_id();
		}
		return mfg_id;
	}
}
