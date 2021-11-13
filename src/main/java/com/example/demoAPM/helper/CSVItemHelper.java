package com.example.demoAPM.helper;

import com.example.demoAPM.model.Item;
import org.apache.commons.csv.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVItemHelper {
    public static String TYPE = "text/csv";


    public static boolean hasCSVFormat(MultipartFile file) {
        if (TYPE.equals(file.getContentType())
                || file.getContentType().equals("application/vnd.ms-excel")) {
            return true;
        }

        return false;
    }

    public static List<Item> csvToItem(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Item> itemArrayList = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {

                Item item = new Item(
                        Long.parseLong(csvRecord.get("Id")),
                        csvRecord.get("startAssembly"),
                        csvRecord.get("deadlineInstalled"),
                        csvRecord.get("location"),
                        csvRecord.get("numberFacility"),
                        csvRecord.get("zipCode"),
                        csvRecord.get("city"),
                        csvRecord.get("street"),
                        csvRecord.get("columnID"),
                        csvRecord.get("ipCCTV"),
                        csvRecord.get("cctv"),
                        csvRecord.get("cctvReady"),
                        csvRecord.get("contactPerson"),
                        csvRecord.get("phoneNumber"),
                        csvRecord.get("voivodeship"),
                        csvRecord.get("machineWidth"),
                        csvRecord.get("shape"),
                        csvRecord.get("typeModule"),
                        csvRecord.get("msisdn"),
                        csvRecord.get("instStatus"),
                        csvRecord.get("apmNumber"),
                        csvRecord.get("firstEntry"),
                        csvRecord.get("InstallDate"),
                        csvRecord.get("installTeam"),
                        csvRecord.get("installStatusWork"),
                        csvRecord.get("powerReady"),
                        csvRecord.get("workOrderDate")
                );

                itemArrayList.add(item);
            }

            return itemArrayList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static ByteArrayInputStream tutorialsToCSV(List<Item> itemList) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
            for (Item item : itemList) {
                List<String> data = Arrays.asList(
                        String.valueOf(item.getId()),
                        item.getLocation(),
                        item.getZipCode(),
                        item.getCity(),
                        item.getStreet(),
                        item.getApmNumber(),
                        item.getInstallStatusWork(),
                        item.getWorkOrderDate(),
                        item.getColumnID(),
                        item.getInstStatus()
                );

                csvPrinter.printRecord(data);
            }

            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
        }
    }

}
