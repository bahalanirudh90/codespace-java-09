@FunctionalInterface
interface blueprint{
    int dothis(int a,int b);
}
public class FunctionalInterfacePractice {
    public static void main(String[] args) {
        blueprint obj = new blueprint() {
            @Override
            public int dothis(int a, int b) {
                return a + b;
            }
        };
        System.out.println(obj.dothis(5, 10));

        // Using a lambda expression
        blueprint obj2 = (a,b) -> a * b;
        System.out.println(obj2.dothis(5, 10));
    }
}
