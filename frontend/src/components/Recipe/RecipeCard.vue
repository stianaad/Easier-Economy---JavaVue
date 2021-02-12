<template>
  <v-card
    class="mx-auto"
    max-width="350"
  >
    <v-img
      height="200"
      src="https://cdn.vuetifyjs.com/images/cards/cooking.png"
    ></v-img>

    <v-card-title>Kjøttdeig og spaghetti</v-card-title>

    <v-card-text>
      <v-row
        align="center"
        class="mx-0"
      >
        <v-rating
          :value="4.5"
          color="amber"
          dense
          half-increments
          readonly
          size="14"
        ></v-rating>

        <div class="grey--text ml-4">
          4.5 (413)
        </div>
        <div>
          Enkel oppskrift for kjøttdeig og spaghetti. Smaker veldig godt
        </div>
      </v-row>
    </v-card-text>
    <v-divider class="mx-4"></v-divider>
    <v-card-text>
      <v-row align="center" class="mx-0">
        <v-icon>mdi-clock-time-nine-outline</v-icon>
        <div class="grey-darken-3--text ml-4">
          30 min
        </div>
        <v-icon class="ml-10">mdi-currency-usd</v-icon>
        <div class="grey-darken-3--text ml-4">
          100 kr
        </div>
      </v-row>
    </v-card-text>
  </v-card>
</template>

<script>
  export default {

  }
</script>

