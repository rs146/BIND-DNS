package com.blackcrowsys.dataaccess.user;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blackcrowsys.domain.User;

@Repository
@Transactional
public class HibernateUserDao implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(readOnly = true)
	public List<User> findAllUsers() {
		Criteria criteria = this.sessionFactory.getCurrentSession()
				.createCriteria(User.class);

		return criteria.list();
	}

	@Transactional(readOnly = true)
	public User findUser(Integer id) {
		return (User) this.sessionFactory.getCurrentSession().get(User.class,
				id);
	}

	@Transactional(readOnly = true)
	public User findUser(String username) {
		Criteria criteria = this.sessionFactory.getCurrentSession()
				.createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));

		return (User) criteria.uniqueResult();
	}

	public void saveUser(User user) {
		this.sessionFactory.getCurrentSession().save(user);
	}

	public void deleteUser(User user) {
		this.sessionFactory.getCurrentSession().delete(user);
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
