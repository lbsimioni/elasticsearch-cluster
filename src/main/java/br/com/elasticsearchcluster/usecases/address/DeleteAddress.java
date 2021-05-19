package br.com.elasticsearchcluster.usecases.address;

import br.com.elasticsearchcluster.gateway.daos.interfaces.address.DeleteAddressDocumentInDataBase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteAddress {

    private final DeleteAddressDocumentInDataBase deleteAddressDocumentInDataBase;

    public void execute(String id) {
        deleteAddressDocumentInDataBase.execute(id);
    }
}
