import proxy.BanqueService;
import proxy.BanqueWS_0020;
import proxy.Compte;

public class ClientWS {
    public static void main(String[] args) {
        BanqueService stub= new BanqueWS_0020().getBanqueServicePort();
        System.out.println(stub.convert(7500));
        Compte cp=stub.getCompte(2);
        System.out.println(cp.getCode());
        System.out.println(cp.getSolde());
    }
}
