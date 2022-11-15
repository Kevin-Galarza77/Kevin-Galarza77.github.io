// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import {getFirestore} from '@firebase/firestore';
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
const firebaseConfig = {
  apiKey: "AIzaSyB98sZO3sDLkZh1PddzfgLb239Q5a2Ss_k",
  authDomain: "mi-portafolio-ae4d7.firebaseapp.com",
  projectId: "mi-portafolio-ae4d7",
  storageBucket: "mi-portafolio-ae4d7.appspot.com",
  messagingSenderId: "289448108254",
  appId: "1:289448108254:web:f21c99205aac6e308e224f"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);

export const db = getFirestore(app);