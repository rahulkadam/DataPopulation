package com.bluestone.bazarscan.dto;

import java.util.Arrays;
import java.util.Map;

public class BookDetails {
	 public	String product_Id;
	 public	String title[];
	 public	String title1;
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
	public String getProduct_Id() {
		return product_Id;
	}
	public void setProduct_Id(String product_Id) {
		this.product_Id = product_Id;
	}
	 public String[] getTitle() {
			return title;
	}
	public void setTitle(String[] titles) {
			this.title = titles;
			if(titles.length>0)
			{
				this.title1=titles[0];
			}
	}
	public String getTitle1() {
		return title1;
	}
	public void setTitle1(String title) {
		this.title1 = title;
	}
	public String getGiftWrapAvailable() {
		return giftWrapAvailable;
	}
	public void setGiftWrapAvailable(String giftWrapAvailable) {
		this.giftWrapAvailable = giftWrapAvailable;
	}
	public String[] getNoOfCustomerReviews() {
		return noOfCustomerReviews;
	}
	public void setNoOfCustomerReviews(String[] noOfCustomerReviews) {
		this.noOfCustomerReviews = noOfCustomerReviews;
	}
	public String getTotalReview() {
		return totalReview;
	}
	public void setTotalReview(String totalReview) {
		this.totalReview = totalReview;
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
	public void setTechDetails(String[] techDetails) {
		this.techDetails = techDetails;
	}
	public String[] getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String[] manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getMfg() {
		return mfg;
	}
	public void setMfg(String mfg) {
		this.mfg = mfg;
	}
	public String[] getInStock() {
		return inStock;
	}
	public void setInStock(String[] inStock) {
		this.inStock = inStock;
	}
	public String getIsInStock() {
		return isInStock;
	}
	public void setIsInStock(String isInStock) {
		this.isInStock = isInStock;
	}
	public String[] getModel() {
		return model;
	}
	public void setModel(String[] model) {
		this.model = model;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String[] getProductSummary() {
		return productSummary;
	}
	public void setProductSummary(String[] productSummary) {
		this.productSummary = productSummary;
	}
	public String getProductSummaryInfo() {
		return productSummaryInfo;
	}
	public void setProductSummaryInfo(String productSummaryInfo) {
		this.productSummaryInfo = productSummaryInfo;
	}
	public String[] getFullProductInfo() {
		return fullProductInfo;
	}
	public void setFullProductInfo(String[] fullProductInfo) {
		this.fullProductInfo = fullProductInfo;
	}
	public String getFullProductDetails() {
		return fullProductDetails;
	}
	public void setFullProductDetails(String fullProductDetails) {
		this.fullProductDetails = fullProductDetails;
	}
	public Map<String, String> getTechmap() {
		return techmap;
	}
	public void setTechmap(Map<String, String> techmap) {
		this.techmap = techmap;
	}
	public String[] getEmiAvailable() {
		return emiAvailable;
	}
	public void setEmiAvailable(String[] emiAvailable) {
		this.emiAvailable = emiAvailable;
	}
	public String getIsEMiAvailable() {
		return isEMiAvailable;
	}
	public void setIsEMiAvailable(String isEMiAvailable) {
		this.isEMiAvailable = isEMiAvailable;
	}
	public String[] getAnsweredQuestions() {
		return answeredQuestions;
	}
	public void setAnsweredQuestions(String[] answeredQuestions) {
		this.answeredQuestions = answeredQuestions;
	}
	public String getNoOfAnsweredQuestions() {
		return noOfAnsweredQuestions;
	}
	public void setNoOfAnsweredQuestions(String noOfAnsweredQuestions) {
		this.noOfAnsweredQuestions = noOfAnsweredQuestions;
	}
	public String[] getAdditionalComments() {
		return additionalComments;
	}
	public void setAdditionalComments(String[] additionalComments) {
		this.additionalComments = additionalComments;
	}
	public String getComments() {
		return Comments;
	}
	public void setComments(String comments) {
		Comments = comments;
	}
	
	@Override
	public String toString() {
		return "BookDetails [product_Id=" + product_Id + ", title=" + title1
				+ ", giftWrapAvailable=" + giftWrapAvailable
				+ ", noOfCustomerReviews="
				+ Arrays.toString(noOfCustomerReviews) + ", totalReview="
				+ totalReview + ", url=" + url + ", techDetails="
				+ Arrays.toString(techDetails) + ", manufacturer="
				+ Arrays.toString(manufacturer) + ", mfg=" + mfg + ", inStock="
				+ Arrays.toString(inStock) + ", isInStock=" + isInStock
				+ ", model=" + Arrays.toString(model) + ", modelName="
				+ modelName + ", productSummary="
				+ Arrays.toString(productSummary) + ", productSummaryInfo="
				+ productSummaryInfo + ", fullProductInfo="
				+ Arrays.toString(fullProductInfo) + ", fullProductDetails="
				+ fullProductDetails + ", techmap=" + techmap
				+ ", emiAvailable=" + Arrays.toString(emiAvailable)
				+ ", isEMiAvailable=" + isEMiAvailable + ", answeredQuestions="
				+ Arrays.toString(answeredQuestions)
				+ ", noOfAnsweredQuestions=" + noOfAnsweredQuestions
				+ ", additionalComments=" + Arrays.toString(additionalComments)
				+ ", Comments=" + Comments + "]";
	}
	 

}
