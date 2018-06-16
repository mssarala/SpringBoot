package com.sarala.explore.utils;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.*;

import java.util.List;

public class ReportUtils {

    public static CellStyle getLogoHeader(XSSFWorkbook my_workbook) {
        CellStyle logoHeader = my_workbook.createCellStyle();
        logoHeader.setBorderBottom(CellStyle.BORDER_THIN);
        logoHeader.setBorderLeft(CellStyle.BORDER_THIN);
        logoHeader.setBorderRight(CellStyle.BORDER_THIN);
        logoHeader.setBorderTop(CellStyle.BORDER_THIN);

        return  logoHeader;
    }
    public static  CellStyle getHeader(XSSFWorkbook my_workbook) {
        CellStyle header = my_workbook.createCellStyle();
        header.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        header.setFillPattern(CellStyle.SOLID_FOREGROUND);
        header.setBorderBottom(CellStyle.BORDER_THIN);
        header.setBorderLeft(CellStyle.BORDER_THIN);
        header.setBorderRight(CellStyle.BORDER_THIN);
        header.setBorderTop(CellStyle.BORDER_THIN);
        header.setAlignment(CellStyle.ALIGN_CENTER);
        header.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

        Font headerFont = my_workbook.createFont();
        headerFont.setColor(IndexedColors.WHITE.getIndex());
        header.setFont(headerFont);

        return  header;
    }
    public static void createColumnHeaders(XSSFSheet my_sheet, int row, int col, CellStyle header, String cellValue)
    {
        XSSFRow existingRow = my_sheet.getRow(row);
        XSSFRow newRow;
        if (existingRow == null) {
            newRow = my_sheet.createRow(row);
        } else {
            newRow = existingRow;
        }
        XSSFCell cell2 = newRow.createCell(col);
        cell2.setCellStyle(header);
        cell2.setCellValue(cellValue);
    }



    public static  void mergeCell (XSSFWorkbook my_workbook, XSSFSheet my_sheet, int firstRow, int lastRow, int firstCol, int lastCol)
    {
        CellRangeAddress mergedCell = new CellRangeAddress(firstRow, lastRow, firstCol, lastCol);

        RegionUtil.setBorderBottom(CellStyle.BORDER_THIN, mergedCell, my_sheet, my_workbook);
        RegionUtil.setBorderBottom(CellStyle.BORDER_THIN, mergedCell, my_sheet, my_workbook);
        RegionUtil.setBorderLeft(CellStyle.BORDER_THIN, mergedCell, my_sheet, my_workbook);
        RegionUtil.setBorderRight(CellStyle.BORDER_THIN, mergedCell, my_sheet, my_workbook);

        my_sheet.addMergedRegion(mergedCell);
    }

    public static  void createCellData(XSSFWorkbook my_workbook, XSSFSheet my_sheet, List<String> headers, int rowNumber, int colNumber)
    {
        CellStyle secColFirst = my_workbook.createCellStyle();
        secColFirst.setBorderRight(CellStyle.BORDER_THIN);
        secColFirst.setBorderTop(CellStyle.BORDER_THIN);
        secColFirst.setAlignment(CellStyle.ALIGN_LEFT);
        secColFirst.setFillPattern(HSSFCellStyle.NO_FILL);
        secColFirst.setVerticalAlignment(CellStyle.VERTICAL_TOP);
        secColFirst.setFillPattern( XSSFCellStyle.SOLID_FOREGROUND);
        secColFirst.setFillForegroundColor(IndexedColors.WHITE.getIndex());

        CellStyle secColLast = my_workbook.createCellStyle();
        secColLast.setBorderRight(CellStyle.BORDER_THIN);
        secColLast.setBorderBottom(CellStyle.BORDER_THIN);
        secColLast.setFillPattern(HSSFCellStyle.NO_FILL);
        secColLast.setAlignment(CellStyle.ALIGN_LEFT);
        secColLast.setVerticalAlignment(CellStyle.VERTICAL_TOP);
        secColLast.setFillPattern( XSSFCellStyle.SOLID_FOREGROUND);
        secColLast.setFillForegroundColor(IndexedColors.WHITE.getIndex());

        CellStyle secColHeader = my_workbook.createCellStyle();
        secColHeader.setBorderRight(CellStyle.BORDER_THIN);
        secColHeader.setAlignment(CellStyle.ALIGN_LEFT);
        secColHeader.setVerticalAlignment(CellStyle.VERTICAL_TOP);
        secColHeader.setFillPattern( XSSFCellStyle.SOLID_FOREGROUND);
        secColHeader.setFillForegroundColor(IndexedColors.WHITE.getIndex());


        int length = headers.size() - 1;
        createColumnHeaders(my_sheet, rowNumber++, colNumber, secColFirst, headers.get(0));
        for(int i=1 ; i <= length; i++) {
            createColumnHeaders(my_sheet, rowNumber++, colNumber, secColHeader, headers.get(i));
        }
        createColumnHeaders(my_sheet, rowNumber++, colNumber, secColLast, headers.get(length));
    }
}
