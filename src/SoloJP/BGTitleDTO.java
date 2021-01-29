package SoloJP;

import java.util.HashMap;
import java.util.Map;

public class BGTitleDTO {
	int bgTitleNo;
	String bgtName;
	String bgtGenre;
    String bgtRelease;
    String bgtDevice;
    int bgtPrice;
	
	
	//getset
	
		public int getBgTitleNo() {
			return bgTitleNo;
		}

		public void setBgTitleNo(int bgTitleNo) {
			this.bgTitleNo = bgTitleNo;
		}

		public String getBgtName() {
			return bgtName;
		}

		public void setBgtName(String bgtName) {
			this.bgtName = bgtName;
		}

		public String getBgtGenre() {
			return bgtGenre;
		}

		public void setBgtGenre(String bgtGenre) {
			this.bgtGenre = bgtGenre;
		}

		public String getBgtRelease() {
			return bgtRelease;
		}

		public void setBgtRelease(String bgtRelease) {
			this.bgtRelease = bgtRelease;
		}

		public String getBgtDevice() {
			return bgtDevice;
		}

		public void setBgtDevice(String bgtDevice) {
			this.bgtDevice = bgtDevice;
		}

		public int getBgtPrice() {
			return bgtPrice;
		}

		public void setBgtPrice(int bgtPrice) {
			this.bgtPrice = bgtPrice;
		}

		
// 오버라이드
		

		@Override
		public String toString() {
			return "BGTitleDTO [bgTitleNo=" + bgTitleNo + ", bgtName=" + bgtName + ", bgtGenre=" + bgtGenre
					+ ", bgtRelease=" + bgtRelease + ", bgtDevice=" + bgtDevice + ", bgtPrice=" + bgtPrice + "]";
		}
		// 상품리스트 출력할 메서드
		/*public String toString() {
			return getGoodsNo()+"\t"+getgName()+"\t"+getDanga();
			}
			}*/
		public BGTitleDTO() {
			super();
		}

		public BGTitleDTO(int bgTitleNo, String bgtName, String bgtGenre, String bgtRelease, String bgtDevice,
				int bgtPrice) {
			super();
			this.bgTitleNo = bgTitleNo;
			this.bgtName = bgtName;
			this.bgtGenre = bgtGenre;
			this.bgtRelease = bgtRelease;
			this.bgtDevice = bgtDevice;
			this.bgtPrice = bgtPrice;
		}

		
	/*	Goods(int goodsNo, String gName, int danga) {
		this.goodsNo = goodsNo;
		this.gName = gName;
		this.danga = danga;
		}
    */
}	
	
		
		