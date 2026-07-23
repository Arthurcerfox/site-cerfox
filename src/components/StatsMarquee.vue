<script setup lang="ts">
import Marquee from "@/components/ui/Marquee.vue"

const stats = [
  { value: "12k+", label: "de cooperados atendidos" },
  { value: "99,9%", label: "de confiabilidade da rede" },
  { value: "40+", label: "anos de história" },
  { value: "24/7", label: "de atendimento" },
  { value: "1.500km", label: "de rede de distribuição" },
  { value: "100%", label: "de energia no campo" },
]
</script>

<template>
  <section class="border-y border-border bg-primary py-15 text-primary-foreground">
    <Marquee duration="38s">
      <div
        v-for="(stat, i) in stats"
        :key="i"
        class="flex items-center"
      >
        <span class="mx-6 h-1.5 w-1.5 rounded-full bg-accent" aria-hidden="true" />
        <span class="font-heading text-3xl font-extrabold tracking-tight sm:text-4xl">
          {{ stat.value }}
        </span>
        <span class="ml-3 text-sm font-mono font-medium text-primary-foreground/60">
          {{ stat.label }}
        </span>
      </div>
    </Marquee>
  </section>
</template>
