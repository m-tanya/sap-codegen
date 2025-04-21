package cds.gen.catalogservice;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.StructuredType;
import com.sap.cds.ql.cqn.CqnPredicate;
import java.lang.Integer;
import java.lang.String;
import java.util.function.Function;
import javax.annotation.processing.Generated;

@CdsName("CatalogService.Books")
@Generated(
    value = "cds-maven-plugin",
    date = "2025-04-21T01:42:07.379322Z",
    comments = "com.sap.cds:cds-maven-plugin:3.7.1 / com.sap.cds:cds4j-api:3.7.0"
)
public interface Books_ extends StructuredType<Books_> {
  String ID = "ID";

  String CDS_NAME = "CatalogService.Books";

  @CdsName(ID)
  ElementRef<Integer> ID();

  ElementRef<String> title();

  ElementRef<Integer> stock();

  BooksTexts_ texts();

  BooksTexts_ texts(Function<BooksTexts_, CqnPredicate> filter);

  BooksTexts_ localized();

  BooksTexts_ localized(Function<BooksTexts_, CqnPredicate> filter);
}
