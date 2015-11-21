package ua.com.goit.gojava.kickstarter;

import java.util.List;

public interface Faqs {

    void add(Faq faq);

    List<Faq> getFaqs();

    List<Faq> get(int project_id);

    int size();


}
