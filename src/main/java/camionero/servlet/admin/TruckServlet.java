package camionero.servlet.admin;

import camionero.dao.DB;
import camionero.model.Truck;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"trucks"})
public class TruckServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("trucks", DB.getInstance().getTruckDAO().list());
        req.getRequestDispatcher("/admin/trucks.jsp").include(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // agarramos los datos posteados
        String plateNumber = req.getParameter("plate_number");
        String brand = req.getParameter("brand");
        // todo todos los datos

        // creamos el nuevo camion
        Truck truck = new Truck(Integer.parseInt(plateNumber));
        truck.setBrand(brand);
        // todo todos los datos

        // guardamos el nuevo camion
        DB.getInstance().getTruckDAO().insert(truck);

        // volvemos a cargar el listado de camiones
        req.setAttribute("msg", "Se guardo el nuevo camion!");
        doGet(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // borro el camion con ese id
        String id = req.getParameter("id");
        DB.getInstance().getTruckDAO().delete(Integer.parseInt(id));

        // volvemos a cargar el listado de camiones
        req.setAttribute("msg", "Se borro el camion!");
        doGet(req, resp);
    }
}

