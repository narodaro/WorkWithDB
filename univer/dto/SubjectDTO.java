package com.veinik.Lesson7.src.main.resources.univer.dto;

public class SubjectDTO {

    private int id;
    private String Subject_name;

    public SubjectDTO(){
    }

    public SubjectDTO(String Subject_name){
        this.setSubject_name(Subject_name);
    }

    public SubjectDTO(int id, String Subject_name){
        this.setId(id);
        this.setSubject_name(Subject_name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject_name() {
        return Subject_name;
    }

    public void setSubject_name(String subjectName) {
        Subject_name = subjectName;
    }

//    @Override
//    public String toString() {
//        return getClass().getSimpleName() + " (id: " + id + ", SubjectName: " + Subject_name  + ")" + "\n";
//    }
}
