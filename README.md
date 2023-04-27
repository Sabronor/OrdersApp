# SpringPracticeProject

Сделано просто для практики в использовании Spring boot, Spting data jpa.

Приложение позволяет создавать данные по заказу ремонтных работ.

Имеется 4 страницы:
 - Добавление клиента
 - Добавление исполнителя
 - Добавление заказа
 - Просмотр всех заказов

Главное меню:
[Главное меню][]
[Добавление клиента][]
[Добавление исполнителя][]
[Добавление заказа][]
[Просмотр заказов][]


Main.class
```Java
@SpringBootApplication
public class OrdersAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdersAppApplication.class, args);
	}

}
```

База данных:
```mermaid
classDiagram
    executor <|-- work_type
    orders <|-- executor
    orders <|-- customer
    class customer{
      id
      name
      lastName
      city
      phone
    }
    class work_type{
      id
      type
    }
    class executor{
      id
      name
      lastName
      type
    }

    class orders{
        id
        customer_id
        executor_id
        work_type_id
    }
```
