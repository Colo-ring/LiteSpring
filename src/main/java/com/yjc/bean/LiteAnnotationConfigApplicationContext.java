package com.yjc.bean;

import com.yjc.annotation.*;
import com.yjc.util.ScanTools;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author IntelliYJC
 * @create 2022/7/28 17:26
 */
public class LiteAnnotationConfigApplicationContext {
    private final Class<?> configClass;
    private final Map<String, Object> ioc = new HashMap<>();
    private final List<String> beanNames = new ArrayList<>();

    public LiteAnnotationConfigApplicationContext(Class<?> configClass) {
        // 初始化配置类
        this.configClass = configClass;
        ComponentScan scanAnnotation = (ComponentScan) configClass.getAnnotation(ComponentScan.class);
        assert scanAnnotation != null : "配置类未正确配置注解！";
        String pack = scanAnnotation.value();
        // 遍历包，找到目标类（原材料）
        Set<BeanDefinition> beanDefinitions = findBeanDefinitions(pack);
        // 根据原材料创建bean
        createObject(beanDefinitions);
        // 自动装载
        autowireObject(beanDefinitions);
    }

    public Object getBean(String beanName){
        return ioc.get(beanName);
    }

    public String[] getBeanDefinitionNames(){
        return beanNames.toArray(new String[0]);
    }

    public Integer getBeanDefinitionCount(){
        return beanNames.size();
    }

    /**
     * 自动装载
     * @param beanDefinitions BeanDefinition 集合
     */
    private void autowireObject(Set<BeanDefinition> beanDefinitions) {
        for (BeanDefinition beanDefinition : beanDefinitions) {
            Class clazz = beanDefinition.getBeanClass();
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                Autowired annotation = declaredField.getAnnotation(Autowired.class);
                if (annotation == null) {
                    continue;
                }
                String fieldName = declaredField.getName();
                String beanName;
                Object bean;
                Qualifier qualifier = declaredField.getAnnotation(Qualifier.class);
                if (qualifier != null) {
                    // byName
                    beanName = qualifier.value();
                } else {
                    // byType
                    Class<?> type = declaredField.getType();
                    Component wiredAnnotation = type.getAnnotation(Component.class);
                    assert wiredAnnotation != null : "注入对象未放入IOC容器！";
                    String value = wiredAnnotation.value();
                    beanName = "".equals(value) ? fieldName : value;
                }
                bean = getBean(beanName);
                String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                try {
                    Method method = clazz.getMethod(methodName, declaredField.getType());
                    Object object = getBean(beanDefinition.getBeanName());
                    method.invoke(object, bean);
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 根据原材料创建bean
     * @param beanDefinitions BeanDefinition 集合
     */
    private void createObject(Set<BeanDefinition> beanDefinitions) {
        for (BeanDefinition beanDefinition : beanDefinitions) {
            Class clazz = beanDefinition.getBeanClass();
            String beanName = beanDefinition.getBeanName();
            try {
                // 创建对象
                Object object = clazz.getConstructor().newInstance();
                // 完成属性的赋值
                Field[] declaredFields = clazz.getDeclaredFields();
                for (Field declaredField : declaredFields) {
                    Value valueAnnotation = declaredField.getAnnotation(Value.class);
                    if (valueAnnotation != null) {
                        String value = valueAnnotation.value();
                        String fieldName = declaredField.getName();
                        String methodName = "set" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
                        Method method = clazz.getMethod(methodName, declaredField.getType());
                        // 类型转换
                        Object val = null;
                        switch (declaredField.getType().getName()) {
                            case "java.lang.Integer":
                                val = Integer.parseInt(value);
                                break;
                            case "java.lang.String":
                                val = value;
                                break;
                            case "java.lang.Float":
                                val = Float.parseFloat(value);
                                break;
                        }
                        method.invoke(object, val);
                    }
                }
                //存入缓存
                ioc.put(beanName, object);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }

        }
    }

    /**
     * 遍历包，找到带有 @Component 注解的目标类（原材料），放入 BeanDefinition 集合中
     * @param pack 包名
     * @return BeanDefinition 集合
     */
    private Set<BeanDefinition> findBeanDefinitions(String pack) {
        // 1. 获取包下所有的类
        Set<Class<?>> classes = ScanTools.getClasses(pack);
        Set<BeanDefinition> beanDefinitions = new HashSet<>();
        for (Class<?> clazz : classes) {
            // 2、遍历这些类，找到添加了注解的类
            Component componentAnnotation = clazz.getAnnotation(Component.class);
            if (componentAnnotation != null) {
                // 获取component的注解value
                String beanName = componentAnnotation.value();
                if ("".equals(beanName)) {
                    // 未设置 component value 值，默认为空，设置为获取类名首字母小写
                    // 删除全类名的包名前缀
                    String className = clazz.getName().replaceAll(clazz.getPackage().getName() + ".", "");
                    beanName = className.substring(0, 1).toLowerCase() + className.substring(1);
                }
                // 3、将这些类封装成BeanDefinition，装载到集合中
                beanDefinitions.add(new BeanDefinition(beanName, clazz));
                beanNames.add(beanName);
            }
        }
        return beanDefinitions;
    }
}
