package ksmart.mybatis.dto;

public class goods {
	private String goodsCode;
	private String goodsName;
	private String goodsPrice;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("goods [goodsCode=");
		builder.append(goodsCode);
		builder.append(", goodsName=");
		builder.append(goodsName);
		builder.append(", goodsPrice=");
		builder.append(goodsPrice);
		builder.append(", goodsSellerId=");
		builder.append(goodsSellerId);
		builder.append(", goodsRegDate=");
		builder.append(goodsRegDate);
		builder.append("]");
		return builder.toString();
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsSellerId() {
		return goodsSellerId;
	}
	public void setGoodsSellerId(String goodsSellerId) {
		this.goodsSellerId = goodsSellerId;
	}
	public String getGoodsRegDate() {
		return goodsRegDate;
	}
	public void setGoodsRegDate(String goodsRegDate) {
		this.goodsRegDate = goodsRegDate;
	}
	private String goodsSellerId;
	private String goodsRegDate;
}
