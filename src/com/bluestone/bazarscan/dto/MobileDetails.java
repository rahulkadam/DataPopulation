package com.bluestone.bazarscan.dto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class MobileDetails {
 public	long product_Id; 
 public String giftWrapAvailable;
 public String noOfCustomerReviews[];
 public String totalReview;
 public String url;
 public String techDetails[];
 public String manufacturer[];
 public String mfg;
 public String inStock[];
 public String isInStock;
 public String model[];
 public String modelName;
 public String productSummary[];
 public String productSummaryInfo;
 public String fullProductInfo[];
 public String fullProductDetails;
 public Map<String,String> techmap;
 public String emiAvailable[];
 public String isEMiAvailable;
 public String answeredQuestions[];
 public String noOfAnsweredQuestions;
 public String additionalComments[];
 public String Comments;
public Map<String, String> getTechmap() {
	return techmap;
}



/*public void setTechmap(Map<String, String> techmap) {
	
	this.techmap = techmap;
}*/

public void setTotalReview(String totalReview) {
	this.totalReview = totalReview;
}



public void setMfg(String mfg) {
	this.mfg = mfg;
}



public void setIsInStock(String isInStock) {
	this.isInStock = isInStock;
}



public void setModelName(String modelName) {
	this.modelName = modelName;
}



public void setProductSummaryInfo(String productSummaryInfo) {
	this.productSummaryInfo = productSummaryInfo;
}



public void setFullProductDetails(String fullProductDetails) {
	this.fullProductDetails = fullProductDetails;
}



public void setIsEMiAvailable(String isEMiAvailable) {
	this.isEMiAvailable = isEMiAvailable;
}



public void setNoOfAnsweredQuestions(String noOfAnsweredQuestions) {
	this.noOfAnsweredQuestions = noOfAnsweredQuestions;
}



public void setComments(String comments) {
	Comments = comments;
}



public long getProduct_Id() {
	return product_Id;
}



public void setProduct_Id(long product_Id) {
	this.product_Id = product_Id;
}



public String getGiftWrapAvailable() {
	return this.giftWrapAvailable;
}


public String getMfg() {
	return mfg;
}


public String getTotalReview() {
	return totalReview;
}

public String getIsInStock() {
	return isInStock;
}


public String getIsEMiAvailable() {
	return isEMiAvailable;
}


public String getModelName() {
	return modelName;
}


public String getProductSummaryInfo() {
	return productSummaryInfo;
}

public String getFullProductDetails() {
	return fullProductDetails;
}

public String getNoOfAnsweredQuestions() {
	return noOfAnsweredQuestions;
}


public String getComments() {
	return Comments;
}

public void setGiftWrapAvailable(String giftWrapAvailable) {
	
	String str =giftWrapAvailable.replaceAll("\n","");
	str = str.replaceAll(" ", "");
	if(str.contains("Gift-wrapavailable"))
	{
		str="Available";
	}
	this.giftWrapAvailable = str;
}


public String[] getNoOfCustomerReviews() {
	return noOfCustomerReviews;
}

public void setNoOfCustomerReviews(String noOfCustomerReviews[]) {
	
	this.noOfCustomerReviews = formatString(noOfCustomerReviews);
	if(this.noOfCustomerReviews.length>0)
	{
		this.totalReview=this.noOfCustomerReviews[0];
	}
}

public String getUrl() {
	return url;
}

public void setUrl(String url) {
	this.url = url;
}

public String[] getTechDetails() {
	
	return techDetails;
}

public void setTechDetails(String techDetails[]) {
	this.techmap =new HashMap<String, String>();
	for (String str1 : techDetails) {
		String[] s=str1.split("::");
		this.techmap.put(s[0], s[1]);
	}
	this.techDetails = techDetails;
}


public String[] getManufacturer() {
	return manufacturer;
}

public void setManufacturer(String manufacturer[]) {
	if(manufacturer.length>0)
	{
		this.mfg = manufacturer[0];
	}
	this.manufacturer = manufacturer;
}

public void setTechmap(Map<String, String> techmap) {
	this.techmap = techmap;
}

public String[] getInStock() {
	return inStock;
}

public void setInStock(String inStock[]) {
	
	this.inStock = formatString(inStock);
	if(this.inStock.length>0)
	{
		this.isInStock=this.inStock[0];
	}
}

public String[] getModel() {
	return model;
}

public void setModel(String model[]) {
	this.model = model;
	if(this.model.length>0)
	{
		this.modelName=this.model[0];
	}
}

public String[] getProductSummary() {
	return productSummary;
}

public void setProductSummary(String productSummary[]) {
	
	this.productSummary = formatString(productSummary);
	if(this.productSummary.length>0)
	{
		this.productSummaryInfo=this.productSummary[0];
	}
}

public String[] getFullProductInfo() {
	return fullProductInfo;
}

public void setFullProductInfo(String fullProductInfo[]) {
	
	this.fullProductInfo = formatString(fullProductInfo);
	if(this.fullProductInfo .length>0)
	{
		this.fullProductDetails=this.fullProductInfo[0];		
	}
}

public String[] getEmiAvailable() {
	return emiAvailable;
}

public void setEmiAvailable(String[] emiAvailable) {
	
	this.emiAvailable = formatString(emiAvailable);
	
	for (String str : this.emiAvailable) {		
		if(str.contains("Available")==true)
		{
			this.isEMiAvailable="Available";
		}
  }
}



public String[] getAnsweredQuestions() {
	return answeredQuestions;
}

public void setAnsweredQuestions(String[] answeredQuestions) {
	
	this.answeredQuestions = formatString(answeredQuestions);
	if(this.answeredQuestions.length>0)
	{
		this.noOfAnsweredQuestions=this.answeredQuestions[0];
	}
}

public String[] getAdditionalComments() {
	return additionalComments;
}

public void setAdditionalComments(String[] additionalComments) {
	
	this.additionalComments = formatString(additionalComments);
	if(this.additionalComments.length>0)
	{
		this.Comments=this.additionalComments[0];
	}
}

public String[] formatString(String[] strings)
{
	int i=0;
	for (String s : strings) {
		String str=s.replaceAll("\n", "");
		str=str.replaceAll("  ", ""); 
		str=str.trim();
		strings[i]=str;
		i++;
	}
	return strings;
}
@Override
public String toString() {
	
//	return "queuwes: "+ this.Comments +"  opt:  "+Arrays.toString(additionalComments) + " \n";
	return "Product [giftWrapAvailable=" + giftWrapAvailable + ", noOfCustomerReviews=" + Arrays.toString(noOfCustomerReviews) + ", url=" + url + ", techDetails=" + Arrays.toString(techDetails) + ", manufacturer=" + Arrays.toString(manufacturer)
			+ ", inStock=" + Arrays.toString(inStock) + ", model=" + Arrays.toString(model) + ", productSummary=" + Arrays.toString(productSummary) + ", fullProductInfo=" + Arrays.toString(fullProductInfo) + ", techmap=" + techmap
			+ ", emiAvailable=" + Arrays.toString(emiAvailable) + ", answeredQuestions=" + Arrays.toString(answeredQuestions) + ", additionalComments=" + Arrays.toString(additionalComments) + "] \n";
}






 
}
