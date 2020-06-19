/**
 * Copyright(C) 2018 Luvina Software Company
 * CaroLogic.java,20/11/2018, Luvina
 */
package logic;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import common.Constant;
import model.CaroButton;
import model.PositionModel;

/**
 * Tạo class CaroLogic xử lý logic trong việc chơi cờ
 * 
 * @author Luvina
 */
public class CaroLogic {
	// tạo thuộc tính arrButt để chứa ma trận bàn cờ
	private CaroButton[][] arrButt = Constant.BUTT_MATR;
	// listTheCo để lưu các thế cờ được đọc ra từ file theCo.txt
	public static ArrayList<PositionModel> listPosition;
	// thuộc tính chỉ số hàng của bàn cờ
	private int rowBoard = Constant.ROW_BOARD;
	// thuộc tính chỉ số cột của bàn cờ
	private int colBoad = Constant.COL_BOARD;
	// thuộc tính chỉ số hàng của thế cờ
	private int rowMat = Constant.ROW_MATR;
	// thuộc tính chỉ số cột của thế cờ
	private int colMat = Constant.COL_MATR;
	// số hàng cần duyệt khi so sánh thế cờ với bàn cờ
	private int maxX = rowBoard - rowMat;
	// số cột cần duyệt khi so sánh thế cờ với bàn cờ
	private int maxY = colBoad - colMat;

	/**
	 * Kiểm tra thắng thua
	 * @param point Tọa độ của điểm vừa được đánh
	 * @return true nếu thắng, false nếu chưa thắng
	 */
	public boolean checkWin(Point point) {
		// kiểm tra checkWinCol hoặc checkWinRow hoặc checkWinMainDiagonal hoặc checkWinAntiDiagonal = true
		return (checkWinCol(point) || checkWinRow(point) || checkWinAntiDiagonal(point) || checkWinMainDiagonal(point));
	// kết thúc hàm
	}
	
	/**
	 * Kiểm tra tính thắng theo cột
	 * @param point Tọa độ của điểm vừa được đánh
	 * @return true: thắng, false: chưa thắng
	 */
	private boolean checkWinCol(Point point) {
		// x và y là tọa độ điểm vừa đánh vào
		// getX trả về double nên cần chuyển về kiểu int
		int x = (int) point.getX();
		// getY trả về double nên cần chuyển về kiểu int
		int y = (int) point.getY();
		// Tạo một biến đếm bằng 0
		int count = 0;
		// duyệt từ trước vị trí i 4 ô và sau vị trị i 4 ô
		for (int i = -4; i <= 4; i++) { 
			// nếu các vị trí kiểm tra thuộc ô bàn cờ
			if (x + i >= 0 && x + i < rowBoard) { 
				// nếu vị trí hiện tại và vị trí kiểm tra có giá trị giống nhau
				if (arrButt[x][y].getText().equals(arrButt[x + i][y].getText())) {
					// biến đếm tăng lên 1
					count++; 		
					// nếu biến đếm bằng 5
					if (count == 5) { 
						// return true
						return true; 
					// kết thúc if so sánh count = 5 hay không
					} 				
				// nếu 2 vị trí so sánh có giá trị khác nhau
				} else { 			
					// count đặt lại bằng 0
					count = 0; 		
				// kết thúc else
				} 					
			// kết thúc if kiểm tra vị trí thuộc ô bàn cờ không
			}						
		// kết thúc for
		} 							
		// Không thỏa mãn điều kiện trả về false
		return false; 				
	// kết thúc phương thức
	} 								

	/**
	 * Kiểm tra tính thắng theo hàng ngang
	 * @param point Tọa độ của điểm vừa được đánh
	 * @return true nếu thắng, false nếu chưa thắng
	 */
	private boolean checkWinRow(Point point) {
		// x và y là tọa độ điểm vừa đánh vào
		// getX trả về double nên cần chuyển về kiểu int
		int x = (int) point.getX();
		// getY trả về double nên cần chuyển về kiểu int
		int y = (int) point.getY();
		// Tạo một biến đếm bằng 0
		int count = 0;
		// duyệt từ trước vị trí i 4 ô và sau vị trị i 4 ô
		for (int i = -4; i <= 4; i++) { 
			// nếu các vị trí kiểm tra thuộc ô bàn cờ
			if (y + i >= 0 && y + i < colBoad) { 
				// nếu vị trí hiện tại và vị trí kiểm tra có giá trị giống nhau
				if (arrButt[x][y].getText().equals(arrButt[x][y + i].getText())) {
					// biến đếm tăng lên 1
					count++; 		
					// nếu biến đếm bằng 5
					if (count == 5) { 
						// return true
						return true; 
					// kết thúc if so sánh count = 5 hay không
					} 				
				// nếu 2 vị trí so sánh có giá trị khác nhau
				} else { 			
					// count đặt lại bằng 0
					count = 0; 		
				// kết thúc else
				} 					
			// kết thúc if kiểm tra vị trí thuộc ô bàn cờ không
			}						
		// kết thúc for
		} 							
		// Không thỏa mãn điều kiện trả về false
		return false; 				
	// kết thúc phương thức
	} 								

	/**
	 * Kiểm tra tính thắng theo đường chéo chính
	 * @param point Tọa độ của điểm vừa được đánh
	 * @return true nếu thắng, false nếu chưa thắng
	 */
	private boolean checkWinMainDiagonal(Point point) {
		// x và y là tọa độ điểm vừa đánh vào
		// getX trả về double nên cần chuyển về kiểu int
		int x = (int) point.getX();
		// getY trả về double nên cần chuyển về kiểu int
		int y = (int) point.getY();
		// Tạo một biến đếm bằng 0
		int count = 0;
		// duyệt từ vị trí hiện tại chéo lên góc trái trên 4 ô và chéo xuống góc phải dưới 4 ô
		for (int i = -4, j = -4; i <= 4 && j <= 4; i++, j++) {
			// nếu các vị trí kiểm tra thuộc ô bàn cờ
			if (y + i >= 0 && y + i < colBoad && x + j >= 0 && x + j < rowBoard) { 
				// nếu vị trí hiện tại và vị trí kiểm tra có giá trị giống nhau
				if (arrButt[x][y].getText().equals(arrButt[x + j][y + i].getText())) {
					// biến đếm tăng lên 1
					count++; 		
					// nếu biến đếm bằng 5
					if (count == 5) { 
						// return true
						return true; 
					// kết thúc if so sánh count = 5 hay không
					} 				
				// nếu 2 vị trí so sánh có giá trị khác nhau
				} else { 			
					// count đặt lại bằng 0
					count = 0; 		
				// kết thúc else
				} 					
			// kết thúc if kiểm tra vị trí thuộc ô bàn cờ không
			}						
		// kết thúc for
		} 							
		// Không thỏa mãn điều kiện trả về false
		return false; 				
	// kết thúc phương thức
	} 								

	/**
	 * Kiểm tra tính thắng theo đường chéo phụ
	 * @param point Tọa độ của điểm vừa được đánh
	 * @return true nếu thắng, false nếu chưa thắng
	 */
	private boolean checkWinAntiDiagonal(Point point) {
		// x và y là tọa độ điểm vừa đánh vào
		// getX trả về double nên cần chuyển về kiểu int
		int x = (int) point.getX();
		// getY trả về double nên cần chuyển về kiểu int
		int y = (int) point.getY();
		// Tạo một biến đếm bằng 0
		int count = 0;
		// duyệt từ vị trí hiện tại chéo xuống góc trái dưới 4 ô và chéo lên góc phải trên 4 ô
		for (int i = -4, j = 4; i <= 4 && j >= -4; i++, j--) {
			 // nếu các vị trí kiểm tra thuộc ô bàn cờ
			if (y + i >= 0 && y + i < colBoad && x + j >= 0 && x + j < rowBoard) {
				// nếu vị trí hiện tại và vị trí kiểm tra có giá trị giống nhau
				if (arrButt[x][y].getText().equals(arrButt[x + j][y + i].getText())) {
					// biến đếm tăng lên 1
					count++; 		
					// nếu biến đếm bằng 5
					if (count > 5) { 
						// return true
						return true; 
					// kết thúc if so sánh count = 5 hay không
					} 				
				// nếu 2 vị trí so sánh có giá trị khác nhau
				} else { 			
					// count đặt lại bằng 0
					count = 0; 		
				// kết thúc else
				} 					
			// kết thúc if kiểm tra vị trí thuộc ô bàn cờ không
			}						
		// kết thúc for
		} 							
		// Không thỏa mãn điều kiện trả về false
		return false; 				
	// kết thúc phương thức
	} 								

	/**
	 * Kiểm tra số nước đã đánh trong bàn cờ
	 * @param countMove đếm số nước đã đi được
	 * @return true nếu hòa cờ, false khi chưa hòa cờ
	 */
	public boolean checkMove(int countMove) {
		//khởi tạo 1 biến check
		boolean check = false; 
		 //nếu số nước đi của máy bằng một nửa tổng số ô bàn cờ
		if (countMove == (rowBoard * colBoad) / 2) {
			// true nếu đã đi hết các ô bàn cờ
			check = true; 
		// kết thúc if
		} 
		// trả về kết quả của biến check
		return check; 
	// kết thúc hàm
	}
	
	/**
	 * Tạo một bàn cờ 5x5 từ bàn cờ cho trước 20x20 để so sánh với thế cờ
	 *
	 * @param x Tọa độ x của ô bàn cờ
	 * @param y Tọa độ y của ô bàn cờ
	 * @return trả về bàn cờ con 5x5 với tọa độ ô trên trái cùng là (x, y)
	 */
	private String[][] getSubBoad(int x, int y) {
		// tạo ma trận subBoad 5x5
		String[][] subBoad = new String[Constant.ROW_MATR][Constant.COL_MATR]; 
		// duyệt hàng ngang của mảng
		for (int i = 0; i < rowMat; i++) { 
			// duyệt hàng dọc
			for (int j = 0; j < colMat; j++) { 
				// lưu giá trị từng ô bàn cờ vào mảng 5x5
				subBoad[i][j] = arrButt[i + x][j + y].getText(); 
			// kết thúc duyệt hàng dọc
			}
		// kết thúc duyệt hàng ngang
		} 
		// trả về mảng hai chiều (ma trận)
		return subBoad;
	// kết thúc hàm
	} 

	/**
	 * Trả về tọa độ điểm mà máy cần đánh vào
	 * 
	 * @param positionModel Đối tượng thế cờ là ma trận 5x5
	 * @param subB       Đối tượng bàn cờ con là ma trận 5x5
	 * @return
	 */
	private Point findPoint(PositionModel positionModel, String[][] subB) {
		// Tạo một biến kiểu Point để lưu tọa độ trả về
		Point point = null;
		// check vị trí bàn cờ với thế cờ. Nếu check = 0 thì không đánh. Nếu check = 1 thì trả về 1 quân cờ
		int check = 1; 
		// đưa thế cờ vào mảng
		char[][] position = positionModel.getPosition(); 
		// duyệt theo hàng ngang của thế cờ
		 flag: for (int i = 0; i < rowMat; i++) {      
			// duyệt theo hàng dọc của thế cờ
			for (int j = 0; j < colMat; j++) { 	
				// lấy từng giá trị của bàn cờ con
				String value = subB[i][j]; 		
				// switch case để so sánh thế cờ từ file với bàn cờ con lấy từ bàn cờ
				switch (position[i][j]) { 		
				// nếu vị trí hiện tại của thế cờ là G
				case 'G': 						
				// thoát switch case
					break; 						
					// nếu vị trí hiện tại của thế cờ là T
				case 'T': 						
					// Kiểm tra tại vị trí thì bàn cờ con khác null
					if (!"".equals(value)) { 	
						// gán check = 0
						check = 0; 				
						// kết thúc if
					} 							
					// thoát switch case
					break;						
					// nếu vị trí hiện tại của thế cờ là D
				case 'D': 						
					// Kiểm tra tại vị trí thì bàn cờ con khác null
					if (!"".equals(value)) { 	
						// gán check = 0
						check = 0; 				
						// Kiểm tra tại vị trí thì bàn cờ con khác null
					} else { 					
						// lấy tọa độ điểm đang duyệt tới
						point = new Point(i, j);
						// kết thúc else
					} 							
					// thoát swith case
					break; 						
					// nếu vị trí hiện tại của thế cờ là X
				case 'X': 						
					// Kiểm tra tại vị trí thì bàn cờ con khác X
					if (!"X".equals(value)) { 	
						// gán check = 0
						check = 0; 				
						// kết thúc if
					} 							
					// thoát swith case
					break; 						
					// nếu vị trí hiện tại của thế cờ là O
				case 'O': 						
					// Kiểm tra tại vị trí thì bàn cờ con khác O
					if (!"O".equals(value)) { 	
						// gán check = 0
						check = 0; 				
						// kết thúc if
					} 							
					// thoát swith case
					break; 						
					// kết thúc switch case
				} 								
				// nếu check = 0
				if (check == 0) { 				
					// thoát khỏi for duyệt theo cột
					break flag; 						
					// kết thúc if
				} 								
				// kết thúc for duyệt theo cột
			} 									
			// kết thúc for duyệt theo hàng
		} 										
		// nếu check = 0
		if (check == 0) { 						
			// trả về null
			return null; 						
			// nếu check khác 0
		} else {								
			// trả về tọa độ điểm X máy cần đánh
			return point;				
			// kết thúc else
		} 			
		 // kết thúc hàm
	}

	/**
	 * Trả về tọa độ điểm máy cần đánh vào trên bàn cờ 20x20
	 * @return xPoint chứa tọa độ điểm máy cần đánh
	 */
	public Point getXPointComputer() {
		// tạo một biến kiểu Point để lát trả về điểm máy đánh
		Point xPoint = null; 
		// tương ứng tọa độ x, y điểm X cần đánh vào
		int x, y;
		// duyệt list thế cờ
		flagX:for (PositionModel itemPosition : listPosition) { 	
			// duyệt theo hàng của bàn cờ
			for (int i = 0; i <= maxX; i++) { 		
				// duyệt theo cột của bàn cờ
				for (int j = 0; j <= maxY; j++) { 	
					// Lấy bàn cờ con từ điểm có tọa độ (i, j)
					String[][] subBoad = getSubBoad(i, j); 
					// Tìm tọa độ điểm X cần đánh
					Point point = findPoint(itemPosition, subBoad); 
					// nếu tọa độ cần tìm khác null
					if (point != null) { 
						// tọa độ cần đánh = tìm được bằng tọa độ tìm được + tọa độ đang duyệt ở bàn cờ
						x = i + (int) point.getX(); 
						// tọa độ cần đánh = tìm được bằng tọa độ tìm được + tọa độ đang duyệt ở bàn cờ			
						y = j + (int) point.getY(); 
						// chứa tọa độ trả về cho máy đánh
						xPoint = new Point(x, y); 
						// đã đánh được rồi thì break hàm
						break flagX; 
					// kết thúc điều kiện
					} 
				// kết thúc for duyệt theo cột
				} 
			// kết thúc for duyệt theo hàng
			}
		// kết thúc for duyệt list thế cờ
		} 
		// kiểm tra nếu xpoint null
		if (xPoint == null) { 
			// đánh random
			xPoint = randomPoint();
		// kết thúc điều kiện	
		} 
		// đã đánh được rồi thì return thoát hàm đến người đánh
		return xPoint; 
	// kết thúc hàm
	} 
	
	/**
		 * Tạo hàm đánh random tạo ra 1 điểm
		 * @return điểm random
	 */
	private Point randomPoint() {
		// khởi tạo biến xpointRd
		Point xpointRd = null; 
		// khởi tạo 1 mảng chứa các button còn trống
		ArrayList<CaroButton> arrButtRandom = new ArrayList<>(); 
		// duyệt vòng for theo hàng
		for (int i = 0; i < arrButt.length; i++) { 
			// duyệt theo cột
			for (int j = 0; j < arrButt.length; j++) { 
				// kiểm tra button đó còn trống
				if ("".equals(arrButt[i][j].getText())) { 
					// thêm button còn trống vào mảng
					arrButtRandom.add(arrButt[i][j]); 
				// kết thúc điều kiện
				} 
			// kết thúc vòng for duyệt cột
			} 
		// kết thúc vòng for duyệt hàng
		} 
		// khởi tạo random
		Random rd = new Random(); 
		// lấy 1 giá trị random trong mảng
		int p = rd.nextInt(arrButtRandom.size()); 
		// lấy ra 1 điểm
		xpointRd = arrButtRandom.get(p).getPoint(); 
		// trả về điểm random
		return xpointRd;
	// kết thúc hàm
	} 
// kết thúc class
} 
