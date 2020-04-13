package com.rh.ui.constant;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;

/**
 * 图片资源引用
 */
public class ImageResources {

    public static final String RESOURCE_PATH = "../../../../";

    public static final URL headURL = ImageResources.class.getResource(RESOURCE_PATH + "dota.png");
    public static final ImageIcon headIcon = new ImageIcon(headURL);

    public static final URL bodyURL = ImageResources.class.getResource(RESOURCE_PATH + "duoduo1.png");
    public static final ImageIcon bodyIcon = new ImageIcon(bodyURL);

    /**
     * 修改图片大小
     */
    public static void main(String[] args) throws Exception {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("/home/hang/myprogram/my_program/src/main/resources/dota5.png"));

        //字节流转图片对象
        Image bi = ImageIO.read(in);
        //构建图片流
        BufferedImage tag = new BufferedImage(30, 30, BufferedImage.TYPE_INT_RGB);
        //绘制改变尺寸后的图
        tag.getGraphics().drawImage(bi, 0, 0, 30, 30, null);
        //输出流
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("/home/hang/myprogram/my_program/src/main/resources/dota.png"));
        //JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        //encoder.encode(tag);
        ImageIO.write(tag, "PNG", out);
        in.close();
        out.close();
    }

}
