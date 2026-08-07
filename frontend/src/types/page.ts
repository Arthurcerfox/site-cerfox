import { SectionResponse } from './section'

export interface CreatePageRequest {
    slug: string
    title: string
    meta?: string
}

export interface UpdatePageRequest {
    title?: string
    slug?: string
    isActive?: boolean
    meta?: unknown
}

export interface PageSummaryResponse {
    id: number
    slug: string
    title: string
    isLanding: boolean
    isActive: boolean
}

export interface PageDetailResponse {
    id: number
    slug: string
    title: string
    isLanding: boolean
    isActive: boolean
    meta: unknown
    sections: SectionResponse[]
}