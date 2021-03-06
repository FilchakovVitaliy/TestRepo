package utils;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class QRCodeDecoder {
    public static String decodeQRCode(File qrCodeimage) {
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(qrCodeimage);
            LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            Result result = new MultiFormatReader().decode(bitmap);
            return result.getText();
        } catch (NotFoundException | IOException e) {
            System.out.println("There is no QR code in the image");
            return null;
        }
    }
}
