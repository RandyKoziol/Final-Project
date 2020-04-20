package com.finalproject.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Pattern;

    @FacesValidator
    public class DateValidator implements Validator {
        private String regex = "^([0-2][0-9]|(3)[0-1])(/)(((0)[0-9])|((1)[0-2]))(/)\\d{4}$";


        @Override
        public void validate(FacesContext facesContext, UIComponent uiComponent, Object name) {
            if (!Pattern.compile(regex).matcher(name.toString()).matches()) {
                FacesMessage msg =
                        new FacesMessage("Date format is dd/mm/yyyy");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        }
    }
