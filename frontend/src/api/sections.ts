import { client } from './client'
import { CreateSectionRequest, SectionResponse, UpdateSectionRequest, SectionRevisionResponse } from '@/types/section'

export const sectionsApi = {
  admin: {
    getByPageId: (pageId: number) => client.get<SectionResponse[]>(`/admin/sections/${pageId}`).then((r) => r.data),
    create: (pageId: number, data: CreateSectionRequest) => client.post<SectionResponse>(`/admin/sections/${pageId}`, data).then((r) => r.data),
    update: (id: number, data: UpdateSectionRequest) => client.patch<SectionResponse>(`/admin/sections/${id}`, data).then((r) => r.data),
    delete: (id: number) => client.delete<void>(`/admin/sections/${id}`).then((r) => r.data),
    getRevisions: (id: number) => client.get<SectionRevisionResponse[]>(`/admin/sections/${id}/revisions`).then((r) => r.data),
  },
}