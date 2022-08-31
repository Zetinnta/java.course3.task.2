package pro.sky.java.course3.task2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Avatar {

    @Id
    @GeneratedValue
    private Long id;

    private String filePath;
    private Long fileSize;
    private String mediaType;

    @Lob
    private byte[] data;

    @OneToOne
    @JsonIgnore
    private Student student;

//    public Avatar(Long id, String filePath, Long fileSize, String mediaType, Student student, byte[] data) {
//        this.id = id;
//        this.filePath = filePath;
//        this.fileSize = fileSize;
//        this.mediaType = mediaType;
//        this.student = student;
//        this.data = data;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avatar avatar = (Avatar) o;
        return Objects.equals(id, avatar.id) && Objects.equals(filePath, avatar.filePath) && Objects.equals(fileSize, avatar.fileSize) && Objects.equals(mediaType, avatar.mediaType) && Arrays.equals(data, avatar.data) && Objects.equals(student, avatar.student);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, filePath, fileSize, mediaType, student);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }

    @Override
    public String toString() {
        return "Avatar{" +
                "id=" + id +
                ", filePath='" + filePath + '\'' +
                ", fileSize=" + fileSize +
                ", mediaType='" + mediaType + '\'' +
                ", data=" + Arrays.toString(data) +
                ", student=" + student +
                '}';
    }
}