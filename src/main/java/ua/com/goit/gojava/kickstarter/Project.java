package ua.com.goit.gojava.kickstarter;

public class Project {

	private int id; 
	private String name;
	private int amount;
	private int days;
	private Category category;
	private String description;
	private int exist;
	private String history;
	private String demoVideo;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + "]";
	}

	private String questionAnswers;

	public Project(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Project(int id, String name, int amount, int days, String demoVideo, String description) {
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.days = days;
		this.description = description;
		this.exist = 0;
		this.demoVideo = demoVideo; 
		this.history = null;
		this.questionAnswers = null;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public void setHistory(String history) {
		this.history = history;
	}

	public Category getCategory() {
		return category;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getAmount() {
		return amount;
	}

	public int getExist() {
		return exist;
	}

	public int getDays() {
		return days;
	}
	
	public void setDemoVideo(String demoVideo) {
		this.demoVideo = demoVideo;
	}
	
	public void addQuestionAnswer(String questionAnswers) {
		if (this.questionAnswers == null) { // если там ничего нет, то надо добавить
			this.questionAnswers = questionAnswers;
		} else {
			this.questionAnswers += '\n' + questionAnswers; // думаю пока для начала хватит
		}
	}

	public String getHistory() {
		return history;
	}

	public String getDemoVideo() {
		return demoVideo;
	}

	public String getQuestionAnswers() {
		return questionAnswers;
	}

	public void donate(int amount) { 
		this.amount -= amount;
	}

}
