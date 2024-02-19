package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		List<Seller> list = new ArrayList<>();
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: seller findByDepartment ====");
		Department dep = new Department(2, "Electronics");
		list = sellerDao.findByDepartment(dep);
		for (Seller e : list) {
			System.out.println(e);
		}
		
		System.out.println("\n=== TEST 3: seller findAll ====");
		list = sellerDao.findAll();
		for (Seller e : list) {
			System.out.println(e);
		}
		
		System.out.println("\n=== TEST 4: seller insert ====");
		Seller newSeller = new Seller(null, "Gred", "greg@gmail.com", new Date(), 4000.0, dep);
		sellerDao.insert(newSeller);
		System.out.println("Insertd! New id = " + newSeller.getId());
		
		System.out.println("\n=== TEST 4: seller update ====");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update completed");
	}
}
