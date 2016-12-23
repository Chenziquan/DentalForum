package jqchen.dentalforum.data.bean;

/**
 * Created by jqchen on 2016/12/12.
 * Use to
 */
public class UserBean {
    private String id;
    private String name;
    private String integration;
    private String posts;
    private String wealth;
    private String collections;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntegration() {
        return integration;
    }

    public void setIntegration(String integration) {
        this.integration = integration;
    }

    public String getPosts() {
        return posts;
    }

    public void setPosts(String posts) {
        this.posts = posts;
    }

    public String getWealth() {
        return wealth;
    }

    public void setWealth(String wealth) {
        this.wealth = wealth;
    }

    public String getCollections() {
        return collections;
    }

    public void setCollections(String collections) {
        this.collections = collections;
    }

    public UserBean() {

    }
}
