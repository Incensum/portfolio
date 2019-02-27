import javax.xml.bind.*;
import java.io.File;

public class XmlManager {
	
	private JAXBContext context;
	private Unmarshaller reader;
	private Marshaller writer;
	
	private File axml;
	
	public XmlManager(String filename) throws Exception
	{
		context = JAXBContext.newInstance(SaveState.class);
		reader = context.createUnmarshaller();
		writer = context.createMarshaller();
		
		writer.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		writer.marshal(new SaveState(), System.out);
		
		axml = new File(filename);
	}
	
	public SaveState read() 
	{
		SaveState s = null;
		try {
			s = (SaveState)reader.unmarshal(axml);
		} catch(UnmarshalException e) {
			s = new SaveState();
		} catch(JAXBException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public void write(AlarmTime a)
	{
		try {
			SaveState s = read();
			s.addAlarm(a);
			writer.marshal(s, axml);
		} catch(JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(String name)
	{
		try {
			SaveState s = read();
			s.deleteAlarm(name);
			writer.marshal(s, axml);
		} catch(JAXBException e) {
			e.printStackTrace();
		}
	}
	
	
}
