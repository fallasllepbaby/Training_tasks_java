public class Vector {
    private int x;
    private int y;
    private int z;

    // SETTERS AND GETTERS

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }

    ///////////////////////////////////////////////

    public Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getLength() {
        double length = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
        return length;
    }

    public double multiplyScalar(Vector vector){
        double result = this.x * vector.x + this.y * vector.y + this.z * vector.z;
        return result;
    }

    public Vector multiplyVector(Vector vector) {
        return new Vector(y * vector.z - z * vector.y, z * vector.x - x * vector.z, x * vector.y - y * vector.x);
    }

    public void getAngle(Vector vector) {
        double result = this.multiplyScalar(vector) / (this.getLength() * vector.getLength());
        System.out.println("Угол между векторами (или косинус угла): " + result);
    }

    public Vector addVector(Vector vector) {
        return new Vector(x + vector.x, y + vector.y, z + vector.z);
    }

    public Vector minusVector(Vector vector) {
        return new Vector(x - vector.x, y - vector.y, z - vector.z);
    }

    public static Vector[] getArrayOfVectors(int n) {
        Vector[] vectors = new Vector[n];
        for(int i = 0; i < vectors.length; i++){
            vectors[i] = new Vector( (int) Math.floor(Math.random() * 5), (int) Math.floor(Math.random() * 5), (int) Math.floor(Math.random() * 5));
        }
        return vectors;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
