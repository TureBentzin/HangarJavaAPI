/*
 * Hangar API
 * This page describes the format for the current Hangar REST API as well as general usage guidelines.<br> Note that all routes **not** listed here should be considered **internal**, and can change at a moment's notice. **Do not use them**.  ## Authentication and Authorization There are two ways to consume the API: Authenticated or anonymous.  ### Anonymous When using anonymous authentication, you only have access to public information, but you don't need to worry about creating and storing an API key or handing JWTs.  ### Authenticated If you need access to non-public content or actions, you need to create and use API keys. These can be created by going to the API keys page via the profile dropdown or by going to your user page and clicking on the key icon.  API keys allow you to impersonate yourself, so they should be handled like passwords. **Do not share them with anyone else!**  #### Getting and Using a JWT Once you have an API key, you need to authenticate yourself: Send a `POST` request with your API key identifier to `/api/v1/authenticate?apiKey=yourKey`. The response will contain your JWT as well as an expiration time. Put this JWT into the `Authorization` header of every request and make sure to request a new JWT after the expiration time has passed.  Please also set a meaningful `User-Agent` header. This allows us to better identify loads and needs for potentially new endpoints.  ## Misc ### Date Formats Standard ISO types. Where possible, we use the [OpenAPI format modifier](https://swagger.io/docs/specification/data-models/data-types/#format).  ### Rate Limits and Caching The default rate limit is set at 20 requests every 5 seconds with an initial overdraft for extra leniency. Individual endpoints, such as version creation, may have stricter rate limiting.  If applicable, always cache responses. The Hangar API itself is cached by CloudFlare and internally.
 *
 * The version of the OpenAPI document: 1.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package de.bentzin.hangar.api.client.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Gets or Sets Color
 */
@JsonAdapter(Color.Adapter.class)
public enum Color {
  
  _B400FF("#B400FF"),
  
  _C87DFF("#C87DFF"),
  
  _E100E1("#E100E1"),
  
  _0000FF("#0000FF"),
  
  _B9F2FF("#B9F2FF"),
  
  _E7FEFF("#E7FEFF"),
  
  _0096FF("#0096FF"),
  
  _00E1E1("#00E1E1"),
  
  _00DC00("#00DC00"),
  
  _009600("#009600"),
  
  _7FFF00("#7FFF00"),
  
  _FFC800("#FFC800"),
  
  _CFB53B("#CFB53B"),
  
  _FF8200("#FF8200"),
  
  _DC0000("#DC0000"),
  
  _C0C0C0("#C0C0C0"),
  
  _A9A9A9("#A9A9A9"),
  
  TRANSPARENT("transparent");

  private String value;

  Color(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static Color fromValue(String value) {
    for (Color b : Color.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<Color> {
    @Override
    public void write(final JsonWriter jsonWriter, final Color enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public Color read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return Color.fromValue(value);
    }
  }
}

