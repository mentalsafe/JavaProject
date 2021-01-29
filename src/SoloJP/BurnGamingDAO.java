package SoloJP;

import java.sql.*;
import java.util.Scanner;

public class BurnGamingDAO {
////////////////////////////////////////////////////////////////////////////////////
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Scanner sc = new Scanner(System.in);
	BurnGamingDTO bgDto = new BurnGamingDTO();
	BGTitleDTO bgTitleDto = new BGTitleDTO();
////////////////////////////////////////////////////////////////////////////////////
	public void connect() {
		con = DBC.DBConnect();
	}
////////////////////////////////////////////////////////////////////////////////////
	public void disconnect() {
		try {
			con.close();
			System.out.println("DB접속종료");
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
////////////////////////////////////////////////////////////////////////////////////
	public boolean checkLoginId(String cId, String cPw) { // 아이디 비번체크
		String sql = "SELECT BID FROM BURNGAMING "
					+"WHERE BID=? AND BPW=?";
		boolean checkid = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cId);
			pstmt.setString(2, cPw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				checkid = true;
			} else {
				System.out.println("nope");
				checkid = false;
			}	
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return checkid;
	}
////////////////////////////////////////////////////////////////////////////////////
	/*public boolean checkLoginPw(String bPw) { // 비밀번호체크
		String sql = "SELECT BPW FROM BURNGAMING WHERE BPW=?";
		boolean checkpw = false;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bPw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				checkpw = true;
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
		
		return checkpw;
	}*/
////////////////////////////////////////////////////////////////////////////////////
	public void bgJoin(BurnGamingDTO bgDto) {
		String sql = "INSERT INTO BURNGAMING(BID,BPW,BNAME,BBIRTH,BEMAIL,BPHONE,BACCOUNTTYPE,BACCOUNT) VALUES(?,?,?,?,?,?,?,?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, bgDto.getbId()); 
			pstmt.setString(2, bgDto.getbPw()); 
			pstmt.setString(3, bgDto.getbName());
			pstmt.setString(4, bgDto.getbBirth());
			pstmt.setString(5, bgDto.getbEmail());
			pstmt.setString(6, bgDto.getbPhone());
			pstmt.setString(7, bgDto.getbAccountType());
			pstmt.setInt(8, bgDto.getbAccount());
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("회원가입 성공!");
			} else {
				System.out.println("회원가입 실패!");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} 
	}
////////////////////////////////////////////////////////////////////////////////////	
	public void bgModify(BurnGamingDTO bgDto) {
		String sql = "UPDATE BURNGAMING SET BPW=?, BNAME=?,"
				+ "BBIRTH=?, BEMAIL=?, BPHONE=?, BACCOUNTTYPE=?, BACCOUNT=? "
				+ "WHERE BID=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, bgDto.getbPw());
			pstmt.setString(2, bgDto.getbName());
			pstmt.setString(3, bgDto.getbBirth());
			pstmt.setString(4, bgDto.getbEmail());
			pstmt.setString(5, bgDto.getbPhone());
			pstmt.setString(6, bgDto.getbAccountType());
			pstmt.setInt(7, bgDto.getbAccount());
			pstmt.setString(8, bgDto.getbId());
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println("회원정보 수정성공!");
			} else {
				System.out.println("회원정보 수정실패!");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
	}
////////////////////////////////////////////////////////////////////////////////////
	public boolean pwCheck(String bPwc) {
		String sql = "SELECT BID FROM BURNGAMING "
				+"WHERE BPW=?";
	boolean checkResult = false;
	
	try {
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, bPwc);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			checkResult = true;
		} else {
			checkResult = false;
		}
	} catch (SQLException se) {
		se.printStackTrace();
	}
	return checkResult;
}	
////////////////////////////////////////////////////////////////////////////////////	
	public boolean deleteCheck(String dId, String dPw) {
		String sql = "SELECT BID FROM BURNGAMING "
				+"WHERE BID=? AND BPW=?";
	boolean deleteResult = false;
	
	try {
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, dId);
		pstmt.setString(2, dPw);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			deleteResult = true;
		} else {
			deleteResult = false;
		}
	} catch (SQLException se) {
		se.printStackTrace();
	}
	return deleteResult;
}
///////// ---------------------------------------------------------------	
	public void mDelete(String dId) {
		String sql = "DELETE BURNGAMING WHERE BID=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dId);
			int result = pstmt.executeUpdate();
			
			if(result>0){
				System.out.println("회원정보 삭제성공");
			} else {
				System.out.println("회원정보 삭제실패!");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
////////////////////////////////////////////////////////////////////////////////////
	public void information(String ciId) {
		String sql = "SELECT * FROM BURNGAMING WHERE BID=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ciId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("아이디 : " + rs.getString(1));
				System.out.println("비밀번호 : " + rs.getString(2));
				System.out.println("이름 : " + rs.getString(3));
				System.out.println("생년월일 : " + rs.getString(4));
				System.out.println("이메일 : " + rs.getString(5));
				System.out.println("휴대전화 : " + rs.getString(6));
				System.out.println("은      행 : " + rs.getString(7));
				System.out.println("계좌번호 : " + rs.getString(8));
				System.out.println("보유 금액 : " + rs.getString(9));
				System.out.println();
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
////////////////////////////////////////////////////////////////////////////////////
public boolean bAccountCheck(int bcAccount) {
		String sql = "SELECT BACCOUNT FROM BURNGAMING "
				+"WHERE BACCOUNT=?";
		//String bcAccountInt ="";
		boolean bAccountCheck = false;
	
	try {
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, bcAccount);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			//bcAccount = Integer.parseInt(bcAccountInt);	
			bAccountCheck = true;
		} else {
			bAccountCheck = false;
		}
	} catch (SQLException se) {
		se.printStackTrace();
	}
	return bAccountCheck;
}


////////////////////////////////////////////////////////////////////////////////////
	public void addCredit(BurnGamingDTO bgDto) {
		String sql = "UPDATE BURNGAMING SET BCREDIT = BCREDIT + ? WHERE BACCOUNT =?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bgDto.getbCredit());
			pstmt.setInt(2, bgDto.getbAccount());
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println();
				System.out.println("충전 성공!");
				System.out.println();
			}else {
				System.out.println();
				System.out.println("충전 실패!");
				System.out.println();
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
	}
////////////////////////////////////////////////////////////////////////////////////
	public void titleList() {
		String sql = "SELECT * FROM BGTITLE";
		try {
			pstmt = con.prepareStatement(sql);
						
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println("===================================");
				System.out.println("상품코드 : " + rs.getInt(1));
				System.out.println("타이틀 이름 : " + rs.getString(2));
				System.out.println("장   르 : " + rs.getString(3));
				System.out.println("발매일 : " + rs.getString(4));
				System.out.println("발매기기 : " + rs.getString(5));
				System.out.println("가   격 : " + rs.getInt(6));
				System.out.println("===================================");
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
	}

	
////////////////////////////////////////////////////////////////////////////////////
	
	public void revertCredit(BurnGamingDTO bgDto) {
		String sql = "UPDATE BURNGAMING SET BCREDIT = BCREDIT - ? WHERE BACCOUNT = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bgDto.getbCredit());
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println();
				System.out.println("결제 성공!");
				System.out.println();
			}else {
				System.out.println();
				System.out.println("결제 실패!");
				System.out.println();
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
	}
////////////////////////////////////////////////////////////////////////////////////
	public boolean ibCheck(String ibIdc) {
		String sql = "SELECT BACCOUNT FROM BURNGAMING "
				+"WHERE BACCOUNT=?";
	boolean iBuyResult = false;
	
	try {
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, ibIdc);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			iBuyResult = true;
		} else {
			iBuyResult = false;
		}
	} catch (SQLException se) {
		se.printStackTrace();
	}
	return iBuyResult;
	}
////////////////////////////////////////////////////////////////////////////////////
	public void SGenreList(String sGenre) {
		String sql = "SELECT * FROM BGTITLE WHERE BGTGENRE=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sGenre);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("===================================");
				System.out.println("상품코드 : " + rs.getInt(1));
				System.out.println("타이틀 이름 : " + rs.getString(2));
				System.out.println("장   르 : " + rs.getString(3));
				System.out.println("발매일 : " + rs.getString(4));
				System.out.println("발매기기 : " + rs.getString(5));
				System.out.println("가   격 : " + rs.getInt(6));
				System.out.println("===================================");
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
	}

////////////////////////////////////////////////////////////////////////////////////
	public void KGenre() {
		String sql = "SELECT DISTINCT BGTGENRE FROM BGTITLE";
		try {
			pstmt = con.prepareStatement(sql);
						
			rs = pstmt.executeQuery();
			int i = 1;
			while(rs.next()) {
				System.out.print(" ["+rs.getString(1)+ "] ");
				i++;
			}System.out.print("키워드가 검색됩니다.");
			 
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
////////////////////////////////////////////////////////////////////////////////////
	
	public void titleBuy(int iBuy) {
		boolean qAnswer = true;
		String titleList[][] = {
				{"null","null"},{"게임타이틀 입력","39900"},{"2","23000"},{"3","33000"},{"4","24000"},{"5","21000"},
				{"6","24000"},{"7","41000"},{"8","39900"},{"9","35000"},{"10","66000"}
		};
		
		if(iBuy<0) {} else { System.out.println(); System.out.println("이전 메뉴로 돌아갑니다~\n");} // else 문에서 의도치 않은 출력 발생
		
		if(iBuy>0) {
			System.out.println(titleList[iBuy][0] + "번입니다. 가격은 " + titleList[iBuy][1] +"입니다.\n");
			if(iBuy>0) {
				System.out.println("정말로 구매하실껀가요? 'Y/N' 으로 입력해주세요.\n");
				String tBuyAnswer = sc.next();
				while(qAnswer) {
					switch(tBuyAnswer) {
					case "Y":
						int TransInt = Integer.parseInt(titleList[iBuy][1]);
						String TransString = Integer.toString(TransInt);
						System.out.println("Debug : " + TransInt + "\nNext Debug :" + TransString + "\n");
						System.out.println("결제를 진행합니다.\n");
						// 계좌번호 설정 및 체크
						System.out.print("구매를 위해 계좌번호를 입력해주세요. !'-'빼고 입력해주세요! >>");
						int buyAccount = sc.nextInt();
						boolean AccountCheck = bAccountCheck(buyAccount);
						if (AccountCheck) {
							TransInt = checkCredit(buyAccount);
							System.out.println("if AccountCheck항목 성공!\n 계좌가 인증되었습니다. ");
							
							if(TransInt > checkCredit(buyAccount)) {
								System.out.println("디버그 : 성공! 결제 메소드 발동");
								withdraw(buyAccount,TransInt);
							} else {
								System.out.println("잔액부족 \n" + (TransInt - checkCredit(buyAccount))+ "원 부족합니다!");
						    	System.out.println("현재 잔액은 " + checkCredit(buyAccount) + "원, 결제 금액은 " + TransInt + "원 입니다.");
							}
						} else {
							System.out.println("else AccountCheck항목 실행!\n 계좌가 없거나 틀리셧습니다.");
						}
						
						
					//	bgDto.setbCredit(TransInt);
						// 디버그
					//	TransString = Integer.toString(TransInt);
					//	System.out.println("Debug : " + TransInt + "\n Next Debug :" + TransString );
						
						
						// 디버그 끝
						break;
					case "y": // case Y에 대한 복사 대기중
					
					case "N":
						System.out.println("이전 메뉴로 돌아갑니다.\n");
						qAnswer = false;
						break;
					case "n":
						System.out.println("이전 메뉴로 돌아갑니다.\n");
						qAnswer = false;
						break;
				default :
					System.out.println("잘못된 입력을 하셧습니다.");
						break;
					} //send
				} // wend
				
				
				
			} // if 2 end
		} // if 1 end
		
				
		} // M end
////////////////////////////////////////////////////////////////////////////////////
private void withdraw(int buyAccount, int transInt) {
	String sql = "UPDATE BURNGAMING SET BCREDIT = BCREDIT - ? WHERE BACCOUNT =?";
	try {
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, transInt);
		pstmt.setInt(2, buyAccount);
		
		int result = pstmt.executeUpdate();
		System.out.println("result :  " + result);
		if(result > 0) {
			System.out.println("결제 성공!");
		}else {
			System.out.println("결제 실패!");
		}	
	} catch (SQLException se) {
		se.printStackTrace();
	}
	}
////////////////////////////////////////////////////////////////////////////////////
	private int checkCredit(int buyAccount) {
		String sql = "SELECT BCREDIT FROM BURNGAMING WHERE BACCOUNT = ? ";
		//String bAccount = "";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, buyAccount);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//buyAccount = Integer.parseInt(bAccount);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return buyAccount; 
	}
	public void bgBuyh() {
		// TODO Auto-generated method stub
		
	}

	
	
	
////////////////////////////////////////////////////////////////////////////////////

















} // dont delete

