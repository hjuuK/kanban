package models.works;

import java.util.ArrayList;
import java.util.List;

public enum Status {
    READY("준비중"),
    PROGRESS("진행중"),
    DONE("완료"),
    POSTPONE("보류");
    
    private String status;
    
    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static List<String[]> getList() {
        List<String[]> items = new ArrayList<>();
        items.add(new String[] {READY.name(), READY.getStatus()});
        items.add(new String[] {PROGRESS.name(), PROGRESS.getStatus()});
        items.add(new String[] {DONE.name(), DONE.getStatus()});
        items.add(new String[] {POSTPONE.name(), POSTPONE.getStatus()});

        return items;
    }
}
