package com.shopping.validator;

public abstract class PayLoadValidator<T extends RequestPayLoad>
{

    abstract boolean shouldValidate(T payload);
    abstract void validatePayLoad(T payload);
}
