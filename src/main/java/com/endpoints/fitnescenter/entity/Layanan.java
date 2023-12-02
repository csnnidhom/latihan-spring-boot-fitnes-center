package com.endpoints.fitnescenter.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "menu_layanan")
public class Layanan {

    @Id
    private String menu_name;

    private Integer duration;


}
