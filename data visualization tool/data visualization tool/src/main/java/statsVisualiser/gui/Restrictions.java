/*
 * This is the interface class for proxy pattern
 */

package statsVisualiser.gui;

public interface Restrictions {

public void checkCountry(String country);
public void checkYears(Object fromYear,Object toYear);
}
