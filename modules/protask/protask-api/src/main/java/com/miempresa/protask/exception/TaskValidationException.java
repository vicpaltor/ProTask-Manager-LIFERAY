package com.miempresa.protask.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class TaskValidationException extends PortalException {
    public TaskValidationException() {
    }

    public TaskValidationException(String msg) {
        super(msg);
    }

    public TaskValidationException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public TaskValidationException(Throwable cause) {
        super(cause);
    }
}