package ru.friend.crmcs.entity.client;


import lombok.*;
import ru.friend.crmcs.entity.order.OrderCS;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Полное имя клиента
     */
    @Column(nullable = false)
    private String fullName;

    /**
     * Сторковое представление основного контактного номера телефона
     *
     */
    @Column(nullable = false)
    private String primaryPhoneNumber;

    /**
     * Сторковое представление дополнительного  контактного номера телефона
     */
    private String secondaryPhoneNumber;
    /**
     * Сторковое представление email
     */
    private String email;

    /**
     * Булевое значение  имеет ли клиент месенджер(TG, WA, Viber)  для опопвещения клиента через мессенджер
     * true = есть мессенджер, false = нет мессенджера
     */
    @Column( columnDefinition = "boolean default false")
    private Boolean haveMessenger;

    /**
     * ЕНАМ  мессенджера (TG, WA, Viber) строковое представление
     */
    @Enumerated(EnumType.STRING)
    private Messenger messenger;

    @OneToMany (mappedBy = "client")
    private List<OrderCS> orderCS;


}
