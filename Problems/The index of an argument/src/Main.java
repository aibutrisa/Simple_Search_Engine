class Problem {
    public static void main(String[] args) {
        int index = -1;
        for (int i = 0; i < args.length; i++) {
            index = args[i].equals("test") ? i : index;
        }
        System.out.println(index);
    }
}