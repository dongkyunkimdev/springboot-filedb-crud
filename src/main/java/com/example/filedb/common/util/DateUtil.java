package com.example.filedb.common.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;

@Component
public class DateUtil {
    public static LocalDate now() {
        return LocalDate.now(ZoneId.of("Asia/Seoul"));
    }
}
