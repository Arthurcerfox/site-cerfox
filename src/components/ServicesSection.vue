<script setup lang="ts">
import { Zap, Sun, Wifi } from "@lucide/vue"
import ServiceCard from "./ui/ServiceCard.vue";

import DistrEnergiaFoto from "@/../public/images/teste.jpg"
import DistrEnergiaFoto2 from "@/../public/images/hero-energia.png"
import DistrEnergiaFoto3 from "@/../public/images/sobre-cooperativa.png"
const services = [
  {
    icon: Zap,
    title: "Distribuição de Energia",
    desc: "Fornecimento contínuo e seguro de energia elétrica para propriedades rurais e urbanas da região.",
    image: DistrEnergiaFoto
  },
  {
    icon: Sun,
    title: "Geração de Energia",
    desc: "Investimento em fontes de geração próprias para garantir autonomia e sustentabilidade aos cooperados.",
    image: DistrEnergiaFoto2
  },
  {
    icon: Wifi,
    title: "Telecomunicações",
    desc: "Internet e conectividade de qualidade levando o mundo digital para todos os associados.",
    image: DistrEnergiaFoto3
  }
]
</script>

<template>
  <section id="solucoes" class="mx-auto max-w-7xl scroll-mt-20 px-4 py-10 lg:py-24 sm:px-6">
    <div class="mx-auto max-w-3xl text-left lg:text-center">
      <span class="text-md font-mono font-bold uppercase tracking-wider text-primary">
        Nossas soluções
      </span>
      <h2 class="mt-3 font-heading text-3xl font-extrabold text-balance sm:text-4xl">
        Tudo o que o cooperado precisa em um só lugar
      </h2>
      <p class="mt-4 font-text text-lg leading-relaxed text-muted-foreground">
        Da energia à conectividade, a <strong class="font-extrabold bg-gradient-to-r from-primary to-accent bg-clip-text text-transparent">CERFOX</strong> oferece serviços completos com o cuidado de
        quem faz parte da comunidade.
      </p>
    </div>

    <div class="mt-14 grid gap-8 sm:grid-cols-2 xl:grid-cols-3">
      <ServiceCard
        v-for="service in services"
        :key="service.title"
        :title="service.title"
        :desc="service.desc"
        :image="service.image"
        :icon="service.icon"
      />
    </div>
  </section>
</template>
