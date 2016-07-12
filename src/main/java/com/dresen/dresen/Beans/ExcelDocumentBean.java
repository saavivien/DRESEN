/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.Beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.util.HSSFColor;
//POI libraries to read Excel File
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author Vivien Saa
 */
@ManagedBean
public class ExcelDocumentBean implements Serializable {

    public void postProcessXLS(Object document) {
        HSSFWorkbook wb = (HSSFWorkbook) document;
        HSSFSheet sheet = wb.getSheetAt(0);
        //Aply style for all cells
        //Iterator rowIter = sheet.rowIterator();
        boolean first_row = true;
        for (Row row : sheet) {
            for (Cell cell : row) {
                HSSFCellStyle cell_style = wb.createCellStyle();
                if (first_row) { //Header cell
                    cell_style.setFillForegroundColor(HSSFColor.PALE_BLUE.index);
                    cell_style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
                }
                cell_style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                cell_style.setVerticalAlignment(HSSFCellStyle.ALIGN_CENTER);
                cell_style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
                cell_style.setBorderTop(HSSFCellStyle.BORDER_THIN);
                cell_style.setBorderRight(HSSFCellStyle.BORDER_THIN);
                cell_style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
                cell_style.setWrapText(true);
                cell.setCellStyle(cell_style);
            }
            first_row = false;
        }
        //Resize columns to fit data
        int noOfColumns = sheet.getRow(0).getLastCellNum();
        for (int i = 0; i < noOfColumns; i++) {
            sheet.autoSizeColumn(i);
        }
    }

}
