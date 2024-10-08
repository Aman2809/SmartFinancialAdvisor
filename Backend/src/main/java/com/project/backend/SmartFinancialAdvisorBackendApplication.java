 package com.project.backend;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;


import com.project.backend.configuration.AppConstraints;
import com.project.backend.model.Role;
import com.project.backend.repository.RoleRepository;

import java.util.List;

@SpringBootApplication
public class SmartFinancialAdvisorBackendApplication  implements CommandLineRunner{
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(SmartFinancialAdvisorBackendApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.passwordEncoder.encode("aman1234"));
		System.out.println(this.passwordEncoder.encode("subham1234"));
		
		try {
			Role role=new Role();
			role.setRoleId(AppConstraints.ADMIN_USER);
			role.setName("ADMIN_USER");
			
			
			Role role1=new Role();
			role1.setRoleId(AppConstraints.NORMAL_USER);
			role1.setName("NORMAL_USER");
			
			List<Role> roles = List.of(role, role1);
			
			List<Role> result = this.roleRepository.saveAll(roles);
			
			
			result.forEach(r->{
				System.out.println(r.getName());
			});
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

