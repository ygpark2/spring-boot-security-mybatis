package com.kdn.kevcs.mobile.service;


import com.kdn.kevcs.mobile.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Inject
	private UserRepository userRepo;

	private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();

	@Override
	public final User loadUserByUsername(String username) throws UsernameNotFoundException {
		final com.kdn.kevcs.mobile.domain.entity.User user = userRepo.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("user not found");
		}

		String password=user.getPassword();
		List<GrantedAuthority> galist = new ArrayList<GrantedAuthority>();

		String[]roles=user.getAuthorities().split(",");
		for(String role:roles){
			galist.add(new SimpleGrantedAuthority(role));
		}
		// detailsChecker.check(user);
		return new User(username, password, galist);
	}
}
