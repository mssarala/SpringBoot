package com.sarala.explore.service;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Units;
import org.apache.poi.xssf.usermodel.*;

import com.sarala.explore.utils.ReportUtils;
import com.sarala.explore.utils.data.ReportDataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;


public class CreateReport {

    public  static void createExcel() {
        FileOutputStream out = null;
        try {
            XSSFWorkbook my_workbook = new XSSFWorkbook();
            XSSFSheet my_sheet = my_workbook.createSheet("MyReport");

            CellStyle logoHeader = ReportUtils.getLogoHeader(my_workbook);
            CellStyle header = ReportUtils.getHeader(my_workbook);

            Row row = my_sheet.createRow(0); // Create a cell and put a value in it.
            row.createCell(0).setCellStyle(logoHeader);
            CellRangeAddress mergedCell = new CellRangeAddress(0, 0, 0, 1);
            RegionUtil.setBorderRight(CellStyle.BORDER_THIN, mergedCell, my_sheet, my_workbook);
            my_sheet.addMergedRegion(mergedCell);
            row.setHeight((short) 750);
            my_sheet.setColumnWidth(0, 8000); // Table //

            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            File file = new File(classLoader.getResource("static/images/logo-default.png").getFile()); /* Read input PNG / JPG Image into FileInputStream Object*/

            InputStream my_banner_image = new FileInputStream(file);
            byte[] bytes = IOUtils.toByteArray(my_banner_image); /* Convert picture to be added into a byte array */
            int my_picture_id = my_workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);  /* Add Picture to Workbook, Specify picture type as PNG and Get an Index */
            my_banner_image.close(); /* Close the InputStream. We are ready to attach the image to workbook now */

            XSSFDrawing drawing = my_sheet.createDrawingPatriarch(); /* Create the drawing container */

            XSSFClientAnchor my_anchor = new XSSFClientAnchor(); /* Create an anchor point */
            my_anchor.setCol1(0); /* Define top left corner, and we can resize picture suitable from there */
            my_anchor.setRow1(0);

            XSSFPicture my_picture = drawing.createPicture(my_anchor, my_picture_id); /* Invoke createPicture and pass the anchor point and ID */
            my_picture.resize(); /* Call resize method, which resizes the image */

            int pictWidthPx = my_picture.getImageDimension().width; //get the picture width

            //get the cell width A1:B1
            float cellWidthPx = 0f;
            for (int col = 0; col < 2; col++) {
                cellWidthPx += my_sheet.getColumnWidthInPixels(col);
            }

            int centerPosPx = Math.round(cellWidthPx / 2f - (float) pictWidthPx / 2f); //calculate the center position
            //determine the new first anchor column dependent of the center position and the remaining pixels as Dx
            for (int col = 0; col < 2; col++) {
                if (Math.round(my_sheet.getColumnWidthInPixels(col)) < centerPosPx) {
                    centerPosPx -= Math.round(my_sheet.getColumnWidthInPixels(col));
                } else {
                    break;
                }
            }
            my_anchor.setDx1(centerPosPx * Units.EMU_PER_PIXEL); //set the remaining pixels up to the center position as Dx in unit EMU
            my_picture.resize(); //resize the pictutre to original size again - this will determine the new bottom rigth anchor position


            XSSFRow row2 = my_sheet.createRow(1);
            XSSFCell cell0 = row2.createCell(0);
            cell0.setCellStyle(header);

            ReportUtils.mergeCell(my_workbook, my_sheet, 2, 18, 0, 0);
            ReportUtils.createColumnHeaders(my_sheet, 2, 0, header, "Overview");

            ReportUtils.mergeCell(my_workbook, my_sheet, 19, 21, 0, 0);
            ReportUtils.createColumnHeaders(my_sheet, 19, 0, header, "Management");

            ReportUtils.mergeCell(my_workbook, my_sheet, 22, 28, 0, 0);
            ReportUtils.createColumnHeaders(my_sheet, 22, 0, header, "Fees & Expenses");


            Cell cell1 = row2.createCell(1);
            cell1.setCellStyle(header);
            cell1.setCellValue("SHARE CLASS NAME");
            my_sheet.setColumnWidth(1, 8000); // Table //


            ReportUtils.createCellData(my_workbook, my_sheet, ReportDataProvider.getOverviewHeaders1(), 2, 1);
            ReportUtils.createCellData(my_workbook, my_sheet, ReportDataProvider.getOverviewHeaders2(), 17, 1);
            ReportUtils.createCellData(my_workbook, my_sheet, ReportDataProvider.getManagementHeaders(), 19, 1);
            ReportUtils.createCellData(my_workbook, my_sheet, ReportDataProvider.getFeeHeaders(), 22, 1);


            int fundCounter = 1;

            fundCounter++;
            Cell cell2 = row2.createCell(2);
            cell2.setCellStyle(header);
            cell2.setCellValue("Fund 1");
            my_sheet.setColumnWidth(2, 8000); // Table //

            ReportUtils.createCellData(my_workbook, my_sheet, ReportDataProvider.getOverviewHeaders1(), 2, 2);
            ReportUtils.createCellData(my_workbook, my_sheet, ReportDataProvider.getOverviewHeaders2(), 17, 2);
            ReportUtils.createCellData(my_workbook, my_sheet, ReportDataProvider.getManagementHeaders(), 19, 2);
            ReportUtils.createCellData(my_workbook, my_sheet, ReportDataProvider.getFeeHeaders(), 22, 2);

            fundCounter++;
            Cell cell3 = row2.createCell(3);
            cell3.setCellStyle(header);
            cell3.setCellValue("Fund 2");
            my_sheet.setColumnWidth(3, 8000); // Table //

            ReportUtils.createCellData(my_workbook, my_sheet, ReportDataProvider.getOverviewHeaders1(), 2, 3);
            ReportUtils.createCellData(my_workbook, my_sheet, ReportDataProvider.getOverviewHeaders2(), 17, 3);
            ReportUtils.createCellData(my_workbook, my_sheet, ReportDataProvider.getManagementHeaders(), 19, 3);
            ReportUtils.createCellData(my_workbook, my_sheet, ReportDataProvider.getFeeHeaders(), 22, 3);


            row.createCell(2).setCellStyle(header);
            CellRangeAddress mergedFundCell = new CellRangeAddress(0, 0, 2, fundCounter);
            RegionUtil.setBorderRight(CellStyle.BORDER_THIN, mergedFundCell, my_sheet, my_workbook);
            my_sheet.addMergedRegion(mergedFundCell);

            out = new FileOutputStream(new File("D:\\Temp\\delete\\sarala.xlsx"));/* Write changes to the workbook */
            my_workbook.write(out);
            out.close();
        } catch (Exception e) {
            System.out.println(e.toString());
            try {
                out.close();
            } catch (Exception ex) {
            }
        }
    }



}
