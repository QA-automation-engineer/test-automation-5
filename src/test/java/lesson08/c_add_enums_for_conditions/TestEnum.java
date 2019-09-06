package lesson08.c_add_enums_for_conditions;

public enum TestEnum {
    FIRST{
        @Override
        public void doSmth() {
            System.out.println(1);
        }
    },
    SECOND {
        @Override
        public void doSmth() {
            System.out.println(2);
        }
    };

    public abstract void doSmth();
}
