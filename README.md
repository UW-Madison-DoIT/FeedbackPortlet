# FeedbackPortlet

[![No Maintenance Intended](http://unmaintained.tech/badge.svg)](http://unmaintained.tech/)

This code moved to [a private git repository](https://git.doit.wisc.edu/wps/myuw-service/myuw-legacy/FeedbackPortlet) for maintenance within the MyUW service.

------

A portlet that allows our users to give us feedback

The portlet is a form field that emails the results to an email service that is meant to consume the email and put it into a ticketing system.


src/main/webapp/context.properties.example must be copied and duplicated to context.properties with the correct information filled out for the email to be sent to where you want.  Example might be that you want the target email and the from address to be your personal email for local testing.


