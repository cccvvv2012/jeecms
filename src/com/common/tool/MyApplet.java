package com.common.tool;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.io.IOException;

public class MyApplet extends Applet {

	AudioClip sound;

	/**
	 * Constructor of the applet.
	 * 
	 * @exception HeadlessException
	 *                if GraphicsEnvironment.isHeadless() returns true.
	 */
	public MyApplet() {
		super();
	}

	@Override
	public void destroy() {
		// Put your code here
	}

	@Override
	public String getAppletInfo() {
		return "This is my default applet created by Eclipse";
	}

	@Override
	public void init() {
		sound = getAudioClip(getDocumentBase(), "味道.au");
	}

	/**
	 * 
	 * 通过applet调用本地的计算器
	 */

	public void openApp() {

		String url = "C:\\WINDOWS\\system32\\calc.exe";

		System.out.println("url=" + url);

		try {

			Runtime.getRuntime().exec(url);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g) {
		Font f = new Font("楷体_GB123", Font.BOLD, 40);
		g.setFont(f);
		g.setColor(Color.blue);
		g.drawString("辛晓琪 - 味道", 0, 50);
	}

	@Override
	public void start() {
		sound.play();
	}

	@Override
	public void stop() {
		sound.stop();
	}
	/*
	 * public final void setStub(AppletStub stub);
	 * //设置Applet的stub.stub是Java和C之间转换参数并返回值的代码位，它是由系统自动设定的。 public boolean
	 * isActive();// 判断一个Applet是否处于活动状态。 public URL getDocumentBase();//
	 * 检索表示该Applet运行的文件目录的对象。 public URL getCodeBase();// 获取该Applet 代码的URL地址。
	 * public String getParameter(String name)；// 获取该Applet 由name指定参数的值。 public
	 * AppletContext getAppletContext()；// 返回浏览器或小应用程序观察器。 public void
	 * resize(int width,int height)；// 调整Applet运行的窗口尺寸。 public void
	 * resize(Dimension d)；// 调整Applet运行的窗口尺寸。 public void showStatus(String
	 * msg)；// 在浏览器的状态条中显示指定的信息。 public Image getImage(URL url)； //
	 * 按url指定的地址装入图象。 public Image getImage(URL url,String name)；//
	 * 按url指定的地址和文件名加载图像。 public AudioClip getAudioClip(URL url)；//
	 * 按url指定的地址获取声音文件。 public AudioClip getAudioClip(URL url, String name)；//
	 * 按url指定的地址和文件名获取声音。 public String getAppletInfo()；//
	 * 返回Applet应用有关的作者、版本和版权方面的信息； public String[][] getParameterInfo()； //
	 * 返回描述Applet参数的字符串数组，该数组通常包含三个字符串： 参数名、该参数所需值的类型和该参数的说明。 public void
	 * play(URL url)；// 加载并播放一个url指定的音频剪辑。
	 */

}
