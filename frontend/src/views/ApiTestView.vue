<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { api, type PageSummary, type NavigationItem } from '@/api/client'

const pages = ref<PageSummary[]>([])
const navigation = ref<NavigationItem[]>([])
const error = ref<string | null>(null)

onMounted(async () => {
  try {
    pages.value = await api.getPages()
    navigation.value = await api.getNavigation()
  } catch (e) {
    error.value = e instanceof Error ? e.message : 'Unknown error'
  }
})
</script>

<template>
  <div style="padding: 2rem; font-family: monospace;">
    <h2>API Test</h2>
    <p v-if="error" style="color: red;">{{ error }}</p>

    <h3>Pages ({{ pages.length }})</h3>
    <pre>{{ pages }}</pre>

    <h3>Navigation ({{ navigation.length }} top-level)</h3>
    <pre>{{ navigation }}</pre>
  </div>
</template>