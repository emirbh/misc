package iso20022.auth030.mas;

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
import iso20022.auth030.mas.meta.TradeTransaction50__1Meta;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="TradeTransaction50__1", builder=TradeTransaction50__1.TradeTransaction50__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeTransaction50__1", model="iso20022", builder=TradeTransaction50__1.TradeTransaction50__1BuilderImpl.class, version="${project.version}")
public interface TradeTransaction50__1 extends RosettaModelObject {

	TradeTransaction50__1Meta metaData = new TradeTransaction50__1Meta();

	/*********************** Getter Methods  ***********************/
	UniqueTransactionIdentifier2Choice__1 getTxId();
	UniqueTransactionIdentifier3Choice__1 getPrrTxId();
	CollateralPortfolioCode6Choice__1 getCollPrtflCd();
	String getPltfmIdr();
	PriceData2__1 getTxPric();
	NotionalAmountLegs5__1 getNtnlAmt();
	NotionalQuantityLegs5__1 getNtnlQty();
	PhysicalTransferType4Code getDlvryTp();
	ZonedDateTime getExctnTmStmp();
	Date getFctvDt();
	Date getXprtnDt();
	Date getSttlmDt();
	DerivativeEvent6__1 getDerivEvt();
	TradeConfirmation4Choice__1 getTradConf();
	TradeClearing11__1 getTradClr();
	InterestRateLegs14__1 getIntrstRate();
	CurrencyExchange22__1 getCcy();
	OptionOrSwaption11__1 getOptn();
	List<? extends OtherPayment5__1> getOthrPmt();
	Package4__1 getPackg();

	/*********************** Build Methods  ***********************/
	TradeTransaction50__1 build();
	
	TradeTransaction50__1.TradeTransaction50__1Builder toBuilder();
	
	static TradeTransaction50__1.TradeTransaction50__1Builder builder() {
		return new TradeTransaction50__1.TradeTransaction50__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeTransaction50__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeTransaction50__1> getType() {
		return TradeTransaction50__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("txId"), processor, UniqueTransactionIdentifier2Choice__1.class, getTxId());
		processRosetta(path.newSubPath("prrTxId"), processor, UniqueTransactionIdentifier3Choice__1.class, getPrrTxId());
		processRosetta(path.newSubPath("collPrtflCd"), processor, CollateralPortfolioCode6Choice__1.class, getCollPrtflCd());
		processor.processBasic(path.newSubPath("pltfmIdr"), String.class, getPltfmIdr(), this);
		processRosetta(path.newSubPath("txPric"), processor, PriceData2__1.class, getTxPric());
		processRosetta(path.newSubPath("ntnlAmt"), processor, NotionalAmountLegs5__1.class, getNtnlAmt());
		processRosetta(path.newSubPath("ntnlQty"), processor, NotionalQuantityLegs5__1.class, getNtnlQty());
		processor.processBasic(path.newSubPath("dlvryTp"), PhysicalTransferType4Code.class, getDlvryTp(), this);
		processor.processBasic(path.newSubPath("exctnTmStmp"), ZonedDateTime.class, getExctnTmStmp(), this);
		processor.processBasic(path.newSubPath("fctvDt"), Date.class, getFctvDt(), this);
		processor.processBasic(path.newSubPath("xprtnDt"), Date.class, getXprtnDt(), this);
		processor.processBasic(path.newSubPath("sttlmDt"), Date.class, getSttlmDt(), this);
		processRosetta(path.newSubPath("derivEvt"), processor, DerivativeEvent6__1.class, getDerivEvt());
		processRosetta(path.newSubPath("tradConf"), processor, TradeConfirmation4Choice__1.class, getTradConf());
		processRosetta(path.newSubPath("tradClr"), processor, TradeClearing11__1.class, getTradClr());
		processRosetta(path.newSubPath("intrstRate"), processor, InterestRateLegs14__1.class, getIntrstRate());
		processRosetta(path.newSubPath("ccy"), processor, CurrencyExchange22__1.class, getCcy());
		processRosetta(path.newSubPath("optn"), processor, OptionOrSwaption11__1.class, getOptn());
		processRosetta(path.newSubPath("othrPmt"), processor, OtherPayment5__1.class, getOthrPmt());
		processRosetta(path.newSubPath("packg"), processor, Package4__1.class, getPackg());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeTransaction50__1Builder extends TradeTransaction50__1, RosettaModelObjectBuilder {
		UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder getOrCreateTxId();
		@Override
		UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder getTxId();
		UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder getOrCreatePrrTxId();
		@Override
		UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder getPrrTxId();
		CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder getOrCreateCollPrtflCd();
		@Override
		CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder getCollPrtflCd();
		PriceData2__1.PriceData2__1Builder getOrCreateTxPric();
		@Override
		PriceData2__1.PriceData2__1Builder getTxPric();
		NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder getOrCreateNtnlAmt();
		@Override
		NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder getNtnlAmt();
		NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder getOrCreateNtnlQty();
		@Override
		NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder getNtnlQty();
		DerivativeEvent6__1.DerivativeEvent6__1Builder getOrCreateDerivEvt();
		@Override
		DerivativeEvent6__1.DerivativeEvent6__1Builder getDerivEvt();
		TradeConfirmation4Choice__1.TradeConfirmation4Choice__1Builder getOrCreateTradConf();
		@Override
		TradeConfirmation4Choice__1.TradeConfirmation4Choice__1Builder getTradConf();
		TradeClearing11__1.TradeClearing11__1Builder getOrCreateTradClr();
		@Override
		TradeClearing11__1.TradeClearing11__1Builder getTradClr();
		InterestRateLegs14__1.InterestRateLegs14__1Builder getOrCreateIntrstRate();
		@Override
		InterestRateLegs14__1.InterestRateLegs14__1Builder getIntrstRate();
		CurrencyExchange22__1.CurrencyExchange22__1Builder getOrCreateCcy();
		@Override
		CurrencyExchange22__1.CurrencyExchange22__1Builder getCcy();
		OptionOrSwaption11__1.OptionOrSwaption11__1Builder getOrCreateOptn();
		@Override
		OptionOrSwaption11__1.OptionOrSwaption11__1Builder getOptn();
		OtherPayment5__1.OtherPayment5__1Builder getOrCreateOthrPmt(int index);
		@Override
		List<? extends OtherPayment5__1.OtherPayment5__1Builder> getOthrPmt();
		Package4__1.Package4__1Builder getOrCreatePackg();
		@Override
		Package4__1.Package4__1Builder getPackg();
		TradeTransaction50__1.TradeTransaction50__1Builder setTxId(UniqueTransactionIdentifier2Choice__1 txId);
		TradeTransaction50__1.TradeTransaction50__1Builder setPrrTxId(UniqueTransactionIdentifier3Choice__1 prrTxId);
		TradeTransaction50__1.TradeTransaction50__1Builder setCollPrtflCd(CollateralPortfolioCode6Choice__1 collPrtflCd);
		TradeTransaction50__1.TradeTransaction50__1Builder setPltfmIdr(String pltfmIdr);
		TradeTransaction50__1.TradeTransaction50__1Builder setTxPric(PriceData2__1 txPric);
		TradeTransaction50__1.TradeTransaction50__1Builder setNtnlAmt(NotionalAmountLegs5__1 ntnlAmt);
		TradeTransaction50__1.TradeTransaction50__1Builder setNtnlQty(NotionalQuantityLegs5__1 ntnlQty);
		TradeTransaction50__1.TradeTransaction50__1Builder setDlvryTp(PhysicalTransferType4Code dlvryTp);
		TradeTransaction50__1.TradeTransaction50__1Builder setExctnTmStmp(ZonedDateTime exctnTmStmp);
		TradeTransaction50__1.TradeTransaction50__1Builder setFctvDt(Date fctvDt);
		TradeTransaction50__1.TradeTransaction50__1Builder setXprtnDt(Date xprtnDt);
		TradeTransaction50__1.TradeTransaction50__1Builder setSttlmDt(Date sttlmDt);
		TradeTransaction50__1.TradeTransaction50__1Builder setDerivEvt(DerivativeEvent6__1 derivEvt);
		TradeTransaction50__1.TradeTransaction50__1Builder setTradConf(TradeConfirmation4Choice__1 tradConf);
		TradeTransaction50__1.TradeTransaction50__1Builder setTradClr(TradeClearing11__1 tradClr);
		TradeTransaction50__1.TradeTransaction50__1Builder setIntrstRate(InterestRateLegs14__1 intrstRate);
		TradeTransaction50__1.TradeTransaction50__1Builder setCcy(CurrencyExchange22__1 ccy);
		TradeTransaction50__1.TradeTransaction50__1Builder setOptn(OptionOrSwaption11__1 optn);
		TradeTransaction50__1.TradeTransaction50__1Builder addOthrPmt(OtherPayment5__1 othrPmt);
		TradeTransaction50__1.TradeTransaction50__1Builder addOthrPmt(OtherPayment5__1 othrPmt, int idx);
		TradeTransaction50__1.TradeTransaction50__1Builder addOthrPmt(List<? extends OtherPayment5__1> othrPmt);
		TradeTransaction50__1.TradeTransaction50__1Builder setOthrPmt(List<? extends OtherPayment5__1> othrPmt);
		TradeTransaction50__1.TradeTransaction50__1Builder setPackg(Package4__1 packg);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("txId"), processor, UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder.class, getTxId());
			processRosetta(path.newSubPath("prrTxId"), processor, UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder.class, getPrrTxId());
			processRosetta(path.newSubPath("collPrtflCd"), processor, CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder.class, getCollPrtflCd());
			processor.processBasic(path.newSubPath("pltfmIdr"), String.class, getPltfmIdr(), this);
			processRosetta(path.newSubPath("txPric"), processor, PriceData2__1.PriceData2__1Builder.class, getTxPric());
			processRosetta(path.newSubPath("ntnlAmt"), processor, NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder.class, getNtnlAmt());
			processRosetta(path.newSubPath("ntnlQty"), processor, NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder.class, getNtnlQty());
			processor.processBasic(path.newSubPath("dlvryTp"), PhysicalTransferType4Code.class, getDlvryTp(), this);
			processor.processBasic(path.newSubPath("exctnTmStmp"), ZonedDateTime.class, getExctnTmStmp(), this);
			processor.processBasic(path.newSubPath("fctvDt"), Date.class, getFctvDt(), this);
			processor.processBasic(path.newSubPath("xprtnDt"), Date.class, getXprtnDt(), this);
			processor.processBasic(path.newSubPath("sttlmDt"), Date.class, getSttlmDt(), this);
			processRosetta(path.newSubPath("derivEvt"), processor, DerivativeEvent6__1.DerivativeEvent6__1Builder.class, getDerivEvt());
			processRosetta(path.newSubPath("tradConf"), processor, TradeConfirmation4Choice__1.TradeConfirmation4Choice__1Builder.class, getTradConf());
			processRosetta(path.newSubPath("tradClr"), processor, TradeClearing11__1.TradeClearing11__1Builder.class, getTradClr());
			processRosetta(path.newSubPath("intrstRate"), processor, InterestRateLegs14__1.InterestRateLegs14__1Builder.class, getIntrstRate());
			processRosetta(path.newSubPath("ccy"), processor, CurrencyExchange22__1.CurrencyExchange22__1Builder.class, getCcy());
			processRosetta(path.newSubPath("optn"), processor, OptionOrSwaption11__1.OptionOrSwaption11__1Builder.class, getOptn());
			processRosetta(path.newSubPath("othrPmt"), processor, OtherPayment5__1.OtherPayment5__1Builder.class, getOthrPmt());
			processRosetta(path.newSubPath("packg"), processor, Package4__1.Package4__1Builder.class, getPackg());
		}
		

		TradeTransaction50__1.TradeTransaction50__1Builder prune();
	}

	/*********************** Immutable Implementation of TradeTransaction50__1  ***********************/
	class TradeTransaction50__1Impl implements TradeTransaction50__1 {
		private final UniqueTransactionIdentifier2Choice__1 txId;
		private final UniqueTransactionIdentifier3Choice__1 prrTxId;
		private final CollateralPortfolioCode6Choice__1 collPrtflCd;
		private final String pltfmIdr;
		private final PriceData2__1 txPric;
		private final NotionalAmountLegs5__1 ntnlAmt;
		private final NotionalQuantityLegs5__1 ntnlQty;
		private final PhysicalTransferType4Code dlvryTp;
		private final ZonedDateTime exctnTmStmp;
		private final Date fctvDt;
		private final Date xprtnDt;
		private final Date sttlmDt;
		private final DerivativeEvent6__1 derivEvt;
		private final TradeConfirmation4Choice__1 tradConf;
		private final TradeClearing11__1 tradClr;
		private final InterestRateLegs14__1 intrstRate;
		private final CurrencyExchange22__1 ccy;
		private final OptionOrSwaption11__1 optn;
		private final List<? extends OtherPayment5__1> othrPmt;
		private final Package4__1 packg;
		
		protected TradeTransaction50__1Impl(TradeTransaction50__1.TradeTransaction50__1Builder builder) {
			this.txId = ofNullable(builder.getTxId()).map(f->f.build()).orElse(null);
			this.prrTxId = ofNullable(builder.getPrrTxId()).map(f->f.build()).orElse(null);
			this.collPrtflCd = ofNullable(builder.getCollPrtflCd()).map(f->f.build()).orElse(null);
			this.pltfmIdr = builder.getPltfmIdr();
			this.txPric = ofNullable(builder.getTxPric()).map(f->f.build()).orElse(null);
			this.ntnlAmt = ofNullable(builder.getNtnlAmt()).map(f->f.build()).orElse(null);
			this.ntnlQty = ofNullable(builder.getNtnlQty()).map(f->f.build()).orElse(null);
			this.dlvryTp = builder.getDlvryTp();
			this.exctnTmStmp = builder.getExctnTmStmp();
			this.fctvDt = builder.getFctvDt();
			this.xprtnDt = builder.getXprtnDt();
			this.sttlmDt = builder.getSttlmDt();
			this.derivEvt = ofNullable(builder.getDerivEvt()).map(f->f.build()).orElse(null);
			this.tradConf = ofNullable(builder.getTradConf()).map(f->f.build()).orElse(null);
			this.tradClr = ofNullable(builder.getTradClr()).map(f->f.build()).orElse(null);
			this.intrstRate = ofNullable(builder.getIntrstRate()).map(f->f.build()).orElse(null);
			this.ccy = ofNullable(builder.getCcy()).map(f->f.build()).orElse(null);
			this.optn = ofNullable(builder.getOptn()).map(f->f.build()).orElse(null);
			this.othrPmt = ofNullable(builder.getOthrPmt()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.packg = ofNullable(builder.getPackg()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("txId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("txId")
		public UniqueTransactionIdentifier2Choice__1 getTxId() {
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
		@RosettaAttribute("collPrtflCd")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("collPrtflCd")
		public CollateralPortfolioCode6Choice__1 getCollPrtflCd() {
			return collPrtflCd;
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
		@RosettaAttribute("sttlmDt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sttlmDt")
		public Date getSttlmDt() {
			return sttlmDt;
		}
		
		@Override
		@RosettaAttribute("derivEvt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("derivEvt")
		public DerivativeEvent6__1 getDerivEvt() {
			return derivEvt;
		}
		
		@Override
		@RosettaAttribute("tradConf")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tradConf")
		public TradeConfirmation4Choice__1 getTradConf() {
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
		@RosettaAttribute("optn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optn")
		public OptionOrSwaption11__1 getOptn() {
			return optn;
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
		public TradeTransaction50__1 build() {
			return this;
		}
		
		@Override
		public TradeTransaction50__1.TradeTransaction50__1Builder toBuilder() {
			TradeTransaction50__1.TradeTransaction50__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeTransaction50__1.TradeTransaction50__1Builder builder) {
			ofNullable(getTxId()).ifPresent(builder::setTxId);
			ofNullable(getPrrTxId()).ifPresent(builder::setPrrTxId);
			ofNullable(getCollPrtflCd()).ifPresent(builder::setCollPrtflCd);
			ofNullable(getPltfmIdr()).ifPresent(builder::setPltfmIdr);
			ofNullable(getTxPric()).ifPresent(builder::setTxPric);
			ofNullable(getNtnlAmt()).ifPresent(builder::setNtnlAmt);
			ofNullable(getNtnlQty()).ifPresent(builder::setNtnlQty);
			ofNullable(getDlvryTp()).ifPresent(builder::setDlvryTp);
			ofNullable(getExctnTmStmp()).ifPresent(builder::setExctnTmStmp);
			ofNullable(getFctvDt()).ifPresent(builder::setFctvDt);
			ofNullable(getXprtnDt()).ifPresent(builder::setXprtnDt);
			ofNullable(getSttlmDt()).ifPresent(builder::setSttlmDt);
			ofNullable(getDerivEvt()).ifPresent(builder::setDerivEvt);
			ofNullable(getTradConf()).ifPresent(builder::setTradConf);
			ofNullable(getTradClr()).ifPresent(builder::setTradClr);
			ofNullable(getIntrstRate()).ifPresent(builder::setIntrstRate);
			ofNullable(getCcy()).ifPresent(builder::setCcy);
			ofNullable(getOptn()).ifPresent(builder::setOptn);
			ofNullable(getOthrPmt()).ifPresent(builder::setOthrPmt);
			ofNullable(getPackg()).ifPresent(builder::setPackg);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeTransaction50__1 _that = getType().cast(o);
		
			if (!Objects.equals(txId, _that.getTxId())) return false;
			if (!Objects.equals(prrTxId, _that.getPrrTxId())) return false;
			if (!Objects.equals(collPrtflCd, _that.getCollPrtflCd())) return false;
			if (!Objects.equals(pltfmIdr, _that.getPltfmIdr())) return false;
			if (!Objects.equals(txPric, _that.getTxPric())) return false;
			if (!Objects.equals(ntnlAmt, _that.getNtnlAmt())) return false;
			if (!Objects.equals(ntnlQty, _that.getNtnlQty())) return false;
			if (!Objects.equals(dlvryTp, _that.getDlvryTp())) return false;
			if (!Objects.equals(exctnTmStmp, _that.getExctnTmStmp())) return false;
			if (!Objects.equals(fctvDt, _that.getFctvDt())) return false;
			if (!Objects.equals(xprtnDt, _that.getXprtnDt())) return false;
			if (!Objects.equals(sttlmDt, _that.getSttlmDt())) return false;
			if (!Objects.equals(derivEvt, _that.getDerivEvt())) return false;
			if (!Objects.equals(tradConf, _that.getTradConf())) return false;
			if (!Objects.equals(tradClr, _that.getTradClr())) return false;
			if (!Objects.equals(intrstRate, _that.getIntrstRate())) return false;
			if (!Objects.equals(ccy, _that.getCcy())) return false;
			if (!Objects.equals(optn, _that.getOptn())) return false;
			if (!ListEquals.listEquals(othrPmt, _that.getOthrPmt())) return false;
			if (!Objects.equals(packg, _that.getPackg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (txId != null ? txId.hashCode() : 0);
			_result = 31 * _result + (prrTxId != null ? prrTxId.hashCode() : 0);
			_result = 31 * _result + (collPrtflCd != null ? collPrtflCd.hashCode() : 0);
			_result = 31 * _result + (pltfmIdr != null ? pltfmIdr.hashCode() : 0);
			_result = 31 * _result + (txPric != null ? txPric.hashCode() : 0);
			_result = 31 * _result + (ntnlAmt != null ? ntnlAmt.hashCode() : 0);
			_result = 31 * _result + (ntnlQty != null ? ntnlQty.hashCode() : 0);
			_result = 31 * _result + (dlvryTp != null ? dlvryTp.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (exctnTmStmp != null ? exctnTmStmp.hashCode() : 0);
			_result = 31 * _result + (fctvDt != null ? fctvDt.hashCode() : 0);
			_result = 31 * _result + (xprtnDt != null ? xprtnDt.hashCode() : 0);
			_result = 31 * _result + (sttlmDt != null ? sttlmDt.hashCode() : 0);
			_result = 31 * _result + (derivEvt != null ? derivEvt.hashCode() : 0);
			_result = 31 * _result + (tradConf != null ? tradConf.hashCode() : 0);
			_result = 31 * _result + (tradClr != null ? tradClr.hashCode() : 0);
			_result = 31 * _result + (intrstRate != null ? intrstRate.hashCode() : 0);
			_result = 31 * _result + (ccy != null ? ccy.hashCode() : 0);
			_result = 31 * _result + (optn != null ? optn.hashCode() : 0);
			_result = 31 * _result + (othrPmt != null ? othrPmt.hashCode() : 0);
			_result = 31 * _result + (packg != null ? packg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeTransaction50__1 {" +
				"txId=" + this.txId + ", " +
				"prrTxId=" + this.prrTxId + ", " +
				"collPrtflCd=" + this.collPrtflCd + ", " +
				"pltfmIdr=" + this.pltfmIdr + ", " +
				"txPric=" + this.txPric + ", " +
				"ntnlAmt=" + this.ntnlAmt + ", " +
				"ntnlQty=" + this.ntnlQty + ", " +
				"dlvryTp=" + this.dlvryTp + ", " +
				"exctnTmStmp=" + this.exctnTmStmp + ", " +
				"fctvDt=" + this.fctvDt + ", " +
				"xprtnDt=" + this.xprtnDt + ", " +
				"sttlmDt=" + this.sttlmDt + ", " +
				"derivEvt=" + this.derivEvt + ", " +
				"tradConf=" + this.tradConf + ", " +
				"tradClr=" + this.tradClr + ", " +
				"intrstRate=" + this.intrstRate + ", " +
				"ccy=" + this.ccy + ", " +
				"optn=" + this.optn + ", " +
				"othrPmt=" + this.othrPmt + ", " +
				"packg=" + this.packg +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeTransaction50__1  ***********************/
	class TradeTransaction50__1BuilderImpl implements TradeTransaction50__1.TradeTransaction50__1Builder {
	
		protected UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder txId;
		protected UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder prrTxId;
		protected CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder collPrtflCd;
		protected String pltfmIdr;
		protected PriceData2__1.PriceData2__1Builder txPric;
		protected NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder ntnlAmt;
		protected NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder ntnlQty;
		protected PhysicalTransferType4Code dlvryTp;
		protected ZonedDateTime exctnTmStmp;
		protected Date fctvDt;
		protected Date xprtnDt;
		protected Date sttlmDt;
		protected DerivativeEvent6__1.DerivativeEvent6__1Builder derivEvt;
		protected TradeConfirmation4Choice__1.TradeConfirmation4Choice__1Builder tradConf;
		protected TradeClearing11__1.TradeClearing11__1Builder tradClr;
		protected InterestRateLegs14__1.InterestRateLegs14__1Builder intrstRate;
		protected CurrencyExchange22__1.CurrencyExchange22__1Builder ccy;
		protected OptionOrSwaption11__1.OptionOrSwaption11__1Builder optn;
		protected List<OtherPayment5__1.OtherPayment5__1Builder> othrPmt = new ArrayList<>();
		protected Package4__1.Package4__1Builder packg;
		
		@Override
		@RosettaAttribute("txId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("txId")
		public UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder getTxId() {
			return txId;
		}
		
		@Override
		public UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder getOrCreateTxId() {
			UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder result;
			if (txId!=null) {
				result = txId;
			}
			else {
				result = txId = UniqueTransactionIdentifier2Choice__1.builder();
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
		@RosettaAttribute("collPrtflCd")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("collPrtflCd")
		public CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder getCollPrtflCd() {
			return collPrtflCd;
		}
		
		@Override
		public CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder getOrCreateCollPrtflCd() {
			CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder result;
			if (collPrtflCd!=null) {
				result = collPrtflCd;
			}
			else {
				result = collPrtflCd = CollateralPortfolioCode6Choice__1.builder();
			}
			
			return result;
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
		@RosettaAttribute("sttlmDt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sttlmDt")
		public Date getSttlmDt() {
			return sttlmDt;
		}
		
		@Override
		@RosettaAttribute("derivEvt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("derivEvt")
		public DerivativeEvent6__1.DerivativeEvent6__1Builder getDerivEvt() {
			return derivEvt;
		}
		
		@Override
		public DerivativeEvent6__1.DerivativeEvent6__1Builder getOrCreateDerivEvt() {
			DerivativeEvent6__1.DerivativeEvent6__1Builder result;
			if (derivEvt!=null) {
				result = derivEvt;
			}
			else {
				result = derivEvt = DerivativeEvent6__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradConf")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tradConf")
		public TradeConfirmation4Choice__1.TradeConfirmation4Choice__1Builder getTradConf() {
			return tradConf;
		}
		
		@Override
		public TradeConfirmation4Choice__1.TradeConfirmation4Choice__1Builder getOrCreateTradConf() {
			TradeConfirmation4Choice__1.TradeConfirmation4Choice__1Builder result;
			if (tradConf!=null) {
				result = tradConf;
			}
			else {
				result = tradConf = TradeConfirmation4Choice__1.builder();
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
		@RosettaAttribute("optn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optn")
		public OptionOrSwaption11__1.OptionOrSwaption11__1Builder getOptn() {
			return optn;
		}
		
		@Override
		public OptionOrSwaption11__1.OptionOrSwaption11__1Builder getOrCreateOptn() {
			OptionOrSwaption11__1.OptionOrSwaption11__1Builder result;
			if (optn!=null) {
				result = optn;
			}
			else {
				result = optn = OptionOrSwaption11__1.builder();
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
		public TradeTransaction50__1.TradeTransaction50__1Builder setTxId(UniqueTransactionIdentifier2Choice__1 _txId) {
			this.txId = _txId == null ? null : _txId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("prrTxId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("prrTxId")
		@Override
		public TradeTransaction50__1.TradeTransaction50__1Builder setPrrTxId(UniqueTransactionIdentifier3Choice__1 _prrTxId) {
			this.prrTxId = _prrTxId == null ? null : _prrTxId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("collPrtflCd")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("collPrtflCd")
		@Override
		public TradeTransaction50__1.TradeTransaction50__1Builder setCollPrtflCd(CollateralPortfolioCode6Choice__1 _collPrtflCd) {
			this.collPrtflCd = _collPrtflCd == null ? null : _collPrtflCd.toBuilder();
			return this;
		}
		
		@RosettaAttribute("pltfmIdr")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("pltfmIdr")
		@Override
		public TradeTransaction50__1.TradeTransaction50__1Builder setPltfmIdr(String _pltfmIdr) {
			this.pltfmIdr = _pltfmIdr == null ? null : _pltfmIdr;
			return this;
		}
		
		@RosettaAttribute("txPric")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("txPric")
		@Override
		public TradeTransaction50__1.TradeTransaction50__1Builder setTxPric(PriceData2__1 _txPric) {
			this.txPric = _txPric == null ? null : _txPric.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ntnlAmt")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("ntnlAmt")
		@Override
		public TradeTransaction50__1.TradeTransaction50__1Builder setNtnlAmt(NotionalAmountLegs5__1 _ntnlAmt) {
			this.ntnlAmt = _ntnlAmt == null ? null : _ntnlAmt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ntnlQty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ntnlQty")
		@Override
		public TradeTransaction50__1.TradeTransaction50__1Builder setNtnlQty(NotionalQuantityLegs5__1 _ntnlQty) {
			this.ntnlQty = _ntnlQty == null ? null : _ntnlQty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dlvryTp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dlvryTp")
		@Override
		public TradeTransaction50__1.TradeTransaction50__1Builder setDlvryTp(PhysicalTransferType4Code _dlvryTp) {
			this.dlvryTp = _dlvryTp == null ? null : _dlvryTp;
			return this;
		}
		
		@RosettaAttribute("exctnTmStmp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("exctnTmStmp")
		@Override
		public TradeTransaction50__1.TradeTransaction50__1Builder setExctnTmStmp(ZonedDateTime _exctnTmStmp) {
			this.exctnTmStmp = _exctnTmStmp == null ? null : _exctnTmStmp;
			return this;
		}
		
		@RosettaAttribute("fctvDt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fctvDt")
		@Override
		public TradeTransaction50__1.TradeTransaction50__1Builder setFctvDt(Date _fctvDt) {
			this.fctvDt = _fctvDt == null ? null : _fctvDt;
			return this;
		}
		
		@RosettaAttribute("xprtnDt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("xprtnDt")
		@Override
		public TradeTransaction50__1.TradeTransaction50__1Builder setXprtnDt(Date _xprtnDt) {
			this.xprtnDt = _xprtnDt == null ? null : _xprtnDt;
			return this;
		}
		
		@RosettaAttribute("sttlmDt")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sttlmDt")
		@Override
		public TradeTransaction50__1.TradeTransaction50__1Builder setSttlmDt(Date _sttlmDt) {
			this.sttlmDt = _sttlmDt == null ? null : _sttlmDt;
			return this;
		}
		
		@RosettaAttribute("derivEvt")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("derivEvt")
		@Override
		public TradeTransaction50__1.TradeTransaction50__1Builder setDerivEvt(DerivativeEvent6__1 _derivEvt) {
			this.derivEvt = _derivEvt == null ? null : _derivEvt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradConf")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tradConf")
		@Override
		public TradeTransaction50__1.TradeTransaction50__1Builder setTradConf(TradeConfirmation4Choice__1 _tradConf) {
			this.tradConf = _tradConf == null ? null : _tradConf.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradClr")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tradClr")
		@Override
		public TradeTransaction50__1.TradeTransaction50__1Builder setTradClr(TradeClearing11__1 _tradClr) {
			this.tradClr = _tradClr == null ? null : _tradClr.toBuilder();
			return this;
		}
		
		@RosettaAttribute("intrstRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("intrstRate")
		@Override
		public TradeTransaction50__1.TradeTransaction50__1Builder setIntrstRate(InterestRateLegs14__1 _intrstRate) {
			this.intrstRate = _intrstRate == null ? null : _intrstRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ccy")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ccy")
		@Override
		public TradeTransaction50__1.TradeTransaction50__1Builder setCcy(CurrencyExchange22__1 _ccy) {
			this.ccy = _ccy == null ? null : _ccy.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optn")
		@Override
		public TradeTransaction50__1.TradeTransaction50__1Builder setOptn(OptionOrSwaption11__1 _optn) {
			this.optn = _optn == null ? null : _optn.toBuilder();
			return this;
		}
		
		@RosettaAttribute("othrPmt")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("othrPmt")
		@Override
		public TradeTransaction50__1.TradeTransaction50__1Builder addOthrPmt(OtherPayment5__1 _othrPmt) {
			if (_othrPmt != null) {
				this.othrPmt.add(_othrPmt.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeTransaction50__1.TradeTransaction50__1Builder addOthrPmt(OtherPayment5__1 _othrPmt, int idx) {
			getIndex(this.othrPmt, idx, () -> _othrPmt.toBuilder());
			return this;
		}
		
		@Override
		public TradeTransaction50__1.TradeTransaction50__1Builder addOthrPmt(List<? extends OtherPayment5__1> othrPmts) {
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
		public TradeTransaction50__1.TradeTransaction50__1Builder setOthrPmt(List<? extends OtherPayment5__1> othrPmts) {
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
		public TradeTransaction50__1.TradeTransaction50__1Builder setPackg(Package4__1 _packg) {
			this.packg = _packg == null ? null : _packg.toBuilder();
			return this;
		}
		
		@Override
		public TradeTransaction50__1 build() {
			return new TradeTransaction50__1.TradeTransaction50__1Impl(this);
		}
		
		@Override
		public TradeTransaction50__1.TradeTransaction50__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeTransaction50__1.TradeTransaction50__1Builder prune() {
			if (txId!=null && !txId.prune().hasData()) txId = null;
			if (prrTxId!=null && !prrTxId.prune().hasData()) prrTxId = null;
			if (collPrtflCd!=null && !collPrtflCd.prune().hasData()) collPrtflCd = null;
			if (txPric!=null && !txPric.prune().hasData()) txPric = null;
			if (ntnlAmt!=null && !ntnlAmt.prune().hasData()) ntnlAmt = null;
			if (ntnlQty!=null && !ntnlQty.prune().hasData()) ntnlQty = null;
			if (derivEvt!=null && !derivEvt.prune().hasData()) derivEvt = null;
			if (tradConf!=null && !tradConf.prune().hasData()) tradConf = null;
			if (tradClr!=null && !tradClr.prune().hasData()) tradClr = null;
			if (intrstRate!=null && !intrstRate.prune().hasData()) intrstRate = null;
			if (ccy!=null && !ccy.prune().hasData()) ccy = null;
			if (optn!=null && !optn.prune().hasData()) optn = null;
			othrPmt = othrPmt.stream().filter(b->b!=null).<OtherPayment5__1.OtherPayment5__1Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (packg!=null && !packg.prune().hasData()) packg = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTxId()!=null && getTxId().hasData()) return true;
			if (getPrrTxId()!=null && getPrrTxId().hasData()) return true;
			if (getCollPrtflCd()!=null && getCollPrtflCd().hasData()) return true;
			if (getPltfmIdr()!=null) return true;
			if (getTxPric()!=null && getTxPric().hasData()) return true;
			if (getNtnlAmt()!=null && getNtnlAmt().hasData()) return true;
			if (getNtnlQty()!=null && getNtnlQty().hasData()) return true;
			if (getDlvryTp()!=null) return true;
			if (getExctnTmStmp()!=null) return true;
			if (getFctvDt()!=null) return true;
			if (getXprtnDt()!=null) return true;
			if (getSttlmDt()!=null) return true;
			if (getDerivEvt()!=null && getDerivEvt().hasData()) return true;
			if (getTradConf()!=null && getTradConf().hasData()) return true;
			if (getTradClr()!=null && getTradClr().hasData()) return true;
			if (getIntrstRate()!=null && getIntrstRate().hasData()) return true;
			if (getCcy()!=null && getCcy().hasData()) return true;
			if (getOptn()!=null && getOptn().hasData()) return true;
			if (getOthrPmt()!=null && getOthrPmt().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPackg()!=null && getPackg().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeTransaction50__1.TradeTransaction50__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeTransaction50__1.TradeTransaction50__1Builder o = (TradeTransaction50__1.TradeTransaction50__1Builder) other;
			
			merger.mergeRosetta(getTxId(), o.getTxId(), this::setTxId);
			merger.mergeRosetta(getPrrTxId(), o.getPrrTxId(), this::setPrrTxId);
			merger.mergeRosetta(getCollPrtflCd(), o.getCollPrtflCd(), this::setCollPrtflCd);
			merger.mergeRosetta(getTxPric(), o.getTxPric(), this::setTxPric);
			merger.mergeRosetta(getNtnlAmt(), o.getNtnlAmt(), this::setNtnlAmt);
			merger.mergeRosetta(getNtnlQty(), o.getNtnlQty(), this::setNtnlQty);
			merger.mergeRosetta(getDerivEvt(), o.getDerivEvt(), this::setDerivEvt);
			merger.mergeRosetta(getTradConf(), o.getTradConf(), this::setTradConf);
			merger.mergeRosetta(getTradClr(), o.getTradClr(), this::setTradClr);
			merger.mergeRosetta(getIntrstRate(), o.getIntrstRate(), this::setIntrstRate);
			merger.mergeRosetta(getCcy(), o.getCcy(), this::setCcy);
			merger.mergeRosetta(getOptn(), o.getOptn(), this::setOptn);
			merger.mergeRosetta(getOthrPmt(), o.getOthrPmt(), this::getOrCreateOthrPmt);
			merger.mergeRosetta(getPackg(), o.getPackg(), this::setPackg);
			
			merger.mergeBasic(getPltfmIdr(), o.getPltfmIdr(), this::setPltfmIdr);
			merger.mergeBasic(getDlvryTp(), o.getDlvryTp(), this::setDlvryTp);
			merger.mergeBasic(getExctnTmStmp(), o.getExctnTmStmp(), this::setExctnTmStmp);
			merger.mergeBasic(getFctvDt(), o.getFctvDt(), this::setFctvDt);
			merger.mergeBasic(getXprtnDt(), o.getXprtnDt(), this::setXprtnDt);
			merger.mergeBasic(getSttlmDt(), o.getSttlmDt(), this::setSttlmDt);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeTransaction50__1 _that = getType().cast(o);
		
			if (!Objects.equals(txId, _that.getTxId())) return false;
			if (!Objects.equals(prrTxId, _that.getPrrTxId())) return false;
			if (!Objects.equals(collPrtflCd, _that.getCollPrtflCd())) return false;
			if (!Objects.equals(pltfmIdr, _that.getPltfmIdr())) return false;
			if (!Objects.equals(txPric, _that.getTxPric())) return false;
			if (!Objects.equals(ntnlAmt, _that.getNtnlAmt())) return false;
			if (!Objects.equals(ntnlQty, _that.getNtnlQty())) return false;
			if (!Objects.equals(dlvryTp, _that.getDlvryTp())) return false;
			if (!Objects.equals(exctnTmStmp, _that.getExctnTmStmp())) return false;
			if (!Objects.equals(fctvDt, _that.getFctvDt())) return false;
			if (!Objects.equals(xprtnDt, _that.getXprtnDt())) return false;
			if (!Objects.equals(sttlmDt, _that.getSttlmDt())) return false;
			if (!Objects.equals(derivEvt, _that.getDerivEvt())) return false;
			if (!Objects.equals(tradConf, _that.getTradConf())) return false;
			if (!Objects.equals(tradClr, _that.getTradClr())) return false;
			if (!Objects.equals(intrstRate, _that.getIntrstRate())) return false;
			if (!Objects.equals(ccy, _that.getCcy())) return false;
			if (!Objects.equals(optn, _that.getOptn())) return false;
			if (!ListEquals.listEquals(othrPmt, _that.getOthrPmt())) return false;
			if (!Objects.equals(packg, _that.getPackg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (txId != null ? txId.hashCode() : 0);
			_result = 31 * _result + (prrTxId != null ? prrTxId.hashCode() : 0);
			_result = 31 * _result + (collPrtflCd != null ? collPrtflCd.hashCode() : 0);
			_result = 31 * _result + (pltfmIdr != null ? pltfmIdr.hashCode() : 0);
			_result = 31 * _result + (txPric != null ? txPric.hashCode() : 0);
			_result = 31 * _result + (ntnlAmt != null ? ntnlAmt.hashCode() : 0);
			_result = 31 * _result + (ntnlQty != null ? ntnlQty.hashCode() : 0);
			_result = 31 * _result + (dlvryTp != null ? dlvryTp.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (exctnTmStmp != null ? exctnTmStmp.hashCode() : 0);
			_result = 31 * _result + (fctvDt != null ? fctvDt.hashCode() : 0);
			_result = 31 * _result + (xprtnDt != null ? xprtnDt.hashCode() : 0);
			_result = 31 * _result + (sttlmDt != null ? sttlmDt.hashCode() : 0);
			_result = 31 * _result + (derivEvt != null ? derivEvt.hashCode() : 0);
			_result = 31 * _result + (tradConf != null ? tradConf.hashCode() : 0);
			_result = 31 * _result + (tradClr != null ? tradClr.hashCode() : 0);
			_result = 31 * _result + (intrstRate != null ? intrstRate.hashCode() : 0);
			_result = 31 * _result + (ccy != null ? ccy.hashCode() : 0);
			_result = 31 * _result + (optn != null ? optn.hashCode() : 0);
			_result = 31 * _result + (othrPmt != null ? othrPmt.hashCode() : 0);
			_result = 31 * _result + (packg != null ? packg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeTransaction50__1Builder {" +
				"txId=" + this.txId + ", " +
				"prrTxId=" + this.prrTxId + ", " +
				"collPrtflCd=" + this.collPrtflCd + ", " +
				"pltfmIdr=" + this.pltfmIdr + ", " +
				"txPric=" + this.txPric + ", " +
				"ntnlAmt=" + this.ntnlAmt + ", " +
				"ntnlQty=" + this.ntnlQty + ", " +
				"dlvryTp=" + this.dlvryTp + ", " +
				"exctnTmStmp=" + this.exctnTmStmp + ", " +
				"fctvDt=" + this.fctvDt + ", " +
				"xprtnDt=" + this.xprtnDt + ", " +
				"sttlmDt=" + this.sttlmDt + ", " +
				"derivEvt=" + this.derivEvt + ", " +
				"tradConf=" + this.tradConf + ", " +
				"tradClr=" + this.tradClr + ", " +
				"intrstRate=" + this.intrstRate + ", " +
				"ccy=" + this.ccy + ", " +
				"optn=" + this.optn + ", " +
				"othrPmt=" + this.othrPmt + ", " +
				"packg=" + this.packg +
			'}';
		}
	}
}
