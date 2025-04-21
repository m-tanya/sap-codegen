package cds.gen.catalogservice;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.StructuredType;
import java.lang.Integer;
import java.lang.String;
import javax.annotation.processing.Generated;

@CdsName("CatalogService.Books.texts")
@Generated(
    value = "cds-maven-plugin",
    date = "2025-04-21T01:42:07.379322Z",
    comments = "com.sap.cds:cds-maven-plugin:3.7.1 / com.sap.cds:cds4j-api:3.7.0"
)
public interface BooksTexts_ extends StructuredType<BooksTexts_> {
  String ID = "ID";

  String CDS_NAME = "CatalogService.Books.texts";

  ElementRef<String> locale();

  @CdsName(ID)
  ElementRef<Integer> ID();

  ElementRef<String> title();
}
