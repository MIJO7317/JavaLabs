package JavaLabs.AccountantBot;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Function;

public class Employee {
    public enum Gender {MALE, FEMALE}

    public enum Role {STAFF, MANAGER, EXECUTIVE}

    public enum Dept {HUMAN_RESOURCES, MARKETING, SALES, FINANCE, LOGISTICS,
                      IT, PURCHASING, RESEARCH_AND_DEVELOPMENT}

    public Employee(String givenName, String surName, int age, Gender gender,
                    Role role, Dept dept, String eMail, String phone,
                    String address, String city, String state,
                    String stateCode) {
        this.givenName = givenName;
        this.surName = surName;
        this.age = age;
        this.gender = gender;
        this.role = role;
        this.dept = dept;
        this.eMail = eMail;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.stateCode = stateCode;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getSurName() {
        return surName;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public Role getRole() {
        return role;
    }

    public Dept getDept() {
        return dept;
    }

    public String getEMail() {
        return eMail;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getStateCode() {
        return stateCode;
    }

    public static ArrayList<Employee> createShortList() {
        String[] maleNames = {"Артём", "Александр", "Максим", "Даниил",
                "Дмитрий", "Иван", "Кирилл", "Никита", "Михаил", "Егор",
                "Матвей", "Андрей", "Илья", "Алексей", "Роман", "Сергей",
                "Владислав", "Ярослав", "Тимофей", "Арсений", "Денис",
                "Владимир", "Павел", "Глеб", "Константин", "Богдан", "Евгений",
                "Николай", "Степан", "Захар", "Тимур", "Марк", "Семён",
                "Фёдор", "Георгий", "Лев", "Антон", "Вадим", "Игорь", "Артур"};
        String[] femaleNames = {"София", "Анастасия", "Дарья", "Мария", "Анна",
                "Виктория", "Полина", "Елизавета", "Екатерина", "Ксения",
                "Валерия", "Варвара", "Александра", "Вероника", "Арина",
                "Алиса", "Алина", "Милана", "Маргарита", "Диана", "Ульяна",
                "Алёна", "Ангелина", "Кристина", "Юлия", "Кира", "Ева",
                "Карина", "Василиса", "Ольга", "Ирина", "Таисия", "Евгения"};
        String[] maleSurNames = {"Иванов", "Васильев", "Петров", "Смирнов",
                "Михайлов", "Фёдоров", "Соколов", "Яковлев", "Попов",
                "Андреев", "Алексеев", "Александров", "Лебедев", "Григорьев",
                "Степанов", "Семёнов", "Павлов", "Богданов", "Николаев",
                "Дмитриев", "Егоров", "Волков", "Кузнецов", "Никитин",
                "Соловьёв", "Тимофеев", "Орлов", "Афанасьев", "Филиппов",
                "Сергеев", "Захаров", "Матвеев", "Виноградов", "Кузьмин",
                "Максимов", "Козлов", "Ильин", "Герасимов", "Марков",
                "Новиков", "Морозов", "Романов", "Осипов", "Макаров", "Зайцев",
                "Беляев", "Гаврилов", "Антонов", "Ефимов", "Леонтьев",
                "Давыдов", "Гусев", "Данилов", "Киселев", "Сорокин",
                "Тихомиров", "Крылов", "Никифоров", "Кондратьев", "Кудрявцев",
                "Борисов", "Жуков", "Воробьёв", "Щербаков", "Поляков",
                "Савельев", "Шмидт", "Трофимов", "Чистяков", "Баранов",
                "Сидоров", "Соболев", "Карпов", "Белов", "Миллер", "Титов",
                "Львов", "Фролов", "Игнатьев", "Комаров", "Прокофьев", "Быков",
                "Абрамов", "Голубев", "Пономарёв", "Покровский", "Мартынов",
                "Кириллов", "Шульц", "Миронов", "Фомин", "Власов", "Троицкий",
                "Федотов", "Назаров", "Ушаков", "Денисов", "Константинов",
                "Воронин", "Наумов"};
        String[] femaleSurNames = {"Иванова", "Васильева", "Петрова", "Смирнова",
                "Михайлова", "Фёдорова", "Соколова", "Яковлева", "Попова",
                "Андреева", "Алексеева", "Александрова", "Лебедева", "Григорьева",
                "Степанова", "Семенова", "Павлова", "Богданова", "Николаева",
                "Дмитриева", "Егорова", "Волкова", "Кузнецова", "Никитина",
                "Соловьёва", "Тимофеева", "Орлова", "Афанасьева", "Филиппова",
                "Сергеева", "Захарова", "Матвеева", "Виноградова", "Кузьмина",
                "Максимова", "Козлова", "Ильина", "Герасимова", "Маркова",
                "Новикова", "Морозова", "Романова", "Осипова", "Макарова", "Зайцева",
                "Беляева", "Гаврилова", "Антонова", "Ефимова", "Леонтьева",
                "Давыдова", "Гусева", "Данилова", "Киселёва", "Сорокина",
                "Тихомирова", "Крылова", "Никифорова", "Кондратьева", "Кудрявцева",
                "Борисова", "Жукова", "Воробьёва", "Щербакова", "Полякова",
                "Савельева", "Шмидт", "Трофимова", "Чистякова", "Баранова",
                "Сидорова", "Соболева", "Карпова", "Белова", "Миллер", "Титова",
                "Львова", "Фролова", "Игнатьева", "Комарова", "Прокофьева", "Быкова",
                "Абрамова", "Голубева", "Пономарёва", "Покровская", "Мартынова",
                "Кириллова", "Шульц", "Миронова", "Фомина", "Власова", "Троицкая",
                "Федотова", "Назарова", "Ушакова", "Денисова", "Константинова",
                "Воронина", "Наумова"};
        int minAge = 18;
        int maxFemaleAge = 56;
        int maxMaleAge = 61;
        String[] phoneCodes = {"903", "909", "963", "964", "965", "966", "967",
                "968", "989", "929", "900", "901", "902", "908", "953", "958"};
        String[] states = {"Амурская область", "Архангельская область",
                "Астраханская область", "Белгородская область",
                "Брянская область", "Владимирская область",
                "Волгоградская область", "Вологодская область",
                "Воронежская область", "Ивановская область",
                "Иркутская область", "Калининградская область",
                "Калужская область", "Камчатская область",
                "Кемеровская область", "Кировская область",
                "Костромская область", "Курганская область",
                "Курская область", "Ленинградская область",
                "Липецкая область", "Магаданская область",
                "Московская область", "Мурманская область",
                "Нижегородская область", "Новгородская область",
                "Новосибирская область", "Омская область",
                "Оренбургская область", "Орловская область",
                "Пензенская область", "Пермская область", "Псковская область",
                "Ростовская область", "Рязанская область", "Самарская область",
                "Саратовская область", "Сахалинская область",
                "Свердловская область", "Смоленская область",
                "Тамбовская область", "Тверская область", "Томская область",
                "Тульская область", "Тюменская область", "Ульяновская область",
                "Челябинская область", "Читинская область",
                "Ярославская область"};
        ArrayList<Employee> employees = new ArrayList<>();
        SecureRandom randomNumber = new SecureRandom();
        for (Dept dept : Dept.values()) {
            EmployeeBuilder builder = new EmployeeBuilder();
            String givenName = "";
            String surName = "";
            int quantityOfStaff = 3 + randomNumber.nextInt(8);
            for (int i = 0; i < quantityOfStaff; i++) {
                if(i == 0) {
                    builder.setRole(Role.EXECUTIVE);
                }
                else if(i > (quantityOfStaff-1)*0.77) {
                    builder.setRole(Role.MANAGER);
                }
                else {
                    builder.setRole(Role.STAFF);
                }
                builder.setDept(dept);
                switch (Gender.values()[randomNumber.nextInt(Gender.values().length)]) {
                    case MALE -> {
                        builder.setGender(Gender.MALE);
                        givenName = maleNames[randomNumber.nextInt(maleNames.length)];
                        surName = maleSurNames[randomNumber.nextInt(maleSurNames.length)];
                        builder.setGivenName(givenName);
                        builder.setSurName(surName);
                        builder.setAge(
                                randomNumber.nextInt(maxMaleAge - minAge + 1)
                                        + minAge);
                    }
                    case FEMALE -> {
                        builder.setGender(Gender.FEMALE);
                        givenName = femaleNames[randomNumber.nextInt(femaleNames.length)];
                        surName = femaleSurNames[randomNumber.nextInt(femaleSurNames.length)];
                        builder.setGivenName(givenName);
                        builder.setSurName(surName);
                        builder.setAge(
                                randomNumber.nextInt(maxFemaleAge - minAge + 1)
                                        + minAge);
                    }
                }
                Function<String, String> transliterate = (message) -> {
                    char[] abcCyr =   {' ','а','б','в','г','д','е','ё', 'ж','з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х', 'ц','ч', 'ш','щ','ъ','ы','ь','э', 'ю','я','А','Б','В','Г','Д','Е','Ё', 'Ж','З','И','Й','К','Л','М','Н','О','П','Р','С','Т','У','Ф','Х', 'Ц', 'Ч','Ш', 'Щ','Ъ','Ы','Ь','Э','Ю','Я','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
                    String[] abcLat = {" ","a","b","v","g","d","e","e","zh","z","i","y","k","l","m","n","o","p","r","s","t","u","f","h","ts","ch","sh","sch", "","i", "","e","ju","ja","A","B","V","G","D","E","E","Zh","Z","I","Y","K","L","M","N","O","P","R","S","T","U","F","H","Ts","Ch","Sh","Sch", "","I", "","E","Ju","Ja","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int j = 0; j < message.length(); j++) {
                        for (int x = 0; x < abcCyr.length; x++ ) {
                            if (message.charAt(j) == abcCyr[x]) {
                                stringBuilder.append(abcLat[x]);
                            }
                        }
                    }
                    return stringBuilder.toString();
                };
                String eMail = transliterate.apply(givenName.charAt(0) + surName) + "@mail.ru";
                builder.setEMail(eMail);
                String phone = "+7 (" + phoneCodes[randomNumber.nextInt(phoneCodes.length)] + ") "
                        + randomNumber.nextInt(10)
                        + randomNumber.nextInt(10)
                        + randomNumber.nextInt(10)
                        + "-"
                        + randomNumber.nextInt(10)
                        + randomNumber.nextInt(10)
                        + "-"
                        + randomNumber.nextInt(10)
                        + randomNumber.nextInt(10);
                builder.setPhone(phone);
                Document doc;
                String address = "NaN";
                String street;
                String house;
                String city = "NaN";
                String state = "NaN";
                try {
                    doc = Jsoup.connect("https://getfakedata.com/address/ru_RU").get();
                    street = doc.body().getElementsByTag("textarea").get(0).text().split("\n")[0].split(",")[3].trim();
                    house = doc.body().getElementsByTag("textarea").get(0).text().split("\n")[0].split(",")[4].trim();
                    city = doc.body().getElementsByTag("textarea").get(0).text().split("\n")[0].split(",")[2].trim();
                    int statePosition = randomNumber.nextInt(states.length);
                    builder.setStateCode(String.valueOf(28 + statePosition));
                    state = states[statePosition];
                    address = street + ", " + house;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                builder.setAddress(address);
                builder.setCity(city);
                builder.setState(state);
                employees.add(builder.getResult());
            }
        }
        return employees;
    }

    @Override
    public String toString() {
        return "Имя:\t\t\t\t" + givenName + '\n' +
               "Фамилия:\t\t\t" + surName + '\n' +
               "Возраст:\t\t\t" + age + '\n' +
               "Пол:\t\t\t\t" + (gender.equals(Gender.MALE) ? "Мужской" : "Женский") + '\n' +
               "Роль:\t\t\t\t" + (role.equals(Role.STAFF) ? "Сотрудник" :
                                  role.equals(Role.MANAGER) ? "Менеджер" :
                                  role.equals(Role.EXECUTIVE) ? "Администратор" : "") + '\n' +
               "Отдел:\t\t\t\t" + (dept.equals(Dept.IT) ? "IT" :
                                   dept.equals(Dept.FINANCE) ? "Финансов" :
                                   dept.equals(Dept.HUMAN_RESOURCES) ? "Кадров" :
                                   dept.equals(Dept.LOGISTICS) ? "Логистики" :
                                   dept.equals(Dept.MARKETING) ? "Маркетинга" :
                                   dept.equals(Dept.PURCHASING) ? "Закупок" :
                                   dept.equals(Dept.RESEARCH_AND_DEVELOPMENT) ? "Исследования и развития" :
                                   dept.equals(Dept.SALES) ? "Продаж" : "") + '\n' +
               "Электронная почта:\t" + eMail + '\n' +
               "Телефон:\t\t\t" + phone + '\n' +
               "Адрес:\t\t\t\t" + address + '\n' +
               "Город:\t\t\t\t" + city + '\n' +
               "Область:\t\t\t" + state + '\n' +
               "Код области:\t\t" + stateCode + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getAge() == employee.getAge()
                && Objects.equals(getGivenName(), employee.getGivenName())
                && Objects.equals(getSurName(), employee.getSurName())
                && getGender() == employee.getGender()
                && getRole() == employee.getRole()
                && Objects.equals(getDept(), employee.getDept())
                && Objects.equals(getEMail(), employee.getEMail())
                && Objects.equals(getPhone(), employee.getPhone())
                && Objects.equals(getAddress(), employee.getAddress())
                && Objects.equals(getCity(), employee.getCity())
                && Objects.equals(getState(), employee.getState())
                && Objects.equals(getStateCode(), employee.getStateCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGivenName(), getSurName(), getAge(),
                getGender(), getRole(), getDept(), getEMail(), getPhone(),
                getAddress(), getCity(), getState(), getStateCode());
    }

    private final String givenName;
    private final String surName;
    private final int age;
    private final Gender gender;
    private final Role role;
    private final Dept dept;
    private final String eMail;
    private final String phone;
    private final String address;
    private final String city;
    private final String state;
    private final String stateCode;
}
