package edu.msudenver.cs3250.group6.msubanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.msudenver.cs3250.group6.msubanner.entities.*;
import edu.msudenver.cs3250.group6.msubanner.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

/**
 * The msubanner application.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({ "edu" })
public class MsubannerApplication extends WebSecurityConfigurerAdapter
        implements CommandLineRunner {

    /** The section repository. */
    @Autowired
    private SectionRepository sectionRepository;

    /** The course repository. */
    @Autowired
    private CourseRepository courseRepository;

    /** The user repository. */
    @Autowired
    private UserRepository userRepository;

    /** The building repository. */
    @Autowired
    private BuildingRepository buildingRepository;

    /** The department repository. */
    @Autowired
    private DepartmentRepository departmentRepository;

    /** The room repository. */
    @Autowired
    private RoomRepository roomRepository;

    /** The schedule repository. */
    @Autowired
    private ScheduleRepository scheduleRepository;

    /** The hour block repository. */
    @Autowired
    private HourBlockRepository hourBlockRepository;

    /** The semester repository. */
    @Autowired
    private SemesterRepository semesterRepository;

    /** The professor repository. */
    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentRepository enrollmentRepository;
    /**
     * Starts the spring application.
     *
     * @param args the args
     */
    public static void main(final String[] args) {
        SpringApplication.run(MsubannerApplication.class, args);
    }

    @Override
    public final void run(final String... args) throws Exception {
        System.out.println("\n\n\n----------\nWorking Directory = "
                + System.getProperty("user.dir") + "\n\n\n\n");

        sectionRepository.deleteAll();
        courseRepository.deleteAll();
        userRepository.deleteAll();
        buildingRepository.deleteAll();
        roomRepository.deleteAll();
        departmentRepository.deleteAll();
        scheduleRepository.deleteAll();
        hourBlockRepository.deleteAll();
        semesterRepository.deleteAll();
        professorRepository.deleteAll();
        studentRepository.deleteAll();
        enrollmentRepository.deleteAll();


        Department department = new Department("Placeholder department");
        departmentRepository.save(department);

        Semester semester = new Semester();
        semesterRepository.save(semester);

        Section section = new Section();
        section.setId("900123456");

        Course course = new Course();
        course.setId("4250");
        course.setTitle("Bla");
        course.setCredits(2);
        course.setLearningObjectives("none");
        course.setDepartment(department);
        courseRepository.save(course);



        Student student = new Student();
        student.setId("9002");
        student.setFirstName("Gary");
        student.setLastName("Harmon");
        userRepository.save(student);
        enrollmentRepository.save(student);
        studentRepository.save(student);

        Professor prof = new Professor();
        prof.setId("65");
        prof.setFirstName("TBA");
        prof.setLastName("TBA");
        userRepository.save(prof);
        professorRepository.save(prof);

        section.setProfessor(prof);
        section.setCourse(course);
        sectionRepository.save(section);

        Building building = new Building();
        building.setBuildingName("Central");
        building.setId("1488");
        buildingRepository.save(building);

        Room room = new Room();
        room.setId("54564");
        room.setRoomNumber(42);
        room.setBuilding(building);
        roomRepository.save(room);

        HourBlock block = new HourBlock(6, 1);
        hourBlockRepository.save(block);

        List<Days.Day> days = new ArrayList<>(Arrays.asList(
                new Days.Day[] {Days.Day.MONDAY, Days.Day.WEDNESDAY }));

        Schedule schedule = new Schedule();
        schedule.setScheduleName("Schedule 1");
        schedule.setRoom(room);
        schedule.setBuilding(building);
        schedule.setSemester(semester);
        schedule.setId("4512");
        schedule.setDuration(2);
        // schedule.setHours("3:00 AM to 5:00 AM");
        schedule.setHourBlock(block);
        schedule.setDays(days);
        schedule.setStartDate("YYYY/MM/DD");
        scheduleRepository.save(schedule);



    }

    /**
     * Config for Authentication.
     *
     * @param http HttpSecurity
     * @throws Exception if login unsuccessful
     */
    @Override
    protected final void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/login", "/error", "/static/**").permitAll()
                .antMatchers("/**").authenticated()
                .and().exceptionHandling()
                .authenticationEntryPoint(new
                        LoginUrlAuthenticationEntryPoint("/login"));
    }

}
