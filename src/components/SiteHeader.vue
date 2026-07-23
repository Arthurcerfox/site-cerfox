<script setup lang="ts">
import NavigationDesktop from "@/components/nav/NavigationDesktop.vue"
import NavigationMobile from "@/components/nav/NavigationMobile.vue"
import DarkModeSwitch from "./ui/DarkModeSwitch.vue"
import CerfoxLogoLight from "/images/logo-cerfox-light.png?url"
import CerfoxLogoDark from "/images/logo-cerfox-dark.png?url"

import { useDark } from "@vueuse/core"

const isDark = useDark()

</script>

<template>
  <header class="sticky top-0 z-50 w-full border-b border-border bg-background/80 backdrop-blur-md">
    <div class="mx-auto flex h-25 max-w-7xl items-center justify-between px-4 sm:px-6">
      <a href="#" aria-label="CERFOX — Página Inicial">
        <img v-if="!isDark" :src="CerfoxLogoLight" alt="Logo CERFOX Dark" class="h-40 w-auto" />
        <img v-else :src="CerfoxLogoDark" alt="Logo CERFOX Light" class="h-40 w-auto" />
      </a>

      <NavigationDesktop class="hidden md:flex" />
      <NavigationMobile class="md:hidden" />

      <DarkModeSwitch />
    </div>
  </header>
</template>