<script setup lang="ts">
import { ref, computed } from "vue"
import { Phone, PhoneCall, Mail, MapPin, Send } from "@lucide/vue"
import { Button } from "@/components/ui/button"
import { Input } from "@/components/ui/input"
import { Textarea } from "@/components/ui/textarea"
import { Field, FieldGroup, FieldLabel } from "@/components/ui/field"
import { Select, SelectContent, SelectItem, SelectTrigger, SelectValue } from "@/components/ui/select"

const form = ref({
  nome: "",
  email: "",
  assunto: "",
  estado: "",
  cidade: "",
  mensagem: "",
})
const enviado = ref(false)

const contatos = [
  { icon: Phone, label: "Telefone", value: "(54) 3352-0000" },
  { icon: PhoneCall, label: "Telefone", value: "0800 6484800" },
  { icon: Mail, label: "E-mail", value: "contato@cerfox.com.br" },
  { icon: MapPin, label: "Endereço", value: "Fontoura Xavier, RS" },
]

const assuntos = [
  { value: "duvida", label: "Dúvida geral" },
  { value: "ligacao-nova", label: "Nova ligação de energia" },
  { value: "conta", label: "Segunda via / conta" },
  { value: "falta-energia", label: "Falta de energia" },
  { value: "cooperado", label: "Tornar-se cooperado" },
  { value: "outro", label: "Outro assunto" },
]

const estados = [
  { value: "RS", label: "Rio Grande do Sul" },
  { value: "SC", label: "Santa Catarina" },
  { value: "PR", label: "Paraná" },
  { value: "SP", label: "São Paulo" },
  { value: "outro", label: "Outro estado" },
]

const cidadesPorEstado: Record<string, { value: string; label: string }[]> = {
  RS: [
    { value: "fontoura-xavier", label: "Fontoura Xavier" },
    { value: "soledade", label: "Soledade" },
    { value: "tapera", label: "Tapera" },
    { value: "santo-antonio-do-planalto", label: "Santo Antônio do Planalto" },
    { value: "ibirapuita", label: "Ibirapuitã" },
  ],
}

const cidades = computed(() => cidadesPorEstado[form.value.estado] ?? [])

function onEstadoChange() {
  form.value.cidade = ""
}

function submit() {
  enviado.value = true
}
</script>

<template>
  <section id="contato" class="scroll-mt-20 bg-primary py-10 lg:py-24 text-primary-foreground">
    <div class="mx-auto grid max-w-7xl gap-12 px-4 sm:px-6 lg:grid-cols-2">
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

        <form v-else @submit.prevent="submit">
          <FieldGroup>
            <Field>
              <FieldLabel for="nome">Nome</FieldLabel>
              <Input
                id="nome"
                v-model="form.nome"
                type="text"
                required
                placeholder="Seu nome completo"
              />
            </Field>

            <Field>
              <FieldLabel for="email">E-mail</FieldLabel>
              <Input
                id="email"
                v-model="form.email"
                type="email"
                required
                placeholder="voce@email.com"
              />
            </Field>

            <Field>
              <FieldLabel for="assunto">Assunto</FieldLabel>
              <Select v-model="form.assunto" required>
                <SelectTrigger id="assunto" class="w-full">
                  <SelectValue placeholder="Selecione o assunto" />
                </SelectTrigger>
                <SelectContent>
                  <SelectItem v-for="a in assuntos" :key="a.value" :value="a.value">
                    {{ a.label }}
                  </SelectItem>
                </SelectContent>
              </Select>
            </Field>

            <div class="grid grid-cols-2 gap-4">
              <Field>
                <FieldLabel for="estado">Estado</FieldLabel>
                <Select v-model="form.estado" required @update:model-value="onEstadoChange">
                  <SelectTrigger id="estado" class="w-full">
                    <SelectValue placeholder="UF" />
                  </SelectTrigger>
                  <SelectContent>
                    <SelectItem v-for="e in estados" :key="e.value" :value="e.value">
                      {{ e.label }}
                    </SelectItem>
                  </SelectContent>
                </Select>
              </Field>

              <Field>
                <FieldLabel for="cidade">Cidade</FieldLabel>
                <Select v-model="form.cidade" required :disabled="!form.estado">
                  <SelectTrigger id="cidade" class="w-full">
                    <SelectValue placeholder="Cidade" />
                  </SelectTrigger>
                  <SelectContent>
                    <SelectItem v-for="c in cidades" :key="c.value" :value="c.value">
                      {{ c.label }}
                    </SelectItem>
                  </SelectContent>
                </Select>
              </Field>
            </div>

            <Field>
              <FieldLabel for="mensagem">Mensagem</FieldLabel>
              <Textarea
                id="mensagem"
                v-model="form.mensagem"
                required
                rows="4"
                placeholder="Como podemos ajudar?"
                class="resize-none"
              />
            </Field>

            <Button type="submit" class="w-full" size="lg">
              Enviar mensagem
              <Send class="h-4 w-4" />
            </Button>
          </FieldGroup>
        </form>
      </div>
    </div>
  </section>
</template>