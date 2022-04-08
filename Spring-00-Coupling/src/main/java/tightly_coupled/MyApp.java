package tightly_coupled;

public class MyApp {
    public static void main(String[] args) {
        FullTimeMentor fullTime = new FullTimeMentor();
        PartTimeMentor partTime = new PartTimeMentor();

        Mentor mentor = new Mentor(fullTime, partTime);
        mentor.manageAccount();
    }
}
