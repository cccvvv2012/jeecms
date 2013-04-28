package com.common.tool;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class ImageUtils {

	public static void cutImage(String strSrc, String strDst, Integer intWidth,
			Integer intHeight) throws IOException {
		File fromFile = new File(strSrc);
		BufferedImage srcImage = ImageIO.read(fromFile);
		Integer intX = 0;
		Integer intY = 0;
		if (srcImage.getWidth() - intWidth > 0) {
			intX = (srcImage.getWidth() - intWidth) / 2;
		}
		if (srcImage.getHeight() - intHeight > 0) {
			intY = (srcImage.getHeight() - intHeight) / 2;
		}
		cutImage(strSrc, strDst, intX, intY, intWidth, intHeight);
	}

	/**
	 * 
	 * 对图片裁剪，并把裁剪完蛋新图片保存 。
	 * 
	 */
	public static void cutImage(String strSrc, String strDst, Integer intX,
			Integer intY, Integer intWidth, Integer intHeight)
			throws IOException {
		FileInputStream is = null;
		ImageInputStream iis = null;
		if (intX == null) {
			intX = 0;
		}
		if (intY == null) {
			intY = 0;
		}
		try {
			// 读取图片文件
			is = new FileInputStream(strSrc);
			/**
			 * 返回包含所有当前已注册 ImageReader 的 Iterator，这些 ImageReader
			 * 声称能够解码指定格式。参数：formatName - 包含非正式格式名称 . （例如 "jpeg" 或 "tiff"）等 。
			 */
			Iterator<ImageReader> it = ImageIO
					.getImageReadersByFormatName("jpg");
			ImageReader reader = it.next();
			// 获取图片流
			iis = ImageIO.createImageInputStream(is);
			/**
			 * <p>
			 * iis:读取源.true:只向前搜索
			 * </p>
			 * .将它标记为 ‘只向前搜索’。 此设置意味着包含在输入源中的图像将只按顺序读取，可能允许 reader
			 * 避免缓存包含与以前已经读取的图像关联的数据的那些输入部分。
			 */
			reader.setInput(iis, true);
			/**
			 * <p>
			 * 描述如何对流进行解码的类
			 * <p>
			 * .用于指定如何在输入时从 Java Image I/O 框架的上下文中的流转换一幅图像或一组图像。用于特定图像格式的插件 将从其
			 * ImageReader 实现的 getDefaultReadParam 方法中返回 ImageReadParam 的实例。
			 */
			ImageReadParam param = reader.getDefaultReadParam();
			/**
			 * 图片裁剪区域。Rectangle 指定了坐标空间中的一个区域，通过 Rectangle 对象
			 * 的左上顶点的坐标（x，y）、宽度和高度可以定义这个区域。
			 */
			Rectangle rect = new Rectangle(intX, intY, intWidth, intHeight);
			// 提供一个 BufferedImage，将其用作解码像素数据的目标。
			param.setSourceRegion(rect);
			/**
			 * 使用所提供的 ImageReadParam 读取通过索引 imageIndex 指定的对象，并将 它作为一个完整的
			 * BufferedImage 返回。
			 */
			BufferedImage bi = reader.read(0, param);
			// 保存新图片
			ImageIO.write(bi, "jpg", new File(strDst));
		} finally {
			if (is != null)
				is.close();
			if (iis != null)
				iis.close();
		}
	}

	public static void main(String[] args) throws Exception {
		// String strSrc = "e:/index/head07.jpg";
		// String strDst = "e:/index/head08.jpg";
		// String strDst1 = "e:/index/head09.jpg";
		// saveImageAsJpg(strSrc, strDst, 200, 100);

		// setImage(strSrc, 200, 100);
	}

	public static BufferedImage resize(BufferedImage source, int targetW,
			int targetH) {
		// targetW，targetH分别表示目标长和宽
		int type = source.getType();
		BufferedImage target = null;
		double sx = (double) targetW / source.getWidth();
		double sy = (double) targetH / source.getHeight();
		// 这里想实现在targetW，targetH范围内实现等比缩放。如果不需要等比缩放
		// 则将下面的if else语句注释即可
		if (sx < sy) {
			sx = sy;
			targetW = (int) (sx * source.getWidth());
		} else {
			sy = sx;
			targetH = (int) (sy * source.getHeight());
		}
		if (type == BufferedImage.TYPE_CUSTOM) { // handmade
			ColorModel cm = source.getColorModel();
			WritableRaster raster = cm.createCompatibleWritableRaster(targetW,
					targetH);
			boolean alphaPremultiplied = cm.isAlphaPremultiplied();
			target = new BufferedImage(cm, raster, alphaPremultiplied, null);
		} else
			target = new BufferedImage(targetW, targetH, type);
		Graphics2D g = target.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		g.drawRenderedImage(source, AffineTransform.getScaleInstance(sx, sy));
		g.dispose();
		return target;
	}

	public static void saveImageAsJpg(String fromFileStr, String saveToFileStr,
			int width, int hight) throws Exception {
		BufferedImage srcImage;
		String imgType = "JPEG";
		if (fromFileStr.toLowerCase().endsWith(".png")) {
			imgType = "PNG";
		}
		File saveFile = new File(saveToFileStr);
		File fromFile = new File(fromFileStr);
		srcImage = ImageIO.read(fromFile);
		if (width > 0 || hight > 0) {
			srcImage = resize(srcImage, width, hight);
		}
		ImageIO.write(srcImage, imgType, saveFile);
	}

	public static void setImage(String strSrc, Integer intWidth,
			Integer intHeight) throws Exception {
		saveImageAsJpg(strSrc, strSrc + "temp", intWidth, intHeight);
		FileUtils.deleteFile(strSrc);
		cutImage(strSrc + "temp", strSrc, intWidth, intHeight);
		FileUtils.deleteFile(strSrc + "temp");
		// FileUtils.moveFile(strSrc + "temp", strSrc);
	}
}