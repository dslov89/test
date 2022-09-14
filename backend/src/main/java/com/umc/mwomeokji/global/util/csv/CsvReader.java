package com.umc.mwomeokji.global.util.csv;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import com.umc.mwomeokji.global.error.exception.BusinessException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static com.umc.mwomeokji.global.error.exception.ExceptionCodeAndDetails.FILE_IO_EXCEPTION;

public class CsvReader {

    private final CSVReader csvReader;

    public CsvReader(MultipartFile file) {
        this.csvReader = createCSVReader(file);
    }

    public List<String[]> readAll() {
        try {
            return csvReader.readAll();
        } catch (IOException | CsvException e) {
            throw new BusinessException(FILE_IO_EXCEPTION);
        }
    }

    private CSVReader createCSVReader(MultipartFile file) {
        return new CSVReaderBuilder(toInputStreamReader(file))
                .withSkipLines(1)
                .build();
    }

    private InputStreamReader toInputStreamReader(MultipartFile file) {
        try {
            return new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new BusinessException(FILE_IO_EXCEPTION);
        }
    }
}
