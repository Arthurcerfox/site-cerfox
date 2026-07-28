<script setup lang="ts">
import CerfoxLogo from "/images/logo-cerfox-footer.png?url"

import { Icon } from "@iconify/vue"
import { MapPin, Mail, Phone, PhoneCall } from "@lucide/vue"

const cols = [
  {
    title: "Soluções",
    links: ["Agência Virtual", "Como se associar", "Cadastro de fornecedores", "Desligamentos programados"],
  },
  {
    title: "Cooperativa",
    links: ["Quem somos", "Planejamento estratégico", "Geração", "Telecom", "Distribuição", "Programas sociais", "Fornecedores"],
  },
  {
    title: "Atendimento",
    links: ["Fale conosco", "Falta de energia", "Segunda via", "Ouvidoria"],
  },
  {
    title: "Explore",
    links: ["Nossas soluções", "Sobre a CERFOX", "Falta de energia", "Trabalhe conosco", "Nosso blog", "Contato"],
  },
]

const socialLinks = [
  {
    name: "Instagram",
    href: "https://www.instagram.com/cerfoxenergia",
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

const contactInfo = [
  {
    icon: MapPin,
    label: "Avenida Jordão Pinto, 2300, Centro, Fontoura Xavier-RS",
    href: "https://maps.google.com/?q=Avenida+Jordão+Pinto,+2300,+Fontoura+Xavier-RS",
  },
  {
    icon: Mail,
    label: "email@cerfox.com.br",
    href: "mailto:email@cerfox.com.br",
  },
  {
    icon: PhoneCall,
    label: "0800 648 4800",
    href: "tel:08006484800",
  },
  {
    icon: Phone,
    label: "(54) 3514-3500",
    href: "tel:+555435143500",
  },
]

const year = new Date().getFullYear()
</script>

<template>
  <footer class="border-t border-border bg-card">
    <div class="mx-auto max-w-7xl px-4 py-5 lg:py-20 sm:px-6">
      <div class="grid gap-10 md:grid-cols-2 lg:grid-cols-5">
        <div>
          <img :src="CerfoxLogo" alt="Logo CERFOX" class="h-18 w-auto" />
          <ul class="mt-3 space-y-3 border-t border-border pt-6">
            <li v-for="contact in contactInfo" :key="contact.label">
              <a
                :href="contact.href"
                class="flex items-start gap-3 text-sm text-muted-foreground hover:text-primary"
              >
                <component :is="contact.icon" class="mt-0.5 h-4 w-4 shrink-0" />
                <span>{{ contact.label }}</span>
              </a>
            </li>
          </ul>
        </div>

        <div v-for="col in cols" :key="col.title">
          <h3 class="font-heading text-sm font-bold text-card-foreground">{{ col.title }}</h3>
          <ul class="mt-3 space-y-1.5">
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

      <div class="mt-12 grid space-y-1.5 lg:flex items-center justify-between border-t border-border pt-6">
        <p class="text-sm text-muted-foreground">
          &copy; {{ year }} CERFOX. Todos os direitos reservados.
        </p>

         <div class="flex items-center gap-3">
          <a
            v-for="social in socialLinks"
            :key="social.name"
            :href="social.href"
            target="_blank"
            rel="noopener noreferrer"
            :aria-label="social.name"
            class="flex h-9 w-9 items-center justify-center text-muted-foreground hover:text-primary"
          >
            <Icon :icon="social.icon" class="h-5 w-5" />
          </a>
        </div>

        <a 
          href="#"
          class="text-sm text-muted-foreground hover:text-primary">
          Política de Privacidade
        </a>
      </div>
    </div>
  </footer>
</template>