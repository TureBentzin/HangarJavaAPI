package de.bentzin.hangar.api.development;

import de.bentzin.hangar.api.*;
import de.bentzin.hangar.api.client.ProjectsApi;
import org.jetbrains.annotations.NotNull;
import org.openapitools.client.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ture Bentzin
 * 27.01.2023
 */
public class Test {

    public static void main(String[] args) throws IOException {

        try {
            List<Project> allProjects = getAllProjects();
            allProjects.stream().map(Project::getName).forEach(System.out::println);

        } catch (ApiException e) {
            throw new RuntimeException(e);
        }

        /*
        try {

            ApiClient apiClient = new ApiClient();
            Configuration.setDefaultApiClient(apiClient);

            AuthenticationApi authenticationApi = new AuthenticationApi();
            Response execute = authenticationApi.authenticateCall("278a0ce4-9dbd-4648-9281-820b2a0cec03", new ApiCallback() {
                @Override
                public void onFailure(ApiException e, int statusCode, Map responseHeaders) {
                    System.out.println("e = " + e + ", statusCode = " + statusCode + ", responseHeaders = " + responseHeaders);
                }

                @Override
                public void onSuccess(Object result, int statusCode, Map responseHeaders) {
                    System.out.println("result = " + result + ", statusCode = " + statusCode + ", responseHeaders = " + responseHeaders);
                }

                @Override
                public void onUploadProgress(long bytesWritten, long contentLength, boolean done) {
                    System.out.println("bytesWritten = " + bytesWritten + ", contentLength = " + contentLength + ", done = " + done);
                }

                @Override
                public void onDownloadProgress(long bytesRead, long contentLength, boolean done) {
                    System.out.println("bytesRead = " + bytesRead + ", contentLength = " + contentLength + ", done = " + done);
                }
            }).execute();

            User tureBentzin = new UsersApi().getUser("TureBentzin");

            PaginatedResultProject projects =
                    new ProjectsApi().getProjects(new RequestPagination().limit(999999L), null, null, null, null, null,
                            null, null, null);
            System.out.println(projects.getPagination());
            for (Project project : projects.getResult()) {
                System.out.println(project.getName());
            }
            System.out.println("bentzin:" + tureBentzin);
            System.out.println("response" + execute);

            /*
            ApiSession authenticate = new AuthenticationApi().authenticate("7c7c6b56-46a2-461b-a560-509ad75931b3");
            PaginatedResultUser name = new UsersApi().getAuthors(new RequestPagination(), "name");
            for (User user : name.getResult()) {
                System.out.println(user.getName());
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

  */
    }

    public static @NotNull List<Project> getAllProjects() throws ApiException {
        ArrayList<Project> projectArrayList = new ArrayList<>();
        long current = 0;
        long count = 0;
            PaginatedResultProject initialResult = getNextProjectsResult(0);
            count = initialResult.getPagination().getCount();
            current = initialResult.getPagination().getOffset();
            projectArrayList.addAll(initialResult.getResult());
        System.out.println("initial: " + current + "/" + count + " [" + projectArrayList.size() + "]");
            while (current < count) {
                PaginatedResultProject nextProjectsResult = getNextProjectsResult(current);
                count = nextProjectsResult.getPagination().getCount();
                current = nextProjectsResult.getPagination().getOffset();
                projectArrayList.addAll(nextProjectsResult.getResult());
                System.out.println("loading: " + current + "/" + count + " [" + projectArrayList.size() + "]");
                if(projectArrayList.size() > count)  {
                    System.err.println("PANIC!");
                    break;
                }
            }
        return projectArrayList;
    }

    public static PaginatedResultProject getNextProjectsResult(long offset) throws ApiException { {
        RequestPagination requestPagination = new RequestPagination().offset(offset);
        return new ProjectsApi().getProjects(requestPagination, true, null, null, null, null,
                null, null, null);
    }



    }
}
