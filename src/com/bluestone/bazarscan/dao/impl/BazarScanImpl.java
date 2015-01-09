package com.bluestone.bazarscan.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import com.bluestone.bazarscan.dao.BazarScanDao;
import com.bluestone.bazarscan.dto.Product;
import com.bluestone.bazarscan.util.Utility;

public class BazarScanImpl implements BazarScanDao{

	private static Session session=null;
	
	private BazarScanImpl bazarScanImpl=new BazarScanImpl();
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
		Session s = bazarScanImpl.getSession();
		Criteria crit = s.createCriteria(obj);
		crit.setProjection(Projections.rowCount());
		long i=(Long)crit.uniqueResult();
		return i;
	}
	
	public boolean isManufacturereExists(String mfgName)
	{
		Session s = bazarScanImpl.getSession();
		Query query=s.createQuery("from manufacturer m where m.mfg_name='"+mfgName+"'");
		if(query.list().size()>0)
		{
			System.out.println("value exist: "+mfgName);
			return true;
		}
		return false;
	}

	@Override
	public void storeManufacturer(List<Product> productList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void storeProduct_header(List<Product> productList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void storeProduct_supplier(List<Product> productList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void storesubcategory(List<Product> productList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void storeReviews(List<Product> productList) {
		// TODO Auto-generated method stub
		
	}
}
