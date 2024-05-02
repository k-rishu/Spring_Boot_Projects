package com.MyOrg.LearnSpring_03;

public class Course {
    private long id;
    private String Name;
    private String author;

    public Course(long id, String name, String author) {
        super();
        this.id = id;
        Name = name;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getAuthor() {
        return author;
    }
}
