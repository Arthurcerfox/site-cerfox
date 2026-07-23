<script setup lang="ts">
import { Sun, Moon } from '@lucide/vue'
import { useDark, useToggle } from '@vueuse/core'
import { Button } from '@/components/ui/button'

const isDark = useDark()
const toggleDark = useToggle(isDark)
</script>

<template>
  <Button
    variant="outline"
    size="icon"
    class="relative rounded-full"
    aria-label="Toggle dark mode"
    @click="toggleDark()"
  >
    <Sun
      class="h-5 w-5 scale-100 rotate-0 transition-all duration-300 dark:scale-0 dark:-rotate-90"
    />
    <Moon
      class="absolute h-5 w-5 scale-0 rotate-90 transition-all duration-300 dark:scale-100 dark:rotate-0"
    />
  </Button>
</template>