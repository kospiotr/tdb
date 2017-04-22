
def a = "/*\n" +
        " * created by: Piotr Kosmowski\n" +
        " * Template pack-custom:middleware/src/main/java/repository/EntityRepository.java.e.vm\n" +
        " */\n" +
        "package pl.xperios.tdb.repository;\n" +
        "\n" +
        "import java.util.List;\n" +
        "\n" +
        "import org.springframework.data.jpa.repository.JpaRepository;\n" +
        "import org.springframework.data.querydsl.QueryDslPredicateExecutor;\n" +
        "import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;\n" +
        "import org.springframework.data.repository.CrudRepository;\n" +
        "\n" +
        "import pl.xperios.tdb.domain.Department;\n" +
        "import pl.xperios.tdb.domain.Department_;\n" +
        "import pl.xperios.tdb.domain.QDepartment;\n" +
        "\n" +
        "public interface DepartmentRepository extends CrudRepository<Department, Long>, JpaRepository<Department, Long>, QueryDslPredicateExecutor<Department>,\n" +
        "        QuerydslBinderCustomizer<QDepartment> {\n" +
        "\n" +
        "}";
def b = "";
a.each {
    print(it + "" + it.bytes + "")
}