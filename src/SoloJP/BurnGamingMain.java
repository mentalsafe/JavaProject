package SoloJP;

import java.sql.*;
import java.util.Scanner;
// 수정 했읍니다.
public class BurnGamingMain {
	public static void main(String[] args) {
		BurnGamingDTO bgDto = new BurnGamingDTO();
		BurnGamingDAO bgDao = new BurnGamingDAO();
		BGTitleDTO bgTitleDto = new BGTitleDTO();
		BGTitleDAO bgTitleDao = new BGTitleDAO();
		Scanner sc = new Scanner(System.in);
		boolean mainStart = true;
		int mainMenu = 0;
		boolean logReg = true;
		int logRegMenu = 0;
		boolean needLogin = true;
		String autoId = "";
		boolean bgtWhile = true;
		int bgtWhileMenu = 0;
		
		while(mainStart) {
			
			if(!logReg) {
				logReg = true;
			}
			bgDao.connect();
			System.out.println();
			System.out.println("==============BGMain에 오신걸 환영합니다================");
			System.out.println("==============! 먼저 로그인해주시길 바랍니다 !=============");
			System.out.println("======1.로그인 및 회원가입  2.타이틀 구매  3.하드웨어 구매 =======");
			System.out.println("======4.하드웨어 옵션 구매  5.크레딧 충전  6.종       료 ==========");
			System.out.println("=================================================");
			System.out.print("원하시는 메뉴번호를 입력해주세요 >>");
			mainMenu = sc.nextInt();
			
			
			
			switch(mainMenu) {
			
			case 1 : //로그인 및 회원가입
					while(logReg) {
						
						System.out.println("================= Login ===================");
						System.out.println("====== 1.로그인     2.회원가입    3.회원정보 수정  =======");
						System.out.println("====== 4.회원정보 삭제  5.내 정보 보기   6.뒤로가기 ======");
						System.out.println("================== Reg ====================");
						System.out.print("원하시는 메뉴번호를 입력해주세요 >>");
						logRegMenu = sc.nextInt();
						
						switch(logRegMenu) {
						
						case 1:
							System.out.println("회원님의 아이디를 입력해주세요 >> ");
							String cId = sc.next();
						
							System.out.println("회원님의 비밀번호를 입력해주세요 >> ");
							String cPw = sc.next();
						
							boolean bcId = bgDao.checkLoginId(cId,cPw);
							if(bcId) {
								needLogin = false;
								System.out.println("로그인 성공!");
							} else {
							System.out.println("입력하신 아이디와 비밀번호가 일치하지 않습니다! 다시 입력해주세요! ");
							System.out.println();
							System.out.println();
							}
							break;
						case 2:
							
							System.out.println("회원님의 정보를 여기다가 입력해주세요!");
							
							System.out.print("아이디를 입력해주세요 >> ");
							String bId = sc.next();
							bgDto.setbId(bId);
							
							System.out.print("비밀번호를 입력해주세요 >> ");
							String bPw = sc.next();
							
							System.out.print("비밀번호 한번 더 입력해주세요 >> ");
							String bPwc = sc.next();
							
							if(bPw.equals(bPwc)) {
								System.out.println("비밀번호가 맞았습니다.");
								bgDto.setbPw(bPw);
							} else {
								System.out.println("비밀번호가 틀렸습니다.");
								break;
							}
							
							System.out.print("회원님의 이름을 입력해주세요 >> ");
							String bName = sc.next();
							bgDto.setbName(bName);
							
							System.out.print("회원님의 생년월일을 입력해주세요 ex) 1234-12-20 >> ");
							String bBirth = sc.next();
							bgDto.setbBirth(bBirth);
							
							System.out.print("회원님의 이메일을 입력해주세요 >> ");
							String bEmail = sc.next();
							bgDto.setbEmail(bEmail);
							
							System.out.print("회원님의 전화번호를 입력해주세요 >> ");
							String bPhone = sc.next();
							bgDto.setbPhone(bPhone);
							
							System.out.print("회원님의 입력할 계좌의 은행이름을  입력해주세요 ex)신한  >> ");
							String bAccountType = sc.next();
							bgDto.setbAccountType(bAccountType);
							
							System.out.print("회원님의 계좌번호를 입력해주세요 ex) '-'제외 >> ");
							int bAccount = sc.nextInt();
							bgDto.setbAccount(bAccount);
							
							bgDao.bgJoin(bgDto);
							System.out.println();
							System.out.println();
							break;
						case 3: // 회원정보 수정
							if(needLogin) {
								System.out.println();
								System.out.println("로그인하고 와주세요~");
								System.out.println();
								break;
							}
							System.out.print("수정할 본인 아이디 >> ");
							bId = sc.next();
							bgDto.setbId(bId);
							
							System.out.print("수정확인용 본인 비밀번호 >> ");
							bPwc = sc.next();
							
							boolean check = bgDao.pwCheck(bPwc);
							
							System.out.print("수정할 본인 비밀번호 >> ");
							bPw = sc.next();
							
							System.out.print("수정할 본인 비밀번호 확인 >> ");
							bPwc = sc.next();
							
							if(bPw.equals(bPwc)) {
								System.out.println("비밀번호가 맞습니다.");
								bgDto.setbPw(bPw);
							} else {
								System.out.println("비밀번호가 틀렸습니다.");
								break;
							}
							
							System.out.print("수정할 본인 이름 >> ");
							bName = sc.next();
							bgDto.setbName(bName);
							
							System.out.print("수정 할 본인 생년월일을 입력해주세요  ex)'-'없이 >> ");
							bBirth = sc.next();
							bgDto.setbBirth(bBirth);
							
							System.out.print("수정 할 본인 이메일을 입력해주세요 >> ");
							bEmail = sc.next();
							bgDto.setbEmail(bEmail);
							
							System.out.print("수정 할 본인 전화번호를 입력해주세요 >> ");
							bPhone = sc.next();
							bgDto.setbPhone(bPhone);
							
							System.out.print("수정 할 본인 은행이름을 입력해주세요  10자리까지 입력해주세요! >> ");
							bAccountType = sc.next();
							bgDto.setbAccountType(bAccountType);
							
							System.out.print("수정 할 본인 계좌번호를 입력해주세요 '-'제외  >> ");
							bAccount = sc.nextInt();
							bgDto.setbAccount(bAccount);
							
							bgDao.bgModify(bgDto);
							break;
						case 4: // 회원삭제
							if(needLogin) {
								System.out.println();
								System.out.println("로그인하고 와주세요~");
								System.out.println();
								break;
							}
							System.out.println("삭제할 본인의 계정을 입력해 주세요!");
							System.out.println();
							System.out.println();
							
							System.out.print("삭제할 아이디 >> ");
							String dId = sc.next();
							
							System.out.print("비밀번호 >> ");
							String dPw = sc.next();
							boolean dCheck = bgDao.deleteCheck(dId,dPw);
							
							if(dCheck) {
								bgDao.mDelete(dId);
							} else {
								System.out.println("아이디와 비밀번호가 일치하지 않습니다 다시입력해주세요.");
							}
						
						case 5: // 자기 정보를 보기
							if(needLogin) {
								System.out.println();
								System.out.println("로그인하고 와주세요~");
								System.out.println();
								break;
							}
								System.out.println("회원님 정보 열람을 위해 아이디를 입력해주세요");
								String ciId = sc.next();
								bgDao.information(ciId);
							break;
							
						case 6: // 종료
							logReg = false;
							System.out.println("뒤로 돌아갑니다~");
							break;
							
						default :
							System.out.println("잘못된 메뉴 번호를 입력하셧습니다 다시 입력해주세요!");
							break;
									}// s end
							} // w end
				break;
			case 2 : // 타이틀 검색
				// 공사중 bgDao.bgBuyt(bgDto);
				while(bgtWhile) {
					System.out.println("============== 타이틀 검색 및 구매 ==============");
					System.out.println("1.타이틀 전체보기 2.장르로 검색  3.결   제  4.뒤로 돌아가기");
					System.out.println("==========================================");
					System.out.print("원하시는 메뉴번호를 입력해주세요 >>");
					bgtWhileMenu = sc.nextInt();
					switch(bgtWhileMenu) {
					case 1 : // 타이틀 전체보기
						bgDao.titleList(); 
						break;
					case 2 : // 장르로 검색
						System.out.println();
						System.out.println("어떤 장르로 검색하실껀가요? 아래에 현재 검색가능한 검색어 입니다.");
						System.out.println();
						bgDao.KGenre();
						System.out.println();
						System.out.print("장르를 입력해주세요! >>");
						System.out.println();
						String SGenre = sc.next();
						bgDao.SGenreList(SGenre);
						
						
						break;
					case 3 : // 결 제
						
						System.out.println();
						System.out.println("상품코드를 입력하셔서 제품을 구매해주세요!\n");
						System.out.println("구매 안하고 돌아가실려면 0번을 눌러주세요\n");
						int iBuy = sc.nextInt();
						bgDao.titleBuy(iBuy);	
						
						break;
					
					case 4 : // 메인메뉴로 돌아가기
						System.out.println("다시 돌아갑니다~");
						bgtWhile = false;
						break;
					
					default :
						System.out.println("잘못된 메뉴 번호를 입력하셧습니다 다시 입력해주세요!");
						break;
						
						
					} // s end
				} // w end
				
				
				
				
				
				break;
			case 3 : // 하드웨어 검색
				bgDao.bgBuyh();
				break;
			case 4 : // 하드웨어 옵션 구매
				// 공사중 bgDao.bgBuyho(bgDto);
				break;
			case 5 : // 현금 충전하기
				if(needLogin) {
					System.out.println();
					System.out.println("로그인하고 와주세요~");
					System.out.println();
					break;
				}
				System.out.println("크레딧 구매");
				System.out.println();
				System.out.print("본인확인을 위해 계좌번호를 입력해주세요 '-'제외 >>");
				int bcAccount = sc.nextInt();
				
				//boolean bACheck = bgDao.bAccountCheck(bcAccount);
				boolean bACheck = bgDao.bAccountCheck(bcAccount);
				if(bACheck) {
					System.out.println();
					System.out.println("회원정보랑 계좌번호가 일치합니다!");
					System.out.println();
					System.out.println("얼마를 충전하시겟습니까?? >>");
					int bCredit = sc.nextInt();
					
					bgDto.setbAccount(bcAccount);
					bgDto.setbCredit(bCredit);
					bgDao.addCredit(bgDto);
				}else {
					System.out.println();
					System.out.println("회원정보랑 계좌번호가 일치하지 않습니다!");
					System.out.println();
				}
				break;
			case 6 : // 종료
				System.out.println();
				System.out.println();
				System.out.println("접속을 종료합니다.");
				bgDao.disconnect();
				mainStart = false;
				break;
			
			default :
				System.out.println("입력오류 입니다~ 메뉴를 다시 골라주세요~");
				break;
			
			
			
			
			
			} // s end
		} // w end
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}
	}