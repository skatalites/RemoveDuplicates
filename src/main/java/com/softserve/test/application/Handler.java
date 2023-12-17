package com.softserve.test.application;

import com.softserve.test.domain.DataService;
import com.softserve.test.domain.DuplicateRemovalService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
@AllArgsConstructor
public class Handler {

    private DuplicateRemovalService removalService;
    private DataService dataService;

    public void handle() {

        try {

            var inputDataFromConsole = dataService.getInputData();

            if (Objects.isNull(inputDataFromConsole.inputData) || inputDataFromConsole.inputData.isEmpty()) {
                log.warn("Ignoring this request, input data is null or empty.");
                return;
            }

            //log.info("Input data: {}", inputDataFromConsole.inputData);

            var result = removalService.removeDuplicateValues(inputDataFromConsole);
            log.info("Final result: {}", result.outputData);

        } catch (Exception exception) {
            log.error("Exception removing duplicates {}", exception.getMessage());
        }
    }

}
