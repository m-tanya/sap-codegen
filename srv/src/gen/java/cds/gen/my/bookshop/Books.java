package cds.gen.my.bookshop;

import com.sap.cds.CdsData;
import com.sap.cds.Struct;
import com.sap.cds.ql.CdsName;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;

@CdsName("my.bookshop.Books")
@Generated(
    value = "cds-maven-plugin",
    date = "2025-04-21T01:42:07.379322Z",
    comments = "com.sap.cds:cds-maven-plugin:3.7.1 / com.sap.cds:cds4j-api:3.7.0"
)
public interface Books extends CdsData {
  String ID = "ID";

  String TITLE = "title";

  String STOCK = "stock";

  String TEXTS = "texts";

  String LOCALIZED = "localized";

  @CdsName(ID)
  Integer getId();

  @CdsName(ID)
  void setId(Integer id);

  String getTitle();

  void setTitle(String title);

  Integer getStock();

  void setStock(Integer stock);

  List<BooksTexts> getTexts();

  void setTexts(List<? extends Map<String, ?>> texts);

  BooksTexts getLocalized();

  void setLocalized(Map<String, ?> localized);

  Books_ ref();

  static Books create() {
    return Struct.create(Books.class);
  }

  static Books of(Map<String, Object> map) {
    return Struct.access(map).as(Books.class);
  }

  static Books create(Integer id) {
    Map<String, Object> keys = new HashMap<>();
    keys.put(ID, id);
    return Struct.access(keys).as(Books.class);
  }
}
