package aplication.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import aplication.config.JpaConfig;

public abstract class DaoAbstrato<T, I extends Serializable> {

	protected EntityManager entityManager;

	private Class<T> persistedClass;

	protected DaoAbstrato() {
	}

	protected DaoAbstrato(Class<T> persistedClass) {
		this.persistedClass = persistedClass;
		entityManager = JpaConfig.iniciarConexao();
	}

	public T salvar(T entity) {
		EntityTransaction t = entityManager.getTransaction();
		t.begin();
		entityManager.persist(entity);
		entityManager.flush();
		t.commit();
		return entity;
	}

	public List<T> salvarTodos(List<T> entitis) {
		EntityTransaction t = entityManager.getTransaction();
		t.begin();
		for (T entity : entitis) {
			entityManager.persist(entity);
			entityManager.flush();
		}
		t.commit();
		return entitis;
	}

	public T atualizar(T entity) {
		EntityTransaction t = entityManager.getTransaction();
		t.begin();
		entityManager.merge(entity);
		entityManager.flush();
		t.commit();
		return entity;
	}

	public void remover(I id) {
		T entity = encontrar(id);
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		T mergedEntity = entityManager.merge(entity);
		entityManager.remove(mergedEntity);
		entityManager.flush();
		tx.commit();
	}

	public List<T> getList() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(persistedClass);
		query.from(persistedClass);
		return entityManager.createQuery(query).getResultList();
	}

	public T encontrar(I id) {
		return entityManager.find(persistedClass, id);
	}
}
