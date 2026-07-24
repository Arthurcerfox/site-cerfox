<script setup lang="ts">
import { Accordion, AccordionContent, AccordionItem, AccordionTrigger } from "@/components/ui/accordion"
import { Button } from "@/components/ui/button"
import { Sheet, SheetContent, SheetFooter, SheetTrigger, SheetHeader, SheetTitle } from "@/components/ui/sheet"
import { Menu } from "@lucide/vue"

import CerfoxLogo from "/images/logo-cerfox-light.png?url"

import { navigationLinks } from "@/components/nav/data/links"
import { ref } from "vue"
import SheetClose from "../ui/sheet/SheetClose.vue"

const open = ref(false)
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

  <SheetContent side="right">
    <SheetHeader>
      <SheetTitle>
        <img :src="CerfoxLogo" alt="Logo CERFOX" class="h-25 w-auto dark:hidden" />
      </SheetTitle>
    </SheetHeader>

    <Accordion type="single" collapsible class="w-full">
      <AccordionItem
        v-for="link in navigationLinks"
        :key="link.label"
        :value="link.label"
      >
        <AccordionTrigger class="w-full text-left text-md px-5 text-bold">
          {{ link.label }}
        </AccordionTrigger>

        <AccordionContent>
          <ul class="flex flex-col gap-2">
            <li
              v-for="item in link.items"
              :key="item.href"
            >
              <Button
                as="a"
                :href="item.href"
                variant="ghost"
                size="sm"
                class="w-full justify-start rounded-md px-5 py-2 text-sm font-medium text-muted-foreground hover:bg-accent hover:text-accent-foreground focus:bg-accent focus:text-accent-foreground"
              >
                {{ item.label }}
              </Button>
            </li>
          </ul>
        </AccordionContent>
      </AccordionItem>
    </Accordion>
    <SheetFooter>
        <SheetClose as-child>
          <Button
            variant="secondary"
            size="sm"
            class="w-full justify-center rounded-md px-4 py-2 text-sm font-bold hover:bg-accent hover:text-accent-foreground focus:bg-accent focus:text-accent-foreground"
          >
            Fechar
          </Button>
        </SheetClose>
    </SheetFooter>
  </SheetContent>
</Sheet>
</template>