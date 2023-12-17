package com.softserve.test.infrastructure;

import com.softserve.test.domain.DataService;
import com.softserve.test.domain.DataTransfer;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class GetDataFromConsole implements DataService {

    @Override
    public DataTransfer getInputData() {
        var scanner = new Scanner(System.in);
        log.info("Please enter a character string: ");
        var input = scanner.nextLine();
        return DataTransfer.builder().inputData(input).build();
    }

}
