package com.bluestone.bazarscan.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import com.bluestone.bazarscan.dao.BazarScanDao;
import com.bluestone.bazarscan.dto.MobileDetails;
import com.bluestone.bazarscan.dto.Product_Header;
import com.bluestone.bazarscan.dto.Product_Line;
import com.bluestone.bazarscan.dto.Product_Spec_Grp_Lines;
import com.bluestone.bazarscan.dto.Product_Spec_Grps;
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
				session.saveOrUpdate(product_Supplier);
				tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void storesubcategory(List<MobileDetails> productList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void storeReviews(List<MobileDetails> productList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isProductExists(String productId) {
		Query query=bazarScanImpl.getSession().createQuery("from Product_Header p where p.id='"+productId+"'");
		if(query!=null && query.list().size()>0)
		{
			System.out.println("value exist: "+productId);
			session.flush();
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
	

	@Override
	public void storeLineDetails(Product_Line product_Line) {
		log.info("storeLineDetails Entered");
		Session session = bazarScanImpl.getSession();
		try {
//			if(!isProductExists(product_Header.getProduct_name(),product_Header.getSub_category()))
			{
				Transaction tx = session.beginTransaction();
				session.save(product_Line);
				tx.commit();
			}
		} catch (Exception e) {
			log.info("storeLineDetails Catch Error occure");
			e.printStackTrace();
		}
		log.info("storeLineDetails Exited");
	}

	@Override
	public String getGroup_Line_Id(String specName) {

		List<Product_Spec_Grp_Lines> result = (List<Product_Spec_Grp_Lines>) bazarScanImpl.getSession()
		.createQuery(
				"from Product_Spec_Grp_Lines where specificationName='"
						+ specName + "'").list();
		String groupLineId="";
		if(result !=null)
		{
			Product_Spec_Grp_Lines mm = (Product_Spec_Grp_Lines) result.get(0);
			groupLineId=mm.getGroupLineId();
		}
		return groupLineId;
		
	}

	@Override
	public String getGroup_Id(String Group_Id) {

		List<Product_Spec_Grps> result = (List<Product_Spec_Grps>) bazarScanImpl.getSession()
		.createQuery(
				"from Product_Spec_Grps where specificationGroup='"
						+ Group_Id + "'").list();
		String groupLineId="";
		if(result !=null)
		{
			Product_Spec_Grps mm = (Product_Spec_Grps) result.get(0);
			groupLineId=mm.getGroupId();
		}
		return groupLineId;
	}
	
	public void updateProduct_header(Product_Header product_Header)
	{
	
		log.info("updateProduct_header Entered");
		Session session = bazarScanImpl.getSession();
		try {
			{
				Transaction tx = session.beginTransaction();
				session.update(product_Header);
				tx.commit();
			}
		} catch (Exception e) {
			log.info("updateProduct_header Catch Error occure");
			e.printStackTrace();
		}
		log.info("updateProduct_header Exited");
	}
	
	public Map<String,String> getGroup_Line(){
		

		List<Product_Spec_Grp_Lines> result = (List<Product_Spec_Grp_Lines>) bazarScanImpl.getSession()
		.createQuery(
				"from Product_Spec_Grp_Lines").list();
		String groupLineId="";
		String spec="";
		Map<String,String> GroupLineMap=new HashMap<String, String>();
		if(result !=null)
		{
			for(Product_Spec_Grp_Lines product_Spec_Grp_Lines:result)
			{
			groupLineId=product_Spec_Grp_Lines.getGroupLineId();
			spec=product_Spec_Grp_Lines.getSpecificationName();
			GroupLineMap.put(spec, groupLineId);
			}
		}
		return GroupLineMap;
	}
	public Map<String,String> getGroups()
	{

		List<Product_Spec_Grps> result = (List<Product_Spec_Grps>) bazarScanImpl.getSession()
		.createQuery(
				"from Product_Spec_Grps").list();
		String groupLineId="";
		String spec="";
		Map<String,String> GroupsMap=new HashMap<String, String>();
		if(result !=null)
		{
			for(Product_Spec_Grps product_Spec_Grps:result)
			{
			groupLineId=product_Spec_Grps.getGroupId();
			spec=product_Spec_Grps.getSpecificationGroup();
			GroupsMap.put(spec, groupLineId);
			}
		}
		return GroupsMap;
	}


}
