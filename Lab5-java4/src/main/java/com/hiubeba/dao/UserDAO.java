package com.hiubeba.dao;

import java.util.List;

import com.hiubeba.entity.UserEntity;
import com.hiubeba.utils.JpaUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class UserDAO {
	EntityManager em = JpaUtils.getEntityManager();
	
	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}
	
	public UserEntity create(UserEntity entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
	
	public UserEntity update(UserEntity entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
	
	public UserEntity remove(String id) {
		try {
			UserEntity entity = this.findById(id);
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
	
	public UserEntity findById(String id) {
		UserEntity entity = em.find(UserEntity.class, id);
		return entity;
	}
	
	public List<UserEntity> findAll() {
		String jpql = "SELECT o FROM UserEntity o";
		TypedQuery<UserEntity> query = em.createQuery(jpql, UserEntity.class);
		List<UserEntity> list = query.getResultList();
		return list;
	}
	
	public List<UserEntity> findPhanTrang(int page, int size){
		String jpql = "SELECT o FROM UserEntity o";
		TypedQuery<UserEntity> query = em.createNamedQuery(jpql, UserEntity.class);
		query.setFirstResult(page * size);
		query.setMaxResults(size);
		List<UserEntity> list = query.getResultList();
		return list;
	}
}
