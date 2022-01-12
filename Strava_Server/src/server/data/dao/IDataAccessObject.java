package server.data.dao;

import java.util.List;

public interface IDataAccessObject<DomainObject> {
	public void save(DomainObject object);
}
