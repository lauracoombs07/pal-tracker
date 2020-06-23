package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private final Map<Long, TimeEntry> timeEntries = new HashMap<>();

    private long idCounter = 1L;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {

        long id = idCounter++;
        TimeEntry timeEntryRecord = new TimeEntry(
                id,
                timeEntry.getProjectId(),
                timeEntry.getUserId(),
                timeEntry.getDate(),
                timeEntry.getHours()

        );
        timeEntries.put(id, timeEntryRecord);
        return timeEntryRecord;
    }

    public TimeEntry find(long id) {
        if (timeEntries.get(id) == null) {
            return null;
        }
        return timeEntries.get(id);
    }


    public List<TimeEntry> list() {
        return new ArrayList<TimeEntry>(timeEntries.values());
    }

    @Override
    public void delete(long timeEntryId) {
        timeEntries.remove(timeEntryId);
    }

    public TimeEntry update(long id, TimeEntry timeEntryToUpdate) {
        if (timeEntries.get(id) == null){
            return null;
        }
        TimeEntry updatedTimeEntry = new TimeEntry(
                id,
                timeEntryToUpdate.getProjectId(),
                timeEntryToUpdate.getUserId(),
                timeEntryToUpdate.getDate(),
                timeEntryToUpdate.getHours()
        );

        timeEntries.put(id, updatedTimeEntry);

        return updatedTimeEntry;
    }


}
