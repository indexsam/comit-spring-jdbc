package org.comit.spring.security;

import org.comit.spring.bean.Customer;
import org.comit.spring.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("UserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	CustomerDao customerDao;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Customer customer = this.customerDao.findUserEmail(email);
		
		if(customer==null) {
			throw new UsernameNotFoundException("User not found: " + email);
		}
				
		return new CustomUserDetails(customer);
	}

}
