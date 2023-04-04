package br.com.dio.desafio.dominio;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClassToString {
    private String response;

    public ClassToString(Object clazz) {
        // lista com todos os métodos declarado na classe
        Method[] declaredMethods = clazz.getClass().getMethods();

        // nome da classe
        String className = clazz.getClass().getSimpleName();

        // string de saída
        response = String.format("\n  %s {\n", className);

        // lista contendo as chaves/valores
        List<String> list = new ArrayList<String>();

        // varre método por método
        for (Method method : declaredMethods) {
            // nome do método
            String methodName = method.getName();

            // executa se o método começar com "get" e o nome do método for diferente de
            // "getClass"
            if (methodName.startsWith("get") && methodName != "getClass") {
                Class<?> returnType = method.getReturnType();
                String type = returnType.getSimpleName().toLowerCase();

                // nome do método sem o "get"
                String name = methodName.replace("get", "");

                // nome do método em camelCase
                String nameInCamel = name.substring(0, 1).toLowerCase() + name.substring(1);

                try {
                    Object object = method.invoke(clazz);
                    String value = object.toString();

                    // obtém o valor como inteiro
                    if (type.equals("int")) {
                        list.add(String.format("%s: %d", nameInCamel, Integer.parseInt(value)));

                    } else if (type.equals("string")) {
                        list.add(String.format("%s: \"%s\"", nameInCamel, value));
                    } else if (type.equals("localdate")) {
                        String[] array = value.split("-");
                        Collections.reverse(Arrays.asList(array));

                        String date = String.join("/", array);

                        list.add(String.format("%s: \"%s\"", nameInCamel, date));
                    } else
                        System.out.println("TIPO DESCONHECIDO: " + type);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        response = String.format("%s    %s\n  }", response, String.join("\n    ", list));
    }

    @Override
    public String toString() {
        return response;
    }
}
