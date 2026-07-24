<script setup lang="ts">
import { Check } from "@lucide/vue"
import { Button } from "@/components/ui/button"

const points = [
  "Gestão democrática e transparente com os cooperados",
  "Compromisso com o desenvolvimento regional",
  "Investimento contínuo em infraestrutura",
  "Energia acessível para o campo e a cidade",
]
</script>

<template>
  <section id="sobre" class="scroll-mt-20 bg-background py-18">
    <div class="mx-auto grid max-w-6xl items-center gap-12 px-4 sm:px-6 lg:grid-cols-2">
      <div class="relative">
        <img
          src="/images/sobre-cooperativa.png"
          alt="Técnico da CERFOX trabalhando em infraestrutura de energia"
          class="aspect-4/3 w-full rounded-2xl object-cover shadow-lg"
        />
        <div
          class="absolute -bottom-6 -right-4 hidden rounded-2xl bg-accent px-6 py-4 text-accent-foreground shadow-lg sm:block"
        >
          <p class="font-heading text-3xl font-extrabold">60+</p>
          <p class="text-sm font-semibold">anos de experiência</p>
        </div>
      </div>

      <div>
        <span class="text-md font-mono font-bold uppercase tracking-wider text-primary">
          Sobre a CERFOX
        </span>
        <h2 class="mt-3 font-heading text-3xl font-extrabold text-balance sm:text-4xl">
          Uma cooperativa que cresce com sua comunidade
        </h2>
        <p class="mt-4 font-text text-lg leading-relaxed text-muted-foreground">
          A CERFOX nasceu para levar energia
          onde ela é essencial. Mais do que distribuir energia, acreditamos em pessoas e no
          poder da união para transformar a realidade de cada cooperado.
        </p>

        <ul class="mt-8 space-y-3">
          <li v-for="point in points" :key="point" class="flex items-start gap-3">
            <span
              class="mt-0.5 flex h-5 w-5 shrink-0 items-center justify-center rounded-full bg-primary text-primary-foreground"
            >
              <Check class="h-3 w-3" />
            </span>
            <span class="font-text text-foreground">{{ point }}</span>
          </li>
        </ul>

        <Button as="a" href="#cooperativismo" size="lg" class="font-text mt-9">Leia mais</Button>
      </div>
    </div>
  </section>
</template>
