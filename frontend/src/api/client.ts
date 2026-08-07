import axios, { type AxiosError } from 'axios'
import { type StandardError } from '@/types/error'

export class ApiError extends Error {
  constructor(public status: number, public code: string, message: string) {
    super(message)
    this.name = 'ApiError'
  }
}
 
export const client = axios.create({
  baseURL: '/api/v1',
  headers: {
    'Content-Type': 'application/json',
  },
})

client.interceptors.request.use((config) => {
  const token = localStorage.getItem('authToken')
  if (token) {
    config.headers.Authorization = `Bearer ${token}`
  }
  return config
})

client.interceptors.response.use(
  (response) => response,
  (error: AxiosError<StandardError>) => {
    const data = error.response?.data
    return Promise.reject(
      new ApiError(
        data?.status ?? error.response?.status ?? 0,
        data?.error ?? 'UNKNOWN_ERROR',
        data?.message ?? error.message ?? 'Unexpected error'
      )
    )
  }
)