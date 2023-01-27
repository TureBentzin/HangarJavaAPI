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

import com.google.gson.*;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModelProperty;
import de.bentzin.hangar.api.client.JSON;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

/**
 * PlatformVersionDownload
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-01-27T18:55:17.902236655+01:00[Europe/Berlin]")
public class PlatformVersionDownload {
  public static final String SERIALIZED_NAME_FILE_INFO = "fileInfo";
  @SerializedName(SERIALIZED_NAME_FILE_INFO)
  private FileInfo fileInfo;

  public static final String SERIALIZED_NAME_EXTERNAL_URL = "externalUrl";
  @SerializedName(SERIALIZED_NAME_EXTERNAL_URL)
  private String externalUrl;

  public static final String SERIALIZED_NAME_DOWNLOAD_URL = "downloadUrl";
  @SerializedName(SERIALIZED_NAME_DOWNLOAD_URL)
  private String downloadUrl;

  public PlatformVersionDownload() {
  }

  public PlatformVersionDownload fileInfo(FileInfo fileInfo) {
    
    this.fileInfo = fileInfo;
    return this;
  }

   /**
   * Get fileInfo
   * @return fileInfo
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public FileInfo getFileInfo() {
    return fileInfo;
  }


  public void setFileInfo(FileInfo fileInfo) {
    this.fileInfo = fileInfo;
  }


  public PlatformVersionDownload externalUrl(String externalUrl) {
    
    this.externalUrl = externalUrl;
    return this;
  }

   /**
   * Get externalUrl
   * @return externalUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getExternalUrl() {
    return externalUrl;
  }


  public void setExternalUrl(String externalUrl) {
    this.externalUrl = externalUrl;
  }


  public PlatformVersionDownload downloadUrl(String downloadUrl) {
    
    this.downloadUrl = downloadUrl;
    return this;
  }

   /**
   * Get downloadUrl
   * @return downloadUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getDownloadUrl() {
    return downloadUrl;
  }


  public void setDownloadUrl(String downloadUrl) {
    this.downloadUrl = downloadUrl;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlatformVersionDownload platformVersionDownload = (PlatformVersionDownload) o;
    return Objects.equals(this.fileInfo, platformVersionDownload.fileInfo) &&
        Objects.equals(this.externalUrl, platformVersionDownload.externalUrl) &&
        Objects.equals(this.downloadUrl, platformVersionDownload.downloadUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fileInfo, externalUrl, downloadUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlatformVersionDownload {\n");
    sb.append("    fileInfo: ").append(toIndentedString(fileInfo)).append("\n");
    sb.append("    externalUrl: ").append(toIndentedString(externalUrl)).append("\n");
    sb.append("    downloadUrl: ").append(toIndentedString(downloadUrl)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("fileInfo");
    openapiFields.add("externalUrl");
    openapiFields.add("downloadUrl");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to PlatformVersionDownload
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!PlatformVersionDownload.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in PlatformVersionDownload is not found in the empty JSON string", PlatformVersionDownload.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!PlatformVersionDownload.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `PlatformVersionDownload` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      // validate the optional field `fileInfo`
      if (jsonObj.get("fileInfo") != null && !jsonObj.get("fileInfo").isJsonNull()) {
        FileInfo.validateJsonObject(jsonObj.getAsJsonObject("fileInfo"));
      }
      if ((jsonObj.get("externalUrl") != null && !jsonObj.get("externalUrl").isJsonNull()) && !jsonObj.get("externalUrl").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `externalUrl` to be a primitive type in the JSON string but got `%s`", jsonObj.get("externalUrl").toString()));
      }
      if ((jsonObj.get("downloadUrl") != null && !jsonObj.get("downloadUrl").isJsonNull()) && !jsonObj.get("downloadUrl").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `downloadUrl` to be a primitive type in the JSON string but got `%s`", jsonObj.get("downloadUrl").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!PlatformVersionDownload.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'PlatformVersionDownload' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<PlatformVersionDownload> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(PlatformVersionDownload.class));

       return (TypeAdapter<T>) new TypeAdapter<PlatformVersionDownload>() {
           @Override
           public void write(JsonWriter out, PlatformVersionDownload value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public PlatformVersionDownload read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of PlatformVersionDownload given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of PlatformVersionDownload
  * @throws IOException if the JSON string is invalid with respect to PlatformVersionDownload
  */
  public static PlatformVersionDownload fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PlatformVersionDownload.class);
  }

 /**
  * Convert an instance of PlatformVersionDownload to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

