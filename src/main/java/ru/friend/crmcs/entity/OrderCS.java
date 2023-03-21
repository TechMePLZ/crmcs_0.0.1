package ru.friend.crmcs.entity;

import lombok.*;

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
     *
     */
    private Boolean isReady;

    private Boolean isActive;

    @Column(updatable = false)
    private OffsetDateTime creationTime;

    @Column(updatable = false)
    private OffsetDateTime closedTime;

    private String bodyOfOrder;

    private Boolean isNotified;

    @OneToMany(mappedBy = "orderCS")
    private List<CommentForOrders> commentsForOrders;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private UserMember orderCreator;

}
