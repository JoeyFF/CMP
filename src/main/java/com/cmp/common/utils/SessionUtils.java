package com.cmp.common.utils;

import javax.servlet.http.HttpServletRequest;

public class SessionUtils {
    /**
     * 获取session
     *
     * @param name
     * @return
     */
    public static Object getSessionAttribute(HttpServletRequest request, String name) {
        return request.getSession().getAttribute(name);
    }

    public static void setSessionAttribute(HttpServletRequest request, String name, Object value) {
        request.getSession().setAttribute(name , value);
    }

    public static void removeSessionAttribute(HttpServletRequest request, String name) {
        request.getSession().removeAttribute(name);
    }
}
