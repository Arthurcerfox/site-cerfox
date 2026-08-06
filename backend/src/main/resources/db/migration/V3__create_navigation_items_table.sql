CREATE TABLE navigation_items (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    parent_id BIGINT,
    label VARCHAR(100) NOT NULL,
    href VARCHAR(100),
    page_id BIGINT,
    display_order INT NOT NULL DEFAULT 0,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    FOREIGN KEY (parent_id) REFERENCES navigation_items (id) ON DELETE CASCADE,
    FOREIGN KEY (page_id) REFERENCES pages (id) ON DELETE SET NULL
);