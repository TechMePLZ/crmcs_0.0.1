package ru.friend.crmcs.entity.order;

import lombok.*;
import ru.friend.crmcs.entity.user.UserMember;
import ru.friend.crmcs.entity.client.Client;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class OrderCS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    /**
     * Флаг значение выполнения задачи
     * true = задача выполнена, false = задача не выаолнена
     * Значение по умолчанию = false
     */
    @Column( columnDefinition = "boolean default false")
    private Boolean isReady;

    /**
     * Флаг значение закрытия задачи
     * true = задача закрыта, false = задача не закрыта
     * Значение по умолчанию = false
     */
    @Column( columnDefinition = "boolean default false")
    private Boolean isActive;

    /**
     * Дата и время создания задачи
     */
    @Column(updatable = false)
    private OffsetDateTime creationTime;

    /**
     * Дата и время закрытия задачи
     */
    @Column(updatable = false)
    private OffsetDateTime closedTime;

    /**
     * Текстовое тело заддачи/заказа
     */
    private String bodyOfOrder;

    /**
     * Флаг значение оповещен ли клиент о готовности
     * true = клинет оповещен, false = клиент не оповещен
     * Значение по умолчанию = false
     */
    @Column( columnDefinition = "boolean default false")
    private Boolean isNotified;

    @OneToMany(mappedBy = "orderCS")
    private List<CommentForOrders> commentsForOrders;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private UserMember orderCreator;

}
