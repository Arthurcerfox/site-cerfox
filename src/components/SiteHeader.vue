<script setup lang="ts">
import NavigationDesktop from "@/components/nav/NavigationDesktop.vue"
import NavigationMobile from "@/components/nav/NavigationMobile.vue"
import CerfoxLogo from "/images/logo-cerfox.png?url"
</script>

<template>
  <header class="sticky top-0 z-50 w-full border-b border-border bg-background/80 backdrop-blur-md">
    <div class="mx-auto flex h-25 max-w-6xl items-center justify-between px-4 sm:px-6">
      <a href="#" aria-label="CERFOX — Página Inicial">
        <img
          :src="CerfoxLogo"
          alt="Logo CERFOX"
          class="h-40 w-auto"
        />
      </a>

      <NavigationDesktop class="hidden md:flex" />
      <NavigationMobile class="md:hidden" />
    </div>
  </header>
</template>
