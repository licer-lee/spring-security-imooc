package com.imooc.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService, SocialUserDetailsService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public SocialUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String password = "123456";
		logger.info("登陆用户名：" + username + "登陆成功");
		return new SocialUser(username, passwordEncoder.encode(password), true, true, true, true, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN,ROLE_USER"));
	}

	@Override
	public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
		String password = "123456";
		logger.info("登陆用户ID：" + userId + "登陆成功");
		return new SocialUser(userId, passwordEncoder.encode(password), true, true, true, true, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));
	}

}
