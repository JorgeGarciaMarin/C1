public class Hub {
    int hubID;
    Container[][] matrix;
    Hub(){
        matrix=new Container[10][12];
    }
    void setHubID(int hubID){
        this.hubID=hubID;
    }
    int getHubID(){
        return hubID;
    }
    void setMatrix(Container[][]matrix){
        this.matrix=matrix;
    }
    Container[][] getMatrix(){
        return matrix;
    }
    void stackContainer(Container toStack) throws FullPriorityLevel, NoPriorityLevel {
        int row = -1;
        int column = -1;
        if (toStack.priorityLevel==1) {
           column=0;
           for(int i=9;i>=0;i--){
               if(matrix[i][column]==null){
                   matrix[i][column]=toStack;
                   row=i;
                   System.out.println("Container Stacked:row"+row+" column:"+column);
                   break;
               }
           }
            if (row == -1)
                throw new FullPriorityLevel("Hub full for priority level");
        } else if (toStack.priorityLevel == 2) {
            column=1;
            for (int i=9;i>=0;i--){
                if(matrix[i][column]==null){
                    row=i;
                    matrix[row][column]=toStack;
                    System.out.println("Container Stacked:row"+row+" column:"+column);
                    break;
                }
            }

            if (row == -1)
                throw new FullPriorityLevel("Hub full for this priority level");
        } else if (toStack.priorityLevel == 3) {
            for (int i = 2; i < 12; i++) {
                for (int j = 9; j >=0; j--) {
                    if (matrix[j][i] == null) {
                        row = j;
                        column = i;
                        matrix[row][column] = toStack;
                        System.out.println("Container Stacked:row"+row+" column:"+column);
                        break;
                    }
                }
                if(row!=-1)
                    break;
            }
            if (row == -1)
                throw new FullPriorityLevel("Hub full for this priority level");
        }
        else
            throw new NoPriorityLevel("Select a Priority Level");
    }
    void removeContainer(int column) throws NoContainersException {
        int count=0;
        for (int i=0;i<10;i++){
            if(matrix[i][column]!=null) {
                matrix[i][column] = null;
                count++;
                System.out.println("Container removed from row"+i+",column"+column);
                break;
            }
        }
        if(count==0)
            throw new NoContainersException("No containers in this column");
    }
    String displayDataFromID(int ID){
      for (int i=0;i<10;i++){
          for (int j=0;j<12;j++){
              if(matrix[i][j]!=null && matrix[i][j].ID==ID){
                  return matrix[i][j].toString();
              }
          }
      }
        return "Container Not Found";
    }
    int containersByCountry(String country){
        int counter=0;
        for (int i=0;i<10;i++){
            for (int j=0;j<12;j++)
                if(matrix[i][j]!=null&&matrix[i][j].countryOrigin.equals(country))
                    counter++;
        }
        return counter;

    }
    public String toString(){
        StringBuilder builder=new StringBuilder();
        for (int i=0;i<10;i++){
            for (int j=0;j<12;j++){
                if(matrix[i][j]==null)
                    builder.append("|"+"E");
                else {
                    builder.append("|"+"C");
                }
            }
            builder.append("\n");
        }
        builder.append("\n"+"E:Empty"+"\n"+"C:Container");
        return builder.toString();
    }
    boolean full(){
        int counter=0;
        for (int i=0;i<10;i++){
            for (int j=0;j<12;j++){
                if(matrix[i][j]==null)
                    counter++;
            }
        }
        if(counter==0) {
            return true;
        } else
            return false;
    }
    //Method that returns information of the containers with weight less or equal that the one passed by argument as a String(using StringBuilder)
    String weightLessOrEqual(int hubNumber,int weightToCompare){
        StringBuilder builder=new StringBuilder();
        if(hubNumber==hubID){
            for (int i=0;i<10;i++){
                for (int j=0;j<12;j++){
                    if(matrix[i][j]!=null &&matrix[i][j].weight<=weightToCompare){
                        //it also sets the "inspectedByCustoms" attribute to true
                        matrix[i][j].inspectedByCustoms=true;
                        builder.append(matrix[i][j].displayForGivenWeight());
                    }
                    builder.append("\n");
                }
            }
        }
        else {
            builder.append("This hub´s ID does not match the entered hub number");
        }
        return builder.toString();
    }
}
