<script setup lang="ts">
import { Zap, Sun, Wifi, ShieldCheck } from "@lucide/vue"

const services = [
  {
    icon: Zap,
    title: "Distribuição de Energia",
    desc: "Fornecimento contínuo e seguro de energia elétrica para propriedades rurais e urbanas da região.",
  },
  {
    icon: Sun,
    title: "Geração de Energia",
    desc: "Investimento em fontes de geração próprias para garantir autonomia e sustentabilidade aos cooperados.",
  },
  {
    icon: Wifi,
    title: "Telecomunicações",
    desc: "Internet e conectividade de qualidade levando o mundo digital para todos os associados.",
  },
  {
    icon: ShieldCheck,
    title: "Atendimento ao Cooperado",
    desc: "Equipe de plantão e agência virtual para resolver ocorrências e demandas com agilidade.",
  },
]
</script>

<template>
  <section id="solucoes" class="mx-auto max-w-6xl scroll-mt-20 px-4 py-15 sm:px-6">
    <div class="max-w-2xl">
      <span class="text-md font-mono font-bold uppercase tracking-wider text-secondary">
        Nossas soluções
      </span>
      <h2 class="mt-3 font-heading text-3xl font-extrabold text-balance sm:text-4xl">
        Tudo o que o cooperado precisa em um só lugar
      </h2>
      <p class="mt-4 font-text text-lg leading-relaxed text-muted-foreground">
        Da energia à conectividade, a CERFOX oferece serviços completos com o cuidado de
        quem faz parte da comunidade.
      </p>
    </div>

    <div class="mt-14 grid gap-6 sm:grid-cols-2 lg:grid-cols-4">
      <article
        v-for="service in services"
        :key="service.title"
        class="group rounded-2xl border border-border bg-card p-6 transition-colors hover:border-secondary"
      >
        <div
          class="flex h-12 w-12 items-center justify-center rounded-xl bg-muted text-primary transition-colors group-hover:bg-secondary group-hover:text-secondary-foreground"
        >
          <component :is="service.icon" class="h-6 w-6" />
        </div>
        <h3 class="mt-5 font-heading text-lg font-bold text-card-foreground">
          {{ service.title }}
        </h3>
        <p class="mt-2 font-text text-sm leading-relaxed text-muted-foreground">
          {{ service.desc }}
        </p>
      </article>
    </div>
  </section>
</template>
