package com.adiskerimov.spring.mvc_hibernate_aop.service;

import com.adiskerimov.spring.mvc_hibernate_aop.dao.*;
import com.adiskerimov.spring.mvc_hibernate_aop.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ServiceImpl implements ServiceI{

    @Autowired
    private AviaTicketDAO aviaTicketDAO;

    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    private ClassAviaDAO classAviaDAO;

    @Autowired
    private ClassHotelDAO classHotelDAO;

    @Autowired
    private ContractDAO contractDAO;

    @Autowired
    private CountryDAO countryDAO;

    @Autowired
    private EventDAO eventDAO;

    @Autowired
    private EventTicketDAO eventTicketDAO;

    @Autowired
    private HotelDAO hotelDAO;

    @Autowired
    private ClientDAO clientDAO;

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private PositionDAO positionDAO;

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private ProgramDAO programDAO;

    @Autowired
    private RoomDAO roomDAO;

    @Autowired
    private TourDAO tourDAO;

    @Autowired
    private TourFlightDAO tourFlightDAO;

    @Autowired
    private TouristDAO touristDAO;

    @Autowired
    private TourPackageDAO tourPackageDAO;

    @Autowired
    private TourTaskDAO tourTaskDAO;

    @Autowired
    private TourTypeDAO tourTypeDAO;

    @Override
    @Transactional
    public List<AviaTicket> getAllAviaTickets() {
        return aviaTicketDAO.getAll();
    }

    @Override
    @Transactional
    public void saveAviaTicket(AviaTicket aviaTicket) {
        aviaTicketDAO.save(aviaTicket);
    }

    @Override
    @Transactional
    public List<Category> getAllCategories() {
        return categoryDAO.getAll();
    }


    @Override
    @Transactional
    public void saveCategory(Category category) {
        categoryDAO.save(category);
    }

    @Override
    @Transactional
    public List<ClassAvia> getAllClassAvia() {
        return classAviaDAO.getAll();
    }

    @Override
    @Transactional
    public void saveClassAvia(ClassAvia classAvia) {
        classAviaDAO.save(classAvia);
    }

    @Override
    @Transactional
    public List<ClassHotel> getAllClassHotel() {
        return classHotelDAO.getAll();
    }

    @Override
    @Transactional
    public void saveClassHotel(ClassHotel classHotel) {
        classHotelDAO.save(classHotel);
    }

    @Override
    @Transactional
    public List<Contract> getAllContracts() {
        return contractDAO.getAll();
    }

    @Override
    @Transactional
    public void saveContract(Contract contract) {
        contractDAO.save(contract);
    }

    @Override
    @Transactional
    public List<Country> getAllCountries() {
        return countryDAO.getAll();
    }

    @Override
    @Transactional
    public void saveCountry(Country country) {
        countryDAO.save(country);
    }

    @Override
    @Transactional
    public List<Event> getAllEvents() {
        return eventDAO.getAll();
    }

    @Override
    @Transactional
    public void saveEvent(Event event){
        eventDAO.save(event);
    }

    @Override
    @Transactional
    public List<EventTicket> getAllEventTickets() {
        return eventTicketDAO.getAll();
    }

    @Override
    @Transactional
    public void saveEventTicket(EventTicket eventTicket){
        eventTicketDAO.save(eventTicket);
    }

    @Override
    @Transactional
    public List<Hotel> getAllHotels() {
        return hotelDAO.getAll();
    }

    @Override
    @Transactional
    public void saveHotel(Hotel hotel){
        hotelDAO.save(hotel);
    }


    @Override
    @Transactional
    public List<Client> getAllClients() {
        return clientDAO.getAllClients();
    }

    @Override
    @Transactional
    public void saveClient(Client client) {
        clientDAO.saveClient(client);
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public List<Position> getAllPositions() {
        return positionDAO.getAllPositions();
    }

    @Override
    @Transactional
    public void savePosition(Position position) {
        positionDAO.savePosition(position);
    }

    @Override
    @Transactional
    public List<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    @Override
    @Transactional
    public void saveOrder(Order order) {
        orderDAO.saveOrder(order);
    }

    @Override
    @Transactional
    public List<Program> getAllPrograms() {
        return programDAO.getAllPrograms();
    }

    @Override
    @Transactional
    public void saveProgram(Program program) {
        programDAO.saveProgram(program);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomDAO.getAllRooms();
    }

    @Override
    @Transactional
    public void saveRoom(Room room) {
        roomDAO.saveRoom(room);
    }

    @Override
    @Transactional
    public List<TourType> getAllTourTypes() {
        return tourTypeDAO.getAllTourTypes();
    }

    @Override
    @Transactional
    public void saveTourType(TourType tourType) {
        tourTypeDAO.saveTourType(tourType);
    }

    @Override
    @Transactional
    public List<TourTask> getAllTourTasks() {
        return tourTaskDAO.getAllTourTasks();
    }

    @Override
    @Transactional
    public void saveTourTask(TourTask tourTask) {
        tourTaskDAO.saveTourTask(tourTask);
    }

    @Override
    @Transactional
    public List<TourPackage> getAllTourPackages() {
        return tourPackageDAO.getAllTourPackages();
    }

    @Override
    @Transactional
    public void saveTourPackage(TourPackage tourPackage) {
        tourPackageDAO.saveTourPackage(tourPackage);
    }

    @Override
    @Transactional
    public List<Tourist> getAllTourists() {
        return touristDAO.getAllTourists();
    }

    @Override
    @Transactional
    public void saveTourist(Tourist tourist) {
        touristDAO.saveTourist(tourist);
    }

    @Override
    @Transactional
    public List<TourFlight> getAllTourFlights() {
        return tourFlightDAO.getAllTourFlights();
    }

    @Override
    @Transactional
    public void saveTourFlight(TourFlight tourFlight) {
        tourFlightDAO.saveTourFlight(tourFlight);
    }

    @Override
    @Transactional
    public List<Tour> getAllTours() {
        return tourDAO.getAllTours();
    }

    @Override
    @Transactional
    public void saveTour(Tour tour) {
        tourDAO.saveTour(tour);
    }
}
