/**
* ClassName : QRCodeGenerator.java
* Create on ：2016年6月21日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@163.com
*/
package com.spring.mvc.util.qrcode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

public class QRCodeGenerator {
    /**
     * 根据输入内容生成二维码图片并存储到指定路径下
     * @param contents 二维码内容
     * @param imgPath 图片存放路径
     * @throws IOException 
     */
    public static void generateQrCodeImgByContent(String contents, String imgPath) throws IOException {
        int width = 140;
        int height = 140;

        // 实例化二维码
        Qrcode qrcode = new Qrcode();
        // 设置二维码参数
        // 设置二维码排错率 可选项L(%7) M (%15) Q(%25) H(%30)
        qrcode.setQrcodeErrorCorrect('M');
        // 设置
        qrcode.setQrcodeEncodeMode('B');
        // 设置二维码的尺寸 取值范围[1-40]
        qrcode.setQrcodeVersion(7);

        // 步骤1：设置图片的尺寸等信息
        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);

        // 步骤2：绘制图片
        Graphics2D gs2D = buffImg.createGraphics();
        gs2D.setBackground(Color.WHITE); // 设置背景色
        gs2D.setColor(Color.BLACK); // 设置二维码颜色
        gs2D.clearRect(0, 0, width, height); // 创建矩形区域

        // 存储二维码的容器
        // 获取内容，通过一个数组的形式设置编码格式
        byte[] contentBytes = contents.getBytes("GBK");

        // 设置偏移量（如果不设置偏移量会导致解析错误）
        int pixoff = 2;

        // 输出二维码
        int length;
        if ((length = contentBytes.length) > 0 && length < 128) {
            boolean[][] codeOut = qrcode.calQrcode(contentBytes);
            for (int i = 0; i < codeOut.length; i++) {
                for (int j = 0; j < codeOut.length; j++) {
                    if (codeOut[j][i]) {
                        // 绘制二维码点
                        gs2D.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
                    }
                }
            }
        }else{
            System.out.println(" 内容超出最大限制");
        }
        gs2D.dispose();
        buffImg.flush();
        
        //步骤3：生成二维码图片
        File imgFile = new File(imgPath);
        ImageIO.write(buffImg, "png", imgFile);
        System.out.println("DONE!");
    }

    public static void main(String[] args) {
        String contents = "这是陈俊洪二维码";
        String imgPath = "D:\\cjh.png";
        try {
            QRCodeGenerator.generateQrCodeImgByContent(contents, imgPath);
        } catch (IOException e) {
            System.err.println("生成二维码出错");
        }
    }

}
