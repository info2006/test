package structs;

public class dataStar {
private String head;

public dataStar(String head)
{
	this.head=head;
}

@Override
public String toString() {
	return "dataStar [head=" + head + "]";
}

public Integer getHead() {
	
	return Integer.parseInt(head);
}

}
