package com.example.service.impl;

import com.example.dto.TaskDTO;
import com.example.entity.Project;
import com.example.entity.Role;
import com.example.entity.Task;
import com.example.entity.User;
import com.example.enums.Gender;
import com.example.enums.Status;
import com.example.mapper.ProjectMapper;
import com.example.mapper.TaskMapper;
import com.example.repository.TaskRepository;
import com.example.repository.UserRepository;
import com.example.service.TaskService;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {TaskServiceImpl.class})
@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {

    @MockBean
    private ProjectMapper projectMapper;

    @MockBean
    private UserRepository userRepository;

    @Mock
    TaskRepository taskRepository;

    @Mock
    TaskMapper taskMapper;

    @InjectMocks
    TaskServiceImpl taskService;

    @ParameterizedTest
    @ValueSource(longs = {1L, 2L, 3L, -5L})
    void findById_test(long id) {

        //Given
        Task task = new Task();

        when(taskRepository.findById(id)).thenReturn(Optional.of(task));
        when(taskMapper.convertToDTO(task)).thenReturn(new TaskDTO());

        //When
        taskService.findById(id);

        //Then
        //verify(taskRepository).findById(id);
        verify(taskRepository).findById(anyLong());
        //verify(taskMapper).convertToDTO(any(Task.class));
        verify(taskMapper).convertToDTO(task);

        //verify(taskRepository, never()).findById(-5L);
    }

    @Test
    void findById_bdd_test() {
        // Given
        Task task = new Task();
        given(taskRepository.findById(anyLong())).willReturn(Optional.of(task));
        given(taskMapper.convertToDTO(task)).willReturn(new TaskDTO());

        //When
        taskService.findById(anyLong());

        //Then
        then(taskRepository).should().findById(anyLong());
        then(taskRepository).should(never()).findById(-5L);
    }

    /**
     * Method under test: {@link TaskServiceImpl#update(TaskDTO)}
     */
    @Test
    void testUpdate() {
        Role role = new Role();
        role.setDescription("The characteristics of someone or something");
        role.setId(123L);
        role.setInsertDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        role.setInsertUserId(123L);
        role.setIsDeleted(true);
        role.setLastUpdateDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        role.setLastUpdateUserId(123L);

        User user = new User();
        user.setEnabled(true);
        user.setFirstName("Jane");
        user.setGender(Gender.MALE);
        user.setId(123L);
        user.setInsertDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setInsertUserId(123L);
        user.setIsDeleted(true);
        user.setLastName("Doe");
        user.setLastUpdateDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setLastUpdateUserId(123L);
        user.setPassWord("Pass Word");
        user.setPhone("4105551212");
        user.setRole(role);
        user.setUserName("janedoe");

        Role role1 = new Role();
        role1.setDescription("The characteristics of someone or something");
        role1.setId(123L);
        role1.setInsertDateTime(null);
        role1.setInsertUserId(123L);
        role1.setIsDeleted(true);
        role1.setLastUpdateDateTime(null);
        role1.setLastUpdateUserId(123L);

        User user1 = new User();
        user1.setEnabled(true);
        user1.setFirstName("Jane");
        user1.setGender(Gender.MALE);
        user1.setId(123L);
        user1.setInsertDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setInsertUserId(123L);
        user1.setIsDeleted(true);
        user1.setLastName("Doe");
        user1.setLastUpdateDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setLastUpdateUserId(123L);
        user1.setPassWord("Pass Word");
        user1.setPhone("4105551212");
        user1.setRole(role1);
        user1.setUserName("janedoe");

        Project project = new Project();
        project.setAssignedManager(user1);
        project.setEndDate(LocalDate.ofEpochDay(1L));
        project.setId(123L);
        project.setInsertDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        project.setInsertUserId(123L);
        project.setIsDeleted(true);
        project.setLastUpdateDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        project.setLastUpdateUserId(123L);
        project.setProjectCode("Project Code");
        project.setProjectDetail("Project Detail");
        project.setProjectName("Project Name");
        project.setProjectStatus(Status.OPEN);
        project.setStartDate(LocalDate.ofEpochDay(1L));

        Task task = new Task();
        task.setAssignedDate(LocalDate.ofEpochDay(1L));
        task.setAssignedEmployee(user);
        task.setId(123L);
        task.setInsertDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        task.setInsertUserId(123L);
        task.setIsDeleted(true);
        task.setLastUpdateDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        task.setLastUpdateUserId(123L);
        task.setProject(project);
        task.setTaskDetail("Task Detail");
        task.setTaskStatus(Status.OPEN);
        task.setTaskSubject("Hello from the Dreaming Spires");
        Optional<Task> ofResult = Optional.of(task);

        Role role2 = new Role();
        role2.setDescription("The characteristics of someone or something");
        role2.setId(123L);
        role2.setInsertDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        role2.setInsertUserId(123L);
        role2.setIsDeleted(true);
        role2.setLastUpdateDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        role2.setLastUpdateUserId(123L);

        User user2 = new User();
        user2.setEnabled(true);
        user2.setFirstName("Jane");
        user2.setGender(Gender.MALE);
        user2.setId(123L);
        user2.setInsertDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        user2.setInsertUserId(123L);
        user2.setIsDeleted(true);
        user2.setLastName("Doe");
        user2.setLastUpdateDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        user2.setLastUpdateUserId(123L);
        user2.setPassWord("Pass Word");
        user2.setPhone("4105551212");
        user2.setRole(role2);
        user2.setUserName("janedoe");

        Role role3 = new Role();
        role3.setDescription("The characteristics of someone or something");
        role3.setId(123L);
        role3.setInsertDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        role3.setInsertUserId(123L);
        role3.setIsDeleted(true);
        role3.setLastUpdateDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        role3.setLastUpdateUserId(123L);

        User user3 = new User();
        user3.setEnabled(true);
        user3.setFirstName("Jane");
        user3.setGender(Gender.MALE);
        user3.setId(123L);
        user3.setInsertDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        user3.setInsertUserId(123L);
        user3.setIsDeleted(true);
        user3.setLastName("Doe");
        user3.setLastUpdateDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        user3.setLastUpdateUserId(123L);
        user3.setPassWord("Pass Word");
        user3.setPhone("4105551212");
        user3.setRole(role3);
        user3.setUserName("janedoe");

        Project project1 = new Project();
        project1.setAssignedManager(user3);
        project1.setEndDate(LocalDate.ofEpochDay(1L));
        project1.setId(123L);
        project1.setInsertDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        project1.setInsertUserId(123L);
        project1.setIsDeleted(true);
        project1.setLastUpdateDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        project1.setLastUpdateUserId(123L);
        project1.setProjectCode("Project Code");
        project1.setProjectDetail("Project Detail");
        project1.setProjectName("Project Name");
        project1.setProjectStatus(Status.OPEN);
        project1.setStartDate(LocalDate.ofEpochDay(1L));

        Task task1 = new Task();
        task1.setAssignedDate(LocalDate.ofEpochDay(1L));
        task1.setAssignedEmployee(user2);
        task1.setId(123L);
        task1.setInsertDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        task1.setInsertUserId(123L);
        task1.setIsDeleted(true);
        task1.setLastUpdateDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        task1.setLastUpdateUserId(123L);
        task1.setProject(project1);
        task1.setTaskDetail("Task Detail");
        task1.setTaskStatus(Status.OPEN);
        task1.setTaskSubject("Hello from the Dreaming Spires");
        when(taskRepository.save((Task) org.mockito.Mockito.any())).thenReturn(task1);
        when(taskRepository.findById((Long) org.mockito.Mockito.any())).thenReturn(ofResult);

        Role role4 = new Role();
        role4.setDescription("The characteristics of someone or something");
        role4.setId(123L);
        role4.setInsertDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        role4.setInsertUserId(123L);
        role4.setIsDeleted(true);
        role4.setLastUpdateDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        role4.setLastUpdateUserId(123L);

        User user4 = new User();
        user4.setEnabled(true);
        user4.setFirstName("Jane");
        user4.setGender(Gender.MALE);
        user4.setId(123L);
        user4.setInsertDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        user4.setInsertUserId(123L);
        user4.setIsDeleted(true);
        user4.setLastName("Doe");
        user4.setLastUpdateDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        user4.setLastUpdateUserId(123L);
        user4.setPassWord("Pass Word");
        user4.setPhone("4105551212");
        user4.setRole(role4);
        user4.setUserName("janedoe");

        Role role5 = new Role();
        role5.setDescription("The characteristics of someone or something");
        role5.setId(123L);
        role5.setInsertDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        role5.setInsertUserId(123L);
        role5.setIsDeleted(true);
        role5.setLastUpdateDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        role5.setLastUpdateUserId(123L);

        User user5 = new User();
        user5.setEnabled(true);
        user5.setFirstName("Jane");
        user5.setGender(Gender.MALE);
        user5.setId(123L);
        user5.setInsertDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        user5.setInsertUserId(123L);
        user5.setIsDeleted(true);
        user5.setLastName("Doe");
        user5.setLastUpdateDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        user5.setLastUpdateUserId(123L);
        user5.setPassWord("Pass Word");
        user5.setPhone("4105551212");
        user5.setRole(role5);
        user5.setUserName("janedoe");

        Project project2 = new Project();
        project2.setAssignedManager(user5);
        project2.setEndDate(LocalDate.ofEpochDay(1L));
        project2.setId(123L);
        project2.setInsertDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        project2.setInsertUserId(123L);
        project2.setIsDeleted(true);
        project2.setLastUpdateDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        project2.setLastUpdateUserId(123L);
        project2.setProjectCode("Project Code");
        project2.setProjectDetail("Project Detail");
        project2.setProjectName("Project Name");
        project2.setProjectStatus(Status.OPEN);
        project2.setStartDate(LocalDate.ofEpochDay(1L));

        Task task2 = new Task();
        task2.setAssignedDate(LocalDate.ofEpochDay(1L));
        task2.setAssignedEmployee(user4);
        task2.setId(123L);
        task2.setInsertDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        task2.setInsertUserId(123L);
        task2.setIsDeleted(true);
        task2.setLastUpdateDateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        task2.setLastUpdateUserId(123L);
        task2.setProject(project2);
        task2.setTaskDetail("Task Detail");
        task2.setTaskStatus(Status.OPEN);
        task2.setTaskSubject("Hello from the Dreaming Spires");
        when(taskMapper.convertToEntity((TaskDTO) org.mockito.Mockito.any())).thenReturn(task2);
        taskService.update(new TaskDTO());
        verify(taskRepository).save((Task) org.mockito.Mockito.any());
        verify(taskRepository).findById((Long) org.mockito.Mockito.any());
        verify(taskMapper).convertToEntity((TaskDTO) org.mockito.Mockito.any());
    }


}