package com.example.mycody.data;

import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;

import java.io.File;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class DownloadImage extends AppCompatActivity {
    FirebaseStorage firebaseStorage = FirebaseStorage.getInstance("gs://mycodyfb.appspot.com");
    StorageReference storageReference = firebaseStorage.getReference();
    StorageReference pathReference = storageReference.child("images/top.jpg");

    protected void setPathReference(String path){
        pathReference = storageReference.child(path);
    }

    public void downloadImageOnStorage(){
        //setPathReference(path);
        try {
            File dir = new File(Environment.getExternalStorageDirectory() + "/photos");
            final File file = new File(dir, "downloadedImage.jpg");
            if(!dir.exists()){
                dir.mkdir();
            }
            final FileDownloadTask fileDownloadTask = pathReference.getFile(file);
            fileDownloadTask.addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    Log.e("failTag","fail");
                }
            }).addOnProgressListener(new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onProgress(FileDownloadTask.TaskSnapshot taskSnapshot) {
                }
            });
        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
