package camionero.servlet.admin;

import camionero.dao.DB;
import camionero.model.Driver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet({"drivers"})
public class DriverServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        final List<Driver> drivers = DB.getInstance().getDriverDAO().list(); // busca la lista

        req.setAttribute("drivers", drivers);

        req.getRequestDispatcher("/admin/drivers.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        //si el ID es distinto de nulo, llama al doDelete
        if (req.getParameter("id")!= null) {
            doDelete(req, resp);
            return;
        }

        // agarramos los datos posteados
        int dni = Integer.parseInt(req.getParameter("dni"));
        String firstName = req.getParameter("first_name");
        String lastName = req.getParameter("last_name");
        LocalDate birthDay = LocalDate.parse(req.getParameter("birth_date"));
        String licenseCategory = req.getParameter("license_category");
        int cellphone = Integer.parseInt(req.getParameter("cellphone"));

        // creamos el nuevo chofer
        Driver driver = new Driver(dni);
        driver.setFirstName(firstName);
        driver.setLastName(lastName);
        driver.setBirthDate(birthDay);
        driver.setLicenseCategory(licenseCategory);
        driver.setCellphone(String.valueOf(cellphone));

        // guardamos el nuevo camion
        DB.getInstance().getDriverDAO().insert(driver);

        // volvemos a cargar el listado de camiones
        req.setAttribute("msg", "Se guardo el nuevo chofer!");
        doGet(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // borro el chofer con ese id
        String id = req.getParameter("id");
        DB.getInstance().getDriverDAO().delete(Integer.parseInt(id));

        // volvemos a cargar el listado de camiones
        req.setAttribute("msg", "Se borro el chofer!");
        doGet(req, resp);
    }
}
