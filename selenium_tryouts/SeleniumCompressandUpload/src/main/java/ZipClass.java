import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipClass {

	public void  zipfiles (String srcFiles2, String fileOutPut) throws IOException
	{
	List<String> srcFiles = Arrays.asList(srcFiles2);
    FileOutputStream fos = new FileOutputStream(fileOutPut);
    ZipOutputStream zipOut = new ZipOutputStream(fos);
    for (String srcFile : srcFiles) {
        File fileToZip = new File(srcFile);
        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
        zipOut.putNextEntry(zipEntry);

        byte[] bytes = new byte[1024];
        int length;
        while((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }
        fis.close();
    }
    zipOut.close();
    fos.close();
}	
	
}
