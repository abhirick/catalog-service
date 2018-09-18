--Create KEYSPACE script for Catalog Services.
CREATE KEYSPACE enterprise_services WITH REPLICATION ={ 'class' : 'NetworkTopologyStrategy', 'datacenter1' : 1};