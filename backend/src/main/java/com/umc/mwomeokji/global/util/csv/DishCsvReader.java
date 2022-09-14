package com.umc.mwomeokji.global.util.csv;

import com.umc.mwomeokji.domain.dish.dish.dto.DishDto.DishPostRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

public class DishCsvReader extends CsvReader{

    public DishCsvReader(MultipartFile file) {
        super(file);
    }

    public List<DishPostRequest> getDishPostRequests(List<String[]> dishes) {
        return dishes.stream()
                .map(line -> new DishPostRequest(line[0].trim(), line[1].trim(), line[3].trim(), line[4].trim(), line[5].trim()))
                .collect(Collectors.toList());
    }
}
