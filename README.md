# SpringPracticeProject

Сделано просто для практики в использовании Spring boot, Spting data jpa.

Приложение позволяет создавать данные по заказу ремонтных работ.

Имеется 4 страницы:
 - Добавление клиента
 - Добавление исполнителя
 - Добавление заказа
 - Просмотр всех заказов


Главное меню:<br>
<img src="https://github.com/Sabronor/OrdersApp/blob/master/show/Main_menu.gif?raw=true" width="500"/><br>
Добавление клиента:<br>
<img src="https://github.com/Sabronor/OrdersApp/blob/master/show/add_customer.gif?raw=true" width="500"/><br>
Добавление исполнителя:<br>
<img src="https://github.com/Sabronor/OrdersApp/blob/master/show/add_executor.gif?raw=true" width="500"/><br>
Добавление заказа:<br>
<img src="https://github.com/Sabronor/OrdersApp/blob/master/show/add_order.gif?raw=true" width="500"/><br>
Просмотр заказов:<br>
<img src="https://github.com/Sabronor/OrdersApp/blob/master/show/display_orders.gif?raw=true" width="500"/><br>


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
