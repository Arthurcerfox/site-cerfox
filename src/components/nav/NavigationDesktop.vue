<script lang="ts" setup>
import { NavigationMenu, NavigationMenuItem, NavigationMenuList, NavigationMenuTrigger, NavigationMenuContent, NavigationMenuLink, navigationMenuTriggerStyle } from "@/components/ui/navigation-menu"
import { navigationLinks } from "@/components/nav/data/links"
import { cn } from "@/lib/utils"
</script>

<template>
<NavigationMenu class="hidden md:flex">
    <NavigationMenuList>
        <NavigationMenuItem
            v-for="link in navigationLinks"
            :key="link.label"
          >
            <template v-if="link.items">
              <NavigationMenuTrigger class="bg-transparent hover:text-background text-background data-[state=open]:text-background data-[state=open]:bg-transparent">
                {{ link.label }}
              </NavigationMenuTrigger>

              <NavigationMenuContent>
                <ul class="grid w-56 gap-1 p-2">
                  <li
                    v-for="item in link.items"
                    :key="item.href"
                  >
                    <NavigationMenuLink as-child>
                       <a :href="item.href"
                        class="block rounded-md p-2 hover:bg-accent"
                      >
                        {{ item.label }}
                      </a>
                    </NavigationMenuLink>
                  </li>
                </ul>
              </NavigationMenuContent>
            </template>

            <template v-else>
              <NavigationMenuLink
                :href="link.href"
                :class="cn(navigationMenuTriggerStyle(), 'bg-transparent hover:bg-accent hover:text-background text-background')"
              >
                {{ link.label }}
              </NavigationMenuLink>
            </template>
          </NavigationMenuItem>
        </NavigationMenuList>
    </NavigationMenu>
</template>