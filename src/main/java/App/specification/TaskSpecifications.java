package App.specification;

import App.dao.entity.Organization;
import App.dao.entity.Status;
import App.dao.entity.Task;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class TaskSpecifications {
    public static Specification<Task> withStatus(Status status) {
        return (root, query, builder) -> builder.equal(root.get("status"), status);
    }


    public static Specification<Task> expiredBefore(LocalDateTime expiredAt) {
        return (root, query, builder) -> builder.lessThan(root.get("expiredAt"), expiredAt);
    }

    public static Specification<Task> withTitle(String title) {
        return (root, query, builder) -> builder.equal(root.get("title"), title);
    }

    public static Specification<Task> withDescription(String description) {
        return (root, query, builder) -> builder.equal(root.get("description"), description);
    }

}
