package de.bentzin.hangar.api.response;

import java.util.SimpleTimeZone;

/**
 * @author Ture Bentzin
 * 27.01.2023
 */
public class User {
    public String createdAt;
    public String name;
    public String tagline;
    public String joinDate;
    public String roles;
    public int projectCount;
    public boolean locked;
}
