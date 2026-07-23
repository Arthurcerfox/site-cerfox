<script setup lang="ts">
import CerfoxLogoLight from "/images/logo-cerfox-light.png?url"
import CerfoxLogoDark from "/images/logo-cerfox-dark.png?url"

const cols = [
  {
    title: "Cooperativa",
    links: ["Sobre a CERFOX", "Cooperativismo", "Trabalhe conosco", "Transparência"],
  },
  {
    title: "Serviços",
    links: ["Distribuição", "Geração", "Telecomunicações", "Agência Virtual"],
  },
  {
    title: "Atendimento",
    links: ["Fale conosco", "Falta de energia", "Segunda via", "Ouvidoria"],
  },
]

const year = new Date().getFullYear()
</script>

<template>
  <footer class="border-t border-border bg-card">
    <div class="mx-auto max-w-6xl px-4 py-14 sm:px-6">
      <div class="grid gap-10 md:grid-cols-2 lg:grid-cols-4">
        <div>
          <img :src="CerfoxLogoLight" alt="Logo CERFOX" class="h-40 w-auto dark:hidden" />
          <img :src="CerfoxLogoDark" alt="Logo CERFOX" class="h-40 w-auto hidden dark:block" />
        </div>

        <div v-for="col in cols" :key="col.title">
          <h3 class="font-heading text-sm font-bold text-card-foreground">{{ col.title }}</h3>
          <ul class="mt-4 space-y-2.5">
            <li v-for="link in col.links" :key="link">
              <a
                href="#"
                class="text-sm text-muted-foreground transition-colors hover:text-secondary dark:hover:text-accent"
              >
                {{ link }}
              </a>
            </li>
          </ul>
        </div>
      </div>

      <div
        class="mt-12 flex flex-col items-center justify-between gap-4 border-t border-border pt-6 sm:flex-row"
      >
        <p class="text-sm text-muted-foreground">
          &copy; {{ year }} CERFOX. Todos os direitos reservados.
        </p>
        <p class="text-sm text-muted-foreground">Fontoura Xavier, Rio Grande do Sul</p>
      </div>
    </div>
  </footer>
</template>
