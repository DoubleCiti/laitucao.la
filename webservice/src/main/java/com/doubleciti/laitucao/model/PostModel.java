package com.doubleciti.laitucao.model;

import com.doubleciti.laitucao.domain.Post;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

import java.util.Objects;

public class PostModel {
    private String id = null;

    @NotEmpty
    private String title = null;

    @NotEmpty
    @URL(protocol = "http")
    private String link = null;

    public PostModel(Post entity) {
        this.id = entity.getId().toString();
        this.title = entity.getTitle();
        this.link = entity.getLink();
    }

    /**
     * Unique identifier representing a specific product for a given latitude & longitude. For example, uberX in San Francisco will have a different product_id than uberX in Los Angeles.
     **/
    public PostModel id(String id) {
        this.id = id;
        return this;
    }


    @ApiModelProperty(value = "Unique identifier representing a specific product for a given latitude & longitude. For example, uberX in San Francisco will have a different product_id than uberX in Los Angeles.")
    @JsonProperty("id")
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Description of product.
     **/
    public PostModel title(String title) {
        this.title = title;
        return this;
    }


    @ApiModelProperty(value = "Description of product.")
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Display name of product.
     **/
    public PostModel link(String link) {
        this.link = link;
        return this;
    }


    @ApiModelProperty(value = "Display name of product.")
    @JsonProperty("link")
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PostModel post = (PostModel) o;
        return Objects.equals(id, post.id) &&
                Objects.equals(title, post.title) &&
                Objects.equals(link, post.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, link);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Post {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    title: ").append(toIndentedString(title)).append("\n");
        sb.append("    link: ").append(toIndentedString(link)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
