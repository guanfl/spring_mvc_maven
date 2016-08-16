/**
* ClassName : TwoDimensionCode.java
* Create on ：2016年6月21日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@163.com
*/
package com.spring.mvc.qrcode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.lowagie.text.pdf.codec.Base64.OutputStream;
import com.swetake.util.Qrcode;

import jp.sourceforge.qrcode.QRCodeDecoder;
import jp.sourceforge.qrcode.exception.DecodingFailedException;

/**
 * 二维码解码实现类
 */
public class TwoDimensionCode {
    /**
     * 生成二维码(QRCode)图片
     * @param contents 存储内容
     * @param path 图片路径
     * @throws IOException 
     */
    public void encodeQrcodeImage(String contents, String imgPath) throws IOException {
        this.encodeQrcodeImage(contents, imgPath, "png");
    }

    /**
     * 生成二维码图片
     * @param contents 存储内容
     * @param output 输出流
     * @throws IOException 
     */
    public void encodeQrcodeImage(String contents, OutputStream output) throws IOException {
        this.encodeQrcodeImage(contents, output, "png");
    }

    public void encodeQrcodeImage(String contents, String imgPath, String imgType) throws IOException {
        int codeVersion = 7;
        this.encodeQrcodeImage(contents, imgPath, imgType, codeVersion);
    }

    /**
     * 生成二维码图片
     * @param contents 存储内容
     * @param output 输出流
     * @param imgType 图片类型
     * @throws IOException 
     */
    public void encodeQrcodeImage(String contents, OutputStream output, String imgType) throws IOException {
        int codeVersion = 7;
        this.encodeQrcodeImage(contents, output, imgType, codeVersion);
    }

    /**
     * 生成二维码图片 
     * @param contents 存储内容
     * @param imgPath 图片路径
     * @param imgType 图片类型
     * @param size 二维码尺寸
     * @throws IOException 
     */
    public void encodeQrcodeImage(String contents, String imgPath, String imgType, int size) throws IOException {
        BufferedImage buffImg = qRCodeCommon(contents, imgType, size);
        File imgFile = new File(imgPath);
        // 生成二维码图片
        ImageIO.write(buffImg, imgType, imgFile);
    }

    /**
     * 生成二维码图片
     * @param contents 存储内容
     * @param output 输出流
     * @param imgType 图片类型
     * @param size 二维码尺寸
     * @throws IOException 
     */
    public void encodeQrcodeImage(String contents, OutputStream output, String imgType, int size) throws IOException {
        BufferedImage buffImg = qRCodeCommon(contents, imgType, size);
        ImageIO.write(buffImg, imgType, output);
    }

    /**
     * 生成图片公用方法
     * @param contents 存储内容
     * @param imgType 图片类型
     * @param size 二维码尺寸
     * @return BufferedImage
     */
    private BufferedImage qRCodeCommon(String contents, String imgType, int size) {
        BufferedImage buffImg = null;
        int width = 140;
        int height = 140;
        int pixoff = 2; // 二维码点偏移量

        try {
            // 步骤1：设置BufferedImage
            buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
            // 步骤2：根据BufferedImage创建绘图Graphics2D
            Graphics2D gs = buffImg.createGraphics();
            gs.setBackground(Color.WHITE);
            gs.setColor(Color.BLACK);
            gs.clearRect(0, 0, width, height);// 创建矩形区域

            Qrcode qrcode = new Qrcode();
            // 设置二维码排错率 L(%7) M(%15) Q(%25) H(%30)
            qrcode.setQrcodeErrorCorrect('M');
            qrcode.setQrcodeEncodeMode('B');
            // 设置二维码尺寸，取值范围 [1-40]，值越大，可存储的信息越多
            qrcode.setQrcodeVersion(size);
            // 获得内容的字节数组，设置编码格式
            byte[] contentBytes = contents.getBytes();

            // 步骤3：输出内容>二维码
            if (contentBytes.length > 0 && contentBytes.length < 800) {
                boolean[][] codeOut = qrcode.calQrcode(contentBytes);
                for (int i = 0; i < codeOut.length; i++) {
                    for (int j = 0; j < codeOut.length; j++) {
                        if (codeOut[j][i]) {
                            gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
                        }
                    }
                }
            } else {
                throw new Exception("QRCode content bytes length out of bounds.");
            }
            gs.dispose();
            buffImg.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffImg;
    }

    public String decodeQrCodeImage(InputStream input) {
        BufferedImage buffImg = null;
        String content = null;
        try {
            buffImg = ImageIO.read(input);
            QRCodeDecoder decoder = new QRCodeDecoder();
            content = new String(decoder.decode(new TwoDimensionCodeImage(buffImg)), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DecodingFailedException dfe) {
            System.err.println("ERROR:" + dfe.getMessage());
        }
        return content;
    }

    public static void main(String[] args) {
        String imgPath = "D:/cjhs.png";
        String contents = "this is content";
        TwoDimensionCode code = new TwoDimensionCode();
        try {
            code.encodeQrcodeImage(contents, imgPath, "png", 7);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("DONE");
    }

}
