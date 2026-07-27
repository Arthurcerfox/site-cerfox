<script setup lang="ts">
import NavigationDesktop from "@/components/nav/NavigationDesktop.vue"
import NavigationMobile from "@/components/nav/NavigationMobile.vue"
import CerfoxLogo from "/images/logo-cerfox-dark.png?url"

import { ref, onMounted, onUnmounted } from "vue"

const isScrolled = ref(false)

function handleScroll() {
  isScrolled.value = window.scrollY > 10
}

onMounted(() => {
  window.addEventListener("scroll", handleScroll)
  handleScroll()
})

onUnmounted(() => {
  window.removeEventListener("scroll", handleScroll)
})
</script>

<template>
  <header :class="[
  'sticky top-0 z-50 w-full transition-all duration-300',
    isScrolled ? 
    'bg-primary/80 backdrop-blur-xl shadow-lg shadow-black/10'
    : 'bg-primary']">
    <div class="mx-auto flex h-20 max-w-6xl items-center justify-between px-4 sm:h-24 sm:px-6 lg:h-28">
      <a href="#" aria-label="CERFOX — Página Inicial">
        <img :src="CerfoxLogo" alt="Logo CERFOX" class="h-24 w-auto sm:h-28 md:h-32 lg:h-36" />
      </a>
      <NavigationDesktop class="hidden md:flex" />
      <NavigationMobile class="md:hidden" />
    </div>
  </header>
</template>