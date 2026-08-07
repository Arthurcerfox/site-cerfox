export interface CreateNavigationRequest {
    parentId?: number,
    label: string,
    href?: string,
    pageId?: number,
    displayOrder?: number
}

export interface UpdateNavigationRequest {
    label?: string,
    href?: string,
    pageId?: number,
    displayOrder?: number,
    isActive?: boolean
}

export interface NavigationItemResponse {
    id: number,
    parentId: number | null,
    order: number | null,
    label: string,
    href: string | null,
    items: NavigationItemResponse[] | null,
}