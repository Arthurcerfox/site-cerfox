<script setup lang="ts">
import Marquee from "@/components/ui/Marquee.vue"

const stats = [
  { value: "30+", label: "municípios" },
  { value: "16.000+", label: "de unidades consumidoras" },
  { value: "24h", label: "de atendimento" },
  { value: "4.000km+", label: "de rede" },
  { value: "4.000+", label: "de transformadores" },
]
</script>

<template>
  <section class="bg-background py-5 lg:py-10">
       <Marquee duration="28s">
      <div
        v-for="(stat, i) in stats"
        :key="i"
        class="flex items-center"
      >
        <span class="mx-6 h-3 w-3 rounded-full bg-accent" aria-hidden="true" />
        <span class="font-heading text-4xl font-extrabold tracking-tight text-primary sm:text-5xl">
          {{ stat.value }}
        </span>
        <span class="ml-3 text-md font-medium text-background-foreground">
          {{ stat.label }}
        </span>
      </div>
    </Marquee>
  </section>
</template>
