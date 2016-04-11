import java.util.ArrayList;
import java.util.Scanner;

class Main5 {
    
    //Refrigerator Magnets
    public static void main0(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> ret = new ArrayList();
        while(true) {
            String line = sc.nextLine();
            if("END".equals(line)) {
                break;
            }
            String newLine = line.replaceAll(" ","");
            char[] lineChar = newLine.toCharArray();
            boolean flag = true;
            for(int i = 0; i < lineChar.length; i++) {
                for(int j = i+1; j < lineChar.length; j++) {
                    if(lineChar[i] == lineChar[j]) {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) {
                ret.add(line);
            }
        }
        for(String a: ret) {
            System.out.println(a);
        }
    }
   
    // Grade School Multiplication
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = 1;
        while(true) {
            long first = sc.nextInt();
            long second = sc.nextInt();
            if(first == 0 && second == 0) {
                break;
            }
            
            System.out.print("Problem ");
            System.out.println(number);
            
            long solution = first * second;

            for(int i = 0; i < String.valueOf(solution).length() - String.valueOf(first).length(); i++) {
                System.out.print(" ");
            }
            System.out.println(first);
            for(int i = 0; i < String.valueOf(solution).length() - String.valueOf(second).length(); i++) {
                System.out.print(" ");
            }
            System.out.println(second);
            for(int i = 0; i < String.valueOf(solution).length(); i++) {
                System.out.print("-");
            }
            
            int counter = 0;
            String digit = "";
            String middle = "";
            int numZero = 0;
            for(int i = String.valueOf(second).length()-1; i >= 0 ; i--) {
                int carriedDigit = 0;
                if(String.valueOf(second).charAt(i) == '0') {
                    digit = "0" + digit;
                    numZero++;
                } else {
                    for(int j = String.valueOf(first).length()-1; j >= 0 ; j--) {
                        int digit1 = Integer.parseInt(""+String.valueOf(second).charAt(i));
                        int digit2 = Integer.parseInt(""+String.valueOf(first).charAt(j));

                        int calculation = (digit1 * digit2) + carriedDigit;
                        if(calculation > 9 && j != 0) {
                            String calculationString = ""+String.valueOf(calculation);
                            String lastChar = calculationString.substring(calculationString.length()-1);
                            String everythingButLastChar = calculationString.substring(0,calculationString.length()-1);
                            int everythingButLastDigit = Integer.parseInt(everythingButLastChar);
                            carriedDigit = everythingButLastDigit;
                            digit = String.valueOf(lastChar) + digit;        
                        } else {
                            digit = String.valueOf(calculation) + digit;
                        }
                    }
                    middle += "\n";
                    for(int k = 0; k < String.valueOf(solution).length() - digit.length() - counter; k++) {
                        middle += " ";
                    }
                    middle += digit;
                    digit = "";
                    for(int q = 0; q < numZero; q++) {
                        counter++;
                    }
                    counter++;
                    numZero = 0;
                }
            }
            if(middle.indexOf("\n") != middle.lastIndexOf("\n")) {
                System.out.println(middle);
                for(int i = 0; i < String.valueOf(solution).length(); i++) {
                    System.out.print("-");
                }
            }
 
            System.out.println();
            System.out.println(solution);   
            number++;
        }
    }
    
    //Pizza Pricing
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menuNumber = 1;
        while(true) {
            int N = sc.nextInt();
            if(N == 0) {
                break;
            }
            int diameter = sc.nextInt();
            int price = sc.nextInt();
            double costPer = price/(Math.PI * Math.pow(diameter/2, 2));
            
            for(int i = 0; i < N-1; i++) {
                int D = sc.nextInt();
                int P = sc.nextInt();
                
                double area = Math.PI * Math.pow(D/2, 2);
                double costPerSquareInch = P/area;
                if(costPerSquareInch < costPer) {
                    diameter = D;
                    price = P;
                    costPer = costPerSquareInch;
                }
            }
            System.out.print("Menu ");
            System.out.print(menuNumber);
            System.out.print(": ");
            System.out.println(diameter);
            
            menuNumber++;
        }
    }
    
    //Sokoban
    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = 1;
        while(true) {
            int height = sc.nextInt();
            int width = sc.nextInt();
            if(height == 0 && width == 0) {
                break;
            }
            String[][] board = new String[height][width];
            sc.nextLine();
            for(int i = 0; i < height; i++) {
                char[] rowChars = sc.nextLine().toCharArray();
                for(int j = 0; j < width; j++) {
                    board[i][j] = ""+rowChars[j];
                }
            }
            boolean flag2 = false;
            char[] inputs = sc.nextLine().toCharArray();
            for(char i : inputs) {
                switch(i) {
                    case 'U':
                        moveUp(board);
                        break;
                    case 'D':
                        moveDown(board);
                        break;
                    case 'L':
                        moveLeft(board);
                        break;
                    case 'R':
                        moveRight(board);
                        break;
                }
                
                String ret = "";
                boolean flag = true;
                for(int k = 0; k < height; k++) {
                    for(int u = 0; u < width; u++) {
                        if ("b".equals(board[k][u]))
                            flag = false;
                        ret += board[k][u];
                    }
                    ret += "\n";
                }
                if (flag) {
                    System.out.println("Game " + number +": complete");
                    System.out.print(ret);
                    flag2 = true;
                    number++;
                    break;
                }
                
            }
            if(!flag2) {
                String ret = "";
                boolean flag = true;
                for(int i = 0; i < height; i++) {
                    for(int j = 0; j < width; j++) {
                        if ("b".equals(board[i][j]))
                            flag = false;
                        ret += board[i][j];
                    }
                    ret += "\n";
                }
                System.out.print("Game " + number +": ");
                if(flag) {
                    System.out.println("complete");
                } else {
                    System.out.println("incomplete");
                }
                System.out.print(ret);
                number++;
            }

        }
         
    }
    
    public static void moveUp(String[][] currentBoard) {
        for(int row = 0; row < currentBoard.length; row++) {
            for(int col = 0; col < currentBoard[row].length; col++) {
                
                if("W".equals(currentBoard[row][col].toUpperCase())) {
                    
                    if(row-1 > -1) {
                        
                        if("#".equals(currentBoard[row-1][col])) {
                            return;
                        }
                        
                        if("+".equals(currentBoard[row-1][col])) {
                            currentBoard[row-1][col] = "W";
                            if("W".equals(currentBoard[row][col])) {
                                currentBoard[row][col] = "+";
                            } else if ("w".equals(currentBoard[row][col])) {
                                currentBoard[row][col] = ".";
                            }
                            return;  
                        }
                        
                        if("b".equals(currentBoard[row-1][col])) {
                            if(row-2 > -1) {
                                if(".".equals(currentBoard[row-2][col])) {
                                    currentBoard[row-2][col] = "b";
                                    currentBoard[row-1][col] = "w";
                                    if("W".equals(currentBoard[row][col])) {
                                        currentBoard[row][col] = "+";
                                    } else if ("w".equals(currentBoard[row][col])) {
                                        currentBoard[row][col] = ".";
                                    }
                                } else if ("+".equals(currentBoard[row-2][col])) {
                                    currentBoard[row-2][col] = "B";
                                    currentBoard[row-1][col] = "w";          
                                    if("W".equals(currentBoard[row][col])) {
                                        currentBoard[row][col] = "+";
                                    } else if ("w".equals(currentBoard[row][col])) {
                                        currentBoard[row][col] = ".";
                                    }  
                                } 
                                return;    
                            }   
                        }
                        
                        if("B".equals(currentBoard[row-1][col])) {
                            if(row-2 > -1) {
                                if(".".equals(currentBoard[row-2][col])) {
                                    currentBoard[row-2][col] = "b";
                                    currentBoard[row-1][col] = "W";
                                    if("W".equals(currentBoard[row][col])) {
                                        currentBoard[row][col] = "+";
                                    } else if ("w".equals(currentBoard[row][col])) {
                                        currentBoard[row][col] = ".";
                                    }
                                } else if ("+".equals(currentBoard[row-2][col])) {
                                    currentBoard[row-2][col] = "B";
                                    currentBoard[row-1][col] = "W";          
                                    if("W".equals(currentBoard[row][col])) {
                                        currentBoard[row][col] = "+";
                                    } else if ("w".equals(currentBoard[row][col])) {
                                        currentBoard[row][col] = ".";
                                    }  
                                } 
                                return;    
                            }   
                        }
                        
                        if(".".equals(currentBoard[row-1][col])) {
                            currentBoard[row-1][col] = "w";
                            if("W".equals(currentBoard[row][col])) {
                                currentBoard[row][col] = "+";
                            } else if ("w".equals(currentBoard[row][col])) {
                                currentBoard[row][col] = ".";
                            }
                            return;  
                        }
                        return;
                    } 
                }
            }
        }
    }
    
    public static void moveDown(String[][] currentBoard) {
        for(int row = 0; row < currentBoard.length; row++) {
            for(int col = 0; col < currentBoard[row].length; col++) {
                
                if("W".equals(currentBoard[row][col].toUpperCase())) {
                    
                    if(row+1 < currentBoard.length) {
                        
                        if("#".equals(currentBoard[row+1][col])) {
                            return;
                        }
                        
                        if("+".equals(currentBoard[row+1][col])) {
                            currentBoard[row+1][col] = "W";
                            if("W".equals(currentBoard[row][col])) {
                                currentBoard[row][col] = "+";
                            } else if ("w".equals(currentBoard[row][col])) {
                                currentBoard[row][col] = ".";
                            }
                            return;  
                        }
                        
                        if("b".equals(currentBoard[row+1][col])) {
                            if(row+2 < currentBoard.length) {
                                if(".".equals(currentBoard[row+2][col])) {
                                    currentBoard[row+2][col] = "b";
                                    currentBoard[row+1][col] = "w";
                                    if("W".equals(currentBoard[row][col])) {
                                        currentBoard[row][col] = "+";
                                    } else if ("w".equals(currentBoard[row][col])) {
                                        currentBoard[row][col] = ".";
                                    }
                                } else if ("+".equals(currentBoard[row+2][col])) {
                                    currentBoard[row+2][col] = "B";
                                    currentBoard[row+1][col] = "w";          
                                    if("W".equals(currentBoard[row][col])) {
                                        currentBoard[row][col] = "+";
                                    } else if ("w".equals(currentBoard[row][col])) {
                                        currentBoard[row][col] = ".";
                                    }  
                                } 
                                return;    
                            }   
                        }
                        
                        if("B".equals(currentBoard[row+1][col])) {
                            if(row+2 < currentBoard.length) {
                                if(".".equals(currentBoard[row+2][col])) {
                                    currentBoard[row+2][col] = "b";
                                    currentBoard[row+1][col] = "W";
                                    if("W".equals(currentBoard[row][col])) {
                                        currentBoard[row][col] = "+";
                                    } else if ("w".equals(currentBoard[row][col])) {
                                        currentBoard[row][col] = ".";
                                    }
                                } else if ("+".equals(currentBoard[row+2][col])) {
                                    currentBoard[row+2][col] = "B";
                                    currentBoard[row+1][col] = "W";          
                                    if("W".equals(currentBoard[row][col])) {
                                        currentBoard[row][col] = "+";
                                    } else if ("w".equals(currentBoard[row][col])) {
                                        currentBoard[row][col] = ".";
                                    }  
                                } 
                                return;    
                            }   
                        }
                        
                        if(".".equals(currentBoard[row+1][col])) {
                            currentBoard[row+1][col] = "w";
                            if("W".equals(currentBoard[row][col])) {
                                currentBoard[row][col] = "+";
                            } else if ("w".equals(currentBoard[row][col])) {
                                currentBoard[row][col] = ".";
                            }
                            return;  
                        }
                        return;
                    } 
                }
            }
        }
    }
    
    public static void moveRight(String[][] currentBoard) {
        for(int row = 0; row < currentBoard.length; row++) {
            for(int col = 0; col < currentBoard[row].length; col++) {
                
                if("W".equals(currentBoard[row][col].toUpperCase())) {
                    
                    if(col+1 < currentBoard[row].length) {
                        
                        if("#".equals(currentBoard[row][col+1])) {
                            return;
                        }
                        
                        if("+".equals(currentBoard[row][col+1])) {
                            currentBoard[row][col+1] = "W";
                            if("W".equals(currentBoard[row][col])) {
                                currentBoard[row][col] = "+";
                            } else if ("w".equals(currentBoard[row][col])) {
                                currentBoard[row][col] = ".";
                            }
                            return;  
                        }
                        
                        if("b".equals(currentBoard[row][col+1])) {
                            if(col+2 < currentBoard[row].length) {
                                if(".".equals(currentBoard[row][col+2])) {
                                    currentBoard[row][col+2] = "b";
                                    currentBoard[row][col+1] = "w";
                                    if("W".equals(currentBoard[row][col])) {
                                        currentBoard[row][col] = "+";
                                    } else if ("w".equals(currentBoard[row][col])) {
                                        currentBoard[row][col] = ".";
                                    }
                                } else if ("+".equals(currentBoard[row][col+2])) {
                                    currentBoard[row][col+2] = "B";
                                    currentBoard[row][col+1] = "w";          
                                    if("W".equals(currentBoard[row][col])) {
                                        currentBoard[row][col] = "+";
                                    } else if ("w".equals(currentBoard[row][col])) {
                                        currentBoard[row][col] = ".";
                                    }  
                                } 
                                return;    
                            }   
                        }
                        
                        if("B".equals(currentBoard[row][col+1])) {
                            if(col+2 < currentBoard[row].length) {
                                if(".".equals(currentBoard[row][col+2])) {
                                    currentBoard[row][col+2] = "b";
                                    currentBoard[row][col+1] = "W";
                                    if("W".equals(currentBoard[row][col])) {
                                        currentBoard[row][col] = "+";
                                    } else if ("w".equals(currentBoard[row][col])) {
                                        currentBoard[row][col] = ".";
                                    }
                                } else if ("+".equals(currentBoard[row][col+2])) {
                                    currentBoard[row][col+2] = "B";
                                    currentBoard[row][col+1] = "W";          
                                    if("W".equals(currentBoard[row][col])) {
                                        currentBoard[row][col] = "+";
                                    } else if ("w".equals(currentBoard[row][col])) {
                                        currentBoard[row][col] = ".";
                                    }  
                                } 
                                return;    
                            }   
                        }
                        
                        if(".".equals(currentBoard[row][col+1])) {
                            currentBoard[row][col+1] = "w";
                            if("W".equals(currentBoard[row][col])) {
                                currentBoard[row][col] = "+";
                            } else if ("w".equals(currentBoard[row][col])) {
                                currentBoard[row][col] = ".";
                            }
                            return;  
                        }
                        return;
                    } 
                }
            }
        }
    }
    
    public static void moveLeft(String[][] currentBoard) {
        for(int row = 0; row < currentBoard.length; row++) {
            for(int col = 0; col < currentBoard[row].length; col++) {
                
                if("W".equals(currentBoard[row][col].toUpperCase())) {
                    
                    if(col-1 > -1) {
                        
                        if("#".equals(currentBoard[row][col-1])) {
                            return;
                        }
                        
                        if("+".equals(currentBoard[row][col-1])) {
                            currentBoard[row][col-1] = "W";
                            if("W".equals(currentBoard[row][col])) {
                                currentBoard[row][col] = "+";
                            } else if ("w".equals(currentBoard[row][col])) {
                                currentBoard[row][col] = ".";
                            }
                            return;  
                        }
                        
                        if("b".equals(currentBoard[row][col-1])) {
                            if(col-2 > -1) {
                                
                                if(".".equals(currentBoard[row][col-2])) {
                                    currentBoard[row][col-2] = "b";
                                    currentBoard[row][col-1] = "w";
                                    if("W".equals(currentBoard[row][col])) {
                                        currentBoard[row][col] = "+";
                                    } else if ("w".equals(currentBoard[row][col])) {
                                        currentBoard[row][col] = ".";
                                    }
                                } else if ("+".equals(currentBoard[row][col-2])) {
                                    currentBoard[row][col-2] = "B";
                                    currentBoard[row][col-1] = "w";          
                                    if("W".equals(currentBoard[row][col])) {
                                        currentBoard[row][col] = "+";
                                    } else if ("w".equals(currentBoard[row][col])) {
                                        currentBoard[row][col] = ".";
                                    }  
                                } 
                                return;    
                            }   
                        }
                        
                        if("B".equals(currentBoard[row][col-1])) {
                            if(col-2 > -1) {
                                if(".".equals(currentBoard[row][col-2])) {
                                    currentBoard[row][col-2] = "b";
                                    currentBoard[row][col-1] = "W";
                                    if("W".equals(currentBoard[row][col])) {
                                        currentBoard[row][col] = "+";
                                    } else if ("w".equals(currentBoard[row][col])) {
                                        currentBoard[row][col] = ".";
                                    }
                                } else if ("+".equals(currentBoard[row][col-2])) {
                                    currentBoard[row][col-2] = "B";
                                    currentBoard[row][col-1] = "W";          
                                    if("W".equals(currentBoard[row][col])) {
                                        currentBoard[row][col] = "+";
                                    } else if ("w".equals(currentBoard[row][col])) {
                                        currentBoard[row][col] = ".";
                                    }  
                                } 
                                return;    
                            }   
                        }
                        
                        if(".".equals(currentBoard[row][col-1])) {
                            currentBoard[row][col-1] = "w";
                            if("W".equals(currentBoard[row][col])) {
                                currentBoard[row][col] = "+";
                            } else if ("w".equals(currentBoard[row][col])) {
                                currentBoard[row][col] = ".";
                            }
                            return;  
                        }
                        return;
                    } 
                }
            }
        }
    }


    
}
