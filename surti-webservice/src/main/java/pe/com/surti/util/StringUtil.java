
package pe.com.surti.util;

/**
 * 
 * @author wcahuaya
 * 
 */
public class StringUtil
{

    /**
     * Determina si una cadena es un numero
     * 
     * @param n
     * @return
     */
    public static boolean isNumber(String n)
    {
        boolean isnumber = true;
        int i = 0;

        for (i = 0; i < n.length(); i++)
        {
            if (!Character.isDigit(n.charAt(i)))
            {
                isnumber = false;
                break;
            }
        }

        return isnumber;
    }

    /**
     * Convierte el primer caracter entre palabras de una cadena en Mayuscula
     * 
     * @param s
     * @return
     * @throws java.io.IOException
     */
    public static String proper(String s)
    {
        java.io.StringReader in = new java.io.StringReader(s.toLowerCase());
        boolean preSpace = true;
        StringBuffer properCase = new StringBuffer();

        try
        {
            while (true)
            {
                int i = in.read();
                if (i == -1) {
                    break;
                }
                
                char c = (char) i;
                if (c == ' ' || c == '"' || c == '(' || c == '.' || c == '/' || c == '\\' || c == ',')
                {
                    properCase.append(c);
                    preSpace = true;
                }
                else
                {
                    if (preSpace) {                    	
                        properCase.append(Character.toUpperCase(c));
                    }
                    else {
                        properCase.append(c);
                    }
                    
                    preSpace = false;
                }
            }

            return properCase.toString();
        }
        catch (Exception e)
        {
            return null;
        }
    }

    /**
     * Convierte un array de string a delimitado por comas
     * 
     * @param array
     * @return
     */
    public static String arrayToString(String array[])
    {
        String values = "";
        if (array != null && array.length > 0)
        {
            for (int i = 0; i < array.length; i++)
            {
                values += "," + array[i];
            }
        }
        return (values.length() > 0 ? values.substring(1) : values);
    }

}
