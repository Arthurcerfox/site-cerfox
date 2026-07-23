<script setup lang="ts">
import { Users, Handshake, Leaf } from "@lucide/vue"

const values = [
  {
    icon: Users,
    title: "Pessoas em primeiro lugar",
    desc: "Cada cooperado é dono e participa das decisões que constroem o futuro da cooperativa.",
  },
  {
    icon: Handshake,
    title: "Cooperação",
    desc: "Trabalhamos juntos para alcançar resultados que beneficiam toda a comunidade.",
  },
  {
    icon: Leaf,
    title: "Sustentabilidade",
    desc: "Compromisso com práticas responsáveis e com o desenvolvimento sustentável da região.",
  },
]
</script>

<template>
  <section id="cooperativismo" class="mx-auto max-w-6xl scroll-mt-20 px-4 py-24 sm:px-6">
    <div class="mx-auto max-w-2xl text-center">
      <span class="text-md font-mono font-bold uppercase tracking-wider text-secondary dark:text-accent">
        Cooperativismo
      </span>
      <h2 class="mt-3 font-heading text-3xl font-extrabold text-balance sm:text-4xl">
        Os valores que movem a CERFOX
      </h2>
      <p class="mt-4 font-text text-lg leading-relaxed text-muted-foreground">
        Ser cooperado é fazer parte de algo maior. Conheça os princípios que guiam cada
        decisão da nossa cooperativa.
      </p>
    </div>

    <div class="mt-14 grid gap-6 md:grid-cols-3">
      <article
        v-for="value in values"
        :key="value.title"
        class="rounded-2xl border border-border bg-card p-8 text-center"
      >
        <div
          class="mx-auto flex h-14 w-14 items-center justify-center rounded-2xl bg-primary text-primary-foreground"
        >
          <component :is="value.icon" class="h-7 w-7" />
        </div>
        <h3 class="mt-5 font-heading text-lg font-bold text-card-foreground">
          {{ value.title }}
        </h3>
        <p class="mt-2 font-text text-sm leading-relaxed text-muted-foreground">{{ value.desc }}</p>
      </article>
    </div>
  </section>
</template>
