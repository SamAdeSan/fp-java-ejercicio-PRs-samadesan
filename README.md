
# 🧑‍💻 Proyecto de Colaboración en Java - Pull Requests

¡Bienvenidos al ejercicio práctico de colaboración en Git con Java! 🚀

En esta tarea, cada alumno contribuirá a un proyecto compartido mediante **Pull Requests (PRs)**. El objetivo es mejorar la calculadora básica añadiendo nuevas funcionalidades o mejorando el código existente.

---

## 🔥 **Instrucciones**

### 1️⃣ **Clona el repositorio**

Primero, haz una copia local del proyecto en tu computadora.

```bash
git clone https://github.com/tu-usuario/fp-java-ejercicio-clase.git
cd fp-java-ejercicio-clase
```

---

### 2️⃣ **Crea una nueva rama con tu nombre**

Para trabajar de manera independiente, crea una rama con tu nombre o tu número de alumno:

```bash
git checkout -b nombre-apellido
```

Por ejemplo:

```bash
git checkout -b juan-perez
```

---

### 3️⃣ **Realiza tus cambios**

En el archivo `Calculadora.java`, agrega una nueva función o mejora el código existente. Aquí hay algunas ideas:
- Multiplicación
- División (manejar división por cero)
- Raíz cuadrada
- Potencia
- Redondeo de números
- Cualquier otra función matemática relevante

💡 **Ejemplo de nueva función:**

```java
/**
 * Realiza una multiplicación de dos números enteros.
 * @param a Primer número
 * @param b Segundo número
 * @return El resultado de multiplicar a por b
 */
public static int multiplicar(int a, int b) {
    return a * b;
}
```

---

### 4️⃣ **Haz commit de tus cambios**

Guarda tus cambios localmente y escribe un mensaje de confirmación (commit):

```bash
git add .
git commit -m "Agregada función de multiplicación"
```

---

### 5️⃣ **Sube tu rama a GitHub**

Empuja tu rama con los cambios al repositorio remoto:

```bash
git push origin nombre-apellido
```

---

### 6️⃣ **Crea un Pull Request (PR)**

Sigue estos pasos para crear tu **Pull Request**:

1. Accede al repositorio en GitHub.
2. Verás un mensaje que dice **"Compare & pull request"**. Haz clic en él.
3. Si no ves el botón, haz clic en la pestaña **"Pull requests"** y luego en **"New pull request"**.
4. Asegúrate de que las ramas estén configuradas correctamente:
    - **Base:** `main` (la rama principal del repositorio)
    - **Compare:** `nombre-apellido` (tu rama con los cambios)
5. Escribe un título descriptivo para tu PR (por ejemplo: `Agregada función de multiplicación`).
6. En el cuadro de descripción, explica brevemente los cambios que realizaste.
7. Haz clic en **"Create pull request"**.

---

### 7️⃣ **Revisión del código**

El profesor revisará tu Pull Request. Es posible que recibas comentarios o sugerencias de mejora. Si es necesario realizar cambios:

1. Haz los cambios sugeridos en tu rama local.
2. Guarda los cambios con un nuevo commit:
   ```bash
   git add .
   git commit -m "Correcciones solicitadas en el PR"
   git push origin nombre-apellido
   ```
3. Los cambios se actualizarán automáticamente en el Pull Request existente.

---

### ✅ **Criterios de evaluación**

- ✔️ El código funciona correctamente.
- ✔️ Se sigue el estilo de código de Java.
- ✔️ Los comentarios en JavaDoc están correctamente implementados.
- ✔️ El Pull Request está correctamente creado y bien documentado.

---

### 📚 **Recursos útiles**

- [Documentación oficial de Java](https://docs.oracle.com/javase/8/docs/api/)
- [Guía básica de GitHub](https://guides.github.com/activities/hello-world/)
- [Markdown Cheat Sheet](https://www.markdownguide.org/cheat-sheet/)

---

### 💬 **Dudas o preguntas**

Si tienes algún problema, ¡no dudes en preguntar en clase o abrir un issue en este repositorio! 😊