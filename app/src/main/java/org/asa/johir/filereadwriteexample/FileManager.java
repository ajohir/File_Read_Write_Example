package org.asa.johir.filereadwriteexample;

import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by Mobile App Develop on 8-3-16.
 */
public class FileManager {

    static final String FILE_NAME = "abcdefg.txt";
    Context context;

    FileManager(Context context)
    {
        this.context = context;
    }

    public void writeToFile(String data) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput(FILE_NAME,Context.MODE_APPEND));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        } catch (IOException e) {

            Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    protected String readFromFile() {

        String text = "";


        try {

            InputStream inputStream = context.openFileInput(FILE_NAME);

            if (inputStream != null) {

                InputStreamReader reader = new InputStreamReader(inputStream);

                BufferedReader bufferedReader = new BufferedReader(reader);

                String receivedString = "";

                StringBuilder builder = new StringBuilder();

                while ((receivedString = bufferedReader.readLine()) != null)
                {
                    builder.append(receivedString);
                }

                inputStream.close();
                text = builder.toString();
            }

        } catch (FileNotFoundException e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
            return  text;


        } catch (IOException e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
            return  text;

        }

        return text;
    }
}



