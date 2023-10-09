package hw;

import java.time.LocalDate;
import java.time.Period;
//import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private long id;
    private String name;
    private List<Human> children;
    private List<Human> parents;
    Gender gender;
    LocalDate BirthData;
    LocalDate DeathData;
    private Human spouse;

    public Human(String name, Gender gender, LocalDate BirthDate, LocalDate DeathData, Human father, Human mother) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.BirthData = BirthDate;
        this.DeathData = DeathData;

        parents = new ArrayList<>();
        if (father != null) {
            parents.add(father);
        }
        if (mother != null) {
            parents.add(mother);
        }
        children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate BirthData) {
        this(name, gender, BirthData, null, null, null);
    }

    public Human(String name, Gender gender, LocalDate BirthData, Human father, Human mother) {
        this(name, gender, BirthData, null, father, mother);
    }

    public boolean AddChildren(Human child) {
        if (!children.contains((child))) {
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean AddParent(Human parent) {
        if (!parents.contains((parent))) {
            parents.add(parent);
            return true;
        }
        return false;
    }

    public Human getFather() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.Male) {
                return parent;
            }
        }
        return null;
    }

    public Human getMother() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.Female) {
                return parent;
            }
        }
        return null;
    }

    public int getAge() {
        if (DeathData == null) {
            return getPeriod(BirthData, LocalDate.now());
        } else {
            return getPeriod(BirthData, DeathData);
        }
    }

    private int getPeriod(LocalDate birthDate, LocalDate deathDate) {
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }

    public long getId() {
        return id;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public Human getSpouse() {
        return spouse;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getBirthDate() {
        return BirthData;
    }

    public LocalDate getDeathDate() {
        return DeathData;
    }

    public List<Human> getParents() {
        return parents;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.BirthData = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.DeathData = deathDate;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return Info();
    }

    public String Info() {
        StringBuilder in = new StringBuilder();
        in.append("id: ");
        in.append(id);
        in.append(", name: ");
        in.append(name);
        in.append(", gender: ");
        in.append(gender);
        in.append(", age: ");
        in.append(getAge());
        in.append(", ");
        in.append(getSpouseInfo());
        in.append(", ");
        in.append(getMotherInfo());
        in.append(", ");
        in.append(getFatherInfo());
        in.append(", ");
        in.append(getChildrenInfo());

        return in.toString();
    }

    public String getSpouseInfo() {
        String res = "spouse: ";
        if (spouse == null) {
            res += "No";
        } else {
            res += spouse.getName();
        }
        return res;
    }

    public String getMotherInfo() {
        String res = "mother: ";
        Human mother = getMother();
        if (mother != null) {
            res += mother.getName();
        } else {
            res += "unknown";
        }
        return res;
    }

    public String getFatherInfo() {
        String res = "father: ";
        Human father = getFather();
        if (father != null) {
            res += father.getName();
        } else {
            res += "unknown";
        }
        return res;
    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("children: ");
        if (children.size() != 0) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("there are no children");
        }
        return res.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }
}