package bugtracker;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

public class BugTracker {

    private List<Bug> bugs;
    private static final String FILE_PATH = "bugs.json";

    public BugTracker() {
        this.bugs = loadBugs();
    }

    public void addBug(Bug bug) {
        bugs.add(bug);
        saveBugs();
    }

    public List<Bug> getAllBugs() {
        return bugs;
    }

    public List<Bug> filterBugs(Severity severity, Status status) {
        return bugs.stream()
                .filter(b -> (severity == null || b.getSeverity() == severity) &&
                             (status == null || b.getStatus() == status))
                .collect(Collectors.toList());
    }

    public void updateBugStatus(String title, Status newStatus) {
        for (Bug b : bugs) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                b.setStatus(newStatus);
                saveBugs();
                break;
            }
        }
    }

    private List<Bug> loadBugs() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type bugListType = new TypeToken<ArrayList<Bug>>() {}.getType();
            return new Gson().fromJson(reader, bugListType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private void saveBugs() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            new Gson().toJson(bugs, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}