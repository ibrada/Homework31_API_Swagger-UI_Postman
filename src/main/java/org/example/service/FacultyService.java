package org.example.service;

import org.example.model.Faculty;
import org.example.model.Student;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class FacultyService {

    private final Map<Long, Faculty> facultyMap = new HashMap<>();
    private long lastId = 0;

    public Faculty createFaculty(Faculty faculty) {
        faculty.setId((++lastId));
        facultyMap.put(lastId, faculty);
        return faculty;
    }

    public Faculty findFaculty(long lastId) {
        return facultyMap.get(lastId);
    }

    public Faculty editFaculty(Faculty faculty) {
        if (facultyMap.containsKey(faculty.getId())) {
            facultyMap.put(faculty.getId(), faculty);
            return faculty;
        }
        return null;
    }

    public Faculty deleteFaculty(long id) {
        return facultyMap.remove(id);
    }

    public Collection<Faculty> getAllFaculties() {
        return facultyMap.values();
    }

}
