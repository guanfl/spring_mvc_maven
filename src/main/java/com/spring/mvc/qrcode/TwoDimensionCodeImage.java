/**
* ClassName : TwoDimensionCodeImage.java
* Create on ：2016年6月21日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@163.com
*/
package com.spring.mvc.qrcode;

import java.awt.image.BufferedImage;

import jp.sourceforge.qrcode.data.QRCodeImage;

/**
 * 二维码图片实现类 
 */
public class TwoDimensionCodeImage implements QRCodeImage {
    private BufferedImage buffImg;

    public TwoDimensionCodeImage(BufferedImage image) {
        this.buffImg = image;
    }
    
    @Override
    public int getHeight() {
        return buffImg.getHeight();
    }

    @Override
    public int getPixel(int x, int y) {
        return buffImg.getRGB(x, y);
    }

    @Override
    public int getWidth() {
        return buffImg.getWidth();
    }
}
