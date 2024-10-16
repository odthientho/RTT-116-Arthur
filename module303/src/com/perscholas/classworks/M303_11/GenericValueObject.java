package com.perscholas.classworks.M303_11;

public class GenericValueObject <T, K>{
    private T value;
    private K key;

    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
    public static void main(String[] args) {
        GenericValueObject<String, String> str = new GenericValueObject<>();
        str.setValue("Hello");
        String str2 = str.getValue();
    }
}
