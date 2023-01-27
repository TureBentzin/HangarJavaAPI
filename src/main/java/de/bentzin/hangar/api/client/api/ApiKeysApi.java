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


package de.bentzin.hangar.api.client.api;

import com.google.gson.reflect.TypeToken;
import de.bentzin.hangar.api.client.*;
import de.bentzin.hangar.api.client.model.ApiKey;
import de.bentzin.hangar.api.client.model.CreateAPIKeyForm;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiKeysApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public ApiKeysApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ApiKeysApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public int getHostIndex() {
        return localHostIndex;
    }

    public void setHostIndex(int hostIndex) {
        this.localHostIndex = hostIndex;
    }

    public String getCustomBaseUrl() {
        return localCustomBaseUrl;
    }

    public void setCustomBaseUrl(String customBaseUrl) {
        this.localCustomBaseUrl = customBaseUrl;
    }

    /**
     * Build call for createKey
     * @param createAPIKeyForm  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 403 </td><td> Not enough permissions to use this endpoint </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Api session missing, invalid or expired </td><td>  -  </td></tr>
        <tr><td> 201 </td><td> Key created </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createKeyCall(CreateAPIKeyForm createAPIKeyForm, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = createAPIKeyForm;

        // create path and map variables
        String localVarPath = "/api/v1/keys";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "text/plain"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "HangarAuth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call createKeyValidateBeforeCall(CreateAPIKeyForm createAPIKeyForm, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'createAPIKeyForm' is set
        if (createAPIKeyForm == null) {
            throw new ApiException("Missing the required parameter 'createAPIKeyForm' when calling createKey(Async)");
        }

        return createKeyCall(createAPIKeyForm, _callback);

    }

    /**
     * Creates an API key
     * Creates an API key. Requires the &#x60;edit_api_keys&#x60; permission.
     * @param createAPIKeyForm  (required)
     * @return String
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 403 </td><td> Not enough permissions to use this endpoint </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Api session missing, invalid or expired </td><td>  -  </td></tr>
        <tr><td> 201 </td><td> Key created </td><td>  -  </td></tr>
     </table>
     */
    public String createKey(CreateAPIKeyForm createAPIKeyForm) throws ApiException {
        ApiResponse<String> localVarResp = createKeyWithHttpInfo(createAPIKeyForm);
        return localVarResp.getData();
    }

    /**
     * Creates an API key
     * Creates an API key. Requires the &#x60;edit_api_keys&#x60; permission.
     * @param createAPIKeyForm  (required)
     * @return ApiResponse&lt;String&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 403 </td><td> Not enough permissions to use this endpoint </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Api session missing, invalid or expired </td><td>  -  </td></tr>
        <tr><td> 201 </td><td> Key created </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<String> createKeyWithHttpInfo(CreateAPIKeyForm createAPIKeyForm) throws ApiException {
        okhttp3.Call localVarCall = createKeyValidateBeforeCall(createAPIKeyForm, null);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Creates an API key (asynchronously)
     * Creates an API key. Requires the &#x60;edit_api_keys&#x60; permission.
     * @param createAPIKeyForm  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 403 </td><td> Not enough permissions to use this endpoint </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Api session missing, invalid or expired </td><td>  -  </td></tr>
        <tr><td> 201 </td><td> Key created </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createKeyAsync(CreateAPIKeyForm createAPIKeyForm, final ApiCallback<String> _callback) throws ApiException {

        okhttp3.Call localVarCall = createKeyValidateBeforeCall(createAPIKeyForm, _callback);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for deleteKey
     * @param name The name of the key to delete (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> Key deleted </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Not enough permissions to use this endpoint </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Api session missing, invalid or expired </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteKeyCall(String name, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/v1/keys";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (name != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("name", name));
        }

        final String[] localVarAccepts = {
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "HangarAuth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call deleteKeyValidateBeforeCall(String name, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'name' is set
        if (name == null) {
            throw new ApiException("Missing the required parameter 'name' when calling deleteKey(Async)");
        }

        return deleteKeyCall(name, _callback);

    }

    /**
     * Deletes an API key
     * Deletes an API key. Requires the &#x60;edit_api_keys&#x60; permission.
     * @param name The name of the key to delete (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> Key deleted </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Not enough permissions to use this endpoint </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Api session missing, invalid or expired </td><td>  -  </td></tr>
     </table>
     */
    public void deleteKey(String name) throws ApiException {
        deleteKeyWithHttpInfo(name);
    }

    /**
     * Deletes an API key
     * Deletes an API key. Requires the &#x60;edit_api_keys&#x60; permission.
     * @param name The name of the key to delete (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> Key deleted </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Not enough permissions to use this endpoint </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Api session missing, invalid or expired </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Void> deleteKeyWithHttpInfo(String name) throws ApiException {
        okhttp3.Call localVarCall = deleteKeyValidateBeforeCall(name, null);
        return localVarApiClient.execute(localVarCall);
    }

    /**
     * Deletes an API key (asynchronously)
     * Deletes an API key. Requires the &#x60;edit_api_keys&#x60; permission.
     * @param name The name of the key to delete (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td> Key deleted </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Not enough permissions to use this endpoint </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Api session missing, invalid or expired </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteKeyAsync(String name, final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = deleteKeyValidateBeforeCall(name, _callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }
    /**
     * Build call for getKeys
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 403 </td><td> Not enough permissions to use this endpoint </td><td>  -  </td></tr>
        <tr><td> 200 </td><td> Key created </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Api session missing, invalid or expired </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getKeysCall(final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/v1/keys";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "HangarAuth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getKeysValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        return getKeysCall(_callback);

    }

    /**
     * Fetches a list of API Keys
     * Fetches a list of API Keys. Requires the &#x60;edit_api_keys&#x60; permission.
     * @return ApiKey
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 403 </td><td> Not enough permissions to use this endpoint </td><td>  -  </td></tr>
        <tr><td> 200 </td><td> Key created </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Api session missing, invalid or expired </td><td>  -  </td></tr>
     </table>
     */
    public ApiKey getKeys() throws ApiException {
        ApiResponse<ApiKey> localVarResp = getKeysWithHttpInfo();
        return localVarResp.getData();
    }

    /**
     * Fetches a list of API Keys
     * Fetches a list of API Keys. Requires the &#x60;edit_api_keys&#x60; permission.
     * @return ApiResponse&lt;ApiKey&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 403 </td><td> Not enough permissions to use this endpoint </td><td>  -  </td></tr>
        <tr><td> 200 </td><td> Key created </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Api session missing, invalid or expired </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<ApiKey> getKeysWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = getKeysValidateBeforeCall(null);
        Type localVarReturnType = new TypeToken<ApiKey>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Fetches a list of API Keys (asynchronously)
     * Fetches a list of API Keys. Requires the &#x60;edit_api_keys&#x60; permission.
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 403 </td><td> Not enough permissions to use this endpoint </td><td>  -  </td></tr>
        <tr><td> 200 </td><td> Key created </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Api session missing, invalid or expired </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getKeysAsync(final ApiCallback<ApiKey> _callback) throws ApiException {

        okhttp3.Call localVarCall = getKeysValidateBeforeCall(_callback);
        Type localVarReturnType = new TypeToken<ApiKey>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
