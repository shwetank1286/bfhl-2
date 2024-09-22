package com.example.userregistration.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "college_email_id")
    private String collegeEmailId;

    @Column(name = "college_roll_number")
    private String collegeRollNumber;

    @Column(name = "numbers_array")
    private String numbersArray;

    @Column(name = "alphabets_array")
    private String alphabetsArray;

    @Column(name = "highest_lowercase")
    private String highestLowercase;

    @Column(name = "file_valid")
    private boolean fileValid;

    @Column(name = "file_mime_type")
    private String fileMimeType;

    @Column(name = "file_size_kb")
    private long fileSizeKB;
}
