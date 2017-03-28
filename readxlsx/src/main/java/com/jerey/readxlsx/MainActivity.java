package com.jerey.readxlsx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "xiamin";

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.tv);
        // readExcel();
        getXlsData("/storage/sdcard0/COMMAND.xls", 0);
    }

    public void readExcel() {
        try {
            InputStream inputStream = new FileInputStream("/storage/sdcard0/COMMAND.xlsx");
            Workbook workbook = Workbook.getWorkbook(inputStream);
        } catch (FileNotFoundException e) {
            Log.e(TAG, "读取文件失败");
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private ArrayList<String> getXlsData(String xlsName, int index) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        try {
            InputStream inputStream = new FileInputStream(xlsName);
            Workbook workbook = Workbook.getWorkbook(inputStream);
            Sheet sheet = workbook.getSheet(index);

            int sheetNum = workbook.getNumberOfSheets();
            int sheetRows = sheet.getRows();
            int sheetColumns = sheet.getColumns();

            Log.d(TAG, "the num of sheets is " + sheetNum);
            Log.d(TAG, "the name of sheet is  " + sheet.getName());
            Log.d(TAG, "total rows is 行=" + sheetRows);
            Log.d(TAG, "total cols is 列=" + sheetColumns);

            for(int i = 0; i < sheetRows; i++){
                stringArrayList.add(sheet.getCell(1,i).getContents() );
            }
            Log.d(TAG, stringArrayList.toString());

            workbook.close();

        } catch (FileNotFoundException e) {
            Log.e(TAG, "未找到xls文件");
            e.printStackTrace();
        } catch (Exception e) {
            Log.e(TAG, "read error=" + e, e);
        }

        return stringArrayList;
    }
}
