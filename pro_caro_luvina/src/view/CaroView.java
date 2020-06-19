/**
 * Copyright(C) 2018 Luvina Software Company
 * CaroView.java, 20/11/2018 , Luvina
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;

import javax.swing.JFrame;

import common.Constant;
import controller.CaroActionListener;
import model.CaroButton;
/**
 * Tạo giao diện
 * @author Luvina
 */
public class CaroView extends JFrame {
	// khai báo biến để chắc chắn trước và sau khi chuyển đổi, lớp CaroUI là một
	private static final long serialVersionUID = 1L; 	
	// khai báo thuộc tính title với tên là "GAME: CỜ CARO"
	private static final String TITLE = "GAME: CỜ CARO";
	// Khai báo một EventListenser
	private CaroActionListener cellEvent; 
	// tạo thuộc tính arrButt để chứa ma trận bàn cờ
	private CaroButton[][] arrButt = Constant.BUTT_MATR; 
	/**
	 * Vẽ bàn cờ kích thước 20x20
	 */
	public void createGUI() {
		// Khởi tạo giao diện
		initGUI();
		// Khởi tạo các component trong giao diện
		initComponent();
		// đặt chế độ hiển thị cho frame
		setVisible(true); 							
	// kết thúc hàm
	}		
	
	/**
	 * Phương thức khởi tạo giao diện với các thuộc tính.
	 */
	private void initGUI() {
		// Tạo tên tiêu đề
		setTitle(TITLE);								
		//thiết lập kích thước
		setSize(Constant.ROW_BOARD * Constant.SIZE_BUTT, Constant.COL_BOARD * Constant.SIZE_BUTT); 
		// thiết lập cửa sổ xuất hiện ở giữa màn hình desktop
		setLocationRelativeTo(null); 					
		// không cho người dùng thay đổi kích thước cửa sổ	
		setResizable(false); 								
		// thiết lập hoạt động khi nhấn tắt cửa sổ
		setDefaultCloseOperation(EXIT_ON_CLOSE); 		
	}

	/**
	 * Phương thức khởi tạo component
	 */
	private void initComponent() {
		// Khởi tạo một EventListener
		cellEvent = new CaroActionListener();						
		// Tạo 1 GridLayout kích thước 20x20 rồi set giá trị vào Frame
		setLayout(new GridLayout(Constant.ROW_BOARD, Constant.COL_BOARD)); 		
		// Tạo ra các button trên bàn cờ
		// duyệt từng dòng của bàn cờ
		for (int row = 0; row < Constant.ROW_BOARD; row++) { 			
			// duyệt từng cột của bàn cờ
			for (int col = 0; col < Constant.COL_BOARD; col++) { 		
				// Tạo button mới ở vị trí hàng i cột j
				arrButt[row][col] = new CaroButton();		
				// thiết lập kích thước cho các component
				arrButt[row][col].setPreferredSize(new Dimension(Constant.SIZE_BUTT, Constant.SIZE_BUTT));
				// set background cho button
				arrButt[row][col].setBackground(Color.WHITE); 				
				// set font chữ trên button
				arrButt[row][col].setFont(new Font("Forte", Font.BOLD, 22));
				// Căn trái phải trên dưới cho giá trị trong button
				arrButt[row][col].setMargin(new Insets(1, 1, 1, 1)); 		
				// Lưu giá trị tọa độ của một button
				arrButt[row][col].setPoint(new Point(row, col)); 			
				// Hành động xảy ra khi tác động vào button	
				arrButt[row][col].addActionListener(cellEvent); 				
				// Thêm button vào Frame với bố cục đã được chia nhờ GridLayout
				add(arrButt[row][col]); 	
			// kết thúc vòng for duyệt cột
			} 										
		// kết thúc vòng for duyệt dòng	
		} 													
		// giúp frame có kích thước vừa đủ với nội dung của frame
		pack(); 									
	} //kết thúc phương thức
	/**
	 * Thiết lập giá trị cho 1 button
	 * @param butt: 1 button có kiểu là Butt
	 * @param name: giá trị của button ( là X hoặc O)
	 * 
	 */
	public void setFlagButt(CaroButton caroButton, String name) {
		// set tên cho một button
		caroButton.setText(name); 					
		// Nếu giá trị muốn set là "X" là quân cờ của máy
		if ("X".equals(name)) { 					
			// Thì cho giá trị đó màu đỏ
			caroButton.setForeground(Color.RED); 	
			// Nếu giá trị muốn set là "O" là quân cờ của người
		} else { 									
			// Thì cho giá trị đó màu xanh
			caroButton.setForeground(Color.BLUE); 	
		// Kết thúc else
		} 											
	// Kết thúc hàm
	} 	
// đóng class
}