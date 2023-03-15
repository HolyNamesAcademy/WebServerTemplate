package service;

import java.io.*;
import java.util.Map;
import java.util.stream.Stream;
import com.azure.core.util.Configuration;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.blob.*;

import org.springframework.web.multipart.MultipartFile;

public class BlobServiceClient {
    public String BlobServiceClient (MultipartFile f) throws IOException{
        try {
            String constr = System.getenv("StorageExplorerConnectionString");
            CloudStorageAccount storageAccount = CloudStorageAccount.parse(constr);

            CloudBlobClient blobClient = storageAccount.createCloudBlobClient();

            CloudBlobContainer container = blobClient.getContainerReference("plantbook");

            CloudBlockBlob blob = container.getBlockBlobReference(f.getOriginalFilename());

            blob.upload(new BufferedInputStream(f.getInputStream()), f.getInputStream().available());
            System.out.println("ok");

            return blob.getUri().toString();
        }
        catch (Exception e){
            System.err.println("error");
            System.err.println(e.getMessage());
        }
        return "ok";
    }
}