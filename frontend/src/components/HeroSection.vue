<script setup lang="ts">
import { ArrowRight, MessageCircleMore } from "@lucide/vue"
import { Button } from "@/components/ui/button"
</script>

<template>
  <section class="relative min-h-[calc(100dvh-var(--header-height))] overflow-hidden bg-primary text-primary-foreground">
    <img
      src="/images/hero-energia.png"
      alt=""
      class="absolute inset-0 h-full w-full object-cover opacity-100"
      aria-hidden="true"
    />

    <div class="absolute inset-0 bg-gradient-to-br from-primary via-primary/100 to-accent/70" />

    <div class="relative mx-auto grid min-h-[calc(100dvh-var(--header-height))] max-w-7xl items-center gap-8 px-4 sm:px-6 lg:grid-cols-2">
      <div class="flex flex-col">
        <div class="max-w-xl text-left">
          <h1 class="font-heading text-4xl font-extrabold leading-tight text-balance sm:text-5xl lg:text-6xl">
            Facilitando o acesso à energia para nossos cooperados
          </h1>

          <p class="mt-6 font-text text-lg leading-relaxed text-primary-foreground/80">
            A CERFOX é a Cooperativa de Distribuição de Energia de Fontoura Xavier,
            comprometida em melhorar a qualidade de vida no campo e na cidade com
            geração, distribuição e telecomunicações.
          </p>

          <div class="mt-6 flex flex-col gap-3 sm:flex-row">
            <Button
              as="a"
              href="#solucoes"
              variant="accent"
              size="lg"
            >
              Conheça nossas soluções
              <ArrowRight class="h-4 w-4" />
            </Button>

            <Button
              as="a"
              href="#contato"
              variant="outline"
              size="lg"
              class="border-primary-foreground/40 font-text text-primary-foreground hover:bg-primary-foreground/10 hover:text-primary-foreground"
            >
              Entre em contato
              <MessageCircleMore class="h-4 w-4" />
            </Button>
          </div>
        </div>
      </div>

      <div class="hidden h-full items-center justify-center lg:flex">
      </div>
    </div>
  </section>
</template>