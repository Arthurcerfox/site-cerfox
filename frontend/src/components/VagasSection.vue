<script setup lang="ts">
import { MapPin, Building2, Clock, ArrowRight, Send } from "@lucide/vue"
import {
  Accordion,
  AccordionContent,
  AccordionItem,
  AccordionTrigger,
} from "@/components/ui/accordion"
import { Button } from "@/components/ui/button"

type Vaga = {
  id: string
  titulo: string
  area: string
  local: string
  tipo: string
  descricao: string
  requisitos: string[]
}

const vagas: Vaga[] = [
  {
    id: "eletricista-rede",
    titulo: "Eletricista de Rede",
    area: "Operações",
    local: "Fontoura Xavier, RS",
    tipo: "Presencial · CLT",
    descricao:
      "Atuação na manutenção e expansão da rede de distribuição de energia, garantindo o fornecimento contínuo e seguro aos cooperados da região.",
    requisitos: [
      "Curso técnico em Eletrotécnica ou Eletricidade",
      "CNH categoria B",
      "Disponibilidade para trabalho em campo e plantões",
      "Experiência com redes de distribuição é um diferencial",
    ],
  },
  {
    id: "analista-telecom",
    titulo: "Analista de Telecomunicações",
    area: "Tecnologia",
    local: "Soledade, RS",
    tipo: "Híbrido · CLT",
    descricao:
      "Responsável pela configuração, monitoramento e suporte da infraestrutura de internet e conectividade oferecida aos associados.",
    requisitos: [
      "Formação em Redes, TI ou áreas correlatas",
      "Conhecimento em redes ópticas (GPON/FTTH)",
      "Experiência com equipamentos de rede e roteamento",
      "Boa comunicação para atendimento técnico",
    ],
  },
  {
    id: "assistente-administrativo",
    titulo: "Assistente Administrativo",
    area: "Administrativo",
    local: "Fontoura Xavier, RS",
    tipo: "Presencial · CLT",
    descricao:
      "Apoio às rotinas administrativas e ao atendimento dos cooperados, contribuindo para a organização e eficiência dos processos internos.",
    requisitos: [
      "Ensino médio completo (superior em andamento é um diferencial)",
      "Domínio do pacote Office",
      "Organização e atenção aos detalhes",
      "Experiência com atendimento ao público",
    ],
  },
  {
    id: "estagio-engenharia",
    titulo: "Estágio em Engenharia Elétrica",
    area: "Engenharia",
    local: "Fontoura Xavier, RS",
    tipo: "Presencial · Estágio",
    descricao:
      "Oportunidade para estudantes acompanharem projetos de geração e distribuição de energia, com acompanhamento de profissionais experientes.",
    requisitos: [
      "Cursando Engenharia Elétrica (a partir do 5º semestre)",
      "Interesse pelo setor de energia e cooperativismo",
      "Disponibilidade de 6 horas diárias",
      "Proatividade e vontade de aprender",
    ],
  },
]
</script>

<template>
  <section id="vagas" class="mx-auto max-w-7xl scroll-mt-20 px-4 py-10 lg:py-24 sm:px-6">
    <div class="mx-auto max-w-3xl text-left lg:text-center">
      <span class="text-md font-mono font-bold uppercase tracking-wider text-primary">
        Trabalhe Conosco
      </span>
      <h2 class="mt-3 font-heading text-3xl font-extrabold text-balance sm:text-4xl">
        Confira nossas vagas de emprego
      </h2>
      <p class="mt-4 font-text text-lg leading-relaxed text-muted-foreground">
        Acreditamos que pessoas fazem a diferença. Venha construir o futuro da energia e da
        conectividade com a nossa equipe.
      </p>
    </div>

    <div class="mx-auto mt-14 max-w-4xl">
      <Accordion type="single" collapsible class="w-full overflow-hidden rounded-2xl border border-border">
        <AccordionItem
          v-for="vaga in vagas"
          :key="vaga.id"
          :value="vaga.id"
          class="border-b border-border px-5 last:border-b-0 sm:px-6"
        >
          <AccordionTrigger class="gap-4 py-5 hover:no-underline [&[data-state=open]>svg]:text-primary">
            <div class="flex flex-1 flex-col gap-3 text-left sm:flex-row sm:items-center sm:justify-between sm:gap-6">
              <span class="font-heading text-lg font-bold text-foreground">
                {{ vaga.titulo }}
              </span>

              <div class="flex flex-wrap items-center gap-2">
                <span class="inline-flex items-center gap-1.5 rounded-full bg-primary/10 px-3 py-1 text-xs font-semibold text-primary">
                  <Building2 class="h-3.5 w-3.5" />
                  {{ vaga.area }}
                </span>
                <span class="inline-flex items-center gap-1.5 rounded-full bg-secondary/10 px-3 py-1 text-xs font-semibold text-secondary">
                  <MapPin class="h-3.5 w-3.5" />
                  {{ vaga.local }}
                </span>
                <span class="inline-flex items-center gap-1.5 rounded-full bg-muted px-3 py-1 text-xs font-semibold text-muted-foreground">
                  <Clock class="h-3.5 w-3.5" />
                  {{ vaga.tipo }}
                </span>
              </div>
            </div>
          </AccordionTrigger>

          <AccordionContent class="pb-6">
            <p class="font-text leading-relaxed text-muted-foreground">
              {{ vaga.descricao }}
            </p>

            <h4 class="mt-6 font-heading text-sm font-bold uppercase tracking-wider text-foreground">
              O que buscamos
            </h4>
            <ul class="mt-3 space-y-2">
              <li
                v-for="req in vaga.requisitos"
                :key="req"
                class="flex items-start gap-2 font-text text-sm text-muted-foreground"
              >
                <span class="mt-2 h-1.5 w-1.5 shrink-0 rounded-full bg-accent" />
                {{ req }}
              </li>
            </ul>

            <Button class="mt-6 w-full sm:w-auto">
              Candidatar-se
              <ArrowRight class="h-4 w-4" />
            </Button>
          </AccordionContent>
        </AccordionItem>
      </Accordion>

      <div class="mt-8 flex flex-col items-start justify-between gap-5 rounded-2xl bg-primary p-6 text-primary-foreground sm:flex-row sm:items-center sm:p-8">
        <div>
          <h3 class="font-heading text-xl font-bold">Não encontrou uma vaga ideal?</h3>
          <p class="mt-1 font-text text-primary-foreground/70">
            Confira todas as vagas disponíveis
          </p>
        </div>
        <Button variant="accent" size="lg" class="w-full shrink-0 sm:w-auto">
          Ver mais vagas
          <Send class="h-4 w-4" />
        </Button>
      </div>
    </div>
  </section>
</template>
