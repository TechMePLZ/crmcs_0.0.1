package ru.friend.crmcs.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class CommentForOrders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Соотнощенеи к какому заказу соотносится данный коментарий
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private OrderCS orderCS;

    /**
     * Строковое прпедставление тела коментария
     */
    private  String bodyOfComments;

    /**
     * Время создания коментария
     */
    @Column(updatable = false)
    private OffsetDateTime createTime;

    /**
     * Пользователь создавший кометарий
     */

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private UserMember author;
}
