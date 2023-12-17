package com.softserve.test;

import com.softserve.test.application.Handler;
import com.softserve.test.service.DuplicateRemoverUsingLambdas;
import com.softserve.test.infrastructure.GetDataFromConsole;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Main {

    public static void main(String[] args) {

        var removalService = new DuplicateRemoverUsingLambdas();
        var dataService = new GetDataFromConsole();

        var handler = new Handler(removalService, dataService);

        handler.handle();

    }

}