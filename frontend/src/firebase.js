import firebase from 'firebase';

const config = {
  apiKey: 'AIzaSyC9kuR4ROsxynWxnQRuDTAw2Ok4T1FRZVE',
  authDomain: 'idana3-e8406.firebaseapp.com',
  projectId: 'idana3-e8406',
  storageBucket: 'idana3-e8406.appspot.com',
  messagingSenderId: '1013899700274',
  appId: '1:1013899700274:web:a2153bf5e4ed9bcde0b42b',
  measurementId: 'G-MFPVVYKP65'
};

const firebaseApp = firebase.initializeApp(config);

const db = firebaseApp.firestore();
const usersCollection = db.collection('users');

export const getUser = async id => {
  const user = await usersCollection.doc(id).get();
  return user.exists ? user.data() : null;
};
