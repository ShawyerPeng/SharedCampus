package converter;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.*;
import java.nio.charset.Charset;

public class GsonHttpMessageConverter extends AbstractHttpMessageConverter<Object> {
    private Gson gson = new Gson();

    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    public GsonHttpMessageConverter(){
        super(new MediaType("application", "json", DEFAULT_CHARSET));
    }

    @Override
    protected boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    protected Object readInternal(Class<?> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        try {
            return gson.fromJson(convertStreamToString(httpInputMessage.getBody()), aClass);
        } catch(JsonSyntaxException e) {
            throw new HttpMessageNotReadableException("Could not read JSON: " + e.getMessage(), e);
        }
    }

    @Override
    protected void writeInternal(Object o, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        String json = gson.toJson(o);
        httpOutputMessage.getBody().write(json.getBytes());
    }

    public String convertStreamToString(InputStream is) throws IOException {
        if (is != null) {
            Writer writer = new StringWriter();

            char[] buffer = new char[1024];
            try {
                Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            } finally {
                is.close();
            }
            return writer.toString();
        } else {
            return "";
        }
    }
}
// https://gxnotes.com/article/168097.html