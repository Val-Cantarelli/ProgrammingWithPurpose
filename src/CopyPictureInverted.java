public class CopyPictureInverted {
    public static void main(String[] args) {
        // Não podemos apenas tratar a imagem como fazemos de colorido para preto e branco.
        // Temos que criar uma nova imagem

        Picture source = new Picture("/Mandrill-Image-on-Synthetic-Surface.ppm");// Pega a imagem
        // Pega as dimensoes dessa imagem source
        int width = source.width();
        int height = source.height();
        Picture target = new Picture(width, height);// Cria uma outr imagem passando essas medidas
        for (int col = 0; col < width; col++)
            for (int row = 0; row < height; row++) target.set(col, height - row - 1, source.get(col, row));

        target.show();

    }
}
