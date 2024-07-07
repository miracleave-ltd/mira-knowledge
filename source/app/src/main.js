import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap.bundle.min.js"
import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

// fontAwesome
import { library } from '@fortawesome/fontawesome-svg-core'
import { faHouse, faUserPlus, faAddressBook,
  faFileLines, faFileCirclePlus, faChartLine,
  faArrowRightFromBracket, faMagnifyingGlass,
  faArrowRightToBracket } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

// 使用アイコン読込
library.add(faHouse)
library.add(faAddressBook)
library.add(faUserPlus)
library.add(faFileLines)
library.add(faFileCirclePlus)
library.add(faChartLine)
library.add(faArrowRightFromBracket)
library.add(faMagnifyingGlass)
library.add(faArrowRightToBracket)


createApp(App)
  .use(router)
  .component('fa', FontAwesomeIcon)
  .mount('#app')
