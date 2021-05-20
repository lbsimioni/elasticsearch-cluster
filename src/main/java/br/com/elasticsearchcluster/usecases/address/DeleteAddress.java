package br.com.elasticsearchcluster.usecases.address;

import br.com.elasticsearchcluster.gateway.daos.interfaces.address.DeleteAddressDocumentInDataBase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class DeleteAddress {

    private final DeleteAddressDocumentInDataBase deleteAddressDocumentInDataBase;

    public void execute(final String id) {
        log.info("UseCase Deleting address");
        deleteAddressDocumentInDataBase.execute(id);
        log.info("UseCase Deleted address");
    }
}
