package org.comit.spring.service;

import java.util.List;

import org.comit.spring.bean.ShopingCart;
import org.comit.spring.dao.ShopingCartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopingCartService {

	@Autowired
	ShopingCartDao shopingcartDao;
	
	public List<ShopingCart> listShopingCart() {
		
		return this.shopingcartDao.listShopingCart();
	}
	
	
	
}
