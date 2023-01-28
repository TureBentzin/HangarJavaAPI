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


package de.bentzin.hangar.api.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.*;

/**
 * Version data
 */
@ApiModel(description = "Version data")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-01-28T17:51:10.536335800+01:00[Europe/Berlin]")
public class VersionUpload {
  public static final String SERIALIZED_NAME_VERSION = "version";
  @SerializedName(SERIALIZED_NAME_VERSION)
  private String version;

  public static final String SERIALIZED_NAME_PLUGIN_DEPENDENCIES = "pluginDependencies";
  @SerializedName(SERIALIZED_NAME_PLUGIN_DEPENDENCIES)
  private Map<String, Set<PluginDependency>> pluginDependencies = null;

  public static final String SERIALIZED_NAME_PLATFORM_DEPENDENCIES = "platformDependencies";
  @SerializedName(SERIALIZED_NAME_PLATFORM_DEPENDENCIES)
  private Map<String, Set<String>> platformDependencies = null;

  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_FILES = "files";
  @SerializedName(SERIALIZED_NAME_FILES)
  private List<MultipartFileOrUrl> files = null;

  public static final String SERIALIZED_NAME_CHANNEL = "channel";
  @SerializedName(SERIALIZED_NAME_CHANNEL)
  private String channel;


  public VersionUpload version(String version) {
    
    this.version = version;
    return this;
  }

   /**
   * Get version
   * @return version
  **/
  @ApiModelProperty(required = true, value = "")

  public String getVersion() {
    return version;
  }


  public void setVersion(String version) {
    this.version = version;
  }


  public VersionUpload pluginDependencies(Map<String, Set<PluginDependency>> pluginDependencies) {
    
    this.pluginDependencies = pluginDependencies;
    return this;
  }

  public VersionUpload putPluginDependenciesItem(String key, Set<PluginDependency> pluginDependenciesItem) {
    if (this.pluginDependencies == null) {
      this.pluginDependencies = new HashMap<String, Set<PluginDependency>>();
    }
    this.pluginDependencies.put(key, pluginDependenciesItem);
    return this;
  }

   /**
   * Get pluginDependencies
   * @return pluginDependencies
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Map<String, Set<PluginDependency>> getPluginDependencies() {
    return pluginDependencies;
  }


  public void setPluginDependencies(Map<String, Set<PluginDependency>> pluginDependencies) {
    this.pluginDependencies = pluginDependencies;
  }


  public VersionUpload platformDependencies(Map<String, Set<String>> platformDependencies) {
    
    this.platformDependencies = platformDependencies;
    return this;
  }

  public VersionUpload putPlatformDependenciesItem(String key, Set<String> platformDependenciesItem) {
    if (this.platformDependencies == null) {
      this.platformDependencies = new HashMap<String, Set<String>>();
    }
    this.platformDependencies.put(key, platformDependenciesItem);
    return this;
  }

   /**
   * Get platformDependencies
   * @return platformDependencies
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Map<String, Set<String>> getPlatformDependencies() {
    return platformDependencies;
  }


  public void setPlatformDependencies(Map<String, Set<String>> platformDependencies) {
    this.platformDependencies = platformDependencies;
  }


  public VersionUpload description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    this.description = description;
  }


  public VersionUpload files(List<MultipartFileOrUrl> files) {
    
    this.files = files;
    return this;
  }

  public VersionUpload addFilesItem(MultipartFileOrUrl filesItem) {
    if (this.files == null) {
      this.files = new ArrayList<MultipartFileOrUrl>();
    }
    this.files.add(filesItem);
    return this;
  }

   /**
   * Get files
   * @return files
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<MultipartFileOrUrl> getFiles() {
    return files;
  }


  public void setFiles(List<MultipartFileOrUrl> files) {
    this.files = files;
  }


  public VersionUpload channel(String channel) {
    
    this.channel = channel;
    return this;
  }

   /**
   * Get channel
   * @return channel
  **/
  @ApiModelProperty(required = true, value = "")

  public String getChannel() {
    return channel;
  }


  public void setChannel(String channel) {
    this.channel = channel;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VersionUpload versionUpload = (VersionUpload) o;
    return Objects.equals(this.version, versionUpload.version) &&
        Objects.equals(this.pluginDependencies, versionUpload.pluginDependencies) &&
        Objects.equals(this.platformDependencies, versionUpload.platformDependencies) &&
        Objects.equals(this.description, versionUpload.description) &&
        Objects.equals(this.files, versionUpload.files) &&
        Objects.equals(this.channel, versionUpload.channel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(version, pluginDependencies, platformDependencies, description, files, channel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VersionUpload {\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    pluginDependencies: ").append(toIndentedString(pluginDependencies)).append("\n");
    sb.append("    platformDependencies: ").append(toIndentedString(platformDependencies)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    files: ").append(toIndentedString(files)).append("\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
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

}

