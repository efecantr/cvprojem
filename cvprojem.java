package org.example;

// GEREKLİ iText import'LArı
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Chunk;
import java.io.FileOutputStream;

public class Main {

    public static void main(String[] args) {

        //  Belge  nesneleri
        Document document = new Document();

        try {
            // PDF dosyasının kaydedileceği yer ve adı
            PdfWriter.getInstance(document, new FileOutputStream("HayaliOzgecmis.pdf"));

            // Belgeyi aç
            document.open();

            // Font Ayarları
            Font baslikFont = FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLD);
            Font altBaslikFont = FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD);
            Font normalFont = FontFactory.getFont(FontFactory.HELVETICA, 11);


            //  Kişisel bilgiler
            document.add(new Paragraph("Yusuf KEMAL (Hayali Kişi)", baslikFont));
            document.add(new Paragraph("Hayali Yazılım Mühendisi", altBaslikFont));
            document.add(new Paragraph("E-posta: hayali@eposta.com | Telefon: +90 555 123 45 67", normalFont));
            document.add(new Paragraph("--------------------------------------------------\n\n")); // Ayırıcı çizgi



            try {

                Image foto = Image.getInstance("img/ppiçin.png");
                foto.scaleAbsolute(80f, 100f); // Fotoğraf boyutunu ayarla
                foto.setAbsolutePosition(450f, 750f); // PDF üzerinde pozisyonunu ayarla (Sağ üste yakın)
                document.add(foto);
            } catch (Exception e) {
                // Eğer resim yanlışsa veya resim yoksa bu mesajı ekleyecek
                document.add(new Paragraph(">>> Fotoğraf yüklenemedi. Dosya yolunu kontrol edin. <<<"));
            }


            // İş deneyimleri
            document.add(new Paragraph(Chunk.NEWLINE));
            document.add(new Paragraph("İŞ DENEYİMİ", altBaslikFont));
            document.add(new Paragraph("--------------------------------------------------"));

            // deneyim 1
            document.add(new Paragraph("Kıdemli Java Geliştirici - BEN10 A.S.", altBaslikFont));
            document.add(new Paragraph("Ocak 2022 - Devam Ediyor", normalFont));
            document.add(new Paragraph("- Büyük ölçekli kurumsal Java projelerinde görev alma.", normalFont));
            document.add(new Paragraph("- Yeni özelliklerin mimari tasarımına ve kod incelemesine katılma.", normalFont));
            document.add(new Paragraph(Chunk.NEWLINE));

            // deneyim2
            document.add(new Paragraph("Yazılım Stajyeri - Genç Kod A.Ş.", altBaslikFont));
            document.add(new Paragraph("Haziran 2021 - Eylül 2021", normalFont));
            document.add(new Paragraph("- Temel Spring Boot modüllerinin geliştirilmesine destek verme.", normalFont));
            document.add(new Paragraph("- Otomasyon testleri yazma ve hata ayıklama süreçlerine katılma.", normalFont));
            document.add(new Paragraph(Chunk.NEWLINE));

            // deneyim3
            document.add(new Paragraph("Junior Gelistirici - Cozumm Ajans", altBaslikFont));
            document.add(new Paragraph("Ocak 2020 - Aralık 2020", normalFont));
            document.add(new Paragraph("- Basit veritabanı CRUD operasyonları için Java uygulamaları geliştirme.", normalFont));
            document.add(new Paragraph("- Proje dokümantasyonu hazırlama ve sürdürme.", normalFont));
            document.add(new Paragraph(Chunk.NEWLINE));


            // Belgeyi Kapa
            document.close();
            System.out.println("PDF başarıyla oluşturuldu: HayaliOzgecmis.pdf");

        } catch (Exception e) {
            System.err.println("PDF oluşturulurken bir hata oluştu: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
