export enum SectionType {
  HERO = 'HERO',
  BANNER = 'BANNER',
  CARDS = 'CARDS',
  TEXT = 'TEXT',
  CONTACT = 'CONTACT',
  VACANCIES = 'VACANCIES',
  GALLERY = 'GALLERY',
  FAQ = 'FAQ',
  CTA = 'CTA',
  CUSTOM = 'CUSTOM'
}

export interface SectionResponse {
  id: number
  keyName: string
  type: SectionType
  anchor: string | null
  displayOrder: number
  isVisible: boolean
  content: Record<string, unknown>
  styles: Record<string, unknown>
}

export interface CreateSectionRequest {
    keyName: string
    type: SectionType
    anchor?: string | null
    displayOrder: number
    content: Record<string, unknown>
    styles: Record<string, unknown>
}

export interface UpdateSectionRequest {
    content?: Record<string, unknown>
    styles?: Record<string, unknown>
    displayOrder?: number
    isVisible?: boolean
    anchor?: string
}

export interface SectionRevisionResponse {
    id: number
    content: Record<string, unknown>
    styles: Record<string, unknown>
    changedBy: number
    changedAt: string
}

