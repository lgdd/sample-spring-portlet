package net.madheroy.liferay;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import net.madheroy.liferay.dto.MyForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("VIEW")
public class PortletViewController {

    public static final Log logger = LogFactoryUtil.getLog(PortletViewController.class);

    @RenderMapping
    public String render(Model model) {
        return "view";
    }

    @ActionMapping(value = "processMyForm")
    public void actionMyForm(@Valid @ModelAttribute("myForm") MyForm myForm, BindingResult results,
                             ActionRequest request, ActionResponse response, Model model) {
        if (!results.hasErrors()) {
            logger.info("myForm.firstName='" + myForm.getFirstName() + "'");
            logger.info("myForm.lastName='" + myForm.getLastName() + "'");
            SessionMessages.add(request, "success");
        }
    }

    @ModelAttribute("myForm")
    public MyForm getMyFormModelAttribute() {
        return new MyForm();
    }
}