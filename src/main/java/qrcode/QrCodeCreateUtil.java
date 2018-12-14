package qrcode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * 浜岀淮鐮佺敓鎴愬拰璇荤殑宸ュ叿绫�
 *
 */
public class QrCodeCreateUtil {
    
    /**
     * 鐢熸垚鍖呭惈瀛楃涓蹭俊鎭殑浜岀淮鐮佸浘鐗�
     * @param outputStream 鏂囦欢杈撳嚭娴佽矾寰�
     * @param content 浜岀淮鐮佹惡甯︿俊鎭�
     * @param qrCodeSize 浜岀淮鐮佸浘鐗囧ぇ灏�
     * @param imageFormat 浜岀淮鐮佺殑鏍煎紡
     * @throws WriterException 
     * @throws IOException 
     */
    public static boolean createQrCode(OutputStream outputStream, String content, int qrCodeSize, String imageFormat) throws WriterException, IOException{  
            //璁剧疆浜岀淮鐮佺籂閿欑骇鍒辑锛★及
            Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<EncodeHintType, ErrorCorrectionLevel>();  
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);  // 鐭敊绾у埆  
            QRCodeWriter qrCodeWriter = new QRCodeWriter();  
            //鍒涘缓姣旂壒鐭╅樀(浣嶇煩闃�)鐨凲R鐮佺紪鐮佺殑瀛楃涓�  
            BitMatrix byteMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, qrCodeSize, qrCodeSize, hintMap);  
            // 浣緽ufferedImage鍕剧敾QRCode  (matrixWidth 鏄浜岀淮鐮佸儚绱犵偣)
            int matrixWidth = byteMatrix.getWidth();  
            BufferedImage image = new BufferedImage(matrixWidth-200, matrixWidth-200, BufferedImage.TYPE_INT_RGB);  
            image.createGraphics();  
            Graphics2D graphics = (Graphics2D) image.getGraphics();  
            graphics.setColor(Color.WHITE);  
            graphics.fillRect(0, 0, matrixWidth, matrixWidth);  
            // 浣跨敤姣旂壒鐭╅樀鐢诲苟淇濆瓨鍥惧儚
            graphics.setColor(Color.BLACK);  
            for (int i = 0; i < matrixWidth; i++){
                for (int j = 0; j < matrixWidth; j++){
                    if (byteMatrix.get(i, j)){
                        graphics.fillRect(i-100, j-100, 1, 1);  
                    }
                }
            }
            return ImageIO.write(image, imageFormat, outputStream);  
    }  
      
    /**
     * 璇讳簩缁寸爜骞惰緭鍑烘惡甯︾殑淇℃伅
     */
    public static void readQrCode(InputStream inputStream) throws IOException{  
        //浠庤緭鍏ユ祦涓幏鍙栧瓧绗︿覆淇℃伅
        BufferedImage image = ImageIO.read(inputStream);  
        //灏嗗浘鍍忚浆鎹负浜岃繘鍒朵綅鍥炬簮
        LuminanceSource source = new BufferedImageLuminanceSource(image);  
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));  
        QRCodeReader reader = new QRCodeReader();  
        Result result = null ;  
        try {
         result = reader.decode(bitmap);  
        } catch (ReaderException e) {
            e.printStackTrace();  
        }
        System.out.println(result.getText());  
    }
    /**
     * 娴嬭瘯浠ｇ爜
     * @throws WriterException 
     */
    public static void main(String[] args) throws IOException, WriterException {  
        
        createQrCode(new FileOutputStream(new File("D:\\qrcode.jpg")),"woshixiaoyu",900,"JPEG");
        readQrCode(new FileInputStream(new File("D:\\qrcode.jpg")));  
    }  
  
}