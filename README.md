# TpCloud

Code for Tutorial 2 
Retrieval of information from server available in both Java and Python (2 codes).
Rest of the project only available in Java.

Part 1:
Retrieval of data:
Creation and Start of a container:

Part 2:
Design and implementation of two applications to automatize the virtualization.
CT generator : this application will be in charge of the creation of CT, randomly on the two servers with a proportion of 66% on server 3, and 33% on server 4, the servers attributed to our team. The creation of a new CT is driven by a statistic distribution with an exponential law and an lambda of 30.

Cluster manager: This application will periodically monitor server status, and acts on the deployed containers based on the following algorithm: As soon as the load of one of your CT exceeds 8% of the host memory (i.e. half the resources accessible on the server), perform load balancing between your servers ;
           As soon as the load of one of the servers exceeds 12% of the total load, stop the oldest CT to support the creation of new ones.

For further explaination, refer to the Google doc of the laboratories -Lab 2 Parts 1 and 2

