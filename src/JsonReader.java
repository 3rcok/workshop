import java.io.*;
public class JsonReader {
    
    
    public static void main(String[] args){
        JsonReader reader = new JsonReader();
        String jsonString = reader.read();
        
    }
    

    private String read () {
        InputStream is = null;
        try {
            is = new FileInputStream("c://tmp//sample-utf8.json");
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        BufferedReader aReader = null;
        try {
            aReader = new BufferedReader(new InputStreamReader((InputStream)is, "UTF-8"));
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        String line  = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            while ((line = aReader.readLine()) != null ) {
                System.out.println(line);
                stringBuilder.append( line );
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                if (aReader != null) {
                    aReader.close();
                }
            } catch (IOException e) {
                    e.printStackTrace();            }
        }  
        return stringBuilder.toString();
        }
        
/*        
        private static HashMap<String, ErrorSpec> getMapFromJson(ErrorSpecUtil errSpecUtil, String jsonStr) {    
            HashMap<String, ErrorSpec> map = new HashMap<String, ErrorSpec>();
            JSONArray array = null;

            logger.log(Level.FINE, "Getting Map from JSON string ..");
            
            try {
                logger.log(Level.FINE, "Get JSON Array from JSON string");
                array = new JSONArray(jsonStr);
            } catch (JSONException e) {
                logger.log(Level.WARNING, e.getMessage());
                return null;
            }

            logger.log(Level.FINEST, "array.size()" + array.length());

            for (int i =0; i < array.length(); i++){

                JSONObject o = (JSONObject)array.optJSONObject(i);
                if (o == null) {
                    continue;
                }
                logger.log(Level.FINEST, (String)o.optString("ErrorCode"));
                String errorCode = (String)o.optString("ErrorCode");
                String errorId = (o.optString("ErrorId") == null ? "":(String)o.optString("ErrorId"));
     
                if (errorCode == null || errorCode.isEmpty() ||
                        errorId == null || errorId.isEmpty()){
                    continue;
                }

                String errorDetail = (String)o.optString("ErrorDetails");
                String cause = (String)o.optString("Cause");                               
                JSONArray actions = (JSONArray)o.optJSONArray("Action");              
                String[] actionsA = errSpecUtil.actionArrayConverter(actions);          
                JSONArray errorParams = (JSONArray)o.optJSONArray("ErrorParams");              
                String[] errorParamsA = errSpecUtil.arrayConverter(errorParams);              
                String[] errorParamKeys = getParamKeys(errorParams);
                ErrorSpec tmp = new ErrorSpec(errorCode,errorDetail,errorId,cause,errorParamsA,actionsA);
                tmp.setErrorParamKeys(errorParamKeys);
                map.put(errorCode, tmp);
            }
            if (map != null && map.size() != 0 ) {
                logger.log(Level.FINE, "Error Map Size" + map.size());
                logger.log(Level.FINEST, "Error Map" + map);
            }
            return map;
        }
*/
}
