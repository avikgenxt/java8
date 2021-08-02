/**
 * 
 */
package lambda.basic.function;

/**
 * @author avikg
 *
 */
public enum Gender {

	MALE("male"),FEMALE("female");

	Gender(String sex) {
		this.sex = sex;
	}
	
    // declaring private variable for getting values
    private String sex;
  
    // getter method
    public String getSex()
    {
        return this.sex;
    }
  
}
