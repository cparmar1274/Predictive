package interfaces;




public interface ICRUDOperations<K> {
	
	void save(K saveMe);
	void update(K updateMe);
	void insert(K insertMe);
	void delete(K deleteMe);

}
