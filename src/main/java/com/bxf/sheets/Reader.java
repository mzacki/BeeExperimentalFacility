package com.bxf.sheets;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.BatchGetValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Matt on 05.06.2019 at 19:02.
 */

public class Reader {

    private static final Logger LOG = LoggerFactory.getLogger(Reader.class);
    private static final String SPREADSHEET_ID = "";

    public static void main(String[] args) throws IOException, GeneralSecurityException {
        Sheets sheetsService = SheetsServiceUtil.getSheetsService();
        List<String> ranges = Arrays.asList("E1","E4");
        BatchGetValuesResponse readResult = sheetsService.spreadsheets().values()
                .batchGet(SPREADSHEET_ID)
                .setRanges(ranges)
                .execute();

        ValueRange januaryTotal = readResult.getValueRanges().get(0);
        LOG.info("January total is: {}", januaryTotal);
    }

}
