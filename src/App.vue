<script setup lang="ts">
import SiteHeader from "./components/SiteHeader.vue"
import HeroSection from "./components/HeroSection.vue"
import StatsMarquee from "./components/StatsMarquee.vue"
import ServicesSection from "./components/ServicesSection.vue"
import AboutSection from "./components/AboutSection.vue"
import CooperativismoSection from "./components/CooperativismoSection.vue"
import ContactSection from "./components/ContactSection.vue"
import SiteFooter from "./components/SiteFooter.vue"
</script>

<template>
  <div class="min-h-screen bg-background">
    <SiteHeader />
    <main>
      <HeroSection />
      <StatsMarquee />
      <ServicesSection />
      <AboutSection />
      <CooperativismoSection />
      <ContactSection />
    </main>
    <SiteFooter />
  </div>
</template>
