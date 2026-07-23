<script setup lang="ts">
import { ArrowRight, Zap, MessageCircleMore } from "@lucide/vue"
import { Button } from "@/components/ui/button"
</script>

<template>
  <section class="relative overflow-hidden bg-primary text-primary-foreground">
    <img
      src="/images/hero-energia.png"
      alt=""
      class="absolute inset-0 h-full w-full object-cover opacity-25"
      aria-hidden="true"
    />
    <div class="absolute inset-0 bg-gradient-to-br from-primary via-primary/90 to-accent/60" />

    <div class="relative mx-auto max-w-6xl px-4 py-26 sm:px-6">
      <div class="max-w-2xl">
        <span
          class="inline-flex font-mono items-center gap-2 rounded-full border border-primary-foreground/20 bg-primary-foreground/10 px-4 py-1.5 text-sm font-medium"
        >
          <Zap class="h-4 w-4 text-accent" />
          Energia que transforma comunidades
        </span>

        <h1
          class="mt-6 font-heading text-4xl font-extrabold leading-tight text-balance sm:text-5xl md:text-7xl"
        >
          Facilitando o acesso à energia para nossos cooperados
        </h1>

        <p class="mt-6 max-w-xl font-text text-lg leading-relaxed text-primary-foreground/80">
          A CERFOX é a Cooperativa de Distribuição de Energia de Fontoura Xavier, comprometida
          em melhorar a qualidade de vida no campo e na cidade com geração, distribuição e
          telecomunicações.
        </p>

        <div class="mt-9 flex flex-col gap-3 sm:flex-row">
          <Button as="a" class="font-text" href="#solucoes" variant="accent" size="lg">
            Conheça nossas soluções
            <ArrowRight class="h-4 w-4" />
          </Button>

          <Button
            as="a" href="#contato"
            size="lg"
            variant="outline"
            class="font-text border-primary-foreground/40 text-primary-foreground hover:bg-primary-foreground/10 hover:text-primary-foreground"
          >
            Entre em contato
            <MessageCircleMore class="h-4 w-4" />
          </Button>
        </div>
      </div>
    </div>
  </section>
</template>
