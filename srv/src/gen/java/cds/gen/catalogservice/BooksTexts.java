package cds.gen.catalogservice;

import com.sap.cds.CdsData;
import com.sap.cds.Struct;
import com.sap.cds.ql.CdsName;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.Map;
import javax.annotation.processing.Generated;

@CdsName("CatalogService.Books.texts")
@Generated(
    value = "cds-maven-plugin",
    date = "2025-04-21T01:42:07.379322Z",
    comments = "com.sap.cds:cds-maven-plugin:3.7.1 / com.sap.cds:cds4j-api:3.7.0"
)
public interface BooksTexts extends CdsData {
  String LOCALE = "locale";

  String ID = "ID";

  String TITLE = "title";

  String getLocale();

  void setLocale(String locale);

  @CdsName(ID)
  Integer getId();

  @CdsName(ID)
  void setId(Integer id);

  String getTitle();

  void setTitle(String title);

  BooksTexts_ ref();

  static BooksTexts create() {
    return Struct.create(BooksTexts.class);
  }

  static BooksTexts of(Map<String, Object> map) {
    return Struct.access(map).as(BooksTexts.class);
  }
}
