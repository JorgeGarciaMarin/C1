public class Container {
    int ID;
    int weight;
    String countryOrigin;
    boolean inspectedByCustoms;
    int priorityLevel;
    String contentDescription;
    String senderCompany;
    String receiverCompany;
    Container(int ID,int weight,String countryOrigin,boolean inspectedByCustoms,String contentDescription,String senderCompany,String receiverCompany){
        this.ID = ID;
        this.weight = weight;
        this.countryOrigin = countryOrigin;
        this.inspectedByCustoms = inspectedByCustoms;
        this.contentDescription = contentDescription;
        this.senderCompany = senderCompany;
        this.receiverCompany = receiverCompany;
    }
    Container(int priorityLevel){
        this.priorityLevel=priorityLevel;
    }
    public int getID() {
        return ID;
    }

    public void setId(int ID) {
        this.ID  = ID;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getCountryOrigin() {
        return countryOrigin;
    }

    public void setCountryOfOrigin(String countryOrigin) {
        this.countryOrigin = countryOrigin;
    }

    public boolean isInspectedByCustoms() {
        return inspectedByCustoms;
    }

    public void setInspectedByCustoms(boolean inspectedByCustoms) {
        this.inspectedByCustoms = inspectedByCustoms;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public String getContentDescription() {
        return contentDescription;
    }

    public void setContentDescription(String contentDescription) {
        this.contentDescription = contentDescription;
    }

    public String getSenderCompany() {
        return senderCompany;
    }

    public void setSenderCompany(String senderCompany) {
        this.senderCompany = senderCompany;
    }

    public String getReceiverCompany() {
        return receiverCompany;
    }

    public void setReceiverCompany(String receiverCompany) {
        this.receiverCompany = receiverCompany;
    }
    public String toString(){
        return "ID:"+ID+"\nWeight:"+weight+"\nPriority Level:"+priorityLevel+"\nCountry of Origin:"+countryOrigin+"\nContent Description:"+contentDescription
                +"\nSender Company:"+senderCompany+"\nReceiver Company:"+receiverCompany+"\nInspected by Customs:"+inspectedByCustoms;
    }
}
