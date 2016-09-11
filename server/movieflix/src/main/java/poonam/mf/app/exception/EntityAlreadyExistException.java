package poonam.mf.app.exception;

public class EntityAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 7590945301564438806L;

	public EntityAlreadyExistException(String message) {
		super(message);
	}

}
