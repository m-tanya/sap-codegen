package cds.gen.my.bookshop;

import com.sap.cds.ql.CdsName;
import java.lang.Class;
import java.lang.String;
import javax.annotation.processing.Generated;

@Generated(
    value = "cds-maven-plugin",
    date = "2025-04-21T01:42:07.379322Z",
    comments = "com.sap.cds:cds-maven-plugin:3.7.1 / com.sap.cds:cds4j-api:3.7.0"
)
@CdsName("my.bookshop")
public interface Bookshop_ {
  String CDS_NAME = "my.bookshop";

  Class<BooksTexts_> BOOKS_TEXTS = BooksTexts_.class;

  Class<Books_> BOOKS = Books_.class;
}
