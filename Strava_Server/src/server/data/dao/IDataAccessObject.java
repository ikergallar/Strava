package server.data.dao;

public interface IDataAccessObject<DomainObject> {
	public void save(DomainObject object);
}
