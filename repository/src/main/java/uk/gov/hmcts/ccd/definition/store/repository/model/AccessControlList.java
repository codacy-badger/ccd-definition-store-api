package uk.gov.hmcts.ccd.definition.store.repository.model;

public class AccessControlList {

    private String role;

    private Boolean create;

    private Boolean read;

    private Boolean update;

    private Boolean delete;

    public AccessControlList() {
    }

    public AccessControlList(String role,
                             Boolean create,
                             Boolean read,
                             Boolean update,
                             Boolean delete) {
        this.role = role;
        this.create = create;
        this.read = read;
        this.update = update;
        this.delete = delete;
    }

    public String getRole() {
        return role;
    }

    public Boolean getCreate() {
        return create;
    }

    public Boolean getRead() {
        return read;
    }

    public Boolean getUpdate() {
        return update;
    }

    public Boolean getDelete() {
        return delete;
    }

}
