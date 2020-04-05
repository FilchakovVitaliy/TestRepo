import java.io.File;

import static utils.QRCodeDecoder.decodeQRCode;
import static utils.QRCodeGenerator.generateQRCodeImage;

public class Demo {
    public static void main(String[] args) {
        final String QR_CODE_IMAGE_PATH = "./MyQRCode.png";

        generateQRCodeImage("vitalik.filchakov@gmail.com", 350, 350, QR_CODE_IMAGE_PATH);
        File file = new File("MyQRCode.png");
        String decodedText = decodeQRCode(file);
        if (decodedText.isEmpty()) {
            System.out.println("No QR Code found in the image");
        } else {
            System.out.println("Decoded text = " + decodedText);
        }
    }
}


