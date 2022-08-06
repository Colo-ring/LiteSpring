package com.yjc.litespringframework.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author IntelliYJC
 * @create 2022/4/4 13:14
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValueList;

    public PropertyValues() { this.propertyValueList = new ArrayList<>(0); }

    public void addPropertyValue(PropertyValue pv) {
        this.propertyValueList.add(pv);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        Iterator<PropertyValue> iterator = this.propertyValueList.iterator();
        PropertyValue pv;
        do {
            if (!iterator.hasNext()) {
                return null;
            }

            pv = iterator.next();
        } while(!pv.getName().equals(propertyName));

        return pv;
    }
}
