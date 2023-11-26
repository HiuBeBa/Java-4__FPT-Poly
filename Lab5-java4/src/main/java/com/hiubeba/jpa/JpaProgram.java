package com.hiubeba.jpa;

import java.util.List;

import com.hiubeba.entity.UserEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class JpaProgram {
	public static void main(String[] args) {
//		create();
//		 update();
//		 delete();
//		 findAll();
//		findByRole(true);
//		findByKeyword("Nguyễn");
//		findOne("1", "123");
//		findPage(2, 3);

	}

	private static void findPage(int page, int size) {
		// Nạp persistence.xml và tạo EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
		// Tạo EntityManager để bắt đầu làm việc với CSDL
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin(); // Bắt đầu Transaction

			// Câu lệnh truy vấn JPQL
			String jpql = "SELECT o FROM UserEntity o";
			// Tạo đối tượng truy vấn
			TypedQuery<UserEntity> query = em.createQuery(jpql, UserEntity.class);
			query.setFirstResult(page * size);
			query.setMaxResults(size);
			// Truy vấn
			List<UserEntity> list = query.getResultList();
			// Hiển thị kết quả truy vấn
			for(UserEntity user: list) {
			System.out.println("ID: " + user.getId());
			System.out.println(">>Fullname: " + user.getFullname());
			System.out.println(">>Is Admin: " + user.getAdmin());
			}


			em.getTransaction().commit(); // Chấp nhận kết quả thao tác
		} catch (Exception e) {
			em.getTransaction().rollback(); // Hủy thao tác
			System.out.println("Error: " + e);
		}
		em.close();
		emf.close();

	}

	private static void findOne(String username, String password) {
		// Nạp persistence.xml và tạo EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
		// Tạo EntityManager để bắt đầu làm việc với CSDL
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin(); // Bắt đầu Transaction

			// Câu lệnh truy vấn JPQL
			String jpql = "SELECT o FROM UserEntity o WHERE o.id=:id AND o.password=:pw";
			// Tạo đối tượng truy vấn
			TypedQuery<UserEntity> query = em.createQuery(jpql, UserEntity.class);
			query.setParameter("id", username);
			query.setParameter("pw", password);

			// Truy vấn một thực thể
			UserEntity user = query.getSingleResult();

			// Hiển thị kết quả truy vấn
			System.out.println("--------------------------------");
			System.out.println(
					user.getId() + "\t" + user.getFullname() + "\t" + user.getEmail() + "\t" + user.getAdmin());

			em.getTransaction().commit(); // Chấp nhận kết quả thao tác
		} catch (Exception e) {
			em.getTransaction().rollback(); // Hủy thao tác
			System.out.println("Error: " + e);
		}
		em.close();
		emf.close();

	}

	private static void findByKeyword(String keyword) {
		// Nạp persistence.xml và tạo EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
		// Tạo EntityManager để bắt đầu làm việc với CSDL
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin(); // Bắt đầu Transaction

			// Câu lệnh truy vấn JPQL
			String jpql = "SELECT o FROM UserEntity o WHERE o.fullname LIKE ?1";
			// Tạo đối tượng truy vấn
			TypedQuery<UserEntity> query = em.createQuery(jpql, UserEntity.class);
			query.setParameter(1, "%" + keyword + "%");
			// Truy vấn
			List<UserEntity> list = query.getResultList();
			// Hiển thị kết quả truy vấn
			System.out.println("--------------------------------");
			for (UserEntity user : list) {
				System.out.println(
						user.getId() + "\t" + user.getFullname() + "\t" + user.getEmail() + "\t" + user.getAdmin());
			}

			em.getTransaction().commit(); // Chấp nhận kết quả thao tác
		} catch (Exception e) {
			em.getTransaction().rollback(); // Hủy thao tác
			System.out.println("Error: " + e);
		}
		em.close();
		emf.close();
	}

	private static void findByRole(boolean role) {
		// Nạp persistence.xml và tạo EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
		// Tạo EntityManager để bắt đầu làm việc với CSDL
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();// Bắt đầu Transaction

			// Câu lệnh truy vấn JPQL
			String jpql = "SELECT o FROM UserEntity o WHERE o.admin=:role";
			// Tạo đối tượng truy vấn
			TypedQuery<UserEntity> query = em.createQuery(jpql, UserEntity.class);
			query.setParameter("role", role);
			// Truy vấn
			List<UserEntity> list = query.getResultList();
			System.out.println("=========================================");
			// Hiển thị kết quả truy vấn
			for (UserEntity user : list) {
				System.out.println(user.getId() + "===" + user.getFullname() + "===" + user.getAdmin());
			}

			em.getTransaction().commit();// Chấp nhận kết quả thao tác
			System.out.println("FindByRole thành công!");
		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
			System.out.println("FindByRole thất bại");
		}
		em.close();
		emf.close();
	}

	private static void findAll() {
		// Nạp persistence.xml và tạo EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
		// Tạo EntityManager để bắt đầu làm việc với CSDL
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();// Bắt đầu Transaction

			// Câu lệnh truy vấn JPQL
			String jpql = "SELECT o FROM UserEntity o";
			// Tạo đối tượng truy vấn
			TypedQuery<UserEntity> query = em.createQuery(jpql, UserEntity.class);
			// Truy vấn
			List<UserEntity> list = query.getResultList();
			System.out.println("=========================================");
			// Hiển thị kết quả truy vấn
			for (UserEntity user : list) {
				System.out.println(user.getId() + "/t" + user.getFullname());
			}

			em.getTransaction().commit();// Chấp nhận kết quả thao tác
			System.out.println("FindAll thành công!");
		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
			System.out.println("FindAll thất bại");
		}
		em.close();
		emf.close();
	}

	private static void delete() {
		// Nạp persistence.xml và tạo EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
		// Tạo EntityManager để bắt đầu làm việc với CSDL
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();// Bắt đầu Transaction

			UserEntity entity = em.find(UserEntity.class, "TeoNV");
			em.remove(entity);

			em.getTransaction().commit();// Chấp nhận kết quả thao tác
			System.out.println("Delete thành công!");
		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
			System.out.println("Delete thất bại");
		}
		em.close();
		emf.close();
	}

	private static void update() {
		// TODO Auto-generated method stub
		// Nạp persistence.xml và tạo EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
		// Tạo EntityManager để bắt đầu làm việc với CSDL
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();// Bắt đầu Transaction

			// Truy vấn thực thể theo id
			UserEntity entity = em.find(UserEntity.class, "TeoNV");
			// Thay đổi thông tin thực thể
			entity.setPassword("poly@2020");
			entity.setAdmin(true);
			// Cập nhật thực thể
			em.merge(entity);

			em.getTransaction().commit();// Chấp nhận kết quả thao tác
			System.out.println("Update thành công!");
		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
			System.out.println("Update thất bại");
		}
		em.close();
		emf.close();
	}

	private static void create() {
		// Nạp persistence.xml và tạo EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
		// Tạo EntityManager để bắt đầu làm việc với CSDL
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();// Bắt đầu Transaction
			UserEntity entity = new UserEntity();
			entity.setId("TeoNV");
			entity.setFullname("Nguyễn Văn Tèo");
			entity.setEmail("teonv@gmail.com");
			entity.setPassword("123456");
			em.persist(entity);
			em.getTransaction().commit();// Chấp nhận kết quả thao tác
			System.out.println("Thêm mới thành công!");
		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
			System.out.println("Thêm mới thất bại");
		}
		em.close();
		emf.close();
	}
}
