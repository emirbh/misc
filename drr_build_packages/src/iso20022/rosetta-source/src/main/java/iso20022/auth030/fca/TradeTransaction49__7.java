package iso20022.auth030.fca;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import iso20022.auth030.fca.meta.TradeTransaction49__7Meta;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Provides details of the trade transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeTransaction49__7", builder=TradeTransaction49__7.TradeTransaction49__7BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeTransaction49__7", model="iso20022", builder=TradeTransaction49__7.TradeTransaction49__7BuilderImpl.class, version="${project.version}")
public interface TradeTransaction49__7 extends RosettaModelObject {

	TradeTransaction49__7Meta metaData = new TradeTransaction49__7Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Choice between a Unique Transaction Identifier (UTI) or a proprietary identifier as agreed with the counterparty.
	 */
	UniqueTransactionIdentifier2Choice__2 getTxId();
	/**
	 * Choice between a Unique Transaction Identifier (UTI) or a proprietary identifier assigned to the predecessor transaction that has given rise to the reported transaction due to a lifecycle event.   Usage: This data element is not applicable when reporting many-to-one and many-to-many relations between transactions (for example, in the case of a compression).  This data element may be applicable when reporting one-to-one and one-to-many relations between transactions (for example, in the case of a clearing).
	 */
	UniqueTransactionIdentifier3Choice__1 getPrrTxId();
	/**
	 * Choice between a Unique Transaction Identifier (UTI) or a proprietary identifier of the position in which a derivative is included. This field is applicable only for the reports related to the termination of a derivative due to its inclusion in a position.
	 */
	UniqueTransactionIdentifier3Choice__1 getSbsqntTxId();
	/**
	 * Specifies the unique code assigned by the reporting counterparty to the portfolio if the collateral is posted on a portfolio basis.
	 */
	CollateralPortfolioCode5Choice__1 getCollPrtflCd();
	/**
	 * Unique number to indicate a group of reports which relate to the same execution.
	 */
	String getRptTrckgNb();
	/**
	 * Identifies the trading platform on which the derivative transaction was executed (for example, exchange, multilateral trading facility, swap execution facility).   Usage: For transactions where no trading facility was involved, specific predefined codes have to be used.
	 */
	String getPltfmIdr();
	/**
	 * Indicates the price per derivative excluding, where applicable, commission and accrued interest.
	 */
	PriceData2__1 getTxPric();
	/**
	 * Indicates monetary or converted amount for the derivatives transaction.  Usage: In case of partial terminations, and amortisations and in case of contracts where the notional, due to the characteristics of the contract, varies over time, it shall reflect the remaining notional after the change took place.
	 */
	NotionalAmountLegs5__1 getNtnlAmt();
	/**
	 * Indicates for each leg of the transaction the total notional quantity of the underlying asset for the term of the transaction.
	 */
	NotionalQuantityLegs5__1 getNtnlQty();
	/**
	 * Indicates whether the financial instrument is settled physically or in cash or decided at expiration time by counterparty.
	 */
	PhysicalTransferType4Code getDlvryTp();
	/**
	 * Indicates the date and time of the execution of the derivative transaction.
	 */
	ZonedDateTime getExctnTmStmp();
	/**
	 * Indicates the date when obligations under the contract come into effect.
	 */
	Date getFctvDt();
	/**
	 * Indicates the unadjusted date at which obligations under the derivative transaction stop being effective, as included in the confirmation.   For European style options, date on which the holder can exercise the right or let it lapse.  For American style options, the holder can exercise the right up to the expiry date.   Usage:  An early termination shall not be reported in this field.
	 */
	Date getXprtnDt();
	/**
	 * Indicates the effective date of the early termination of the reported derivative transaction.
	 */
	Date getEarlyTermntnDt();
	/**
	 * Indicates the unadjusted date, as per the contract, by which all transfer of cash or assets should take place and the counterparties should no longer have any outstanding obligations to each other.   For products that may not have a final contractual settlement date (eg American options), this data element reflects the date by which the transfer of cash or asset would take place if termination were to occur on the expiration date.
	 */
	Date getSttlmDt();
	/**
	 * Details related to the master agreement.
	 */
	MasterAgreement8__1 getMstrAgrmt();
	/**
	 * Indicates whether the contract results from a PTRR operation.
	 */
	Boolean getPstTradRskRdctnFlg();
	/**
	 * Identify whether the contract results from a Post Trade Risk Reduction operation.
	 */
	PTRREvent2__1 getPstTradRskRdctnEvt();
	/**
	 * Indication of the derivative event of the transaction.
	 */
	DerivativeEvent6__3 getDerivEvt();
	/**
	 * Specifies whether the contract was electronically confirmed, non-electronically confirmed or remains unconfirmed.
	 */
	TradeConfirmation1Choice getTradConf();
	/**
	 * Information related to clearing of the reported contract.
	 */
	TradeClearing11__1 getTradClr();
	/**
	 * Information related to interest rate asset class type.
	 */
	InterestRateLegs14__1 getIntrstRate();
	/**
	 * Information related to currency asset class type.
	 */
	CurrencyExchange22__1 getCcy();
	/**
	 * Information related to commodity asset class type.
	 */
	AssetClassCommodity6Choice__1 getCmmdty();
	/**
	 * Information related to credit derivative asset class type.
	 */
	OptionOrSwaption10__1 getOptn();
	/**
	 * Attributes specific for derivative contracts related to natural gas and electricity.
	 */
	EnergySpecificAttribute9__1 getNrgySpcfcAttrbts();
	/**
	 * Information related to credit derivative asset class type.
	 */
	CreditDerivative4__1 getCdt();
	/**
	 * Payment related to elements not reported in dedicated fields.
	 */
	List<? extends OtherPayment5__1> getOthrPmt();
	/**
	 * A combination of two or more transactions that are reported separately but that are negotiated together as the product of a single economic agreement.
	 */
	Package4__1 getPackg();

	/*********************** Build Methods  ***********************/
	TradeTransaction49__7 build();
	
	TradeTransaction49__7.TradeTransaction49__7Builder toBuilder();
	
	static TradeTransaction49__7.TradeTransaction49__7Builder builder() {
		return new TradeTransaction49__7.TradeTransaction49__7BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeTransaction49__7> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeTransaction49__7> getType() {
		return TradeTransaction49__7.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("txId"), processor, UniqueTransactionIdentifier2Choice__2.class, getTxId());
		processRosetta(path.newSubPath("prrTxId"), processor, UniqueTransactionIdentifier3Choice__1.class, getPrrTxId());
		processRosetta(path.newSubPath("sbsqntTxId"), processor, UniqueTransactionIdentifier3Choice__1.class, getSbsqntTxId());
		processRosetta(path.newSubPath("collPrtflCd"), processor, CollateralPortfolioCode5Choice__1.class, getCollPrtflCd());
		processor.processBasic(path.newSubPath("rptTrckgNb"), String.class, getRptTrckgNb(), this);
		processor.processBasic(path.newSubPath("pltfmIdr"), String.class, getPltfmIdr(), this);
		processRosetta(path.newSubPath("txPric"), processor, PriceData2__1.class, getTxPric());
		processRosetta(path.newSubPath("ntnlAmt"), processor, NotionalAmountLegs5__1.class, getNtnlAmt());
		processRosetta(path.newSubPath("ntnlQty"), processor, NotionalQuantityLegs5__1.class, getNtnlQty());
		processor.processBasic(path.newSubPath("dlvryTp"), PhysicalTransferType4Code.class, getDlvryTp(), this);
		processor.processBasic(path.newSubPath("exctnTmStmp"), ZonedDateTime.class, getExctnTmStmp(), this);
		processor.processBasic(path.newSubPath("fctvDt"), Date.class, getFctvDt(), this);
		processor.processBasic(path.newSubPath("xprtnDt"), Date.class, getXprtnDt(), this);
		processor.processBasic(path.newSubPath("earlyTermntnDt"), Date.class, getEarlyTermntnDt(), this);
		processor.processBasic(path.newSubPath("sttlmDt"), Date.class, getSttlmDt(), this);
		processRosetta(path.newSubPath("mstrAgrmt"), processor, MasterAgreement8__1.class, getMstrAgrmt());
		processor.processBasic(path.newSubPath("pstTradRskRdctnFlg"), Boolean.class, getPstTradRskRdctnFlg(), this);
		processRosetta(path.newSubPath("pstTradRskRdctnEvt"), processor, PTRREvent2__1.class, getPstTradRskRdctnEvt());
		processRosetta(path.newSubPath("derivEvt"), processor, DerivativeEvent6__3.class, getDerivEvt());
		processRosetta(path.newSubPath("tradConf"), processor, TradeConfirmation1Choice.class, getTradConf());
		processRosetta(path.newSubPath("tradClr"), processor, TradeClearing11__1.class, getTradClr());
		processRosetta(path.newSubPath("intrstRate"), processor, InterestRateLegs14__1.class, getIntrstRate());
		processRosetta(path.newSubPath("ccy"), processor, CurrencyExchange22__1.class, getCcy());
		processRosetta(path.newSubPath("cmmdty"), processor, AssetClassCommodity6Choice__1.class, getCmmdty());
		processRosetta(path.newSubPath("optn"), processor, OptionOrSwaption10__1.class, getOptn());
		processRosetta(path.newSubPath("nrgySpcfcAttrbts"), processor, EnergySpecificAttribute9__1.class, getNrgySpcfcAttrbts());
		processRosetta(path.newSubPath("cdt"), processor, CreditDerivative4__1.class, getCdt());
		processRosetta(path.newSubPath("othrPmt"), processor, OtherPayment5__1.class, getOthrPmt());
		processRosetta(path.newSubPath("packg"), processor, Package4__1.class, getPackg());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeTransaction49__7Builder extends TradeTransaction49__7, RosettaModelObjectBuilder {
		UniqueTransactionIdentifier2Choice__2.UniqueTransactionIdentifier2Choice__2Builder getOrCreateTxId();
		@Override
		UniqueTransactionIdentifier2Choice__2.UniqueTransactionIdentifier2Choice__2Builder getTxId();
		UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder getOrCreatePrrTxId();
		@Override
		UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder getPrrTxId();
		UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder getOrCreateSbsqntTxId();
		@Override
		UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder getSbsqntTxId();
		CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Builder getOrCreateCollPrtflCd();
		@Override
		CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Builder getCollPrtflCd();
		PriceData2__1.PriceData2__1Builder getOrCreateTxPric();
		@Override
		PriceData2__1.PriceData2__1Builder getTxPric();
		NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder getOrCreateNtnlAmt();
		@Override
		NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder getNtnlAmt();
		NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder getOrCreateNtnlQty();
		@Override
		NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder getNtnlQty();
		MasterAgreement8__1.MasterAgreement8__1Builder getOrCreateMstrAgrmt();
		@Override
		MasterAgreement8__1.MasterAgreement8__1Builder getMstrAgrmt();
		PTRREvent2__1.PTRREvent2__1Builder getOrCreatePstTradRskRdctnEvt();
		@Override
		PTRREvent2__1.PTRREvent2__1Builder getPstTradRskRdctnEvt();
		DerivativeEvent6__3.DerivativeEvent6__3Builder getOrCreateDerivEvt();
		@Override
		DerivativeEvent6__3.DerivativeEvent6__3Builder getDerivEvt();
		TradeConfirmation1Choice.TradeConfirmation1ChoiceBuilder getOrCreateTradConf();
		@Override
		TradeConfirmation1Choice.TradeConfirmation1ChoiceBuilder getTradConf();
		TradeClearing11__1.TradeClearing11__1Builder getOrCreateTradClr();
		@Override
		TradeClearing11__1.TradeClearing11__1Builder getTradClr();
		InterestRateLegs14__1.InterestRateLegs14__1Builder getOrCreateIntrstRate();
		@Override
		InterestRateLegs14__1.InterestRateLegs14__1Builder getIntrstRate();
		CurrencyExchange22__1.CurrencyExchange22__1Builder getOrCreateCcy();
		@Override
		CurrencyExchange22__1.CurrencyExchange22__1Builder getCcy();
		AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder getOrCreateCmmdty();
		@Override
		AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder getCmmdty();
		OptionOrSwaption10__1.OptionOrSwaption10__1Builder getOrCreateOptn();
		@Override
		OptionOrSwaption10__1.OptionOrSwaption10__1Builder getOptn();
		EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder getOrCreateNrgySpcfcAttrbts();
		@Override
		EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder getNrgySpcfcAttrbts();
		CreditDerivative4__1.CreditDerivative4__1Builder getOrCreateCdt();
		@Override
		CreditDerivative4__1.CreditDerivative4__1Builder getCdt();
		OtherPayment5__1.OtherPayment5__1Builder getOrCreateOthrPmt(int index);
		@Override
		List<? extends OtherPayment5__1.OtherPayment5__1Builder> getOthrPmt();
		Package4__1.Package4__1Builder getOrCreatePackg();
		@Override
		Package4__1.Package4__1Builder getPackg();
		TradeTransaction49__7.TradeTransaction49__7Builder setTxId(UniqueTransactionIdentifier2Choice__2 txId);
		TradeTransaction49__7.TradeTransaction49__7Builder setPrrTxId(UniqueTransactionIdentifier3Choice__1 prrTxId);
		TradeTransaction49__7.TradeTransaction49__7Builder setSbsqntTxId(UniqueTransactionIdentifier3Choice__1 sbsqntTxId);
		TradeTransaction49__7.TradeTransaction49__7Builder setCollPrtflCd(CollateralPortfolioCode5Choice__1 collPrtflCd);
		TradeTransaction49__7.TradeTransaction49__7Builder setRptTrckgNb(String rptTrckgNb);
		TradeTransaction49__7.TradeTransaction49__7Builder setPltfmIdr(String pltfmIdr);
		TradeTransaction49__7.TradeTransaction49__7Builder setTxPric(PriceData2__1 txPric);
		TradeTransaction49__7.TradeTransaction49__7Builder setNtnlAmt(NotionalAmountLegs5__1 ntnlAmt);
		TradeTransaction49__7.TradeTransaction49__7Builder setNtnlQty(NotionalQuantityLegs5__1 ntnlQty);
		TradeTransaction49__7.TradeTransaction49__7Builder setDlvryTp(PhysicalTransferType4Code dlvryTp);
		TradeTransaction49__7.TradeTransaction49__7Builder setExctnTmStmp(ZonedDateTime exctnTmStmp);
		TradeTransaction49__7.TradeTransaction49__7Builder setFctvDt(Date fctvDt);
		TradeTransaction49__7.TradeTransaction49__7Builder setXprtnDt(Date xprtnDt);
		TradeTransaction49__7.TradeTransaction49__7Builder setEarlyTermntnDt(Date earlyTermntnDt);
		TradeTransaction49__7.TradeTransaction49__7Builder setSttlmDt(Date sttlmDt);
		TradeTransaction49__7.TradeTransaction49__7Builder setMstrAgrmt(MasterAgreement8__1 mstrAgrmt);
		TradeTransaction49__7.TradeTransaction49__7Builder setPstTradRskRdctnFlg(Boolean pstTradRskRdctnFlg);
		TradeTransaction49__7.TradeTransaction49__7Builder setPstTradRskRdctnEvt(PTRREvent2__1 pstTradRskRdctnEvt);
		TradeTransaction49__7.TradeTransaction49__7Builder setDerivEvt(DerivativeEvent6__3 derivEvt);
		TradeTransaction49__7.TradeTransaction49__7Builder setTradConf(TradeConfirmation1Choice tradConf);
		TradeTransaction49__7.TradeTransaction49__7Builder setTradClr(TradeClearing11__1 tradClr);
		TradeTransaction49__7.TradeTransaction49__7Builder setIntrstRate(InterestRateLegs14__1 intrstRate);
		TradeTransaction49__7.TradeTransaction49__7Builder setCcy(CurrencyExchange22__1 ccy);
		TradeTransaction49__7.TradeTransaction49__7Builder setCmmdty(AssetClassCommodity6Choice__1 cmmdty);
		TradeTransaction49__7.TradeTransaction49__7Builder setOptn(OptionOrSwaption10__1 optn);
		TradeTransaction49__7.TradeTransaction49__7Builder setNrgySpcfcAttrbts(EnergySpecificAttribute9__1 nrgySpcfcAttrbts);
		TradeTransaction49__7.TradeTransaction49__7Builder setCdt(CreditDerivative4__1 cdt);
		TradeTransaction49__7.TradeTransaction49__7Builder addOthrPmt(OtherPayment5__1 othrPmt);
		TradeTransaction49__7.TradeTransaction49__7Builder addOthrPmt(OtherPayment5__1 othrPmt, int idx);
		TradeTransaction49__7.TradeTransaction49__7Builder addOthrPmt(List<? extends OtherPayment5__1> othrPmt);
		TradeTransaction49__7.TradeTransaction49__7Builder setOthrPmt(List<? extends OtherPayment5__1> othrPmt);
		TradeTransaction49__7.TradeTransaction49__7Builder setPackg(Package4__1 packg);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("txId"), processor, UniqueTransactionIdentifier2Choice__2.UniqueTransactionIdentifier2Choice__2Builder.class, getTxId());
			processRosetta(path.newSubPath("prrTxId"), processor, UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder.class, getPrrTxId());
			processRosetta(path.newSubPath("sbsqntTxId"), processor, UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder.class, getSbsqntTxId());
			processRosetta(path.newSubPath("collPrtflCd"), processor, CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Builder.class, getCollPrtflCd());
			processor.processBasic(path.newSubPath("rptTrckgNb"), String.class, getRptTrckgNb(), this);
			processor.processBasic(path.newSubPath("pltfmIdr"), String.class, getPltfmIdr(), this);
			processRosetta(path.newSubPath("txPric"), processor, PriceData2__1.PriceData2__1Builder.class, getTxPric());
			processRosetta(path.newSubPath("ntnlAmt"), processor, NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder.class, getNtnlAmt());
			processRosetta(path.newSubPath("ntnlQty"), processor, NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder.class, getNtnlQty());
			processor.processBasic(path.newSubPath("dlvryTp"), PhysicalTransferType4Code.class, getDlvryTp(), this);
			processor.processBasic(path.newSubPath("exctnTmStmp"), ZonedDateTime.class, getExctnTmStmp(), this);
			processor.processBasic(path.newSubPath("fctvDt"), Date.class, getFctvDt(), this);
			processor.processBasic(path.newSubPath("xprtnDt"), Date.class, getXprtnDt(), this);
			processor.processBasic(path.newSubPath("earlyTermntnDt"), Date.class, getEarlyTermntnDt(), this);
			processor.processBasic(path.newSubPath("sttlmDt"), Date.class, getSttlmDt(), this);
			processRosetta(path.newSubPath("mstrAgrmt"), processor, MasterAgreement8__1.MasterAgreement8__1Builder.class, getMstrAgrmt());
			processor.processBasic(path.newSubPath("pstTradRskRdctnFlg"), Boolean.class, getPstTradRskRdctnFlg(), this);
			processRosetta(path.newSubPath("pstTradRskRdctnEvt"), processor, PTRREvent2__1.PTRREvent2__1Builder.class, getPstTradRskRdctnEvt());
			processRosetta(path.newSubPath("derivEvt"), processor, DerivativeEvent6__3.DerivativeEvent6__3Builder.class, getDerivEvt());
			processRosetta(path.newSubPath("tradConf"), processor, TradeConfirmation1Choice.TradeConfirmation1ChoiceBuilder.class, getTradConf());
			processRosetta(path.newSubPath("tradClr"), processor, TradeClearing11__1.TradeClearing11__1Builder.class, getTradClr());
			processRosetta(path.newSubPath("intrstRate"), processor, InterestRateLegs14__1.InterestRateLegs14__1Builder.class, getIntrstRate());
			processRosetta(path.newSubPath("ccy"), processor, CurrencyExchange22__1.CurrencyExchange22__1Builder.class, getCcy());
			processRosetta(path.newSubPath("cmmdty"), processor, AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder.class, getCmmdty());
			processRosetta(path.newSubPath("optn"), processor, OptionOrSwaption10__1.OptionOrSwaption10__1Builder.class, getOptn());
			processRosetta(path.newSubPath("nrgySpcfcAttrbts"), processor, EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder.class, getNrgySpcfcAttrbts());
			processRosetta(path.newSubPath("cdt"), processor, CreditDerivative4__1.CreditDerivative4__1Builder.class, getCdt());
			processRosetta(path.newSubPath("othrPmt"), processor, OtherPayment5__1.OtherPayment5__1Builder.class, getOthrPmt());
			processRosetta(path.newSubPath("packg"), processor, Package4__1.Package4__1Builder.class, getPackg());
		}
		

		TradeTransaction49__7.TradeTransaction49__7Builder prune();
	}

	/*********************** Immutable Implementation of TradeTransaction49__7  ***********************/
	class TradeTransaction49__7Impl implements TradeTransaction49__7 {
		private final UniqueTransactionIdentifier2Choice__2 txId;
		private final UniqueTransactionIdentifier3Choice__1 prrTxId;
		private final UniqueTransactionIdentifier3Choice__1 sbsqntTxId;
		private final CollateralPortfolioCode5Choice__1 collPrtflCd;
		private final String rptTrckgNb;
		private final String pltfmIdr;
		private final PriceData2__1 txPric;
		private final NotionalAmountLegs5__1 ntnlAmt;
		private final NotionalQuantityLegs5__1 ntnlQty;
		private final PhysicalTransferType4Code dlvryTp;
		private final ZonedDateTime exctnTmStmp;
		private final Date fctvDt;
		private final Date xprtnDt;
		private final Date earlyTermntnDt;
		private final Date sttlmDt;
		private final MasterAgreement8__1 mstrAgrmt;
		private final Boolean pstTradRskRdctnFlg;
		private final PTRREvent2__1 pstTradRskRdctnEvt;
		private final DerivativeEvent6__3 derivEvt;
		private final TradeConfirmation1Choice tradConf;
		private final TradeClearing11__1 tradClr;
		private final InterestRateLegs14__1 intrstRate;
		private final CurrencyExchange22__1 ccy;
		private final AssetClassCommodity6Choice__1 cmmdty;
		private final OptionOrSwaption10__1 optn;
		private final EnergySpecificAttribute9__1 nrgySpcfcAttrbts;
		private final CreditDerivative4__1 cdt;
		private final List<? extends OtherPayment5__1> othrPmt;
		private final Package4__1 packg;
		
		protected TradeTransaction49__7Impl(TradeTransaction49__7.TradeTransaction49__7Builder builder) {
			this.txId = ofNullable(builder.getTxId()).map(f->f.build()).orElse(null);
			this.prrTxId = ofNullable(builder.getPrrTxId()).map(f->f.build()).orElse(null);
			this.sbsqntTxId = ofNullable(builder.getSbsqntTxId()).map(f->f.build()).orElse(null);
			this.collPrtflCd = ofNullable(builder.getCollPrtflCd()).map(f->f.build()).orElse(null);
			this.rptTrckgNb = builder.getRptTrckgNb();
			this.pltfmIdr = builder.getPltfmIdr();
			this.txPric = ofNullable(builder.getTxPric()).map(f->f.build()).orElse(null);
			this.ntnlAmt = ofNullable(builder.getNtnlAmt()).map(f->f.build()).orElse(null);
			this.ntnlQty = ofNullable(builder.getNtnlQty()).map(f->f.build()).orElse(null);
			this.dlvryTp = builder.getDlvryTp();
			this.exctnTmStmp = builder.getExctnTmStmp();
			this.fctvDt = builder.getFctvDt();
			this.xprtnDt = builder.getXprtnDt();
			this.earlyTermntnDt = builder.getEarlyTermntnDt();
			this.sttlmDt = builder.getSttlmDt();
			this.mstrAgrmt = ofNullable(builder.getMstrAgrmt()).map(f->f.build()).orElse(null);
			this.pstTradRskRdctnFlg = builder.getPstTradRskRdctnFlg();
			this.pstTradRskRdctnEvt = ofNullable(builder.getPstTradRskRdctnEvt()).map(f->f.build()).orElse(null);
			this.derivEvt = ofNullable(builder.getDerivEvt()).map(f->f.build()).orElse(null);
			this.tradConf = ofNullable(builder.getTradConf()).map(f->f.build()).orElse(null);
			this.tradClr = ofNullable(builder.getTradClr()).map(f->f.build()).orElse(null);
			this.intrstRate = ofNullable(builder.getIntrstRate()).map(f->f.build()).orElse(null);
			this.ccy = ofNullable(builder.getCcy()).map(f->f.build()).orElse(null);
			this.cmmdty = ofNullable(builder.getCmmdty()).map(f->f.build()).orElse(null);
			this.optn = ofNullable(builder.getOptn()).map(f->f.build()).orElse(null);
			this.nrgySpcfcAttrbts = ofNullable(builder.getNrgySpcfcAttrbts()).map(f->f.build()).orElse(null);
			this.cdt = ofNullable(builder.getCdt()).map(f->f.build()).orElse(null);
			this.othrPmt = ofNullable(builder.getOthrPmt()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.packg = ofNullable(builder.getPackg()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("txId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("txId")
		public UniqueTransactionIdentifier2Choice__2 getTxId() {
			return txId;
		}
		
		@Override
		@RosettaAttribute("prrTxId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prrTxId")
		public UniqueTransactionIdentifier3Choice__1 getPrrTxId() {
			return prrTxId;
		}
		
		@Override
		@RosettaAttribute("sbsqntTxId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sbsqntTxId")
		public UniqueTransactionIdentifier3Choice__1 getSbsqntTxId() {
			return sbsqntTxId;
		}
		
		@Override
		@RosettaAttribute("collPrtflCd")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("collPrtflCd")
		public CollateralPortfolioCode5Choice__1 getCollPrtflCd() {
			return collPrtflCd;
		}
		
		@Override
		@RosettaAttribute("rptTrckgNb")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rptTrckgNb")
		public String getRptTrckgNb() {
			return rptTrckgNb;
		}
		
		@Override
		@RosettaAttribute("pltfmIdr")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("pltfmIdr")
		public String getPltfmIdr() {
			return pltfmIdr;
		}
		
		@Override
		@RosettaAttribute("txPric")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("txPric")
		public PriceData2__1 getTxPric() {
			return txPric;
		}
		
		@Override
		@RosettaAttribute("ntnlAmt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ntnlAmt")
		public NotionalAmountLegs5__1 getNtnlAmt() {
			return ntnlAmt;
		}
		
		@Override
		@RosettaAttribute("ntnlQty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ntnlQty")
		public NotionalQuantityLegs5__1 getNtnlQty() {
			return ntnlQty;
		}
		
		@Override
		@RosettaAttribute("dlvryTp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("dlvryTp")
		public PhysicalTransferType4Code getDlvryTp() {
			return dlvryTp;
		}
		
		@Override
		@RosettaAttribute("exctnTmStmp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("exctnTmStmp")
		public ZonedDateTime getExctnTmStmp() {
			return exctnTmStmp;
		}
		
		@Override
		@RosettaAttribute("fctvDt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("fctvDt")
		public Date getFctvDt() {
			return fctvDt;
		}
		
		@Override
		@RosettaAttribute("xprtnDt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("xprtnDt")
		public Date getXprtnDt() {
			return xprtnDt;
		}
		
		@Override
		@RosettaAttribute("earlyTermntnDt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("earlyTermntnDt")
		public Date getEarlyTermntnDt() {
			return earlyTermntnDt;
		}
		
		@Override
		@RosettaAttribute("sttlmDt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sttlmDt")
		public Date getSttlmDt() {
			return sttlmDt;
		}
		
		@Override
		@RosettaAttribute("mstrAgrmt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("mstrAgrmt")
		public MasterAgreement8__1 getMstrAgrmt() {
			return mstrAgrmt;
		}
		
		@Override
		@RosettaAttribute("pstTradRskRdctnFlg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pstTradRskRdctnFlg")
		public Boolean getPstTradRskRdctnFlg() {
			return pstTradRskRdctnFlg;
		}
		
		@Override
		@RosettaAttribute("pstTradRskRdctnEvt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pstTradRskRdctnEvt")
		public PTRREvent2__1 getPstTradRskRdctnEvt() {
			return pstTradRskRdctnEvt;
		}
		
		@Override
		@RosettaAttribute("derivEvt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("derivEvt")
		public DerivativeEvent6__3 getDerivEvt() {
			return derivEvt;
		}
		
		@Override
		@RosettaAttribute("tradConf")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradConf")
		public TradeConfirmation1Choice getTradConf() {
			return tradConf;
		}
		
		@Override
		@RosettaAttribute("tradClr")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tradClr")
		public TradeClearing11__1 getTradClr() {
			return tradClr;
		}
		
		@Override
		@RosettaAttribute("intrstRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("intrstRate")
		public InterestRateLegs14__1 getIntrstRate() {
			return intrstRate;
		}
		
		@Override
		@RosettaAttribute("ccy")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ccy")
		public CurrencyExchange22__1 getCcy() {
			return ccy;
		}
		
		@Override
		@RosettaAttribute("cmmdty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cmmdty")
		public AssetClassCommodity6Choice__1 getCmmdty() {
			return cmmdty;
		}
		
		@Override
		@RosettaAttribute("optn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optn")
		public OptionOrSwaption10__1 getOptn() {
			return optn;
		}
		
		@Override
		@RosettaAttribute("nrgySpcfcAttrbts")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nrgySpcfcAttrbts")
		public EnergySpecificAttribute9__1 getNrgySpcfcAttrbts() {
			return nrgySpcfcAttrbts;
		}
		
		@Override
		@RosettaAttribute("cdt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cdt")
		public CreditDerivative4__1 getCdt() {
			return cdt;
		}
		
		@Override
		@RosettaAttribute("othrPmt")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("othrPmt")
		public List<? extends OtherPayment5__1> getOthrPmt() {
			return othrPmt;
		}
		
		@Override
		@RosettaAttribute("packg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packg")
		public Package4__1 getPackg() {
			return packg;
		}
		
		@Override
		public TradeTransaction49__7 build() {
			return this;
		}
		
		@Override
		public TradeTransaction49__7.TradeTransaction49__7Builder toBuilder() {
			TradeTransaction49__7.TradeTransaction49__7Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeTransaction49__7.TradeTransaction49__7Builder builder) {
			ofNullable(getTxId()).ifPresent(builder::setTxId);
			ofNullable(getPrrTxId()).ifPresent(builder::setPrrTxId);
			ofNullable(getSbsqntTxId()).ifPresent(builder::setSbsqntTxId);
			ofNullable(getCollPrtflCd()).ifPresent(builder::setCollPrtflCd);
			ofNullable(getRptTrckgNb()).ifPresent(builder::setRptTrckgNb);
			ofNullable(getPltfmIdr()).ifPresent(builder::setPltfmIdr);
			ofNullable(getTxPric()).ifPresent(builder::setTxPric);
			ofNullable(getNtnlAmt()).ifPresent(builder::setNtnlAmt);
			ofNullable(getNtnlQty()).ifPresent(builder::setNtnlQty);
			ofNullable(getDlvryTp()).ifPresent(builder::setDlvryTp);
			ofNullable(getExctnTmStmp()).ifPresent(builder::setExctnTmStmp);
			ofNullable(getFctvDt()).ifPresent(builder::setFctvDt);
			ofNullable(getXprtnDt()).ifPresent(builder::setXprtnDt);
			ofNullable(getEarlyTermntnDt()).ifPresent(builder::setEarlyTermntnDt);
			ofNullable(getSttlmDt()).ifPresent(builder::setSttlmDt);
			ofNullable(getMstrAgrmt()).ifPresent(builder::setMstrAgrmt);
			ofNullable(getPstTradRskRdctnFlg()).ifPresent(builder::setPstTradRskRdctnFlg);
			ofNullable(getPstTradRskRdctnEvt()).ifPresent(builder::setPstTradRskRdctnEvt);
			ofNullable(getDerivEvt()).ifPresent(builder::setDerivEvt);
			ofNullable(getTradConf()).ifPresent(builder::setTradConf);
			ofNullable(getTradClr()).ifPresent(builder::setTradClr);
			ofNullable(getIntrstRate()).ifPresent(builder::setIntrstRate);
			ofNullable(getCcy()).ifPresent(builder::setCcy);
			ofNullable(getCmmdty()).ifPresent(builder::setCmmdty);
			ofNullable(getOptn()).ifPresent(builder::setOptn);
			ofNullable(getNrgySpcfcAttrbts()).ifPresent(builder::setNrgySpcfcAttrbts);
			ofNullable(getCdt()).ifPresent(builder::setCdt);
			ofNullable(getOthrPmt()).ifPresent(builder::setOthrPmt);
			ofNullable(getPackg()).ifPresent(builder::setPackg);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeTransaction49__7 _that = getType().cast(o);
		
			if (!Objects.equals(txId, _that.getTxId())) return false;
			if (!Objects.equals(prrTxId, _that.getPrrTxId())) return false;
			if (!Objects.equals(sbsqntTxId, _that.getSbsqntTxId())) return false;
			if (!Objects.equals(collPrtflCd, _that.getCollPrtflCd())) return false;
			if (!Objects.equals(rptTrckgNb, _that.getRptTrckgNb())) return false;
			if (!Objects.equals(pltfmIdr, _that.getPltfmIdr())) return false;
			if (!Objects.equals(txPric, _that.getTxPric())) return false;
			if (!Objects.equals(ntnlAmt, _that.getNtnlAmt())) return false;
			if (!Objects.equals(ntnlQty, _that.getNtnlQty())) return false;
			if (!Objects.equals(dlvryTp, _that.getDlvryTp())) return false;
			if (!Objects.equals(exctnTmStmp, _that.getExctnTmStmp())) return false;
			if (!Objects.equals(fctvDt, _that.getFctvDt())) return false;
			if (!Objects.equals(xprtnDt, _that.getXprtnDt())) return false;
			if (!Objects.equals(earlyTermntnDt, _that.getEarlyTermntnDt())) return false;
			if (!Objects.equals(sttlmDt, _that.getSttlmDt())) return false;
			if (!Objects.equals(mstrAgrmt, _that.getMstrAgrmt())) return false;
			if (!Objects.equals(pstTradRskRdctnFlg, _that.getPstTradRskRdctnFlg())) return false;
			if (!Objects.equals(pstTradRskRdctnEvt, _that.getPstTradRskRdctnEvt())) return false;
			if (!Objects.equals(derivEvt, _that.getDerivEvt())) return false;
			if (!Objects.equals(tradConf, _that.getTradConf())) return false;
			if (!Objects.equals(tradClr, _that.getTradClr())) return false;
			if (!Objects.equals(intrstRate, _that.getIntrstRate())) return false;
			if (!Objects.equals(ccy, _that.getCcy())) return false;
			if (!Objects.equals(cmmdty, _that.getCmmdty())) return false;
			if (!Objects.equals(optn, _that.getOptn())) return false;
			if (!Objects.equals(nrgySpcfcAttrbts, _that.getNrgySpcfcAttrbts())) return false;
			if (!Objects.equals(cdt, _that.getCdt())) return false;
			if (!ListEquals.listEquals(othrPmt, _that.getOthrPmt())) return false;
			if (!Objects.equals(packg, _that.getPackg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (txId != null ? txId.hashCode() : 0);
			_result = 31 * _result + (prrTxId != null ? prrTxId.hashCode() : 0);
			_result = 31 * _result + (sbsqntTxId != null ? sbsqntTxId.hashCode() : 0);
			_result = 31 * _result + (collPrtflCd != null ? collPrtflCd.hashCode() : 0);
			_result = 31 * _result + (rptTrckgNb != null ? rptTrckgNb.hashCode() : 0);
			_result = 31 * _result + (pltfmIdr != null ? pltfmIdr.hashCode() : 0);
			_result = 31 * _result + (txPric != null ? txPric.hashCode() : 0);
			_result = 31 * _result + (ntnlAmt != null ? ntnlAmt.hashCode() : 0);
			_result = 31 * _result + (ntnlQty != null ? ntnlQty.hashCode() : 0);
			_result = 31 * _result + (dlvryTp != null ? dlvryTp.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (exctnTmStmp != null ? exctnTmStmp.hashCode() : 0);
			_result = 31 * _result + (fctvDt != null ? fctvDt.hashCode() : 0);
			_result = 31 * _result + (xprtnDt != null ? xprtnDt.hashCode() : 0);
			_result = 31 * _result + (earlyTermntnDt != null ? earlyTermntnDt.hashCode() : 0);
			_result = 31 * _result + (sttlmDt != null ? sttlmDt.hashCode() : 0);
			_result = 31 * _result + (mstrAgrmt != null ? mstrAgrmt.hashCode() : 0);
			_result = 31 * _result + (pstTradRskRdctnFlg != null ? pstTradRskRdctnFlg.hashCode() : 0);
			_result = 31 * _result + (pstTradRskRdctnEvt != null ? pstTradRskRdctnEvt.hashCode() : 0);
			_result = 31 * _result + (derivEvt != null ? derivEvt.hashCode() : 0);
			_result = 31 * _result + (tradConf != null ? tradConf.hashCode() : 0);
			_result = 31 * _result + (tradClr != null ? tradClr.hashCode() : 0);
			_result = 31 * _result + (intrstRate != null ? intrstRate.hashCode() : 0);
			_result = 31 * _result + (ccy != null ? ccy.hashCode() : 0);
			_result = 31 * _result + (cmmdty != null ? cmmdty.hashCode() : 0);
			_result = 31 * _result + (optn != null ? optn.hashCode() : 0);
			_result = 31 * _result + (nrgySpcfcAttrbts != null ? nrgySpcfcAttrbts.hashCode() : 0);
			_result = 31 * _result + (cdt != null ? cdt.hashCode() : 0);
			_result = 31 * _result + (othrPmt != null ? othrPmt.hashCode() : 0);
			_result = 31 * _result + (packg != null ? packg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeTransaction49__7 {" +
				"txId=" + this.txId + ", " +
				"prrTxId=" + this.prrTxId + ", " +
				"sbsqntTxId=" + this.sbsqntTxId + ", " +
				"collPrtflCd=" + this.collPrtflCd + ", " +
				"rptTrckgNb=" + this.rptTrckgNb + ", " +
				"pltfmIdr=" + this.pltfmIdr + ", " +
				"txPric=" + this.txPric + ", " +
				"ntnlAmt=" + this.ntnlAmt + ", " +
				"ntnlQty=" + this.ntnlQty + ", " +
				"dlvryTp=" + this.dlvryTp + ", " +
				"exctnTmStmp=" + this.exctnTmStmp + ", " +
				"fctvDt=" + this.fctvDt + ", " +
				"xprtnDt=" + this.xprtnDt + ", " +
				"earlyTermntnDt=" + this.earlyTermntnDt + ", " +
				"sttlmDt=" + this.sttlmDt + ", " +
				"mstrAgrmt=" + this.mstrAgrmt + ", " +
				"pstTradRskRdctnFlg=" + this.pstTradRskRdctnFlg + ", " +
				"pstTradRskRdctnEvt=" + this.pstTradRskRdctnEvt + ", " +
				"derivEvt=" + this.derivEvt + ", " +
				"tradConf=" + this.tradConf + ", " +
				"tradClr=" + this.tradClr + ", " +
				"intrstRate=" + this.intrstRate + ", " +
				"ccy=" + this.ccy + ", " +
				"cmmdty=" + this.cmmdty + ", " +
				"optn=" + this.optn + ", " +
				"nrgySpcfcAttrbts=" + this.nrgySpcfcAttrbts + ", " +
				"cdt=" + this.cdt + ", " +
				"othrPmt=" + this.othrPmt + ", " +
				"packg=" + this.packg +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeTransaction49__7  ***********************/
	class TradeTransaction49__7BuilderImpl implements TradeTransaction49__7.TradeTransaction49__7Builder {
	
		protected UniqueTransactionIdentifier2Choice__2.UniqueTransactionIdentifier2Choice__2Builder txId;
		protected UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder prrTxId;
		protected UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder sbsqntTxId;
		protected CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Builder collPrtflCd;
		protected String rptTrckgNb;
		protected String pltfmIdr;
		protected PriceData2__1.PriceData2__1Builder txPric;
		protected NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder ntnlAmt;
		protected NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder ntnlQty;
		protected PhysicalTransferType4Code dlvryTp;
		protected ZonedDateTime exctnTmStmp;
		protected Date fctvDt;
		protected Date xprtnDt;
		protected Date earlyTermntnDt;
		protected Date sttlmDt;
		protected MasterAgreement8__1.MasterAgreement8__1Builder mstrAgrmt;
		protected Boolean pstTradRskRdctnFlg;
		protected PTRREvent2__1.PTRREvent2__1Builder pstTradRskRdctnEvt;
		protected DerivativeEvent6__3.DerivativeEvent6__3Builder derivEvt;
		protected TradeConfirmation1Choice.TradeConfirmation1ChoiceBuilder tradConf;
		protected TradeClearing11__1.TradeClearing11__1Builder tradClr;
		protected InterestRateLegs14__1.InterestRateLegs14__1Builder intrstRate;
		protected CurrencyExchange22__1.CurrencyExchange22__1Builder ccy;
		protected AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder cmmdty;
		protected OptionOrSwaption10__1.OptionOrSwaption10__1Builder optn;
		protected EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder nrgySpcfcAttrbts;
		protected CreditDerivative4__1.CreditDerivative4__1Builder cdt;
		protected List<OtherPayment5__1.OtherPayment5__1Builder> othrPmt = new ArrayList<>();
		protected Package4__1.Package4__1Builder packg;
		
		@Override
		@RosettaAttribute("txId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("txId")
		public UniqueTransactionIdentifier2Choice__2.UniqueTransactionIdentifier2Choice__2Builder getTxId() {
			return txId;
		}
		
		@Override
		public UniqueTransactionIdentifier2Choice__2.UniqueTransactionIdentifier2Choice__2Builder getOrCreateTxId() {
			UniqueTransactionIdentifier2Choice__2.UniqueTransactionIdentifier2Choice__2Builder result;
			if (txId!=null) {
				result = txId;
			}
			else {
				result = txId = UniqueTransactionIdentifier2Choice__2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("prrTxId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prrTxId")
		public UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder getPrrTxId() {
			return prrTxId;
		}
		
		@Override
		public UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder getOrCreatePrrTxId() {
			UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder result;
			if (prrTxId!=null) {
				result = prrTxId;
			}
			else {
				result = prrTxId = UniqueTransactionIdentifier3Choice__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sbsqntTxId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sbsqntTxId")
		public UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder getSbsqntTxId() {
			return sbsqntTxId;
		}
		
		@Override
		public UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder getOrCreateSbsqntTxId() {
			UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder result;
			if (sbsqntTxId!=null) {
				result = sbsqntTxId;
			}
			else {
				result = sbsqntTxId = UniqueTransactionIdentifier3Choice__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("collPrtflCd")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("collPrtflCd")
		public CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Builder getCollPrtflCd() {
			return collPrtflCd;
		}
		
		@Override
		public CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Builder getOrCreateCollPrtflCd() {
			CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Builder result;
			if (collPrtflCd!=null) {
				result = collPrtflCd;
			}
			else {
				result = collPrtflCd = CollateralPortfolioCode5Choice__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rptTrckgNb")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rptTrckgNb")
		public String getRptTrckgNb() {
			return rptTrckgNb;
		}
		
		@Override
		@RosettaAttribute("pltfmIdr")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("pltfmIdr")
		public String getPltfmIdr() {
			return pltfmIdr;
		}
		
		@Override
		@RosettaAttribute("txPric")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("txPric")
		public PriceData2__1.PriceData2__1Builder getTxPric() {
			return txPric;
		}
		
		@Override
		public PriceData2__1.PriceData2__1Builder getOrCreateTxPric() {
			PriceData2__1.PriceData2__1Builder result;
			if (txPric!=null) {
				result = txPric;
			}
			else {
				result = txPric = PriceData2__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ntnlAmt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ntnlAmt")
		public NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder getNtnlAmt() {
			return ntnlAmt;
		}
		
		@Override
		public NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder getOrCreateNtnlAmt() {
			NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder result;
			if (ntnlAmt!=null) {
				result = ntnlAmt;
			}
			else {
				result = ntnlAmt = NotionalAmountLegs5__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ntnlQty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ntnlQty")
		public NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder getNtnlQty() {
			return ntnlQty;
		}
		
		@Override
		public NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder getOrCreateNtnlQty() {
			NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder result;
			if (ntnlQty!=null) {
				result = ntnlQty;
			}
			else {
				result = ntnlQty = NotionalQuantityLegs5__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dlvryTp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("dlvryTp")
		public PhysicalTransferType4Code getDlvryTp() {
			return dlvryTp;
		}
		
		@Override
		@RosettaAttribute("exctnTmStmp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("exctnTmStmp")
		public ZonedDateTime getExctnTmStmp() {
			return exctnTmStmp;
		}
		
		@Override
		@RosettaAttribute("fctvDt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("fctvDt")
		public Date getFctvDt() {
			return fctvDt;
		}
		
		@Override
		@RosettaAttribute("xprtnDt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("xprtnDt")
		public Date getXprtnDt() {
			return xprtnDt;
		}
		
		@Override
		@RosettaAttribute("earlyTermntnDt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("earlyTermntnDt")
		public Date getEarlyTermntnDt() {
			return earlyTermntnDt;
		}
		
		@Override
		@RosettaAttribute("sttlmDt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sttlmDt")
		public Date getSttlmDt() {
			return sttlmDt;
		}
		
		@Override
		@RosettaAttribute("mstrAgrmt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("mstrAgrmt")
		public MasterAgreement8__1.MasterAgreement8__1Builder getMstrAgrmt() {
			return mstrAgrmt;
		}
		
		@Override
		public MasterAgreement8__1.MasterAgreement8__1Builder getOrCreateMstrAgrmt() {
			MasterAgreement8__1.MasterAgreement8__1Builder result;
			if (mstrAgrmt!=null) {
				result = mstrAgrmt;
			}
			else {
				result = mstrAgrmt = MasterAgreement8__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pstTradRskRdctnFlg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pstTradRskRdctnFlg")
		public Boolean getPstTradRskRdctnFlg() {
			return pstTradRskRdctnFlg;
		}
		
		@Override
		@RosettaAttribute("pstTradRskRdctnEvt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pstTradRskRdctnEvt")
		public PTRREvent2__1.PTRREvent2__1Builder getPstTradRskRdctnEvt() {
			return pstTradRskRdctnEvt;
		}
		
		@Override
		public PTRREvent2__1.PTRREvent2__1Builder getOrCreatePstTradRskRdctnEvt() {
			PTRREvent2__1.PTRREvent2__1Builder result;
			if (pstTradRskRdctnEvt!=null) {
				result = pstTradRskRdctnEvt;
			}
			else {
				result = pstTradRskRdctnEvt = PTRREvent2__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("derivEvt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("derivEvt")
		public DerivativeEvent6__3.DerivativeEvent6__3Builder getDerivEvt() {
			return derivEvt;
		}
		
		@Override
		public DerivativeEvent6__3.DerivativeEvent6__3Builder getOrCreateDerivEvt() {
			DerivativeEvent6__3.DerivativeEvent6__3Builder result;
			if (derivEvt!=null) {
				result = derivEvt;
			}
			else {
				result = derivEvt = DerivativeEvent6__3.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradConf")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradConf")
		public TradeConfirmation1Choice.TradeConfirmation1ChoiceBuilder getTradConf() {
			return tradConf;
		}
		
		@Override
		public TradeConfirmation1Choice.TradeConfirmation1ChoiceBuilder getOrCreateTradConf() {
			TradeConfirmation1Choice.TradeConfirmation1ChoiceBuilder result;
			if (tradConf!=null) {
				result = tradConf;
			}
			else {
				result = tradConf = TradeConfirmation1Choice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradClr")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tradClr")
		public TradeClearing11__1.TradeClearing11__1Builder getTradClr() {
			return tradClr;
		}
		
		@Override
		public TradeClearing11__1.TradeClearing11__1Builder getOrCreateTradClr() {
			TradeClearing11__1.TradeClearing11__1Builder result;
			if (tradClr!=null) {
				result = tradClr;
			}
			else {
				result = tradClr = TradeClearing11__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("intrstRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("intrstRate")
		public InterestRateLegs14__1.InterestRateLegs14__1Builder getIntrstRate() {
			return intrstRate;
		}
		
		@Override
		public InterestRateLegs14__1.InterestRateLegs14__1Builder getOrCreateIntrstRate() {
			InterestRateLegs14__1.InterestRateLegs14__1Builder result;
			if (intrstRate!=null) {
				result = intrstRate;
			}
			else {
				result = intrstRate = InterestRateLegs14__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ccy")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ccy")
		public CurrencyExchange22__1.CurrencyExchange22__1Builder getCcy() {
			return ccy;
		}
		
		@Override
		public CurrencyExchange22__1.CurrencyExchange22__1Builder getOrCreateCcy() {
			CurrencyExchange22__1.CurrencyExchange22__1Builder result;
			if (ccy!=null) {
				result = ccy;
			}
			else {
				result = ccy = CurrencyExchange22__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cmmdty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cmmdty")
		public AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder getCmmdty() {
			return cmmdty;
		}
		
		@Override
		public AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder getOrCreateCmmdty() {
			AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder result;
			if (cmmdty!=null) {
				result = cmmdty;
			}
			else {
				result = cmmdty = AssetClassCommodity6Choice__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optn")
		public OptionOrSwaption10__1.OptionOrSwaption10__1Builder getOptn() {
			return optn;
		}
		
		@Override
		public OptionOrSwaption10__1.OptionOrSwaption10__1Builder getOrCreateOptn() {
			OptionOrSwaption10__1.OptionOrSwaption10__1Builder result;
			if (optn!=null) {
				result = optn;
			}
			else {
				result = optn = OptionOrSwaption10__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("nrgySpcfcAttrbts")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nrgySpcfcAttrbts")
		public EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder getNrgySpcfcAttrbts() {
			return nrgySpcfcAttrbts;
		}
		
		@Override
		public EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder getOrCreateNrgySpcfcAttrbts() {
			EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder result;
			if (nrgySpcfcAttrbts!=null) {
				result = nrgySpcfcAttrbts;
			}
			else {
				result = nrgySpcfcAttrbts = EnergySpecificAttribute9__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cdt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cdt")
		public CreditDerivative4__1.CreditDerivative4__1Builder getCdt() {
			return cdt;
		}
		
		@Override
		public CreditDerivative4__1.CreditDerivative4__1Builder getOrCreateCdt() {
			CreditDerivative4__1.CreditDerivative4__1Builder result;
			if (cdt!=null) {
				result = cdt;
			}
			else {
				result = cdt = CreditDerivative4__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("othrPmt")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("othrPmt")
		public List<? extends OtherPayment5__1.OtherPayment5__1Builder> getOthrPmt() {
			return othrPmt;
		}
		
		@Override
		public OtherPayment5__1.OtherPayment5__1Builder getOrCreateOthrPmt(int index) {
			if (othrPmt==null) {
				this.othrPmt = new ArrayList<>();
			}
			return getIndex(othrPmt, index, () -> {
						OtherPayment5__1.OtherPayment5__1Builder newOthrPmt = OtherPayment5__1.builder();
						return newOthrPmt;
					});
		}
		
		@Override
		@RosettaAttribute("packg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packg")
		public Package4__1.Package4__1Builder getPackg() {
			return packg;
		}
		
		@Override
		public Package4__1.Package4__1Builder getOrCreatePackg() {
			Package4__1.Package4__1Builder result;
			if (packg!=null) {
				result = packg;
			}
			else {
				result = packg = Package4__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("txId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("txId")
		@Override
		public TradeTransaction49__7.TradeTransaction49__7Builder setTxId(UniqueTransactionIdentifier2Choice__2 _txId) {
			this.txId = _txId == null ? null : _txId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("prrTxId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("prrTxId")
		@Override
		public TradeTransaction49__7.TradeTransaction49__7Builder setPrrTxId(UniqueTransactionIdentifier3Choice__1 _prrTxId) {
			this.prrTxId = _prrTxId == null ? null : _prrTxId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sbsqntTxId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sbsqntTxId")
		@Override
		public TradeTransaction49__7.TradeTransaction49__7Builder setSbsqntTxId(UniqueTransactionIdentifier3Choice__1 _sbsqntTxId) {
			this.sbsqntTxId = _sbsqntTxId == null ? null : _sbsqntTxId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("collPrtflCd")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("collPrtflCd")
		@Override
		public TradeTransaction49__7.TradeTransaction49__7Builder setCollPrtflCd(CollateralPortfolioCode5Choice__1 _collPrtflCd) {
			this.collPrtflCd = _collPrtflCd == null ? null : _collPrtflCd.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rptTrckgNb")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rptTrckgNb")
		@Override
		public TradeTransaction49__7.TradeTransaction49__7Builder setRptTrckgNb(String _rptTrckgNb) {
			this.rptTrckgNb = _rptTrckgNb == null ? null : _rptTrckgNb;
			return this;
		}
		
		@RosettaAttribute("pltfmIdr")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("pltfmIdr")
		@Override
		public TradeTransaction49__7.TradeTransaction49__7Builder setPltfmIdr(String _pltfmIdr) {
			this.pltfmIdr = _pltfmIdr == null ? null : _pltfmIdr;
			return this;
		}
		
		@RosettaAttribute("txPric")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("txPric")
		@Override
		public TradeTransaction49__7.TradeTransaction49__7Builder setTxPric(PriceData2__1 _txPric) {
			this.txPric = _txPric == null ? null : _txPric.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ntnlAmt")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("ntnlAmt")
		@Override
		public TradeTransaction49__7.TradeTransaction49__7Builder setNtnlAmt(NotionalAmountLegs5__1 _ntnlAmt) {
			this.ntnlAmt = _ntnlAmt == null ? null : _ntnlAmt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ntnlQty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ntnlQty")
		@Override
		public TradeTransaction49__7.TradeTransaction49__7Builder setNtnlQty(NotionalQuantityLegs5__1 _ntnlQty) {
			this.ntnlQty = _ntnlQty == null ? null : _ntnlQty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dlvryTp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dlvryTp")
		@Override
		public TradeTransaction49__7.TradeTransaction49__7Builder setDlvryTp(PhysicalTransferType4Code _dlvryTp) {
			this.dlvryTp = _dlvryTp == null ? null : _dlvryTp;
			return this;
		}
		
		@RosettaAttribute("exctnTmStmp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("exctnTmStmp")
		@Override
		public TradeTransaction49__7.TradeTransaction49__7Builder setExctnTmStmp(ZonedDateTime _exctnTmStmp) {
			this.exctnTmStmp = _exctnTmStmp == null ? null : _exctnTmStmp;
			return this;
		}
		
		@RosettaAttribute("fctvDt")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fctvDt")
		@Override
		public TradeTransaction49__7.TradeTransaction49__7Builder setFctvDt(Date _fctvDt) {
			this.fctvDt = _fctvDt == null ? null : _fctvDt;
			return this;
		}
		
		@RosettaAttribute("xprtnDt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("xprtnDt")
		@Override
		public TradeTransaction49__7.TradeTransaction49__7Builder setXprtnDt(Date _xprtnDt) {
			this.xprtnDt = _xprtnDt == null ? null : _xprtnDt;
			return this;
		}
		
		@RosettaAttribute("earlyTermntnDt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("earlyTermntnDt")
		@Override
		public TradeTransaction49__7.TradeTransaction49__7Builder setEarlyTermntnDt(Date _earlyTermntnDt) {
			this.earlyTermntnDt = _earlyTermntnDt == null ? null : _earlyTermntnDt;
			return this;
		}
		
		@RosettaAttribute("sttlmDt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sttlmDt")
		@Override
		public TradeTransaction49__7.TradeTransaction49__7Builder setSttlmDt(Date _sttlmDt) {
			this.sttlmDt = _sttlmDt == null ? null : _sttlmDt;
			return this;
		}
		
		@RosettaAttribute("mstrAgrmt")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("mstrAgrmt")
		@Override
		public TradeTransaction49__7.TradeTransaction49__7Builder setMstrAgrmt(MasterAgreement8__1 _mstrAgrmt) {
			this.mstrAgrmt = _mstrAgrmt == null ? null : _mstrAgrmt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("pstTradRskRdctnFlg")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pstTradRskRdctnFlg")
		@Override
		public TradeTransaction49__7.TradeTransaction49__7Builder setPstTradRskRdctnFlg(Boolean _pstTradRskRdctnFlg) {
			this.pstTradRskRdctnFlg = _pstTradRskRdctnFlg == null ? null : _pstTradRskRdctnFlg;
			return this;
		}
		
		@RosettaAttribute("pstTradRskRdctnEvt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pstTradRskRdctnEvt")
		@Override
		public TradeTransaction49__7.TradeTransaction49__7Builder setPstTradRskRdctnEvt(PTRREvent2__1 _pstTradRskRdctnEvt) {
			this.pstTradRskRdctnEvt = _pstTradRskRdctnEvt == null ? null : _pstTradRskRdctnEvt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("derivEvt")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("derivEvt")
		@Override
		public TradeTransaction49__7.TradeTransaction49__7Builder setDerivEvt(DerivativeEvent6__3 _derivEvt) {
			this.derivEvt = _derivEvt == null ? null : _derivEvt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradConf")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradConf")
		@Override
		public TradeTransaction49__7.TradeTransaction49__7Builder setTradConf(TradeConfirmation1Choice _tradConf) {
			this.tradConf = _tradConf == null ? null : _tradConf.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradClr")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tradClr")
		@Override
		public TradeTransaction49__7.TradeTransaction49__7Builder setTradClr(TradeClearing11__1 _tradClr) {
			this.tradClr = _tradClr == null ? null : _tradClr.toBuilder();
			return this;
		}
		
		@RosettaAttribute("intrstRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("intrstRate")
		@Override
		public TradeTransaction49__7.TradeTransaction49__7Builder setIntrstRate(InterestRateLegs14__1 _intrstRate) {
			this.intrstRate = _intrstRate == null ? null : _intrstRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ccy")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ccy")
		@Override
		public TradeTransaction49__7.TradeTransaction49__7Builder setCcy(CurrencyExchange22__1 _ccy) {
			this.ccy = _ccy == null ? null : _ccy.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cmmdty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cmmdty")
		@Override
		public TradeTransaction49__7.TradeTransaction49__7Builder setCmmdty(AssetClassCommodity6Choice__1 _cmmdty) {
			this.cmmdty = _cmmdty == null ? null : _cmmdty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optn")
		@Override
		public TradeTransaction49__7.TradeTransaction49__7Builder setOptn(OptionOrSwaption10__1 _optn) {
			this.optn = _optn == null ? null : _optn.toBuilder();
			return this;
		}
		
		@RosettaAttribute("nrgySpcfcAttrbts")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nrgySpcfcAttrbts")
		@Override
		public TradeTransaction49__7.TradeTransaction49__7Builder setNrgySpcfcAttrbts(EnergySpecificAttribute9__1 _nrgySpcfcAttrbts) {
			this.nrgySpcfcAttrbts = _nrgySpcfcAttrbts == null ? null : _nrgySpcfcAttrbts.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cdt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cdt")
		@Override
		public TradeTransaction49__7.TradeTransaction49__7Builder setCdt(CreditDerivative4__1 _cdt) {
			this.cdt = _cdt == null ? null : _cdt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("othrPmt")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("othrPmt")
		@Override
		public TradeTransaction49__7.TradeTransaction49__7Builder addOthrPmt(OtherPayment5__1 _othrPmt) {
			if (_othrPmt != null) {
				this.othrPmt.add(_othrPmt.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeTransaction49__7.TradeTransaction49__7Builder addOthrPmt(OtherPayment5__1 _othrPmt, int idx) {
			getIndex(this.othrPmt, idx, () -> _othrPmt.toBuilder());
			return this;
		}
		
		@Override
		public TradeTransaction49__7.TradeTransaction49__7Builder addOthrPmt(List<? extends OtherPayment5__1> othrPmts) {
			if (othrPmts != null) {
				for (final OtherPayment5__1 toAdd : othrPmts) {
					this.othrPmt.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("othrPmt")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("othrPmt")
		@Override
		public TradeTransaction49__7.TradeTransaction49__7Builder setOthrPmt(List<? extends OtherPayment5__1> othrPmts) {
			if (othrPmts == null) {
				this.othrPmt = new ArrayList<>();
			} else {
				this.othrPmt = othrPmts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("packg")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packg")
		@Override
		public TradeTransaction49__7.TradeTransaction49__7Builder setPackg(Package4__1 _packg) {
			this.packg = _packg == null ? null : _packg.toBuilder();
			return this;
		}
		
		@Override
		public TradeTransaction49__7 build() {
			return new TradeTransaction49__7.TradeTransaction49__7Impl(this);
		}
		
		@Override
		public TradeTransaction49__7.TradeTransaction49__7Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeTransaction49__7.TradeTransaction49__7Builder prune() {
			if (txId!=null && !txId.prune().hasData()) txId = null;
			if (prrTxId!=null && !prrTxId.prune().hasData()) prrTxId = null;
			if (sbsqntTxId!=null && !sbsqntTxId.prune().hasData()) sbsqntTxId = null;
			if (collPrtflCd!=null && !collPrtflCd.prune().hasData()) collPrtflCd = null;
			if (txPric!=null && !txPric.prune().hasData()) txPric = null;
			if (ntnlAmt!=null && !ntnlAmt.prune().hasData()) ntnlAmt = null;
			if (ntnlQty!=null && !ntnlQty.prune().hasData()) ntnlQty = null;
			if (mstrAgrmt!=null && !mstrAgrmt.prune().hasData()) mstrAgrmt = null;
			if (pstTradRskRdctnEvt!=null && !pstTradRskRdctnEvt.prune().hasData()) pstTradRskRdctnEvt = null;
			if (derivEvt!=null && !derivEvt.prune().hasData()) derivEvt = null;
			if (tradConf!=null && !tradConf.prune().hasData()) tradConf = null;
			if (tradClr!=null && !tradClr.prune().hasData()) tradClr = null;
			if (intrstRate!=null && !intrstRate.prune().hasData()) intrstRate = null;
			if (ccy!=null && !ccy.prune().hasData()) ccy = null;
			if (cmmdty!=null && !cmmdty.prune().hasData()) cmmdty = null;
			if (optn!=null && !optn.prune().hasData()) optn = null;
			if (nrgySpcfcAttrbts!=null && !nrgySpcfcAttrbts.prune().hasData()) nrgySpcfcAttrbts = null;
			if (cdt!=null && !cdt.prune().hasData()) cdt = null;
			othrPmt = othrPmt.stream().filter(b->b!=null).<OtherPayment5__1.OtherPayment5__1Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (packg!=null && !packg.prune().hasData()) packg = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTxId()!=null && getTxId().hasData()) return true;
			if (getPrrTxId()!=null && getPrrTxId().hasData()) return true;
			if (getSbsqntTxId()!=null && getSbsqntTxId().hasData()) return true;
			if (getCollPrtflCd()!=null && getCollPrtflCd().hasData()) return true;
			if (getRptTrckgNb()!=null) return true;
			if (getPltfmIdr()!=null) return true;
			if (getTxPric()!=null && getTxPric().hasData()) return true;
			if (getNtnlAmt()!=null && getNtnlAmt().hasData()) return true;
			if (getNtnlQty()!=null && getNtnlQty().hasData()) return true;
			if (getDlvryTp()!=null) return true;
			if (getExctnTmStmp()!=null) return true;
			if (getFctvDt()!=null) return true;
			if (getXprtnDt()!=null) return true;
			if (getEarlyTermntnDt()!=null) return true;
			if (getSttlmDt()!=null) return true;
			if (getMstrAgrmt()!=null && getMstrAgrmt().hasData()) return true;
			if (getPstTradRskRdctnFlg()!=null) return true;
			if (getPstTradRskRdctnEvt()!=null && getPstTradRskRdctnEvt().hasData()) return true;
			if (getDerivEvt()!=null && getDerivEvt().hasData()) return true;
			if (getTradConf()!=null && getTradConf().hasData()) return true;
			if (getTradClr()!=null && getTradClr().hasData()) return true;
			if (getIntrstRate()!=null && getIntrstRate().hasData()) return true;
			if (getCcy()!=null && getCcy().hasData()) return true;
			if (getCmmdty()!=null && getCmmdty().hasData()) return true;
			if (getOptn()!=null && getOptn().hasData()) return true;
			if (getNrgySpcfcAttrbts()!=null && getNrgySpcfcAttrbts().hasData()) return true;
			if (getCdt()!=null && getCdt().hasData()) return true;
			if (getOthrPmt()!=null && getOthrPmt().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPackg()!=null && getPackg().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeTransaction49__7.TradeTransaction49__7Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeTransaction49__7.TradeTransaction49__7Builder o = (TradeTransaction49__7.TradeTransaction49__7Builder) other;
			
			merger.mergeRosetta(getTxId(), o.getTxId(), this::setTxId);
			merger.mergeRosetta(getPrrTxId(), o.getPrrTxId(), this::setPrrTxId);
			merger.mergeRosetta(getSbsqntTxId(), o.getSbsqntTxId(), this::setSbsqntTxId);
			merger.mergeRosetta(getCollPrtflCd(), o.getCollPrtflCd(), this::setCollPrtflCd);
			merger.mergeRosetta(getTxPric(), o.getTxPric(), this::setTxPric);
			merger.mergeRosetta(getNtnlAmt(), o.getNtnlAmt(), this::setNtnlAmt);
			merger.mergeRosetta(getNtnlQty(), o.getNtnlQty(), this::setNtnlQty);
			merger.mergeRosetta(getMstrAgrmt(), o.getMstrAgrmt(), this::setMstrAgrmt);
			merger.mergeRosetta(getPstTradRskRdctnEvt(), o.getPstTradRskRdctnEvt(), this::setPstTradRskRdctnEvt);
			merger.mergeRosetta(getDerivEvt(), o.getDerivEvt(), this::setDerivEvt);
			merger.mergeRosetta(getTradConf(), o.getTradConf(), this::setTradConf);
			merger.mergeRosetta(getTradClr(), o.getTradClr(), this::setTradClr);
			merger.mergeRosetta(getIntrstRate(), o.getIntrstRate(), this::setIntrstRate);
			merger.mergeRosetta(getCcy(), o.getCcy(), this::setCcy);
			merger.mergeRosetta(getCmmdty(), o.getCmmdty(), this::setCmmdty);
			merger.mergeRosetta(getOptn(), o.getOptn(), this::setOptn);
			merger.mergeRosetta(getNrgySpcfcAttrbts(), o.getNrgySpcfcAttrbts(), this::setNrgySpcfcAttrbts);
			merger.mergeRosetta(getCdt(), o.getCdt(), this::setCdt);
			merger.mergeRosetta(getOthrPmt(), o.getOthrPmt(), this::getOrCreateOthrPmt);
			merger.mergeRosetta(getPackg(), o.getPackg(), this::setPackg);
			
			merger.mergeBasic(getRptTrckgNb(), o.getRptTrckgNb(), this::setRptTrckgNb);
			merger.mergeBasic(getPltfmIdr(), o.getPltfmIdr(), this::setPltfmIdr);
			merger.mergeBasic(getDlvryTp(), o.getDlvryTp(), this::setDlvryTp);
			merger.mergeBasic(getExctnTmStmp(), o.getExctnTmStmp(), this::setExctnTmStmp);
			merger.mergeBasic(getFctvDt(), o.getFctvDt(), this::setFctvDt);
			merger.mergeBasic(getXprtnDt(), o.getXprtnDt(), this::setXprtnDt);
			merger.mergeBasic(getEarlyTermntnDt(), o.getEarlyTermntnDt(), this::setEarlyTermntnDt);
			merger.mergeBasic(getSttlmDt(), o.getSttlmDt(), this::setSttlmDt);
			merger.mergeBasic(getPstTradRskRdctnFlg(), o.getPstTradRskRdctnFlg(), this::setPstTradRskRdctnFlg);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeTransaction49__7 _that = getType().cast(o);
		
			if (!Objects.equals(txId, _that.getTxId())) return false;
			if (!Objects.equals(prrTxId, _that.getPrrTxId())) return false;
			if (!Objects.equals(sbsqntTxId, _that.getSbsqntTxId())) return false;
			if (!Objects.equals(collPrtflCd, _that.getCollPrtflCd())) return false;
			if (!Objects.equals(rptTrckgNb, _that.getRptTrckgNb())) return false;
			if (!Objects.equals(pltfmIdr, _that.getPltfmIdr())) return false;
			if (!Objects.equals(txPric, _that.getTxPric())) return false;
			if (!Objects.equals(ntnlAmt, _that.getNtnlAmt())) return false;
			if (!Objects.equals(ntnlQty, _that.getNtnlQty())) return false;
			if (!Objects.equals(dlvryTp, _that.getDlvryTp())) return false;
			if (!Objects.equals(exctnTmStmp, _that.getExctnTmStmp())) return false;
			if (!Objects.equals(fctvDt, _that.getFctvDt())) return false;
			if (!Objects.equals(xprtnDt, _that.getXprtnDt())) return false;
			if (!Objects.equals(earlyTermntnDt, _that.getEarlyTermntnDt())) return false;
			if (!Objects.equals(sttlmDt, _that.getSttlmDt())) return false;
			if (!Objects.equals(mstrAgrmt, _that.getMstrAgrmt())) return false;
			if (!Objects.equals(pstTradRskRdctnFlg, _that.getPstTradRskRdctnFlg())) return false;
			if (!Objects.equals(pstTradRskRdctnEvt, _that.getPstTradRskRdctnEvt())) return false;
			if (!Objects.equals(derivEvt, _that.getDerivEvt())) return false;
			if (!Objects.equals(tradConf, _that.getTradConf())) return false;
			if (!Objects.equals(tradClr, _that.getTradClr())) return false;
			if (!Objects.equals(intrstRate, _that.getIntrstRate())) return false;
			if (!Objects.equals(ccy, _that.getCcy())) return false;
			if (!Objects.equals(cmmdty, _that.getCmmdty())) return false;
			if (!Objects.equals(optn, _that.getOptn())) return false;
			if (!Objects.equals(nrgySpcfcAttrbts, _that.getNrgySpcfcAttrbts())) return false;
			if (!Objects.equals(cdt, _that.getCdt())) return false;
			if (!ListEquals.listEquals(othrPmt, _that.getOthrPmt())) return false;
			if (!Objects.equals(packg, _that.getPackg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (txId != null ? txId.hashCode() : 0);
			_result = 31 * _result + (prrTxId != null ? prrTxId.hashCode() : 0);
			_result = 31 * _result + (sbsqntTxId != null ? sbsqntTxId.hashCode() : 0);
			_result = 31 * _result + (collPrtflCd != null ? collPrtflCd.hashCode() : 0);
			_result = 31 * _result + (rptTrckgNb != null ? rptTrckgNb.hashCode() : 0);
			_result = 31 * _result + (pltfmIdr != null ? pltfmIdr.hashCode() : 0);
			_result = 31 * _result + (txPric != null ? txPric.hashCode() : 0);
			_result = 31 * _result + (ntnlAmt != null ? ntnlAmt.hashCode() : 0);
			_result = 31 * _result + (ntnlQty != null ? ntnlQty.hashCode() : 0);
			_result = 31 * _result + (dlvryTp != null ? dlvryTp.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (exctnTmStmp != null ? exctnTmStmp.hashCode() : 0);
			_result = 31 * _result + (fctvDt != null ? fctvDt.hashCode() : 0);
			_result = 31 * _result + (xprtnDt != null ? xprtnDt.hashCode() : 0);
			_result = 31 * _result + (earlyTermntnDt != null ? earlyTermntnDt.hashCode() : 0);
			_result = 31 * _result + (sttlmDt != null ? sttlmDt.hashCode() : 0);
			_result = 31 * _result + (mstrAgrmt != null ? mstrAgrmt.hashCode() : 0);
			_result = 31 * _result + (pstTradRskRdctnFlg != null ? pstTradRskRdctnFlg.hashCode() : 0);
			_result = 31 * _result + (pstTradRskRdctnEvt != null ? pstTradRskRdctnEvt.hashCode() : 0);
			_result = 31 * _result + (derivEvt != null ? derivEvt.hashCode() : 0);
			_result = 31 * _result + (tradConf != null ? tradConf.hashCode() : 0);
			_result = 31 * _result + (tradClr != null ? tradClr.hashCode() : 0);
			_result = 31 * _result + (intrstRate != null ? intrstRate.hashCode() : 0);
			_result = 31 * _result + (ccy != null ? ccy.hashCode() : 0);
			_result = 31 * _result + (cmmdty != null ? cmmdty.hashCode() : 0);
			_result = 31 * _result + (optn != null ? optn.hashCode() : 0);
			_result = 31 * _result + (nrgySpcfcAttrbts != null ? nrgySpcfcAttrbts.hashCode() : 0);
			_result = 31 * _result + (cdt != null ? cdt.hashCode() : 0);
			_result = 31 * _result + (othrPmt != null ? othrPmt.hashCode() : 0);
			_result = 31 * _result + (packg != null ? packg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeTransaction49__7Builder {" +
				"txId=" + this.txId + ", " +
				"prrTxId=" + this.prrTxId + ", " +
				"sbsqntTxId=" + this.sbsqntTxId + ", " +
				"collPrtflCd=" + this.collPrtflCd + ", " +
				"rptTrckgNb=" + this.rptTrckgNb + ", " +
				"pltfmIdr=" + this.pltfmIdr + ", " +
				"txPric=" + this.txPric + ", " +
				"ntnlAmt=" + this.ntnlAmt + ", " +
				"ntnlQty=" + this.ntnlQty + ", " +
				"dlvryTp=" + this.dlvryTp + ", " +
				"exctnTmStmp=" + this.exctnTmStmp + ", " +
				"fctvDt=" + this.fctvDt + ", " +
				"xprtnDt=" + this.xprtnDt + ", " +
				"earlyTermntnDt=" + this.earlyTermntnDt + ", " +
				"sttlmDt=" + this.sttlmDt + ", " +
				"mstrAgrmt=" + this.mstrAgrmt + ", " +
				"pstTradRskRdctnFlg=" + this.pstTradRskRdctnFlg + ", " +
				"pstTradRskRdctnEvt=" + this.pstTradRskRdctnEvt + ", " +
				"derivEvt=" + this.derivEvt + ", " +
				"tradConf=" + this.tradConf + ", " +
				"tradClr=" + this.tradClr + ", " +
				"intrstRate=" + this.intrstRate + ", " +
				"ccy=" + this.ccy + ", " +
				"cmmdty=" + this.cmmdty + ", " +
				"optn=" + this.optn + ", " +
				"nrgySpcfcAttrbts=" + this.nrgySpcfcAttrbts + ", " +
				"cdt=" + this.cdt + ", " +
				"othrPmt=" + this.othrPmt + ", " +
				"packg=" + this.packg +
			'}';
		}
	}
}
