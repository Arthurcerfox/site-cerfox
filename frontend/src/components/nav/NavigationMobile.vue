<script setup lang="ts">
import { Accordion, AccordionContent, AccordionItem, AccordionTrigger } from "@/components/ui/accordion"
import { Button } from "@/components/ui/button"
import { Sheet, SheetContent, SheetDescription, SheetFooter, SheetTrigger, SheetHeader, SheetTitle } from "@/components/ui/sheet"
import { Menu } from "@lucide/vue"

import { navigationLinks } from "@/components/nav/data/links"
import { ref } from "vue"
import SheetClose from "../ui/sheet/SheetClose.vue"

const open = ref(false)
const year = new Date().getFullYear()
</script>

<template>
  <Sheet v-model:open="open">
    <SheetTrigger as-child>
      <Button
        variant="ghost"
        size="icon"
        class="md:hidden text-background"
      >
        <Menu class="h-6 w-6" />
      </Button>
    </SheetTrigger>

    <SheetContent
      side="right"
      class="flex h-full flex-col gap-0 border-l border-primary-foreground/10 bg-primary p-0 text-primary-foreground"
    >
      <SheetHeader class="shrink-0 gap-1 border-b border-primary-foreground/10 px-5 py-6 text-left">
        <SheetTitle class="font-heading text-xl font-bold tracking-tight text-primary-foreground">
          Menu
        </SheetTitle>
        <SheetDescription class="text-sm text-primary-foreground">
          Navegue pelo site da CERFOX
        </SheetDescription>
      </SheetHeader>

      <nav class="flex-1 overflow-y-auto px-0 py-2">
        <Accordion type="single" collapsible class="w-full">
          <template
            v-for="link in navigationLinks"
            :key="link.label"
          >
            <AccordionItem
              v-if="link.items"
              :value="link.label"
              class="border-b border-primary-foreground/10"
            >
              <AccordionTrigger
                class="w-full px-5 py-4 text-left font-heading text-base font-bold text-primary-foreground hover:no-underline [&[data-state=open]>svg]:text-accent [&>svg]:text-accent/70"
              >
                {{ link.label }}
              </AccordionTrigger>

              <AccordionContent class="pb-2">
                <ul class="flex flex-col gap-1">
                  <li
                    v-for="item in link.items"
                    :key="item.href"
                  >
                    <a
                      :href="item.href"
                      class="flex items-center rounded-md px-5 py-2.5 text-sm font-medium text-primary-foreground/70 transition-colors hover:bg-primary-foreground/10 hover:text-accent focus:bg-primary-foreground/10 focus:text-accent focus:outline-none"
                      @click="open = false"
                    >
                      {{ item.label }}
                    </a>
                  </li>
                </ul>
              </AccordionContent>
            </AccordionItem>

            <a
              v-else
              :href="link.href"
              class="flex items-center border-b border-primary-foreground/10 px-5 py-4 font-heading text-base font-bold text-primary-foreground transition-colors hover:bg-primary-foreground/10 hover:text-accent focus:bg-primary-foreground/10 focus:text-accent focus:outline-none"
              @click="open = false"
            >
              {{ link.label }}
            </a>
          </template>
        </Accordion>
      </nav>

      <SheetFooter class="shrink-0 gap-4 border-primary-foreground/10 px-5 py-6">
        <SheetClose as-child>
          <Button
            variant="accent"
            size="sm"
            class="w-full justify-center rounded-md px-4 py-2 text-sm font-bold"
          >
            Fechar
          </Button>
        </SheetClose>
      </SheetFooter>
    </SheetContent>
  </Sheet>
</template>
