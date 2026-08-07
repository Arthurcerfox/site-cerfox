<script setup lang="ts">
import SiteHeader from "./views/SiteHeader.vue"
import HeroSection from "./views/HeroSection.vue"
import StatsMarquee from "./views/StatsMarquee.vue"
import SolucoesSection from "./views/SolucoesSection.vue"
import AboutSection from "./views/AboutSection.vue"
import FaltaDeEnergiaSection from "./views/FaltaDeEnergiaSection.vue"
import VagasSection from "./views/VagasSection.vue"
import ContactSection from "./views/ContactSection.vue"
import BlogSection from "./views/BlogSection.vue"
import SiteFooter from "./views/SiteFooter.vue"
</script>

<template>
  <div class="min-h-screen bg-background">
    <SiteHeader />
    <main>
      <HeroSection />
      <SolucoesSection />
      <StatsMarquee />
      <AboutSection />
      <FaltaDeEnergiaSection />
      <VagasSection />
      <BlogSection />
      <ContactSection />
    </main>
    <SiteFooter />
  </div>
</template>
