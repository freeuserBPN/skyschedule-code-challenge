package com.synerzip.dto;

import java.util.List;

public class FlightDto {

  private String type;
  private String dataSource;
  private List<FlightData> data = null;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getDataSource() {
    return dataSource;
  }

  public void setDataSource(String dataSource) {
    this.dataSource = dataSource;
  }

  public List<FlightData> getData() {
    return data;
  }

  public void setData(List<FlightData> data) {
    this.data = data;
  }
}
