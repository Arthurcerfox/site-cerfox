package com.cerfox.site.domain;

import com.cerfox.site.enums.SectionType;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sections",
        uniqueConstraints = @UniqueConstraint(name = "uq_page_section", columnNames = {"page_id", "key_name"})
)
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "page_id", nullable = false)
    private Page page;

    @Column(name = "key_name", nullable = false, length = 100)
    private String keyName;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, length = 50)
    private SectionType type;

    @Column(name = "anchor", length = 100)
    private String anchor;

    @Column(name = "display_order", nullable = false)
    private int displayOrder = 0;

    @Column(name = "is_visible", nullable = false)
    private boolean isVisible = true;

    @Column(name = "content", nullable = false, columnDefinition = "JSON")
    private String content;

    @Column(name = "styles", nullable = false, columnDefinition = "JSON")
    private String styles;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @OrderBy("changedAt DESC")
    private List<SectionRevision> revisions = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public Section() {}

    public Section(Page page, String keyName, SectionType type, int displayOrder, String content, String styles) {
        this.page = page;
        this.keyName = keyName;
        this.type = type;
        this.displayOrder = displayOrder;
        this.content = content;
        this.styles = styles;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Page getPage() { return page; }
    public void setPage(Page page) { this.page = page; }

    public String getKeyName() { return keyName; }
    public void setKeyName(String keyName) { this.keyName = keyName; }

    public SectionType getType() { return type; }
    public void setType(SectionType type) { this.type = type; }

    public String getAnchor() { return anchor; }
    public void setAnchor(String anchor) { this.anchor = anchor; }

    public int getDisplayOrder() { return displayOrder; }
    public void setDisplayOrder(int displayOrder) { this.displayOrder = displayOrder; }

    public boolean isVisible() { return isVisible; }
    public void setVisible(boolean visible) { isVisible = visible; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getStyles() { return styles; }
    public void setStyles(String styles) { this.styles = styles; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public List<SectionRevision> getRevisions() { return revisions; }
    public void setRevisions(List<SectionRevision> revisions) { this.revisions = revisions; }
}