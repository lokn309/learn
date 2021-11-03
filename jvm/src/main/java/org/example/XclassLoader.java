package org.example;

import sun.applet.Main;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: lokn
 * @date: 2021/11/03 23:31
 */
public class XclassLoader extends ClassLoader {

    public static void main(String[] args) {
        String className = "Hello";
        String methodName = "hello";
        XclassLoader xclassLoader = new XclassLoader();
        try {
            Class<?> clazz = xclassLoader.loadClass(className);
            Object object = clazz.getDeclaredConstructor().newInstance();
            Method method = clazz.getDeclaredMethod(methodName);
            method.invoke(object);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = name + ".xlass";
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(className);
        try {
            byte[] classByte = new byte[inputStream.available()];
            inputStream.read(classByte);
            byte[] decodeByte = this.decode(classByte);
            return defineClass(name, decodeByte, 0, decodeByte.length);
        } catch (IOException e) {
            throw new ClassNotFoundException(name, e);
        } finally {
            this.close(inputStream);
        }
    }

    private byte[] decode(byte[] bytes) {
        byte[] decodeByte = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            decodeByte[i] = (byte)(255 - bytes[i]);
        }
        return decodeByte;
    }

    private void close(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
