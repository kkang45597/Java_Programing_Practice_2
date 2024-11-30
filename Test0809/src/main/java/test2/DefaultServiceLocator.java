package test2;

public class DefaultServiceLocator {
	
	private static ClientService clientService = new ClientServiceImpl();
	
	private static AccountService accountService = new AccountServiceImpl();

	public ClientService createClientServiceInstance() {
		return clientService;
	}

	public AccountService createAccountServiceInstance() {
		return accountService;
	}
}
