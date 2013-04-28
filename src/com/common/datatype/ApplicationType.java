package com.common.datatype;

public class ApplicationType {
	private String strShangChuanXiangDuiLuJing; // 上传文件相对路径
	private String strShuJuKuBeiFenLuJing; // 数据库备份路径
	private String strMysqlDiZhi; // 数据库mysql程序地址
	private String strMysqldumpDiZhi; // 数据库mysqldump程序地址
	private String strKaiQiZiDongBeiFen; // 开启自动备份
	private String strShuJuKuYongHuMing; // 数据库用户名
	private String strShuJuKuMiMa; // 数据库密码
	private String strShuJuKuURL; // 数据库连接URL
	private String strShuJuMingCheng; // 数据库名称
	private String strShiYongDanWei; // 使用单位
	private String strXiTongMingCheng; // 系统名称
	private String strRiZhiLuJing; // 日志路径

	private String strHTMLAuthor; // HTML代码Title中的Author
	private String strHTMLCopyright; // HTML代码Title中的Copyright
	private String strHTMLUser; // HTML代码Title中的User
	private String strHTMLTitle; // HTML代码Title中的Title
	private String strHTMLURL; // HTML代码Title中的URL
	private String strHTMLMeta; // HTML代码Title中的其他Meta

	private Integer intFenYeDaXiao; // 默认分页大小

	public Integer getIntFenYeDaXiao() {
		return intFenYeDaXiao;
	}

	public String getStrHTMLAuthor() {
		return strHTMLAuthor;
	}

	public String getStrHTMLCopyright() {
		return strHTMLCopyright;
	}

	public String getStrHTMLMeta() {
		return strHTMLMeta;
	}

	public String getStrHTMLTitle() {
		return strHTMLTitle;
	}

	public String getStrHTMLURL() {
		return strHTMLURL;
	}

	public String getStrHTMLUser() {
		return strHTMLUser;
	}

	public String getStrKaiQiZiDongBeiFen() {
		return strKaiQiZiDongBeiFen;
	}

	public String getStrMysqlDiZhi() {
		return strMysqlDiZhi;
	}

	public String getStrMysqldumpDiZhi() {
		return strMysqldumpDiZhi;
	}

	public String getStrRiZhiLuJing() {
		return strRiZhiLuJing;
	}

	public String getStrShangChuanXiangDuiLuJing() {
		return strShangChuanXiangDuiLuJing;
	}

	public String getStrShiYongDanWei() {
		return strShiYongDanWei;
	}

	public String getStrShuJuKuBeiFenLuJing() {
		return strShuJuKuBeiFenLuJing;
	}

	public String getStrShuJuKuMiMa() {
		return strShuJuKuMiMa;
	}

	public String getStrShuJuKuURL() {
		return strShuJuKuURL;
	}

	public String getStrShuJuKuYongHuMing() {
		return strShuJuKuYongHuMing;
	}

	public String getStrShuJuMingCheng() {
		try {
			if (strShuJuKuURL != null && strShuJuKuURL.length() > 0) {
				String strTemp = strShuJuKuURL.substring(strShuJuKuURL
						.lastIndexOf("/") + 1, strShuJuKuURL.length());
				return strTemp;
			} else {
				return strShuJuMingCheng;
			}
		} catch (Exception e) {
			return strShuJuMingCheng;
		}
	}

	public String getStrXiTongMingCheng() {
		return strXiTongMingCheng;
	}

	public void setIntFenYeDaXiao(Integer intFenYeDaXiao) {
		this.intFenYeDaXiao = intFenYeDaXiao;
	}

	public void setStrHTMLAuthor(String strHTMLAuthor) {
		this.strHTMLAuthor = strHTMLAuthor;
	}

	public void setStrHTMLCopyright(String strHTMLCopyright) {
		this.strHTMLCopyright = strHTMLCopyright;
	}

	public void setStrHTMLMeta(String strHTMLMeta) {
		this.strHTMLMeta = strHTMLMeta;
	}

	public void setStrHTMLTitle(String strHTMLTitle) {
		this.strHTMLTitle = strHTMLTitle;
	}

	public void setStrHTMLURL(String strHTMLURL) {
		this.strHTMLURL = strHTMLURL;
	}

	public void setStrHTMLUser(String strHTMLUser) {
		this.strHTMLUser = strHTMLUser;
	}

	public void setStrKaiQiZiDongBeiFen(String strKaiQiZiDongBeiFen) {
		this.strKaiQiZiDongBeiFen = strKaiQiZiDongBeiFen;
	}

	public void setStrMysqlDiZhi(String strMysqlDiZhi) {
		this.strMysqlDiZhi = strMysqlDiZhi;
	}

	public void setStrMysqldumpDiZhi(String strMysqldumpDiZhi) {
		this.strMysqldumpDiZhi = strMysqldumpDiZhi;
	}

	public void setStrRiZhiLuJing(String strRiZhiLuJing) {
		this.strRiZhiLuJing = strRiZhiLuJing;
	}

	public void setStrShangChuanXiangDuiLuJing(
			String strShangChuanXiangDuiLuJing) {
		this.strShangChuanXiangDuiLuJing = strShangChuanXiangDuiLuJing;
	}

	public void setStrShiYongDanWei(String strShiYongDanWei) {
		this.strShiYongDanWei = strShiYongDanWei;
	}

	public void setStrShuJuKuBeiFenLuJing(String strShuJuKuBeiFenLuJing) {
		this.strShuJuKuBeiFenLuJing = strShuJuKuBeiFenLuJing;
	}

	public void setStrShuJuKuMiMa(String strShuJuKuMiMa) {
		this.strShuJuKuMiMa = strShuJuKuMiMa;
	}

	public void setStrShuJuKuURL(String strShuJuKuURL) {
		this.strShuJuKuURL = strShuJuKuURL;
	}

	public void setStrShuJuKuYongHuMing(String strShuJuKuYongHuMing) {
		this.strShuJuKuYongHuMing = strShuJuKuYongHuMing;
	}

	public void setStrShuJuMingCheng(String strShuJuMingCheng) {
		this.strShuJuMingCheng = strShuJuMingCheng;
	}

	public void setStrXiTongMingCheng(String strXiTongMingCheng) {
		this.strXiTongMingCheng = strXiTongMingCheng;
	}

}
