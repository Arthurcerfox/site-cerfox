<script setup lang="ts">
import ServiceCard from "@/components/ui/ServiceCard.vue";

import DistrEnergiaFoto from "@/../public/images/teste.jpg"
import DistrEnergiaFoto2 from "@/../public/images/hero-energia.png"
import DistrEnergiaFoto3 from "@/../public/images/sobre-cooperativa.png"
const noticias = [
  {
    title: "Relatório de Transparência e Igualdade Salarial de Mulheres ...",
    desc: "A Cerfox está divulgando o relatório de transparência e igualdade salarial de mulheres e homens",
    image: DistrEnergiaFoto
  },
  {
    title: "Sorteio Assistência Familiar Setembro",
    desc: "GANHADORES DE SETEMBRO! A CERFOX divulga os contemplados da Promoção Assistência Familia...",
    image: DistrEnergiaFoto2
  },
  {
    title: "Outubro terá bandeira vermelha patamar 1",
    desc: "Outubro terá bandeira vermelha patamar 1 A ANEEL anunciou que haverá acréscimo de R$ 4,46 a c...",
    image: DistrEnergiaFoto3
  }
]
</script>

<template>
  <section id="blog" class="mx-auto max-w-7xl scroll-mt-20 px-4 py-10 lg:py-24 sm:px-6">
    <div class="mx-auto max-w-3xl text-left lg:text-center">
      <span class="text-md font-mono font-bold uppercase tracking-wider text-primary">
        Nosso Blog
      </span>
      <h2 class="mt-3 font-heading text-3xl font-extrabold text-balance sm:text-4xl">
        Confira as últimas notícias
      </h2>
      <p class="mt-4 font-text text-lg leading-relaxed text-muted-foreground">
        Informações relevantes, avisos, eventos e projetos que fortalecem nossa cooperativa e mantêm você sempre bem informado.
      </p>
    </div>

    <div class="mt-14 grid gap-8 sm:grid-cols-2 xl:grid-cols-3">
      <ServiceCard
        v-for="noticia in noticias"
        :key="noticia.title"
        :title="noticia.title"
        :desc="noticia.desc"
        :image="noticia.image"
      />
    </div>
  </section>
</template>
