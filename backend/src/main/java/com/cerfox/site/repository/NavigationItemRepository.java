package com.cerfox.site.repository;

import com.cerfox.site.domain.NavigationItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NavigationItemRepository extends JpaRepository<NavigationItem, Long> {
    List<NavigationItem> findByParentIsNullOrderByDisplayOrderAsc();
    int countByParentId(Long parentId);
    int countByParentIsNull();
}
