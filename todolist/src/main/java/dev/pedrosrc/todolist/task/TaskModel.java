package dev.pedrosrc.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_tasks")
public class TaskModel {
    /*
     * ID
     * USER
     * TITLE
     * DESCRIPTION
     * CREATED DATE
     * PRIORITY
     * 
     */
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    
    @Column(length = 50)
    private String title;
    private String description;
    @Column(length = 50)
    private String priority;

    private UUID idUser;

    @CreationTimestamp
    private LocalDateTime createdAt;

    
}