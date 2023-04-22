// SALONI SALIAN
// 13/12/21
// VERSION 1
// Final Version of the game

import java.util.Scanner; // Needed to make Scanner available
import java.util.Random;//Needed to make Random available
import java.io.*;//Needed to make io available

class Question//record to store the question and answer
{
  String question;
  String answer;
}

class Player//record to store a player's information
{
  String name;
  int place_on_board;
  int turn;
}

class mini1
{
  public static void main (String [] a) throws IOException
  {
    body();
    System.exit(0);
  }
  public static void print(String message)//method to print anything
  {
    System.out.println(message);
    return;
  }
  public static String answer()//method to accept and return the user's input
  {
    Scanner sc = new Scanner(System.in);
    String ans = sc.nextLine();
    return ans;
  }
  public static int answer_int()//method to accept and return the user's input
  {
    Scanner sc = new Scanner(System.in);
    int ans = sc.nextInt();
    return ans;
  }
public static Question setQuestion (String question, String answer)//method to initialise the Question record
  {
    Question qa = new Question();
    qa.question = question;
    qa.answer = answer;
    return qa;
  }
public static int roll()//method to get and return the user's position using a randomly generated value
  {
    Random dice = new Random();
    int diceroll = dice.nextInt(6)+1;
    return diceroll;
  }
public static String getAns (int index, Question [] questions)//gets the answer from the question bank
  {
    String answer = questions[index].answer;
    return answer;
  }
public static String getQn (int index, Question [] questions)//gets the question from the question bank
  {
    String question =questions[index].question;
    return question;
  }
public static Player setPlayer (String name, int pos, int turn )//method to initialise the Player record
  {
    Player p = new Player();
    p.name = name;
    p.place_on_board = pos;
    p.turn = turn;
    return p;
  }
  public static void createQB (Question questions[])//initialises and creates the question bank
  {
    questions[0] = setQuestion("What is the capital of France?","Paris");
    questions[1] = setQuestion("Which team won MCC 18?","Mustard Mummies");
    questions[2] = setQuestion("What color does blue and red make?","Purple");
    questions[3] = setQuestion("What is the smallest planet in the solar system?","Mercury");
    questions[4] = setQuestion("How many exponents does Avogadro's number have?","23");
    questions[5] = setQuestion("What 7 wonder of the world is located in India?","Taj Mahal");
    questions[6] = setQuestion("How many notes are there in a musical scale?","7");
    questions[7] = setQuestion("What is the technique that calls a method in a method?","Recursion");
    questions[8] = setQuestion("Which British actor will play Batman in the upcoming reboot directed by Matt Reeves?","Robert Pattinson");
    questions[9] = setQuestion("How many countries are there in the region of Europe (Recognised by the United Nations)?","44");
    return;
  }
  public static int newposition(int position, boolean flag, int place)//method to return the corresponding position based on if the user was correct or not
  {
    int new_position;
    if (flag==true)
    {
      print("Your answer is correct!");
      if(place > 0)
      {
        print("You encountered a secret corridor!");
        new_position = position + place;
      }
      else
      {
        new_position = position;
      }
    }
    else
    {
      print("Your answer is incorrect!");
      if(place < 0)
      {
        print("You encountered a secret trap!");
        new_position = position + place;
      }
      else
      {
        new_position = position - 1;
      }
    }
    return new_position;
  }
  public static void print_sorted(Player [] lead)//print the sorted positions
  {
    int n = lead.length;
    for(int i = 0; i < n; i++)
    {
      int y = 1+i;
      System.out.println(lead[i].name + " is in position " + y);
    }
    System.out.println();
    return;
  }
  public static void sort(Player [] lead)//sorting the positions in descending order using bubble sort
  {
    int n = lead.length;
    for (int i = 0; i < n-1; i++)
    {
      for (int j = 0; j < n-i-1; j++)
      {
        if (lead[j].place_on_board < lead[j+1].place_on_board)
        {
          Player temp = lead[j];
          lead[j] = lead[j+1];
          lead[j+1] = temp;
        }
      }
    }
    return;
  }
  public static boolean over(int position)//checks if a player goes out of the board
  {
    boolean flag = false;
    if (position>10)
    {
      print("Out of bounds");
      flag = true;
    }
    return flag;
  }
  public static void ini_board(int board[])//initialises the traps and corridors on the board
  {
    board[0] = 0;
    board[1] = 0;
    board[2] = -2;
    board[3] = 0;
    board[4] = 2;
    board[5] = -2;
    board[6] = 0;
    board[7] = 2;
    board[8] = 0;
    board[9] = 0;
    return;
  }
  public static boolean Right_or_Wrong(Question questions[], int position)//checks whether the answer inputted by a player is right or wrong
  {
    boolean flag = false;
    if(position == 1)
    {
      print(getQn(0,questions));
      String input = answer();
      print("Your answer is " + input);
      if(input.equalsIgnoreCase(getAns(0,questions)))
      {
        flag = true;
      }
    }
    else if (position == 2)
    {
      print(getQn(1,questions));
      String input = answer();
      print("Your answer is " + input);
      if(input.equalsIgnoreCase(getAns(1,questions)))
      {
        flag = true;
      }
    }
    else if (position == 3)
    {
      print(getQn(2,questions));
      String input = answer();
      print("Your answer is " + input);
      if(input.equalsIgnoreCase(getAns(2,questions)))
      {
        flag = true;
      }
    }
    else if (position == 4)
    {
      print(getQn(3,questions));
      String input = answer();
      print("Your answer is " + input);
      if(input.equalsIgnoreCase(getAns(3,questions)))
      {
        flag = true;
      }
    }
    else if (position == 5)
    {
      print(getQn(4,questions));
      int input = answer_int();
      print("Your answer is " + input);
      if(input == Integer.parseInt(getAns(4,questions)))
      {
        flag = true;
      }
    }
    else if (position == 6)
    {
      print(getQn(5,questions));
      String input = answer();
      print("Your answer is " + input);
      if(input.equalsIgnoreCase(getAns(5,questions)))
      {
        flag = true;
      }
    }
    else if (position == 7)
    {
      print(getQn(6,questions));
      int input = answer_int();
      print("Your answer is " + input);
      if(input == Integer.parseInt(getAns(6,questions)))
      {
        flag = true;
      }
    }
    else if (position == 8)
    {
      print(getQn(7,questions));
      String input = answer();
      print("Your answer is " + input);
      if(input.equalsIgnoreCase(getAns(7,questions)))
      {
        flag = true;
      }
    }
    else if (position == 9)
    {
      print(getQn(8,questions));
      String input = answer();
      print("Your answer is " + input);
      if(input.equalsIgnoreCase(getAns(8,questions)))
      {
        flag = true;
      }
    }
    else
    {
      print(getQn(9,questions));
      int input = answer_int();
      print("Your answer is " + input);
      if(input == Integer.parseInt(getAns(9,questions)))
      {
        flag = true;
      }
    }
    return flag;
  }
  public static void ori_position(Player lead[])
  {
    int n = lead.length;
    for (int i = 0; i < n-1; i++)
    {
      for (int j = 0; j < n-i-1; j++)
      {
        if (lead[j].turn > lead[j+1].turn)
        {
          Player temp = lead[j];
          lead[j] = lead[j+1];
          lead[j+1] = temp;
        }
      }
    }
  return;
  }
  public static void ini_leaderboard(Player leaderboard[])//initializes the leaderboard
  {
    int n = leaderboard.length;
    for(int i = 0 ; i<n; i++)
    {
      int turn = 1+i;
      print("What is your name?");
      String name = answer();
      leaderboard[i] = setPlayer(name,0,turn);
    }
    return;
  }
  public static void file_save(Player leaderboard[]) throws IOException//saves the users data to a .txt file
  {
    PrintWriter outputStream = new PrintWriter (new FileWriter("FileSave.txt"));
    int n = leaderboard.length;
    outputStream.println(n);
    for (int i = 0; i < n; i++)
    {
      outputStream.println(leaderboard[i].name);
      outputStream.println(leaderboard[i].place_on_board);
      outputStream.println(leaderboard[i].turn);
    }
    outputStream.close();
    return;
  }
  public static void save(String input, Player p[]) throws IOException//checks if the users wants to save their positions
  {
    if (input.equalsIgnoreCase("yes"))
    {
      ori_position(p);
      file_save(p);
      print("Your positions have been saved");
      System.exit(0);
    }
    else
      System.out.println();
    return;
  }
  public static void load(Player[] leaderboard, int[] current_position) throws IOException//loads the file
  {
    BufferedReader inputStream = new BufferedReader (new FileReader("FileSave.txt"));
    inputStream.readLine();
    int n = leaderboard.length;
    for (int i = 0; i < n; i++)
    {
      leaderboard[i] = new Player();
      leaderboard[i].name = inputStream.readLine();
      leaderboard[i].place_on_board = Integer.parseInt(inputStream.readLine());
      leaderboard[i].turn = Integer.parseInt(inputStream.readLine());
      last_positions(leaderboard,current_position,i);
    }
    inputStream.close();
    return;
  }
  public static void last_positions(Player[] leaderboard, int[] current_position, int index) throws IOException//stores the player's last position in the current position array
  {
    current_position[index]=leaderboard[index].place_on_board;
    return;
  }
  public static void body() throws IOException
  {
    print("Load last save?[yes/no]");
    String saved_game = answer();
    System.out.println();
    int [] current_position;
    int [] board = new int [10];
    Player [] leaderboard;
    Question questions[] = new Question[10];
    createQB(questions);
    ini_board(board);//initialises where the traps or corridors are held
    int farthest_position = 0;
    String Current_player = "";
    int number_players = 0;
    boolean flag = false;
    if(saved_game.equalsIgnoreCase("yes"))
    {
      BufferedReader inputStream = new BufferedReader (new FileReader("FileSave.txt"));
      number_players = Integer.parseInt(inputStream.readLine());
      inputStream.close();
      current_position = new int [number_players];
      leaderboard = new Player[number_players];
      load(leaderboard,current_position);
    }
    else
    {
      print("How many players are there?");
      number_players = answer_int();
      current_position = new int [number_players];
      leaderboard = new Player[number_players];
      ini_leaderboard(leaderboard);
    }
    while(farthest_position!=10)//loops until one of the players reaches the end of the board
    {
      for (int x = 1; x<= number_players; x++)//each person's turn
      {
        int y=x-1;//index
        Current_player = leaderboard[y].name;
        print("Player " + x + " is " + Current_player);
        int currentroll = roll();
        current_position [y] = current_position [y] + currentroll;//holds the current position of each player
        if (over(current_position [y])==true)//checks if the player goes out of the board
        {
          current_position [y] = current_position [y] - currentroll;//moves the player to their pre-roll position
          continue;
        }
        print("Your current position is " + current_position[y]);
        boolean correct = Right_or_Wrong(questions,current_position[y]);//checks if the players answer is right or wrong
        current_position[y] = newposition(current_position[y],correct,board[current_position[y]-1]);//gets the new position using the current position, if the user was correct and if they landed on a trap or a corridor
        print("You finish your turn in position " + current_position[y]);
        if(farthest_position < current_position[y])//checks the farthest position that a player has reached on the board
          farthest_position = current_position[y];
        leaderboard[y].place_on_board = current_position[y];//changes the players position on the board
        System.out.println();
        if(current_position[y]==10)
        {
          flag=true;
          break;
        }
      }
      if (flag)
      {
        break;
      }
      sort(leaderboard);
      print_sorted(leaderboard);
      ori_position(leaderboard);
      System.out.println("Do you want to quit and save your position[yes/no]?");
      save(answer(),leaderboard);
    }
    print("Congratulations to " + Current_player + " for winning");
    return;
  }
}
