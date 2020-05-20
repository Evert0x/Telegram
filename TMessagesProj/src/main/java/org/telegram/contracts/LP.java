package LendingPool;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint16;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint40;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple10;
import org.web3j.tuples.generated.Tuple13;
import org.web3j.tuples.generated.Tuple8;
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
public class LP extends Contract {
    private static final String BINARY = "Bin file was not provided";

    public static final String FUNC_LENDINGPOOL_REVISION = "LENDINGPOOL_REVISION";

    public static final String FUNC_UINT_MAX_VALUE = "UINT_MAX_VALUE";

    public static final String FUNC_ADDRESSESPROVIDER = "addressesProvider";

    public static final String FUNC_CORE = "core";

    public static final String FUNC_DATAPROVIDER = "dataProvider";

    public static final String FUNC_PARAMETERSPROVIDER = "parametersProvider";

    public static final String FUNC_INITIALIZE = "initialize";

    public static final String FUNC_DEPOSIT = "deposit";

    public static final String FUNC_REDEEMUNDERLYING = "redeemUnderlying";

    public static final String FUNC_BORROW = "borrow";

    public static final String FUNC_REPAY = "repay";

    public static final String FUNC_SWAPBORROWRATEMODE = "swapBorrowRateMode";

    public static final String FUNC_REBALANCESTABLEBORROWRATE = "rebalanceStableBorrowRate";

    public static final String FUNC_SETUSERUSERESERVEASCOLLATERAL = "setUserUseReserveAsCollateral";

    public static final String FUNC_LIQUIDATIONCALL = "liquidationCall";

    public static final String FUNC_FLASHLOAN = "flashLoan";

    public static final String FUNC_GETRESERVECONFIGURATIONDATA = "getReserveConfigurationData";

    public static final String FUNC_GETRESERVEDATA = "getReserveData";

    public static final String FUNC_GETUSERACCOUNTDATA = "getUserAccountData";

    public static final String FUNC_GETUSERRESERVEDATA = "getUserReserveData";

    public static final String FUNC_GETRESERVES = "getReserves";

    public static final Event BORROW_EVENT = new Event("Borrow", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint16>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event DEPOSIT_EVENT = new Event("Deposit", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Uint16>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event FLASHLOAN_EVENT = new Event("FlashLoan", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event LIQUIDATIONCALL_EVENT = new Event("LiquidationCall", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event ORIGINATIONFEELIQUIDATED_EVENT = new Event("OriginationFeeLiquidated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event REBALANCESTABLEBORROWRATE_EVENT = new Event("RebalanceStableBorrowRate", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event REDEEMUNDERLYING_EVENT = new Event("RedeemUnderlying", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event REPAY_EVENT = new Event("Repay", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event RESERVEUSEDASCOLLATERALDISABLED_EVENT = new Event("ReserveUsedAsCollateralDisabled", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event RESERVEUSEDASCOLLATERALENABLED_EVENT = new Event("ReserveUsedAsCollateralEnabled", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event SWAP_EVENT = new Event("Swap", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected LP(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected LP(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected LP(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected LP(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<BorrowEventResponse> getBorrowEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(BORROW_EVENT, transactionReceipt);
        ArrayList<BorrowEventResponse> responses = new ArrayList<BorrowEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            BorrowEventResponse typedResponse = new BorrowEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._reserve = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._user = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._referral = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            typedResponse._amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._borrowRateMode = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse._borrowRate = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse._originationFee = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse._borrowBalanceIncrease = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse._timestamp = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<BorrowEventResponse> borrowEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, BorrowEventResponse>() {
            @Override
            public BorrowEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(BORROW_EVENT, log);
                BorrowEventResponse typedResponse = new BorrowEventResponse();
                typedResponse.log = log;
                typedResponse._reserve = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._user = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._referral = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
                typedResponse._amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._borrowRateMode = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse._borrowRate = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse._originationFee = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse._borrowBalanceIncrease = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse._timestamp = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<BorrowEventResponse> borrowEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(BORROW_EVENT));
        return borrowEventFlowable(filter);
    }

    public List<DepositEventResponse> getDepositEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(DEPOSIT_EVENT, transactionReceipt);
        ArrayList<DepositEventResponse> responses = new ArrayList<DepositEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DepositEventResponse typedResponse = new DepositEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._reserve = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._user = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._referral = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            typedResponse._amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._timestamp = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DepositEventResponse> depositEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, DepositEventResponse>() {
            @Override
            public DepositEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(DEPOSIT_EVENT, log);
                DepositEventResponse typedResponse = new DepositEventResponse();
                typedResponse.log = log;
                typedResponse._reserve = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._user = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._referral = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
                typedResponse._amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._timestamp = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<DepositEventResponse> depositEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DEPOSIT_EVENT));
        return depositEventFlowable(filter);
    }

    public List<FlashLoanEventResponse> getFlashLoanEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(FLASHLOAN_EVENT, transactionReceipt);
        ArrayList<FlashLoanEventResponse> responses = new ArrayList<FlashLoanEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            FlashLoanEventResponse typedResponse = new FlashLoanEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._target = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._reserve = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._totalFee = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse._protocolFee = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse._timestamp = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<FlashLoanEventResponse> flashLoanEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, FlashLoanEventResponse>() {
            @Override
            public FlashLoanEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(FLASHLOAN_EVENT, log);
                FlashLoanEventResponse typedResponse = new FlashLoanEventResponse();
                typedResponse.log = log;
                typedResponse._target = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._reserve = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._totalFee = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse._protocolFee = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse._timestamp = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<FlashLoanEventResponse> flashLoanEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(FLASHLOAN_EVENT));
        return flashLoanEventFlowable(filter);
    }

    public List<LiquidationCallEventResponse> getLiquidationCallEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(LIQUIDATIONCALL_EVENT, transactionReceipt);
        ArrayList<LiquidationCallEventResponse> responses = new ArrayList<LiquidationCallEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            LiquidationCallEventResponse typedResponse = new LiquidationCallEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._collateral = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._reserve = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._user = (String) eventValues.getIndexedValues().get(2).getValue();
            typedResponse._purchaseAmount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._liquidatedCollateralAmount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse._accruedBorrowInterest = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse._liquidator = (String) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse._receiveAToken = (Boolean) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse._timestamp = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<LiquidationCallEventResponse> liquidationCallEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, LiquidationCallEventResponse>() {
            @Override
            public LiquidationCallEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(LIQUIDATIONCALL_EVENT, log);
                LiquidationCallEventResponse typedResponse = new LiquidationCallEventResponse();
                typedResponse.log = log;
                typedResponse._collateral = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._reserve = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._user = (String) eventValues.getIndexedValues().get(2).getValue();
                typedResponse._purchaseAmount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._liquidatedCollateralAmount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse._accruedBorrowInterest = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse._liquidator = (String) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse._receiveAToken = (Boolean) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse._timestamp = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<LiquidationCallEventResponse> liquidationCallEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(LIQUIDATIONCALL_EVENT));
        return liquidationCallEventFlowable(filter);
    }

    public List<OriginationFeeLiquidatedEventResponse> getOriginationFeeLiquidatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ORIGINATIONFEELIQUIDATED_EVENT, transactionReceipt);
        ArrayList<OriginationFeeLiquidatedEventResponse> responses = new ArrayList<OriginationFeeLiquidatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OriginationFeeLiquidatedEventResponse typedResponse = new OriginationFeeLiquidatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._collateral = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._reserve = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._user = (String) eventValues.getIndexedValues().get(2).getValue();
            typedResponse._feeLiquidated = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._liquidatedCollateralForFee = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse._timestamp = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OriginationFeeLiquidatedEventResponse> originationFeeLiquidatedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, OriginationFeeLiquidatedEventResponse>() {
            @Override
            public OriginationFeeLiquidatedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ORIGINATIONFEELIQUIDATED_EVENT, log);
                OriginationFeeLiquidatedEventResponse typedResponse = new OriginationFeeLiquidatedEventResponse();
                typedResponse.log = log;
                typedResponse._collateral = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._reserve = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._user = (String) eventValues.getIndexedValues().get(2).getValue();
                typedResponse._feeLiquidated = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._liquidatedCollateralForFee = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse._timestamp = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OriginationFeeLiquidatedEventResponse> originationFeeLiquidatedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ORIGINATIONFEELIQUIDATED_EVENT));
        return originationFeeLiquidatedEventFlowable(filter);
    }

    public List<RebalanceStableBorrowRateEventResponse> getRebalanceStableBorrowRateEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(REBALANCESTABLEBORROWRATE_EVENT, transactionReceipt);
        ArrayList<RebalanceStableBorrowRateEventResponse> responses = new ArrayList<RebalanceStableBorrowRateEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RebalanceStableBorrowRateEventResponse typedResponse = new RebalanceStableBorrowRateEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._reserve = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._user = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._newStableRate = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._borrowBalanceIncrease = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse._timestamp = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RebalanceStableBorrowRateEventResponse> rebalanceStableBorrowRateEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, RebalanceStableBorrowRateEventResponse>() {
            @Override
            public RebalanceStableBorrowRateEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(REBALANCESTABLEBORROWRATE_EVENT, log);
                RebalanceStableBorrowRateEventResponse typedResponse = new RebalanceStableBorrowRateEventResponse();
                typedResponse.log = log;
                typedResponse._reserve = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._user = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._newStableRate = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._borrowBalanceIncrease = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse._timestamp = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RebalanceStableBorrowRateEventResponse> rebalanceStableBorrowRateEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(REBALANCESTABLEBORROWRATE_EVENT));
        return rebalanceStableBorrowRateEventFlowable(filter);
    }

    public List<RedeemUnderlyingEventResponse> getRedeemUnderlyingEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(REDEEMUNDERLYING_EVENT, transactionReceipt);
        ArrayList<RedeemUnderlyingEventResponse> responses = new ArrayList<RedeemUnderlyingEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RedeemUnderlyingEventResponse typedResponse = new RedeemUnderlyingEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._reserve = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._user = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._timestamp = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RedeemUnderlyingEventResponse> redeemUnderlyingEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, RedeemUnderlyingEventResponse>() {
            @Override
            public RedeemUnderlyingEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(REDEEMUNDERLYING_EVENT, log);
                RedeemUnderlyingEventResponse typedResponse = new RedeemUnderlyingEventResponse();
                typedResponse.log = log;
                typedResponse._reserve = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._user = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._timestamp = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RedeemUnderlyingEventResponse> redeemUnderlyingEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(REDEEMUNDERLYING_EVENT));
        return redeemUnderlyingEventFlowable(filter);
    }

    public List<RepayEventResponse> getRepayEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(REPAY_EVENT, transactionReceipt);
        ArrayList<RepayEventResponse> responses = new ArrayList<RepayEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RepayEventResponse typedResponse = new RepayEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._reserve = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._user = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._repayer = (String) eventValues.getIndexedValues().get(2).getValue();
            typedResponse._amountMinusFees = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._fees = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse._borrowBalanceIncrease = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse._timestamp = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RepayEventResponse> repayEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, RepayEventResponse>() {
            @Override
            public RepayEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(REPAY_EVENT, log);
                RepayEventResponse typedResponse = new RepayEventResponse();
                typedResponse.log = log;
                typedResponse._reserve = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._user = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._repayer = (String) eventValues.getIndexedValues().get(2).getValue();
                typedResponse._amountMinusFees = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._fees = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse._borrowBalanceIncrease = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse._timestamp = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RepayEventResponse> repayEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(REPAY_EVENT));
        return repayEventFlowable(filter);
    }

    public List<ReserveUsedAsCollateralDisabledEventResponse> getReserveUsedAsCollateralDisabledEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(RESERVEUSEDASCOLLATERALDISABLED_EVENT, transactionReceipt);
        ArrayList<ReserveUsedAsCollateralDisabledEventResponse> responses = new ArrayList<ReserveUsedAsCollateralDisabledEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ReserveUsedAsCollateralDisabledEventResponse typedResponse = new ReserveUsedAsCollateralDisabledEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._reserve = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._user = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ReserveUsedAsCollateralDisabledEventResponse> reserveUsedAsCollateralDisabledEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ReserveUsedAsCollateralDisabledEventResponse>() {
            @Override
            public ReserveUsedAsCollateralDisabledEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(RESERVEUSEDASCOLLATERALDISABLED_EVENT, log);
                ReserveUsedAsCollateralDisabledEventResponse typedResponse = new ReserveUsedAsCollateralDisabledEventResponse();
                typedResponse.log = log;
                typedResponse._reserve = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._user = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ReserveUsedAsCollateralDisabledEventResponse> reserveUsedAsCollateralDisabledEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RESERVEUSEDASCOLLATERALDISABLED_EVENT));
        return reserveUsedAsCollateralDisabledEventFlowable(filter);
    }

    public List<ReserveUsedAsCollateralEnabledEventResponse> getReserveUsedAsCollateralEnabledEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(RESERVEUSEDASCOLLATERALENABLED_EVENT, transactionReceipt);
        ArrayList<ReserveUsedAsCollateralEnabledEventResponse> responses = new ArrayList<ReserveUsedAsCollateralEnabledEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ReserveUsedAsCollateralEnabledEventResponse typedResponse = new ReserveUsedAsCollateralEnabledEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._reserve = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._user = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ReserveUsedAsCollateralEnabledEventResponse> reserveUsedAsCollateralEnabledEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ReserveUsedAsCollateralEnabledEventResponse>() {
            @Override
            public ReserveUsedAsCollateralEnabledEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(RESERVEUSEDASCOLLATERALENABLED_EVENT, log);
                ReserveUsedAsCollateralEnabledEventResponse typedResponse = new ReserveUsedAsCollateralEnabledEventResponse();
                typedResponse.log = log;
                typedResponse._reserve = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._user = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ReserveUsedAsCollateralEnabledEventResponse> reserveUsedAsCollateralEnabledEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RESERVEUSEDASCOLLATERALENABLED_EVENT));
        return reserveUsedAsCollateralEnabledEventFlowable(filter);
    }

    public List<SwapEventResponse> getSwapEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(SWAP_EVENT, transactionReceipt);
        ArrayList<SwapEventResponse> responses = new ArrayList<SwapEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SwapEventResponse typedResponse = new SwapEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._reserve = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._user = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._newRateMode = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._newRate = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse._borrowBalanceIncrease = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse._timestamp = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<SwapEventResponse> swapEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, SwapEventResponse>() {
            @Override
            public SwapEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(SWAP_EVENT, log);
                SwapEventResponse typedResponse = new SwapEventResponse();
                typedResponse.log = log;
                typedResponse._reserve = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._user = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._newRateMode = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._newRate = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse._borrowBalanceIncrease = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse._timestamp = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<SwapEventResponse> swapEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SWAP_EVENT));
        return swapEventFlowable(filter);
    }

    public RemoteCall<BigInteger> LENDINGPOOL_REVISION() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_LENDINGPOOL_REVISION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> UINT_MAX_VALUE() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_UINT_MAX_VALUE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> addressesProvider() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ADDRESSESPROVIDER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> core() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_CORE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> dataProvider() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DATAPROVIDER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> parametersProvider() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PARAMETERSPROVIDER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> initialize(String _addressesProvider) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_INITIALIZE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_addressesProvider)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> deposit(String _reserve, BigInteger _amount, BigInteger _referralCode, BigInteger weiValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_DEPOSIT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_reserve), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount), 
                new org.web3j.abi.datatypes.generated.Uint16(_referralCode)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> redeemUnderlying(String _reserve, String _user, BigInteger _amount, BigInteger _aTokenBalanceAfterRedeem) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REDEEMUNDERLYING, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_reserve), 
                new org.web3j.abi.datatypes.Address(_user), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount), 
                new org.web3j.abi.datatypes.generated.Uint256(_aTokenBalanceAfterRedeem)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> borrow(String _reserve, BigInteger _amount, BigInteger _interestRateMode, BigInteger _referralCode) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_BORROW, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_reserve), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount), 
                new org.web3j.abi.datatypes.generated.Uint256(_interestRateMode), 
                new org.web3j.abi.datatypes.generated.Uint16(_referralCode)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> repay(String _reserve, BigInteger _amount, String _onBehalfOf, BigInteger weiValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REPAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_reserve), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount), 
                new org.web3j.abi.datatypes.Address(_onBehalfOf)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> swapBorrowRateMode(String _reserve) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SWAPBORROWRATEMODE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_reserve)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> rebalanceStableBorrowRate(String _reserve, String _user) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REBALANCESTABLEBORROWRATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_reserve), 
                new org.web3j.abi.datatypes.Address(_user)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setUserUseReserveAsCollateral(String _reserve, Boolean _useAsCollateral) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETUSERUSERESERVEASCOLLATERAL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_reserve), 
                new org.web3j.abi.datatypes.Bool(_useAsCollateral)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> liquidationCall(String _collateral, String _reserve, String _user, BigInteger _purchaseAmount, Boolean _receiveAToken, BigInteger weiValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_LIQUIDATIONCALL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_collateral), 
                new org.web3j.abi.datatypes.Address(_reserve), 
                new org.web3j.abi.datatypes.Address(_user), 
                new org.web3j.abi.datatypes.generated.Uint256(_purchaseAmount), 
                new org.web3j.abi.datatypes.Bool(_receiveAToken)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> flashLoan(String _receiver, String _reserve, BigInteger _amount, byte[] _params) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_FLASHLOAN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_receiver), 
                new org.web3j.abi.datatypes.Address(_reserve), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount), 
                new org.web3j.abi.datatypes.DynamicBytes(_params)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple8<BigInteger, BigInteger, BigInteger, String, Boolean, Boolean, Boolean, Boolean>> getReserveConfigurationData(String _reserve) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETRESERVECONFIGURATIONDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_reserve)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Bool>() {}, new TypeReference<Bool>() {}, new TypeReference<Bool>() {}));
        return new RemoteCall<Tuple8<BigInteger, BigInteger, BigInteger, String, Boolean, Boolean, Boolean, Boolean>>(
                new Callable<Tuple8<BigInteger, BigInteger, BigInteger, String, Boolean, Boolean, Boolean, Boolean>>() {
                    @Override
                    public Tuple8<BigInteger, BigInteger, BigInteger, String, Boolean, Boolean, Boolean, Boolean> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple8<BigInteger, BigInteger, BigInteger, String, Boolean, Boolean, Boolean, Boolean>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (Boolean) results.get(4).getValue(), 
                                (Boolean) results.get(5).getValue(), 
                                (Boolean) results.get(6).getValue(), 
                                (Boolean) results.get(7).getValue());
                    }
                });
    }

    public RemoteCall<Tuple13<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, BigInteger>> getReserveData(String _reserve) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETRESERVEDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_reserve)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Uint40>() {}));
        return new RemoteCall<Tuple13<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, BigInteger>>(
                new Callable<Tuple13<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, BigInteger>>() {
                    @Override
                    public Tuple13<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple13<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue(), 
                                (BigInteger) results.get(6).getValue(), 
                                (BigInteger) results.get(7).getValue(), 
                                (BigInteger) results.get(8).getValue(), 
                                (BigInteger) results.get(9).getValue(), 
                                (BigInteger) results.get(10).getValue(), 
                                (String) results.get(11).getValue(), 
                                (BigInteger) results.get(12).getValue());
                    }
                });
    }

    public RemoteCall<Tuple8<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>> getUserAccountData(String _user) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETUSERACCOUNTDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_user)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple8<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>>(
                new Callable<Tuple8<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple8<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple8<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue(), 
                                (BigInteger) results.get(6).getValue(), 
                                (BigInteger) results.get(7).getValue());
                    }
                });
    }

    public RemoteCall<Tuple10<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, Boolean>> getUserReserveData(String _reserve, String _user) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETUSERRESERVEDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_reserve), 
                new org.web3j.abi.datatypes.Address(_user)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}));
        return new RemoteCall<Tuple10<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, Boolean>>(
                new Callable<Tuple10<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, Boolean>>() {
                    @Override
                    public Tuple10<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, Boolean> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple10<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, Boolean>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue(), 
                                (BigInteger) results.get(6).getValue(), 
                                (BigInteger) results.get(7).getValue(), 
                                (BigInteger) results.get(8).getValue(), 
                                (Boolean) results.get(9).getValue());
                    }
                });
    }

    public RemoteCall<List> getReserves() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETRESERVES, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return new RemoteCall<List>(
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    @Deprecated
    public static LP load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new LP(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static LP load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new LP(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static LP load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new LP(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static LP load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new LP(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static class BorrowEventResponse {
        public Log log;

        public String _reserve;

        public String _user;

        public BigInteger _referral;

        public BigInteger _amount;

        public BigInteger _borrowRateMode;

        public BigInteger _borrowRate;

        public BigInteger _originationFee;

        public BigInteger _borrowBalanceIncrease;

        public BigInteger _timestamp;
    }

    public static class DepositEventResponse {
        public Log log;

        public String _reserve;

        public String _user;

        public BigInteger _referral;

        public BigInteger _amount;

        public BigInteger _timestamp;
    }

    public static class FlashLoanEventResponse {
        public Log log;

        public String _target;

        public String _reserve;

        public BigInteger _amount;

        public BigInteger _totalFee;

        public BigInteger _protocolFee;

        public BigInteger _timestamp;
    }

    public static class LiquidationCallEventResponse {
        public Log log;

        public String _collateral;

        public String _reserve;

        public String _user;

        public BigInteger _purchaseAmount;

        public BigInteger _liquidatedCollateralAmount;

        public BigInteger _accruedBorrowInterest;

        public String _liquidator;

        public Boolean _receiveAToken;

        public BigInteger _timestamp;
    }

    public static class OriginationFeeLiquidatedEventResponse {
        public Log log;

        public String _collateral;

        public String _reserve;

        public String _user;

        public BigInteger _feeLiquidated;

        public BigInteger _liquidatedCollateralForFee;

        public BigInteger _timestamp;
    }

    public static class RebalanceStableBorrowRateEventResponse {
        public Log log;

        public String _reserve;

        public String _user;

        public BigInteger _newStableRate;

        public BigInteger _borrowBalanceIncrease;

        public BigInteger _timestamp;
    }

    public static class RedeemUnderlyingEventResponse {
        public Log log;

        public String _reserve;

        public String _user;

        public BigInteger _amount;

        public BigInteger _timestamp;
    }

    public static class RepayEventResponse {
        public Log log;

        public String _reserve;

        public String _user;

        public String _repayer;

        public BigInteger _amountMinusFees;

        public BigInteger _fees;

        public BigInteger _borrowBalanceIncrease;

        public BigInteger _timestamp;
    }

    public static class ReserveUsedAsCollateralDisabledEventResponse {
        public Log log;

        public String _reserve;

        public String _user;
    }

    public static class ReserveUsedAsCollateralEnabledEventResponse {
        public Log log;

        public String _reserve;

        public String _user;
    }

    public static class SwapEventResponse {
        public Log log;

        public String _reserve;

        public String _user;

        public BigInteger _newRateMode;

        public BigInteger _newRate;

        public BigInteger _borrowBalanceIncrease;

        public BigInteger _timestamp;
    }
}
