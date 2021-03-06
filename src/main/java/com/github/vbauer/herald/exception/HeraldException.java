package com.github.vbauer.herald.exception;

/**
 * @author Vladislav Bauer
 */

public abstract class HeraldException extends RuntimeException {

    public String getMessage() {
        return "You shouldn't see this error message. Override it in the sub-class";
    }

}
