package com.example.DukeStrategicTechnologies.pki.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "templates")
public class Template {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "signature_algorithm")
    private String signatureAlgorithm;

    @Column(name = "key_algorithm")
    private String keyAlgorithm;

    @ElementCollection
    @CollectionTable(name = "key_usages", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "key_usage")
    private Set<String> keyUsage;

    @ElementCollection
    @CollectionTable(name = "extended_key_usages", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "extended_key_usage")
    private Set<String> extendedKeyUsage;

    @Column(name = "name")
    private String name;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    public Template() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSignatureAlgorithm() {
        return signatureAlgorithm;
    }

    public void setSignatureAlgorithm(String signatureAlgorithm) {
        this.signatureAlgorithm = signatureAlgorithm;
    }

    public String getKeyAlgorithm() {
        return keyAlgorithm;
    }

    public void setKeyAlgorithm(String keyAlgorithm) {
        this.keyAlgorithm = keyAlgorithm;
    }

    public Set<String> getKeyUsage() {
        return keyUsage;
    }

    public void setKeyUsage(Set<String> keyUsage) {
        this.keyUsage = keyUsage;
    }

    public Set<String> getExtendedKeyUsage() {
        return extendedKeyUsage;
    }

    public void setExtendedKeyUsage(Set<String> extendedKeyUsage) {
        this.extendedKeyUsage = extendedKeyUsage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}