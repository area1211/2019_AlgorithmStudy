package datastructure.sorting;

public enum  TestEnum {
    ON("온"), OFF("오프");

    private String krName;

    TestEnum(String string) {
        krName = string;
    }

    public String getKrName() {
        return krName;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println(12);
        TestEnum enum1 = TestEnum.ON;
        System.out.println(enum1.getKrName());
        TestClone testClone = new TestClone(123);
        TestClone testClone1 = testClone;
        TestClone clone = testClone.clone();
        System.out.println(testClone1.hashCode() == testClone.hashCode());
    }

    static class TestClone implements Cloneable{
        private int num;

        TestClone(int num){
            this.num = num;
            System.out.println("hi");
        }

        @Override
        protected TestClone clone() throws CloneNotSupportedException {
            return (TestClone)super.clone();
        }
    }
}
