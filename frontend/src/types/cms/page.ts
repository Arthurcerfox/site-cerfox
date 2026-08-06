import { SectionResponse } from './section'

export interface CreatePageRequest {
    slug: string
    title: string
    isLanding: boolean
    meta: string
}

export interface UpdatePageRequest {
    title?: string
    isLanding?: boolean
    meta?: string
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
    meta: string
    sections: SectionResponse[]
}