import { client } from '@/api/client'
import { CreateNavigationRequest, NavigationItemResponse, UpdateNavigationRequest } from '@/types/navigation'

export const navigationApi = {
    getAll: () => client.get<NavigationItemResponse[]>('/public/navigation-items').then(response => response.data),
    
    create: (data: CreateNavigationRequest) => client.post('/admin/navigation-items', data).then(response => response.data),
    update: (id: number, data: UpdateNavigationRequest) => client.patch(`/admin/navigation-items/${id}`, data).then(response => response.data),
    delete: (id: number) => client.delete(`/admin/navigation-items/${id}`).then(response => response.data),
}