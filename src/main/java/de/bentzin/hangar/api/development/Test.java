package de.bentzin.hangar.api.development;

import de.bentzin.hangar.api.client.ProjectsApi;
import de.bentzin.hangar.api.ApiException;
import org.jetbrains.annotations.NotNull;
import de.bentzin.hangar.api.model.*;

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
                current = nextProjectsResult.getPagination().getOffset() + nextProjectsResult.getResult().size();
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
