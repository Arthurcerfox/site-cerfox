<script setup lang="ts">
import SiteHeader from "./components/SiteHeader.vue"
import HeroSection from "./components/HeroSection.vue"
import StatsMarquee from "./components/StatsMarquee.vue"
import SolucoesSection from "./components/SolucoesSection.vue"
import AboutSection from "./components/AboutSection.vue"
import FaltaDeEnergiaSection from "./components/FaltaDeEnergiaSection.vue"
import VagasSection from "./components/VagasSection.vue"
import ContactSection from "./components/ContactSection.vue"
import BlogSection from "./components/BlogSection.vue"
import SiteFooter from "./components/SiteFooter.vue"
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
