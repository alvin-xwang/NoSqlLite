package com.alvin.nosql.sample;

import com.alvin.nosql.api.Condition;
import com.alvin.nosql.api.ItemFilter;
import com.alvin.nosql.api.Operator;

/**
 * The implementation class for ItemFilter<User>.
 * 
 * @author Alvin
 *
 */
public class UserFilter implements ItemFilter<User> {

    private Condition<String> nameCondition = null;
    private Condition<Integer> ageCondition = null;

    public Condition<String> getNameCondition() {
        return nameCondition;
    }

    public void setNameCondition(String name, Operator spec) {
        this.nameCondition = new Condition<String>(name, spec);
    }

    public Condition<Integer> getAgeCondition() {
        return ageCondition;
    }

    public void setAgeCondition(int age, Operator spec) {
        this.ageCondition = new Condition<Integer>(age, spec);
        ;
    }

    @Override
    public boolean match(User user) {
        if (user == null) {
            return false;
        }

        if (nameCondition == null) {
            return (ageCondition.eval(user.getAge()));
        }

        return nameCondition.eval(user.getName())
                && ageCondition.eval(user.getAge());
    }

}
