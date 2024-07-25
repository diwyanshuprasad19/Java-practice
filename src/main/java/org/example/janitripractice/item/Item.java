package org.example.janitripractice.item;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity(name = "item")
@Table(name = "item")
public class Item {
    // Id this will be our primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title", columnDefinition = "TEXT")
    private String title;

    @Column(name="full_description", columnDefinition = "TEXT")
    private String fullDescription;

    @Column(name="price", columnDefinition = "TEXT")
    private String price;
}