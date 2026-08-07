import { client } from '@/api/client'
import { CreatePageRequest, UpdatePageRequest, type PageSummaryResponse } from '@/types/page'
import { type PageDetailResponse } from '@/types/page'

export const pagesApi = {
  public: {
    getAll: () => client.get<PageSummaryResponse[]>('/public/pages').then((r) => r.data),
    getBySlug: (slug: string) => client.get<PageDetailResponse>(`/public/pages/${slug}`).then((r) => r.data),
  },
  admin: {
    create: (data: CreatePageRequest) => client.post<PageDetailResponse>('/admin/pages', data).then((r) => r.data),
    update: (id: number, data: UpdatePageRequest) => client.patch<PageDetailResponse>(`/admin/pages/${id}`, data).then((r) => r.data),
    setAsLanding: (id: number) => client.patch<PageDetailResponse>(`/admin/pages/${id}/landing`).then((r) => r.data),
    delete: (id: number) => client.delete<void>(`/admin/pages/${id}`).then((r) => r.data),
    activate: (id: number) => client.patch(`/admin/pages/${id}/activate`).then(response => response.data),
    deactivate: (id: number) => client.patch(`/admin/pages/${id}/deactivate`).then(response => response.data),
  },
}



