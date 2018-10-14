package com.serifgungor.dosyayoneticisi.Helper;

import android.content.Context;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by Lab08-ogretmen on 11.04.2018.
 */

public class DosyaIslemleri {

    public String dosyaIcerigiOku(InputStream inputStream)
        throws IOException{
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[4096];
        int uzunluk = 0;
        while ((uzunluk = inputStream.read(bytes))>0){
            byteStream.write(bytes,0,uzunluk);
        }
        return new String(byteStream.toByteArray(),"UTF8");
    }

    public String dosyaIcerigiOku2(FileInputStream fileInputStream)
        throws IOException{
        BufferedReader fileInBuffer = new BufferedReader(
                new InputStreamReader(fileInputStream)
        );
        String text = "";
        String satir; //Verilerin geçici olarak yazıldığı satır
        while((satir = fileInBuffer.readLine()) != null){
            text += satir; //Geçici veriyi text değişkenine ilave et
        }
        fileInBuffer.close(); //Dosya içeriğini okuyan metodu kapat
        return text; //text değişkeninin son değerini dön
    }

    public boolean dosyaIcerigineKaydet(FileOutputStream fos, String str){
        OutputStreamWriter writer = new OutputStreamWriter(fos);
        //OutputStreamWriter dosya içerisine yazmak için kullanılır.
        boolean bool = true;

        try{
            writer.write(str); // Dosya içerisine yaz
            if(writer!=null){ // Nesne doluysa
                writer.close(); // Nesneyi tekrar kullanmamak üzere kapat
            }
        }catch (Exception e){
            bool = false;
        }

        return bool; //Dosyaya kaydettiyse true, kaydedemediyse false döner
    }


}
