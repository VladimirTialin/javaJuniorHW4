package org.example.jpa;

public class Program {
    private static final String [] nameBooks={"Властелин колец", "Гордость и предубеждение",
            "Тёмные начала", "Автостопом по галактике" , "Гарри Поттер и Кубок огня" , "Убить пересмешника" ,
            "Перед потопом" , "Река" , "Лев, колдунья и платяной шкаф" , "Джейн Эйр"};
    private static final String [] authorBooks={"Джон Р. Р. Толкин","Джейн Остин","Филип Пулман"
            ,"Дуглас Адамс","Джоан Роулинг","Харпер Ли","Алан Александр Милн","Алан Александр Милн"
            ,"Клайв Стэйплз Льюис","Шарлотта Бронте"};

    public static void main(String[] args) {
        JPA workBase=new JPA();
        workBase.addBook(new BookJPA(),authorBooks,nameBooks);
        workBase.queryBook();
    }
}
