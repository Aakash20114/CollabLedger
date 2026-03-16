package chaincode;

import org.hyperledger.fabric.contract.Context;
import org.hyperledger.fabric.contract.ContractInterface;
import org.hyperledger.fabric.contract.annotation.Contract;
import org.hyperledger.fabric.contract.annotation.Default;
import org.hyperledger.fabric.contract.annotation.Transaction;

import org.hyperledger.fabric.shim.ChaincodeStub;

@Contract(name = "ContributionContract")
@Default
public class ContributionContract implements ContractInterface {


// Create a contribution record on the ledger
@Transaction()
public void recordContribution(Context ctx, String contributionId, String contributor, String task, String timestamp) {

    ChaincodeStub stub = ctx.getStub();

    String contributionData = contributor + "|" + task + "|" + timestamp;

    stub.putStringState(contributionId, contributionData);

    System.out.println("Contribution recorded on Fabric ledger: " + contributionId);
}

// Read contribution from ledger
@Transaction()
public String getContribution(Context ctx, String contributionId) {

    ChaincodeStub stub = ctx.getStub();

    String contributionData = stub.getStringState(contributionId);

    if (contributionData == null || contributionData.isEmpty()) {
        return "Contribution not found";
    }

    return contributionData;
}

// Check if contribution exists
@Transaction()
public boolean contributionExists(Context ctx, String contributionId) {

    ChaincodeStub stub = ctx.getStub();

    String contributionData = stub.getStringState(contributionId);

    return contributionData != null && !contributionData.isEmpty();
}


}
