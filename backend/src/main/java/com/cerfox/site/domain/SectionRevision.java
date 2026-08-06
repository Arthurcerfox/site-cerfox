package com.cerfox.site.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "section_revisions")
public class SectionRevision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "section_id", nullable = false)
    private Section section;

    @Column(name = "content", columnDefinition = "JSON")
    private String content;

    @Column(name = "styles", columnDefinition = "JSON")
    private String styles;

    @Column(name = "changed_by")
    private Long changedBy;

    @Column(name = "changed_at", nullable = false, updatable = false)
    private LocalDateTime changedAt;

    @PrePersist
    protected void onCreate() {
        this.changedAt = LocalDateTime.now();
    }

    public SectionRevision() {}

    public SectionRevision(Section section, String content, String styles, Long changedBy) {
        this.section = section;
        this.content = content;
        this.styles = styles;
        this.changedBy = changedBy;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Section getSection() { return section; }
    public void setSection(Section section) { this.section = section; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getStyles() { return styles; }
    public void setStyles(String styles) { this.styles = styles; }

    public Long getChangedBy() { return changedBy; }
    public void setChangedBy(Long changedBy) { this.changedBy = changedBy; }

    public LocalDateTime getChangedAt() { return changedAt; }
}
