package org.telegram.contracts;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.2.0.
 */
public class Abi extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5060405161267f38038061267f8339818101604052608081101561003357600080fd5b8101908080519060200190929190805190602001909291908051906020019092919080519060200190929190505050336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16600073ffffffffffffffffffffffffffffffffffffffff167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a381811161012a57600080fd5b83600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555082600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508160038190555080600481905550505050506124b2806101cd6000396000f3fe60806040526004361061012a5760003560e01c80638d839ffe116100ab578063aeb8ce9b1161006f578063aeb8ce9b146107cc578063ce1e09c0146108ac578063f14fcbc8146108d7578063f2fde38b14610912578063f49826be14610963578063f7a1696314610a695761012a565b80638d839ffe146105b85780638da5cb5b146105e35780638f32d59b1461063a5780639791c09714610669578063acf1a841146107495761012a565b80637e324479116100f25780637e32447914610366578063839df945146103ab57806383e7f6ff146103fa57806385f6d155146104e05780638a95b09f1461058d5761012a565b806301ffc9a71461012f5780633ccfd60b146101a15780633d86c52f146101b8578063530e784f146102fe578063715018a61461034f575b600080fd5b34801561013b57600080fd5b506101876004803603602081101561015257600080fd5b8101908080357bffffffffffffffffffffffffffffffffffffffffffffffffffffffff19169060200190929190505050610b98565b604051808215151515815260200191505060405180910390f35b3480156101ad57600080fd5b506101b6610de7565b005b3480156101c457600080fd5b506102e8600480360360a08110156101db57600080fd5b81019080803590602001906401000000008111156101f857600080fd5b82018360208201111561020a57600080fd5b8035906020019184600183028401116401000000008311171561022c57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610e41565b6040518082815260200191505060405180910390f35b34801561030a57600080fd5b5061034d6004803603602081101561032157600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611044565b005b34801561035b57600080fd5b506103646110fe565b005b34801561037257600080fd5b506103a96004803603604081101561038957600080fd5b8101908080359060200190929190803590602001909291905050506111ce565b005b3480156103b757600080fd5b506103e4600480360360208110156103ce57600080fd5b81019080803590602001909291905050506111f1565b6040518082815260200191505060405180910390f35b34801561040657600080fd5b506104ca6004803603604081101561041d57600080fd5b810190808035906020019064010000000081111561043a57600080fd5b82018360208201111561044c57600080fd5b8035906020019184600183028401116401000000008311171561046e57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f82011690508083019250505050505050919291929080359060200190929190505050611209565b6040518082815260200191505060405180910390f35b61058b600480360360808110156104f657600080fd5b810190808035906020019064010000000081111561051357600080fd5b82018360208201111561052557600080fd5b8035906020019184600183028401116401000000008311171561054757600080fd5b9091929391929390803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190803590602001909291905050506113f2565b005b34801561059957600080fd5b506105a261144c565b6040518082815260200191505060405180910390f35b3480156105c457600080fd5b506105cd611453565b6040518082815260200191505060405180910390f35b3480156105ef57600080fd5b506105f8611459565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561064657600080fd5b5061064f611482565b604051808215151515815260200191505060405180910390f35b34801561067557600080fd5b5061072f6004803603602081101561068c57600080fd5b81019080803590602001906401000000008111156106a957600080fd5b8201836020820111156106bb57600080fd5b803590602001918460018302840111640100000000831117156106dd57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505091929192905050506114d9565b604051808215151515815260200191505060405180910390f35b6107ca6004803603604081101561075f57600080fd5b810190808035906020019064010000000081111561077c57600080fd5b82018360208201111561078e57600080fd5b803590602001918460018302840111640100000000831117156107b057600080fd5b9091929391929390803590602001909291905050506114ef565b005b3480156107d857600080fd5b50610892600480360360208110156107ef57600080fd5b810190808035906020019064010000000081111561080c57600080fd5b82018360208201111561081e57600080fd5b8035906020019184600183028401116401000000008311171561084057600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505091929192905050506116fe565b604051808215151515815260200191505060405180910390f35b3480156108b857600080fd5b506108c16117d5565b6040518082815260200191505060405180910390f35b3480156108e357600080fd5b50610910600480360360208110156108fa57600080fd5b81019080803590602001909291905050506117db565b005b34801561091e57600080fd5b506109616004803603602081101561093557600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611819565b005b34801561096f57600080fd5b50610a536004803603606081101561098657600080fd5b81019080803590602001906401000000008111156109a357600080fd5b8201836020820111156109b557600080fd5b803590602001918460018302840111640100000000831117156109d757600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050611836565b6040518082815260200191505060405180910390f35b610b96600480360360c0811015610a7f57600080fd5b8101908080359060200190640100000000811115610a9c57600080fd5b820183602082011115610aae57600080fd5b80359060200191846001830284011164010000000083111715610ad057600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290803573ffffffffffffffffffffffffffffffffffffffff1690602001909291908035906020019092919080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061184f565b005b600060405180807f737570706f727473496e74657266616365286279746573342900000000000000815250601901905060405180910390207bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916827bffffffffffffffffffffffffffffffffffffffffffffffffffffffff19161480610d66575060405180807f72656e657728737472696e672c75696e743235362900000000000000000000008152506015019050604051809103902060405180806123ee602891396028019050604051809103902060405180807f636f6d6d69742862797465733332290000000000000000000000000000000000815250600f01905060405180910390206040518080612416602691396026019050604051809103902060405180807f617661696c61626c6528737472696e67290000000000000000000000000000008152506011019050604051809103902060405180807f72656e74507269636528737472696e672c75696e7432353629000000000000008152506019019050604051809103902018181818187bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916827bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916145b80610de0575060405180806123ae6040913960400190506040518091039020604051808061243c6042913960420190506040518091039020187bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916827bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916145b9050919050565b610def611482565b610df857600080fd5b3373ffffffffffffffffffffffffffffffffffffffff166108fc479081150290604051600060405180830381858888f19350505050158015610e3e573d6000803e3d6000fd5b50565b60008086805190602001209050600073ffffffffffffffffffffffffffffffffffffffff168473ffffffffffffffffffffffffffffffffffffffff16148015610eb65750600073ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff16145b15610f2957808686604051602001808481526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1660601b815260140182815260200193505050506040516020818303038152906040528051906020012091505061103b565b600073ffffffffffffffffffffffffffffffffffffffff168473ffffffffffffffffffffffffffffffffffffffff161415610f6357600080fd5b8086858588604051602001808681526020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1660601b81526014018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1660601b81526014018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1660601b815260140182815260200195505050505050604051602081830303815290604052805190602001209150505b95945050505050565b61104c611482565b61105557600080fd5b80600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167ff261845a790fe29bbd6631e2ca4a5bdc83e6eed7c3271d9590d97287e00e912360405160405180910390a250565b611106611482565b61110f57600080fd5b600073ffffffffffffffffffffffffffffffffffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a360008060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550565b6111d6611482565b6111df57600080fd5b81600381905550806004819055505050565b60056020528060005260406000206000915090505481565b60008083805190602001209050600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166350e9a71585600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663d6e4fa868560001c6040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b1580156112cb57600080fd5b505afa1580156112df573d6000803e3d6000fd5b505050506040513d60208110156112f557600080fd5b8101908080519060200190929190505050866040518463ffffffff1660e01b81526004018080602001848152602001838152602001828103825285818151815260200191508051906020019080838360005b83811015611362578082015181840152602081019050611347565b50505050905090810190601f16801561138f5780820380516001836020036101000a031916815260200191505b5094505050505060206040518083038186803b1580156113ae57600080fd5b505afa1580156113c2573d6000803e3d6000fd5b505050506040513d60208110156113d857600080fd5b810190808051906020019092919050505091505092915050565b61144585858080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505084848460008061184f565b5050505050565b6224ea0081565b60035481565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905090565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614905090565b600060036114e683612097565b10159050919050565b600061153f84848080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505083611209565b90508034101561154e57600080fd5b60008484604051808383808284378083019250505092505050604051809103902090506000600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663c475abff8360001c866040518363ffffffff1660e01b81526004018083815260200182815260200192505050602060405180830381600087803b1580156115f357600080fd5b505af1158015611607573d6000803e3d6000fd5b505050506040513d602081101561161d57600080fd5b8101908080519060200190929190505050905082341115611682573373ffffffffffffffffffffffffffffffffffffffff166108fc8434039081150290604051600060405180830381858888f19350505050158015611680573d6000803e3d6000fd5b505b817f3da24c024582931cfaf8267d8ed24d13a82a8068d5bd337d30ec45cea4e506ae8787868560405180806020018481526020018381526020018281038252868682818152602001925080828437600081840152601f19601f8201169050808301925050509550505050505060405180910390a2505050505050565b60008082805190602001209050611714836114d9565b80156117cd5750600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166396e494e88260001c6040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b15801561179157600080fd5b505afa1580156117a5573d6000803e3d6000fd5b505050506040513d60208110156117bb57600080fd5b81019080805190602001909291905050505b915050919050565b60045481565b42600454600560008481526020019081526020016000205401106117fe57600080fd5b42600560008381526020019081526020016000208190555050565b611821611482565b61182a57600080fd5b6118338161220d565b50565b6000611846848484600080610e41565b90509392505050565b600061185e8787868686610e41565b9050600061186d888784612305565b905060008880519060200120905060008160001c905060008073ffffffffffffffffffffffffffffffffffffffff168773ffffffffffffffffffffffffffffffffffffffff1614611e4c57600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663fca247ac83308c6040518463ffffffff1660e01b8152600401808481526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050602060405180830381600087803b15801561196957600080fd5b505af115801561197d573d6000803e3d6000fd5b505050506040513d602081101561199357600080fd5b810190808051906020019092919050505090506000600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663ddf7fcb06040518163ffffffff1660e01b815260040160206040518083038186803b158015611a1057600080fd5b505afa158015611a24573d6000803e3d6000fd5b505050506040513d6020811015611a3a57600080fd5b8101908080519060200190929190505050846040516020018083815260200182815260200192505050604051602081830303815290604052805190602001209050600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16633f15457f6040518163ffffffff1660e01b815260040160206040518083038186803b158015611ae357600080fd5b505afa158015611af7573d6000803e3d6000fd5b505050506040513d6020811015611b0d57600080fd5b810190808051906020019092919050505073ffffffffffffffffffffffffffffffffffffffff16631896f70a828a6040518363ffffffff1660e01b8152600401808381526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200192505050600060405180830381600087803b158015611ba457600080fd5b505af1158015611bb8573d6000803e3d6000fd5b50505050600073ffffffffffffffffffffffffffffffffffffffff168773ffffffffffffffffffffffffffffffffffffffff1614611c90578773ffffffffffffffffffffffffffffffffffffffff1663d5fa2b0082896040518363ffffffff1660e01b8152600401808381526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200192505050600060405180830381600087803b158015611c7757600080fd5b505af1158015611c8b573d6000803e3d6000fd5b505050505b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166328ed4f6c848d6040518363ffffffff1660e01b8152600401808381526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200192505050600060405180830381600087803b158015611d3957600080fd5b505af1158015611d4d573d6000803e3d6000fd5b50505050600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166323b872dd308d866040518463ffffffff1660e01b8152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050600060405180830381600087803b158015611e2e57600080fd5b505af1158015611e42573d6000803e3d6000fd5b5050505050611f74565b600073ffffffffffffffffffffffffffffffffffffffff168673ffffffffffffffffffffffffffffffffffffffff1614611e8557600080fd5b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663fca247ac838c8c6040518463ffffffff1660e01b8152600401808481526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050602060405180830381600087803b158015611f3657600080fd5b505af1158015611f4a573d6000803e3d6000fd5b505050506040513d6020811015611f6057600080fd5b810190808051906020019092919050505090505b8973ffffffffffffffffffffffffffffffffffffffff16837fca6abbe9d7f11422cb6ca7629fbf6fe9efb1c621f71ce8f02b9f2a230097404f8d87856040518080602001848152602001838152602001828103825285818151815260200191508051906020019080838360005b83811015611ffc578082015181840152602081019050611fe1565b50505050905090810190601f1680156120295780820380516001836020036101000a031916815260200191505b5094505050505060405180910390a38334111561208a573373ffffffffffffffffffffffffffffffffffffffff166108fc8534039081150290604051600060405180830381858888f19350505050158015612088573d6000803e3d6000fd5b505b5050505050505050505050565b6000806000809050600084519050600092505b808210156122025760008583815181106120c057fe5b602001015160f81c60f81b9050608060f81b817effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff19161015612106576001830192506121f4565b60e060f81b817effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916101561213f576002830192506121f3565b60f060f81b817effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff19161015612178576003830192506121f2565b60f8801b817effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff191610156121b0576004830192506121f1565b60fc60f81b817effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff191610156121e9576005830192506121f0565b6006830192505b5b5b5b5b5082806001019350506120aa565b829350505050919050565b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff16141561224757600080fd5b8073ffffffffffffffffffffffffffffffffffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a3806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b600042600354600560008581526020019081526020016000205401111561232b57600080fd5b426004546005600085815260200190815260200160002054011161234e57600080fd5b612357846116fe565b61236057600080fd5b600560008381526020019081526020016000206000905560006123838585611209565b90506224ea0084101561239557600080fd5b803410156123a257600080fd5b80915050939250505056fe6d616b65436f6d6d69746d656e7457697468436f6e66696728737472696e672c616464726573732c627974657333322c616464726573732c6164647265737329726567697374657228737472696e672c616464726573732c75696e743235362c62797465733332296d616b65436f6d6d69746d656e7428737472696e672c616464726573732c6279746573333229726567697374657257697468436f6e66696728737472696e672c616464726573732c75696e743235362c627974657333322c616464726573732c6164647265737329a265627a7a72315820ae5aec11a7c9126de666c7630771a2e6e95d684de2539cfca1b14cb30a427a4264736f6c6343000510003200000000000000000000000057f1887a8bf19b14fc0df6fd9b2acc9af147ea8500000000000000000000000004cd12453859f6c21fa268bf9ab4d7f81a25d543000000000000000000000000000000000000000000000000000000000000003c0000000000000000000000000000000000000000000000000000000000015180\n";

    public static final String FUNC_MIN_REGISTRATION_DURATION = "MIN_REGISTRATION_DURATION";

    public static final String FUNC_AVAILABLE = "available";

    public static final String FUNC_COMMIT = "commit";

    public static final String FUNC_COMMITMENTS = "commitments";

    public static final String FUNC_ISOWNER = "isOwner";

    public static final String FUNC_MAKECOMMITMENT = "makeCommitment";

    public static final String FUNC_MAKECOMMITMENTWITHCONFIG = "makeCommitmentWithConfig";

    public static final String FUNC_MAXCOMMITMENTAGE = "maxCommitmentAge";

    public static final String FUNC_MINCOMMITMENTAGE = "minCommitmentAge";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_REGISTER = "register";

    public static final String FUNC_REGISTERWITHCONFIG = "registerWithConfig";

    public static final String FUNC_RENEW = "renew";

    public static final String FUNC_RENOUNCEOWNERSHIP = "renounceOwnership";

    public static final String FUNC_RENTPRICE = "rentPrice";

    public static final String FUNC_SETCOMMITMENTAGES = "setCommitmentAges";

    public static final String FUNC_SETPRICEORACLE = "setPriceOracle";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_VALID = "valid";

    public static final String FUNC_WITHDRAW = "withdraw";

    public static final Event NAMEREGISTERED_EVENT = new Event("NameRegistered", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Bytes32>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event NAMERENEWED_EVENT = new Event("NameRenewed", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Bytes32>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event NEWPRICEORACLE_EVENT = new Event("NewPriceOracle", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    @Deprecated
    protected Abi(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Abi(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Abi(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Abi(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<NameRegisteredEventResponse> getNameRegisteredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(NAMEREGISTERED_EVENT, transactionReceipt);
        ArrayList<NameRegisteredEventResponse> responses = new ArrayList<NameRegisteredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            NameRegisteredEventResponse typedResponse = new NameRegisteredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.label = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.name = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.cost = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.expires = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<NameRegisteredEventResponse> nameRegisteredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, NameRegisteredEventResponse>() {
            @Override
            public NameRegisteredEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(NAMEREGISTERED_EVENT, log);
                NameRegisteredEventResponse typedResponse = new NameRegisteredEventResponse();
                typedResponse.log = log;
                typedResponse.label = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.owner = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.name = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.cost = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.expires = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<NameRegisteredEventResponse> nameRegisteredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(NAMEREGISTERED_EVENT));
        return nameRegisteredEventFlowable(filter);
    }

    public List<NameRenewedEventResponse> getNameRenewedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(NAMERENEWED_EVENT, transactionReceipt);
        ArrayList<NameRenewedEventResponse> responses = new ArrayList<NameRenewedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            NameRenewedEventResponse typedResponse = new NameRenewedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.label = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.name = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.cost = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.expires = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<NameRenewedEventResponse> nameRenewedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, NameRenewedEventResponse>() {
            @Override
            public NameRenewedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(NAMERENEWED_EVENT, log);
                NameRenewedEventResponse typedResponse = new NameRenewedEventResponse();
                typedResponse.log = log;
                typedResponse.label = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.name = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.cost = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.expires = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<NameRenewedEventResponse> nameRenewedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(NAMERENEWED_EVENT));
        return nameRenewedEventFlowable(filter);
    }

    public List<NewPriceOracleEventResponse> getNewPriceOracleEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(NEWPRICEORACLE_EVENT, transactionReceipt);
        ArrayList<NewPriceOracleEventResponse> responses = new ArrayList<NewPriceOracleEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            NewPriceOracleEventResponse typedResponse = new NewPriceOracleEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.oracle = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<NewPriceOracleEventResponse> newPriceOracleEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, NewPriceOracleEventResponse>() {
            @Override
            public NewPriceOracleEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(NEWPRICEORACLE_EVENT, log);
                NewPriceOracleEventResponse typedResponse = new NewPriceOracleEventResponse();
                typedResponse.log = log;
                typedResponse.oracle = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<NewPriceOracleEventResponse> newPriceOracleEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(NEWPRICEORACLE_EVENT));
        return newPriceOracleEventFlowable(filter);
    }

    public List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, transactionReceipt);
        ArrayList<OwnershipTransferredEventResponse> responses = new ArrayList<OwnershipTransferredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, OwnershipTransferredEventResponse>() {
            @Override
            public OwnershipTransferredEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, log);
                OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
                typedResponse.log = log;
                typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERSHIPTRANSFERRED_EVENT));
        return ownershipTransferredEventFlowable(filter);
    }

    public RemoteCall<BigInteger> MIN_REGISTRATION_DURATION() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MIN_REGISTRATION_DURATION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Boolean> available(String name) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_AVAILABLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> commit(byte[] commitment) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_COMMIT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(commitment)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> commitments(byte[] param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_COMMITMENTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Boolean> isOwner() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISOWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<byte[]> makeCommitment(String name, String owner, byte[] secret) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MAKECOMMITMENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Address(owner), 
                new org.web3j.abi.datatypes.generated.Bytes32(secret)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<byte[]> makeCommitmentWithConfig(String name, String owner, byte[] secret, String resolver, String addr) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MAKECOMMITMENTWITHCONFIG, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Address(owner), 
                new org.web3j.abi.datatypes.generated.Bytes32(secret), 
                new org.web3j.abi.datatypes.Address(resolver), 
                new org.web3j.abi.datatypes.Address(addr)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<BigInteger> maxCommitmentAge() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MAXCOMMITMENTAGE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> minCommitmentAge() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MINCOMMITMENTAGE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> owner() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> register(String name, String owner, BigInteger duration, byte[] secret, BigInteger weiValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REGISTER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Address(owner), 
                new org.web3j.abi.datatypes.generated.Uint256(duration), 
                new org.web3j.abi.datatypes.generated.Bytes32(secret)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> registerWithConfig(String name, String owner, BigInteger duration, byte[] secret, String resolver, String addr, BigInteger weiValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REGISTERWITHCONFIG, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Address(owner), 
                new org.web3j.abi.datatypes.generated.Uint256(duration), 
                new org.web3j.abi.datatypes.generated.Bytes32(secret), 
                new org.web3j.abi.datatypes.Address(resolver), 
                new org.web3j.abi.datatypes.Address(addr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> renew(String name, BigInteger duration, BigInteger weiValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_RENEW, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.generated.Uint256(duration)), 
                Collections.<TypeReference<?>>emptyList());

        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> renounceOwnership() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_RENOUNCEOWNERSHIP, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> rentPrice(String name, BigInteger duration) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_RENTPRICE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.generated.Uint256(duration)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> setCommitmentAges(BigInteger _minCommitmentAge, BigInteger _maxCommitmentAge) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETCOMMITMENTAGES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_minCommitmentAge), 
                new org.web3j.abi.datatypes.generated.Uint256(_maxCommitmentAge)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setPriceOracle(String _prices) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETPRICEORACLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_prices)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> supportsInterface(byte[] interfaceID) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SUPPORTSINTERFACE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(interfaceID)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(String newOwner) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> valid(String name) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_VALID, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> withdraw() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_WITHDRAW, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Abi load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Abi(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Abi load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Abi(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Abi load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Abi(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Abi load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Abi(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Abi> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _base, String _prices, BigInteger _minCommitmentAge, BigInteger _maxCommitmentAge) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_base), 
                new org.web3j.abi.datatypes.Address(_prices), 
                new org.web3j.abi.datatypes.generated.Uint256(_minCommitmentAge), 
                new org.web3j.abi.datatypes.generated.Uint256(_maxCommitmentAge)));
        return deployRemoteCall(Abi.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Abi> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _base, String _prices, BigInteger _minCommitmentAge, BigInteger _maxCommitmentAge) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_base), 
                new org.web3j.abi.datatypes.Address(_prices), 
                new org.web3j.abi.datatypes.generated.Uint256(_minCommitmentAge), 
                new org.web3j.abi.datatypes.generated.Uint256(_maxCommitmentAge)));
        return deployRemoteCall(Abi.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Abi> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _base, String _prices, BigInteger _minCommitmentAge, BigInteger _maxCommitmentAge) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_base), 
                new org.web3j.abi.datatypes.Address(_prices), 
                new org.web3j.abi.datatypes.generated.Uint256(_minCommitmentAge), 
                new org.web3j.abi.datatypes.generated.Uint256(_maxCommitmentAge)));
        return deployRemoteCall(Abi.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Abi> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _base, String _prices, BigInteger _minCommitmentAge, BigInteger _maxCommitmentAge) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_base), 
                new org.web3j.abi.datatypes.Address(_prices), 
                new org.web3j.abi.datatypes.generated.Uint256(_minCommitmentAge), 
                new org.web3j.abi.datatypes.generated.Uint256(_maxCommitmentAge)));
        return deployRemoteCall(Abi.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class NameRegisteredEventResponse {
        public Log log;

        public byte[] label;

        public String owner;

        public String name;

        public BigInteger cost;

        public BigInteger expires;
    }

    public static class NameRenewedEventResponse {
        public Log log;

        public byte[] label;

        public String name;

        public BigInteger cost;

        public BigInteger expires;
    }

    public static class NewPriceOracleEventResponse {
        public Log log;

        public String oracle;
    }

    public static class OwnershipTransferredEventResponse {
        public Log log;

        public String previousOwner;

        public String newOwner;
    }
}
