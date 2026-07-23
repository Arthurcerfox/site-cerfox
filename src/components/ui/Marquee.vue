<script setup lang="ts">
withDefaults(
  defineProps<{
    duration?: string
    pauseOnHover?: boolean
  }>(),
  {
    duration: "40s",
    pauseOnHover: true,
  },
)
</script>

<template>
  <div
    class="marquee group relative flex w-full overflow-hidden"
    :style="{
      '--marquee-duration': duration,
      maskImage:
        'linear-gradient(to right, transparent, black 8%, black 92%, transparent)',
      WebkitMaskImage:
        'linear-gradient(to right, transparent, black 8%, black 92%, transparent)',
    }"
  >
    <div
      class="flex shrink-0 items-center animate-[marquee_var(--marquee-duration)_linear_infinite]"
      :class="pauseOnHover ? 'group-hover:[animation-play-state:paused]' : ''"
    >
      <slot />
    </div>
    <div
      aria-hidden="true"
      class="flex shrink-0 items-center animate-[marquee_var(--marquee-duration)_linear_infinite]"
      :class="pauseOnHover ? 'group-hover:[animation-play-state:paused]' : ''"
    >
      <slot />
    </div>
  </div>
</template>
