import java.util.Scanner;
import java.util.Arrays;
 class UserRegistration 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        String correctUsername = "myusername";
        String correctPassword = "mypassword";
        System.out.print("Enter your username: ");
        String enteredUsername = scanner.nextLine();
        System.out.print("Enter your password: ");
        String enteredPassword = scanner.nextLine();
        if (enteredUsername.equals(correctUsername) && enteredPassword.equals(correctPassword)) {
            System.out.println("Registration successful! You can access the exam.");
        } else {
            System.out.println("Registration failed. Incorrect username or password.");
        }
    }
}
class Exam 
{
    private String title;
    private Question[] questions;

    public Exam(String title, Question[] questions) 
    {
        this.title = title;
        this.questions = questions;
    }
    public String getTitle() 
    {
        return title;
    }
    public Question[] getQuestions() 
    {
        return questions;
    }
}

class Question {
    private String questionText;
    private String correctAnswer;

    public Question(String questionText, String correctAnswer)
    {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() 
    {
        return questionText;
    }

    public String getCorrectAnswer() 
    {
        return correctAnswer;
    }
}

class User
{
    private String username;
    private String password;

    public User(String username, String password) 
    {
        this.username = username;
        this.password = password;
    }
    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }
}

class AdminSystem
{
    public static void main(String[] args)
    {
        User[] users = new User[0];
        Exam[] exams = new Exam[0];
        Scanner scanner = new Scanner(System.in);
        while (true) 
        {
            System.out.println("Admin Panel:");
            System.out.println("1. Add User");
            System.out.println("2. Delete User");
            System.out.println("3. Add Exam");
            System.out.println("4. Add Question to Exam");
            System.out.println("5. Modify Correct Answer");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) 
            {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.next();
                    System.out.print("Enter password: ");
                    String password = scanner.next();
                    User newUser = new User(username, password);
                    users = Arrays.copyOf(users, users.length + 1);
                    users[users.length - 1] = newUser;
                    System.out.println("User added successfully.");
                    break;
                case 2:
                    System.out.print("Enter username to delete: ");
                    String usernameToDelete = scanner.next();
                    int userIndexToDelete = -1;
                    for (int i = 0; i < users.length; i++) 
                    {
                        if (users[i].getUsername().equals(usernameToDelete))
                        {
                            userIndexToDelete = i;
                            break;
                        }
                    }
                    if (userIndexToDelete != -1) 
                    {
                        User[] updatedUsers = new User[users.length - 1];
                        for (int i = 0, j = 0; i < users.length; i++) 
                        {
                            if (i != userIndexToDelete) {
                                updatedUsers[j] = users[i];
                                j++;
                            }
                        }
                        users = updatedUsers;
                        System.out.println("User deleted successfully.");
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter exam title: ");
                    String examTitle = scanner.next();
                    Exam newExam = new Exam(examTitle, new Question[0]);
                    exams = Arrays.copyOf(exams, exams.length + 1);
                    exams[exams.length - 1] = newExam;
                    System.out.println("Exam added successfully.");
                    break;
                case 4:
                    System.out.print("Enter the title of the exam to add a question to: ");
                    String examToAddQuestionTo = scanner.next();
                    int examIndex = -1;
                    for (int i = 0; i < exams.length; i++) 
                    {
                        if (exams[i].getTitle().equals(examToAddQuestionTo)) 
                        {
                            examIndex = i;
                            break;
                        }
                    }
                    if (examIndex != -1) 
                    {
                        System.out.print("Enter the question: ");
                        String questionText = scanner.next();
                        System.out.print("Enter the correct answer: ");
                        String correctAnswer = scanner.next();

                        Question newQuestion = new Question(questionText, correctAnswer);
                        Question[] updatedQuestions = Arrays.copyOf(exams[examIndex].getQuestions(), exams[examIndex].getQuestions().length + 1);
                        updatedQuestions[updatedQuestions.length - 1] = newQuestion;
                        exams[examIndex] = new Exam(exams[examIndex].getTitle(), updatedQuestions);

                        System.out.println("Question added to the exam.");
                    } else {
                        System.out.println("Exam not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter the title of the exam to modify an answer in: ");
                    String examToModifyAnswer = scanner.next();
                    int examToUpdateIndex = -1;
                    for (int i = 0; i < exams.length; i++) {
                        if (exams[i].getTitle().equals(examToModifyAnswer)) {
                            examToUpdateIndex = i;
                            break;
                        }
                    }
                    if (examToUpdateIndex != -1)
                    {
                        System.out.print("Enter the question to modify the answer for: ");
                        String questionToModify = scanner.next();
                        Question[] questions = exams[examToUpdateIndex].getQuestions();
                        int questionIndexToModify = -1;
                        for (int i = 0; i < questions.length; i++)
                        {
                            if (questions[i].getQuestionText().equals(questionToModify)) 
                            {
                                questionIndexToModify = i;
                                break;
                            }
                        }
                        if (questionIndexToModify != -1) 
                        {
                            System.out.print("Enter the new correct answer: ");
                            String newCorrectAnswer = scanner.next();
                            questions[questionIndexToModify] = new Question(questions[questionIndexToModify].getQuestionText(), newCorrectAnswer);
                            System.out.println("Correct answer modified successfully.");
                        } else {
                            System.out.println("Question not found in the selected exam.");
                        }
                    } else {
                        System.out.println("Exam not found.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting Admin Panel.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
public class ExamSystem 
{
    public static void main(String[] args) 
    {
        User[] users =
        {
            new User("User1", "password1"),
            new User("User2", "password2")
        };
        Exam[] exams = {
            new Exam("Math Exam", new Question[] 
            {
                new Question("What is 2 + 2?", "4"),
                new Question("What is 5 - 3?", "2")
            }),
            new Exam("Science Exam", new Question[] 
            {
                new Question("What is the chemical symbol for water?", "H2O"),
                new Question("What planet is known as the Red Planet?", "Mars")
            })
        };
        Result[] results = 
        {
            new Result(users[0], exams[0], 85),
            new Result(users[0], exams[1], 92),
            new Result(users[1], exams[0], 78),
        };
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("User Menu:");
            System.out.println("1. View All Exams");
            System.out.println("2. Check Result History");
            System.out.println("3. Take an Exam");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("Available Exams:");
                    for (Exam exam : exams)
                    {
                        System.out.println(exam.getTitle());
                    }
                    break;
                case 2:
                    System.out.print("Enter your username: ");
                    String username = scanner.next();
                    boolean found = false;
                    for (User user : users) 
                    {
                        if (user.getUsername().equals(username))
                        {
                            System.out.println("Result History for " + username + ":");
                            for (Result result : results) 
                            {
                                if (result.getUser() == user)
                                {
                                    System.out.println("Exam: " + result.getExam().getTitle() + ", Score: " + result.getScore());
                                }
                            }
                            found = true;
                            break;
                        }
                    }
                    if (!found) 
                    {
                        System.out.println("User not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter your username: ");
                    String usernameToTakeExam = scanner.next();
                    boolean userFound = false;
                    User takingUser = null;
                    
                    // Find the user who wants to take the exam
                    for (User user : users) 
                    {
                        if (user.getUsername().equals(usernameToTakeExam))
                        {
                            takingUser = user;
                            userFound = true;
                            break;
                        }
                    }
                    
                    if (userFound) 
                    {
                        System.out.println("Select an Exam to Take:");
                        for (int i = 0; i < exams.length; i++) {
                            System.out.println((i + 1) + ". " + exams[i].getTitle());
                        }
                        
                        int examChoice = scanner.nextInt();
                        if (examChoice >= 1 && examChoice <= exams.length) 
                        {
                            Exam selectedExam = exams[examChoice - 1];
                            Question[] questions = selectedExam.getQuestions();
                            int totalScore = 0;
                            
                            for (Question question : questions) 
                            {
                                System.out.println("Question: " + question.getQuestionText());
                                System.out.print("Your Answer: ");
                                String userAnswer = scanner.next();
                                
                                if (userAnswer.equals(question.getCorrectAnswer())) 
                                {
                                    System.out.println("Correct!");
                                    totalScore++;
                                } else {
                                    System.out.println("Wrong!");
                                }
                            }
                            
                            System.out.println("Exam completed. Total Score: " + totalScore);
                            results = Arrays.copyOf(results, results.length + 1);
                            results[results.length - 1] = new Result(takingUser, selectedExam, totalScore);
                        } 
                        else 
                        {
                            System.out.println("Invalid Exam Selection.");
                        }
                    } 
                    else 
                    {
                        System.out.println("User not found.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting Exam System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
class Result 
{
    private User user;
    private Exam exam;
    private int score;

    public Result(User user, Exam exam, int score) 
    {
        this.user = user;
        this.exam = exam;
        this.score = score;
    }

    public User getUser() 
    {
        return user;
    }

    public Exam getExam() 
    {
        return exam;
    }

    public int getScore() 
    {
        return score;
    }
}
