# BookMappingAuthor
Implementation of Author Entity with Bidirectional Book Relationship  "Design and Implement the Author Entity with a One-to-Many Relationship to the Book Entity, including Bidirectional Mapping and Proper Annotations."

Mapping
Mapping with BasicJdbcConverter in Spring Data JDBC

The BasicJdbcConverter in Spring Data JDBC provides rich mapping support that allows you to map domain objects to database rows. This is achieved through a comprehensive metadata model, which can be populated using annotations on your domain objects. While annotations are commonly used, they are not the only source of metadata information. The BasicJdbcConverter also supports convention-based mapping, allowing you to map objects to rows without providing additional metadata.

This section explores the features of the BasicJdbcConverter, including how to use conventions for mapping objects to rows and how to override those conventions with annotation-based mapping metadata.

 Convention-Based Mapping

When no additional mapping metadata is provided, the BasicJdbcConverter follows a few conventions for mapping objects to database rows:

- Class Name to Table Name: The short Java class name is mapped to the table name. For instance, the `com.bigbank.SavingsAccount` class maps to the `SAVINGS_ACCOUNT` table. Similarly, field names are mapped to column names (e.g., `firstName` maps to `FIRST_NAME`).
- Naming Strategy: You can control the naming conventions by providing a custom `NamingStrategy`. For more details, refer to the "Mapping Configuration" section. By default, table and column names derived from property or class names are used in SQL statements without quotes. This behavior can be altered by setting `RelationalMappingContext.setForceQuote(true)`.
- Spring Converters: The converter uses any Spring Converters registered with `CustomConversions` to override the default mapping of object properties to row columns and values.
- Field Mapping: The fields of an object are used to convert to and from columns in the row. Public JavaBean properties are not used.
- Constructor Mapping: If a class has a single non-zero-argument constructor whose argument names match top-level column names in the row, that constructor is used. Otherwise, the zero-argument constructor is used. If there is more than one non-zero-argument constructor, an exception is thrown.

 Supported Types in Your Entity

The following types are supported for properties in your entity:

- All primitive types and their boxed equivalents (e.g., `int`, `Integer`).
- Enums (mapped to their name).
- `String`.
- Date and time types (`java.util.Date`, `java.time.LocalDate`, etc.).
- Arrays and Collections of supported types, if your database supports them.
- Any type accepted by your database driver.
- References to other entities, considered as one-to-one relationships or embedded types.

 Mapping Annotation Overview

The RelationalConverter can use metadata annotations to map objects to rows:

- @Id: Marks the primary key field.
- @Table: Indicates the class is a candidate for mapping to the database and allows specifying the table name.
- @Transient: Excludes the annotated field from being stored in the database.
- @PersistenceCreator: Marks a constructor or static factory method to be used for instantiating the object from the database.
- @Value: Allows using Spring Expression Language (SpEL) to transform a database value before constructing a domain object.
- @Column: Specifies a custom column name for a field.
- @Version: Used for optimistic locking, with automatic version incrementing on updates.

 Referenced Entities and Back References

References to other entities result in foreign key relationships in the database. The name of the foreign key column is derived from the table name of the referencing entity. You can customize this naming by implementing the `NamingStrategy.getReverseColumnName` method or by using the `@MappedCollection` annotation.

 Embedded Entities

Embedded entities allow value objects to be part of your Java data model, even if there is only one table in the database. The `@Embedded` annotation maps these objects, and the `onEmpty` attribute controls how null values are handled.

 Read-Only and Insert-Only Properties

- @ReadOnlyProperty: Attributes annotated with this will be read from the database but not written back.
- @InsertOnlyProperty: Attributes annotated with this will only be written during insert operations and ignored during updates.

 Custom Object Construction

The mapping subsystem allows customization of object construction using the `@PersistenceConstructor` annotation. This annotation can be used to map constructor parameters to row values, with the option to use SpEL expressions for more complex mappings.

 Overriding Mapping with Custom Converters

Spring Data allows the registration of custom converters to influence how values are mapped between the domain and the database. These converters can be registered with the `JdbcConverter`, and they allow for the conversion of properties at the field level.

For example, a `BooleanToStringConverter` can convert Boolean values to String representations in the database, and a `StringToBooleanConverter` can do the reverse.

 Conclusion

The BasicJdbcConverter in Spring Data JDBC provides powerful and flexible tools for mapping domain objects to database rows. Whether you rely on convention-based mapping or customize the mapping with annotations and converters, the BasicJdbcConverter can accommodate a wide range of use cases, ensuring that your data access layer is both robust and easy to maintain.






@Onetoone
Unidirectional

1.For eg if we create two entities one is student and other is laptop.
2.Give  annotation on laptop variable.
3.By using this keyword laptop id foreign key will build by hibernate in table automatically.
4.In this you can find laptop using student detaail but, you can not find student detail using laptop detail which called unidirectional one to one mappting.
	Class Student{
	@onetoone
	Private Laptop laptop;


}


@One toone
Bidirectional

1.For eg if we create two entities one is student and other is laptop.
2.Give  annotation on laptop variable also give  anotation in another class (laptop) on student class varriable
	Class Student{
	@onetoone
	Private Laptop laptop;


}
	Class Laptop{
	@onetoone
	Private Student student;


}


3.But whn we use only @anotation then it will always create forein key for each table.
4.So not to create foreign key we have to write syntax in such a way that 

	Class Student{
	@onetoone
	Private Laptop laptop;


}

 	Class Laptop{
	@onetoone(mappedby = “laptop”)
	Private Student student;


}

We can Also give name ti Join column foreign key column.

Class Student{
	@onetoone
	@JoinColumn(name = “ ”)
	Private Laptop laptop;


}
