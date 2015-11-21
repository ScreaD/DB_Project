package ua.com.goit.gojava.kickstarter.dao;

import ua.com.goit.gojava.kickstarter.Faq;
import ua.com.goit.gojava.kickstarter.Faqs;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * The class is getting necessary information to the table "faqs"
 *
 * @author scread
 * @see ua.com.goit.gojava.kickstarter.dao.AbstractDAO
 */
public class FaqsDAO extends AbstractDAO implements Faqs {

    /**
     * Adds to the table "faqs" fields question, obtained with the program
     *
     * @throws RuntimeException, when something wrong with adding new faq
     * @param faq class object Faq, which will be added to the database
     */
    @Override
    public void add(Faq faq) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("insert into faqs (question, answer) values (?, ?)");
            statement.setString(1, faq.getQuestion());
            statement.setString(2, faq.getAnswer());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Something wrong with adding new faq", e);
        }
    }

    /**
     * Retrieves from the table "faqs" all records, create a list of objects of List<Faq>
     * and return to the list of data to display user
     *
     * @throws RuntimeException, when something wrong with getting all faqs
     * @return  the list of objects of class Faq
     */
    @Override
    public List<Faq> getFaqs() {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            List<Faq> result = new LinkedList<Faq>();

            ResultSet rs = statement.executeQuery("select * from faqs");
            while (rs.next()) {
                result.add(new Faq(rs.getString("question"), rs.getString("answer")));
            }

            return result;
        } catch (SQLException e) {
            throw new RuntimeException("Something wrong with getting all faqs", e);
        }
    }

    /**
     * Getting a list of frequently asked questions related to the project design by id
     *
     * @throws RuntimeException, when something wrong with getting faqs by project's id
     * @param project_id    identifier project
     * @return              a list of found objects-class Faq
     */
    @Override
    public List<Faq> get(int project_id) {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            List<Faq> result = new LinkedList<Faq>();
            ResultSet rs = statement.executeQuery("SELECT faq.question AS questions, faq.answer AS answers " +
                    "FROM faq where id in (select id_faq from projects_faq_maps where id_project = " + project_id + ")");
            while (rs.next()) {
                result.add(new Faq(rs.getString("questions"), rs.getString("answers")));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException("Something wrong with getting faqs by id", e);
        }
    }


    /**
     * Performs counting the number of records in the table "faqs"
     *
     * @throws RuntimeException, when something wrong while calculation faqs size
     * @return  number records found, 0 - no records
     */
    @Override
    public int size() {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select count(*) from faqs");
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException("Something wrong while calculation faqs size", e);
        }
    }
}
