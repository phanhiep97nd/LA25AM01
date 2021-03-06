﻿/**
 * Copyright(C) 2020  Luvina Software
 *Main.java, 11:18:39 PM Phan Văn Hiệp
 */
package bai2;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Thực thi chương trình
 * 
 * @author Phan Văn Hiệp
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CDDatabase cdDb = new CDDatabase();
		do {
			System.out.println("-----------MENU-----------");
			System.out.println("1.Thêm CD!");
			System.out.println("2.Xóa CD!");
			System.out.println("3.Tìm kiếm theo title!");
			System.out.println("4.Tìm kiếm theo artist!");
			System.out.println("5.Thoát!");
			int choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1:
				CD cdInsert = new CD();
				System.out.println("------------1.Thêm CD!----------");
				System.out.println("Mời bạn nhập tên artist:");
				cdInsert.setArtist(sc.nextLine());
				System.out.println("Mời bạn nhập title: ");
				cdInsert.setTitle(sc.nextLine());
				boolean checkInsert;
				try {
					checkInsert = cdDb.insertCD(cdInsert);
					if (checkInsert) {
						System.out.println("Đã thêm thành công!");
					} else {
						System.out.println("Đã có lỗi xảy ra! Không thêm thành công!");
					}
				} catch (SQLException e) {
					System.out.println("Có lỗi hệ thống!");
				}				
				break;
			case 2:
				CD cdRemove = new CD();
				System.out.println("------------2.Xóa CD!----------");
				System.out.println("Mời bạn nhập tên artist của CD muốn xóa:");
				cdRemove.setArtist(sc.nextLine());
				System.out.println("Mời bạn nhập title của CD muốn xóa: ");
				cdRemove.setTitle(sc.nextLine());
				boolean checkRemove;
				try {
					checkRemove = cdDb.removeCD(cdRemove);
					if (checkRemove) {
						System.out.println("Đã xóa thành công!");
					} else {
						System.out.println("Đã có lỗi xảy ra! Không xóa thành công!");
					}
				} catch (SQLException e) {
					System.out.println("Có lỗi hệ thống!");
				}
			
				break;
			case 3:
				System.out.println("------------3.Tìm kiếm theo title!----------");
				System.out.println("Mời bạn nhập title muốn tìm kiếm:");
				String titleInput = sc.nextLine();
				System.out.println("Nhập trường muốn sắp xếp: ");
				String sortField = sc.nextLine();
				ArrayList<CD> lstCD;
				try {
					lstCD = cdDb.findByTitle(titleInput,sortField);
					if (lstCD.isEmpty()) {
						System.out.println("Không tìm thấy kết quả nào!!!!");
					} else {
						for (CD c : lstCD) {
							System.out.print("Artist: " + c.getArtist() + " || ");
							System.out.println("Title: " + c.getTitle());
						}
					}
				} catch (Exception e) {
					System.out.println("Có lỗi hệ thống!");
				}
			
				break;
			case 4:
				System.out.println("------------4.Tìm kiếm theo artist!----------");
				System.out.println("Mời bạn nhập artist muốn tìm kiếm:");
				String artistInput = sc.nextLine();
				ArrayList<CD> lstcdByArtist;
				try {
					lstcdByArtist = cdDb.findByArtist(artistInput);
					if (lstcdByArtist.isEmpty()) {
						System.out.println("Không tìm thấy kết quả nào!!!!");
					} else {
						for (CD c : lstcdByArtist) {
							System.out.print("Artist: " + c.getArtist() + " || ");
							System.out.println("Title: " + c.getTitle());
						}
					}
				} catch (SQLException e) {
					System.out.println("Có lỗi hệ thống!");
				}
				
				break;
			case 5:
				System.out.println("Hẹn gặp lại!!!!!!!!");
				System.exit(0);
				break;
			case 6:
				ArrayList<CD> lstCdAll;
				try {
					lstCdAll = cdDb.getAll();
					if (lstCdAll.isEmpty()) {
						System.out.println("Không tìm thấy kết quả nào!!!!");
					} else {
						for (CD c : lstCdAll) {
							System.out.print("Artist: " + c.getArtist() + " || ");
							System.out.println("Title: " + c.getTitle());
						}
					}
				} catch (SQLException e) {
					System.out.println("Có lỗi hệ thống!");
				}
				
				break;
			default:
				System.out.println("Bạn đã chọn sai chức năng!!!! Mời chọn từ 1 đến 5!!");
				break;
			}
		} while (true);
	}
}
