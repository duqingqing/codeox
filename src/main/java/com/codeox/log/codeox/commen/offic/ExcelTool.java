package com.codeox.log.codeox.commen.offic;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @autor : duqingqing
 * @data : 2018/9/13 0013
 * @time: 17:33
 * @package: com.codeox.log.codeox.commen.offic
 * <p>
 * 07版本前
 * <p>
 * Excel 的工作簿对应POI的HSSFWorkbook对象；
 * Excel 的工作表对应POI的HSSFSheet对象；
 * Excel 的行对应POI的HSSFRow对象；
 * Excel 的单元格对应POI的HSSFCell对象。
 * 07版本及07以后版本
 * <p>
 * Excel 的工作簿对应POI的XSSFWorkbook对象；
 * Excel 的工作表对应POI的XSSFSheet对象；
 * Excel 的行对应POI的XSSFRow对象；
 * Excel 的单元格对应POI的XSSFCell对象。
 * <p>
 */
public class ExcelTool {

    public void outputExcelAfter2007(String fileName) throws IOException {
        // 1. 创建工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 2. 创建工作类
        XSSFSheet sheet = workbook.createSheet("hello world");
        // 3. 创建行 , 第三行 注意:从0开始
        XSSFRow row = sheet.createRow(0);
        // 4. 创建单元格, 第三行第三列 注意:从0开始
        for (int i = 0; i < 10; i++) {
            XSSFCell cell = row.createCell(i);
            cell.setCellValue("Hello World" + i);
        }
        FileOutputStream fileOutputSteam = new FileOutputStream(fileName);
        workbook.write(fileOutputSteam);
        workbook.close();
        fileOutputSteam.close();
    }

    public void outputExcelBefore2007(String fileName) throws IOException {
        // 1. 创建工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 2. 创建工作类
        HSSFSheet sheet = workbook.createSheet("hello world");
        // 3. 创建行 , 第三行 注意:从0开始
        HSSFRow row = sheet.createRow(0);
        // 4. 创建单元格, 第三行第三列 注意:从0开始
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("Hello World");
        FileOutputStream fileOutputSteam = new FileOutputStream(fileName);
        workbook.write(fileOutputSteam);
        workbook.close();
        fileOutputSteam.close();
    }

    /**
     * 读取excel
     */
    public static String readCellValue(Cell cell) {
        if (cell == null) {
            return "0.0";
        }
        CellType cellType = cell.getCellTypeEnum();
        switch (cellType) {
            case BLANK:
                return "";
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            default:
                return cell.getStringCellValue();
        }
    }

    public static List<List<String>> readExcel(String filePath, int sheetNo) {
        String fileType = filePath.substring(filePath.lastIndexOf(".") + 1);
        InputStream inputStream = null;
        Workbook wb = null;
        try {
            inputStream = new FileInputStream(filePath);
            if ("xls".equalsIgnoreCase(fileType)) {
                wb = new HSSFWorkbook(inputStream);
            } else {
                wb = new XSSFWorkbook(inputStream);
            }
            Sheet sheet = wb.getSheetAt(sheetNo);
            List<List<String>> result = new ArrayList<>();
            for (int i = 0; i <=sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) {
                    continue;
                }
                List<String> cellList = new ArrayList<>();
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    Cell cell = row.getCell(j);
                    cellList.add(readCellValue(cell));
                }
                result.add(cellList);
            }
            return result;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (wb != null) {
                try {
                    wb.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

    @Test
    public void testReadExcel() {
        int[] creditList = {3,3,3,4,3,4,2,1,2,2,3,4,3,3,3,3,3,2,1,1,3};
        List<List<String>> excelList = ExcelTool.readExcel("D:\\excelTest\\20162.xls", 0);
        for (List oneList : excelList) {
            int mark = 0;
            double sum = 0;
            double avg = 0;
            int creditSum = 0;
            for (Object oneCell : oneList) {
                if (mark == 0) {
                    System.out.print("[" + oneCell + "]");
                } else {
                    Double grade = 0.0;
                    if (!oneCell.equals("")) {
                        grade = Double.parseDouble((String) oneCell)*creditList[(mark-1)];
                        creditSum +=creditList[(mark-1)];
                        sum += grade;
                        System.out.print("[" + (String) oneCell + "]");
                    }else{
                        grade = 0.0;
                        sum += grade;
                        System.out.print("[" + grade + "]");
                    }
                }
                mark++;
            }
            System.out.println("总学分：["+creditSum+"]");
            System.out.println("sum : 【"+sum+"】");
            System.out.println("avg : 【"+sum/creditSum+"】");
            System.out.println("");
        }
    }
}
