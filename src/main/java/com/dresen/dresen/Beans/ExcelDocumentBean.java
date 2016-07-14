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
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author Vivien Saa
 */
@ManagedBean
public class ExcelDocumentBean implements Serializable {

    public void postProcessXLS(Object document) {
        HSSFWorkbook wb = (HSSFWorkbook) document;

        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow header = sheet.getRow(0);
        int nbCol = header.getPhysicalNumberOfCells();
        int nbRow = sheet.getPhysicalNumberOfRows();
        //HSSFRow row1 = sheet.createRow(0);
        //Aply style for all cells
        //Iterator rowIter = sheet.rowIterator();
//        boolean first_row = true;
        HSSFCellStyle cell_style = wb.createCellStyle();
        cell_style.setVerticalAlignment(HSSFCellStyle.ALIGN_CENTER);
        cell_style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cell_style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        cell_style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cell_style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cell_style.setWrapText(true);

        HSSFCellStyle cell_styleForHeader = wb.createCellStyle();
        cell_styleForHeader.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cell_styleForHeader.setVerticalAlignment(HSSFCellStyle.ALIGN_CENTER);
        cell_styleForHeader.setWrapText(true);
        cell_styleForHeader.setFillForegroundColor(HSSFColor.PALE_BLUE.index);
        cell_styleForHeader.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

        for (int i = 0; i < nbRow; i++) {
            HSSFRow row = sheet.getRow(i);
            for (int j = 0; j < nbCol; j++) {
                HSSFCell cell = row.getCell(j);
                if (i == 0) { //Header cell
                   // cell.;
                    cell.setCellStyle(cell_styleForHeader);
                } else {
                    cell.setCellStyle(cell_style);
                }
            }
//            first_row = false;
        }
        //Resize columns to fit data
//        int noOfColumns = sheet.getRow(0).getLastCellNum();
        for (int i = 0; i < nbCol; i++) {
            sheet.autoSizeColumn(i);
        }
    }

}
