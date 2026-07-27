<script setup lang="ts">
import { Button } from "@/components/ui/button"
import { ArrowRight } from "@lucide/vue";

</script>

<template>
  <section id="falta-de-energia" class="scroll-mt-20 py-10 lg:py-24">
    <div class="mx-auto grid max-w-7xl items-center gap-12 px-4 sm:px-6 lg:grid-cols-2">
      <div>
        <span class="text-md font-mono font-bold uppercase tracking-wider text-primary">
          Falta de Energia
        </span>
        <h2 class="mt-4 font-heading text-3xl font-extrabold text-balance sm:text-4xl">
          Deseja informar falta de energia?
        </h2>
        <p class="mt-3 font-text text-lg leading-relaxed text-muted-foreground">
            Registre aqui para que possamos verificar a sua rede elétrica. Em caso de emergência, entre em contato pelo telefone: <strong>0800 6484800</strong>.
        </p>

        <Button as="a" href="#cooperativismo" size="lg" class="mt-4 w-full lg:w-auto" variant="accent">
            Clique aqui
            <ArrowRight class="h-4 w-4" />
        </Button>
      </div>
      <div>
        <img
          src="/images/sobre-cooperativa.png"
          alt="Técnico da CERFOX trabalhando em infraestrutura de energia"
          class="aspect-4/3 w-full rounded-2xl object-cover shadow-lg"
        />
      </div>
    </div>
  </section>
</template>
