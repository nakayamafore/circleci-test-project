package com.example.demo.config;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import javax.persistence.AttributeConverter;

// @Converter(autoApply = true)
public class ZonedDateTimeConverter implements AttributeConverter<ZonedDateTime, Date> {

  @Override
  public Date convertToDatabaseColumn(ZonedDateTime zonedDateTime) {
    return zonedDateTime == null ? null
        : Date.from(zonedDateTime.toInstant());
  }

  @Override
  public ZonedDateTime convertToEntityAttribute(Date dbData) {
    return dbData == null ? null
        : ZonedDateTime.ofInstant(dbData.toInstant(), ZoneId.systemDefault());
  }
}
