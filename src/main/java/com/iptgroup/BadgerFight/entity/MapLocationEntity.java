package com.iptgroup.BadgerFight.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "map_locations")

public class MapLocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    private String description;

    @OneToOne
    @JoinColumn(name = "enemy_id")
    private EnemyEntity entity;

    @OneToOne
    @JoinColumn(name = "quest_id")
    private QuestEntity quest;

    @ManyToMany
    @JoinTable(
            name = "location_connections",
            joinColumns = @JoinColumn(name = "location_id"),
            inverseJoinColumns = @JoinColumn(name = "connected_location_id")
    )

    private Set<MapLocationEntity> connections;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public QuestEntity getQuest() {return quest;}
    public void setQuest(QuestEntity quest) {this.quest = quest;}

    public EnemyEntity getEntity() {return entity;}
    public void setEntity(EnemyEntity entity) {this.entity = entity;}

    public Set<MapLocationEntity> getConnections() { return connections; }
    public void setConnections(Set<MapLocationEntity> connections) { this.connections = connections; }

    public MapLocationEntity() {}
}
