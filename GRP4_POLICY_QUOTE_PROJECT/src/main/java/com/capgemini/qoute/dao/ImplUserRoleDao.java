package com.capgemini.qoute.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.capgemini.quote.entity.Role;
import com.capgemini.quote.entity.User;
import com.capgemini.quote.util.JPAUtil;

public class ImplUserRoleDao implements IUserRoleDao {

	private EntityManager em;

	public ImplUserRoleDao() {
		em = JPAUtil.getEntityManager();
	}

	@Override
	public User getUserById(String userName) {
		User user = em.find(User.class, userName);
		return user;
	}

	@Override
	public List<Role> getRoleList() {
		List<Role> list = em.createQuery("SELECT a FROM Role a", Role.class).getResultList();
		return list;
	}

	@Override
	public void createUser(User user) {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}

	@Override
	public User Login() {
		Scanner sc = new Scanner(System.in);
		System.out.println("***Enter Your Login Details***");
		System.out.println("\nEnter User Name");
		String userName = sc.next();
		System.out.println("Enter Password");
		String password = sc.next();

		User user = em.find(User.class, userName);
		if (user==null) {
			System.out.println("User Not Found");
		}
		else{
			if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
				System.out.println("****Online Insurance Quote Generation System****");
				return user;
			}
			else {
				System.out.println("Wrong Credentials");	
				return null;			
			}						
		}

		return null;
	}
}
