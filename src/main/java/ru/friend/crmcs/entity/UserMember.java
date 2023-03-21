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

    /**
     * юзернейм пользователя системы
     */
    private String username;

    /**
     * пасворд пользователя системы (занчение зашивровано Base64)
     */
    private String password;

    /**
     * строковое предствление Имени и фамилии пользователя
     */
    private String name;

    /**
     * Роль ENUM
     */
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "orderCreator")
    private List<OrderCS> orderCS;

    @OneToMany(mappedBy = "author")
    private List<CommentForOrders> comments;
}
