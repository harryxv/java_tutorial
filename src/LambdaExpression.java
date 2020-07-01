public class LambdaExpression {
    interface Todo {
        void execute();
    }

    public static void main(String[] args) {
        Todo todo = () -> {
            System.out.println("I am a lambda function");
        };
        todo.execute();
    }
}