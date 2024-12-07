package persistencia;

import modelo.Usuario;
import java.io.*;
import java.util.ArrayList;

public class ArchivoUsuarios {
    private static final String FILE_NAME = "usuarios.dat";

    public static void guardarUsuarios(ArrayList<Usuario> usuarios) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(usuarios);
        }
    }

    @SuppressWarnings("unchecked")
	public static ArrayList<Usuario> cargarUsuarios() throws IOException, ClassNotFoundException {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (ArrayList<Usuario>) ois.readObject();
        }
    }
}
