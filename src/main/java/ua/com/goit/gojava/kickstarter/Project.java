package ua.com.goit.gojava.kickstarter;

public class Project {

	private int id;
	private String name;
	private Category category;
	private String description;
	private int collected;
	private int amount;
	private int days;
	private String history;
	private String video;

	private String questionAnswers;

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

	public Project(int id, String name, String description, int collected, int amount, int days, String history, String video) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.collected = collected;
		this.amount = amount;
		this.days = days;
		this.history = history;
		this.video = video;
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

	public int getDays() {
		return days;
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

	public String getQuestionAnswers() {
		return questionAnswers;
	}

	public void donate(int amount) { 
		this.amount -= amount;
	}

	public double getAmount() {
		return amount;
	}

	public String getVideo() {
		return video;
	}

	public double getCollected() {
		return collected;
	}
}
