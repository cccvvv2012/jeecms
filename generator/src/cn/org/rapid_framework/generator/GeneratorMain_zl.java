package cn.org.rapid_framework.generator;

/**
 * 
 * @author badqiu
 * @email badqiu(a)gmail.com
 */

public class GeneratorMain_zl {
 

	/**
	 * 请直接修改以下代码调用不同的方法以执行相关生成任务.
	 */
	public static void main(String[] args) {
		try {
			GeneratorData(2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void GeneratorData(int gType) throws Exception {
		GeneratorFacade g = new GeneratorFacade();
		g.printAllTableNames(); // 打印数据库中的表名称
		g.deleteOutRootDir(); // 删除生成器的输出目录
		if (gType == 1) {
			// 通过数据库表生成文件,生成为springmvc为模板的根目录
			g.generateByTable("user_info", "springmvc");
		} else {
			// 通过数据库表生成文件,生成为ibatis为模板的根目录
			g.generateByTable("user_info", "ibatis");
		}
		// 打开文件夹
		Runtime.getRuntime().exec(
				"cmd.exe /c start "
						+ GeneratorProperties.getRequiredProperty("outRoot"));
	}
}
