package de.bentzin.hangar.api.development;

import de.bentzin.hangar.api.HangarJavaAPI;
import de.bentzin.hangar.api.base.HangarAPIVersion;
import de.bentzin.hangar.api.base.HangarInstance;
import de.bentzin.hangar.api.service.HangarAPIService;
import okhttp3.ResponseBody;

import java.io.IOException;

/**
 * @author Ture Bentzin
 * 27.01.2023
 */
public class Test {

    public static void main(String[] args) throws IOException {
        HangarJavaAPI hangarJavaAPI = new HangarJavaAPI(Keyholder.testHolder(), HangarInstance.stagingInstance, HangarAPIVersion.v1);
        HangarAPIService service = hangarJavaAPI.getService();
        ResponseBody authors = service.getAuthors().execute().body();;
        System.out.println(authors);
    }
}
