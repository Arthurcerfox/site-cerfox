<script setup lang="ts">
import { Check, ArrowRight } from "@lucide/vue"
import { Button } from "@/components/ui/button"

const points = [
  "Gestão democrática e transparente com os cooperados",
  "Compromisso com o desenvolvimento regional",
  "Investimento contínuo em infraestrutura",
  "Energia acessível para o campo e a cidade",
]
</script>

<template>
  <section id="sobre" class="scroll-mt-20 bg-background py-10 lg:py-24">
    <div class="mx-auto grid max-w-7xl items-center gap-12 px-4 sm:px-6 lg:grid-cols-2">
      <div class="relative">
        <img
          src="/public/images/hero-energia.png"
          alt="Técnico da CERFOX trabalhando em infraestrutura de energia"
          class="aspect-4/3 w-full rounded-2xl object-cover shadow-lg"
        />
        <div class="absolute -bottom-4 -right-2 rounded-2xl bg-accent px-4 py-3 text-accent-foreground shadow-lg sm:-bottom-6 sm:-right-4 sm:px-6 sm:py-4">
          <p class="font-heading text-2xl font-extrabold sm:text-3xl">60+</p>
          <p class="text-xs font-semibold sm:text-sm">anos de experiência</p>
        </div>
      </div>

      <div>
        <span class="text-md flex font-mono font-bold uppercase tracking-wider text-primary">
          Sobre a CERFOX
        </span>
        <h2 class="mt-4 font-heading text-3xl font-extrabold text-balance sm:text-4xl">
          Facilitamos o acesso à energia, melhorando a qualidade de vida dos cooperados
        </h2>
        <p class="mt-3 font-text text-lg leading-relaxed text-muted-foreground">
          A <strong class="font-extrabold bg-gradient-to-r from-primary to-accent bg-clip-text text-transparent">CERFOX</strong>
          foi fundada em 9 de julho de 1962, na cidade de Soledade, por um grupo de 16 pessoas,
          com o objetivo social de promover o desenvolvimento regional, 
          facilitando o acesso à energia, à saúde e à disponibilização de produtos, 
          serviços e bens de consumo de necessidade básica, visando à melhoria da qualidade de vida dos cooperados,
          dos colaboradores e da comunidade.</p>
        <ul class="mt-3 space-y-3">
          <li v-for="point in points" :key="point" class="flex items-start gap-3">
            <span
              class="mt-0.5 flex h-5 w-5 shrink-0 items-center justify-center rounded-full bg-primary text-primary-foreground"
            >
              <Check class="h-3 w-3" />
            </span>
            <span class="font-text text-foreground">{{ point }}</span>
          </li>
        </ul>

        <Button as="a" href="#cooperativismo" size="lg" class="mt-4 w-full lg:w-auto" variant="default">
          Leia mais
          <ArrowRight class="h-4 w-4" />
        </Button>
      </div>
    </div>
  </section>
</template>
