package section14.LambdaExpressions;

//  This is a Functional Interface, as it has only one abstrct method;
//  The anotation ensures this rule is respected, otherwise there will be an error at compile time;
@FunctionalInterface
public interface Operation<T> {
    
    T operate(T value1, T value2);

}
