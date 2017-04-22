package RauAPI.model;

/**
 * Created by flo on 22.04.17.
 */
public class Resource {
    private long id;
    private String title;
    private String description;
    private String link;
    private int type;
    private int user;

    public Resource() {
    }

    public Resource(long id, String title, String description, String link, int type, int user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.link = link;
        this.type = type;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                ", type=" + type +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resource resource = (Resource) o;

        if (id != resource.id) return false;
        if (type != resource.type) return false;
        if (user != resource.user) return false;
        if (!title.equals(resource.title)) return false;
        if (!description.equals(resource.description)) return false;
        return link.equals(resource.link);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + title.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + link.hashCode();
        result = 31 * result + type;
        result = 31 * result + user;
        return result;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }
}
