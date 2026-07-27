<script setup lang="ts">
import CerfoxLogo from "/images/logo-cerfox-light.png?url"

import { Icon } from "@iconify/vue"

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

const socialLinks = [
  {
    name: "Instagram",
    href: "https://www.instagram.com/cerfoxoficial",
    icon: "simple-icons:instagram",
  },
  {
    name: "Facebook",
    href: "https://www.facebook.com/cerfox",
    icon: "simple-icons:facebook",
  },
  {
    name: "LinkedIn",
    href: "https://www.linkedin.com/company/cerfox",
    icon: "simple-icons:linkedin",
  },
]

const year = new Date().getFullYear()
</script>

<template>
  <footer class="border-t border-border bg-card">
    <div class="mx-auto max-w-7xl px-4 py-5 lg:py-20 sm:px-6">
      <div class="grid gap-10 md:grid-cols-2 lg:grid-cols-4">
        <div>
          <img :src="CerfoxLogo" alt="Logo CERFOX" class="h-40 w-auto" />
        </div>

        <div v-for="col in cols" :key="col.title">
          <h3 class="font-heading text-sm font-bold text-card-foreground">{{ col.title }}</h3>
          <ul class="mt-4 space-y-2.5">
            <li v-for="link in col.links" :key="link">
              <a
                href="#"
                class="text-sm text-muted-foreground hover:text-primary"
              >
                {{ link }}
              </a>
            </li>
          </ul>
        </div>
      </div>

      <div class="mt-12 text-center border-t border-border pt-6">
        <p class="text-sm text-muted-foreground">
          &copy; {{ year }} CERFOX. Todos os direitos reservados.
        </p>
      </div>
    </div>
  </footer>
</template>
