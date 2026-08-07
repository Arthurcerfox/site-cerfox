import { client } from '@/api/client'
import { LoginRequest, LoginResponse } from '@/types/auth'

export const authApi = {
    login: async (data: LoginRequest) => client.post<LoginResponse>('/auth/login', data).then(response => response.data),
    logout: async () => client.post('/auth/logout').then(response => response.data),
}