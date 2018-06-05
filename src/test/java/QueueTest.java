import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTest {

	@Test
	public void testQeueBehavior() {
		int max=3;
		
		// Normales Verhalte 1:
		// Da in Queue nichts statisch ist, neues objekt anlegen
		Queue queue = new Queue(max);
		
		// Hier ist ein void Methode, d.h. es gibt keinen Rückgabewert zu überprüfen
		queue.enqueue(23);
		queue.enqueue(43);
		queue.enqueue(2);
		
		// liest das älteste Elemnt und gibt es zurück
		assertEquals(23, queue.dequeue());
		
		
		// Normales Verhalte 2: 
		// Hinzufügen bei nicht vollen und nicht leeren Schlange
		queue.enqueue(6);
		assertEquals(43, queue.dequeue());
		
	}
	
	// Für spezial Fälle neue Methoden schreiben wegen bessere Verstädlichkeit
	
	//1.Fall:  Wenn die Queue voll ist, dann wird der Wert am Ende der Queue überschrieben
	@Test
	public void testWhenQueueIsFull() {
		int max = 3;
		Queue queue = new Queue(max);
		queue.enqueue(23);
		queue.enqueue(43);
		queue.enqueue(2);
		
		// Falls letzte Position, Wert überschreiben
		queue.enqueue(16);
		
		// Mit int dequeue() wird die Zahl, die am längsten in der Queue ist
		queue.dequeue();
		queue.dequeue();
		assertEquals(16, queue.dequeue());
	}
	
	// 2. Fall: Wenn die Queue leer ist, dann ist die Operation dequeue nicht erlaubt 
	//und es wird ein Fehler signalisiert.
	
	@Test(expected = IllegalStateException.class)
	public void testWhenQueueIsEmpty() {
		int max = 3;
		Queue queue = new Queue(max);
		
		// Wir erwarten hier eine Fehlermeldung und keinen Rückgabewert
		// deswegen schreiben hier keinen Assert. Diese implementiert man nur
		// wenn man wirklich einen Wert überprüfen will
		queue.dequeue();
	}
}
