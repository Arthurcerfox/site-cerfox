<script setup lang="ts">
import { Button } from "@/components/ui/button"
import { ArrowRight, PhoneOutgoing, ZapOff } from "@lucide/vue";
</script>

<template>
  <section id="falta-de-energia" class="scroll-mt-20 py-10 lg:py-16">
    <div class="mx-auto max-w-7xl px-4 sm:px-6">
      <div
        class="flex flex-col gap-6 overflow-hidden rounded-2xl bg-accent p-6 text-accent-foreground shadow-lg sm:p-8 lg:flex-row lg:items-center lg:justify-between lg:gap-8"
      >
        <div class="flex items-start gap-4">
          <div>
            <span class="font-mono text-sm font-bold uppercase tracking-wider text-accent-foreground/70">
              Falta de Energia
            </span>
            <h2 class="mt-1 font-heading text-2xl font-extrabold text-balance sm:text-3xl">
              Deseja informar falta de energia?
            </h2>
            <p class="mt-2 max-w-xl font-text text-base leading-relaxed text-accent-foreground/80">
              Informe a falta de energia para verificarmos a sua rede elétrica. Em caso de
              emergência, entre em contato pelo telefone ao lado.
            </p>
          </div>
        </div>

        <div class="flex shrink-0 flex-col gap-3 sm:flex-row lg:flex-col xl:flex-row">
          <Button
            as="a"
            href="tel:08006484800"
            size="lg"
            variant="outline"
            class="whitespace-nowrap border-accent-foreground/30 bg-transparent text-accent-foreground hover:bg-accent-foreground/10 hover:text-accent-foreground"
          >
            <PhoneOutgoing class="h-4 w-4 shrink-0" />
            0800 648 4800
          </Button>

          <Button
            as="a"
            href="#cooperativismo"
            size="lg"
            variant="default"
            class="whitespace-nowrap bg-primary text-primary-foreground shadow-md hover:bg-primary/90"
          >
            Informar falta de energia
            <ArrowRight class="h-4 w-4 shrink-0" />
          </Button>
        </div>
      </div>
    </div>
  </section>
</template>
