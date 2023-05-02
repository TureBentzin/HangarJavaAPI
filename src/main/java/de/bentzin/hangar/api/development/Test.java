package de.bentzin.hangar.api.development;

import de.bentzin.hangar.api.ApiException;
import de.bentzin.hangar.api.client.ProjectsApi;
import de.bentzin.hangar.api.client.VersionsApi;
import de.bentzin.hangar.api.model.*;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author Ture Bentzin
 * 27.01.2023
 */
public class Test {

    public static void main(String[] args) throws IOException {

        try {
            List<Project> allProjects = getAllProjects();
            //testUploadVersion();
            for (Project allProject : allProjects) {
                System.out.println(allProject.getName() + " by " + allProject.getNamespace().getOwner());
            }
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
    }


    public static void testUploadVersion() throws ApiException {
        VersionsApi versionsApi = new VersionsApi();
        File file = new File("File.jar");
        VersionUpload upload = new VersionUpload();
        upload.version("1");
        upload.channel("Release");
        upload.description("test");
        MultipartFileOrUrl fileOrUrl = new MultipartFileOrUrl();
        fileOrUrl.url(true);
        fileOrUrl.addPlatformsItem(Platform.PAPER);
        HashMap<String, Set<String>> depends = new HashMap<>();
        depends.put("PAPER", Set.of("1.18"));
        upload.setPlatformDependencies(depends);
        fileOrUrl.externalUrl("https://hangarcdn.papermc.dev/plugins/MiniDigger/ddd/versions/4.0.1/VELOCITY/MaintenanceVelocity%20(1)%20(1).jar");
        upload.addFilesItem(fileOrUrl);
        versionsApi.uploadVersion("TureBentzin", "HangarAPITEST", upload, null);
    }

    public static @NotNull List<Project> getAllProjectsAtOnce() throws ApiException {
        return Objects.requireNonNull(new ProjectsApi().getProjects(new RequestPagination().limit(1000L), true, null, null,
                null, null, null, null, null).getResult());
    }


    public static List<Project> getAllProjects() throws ApiException {
        return getProjects(null);
    }

    public static @NotNull List<Project> getProjects(String query) throws ApiException {
        ArrayList<Project> projectArrayList = new ArrayList<>();
        long current = 0;
        long count = 0;
        PaginatedResultProject initialResult = getNextProjectsResult(0, query);
        count = initialResult.getPagination().getCount();
        current = initialResult.getPagination().getOffset();
        projectArrayList.addAll(initialResult.getResult());
        System.out.println("initial: " + current + "/" + count + " [" + projectArrayList.size() + "]");
        while (current < count) {
            PaginatedResultProject nextProjectsResult = getNextProjectsResult(current, query);
            count = nextProjectsResult.getPagination().getCount();
            current = nextProjectsResult.getPagination().getOffset() + nextProjectsResult.getResult().size();
            projectArrayList.addAll(nextProjectsResult.getResult());
            System.out.println("loading at: " + (current) + "/" + count + " [" + projectArrayList.size() + "]");
            if (projectArrayList.size() > count) {
                System.err.println("PANIC!");
                break;
            }
        }
        return projectArrayList;
    }

    public static PaginatedResultProject getNextProjectsResult(long offset, String query) throws ApiException {
        RequestPagination requestPagination = new RequestPagination().offset(offset);
        return new ProjectsApi().getProjects(requestPagination.limit(50L), true, "slug", null, null, null,
                query, null, null);
    }

    public static @NotNull Optional<Project> findBestProject(String name) throws ApiException {
        return getProjects(name).stream().findFirst();
    }

    @org.junit.Test
    public void testFindBestProject() {
        try {
            Optional<Project> bestProject = findBestProject("A");
            bestProject.ifPresent(project ->{
                System.out.println(project.getNamespace().getOwner() + "/" + project.getNamespace().getSlug());
            });
           // System.out.println(bestProject);
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
    }

    @org.junit.Test
    public void downloadProject() throws ApiException {
        Project project = new ProjectsApi().getProject("TureBentzin", "Core");
        String string = new VersionsApi().downloadVersion("TureBentzin", "Core", "1.0", Platform.PAPER).toString();
        System.out.println(string);
    }
}
