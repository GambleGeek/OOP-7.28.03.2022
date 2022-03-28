package com.adiskerimov.spring.mvc_hibernate_aop.service;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.*;

import java.util.List;

public interface ServiceI {

    public List<AviaTicket> getAllAviaTickets();

    public void saveAviaTicket(AviaTicket aviaTicket);

    public List<Category> getAllCategories();

    public void saveCategory(Category category);

    public List<ClassAvia> getAllClassAvia();

    public void saveClassAvia(ClassAvia classAvia);

    public List<ClassHotel> getAllClassHotel();

    public void saveClassHotel(ClassHotel classHotel);

    public List<Contract> getAllContracts();

    public void saveContract(Contract contract);

    public List<Country> getAllCountries();

    public void saveCountry(Country country);

    public List<Event> getAllEvents();

    public void saveEvent(Event event);

    public List<EventTicket> getAllEventTickets();

    public void saveEventTicket(EventTicket eventTicket);

    public List<Hotel> getAllHotels();

    public void saveHotel(Hotel hotel);


    public List<Client> getAllClients();

    public void saveClient(Client client);

    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public List<Position> getAllPositions();

    public void savePosition(Position position);

    public List<Order> getAllOrders();

    public void saveOrder(Order order);

    public List<Program> getAllPrograms();

    public void saveProgram(Program program);

    public List<Room> getAllRooms();

    public void saveRoom(Room room);

    public List<TourType> getAllTourTypes();

    public void saveTourType(TourType tourType);

    public List<TourTask> getAllTourTasks();

    public void saveTourTask(TourTask tourTask);

    public List<TourPackage> getAllTourPackages();

    public void saveTourPackage(TourPackage tourPackage);

    public List<Tourist> getAllTourists();

    public void saveTourist(Tourist tourist);

    public List<TourFlight> getAllTourFlights();

    public void saveTourFlight(TourFlight tourFlight);

    public List<Tour> getAllTours();

    public void saveTour(Tour tour);

    public Client getClient(int id);

    public void delete(int id);
}
