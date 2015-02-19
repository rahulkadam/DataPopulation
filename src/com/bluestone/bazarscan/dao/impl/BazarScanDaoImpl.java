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
	private Logger log=Logger.getLogger(BazarScanDaoImpl.class.getName());
	
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
			  if(!isExistProductSupplierWithProductId(product_Supplier.getProduct_id()))
			  {
				Transaction tx = session.beginTransaction();
				session.clear();
				session.save(product_Supplier);
				tx.commit();
			  }else
			  {
				 // product_Supplier.getCurrency()
				  log.info("Product Supplier Exist with supplier Id ="+product_Supplier.getSupplier_id());
				  String updateProductSupplier="update Product_Supplier set "+
				  		"in_stock= '"+product_Supplier.getIn_stock()+"',currency ='"+product_Supplier.getCurrency()+"',"+
				  		"product_url='"+product_Supplier.getProduct_id()+"',emi_available='"+product_Supplier.getEmi_available()+"',"+
				  		"gift_wrap='"+product_Supplier.getGift_wrap()+"',mfgId='"+product_Supplier.getMfgId()+"'";
				  if(product_Supplier.getDiscount()!=null)
				  {
					  updateProductSupplier=updateProductSupplier+",discount= '"+product_Supplier.getDiscount()+"'";  
				  }
				  if(product_Supplier.getPrice()!=null)
				  {
					  updateProductSupplier=updateProductSupplier+",price='"+product_Supplier.getPrice()+"'";
				  }
				  if(product_Supplier.getMrp()!=null)
				  {
					  updateProductSupplier=updateProductSupplier+",mrp ='"+product_Supplier.getMrp()+"'";
					  		
				  }
				  updateProductSupplier=updateProductSupplier+" where product_id='"+product_Supplier.getProduct_id()+"'";
				  Transaction tx = session.beginTransaction();
				  int i=session.createQuery(updateProductSupplier).executeUpdate();
//				  Criteria criteria=session.createCriteria(Product_Supplier.class);
				  tx.commit(); 
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean isExistProductSupplierWithProductId(String product_id) {
		String ProductSupplierExistQuery="from Product_Supplier where product_Id='"+product_id +"'";
		Query query=bazarScanImpl.getSession().createQuery(ProductSupplierExistQuery);
		List<Product_Supplier> product_SupplierList=(List<Product_Supplier>)query.list();
		if(product_SupplierList!=null && product_SupplierList.size()>0)
			return true;
		return false;
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
			if(!isProductLineExists(product_Line.getProduct_Id(),product_Line.getGroup_Id(),product_Line.getGroup_Line_Id()))
			{
				Transaction tx = session.beginTransaction();
				session.clear();
				session.merge(product_Line);
				tx.commit();
				
			}
			else
			{
				log.info("Product line already exist with productId +"+product_Line.getProduct_Id());
				String updateProductLineQuery="update Product_Line set value='"+product_Line.getValue()+"', summary='"+product_Line.getSummary()+"'"+
				" where product_Id='"+product_Line.getProduct_Id()+"' and group_Id='"+product_Line.getGroup_Id()+"' and group_Line_Id='"+product_Line.getGroup_Line_Id()+"'";
				Transaction tx = session.beginTransaction();
				int i=session.createQuery(updateProductLineQuery).executeUpdate();
				log.info("Updating product_line :"+i);
				tx.commit();
			}
		} catch (Exception e) {
			log.info("storeLineDetails Catch Error occure");
			e.printStackTrace();
		}
		log.info("storeLineDetails Exited");
	}

	private boolean isProductLineExists(String product_Id,String group_Id,String group_line_Id) {
		String fetchProductLineByProductId="from Product_Line where product_Id='"+product_Id+"' and group_Id='"+group_Id+"' and group_Line_Id='"+group_line_Id+"'";
      Query q=bazarScanImpl.getSession().createQuery(fetchProductLineByProductId);
      List<Product_Line> product_Line_List=(List<Product_Line>)q.list();
		if(product_Line_List !=null && product_Line_List.size()>0)
			return true;
		return false;
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
				session.save(product_Header);
				tx.commit();
			}
		} catch (Exception e) {
			log.info("updateProduct_header Catch Error occure");
			e.printStackTrace();
		}
		log.info("updateProduct_header Exited");
	}
	
	public Map<Product_Spec_Grp_Lines,String> getGroup_Line(){
		

		List<Product_Spec_Grp_Lines> result = (List<Product_Spec_Grp_Lines>) bazarScanImpl.getSession()
		.createQuery(
				"from Product_Spec_Grp_Lines").list();
		String groupLineId="";
		String spec="";
		Map<Product_Spec_Grp_Lines,String> GroupLineMap=new HashMap<Product_Spec_Grp_Lines, String>();
		if(result !=null)
		{
			for(Product_Spec_Grp_Lines product_Spec_Grp_Lines:result)
			{
			groupLineId=product_Spec_Grp_Lines.getGroupLineId();
			spec=product_Spec_Grp_Lines.getSpecificationName();
			product_Spec_Grp_Lines.getGroupId();
			GroupLineMap.put(product_Spec_Grp_Lines, groupLineId);
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
