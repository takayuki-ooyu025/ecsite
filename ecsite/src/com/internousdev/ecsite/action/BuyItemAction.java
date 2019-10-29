package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	private int count;
	private String pay;

	public String execute(){

		String result = SUCCESS;

		session.put("count", count);

		int intCount = Integer.parseInt(session.get("count").toString());
		int intPrice = Integer.parseInt(session.get("buyItem_price").toString());
		//toStringでいったん文字列型にしてparseIntを使えるようにして、intCountで数字にする
		session.put("total_price", intCount * intPrice);
		//intCount×intPriceを計算してputでsessionに入れている

		String payment;
		if(pay.equals("1")){
			payment = "現金払い";
			session.put("pay", payment);
		}else{
			payment = "クレジットカード";
			session.put("pay", payment);
		}
		return result;
	}


	public void setCount(int count){
		this.count = count;
	}

	public void setPay(String pay){
		this.pay = pay;
	}
	//sessionを使ってjspに表示させているのでreturnはいらない

	public Map<String,Object> getSession(){
		return this.session;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
