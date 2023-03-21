package ru.friend.crmcs.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class UserMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String name;

    private String role;

    @OneToMany(mappedBy = "orderCreator")
    private List<OrderCS> orderCS;

    @OneToMany(mappedBy = "author")
    private List<CommentForOrders> comments;
}
