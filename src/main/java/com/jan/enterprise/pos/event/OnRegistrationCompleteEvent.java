package com.jan.enterprise.pos.event;

import java.util.Locale;

import org.springframework.context.ApplicationEvent;

import com.jan.enterprise.pos.model.MemberModel;

@SuppressWarnings("serial")
public class OnRegistrationCompleteEvent extends ApplicationEvent {

    private final String appUrl;
    private final Locale locale;
    private final MemberModel member;

    public OnRegistrationCompleteEvent(final MemberModel member, final Locale locale, final String appUrl) {
        super(member);
        this.member = member;
        this.locale = locale;
        this.appUrl = appUrl;
    }

    //

    public String getAppUrl() {
        return appUrl;
    }

    public Locale getLocale() {
        return locale;
    }

    public MemberModel getUser() {
        return member;
    }

}
