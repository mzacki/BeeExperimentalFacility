package com.colony.sheets;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.BatchGetValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Matt on 05.06.2019 at 19:02.
 */
public class Reader {


    private static Sheets sheetsService;
    private static String SPREADSHEET_ID = "1s_lu1xjX701dRqeUKY327Tl6i1qM-kPWWgulx-ty6zc";


    public static void main(String[] args) throws IOException, GeneralSecurityException {
        sheetsService = SheetsServiceUtil.getSheetsService();
        List<String> ranges = Arrays.asList("E1","E4");
        BatchGetValuesResponse readResult = sheetsService.spreadsheets().values()
                .batchGet(SPREADSHEET_ID)
                .setRanges(ranges)
                .execute();

        ValueRange januaryTotal = readResult.getValueRanges().get(0);
        System.out.println("January total is: " + januaryTotal);


    }
}
