package org.ctlv.proxmox.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

import org.ctlv.proxmox.api.ProxmoxAPI;
import org.ctlv.proxmox.api.data.LXC;
import org.json.JSONException;

public class Controller {

	ProxmoxAPI api;
	public Controller(ProxmoxAPI api){
		this.api = api;
	}
	
	// migrer un conteneur du serveur "srcServer" vers le serveur "dstServer"
	public void migrateFromTo(String srcServer, String dstServer)  {
		
		List<LXC> listOfLXC; 
		
		

	}

	// arrêter le plus vieux conteneur sur le serveur "server"
	public void offLoad(String server) {
		
		List<LXC> listOfLXC = new ArrayList<LXC>();
		
		
		try {
			List<LXC> cts = api.getCTs(server);
			for (LXC lxc : cts) {
				if(lxc.getName().contains("C2")) {
					listOfLXC.add(lxc);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Recupération des nos CTs effectué...");
		long longestUptime = 0;
		LXC lxcToStop = null;
		for( LXC lxc : listOfLXC) {
			if(lxc.getUptime() > longestUptime) {
				longestUptime = lxc.getUptime();
				lxcToStop = lxc;
			}
		}
		
		if(lxcToStop != null) {
			try {
				api.stopCT(server, lxcToStop.getVmid());
				System.out.println("CT : "+ lxcToStop.getVmid()+ " arrêté");
			} catch (LoginException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
