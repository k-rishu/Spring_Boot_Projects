package com.example.test;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MySqlDataService implements DataService{

    @Override
    public int[] retriveData() {
        return new int[] {1,2,3,4,5};
    }
}
