package pl.sturnusdev.fantasypremierleaguenews.storage;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public class MultipartFileUtil {

    public static MultipartFile convertByteArrayToMultipartFile(byte[] bytes, String originalFileName, String contentType) {
        try {
            return new MultipartFile() {
                @Override
                public String getName() {
                    return null;
                }

                @Override
                public String getOriginalFilename() {
                    return originalFileName;
                }

                @Override
                public String getContentType() {
                    return contentType;
                }

                @Override
                public boolean isEmpty() {
                    return bytes == null || bytes.length == 0;
                }

                @Override
                public long getSize() {
                    return bytes != null ? bytes.length : 0;
                }

                @Override
                public byte[] getBytes() throws IOException {
                    return bytes;
                }

                @Override
                public InputStream getInputStream() throws IOException {
                    return new ByteArrayInputStream(bytes);
                }

                @Override
                public void transferTo(File dest) throws IOException, IllegalStateException {
                    new FileOutputStream(dest).write(bytes);
                }
            };
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

