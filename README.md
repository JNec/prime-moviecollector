prime-moviecollector
====================

This is a "Cluster Ready" version of the famous "prime-moviecollector" example from primefaces.

Application Servers
------------ 
* Jboss 7.1.1
* JBoss EAP 6.1 

Original Code
------------
See https://code.google.com/p/primefaces/source/browse/#svn%2Fexamples%2Ftrunk%2Fprime-moviecollector 

Changes from the original Source 
------------
* Adding postgresql as Database
* Adding support for Jboss 7.1 ( http://stackoverflow.com/questions/10020447/error-deploying-primefaces-application-on-jboss-7-1-0 ) in web.xml
		<context-param>
			    <param-name>org.jboss.jbossfaces.WAR_BUNDLES_JSF_IMPL</param-name>
			    <param-value>true</param-value>
		</context-param> 
* Adding  <distributable/> in order to support clustering
 
