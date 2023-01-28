package de.bentzin.hangar.api.development;

import de.bentzin.hangar.api.ApiClient;
import de.bentzin.hangar.api.ApiException;
import de.bentzin.hangar.api.client.ProjectsApi;
import org.jetbrains.annotations.NotNull;
import de.bentzin.hangar.api.model.*;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Ture Bentzin
 * 28.01.2023
 */
public class ProjectSearchTest {

    public static void main(String[] args) throws IOException, ApiException {
        InputStreamReader i = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(i);
        ApiClient client = new ApiClient();
        ProjectsApi projectsApi = new ProjectsApi(client);
        while (true) {
            System.out.print("Type query: ");
            String input = reader.readLine();
            System.out.println();
            System.out.println("-> " + input);
            System.out.println("searching...");
            PaginatedResultProject search = search(projectsApi, input);
            System.out.println("------------------------------------");
            System.out.println("Seitennation: " + search.getPagination());
            for (Project project : search.getResult()) {
                System.out.println(project.getName() + " by " + project.getNamespace().getOwner() + "[" + project.getCategory().name() + "]");
            }
            System.out.println(">----------------------------------<");
        }
    }

    private static PaginatedResultProject search(@NotNull ProjectsApi api, String name) throws ApiException {
        return api.getProjects(new RequestPagination().offset(3L), true, null, null, null, null, name, null, null);
    }
}
