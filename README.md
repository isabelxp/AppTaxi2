# AppTaxi2
taxi taxi

#Consumiendo servicios

- Registrar usuario
```java
ServRegistroUsuario registro = new ServRegistroUsuario();
RequestCrearUsuario requestCrearUsuario = new RequestCrearUsuario(
"V1003933", //Cedula
"12345", //Contraseña
"Andy Sanchez", //Nombre
"0412833123", //Telefono
1, //Si esta en el CNE (1 si, 0 no)
"dadcrazy@gmail.com", //Correo
"pasajero", //Rol
profile, //Foto de perfil *bitmap*
null); //Foto de cedula *bitmap*
registro.registrarUsuario(requestCrearUsuario);
```

- Pedir foto de usuario por C.I
```java
new ServPhotoByCI("V1003933", 300){ //Cedula,Tamaño en pixeles *Opcional*
    @Override
    public void onSuccess() {
        Picasso.with(MainActivity.this) //Tu activity
          .load(getUrl()) //Se deja igual
          .into(*ImageView*); //El ImageView donde mostraras la imagen
    }
};
```
