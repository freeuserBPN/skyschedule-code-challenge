package com.synerzip.manager;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.synerzip.dto.FlightDto;
import java.io.File;
import java.io.IOException;

public class JsonFileManager {

  private static final String OUTPUT_FILE_NAME = "FlightDetailsOutput.json";

  public static FlightDto readFromJson(File file, FlightDto flightDto) throws IOException {

    final ObjectMapper objectMapper =
        new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    final JsonNode jsonNode = objectMapper.readTree(file);

    if (!jsonNode.has("type")) {
      throw new RuntimeException("type is required!! Not a valid JSON");
    }

      return objectMapper.treeToValue(jsonNode, flightDto.getClass());

  }

  public static void writeToJson(FlightDto flightData) {

    final ObjectMapper mapper = new ObjectMapper();

    final File file = new File(OUTPUT_FILE_NAME);
    try {
      mapper.writeValue(file, flightData);

      System.out.println(
          "Successfully generated file outout in json format. Please check project root folder for file name = "
              + file.getAbsolutePath());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String getType(File file) {
    final ObjectMapper objectMapper =
        new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    JsonNode jsonNode = null;
    try {
      jsonNode = objectMapper.readTree(file);
    } catch (IOException e) {
      e.printStackTrace();
    }

    if (!jsonNode.has("type")) {
      throw new RuntimeException("type is required!! Not a valid JSON");
    }

    return jsonNode.get("type").asText();
  }
}
