<script setup lang="ts">
import type { LucideIcon } from "@lucide/vue"

import { Card, CardDescription, CardHeader, CardTitle, CardFooter } from "@/components/ui/card"
import { Button } from "./button"

defineProps<{
  title: string
  desc: string
  image: string
  icon: LucideIcon
}>()
</script>

<template>
  <Card class="flex h-full flex-col overflow-hidden pt-0 transition-shadow hover:shadow-md">
    <div class="relative">
      <img
        :src="image"
        :alt="title"
        class="aspect-video w-full object-cover"
      />

      <div
        class="absolute bottom-4 left-4 flex h-11 w-11 items-center justify-center rounded-lg bg-primary text-primary-foreground shadow-sm"
      >
        <component :is="icon" class="h-5 w-5" />
      </div>
    </div>

    <CardHeader class="flex-1 gap-2">
      <CardTitle class="text-lg">{{ title }}</CardTitle>
      <CardDescription class="text-md">
        {{ desc }}
      </CardDescription>
    </CardHeader>

    <CardFooter class="mt-auto">
      <Button class="w-full">
        Saiba mais
      </Button>
    </CardFooter>
  </Card>
</template>