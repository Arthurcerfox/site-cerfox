import { client } from './client'
import type { MediaAssetResponse } from '@/types/media'

export const mediaApi = {
  getAll: () => client.get<MediaAssetResponse[]>('/medias').then((r) => r.data),

  upload: (file: File) => {
    const formData = new FormData()
    formData.append('file', file)
    return client
      .post<MediaAssetResponse>('/medias', formData, {
        headers: { 'Content-Type': 'multipart/form-data' },
      })
      .then((r) => r.data)
  },

  delete: (id: number) =>
    client.delete<void>(`/medias/${id}`).then((r) => r.data),
}