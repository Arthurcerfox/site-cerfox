<script setup lang="ts">
import { ref } from "vue"
import { Phone, Mail, MapPin, Send } from "@lucide/vue"
import { Button } from "@/components/ui/button"

const form = ref({ nome: "", email: "", mensagem: "" })
const enviado = ref(false)

const contatos = [
  { icon: Phone, label: "Telefone", value: "(54) 3352-0000" },
  { icon: Mail, label: "E-mail", value: "contato@cerfox.com.br" },
  { icon: MapPin, label: "Endereço", value: "Fontoura Xavier, RS" },
]

function submit() {
  enviado.value = true
}
</script>

<template>
  <section id="contato" class="scroll-mt-20 bg-primary py-18 text-primary-foreground">
    <div class="mx-auto grid max-w-6xl gap-12 px-4 sm:px-6 lg:grid-cols-2">
      <div>
        <span class="text-md font-mono font-bold uppercase tracking-wider text-accent">
          Fale conosco
        </span>
        <h2 class="mt-3 font-heading text-3xl font-extrabold text-balance sm:text-4xl">
          Estamos prontos para atender você
        </h2>
        <p class="mt-4 font-text text-lg leading-relaxed text-primary-foreground/80">
          Tire suas dúvidas, solicite serviços ou saiba como se tornar um cooperado. Nossa
          equipe está à disposição.
        </p>

        <ul class="mt-10 space-y-6">
          <li v-for="c in contatos" :key="c.label" class="flex items-center gap-4">
            <span
              class="flex h-11 w-11 items-center justify-center rounded-xl bg-primary-foreground/10 text-accent"
            >
              <component :is="c.icon" class="h-5 w-5" />
            </span>
            <div>
              <p class="text-sm font-text text-primary-foreground/60">{{ c.label }}</p>
              <p class="font-text font-semibold">{{ c.value }}</p>
            </div>
          </li>
        </ul>
      </div>

      <div class="rounded-2xl bg-card p-8 text-card-foreground shadow-xl">
        <div v-if="enviado" class="flex h-full flex-col items-center justify-center py-10 text-center">
          <div
            class="flex h-14 w-14 items-center justify-center rounded-full bg-secondary text-secondary-foreground"
          >
            <Send class="h-6 w-6" />
          </div>
          <h3 class="mt-4 font-heading text-xl font-bold">Mensagem enviada!</h3>
          <p class="mt-2 font-text text-muted-foreground">Em breve entraremos em contato com você.</p>
        </div>

        <form v-else class="space-y-5" @submit.prevent="submit">
          <div>
            <label for="nome" class="text-sm font-text font-medium">Nome</label>
            <input
              id="nome"
              v-model="form.nome"
              type="text"
              required
              placeholder="Seu nome completo"
              class="mt-1.5 w-full rounded-lg border border-input bg-background px-4 py-2.5 text-foreground outline-none focus:border-ring focus:ring-2 focus:ring-ring/30"
            />
          </div>
          <div>
            <label for="email" class="text-sm font-medium">E-mail</label>
            <input
              id="email"
              v-model="form.email"
              type="email"
              required
              placeholder="voce@email.com"
              class="mt-1.5 w-full rounded-lg border border-input bg-background px-4 py-2.5 text-foreground outline-none focus:border-ring focus:ring-2 focus:ring-ring/30"
            />
          </div>
          <div>
            <label for="mensagem" class="text-sm font-medium">Mensagem</label>
            <textarea
              id="mensagem"
              v-model="form.mensagem"
              required
              rows="4"
              placeholder="Como podemos ajudar?"
              class="mt-1.5 w-full resize-none rounded-lg border border-input bg-background px-4 py-2.5 text-foreground outline-none focus:border-ring focus:ring-2 focus:ring-ring/30"
            />
          </div>
          <Button type="submit" class="w-full" size="lg">
            Enviar mensagem
            <Send class="h-4 w-4" />
          </Button>
        </form>
      </div>
    </div>
  </section>
</template>
