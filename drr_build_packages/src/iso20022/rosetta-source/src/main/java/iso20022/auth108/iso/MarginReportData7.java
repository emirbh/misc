package iso20022.auth108.iso;

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
import iso20022.auth108.iso.meta.MarginReportData7Meta;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies the details of the margin data.
 * @version ${project.version}
 */
@RosettaDataType(value="MarginReportData7", builder=MarginReportData7.MarginReportData7BuilderImpl.class, version="${project.version}")
@RuneDataType(value="MarginReportData7", model="iso20022", builder=MarginReportData7.MarginReportData7BuilderImpl.class, version="${project.version}")
public interface MarginReportData7 extends RosettaModelObject {

	MarginReportData7Meta metaData = new MarginReportData7Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Date and time of submission of the report to the trade repository.
	 */
	ZonedDateTime getRptgTmStmp();
	/**
	 * Data specific to counterparties and related fields.
	 */
	TradeCounterpartyReport20 getCtrPtyId();
	/**
	 * Date on which the reportable event pertaining to the transaction and captured by the report took place.
	 */
	Date getEvtDt();
	/**
	 * Choice between a Unique Transaction Identifier (UTI) or a proprietary identifier as agreed with the counterparty.
	 */
	UniqueTransactionIdentifier2Choice getTxId();
	/**
	 * Information related to collateral agreement existing between counterparties.
	 */
	MarginCollateralReport4 getColl();
	/**
	 * Information on posted collateral and margin.
	 */
	PostedMarginOrCollateral6 getPstdMrgnOrColl();
	/**
	 * Information on received collateral and margin.
	 */
	ReceivedMarginOrCollateral6 getRcvdMrgnOrColl();
	/**
	 * Indicates if a counterparty rating trigger is agreed by the counterparties for the collateral posted by the reporting counterparty.    Usage: If the element is not present, the CounterpartyRatingTrigger is False.
	 */
	Boolean getCtrPtyRatgTrggrInd();
	/**
	 * Indicates if a counterparty rating trigger includes a threshold that increases collateral requirements when the counterparty falls below the single-A rating or equivalent.    Usage: If the CounterpartyRatingTrigger indicator is false, this element is omitted.
	 */
	Boolean getCtrPtyRatgThrshldInd();
	/**
	 * Specifies technical attributes of the message.
	 */
	TechnicalAttributes6 getTechAttrbts();
	/**
	 * Additional information that can not be captured in the structured fields and/or any other specific block.
	 */
	List<? extends SupplementaryData1> getSplmtryData();

	/*********************** Build Methods  ***********************/
	MarginReportData7 build();
	
	MarginReportData7.MarginReportData7Builder toBuilder();
	
	static MarginReportData7.MarginReportData7Builder builder() {
		return new MarginReportData7.MarginReportData7BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MarginReportData7> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MarginReportData7> getType() {
		return MarginReportData7.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("rptgTmStmp"), ZonedDateTime.class, getRptgTmStmp(), this);
		processRosetta(path.newSubPath("ctrPtyId"), processor, TradeCounterpartyReport20.class, getCtrPtyId());
		processor.processBasic(path.newSubPath("evtDt"), Date.class, getEvtDt(), this);
		processRosetta(path.newSubPath("txId"), processor, UniqueTransactionIdentifier2Choice.class, getTxId());
		processRosetta(path.newSubPath("coll"), processor, MarginCollateralReport4.class, getColl());
		processRosetta(path.newSubPath("pstdMrgnOrColl"), processor, PostedMarginOrCollateral6.class, getPstdMrgnOrColl());
		processRosetta(path.newSubPath("rcvdMrgnOrColl"), processor, ReceivedMarginOrCollateral6.class, getRcvdMrgnOrColl());
		processor.processBasic(path.newSubPath("ctrPtyRatgTrggrInd"), Boolean.class, getCtrPtyRatgTrggrInd(), this);
		processor.processBasic(path.newSubPath("ctrPtyRatgThrshldInd"), Boolean.class, getCtrPtyRatgThrshldInd(), this);
		processRosetta(path.newSubPath("techAttrbts"), processor, TechnicalAttributes6.class, getTechAttrbts());
		processRosetta(path.newSubPath("splmtryData"), processor, SupplementaryData1.class, getSplmtryData());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MarginReportData7Builder extends MarginReportData7, RosettaModelObjectBuilder {
		TradeCounterpartyReport20.TradeCounterpartyReport20Builder getOrCreateCtrPtyId();
		@Override
		TradeCounterpartyReport20.TradeCounterpartyReport20Builder getCtrPtyId();
		UniqueTransactionIdentifier2Choice.UniqueTransactionIdentifier2ChoiceBuilder getOrCreateTxId();
		@Override
		UniqueTransactionIdentifier2Choice.UniqueTransactionIdentifier2ChoiceBuilder getTxId();
		MarginCollateralReport4.MarginCollateralReport4Builder getOrCreateColl();
		@Override
		MarginCollateralReport4.MarginCollateralReport4Builder getColl();
		PostedMarginOrCollateral6.PostedMarginOrCollateral6Builder getOrCreatePstdMrgnOrColl();
		@Override
		PostedMarginOrCollateral6.PostedMarginOrCollateral6Builder getPstdMrgnOrColl();
		ReceivedMarginOrCollateral6.ReceivedMarginOrCollateral6Builder getOrCreateRcvdMrgnOrColl();
		@Override
		ReceivedMarginOrCollateral6.ReceivedMarginOrCollateral6Builder getRcvdMrgnOrColl();
		TechnicalAttributes6.TechnicalAttributes6Builder getOrCreateTechAttrbts();
		@Override
		TechnicalAttributes6.TechnicalAttributes6Builder getTechAttrbts();
		SupplementaryData1.SupplementaryData1Builder getOrCreateSplmtryData(int index);
		@Override
		List<? extends SupplementaryData1.SupplementaryData1Builder> getSplmtryData();
		MarginReportData7.MarginReportData7Builder setRptgTmStmp(ZonedDateTime rptgTmStmp);
		MarginReportData7.MarginReportData7Builder setCtrPtyId(TradeCounterpartyReport20 ctrPtyId);
		MarginReportData7.MarginReportData7Builder setEvtDt(Date evtDt);
		MarginReportData7.MarginReportData7Builder setTxId(UniqueTransactionIdentifier2Choice txId);
		MarginReportData7.MarginReportData7Builder setColl(MarginCollateralReport4 coll);
		MarginReportData7.MarginReportData7Builder setPstdMrgnOrColl(PostedMarginOrCollateral6 pstdMrgnOrColl);
		MarginReportData7.MarginReportData7Builder setRcvdMrgnOrColl(ReceivedMarginOrCollateral6 rcvdMrgnOrColl);
		MarginReportData7.MarginReportData7Builder setCtrPtyRatgTrggrInd(Boolean ctrPtyRatgTrggrInd);
		MarginReportData7.MarginReportData7Builder setCtrPtyRatgThrshldInd(Boolean ctrPtyRatgThrshldInd);
		MarginReportData7.MarginReportData7Builder setTechAttrbts(TechnicalAttributes6 techAttrbts);
		MarginReportData7.MarginReportData7Builder addSplmtryData(SupplementaryData1 splmtryData);
		MarginReportData7.MarginReportData7Builder addSplmtryData(SupplementaryData1 splmtryData, int idx);
		MarginReportData7.MarginReportData7Builder addSplmtryData(List<? extends SupplementaryData1> splmtryData);
		MarginReportData7.MarginReportData7Builder setSplmtryData(List<? extends SupplementaryData1> splmtryData);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("rptgTmStmp"), ZonedDateTime.class, getRptgTmStmp(), this);
			processRosetta(path.newSubPath("ctrPtyId"), processor, TradeCounterpartyReport20.TradeCounterpartyReport20Builder.class, getCtrPtyId());
			processor.processBasic(path.newSubPath("evtDt"), Date.class, getEvtDt(), this);
			processRosetta(path.newSubPath("txId"), processor, UniqueTransactionIdentifier2Choice.UniqueTransactionIdentifier2ChoiceBuilder.class, getTxId());
			processRosetta(path.newSubPath("coll"), processor, MarginCollateralReport4.MarginCollateralReport4Builder.class, getColl());
			processRosetta(path.newSubPath("pstdMrgnOrColl"), processor, PostedMarginOrCollateral6.PostedMarginOrCollateral6Builder.class, getPstdMrgnOrColl());
			processRosetta(path.newSubPath("rcvdMrgnOrColl"), processor, ReceivedMarginOrCollateral6.ReceivedMarginOrCollateral6Builder.class, getRcvdMrgnOrColl());
			processor.processBasic(path.newSubPath("ctrPtyRatgTrggrInd"), Boolean.class, getCtrPtyRatgTrggrInd(), this);
			processor.processBasic(path.newSubPath("ctrPtyRatgThrshldInd"), Boolean.class, getCtrPtyRatgThrshldInd(), this);
			processRosetta(path.newSubPath("techAttrbts"), processor, TechnicalAttributes6.TechnicalAttributes6Builder.class, getTechAttrbts());
			processRosetta(path.newSubPath("splmtryData"), processor, SupplementaryData1.SupplementaryData1Builder.class, getSplmtryData());
		}
		

		MarginReportData7.MarginReportData7Builder prune();
	}

	/*********************** Immutable Implementation of MarginReportData7  ***********************/
	class MarginReportData7Impl implements MarginReportData7 {
		private final ZonedDateTime rptgTmStmp;
		private final TradeCounterpartyReport20 ctrPtyId;
		private final Date evtDt;
		private final UniqueTransactionIdentifier2Choice txId;
		private final MarginCollateralReport4 coll;
		private final PostedMarginOrCollateral6 pstdMrgnOrColl;
		private final ReceivedMarginOrCollateral6 rcvdMrgnOrColl;
		private final Boolean ctrPtyRatgTrggrInd;
		private final Boolean ctrPtyRatgThrshldInd;
		private final TechnicalAttributes6 techAttrbts;
		private final List<? extends SupplementaryData1> splmtryData;
		
		protected MarginReportData7Impl(MarginReportData7.MarginReportData7Builder builder) {
			this.rptgTmStmp = builder.getRptgTmStmp();
			this.ctrPtyId = ofNullable(builder.getCtrPtyId()).map(f->f.build()).orElse(null);
			this.evtDt = builder.getEvtDt();
			this.txId = ofNullable(builder.getTxId()).map(f->f.build()).orElse(null);
			this.coll = ofNullable(builder.getColl()).map(f->f.build()).orElse(null);
			this.pstdMrgnOrColl = ofNullable(builder.getPstdMrgnOrColl()).map(f->f.build()).orElse(null);
			this.rcvdMrgnOrColl = ofNullable(builder.getRcvdMrgnOrColl()).map(f->f.build()).orElse(null);
			this.ctrPtyRatgTrggrInd = builder.getCtrPtyRatgTrggrInd();
			this.ctrPtyRatgThrshldInd = builder.getCtrPtyRatgThrshldInd();
			this.techAttrbts = ofNullable(builder.getTechAttrbts()).map(f->f.build()).orElse(null);
			this.splmtryData = ofNullable(builder.getSplmtryData()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("rptgTmStmp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rptgTmStmp")
		public ZonedDateTime getRptgTmStmp() {
			return rptgTmStmp;
		}
		
		@Override
		@RosettaAttribute("ctrPtyId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ctrPtyId")
		public TradeCounterpartyReport20 getCtrPtyId() {
			return ctrPtyId;
		}
		
		@Override
		@RosettaAttribute("evtDt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("evtDt")
		public Date getEvtDt() {
			return evtDt;
		}
		
		@Override
		@RosettaAttribute("txId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("txId")
		public UniqueTransactionIdentifier2Choice getTxId() {
			return txId;
		}
		
		@Override
		@RosettaAttribute("coll")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("coll")
		public MarginCollateralReport4 getColl() {
			return coll;
		}
		
		@Override
		@RosettaAttribute("pstdMrgnOrColl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pstdMrgnOrColl")
		public PostedMarginOrCollateral6 getPstdMrgnOrColl() {
			return pstdMrgnOrColl;
		}
		
		@Override
		@RosettaAttribute("rcvdMrgnOrColl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rcvdMrgnOrColl")
		public ReceivedMarginOrCollateral6 getRcvdMrgnOrColl() {
			return rcvdMrgnOrColl;
		}
		
		@Override
		@RosettaAttribute("ctrPtyRatgTrggrInd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ctrPtyRatgTrggrInd")
		public Boolean getCtrPtyRatgTrggrInd() {
			return ctrPtyRatgTrggrInd;
		}
		
		@Override
		@RosettaAttribute("ctrPtyRatgThrshldInd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ctrPtyRatgThrshldInd")
		public Boolean getCtrPtyRatgThrshldInd() {
			return ctrPtyRatgThrshldInd;
		}
		
		@Override
		@RosettaAttribute("techAttrbts")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("techAttrbts")
		public TechnicalAttributes6 getTechAttrbts() {
			return techAttrbts;
		}
		
		@Override
		@RosettaAttribute("splmtryData")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("splmtryData")
		public List<? extends SupplementaryData1> getSplmtryData() {
			return splmtryData;
		}
		
		@Override
		public MarginReportData7 build() {
			return this;
		}
		
		@Override
		public MarginReportData7.MarginReportData7Builder toBuilder() {
			MarginReportData7.MarginReportData7Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MarginReportData7.MarginReportData7Builder builder) {
			ofNullable(getRptgTmStmp()).ifPresent(builder::setRptgTmStmp);
			ofNullable(getCtrPtyId()).ifPresent(builder::setCtrPtyId);
			ofNullable(getEvtDt()).ifPresent(builder::setEvtDt);
			ofNullable(getTxId()).ifPresent(builder::setTxId);
			ofNullable(getColl()).ifPresent(builder::setColl);
			ofNullable(getPstdMrgnOrColl()).ifPresent(builder::setPstdMrgnOrColl);
			ofNullable(getRcvdMrgnOrColl()).ifPresent(builder::setRcvdMrgnOrColl);
			ofNullable(getCtrPtyRatgTrggrInd()).ifPresent(builder::setCtrPtyRatgTrggrInd);
			ofNullable(getCtrPtyRatgThrshldInd()).ifPresent(builder::setCtrPtyRatgThrshldInd);
			ofNullable(getTechAttrbts()).ifPresent(builder::setTechAttrbts);
			ofNullable(getSplmtryData()).ifPresent(builder::setSplmtryData);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MarginReportData7 _that = getType().cast(o);
		
			if (!Objects.equals(rptgTmStmp, _that.getRptgTmStmp())) return false;
			if (!Objects.equals(ctrPtyId, _that.getCtrPtyId())) return false;
			if (!Objects.equals(evtDt, _that.getEvtDt())) return false;
			if (!Objects.equals(txId, _that.getTxId())) return false;
			if (!Objects.equals(coll, _that.getColl())) return false;
			if (!Objects.equals(pstdMrgnOrColl, _that.getPstdMrgnOrColl())) return false;
			if (!Objects.equals(rcvdMrgnOrColl, _that.getRcvdMrgnOrColl())) return false;
			if (!Objects.equals(ctrPtyRatgTrggrInd, _that.getCtrPtyRatgTrggrInd())) return false;
			if (!Objects.equals(ctrPtyRatgThrshldInd, _that.getCtrPtyRatgThrshldInd())) return false;
			if (!Objects.equals(techAttrbts, _that.getTechAttrbts())) return false;
			if (!ListEquals.listEquals(splmtryData, _that.getSplmtryData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rptgTmStmp != null ? rptgTmStmp.hashCode() : 0);
			_result = 31 * _result + (ctrPtyId != null ? ctrPtyId.hashCode() : 0);
			_result = 31 * _result + (evtDt != null ? evtDt.hashCode() : 0);
			_result = 31 * _result + (txId != null ? txId.hashCode() : 0);
			_result = 31 * _result + (coll != null ? coll.hashCode() : 0);
			_result = 31 * _result + (pstdMrgnOrColl != null ? pstdMrgnOrColl.hashCode() : 0);
			_result = 31 * _result + (rcvdMrgnOrColl != null ? rcvdMrgnOrColl.hashCode() : 0);
			_result = 31 * _result + (ctrPtyRatgTrggrInd != null ? ctrPtyRatgTrggrInd.hashCode() : 0);
			_result = 31 * _result + (ctrPtyRatgThrshldInd != null ? ctrPtyRatgThrshldInd.hashCode() : 0);
			_result = 31 * _result + (techAttrbts != null ? techAttrbts.hashCode() : 0);
			_result = 31 * _result + (splmtryData != null ? splmtryData.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MarginReportData7 {" +
				"rptgTmStmp=" + this.rptgTmStmp + ", " +
				"ctrPtyId=" + this.ctrPtyId + ", " +
				"evtDt=" + this.evtDt + ", " +
				"txId=" + this.txId + ", " +
				"coll=" + this.coll + ", " +
				"pstdMrgnOrColl=" + this.pstdMrgnOrColl + ", " +
				"rcvdMrgnOrColl=" + this.rcvdMrgnOrColl + ", " +
				"ctrPtyRatgTrggrInd=" + this.ctrPtyRatgTrggrInd + ", " +
				"ctrPtyRatgThrshldInd=" + this.ctrPtyRatgThrshldInd + ", " +
				"techAttrbts=" + this.techAttrbts + ", " +
				"splmtryData=" + this.splmtryData +
			'}';
		}
	}

	/*********************** Builder Implementation of MarginReportData7  ***********************/
	class MarginReportData7BuilderImpl implements MarginReportData7.MarginReportData7Builder {
	
		protected ZonedDateTime rptgTmStmp;
		protected TradeCounterpartyReport20.TradeCounterpartyReport20Builder ctrPtyId;
		protected Date evtDt;
		protected UniqueTransactionIdentifier2Choice.UniqueTransactionIdentifier2ChoiceBuilder txId;
		protected MarginCollateralReport4.MarginCollateralReport4Builder coll;
		protected PostedMarginOrCollateral6.PostedMarginOrCollateral6Builder pstdMrgnOrColl;
		protected ReceivedMarginOrCollateral6.ReceivedMarginOrCollateral6Builder rcvdMrgnOrColl;
		protected Boolean ctrPtyRatgTrggrInd;
		protected Boolean ctrPtyRatgThrshldInd;
		protected TechnicalAttributes6.TechnicalAttributes6Builder techAttrbts;
		protected List<SupplementaryData1.SupplementaryData1Builder> splmtryData = new ArrayList<>();
		
		@Override
		@RosettaAttribute("rptgTmStmp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rptgTmStmp")
		public ZonedDateTime getRptgTmStmp() {
			return rptgTmStmp;
		}
		
		@Override
		@RosettaAttribute("ctrPtyId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ctrPtyId")
		public TradeCounterpartyReport20.TradeCounterpartyReport20Builder getCtrPtyId() {
			return ctrPtyId;
		}
		
		@Override
		public TradeCounterpartyReport20.TradeCounterpartyReport20Builder getOrCreateCtrPtyId() {
			TradeCounterpartyReport20.TradeCounterpartyReport20Builder result;
			if (ctrPtyId!=null) {
				result = ctrPtyId;
			}
			else {
				result = ctrPtyId = TradeCounterpartyReport20.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("evtDt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("evtDt")
		public Date getEvtDt() {
			return evtDt;
		}
		
		@Override
		@RosettaAttribute("txId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("txId")
		public UniqueTransactionIdentifier2Choice.UniqueTransactionIdentifier2ChoiceBuilder getTxId() {
			return txId;
		}
		
		@Override
		public UniqueTransactionIdentifier2Choice.UniqueTransactionIdentifier2ChoiceBuilder getOrCreateTxId() {
			UniqueTransactionIdentifier2Choice.UniqueTransactionIdentifier2ChoiceBuilder result;
			if (txId!=null) {
				result = txId;
			}
			else {
				result = txId = UniqueTransactionIdentifier2Choice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("coll")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("coll")
		public MarginCollateralReport4.MarginCollateralReport4Builder getColl() {
			return coll;
		}
		
		@Override
		public MarginCollateralReport4.MarginCollateralReport4Builder getOrCreateColl() {
			MarginCollateralReport4.MarginCollateralReport4Builder result;
			if (coll!=null) {
				result = coll;
			}
			else {
				result = coll = MarginCollateralReport4.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pstdMrgnOrColl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pstdMrgnOrColl")
		public PostedMarginOrCollateral6.PostedMarginOrCollateral6Builder getPstdMrgnOrColl() {
			return pstdMrgnOrColl;
		}
		
		@Override
		public PostedMarginOrCollateral6.PostedMarginOrCollateral6Builder getOrCreatePstdMrgnOrColl() {
			PostedMarginOrCollateral6.PostedMarginOrCollateral6Builder result;
			if (pstdMrgnOrColl!=null) {
				result = pstdMrgnOrColl;
			}
			else {
				result = pstdMrgnOrColl = PostedMarginOrCollateral6.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rcvdMrgnOrColl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rcvdMrgnOrColl")
		public ReceivedMarginOrCollateral6.ReceivedMarginOrCollateral6Builder getRcvdMrgnOrColl() {
			return rcvdMrgnOrColl;
		}
		
		@Override
		public ReceivedMarginOrCollateral6.ReceivedMarginOrCollateral6Builder getOrCreateRcvdMrgnOrColl() {
			ReceivedMarginOrCollateral6.ReceivedMarginOrCollateral6Builder result;
			if (rcvdMrgnOrColl!=null) {
				result = rcvdMrgnOrColl;
			}
			else {
				result = rcvdMrgnOrColl = ReceivedMarginOrCollateral6.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ctrPtyRatgTrggrInd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ctrPtyRatgTrggrInd")
		public Boolean getCtrPtyRatgTrggrInd() {
			return ctrPtyRatgTrggrInd;
		}
		
		@Override
		@RosettaAttribute("ctrPtyRatgThrshldInd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ctrPtyRatgThrshldInd")
		public Boolean getCtrPtyRatgThrshldInd() {
			return ctrPtyRatgThrshldInd;
		}
		
		@Override
		@RosettaAttribute("techAttrbts")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("techAttrbts")
		public TechnicalAttributes6.TechnicalAttributes6Builder getTechAttrbts() {
			return techAttrbts;
		}
		
		@Override
		public TechnicalAttributes6.TechnicalAttributes6Builder getOrCreateTechAttrbts() {
			TechnicalAttributes6.TechnicalAttributes6Builder result;
			if (techAttrbts!=null) {
				result = techAttrbts;
			}
			else {
				result = techAttrbts = TechnicalAttributes6.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("splmtryData")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("splmtryData")
		public List<? extends SupplementaryData1.SupplementaryData1Builder> getSplmtryData() {
			return splmtryData;
		}
		
		@Override
		public SupplementaryData1.SupplementaryData1Builder getOrCreateSplmtryData(int index) {
			if (splmtryData==null) {
				this.splmtryData = new ArrayList<>();
			}
			return getIndex(splmtryData, index, () -> {
						SupplementaryData1.SupplementaryData1Builder newSplmtryData = SupplementaryData1.builder();
						return newSplmtryData;
					});
		}
		
		@RosettaAttribute("rptgTmStmp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rptgTmStmp")
		@Override
		public MarginReportData7.MarginReportData7Builder setRptgTmStmp(ZonedDateTime _rptgTmStmp) {
			this.rptgTmStmp = _rptgTmStmp == null ? null : _rptgTmStmp;
			return this;
		}
		
		@RosettaAttribute("ctrPtyId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("ctrPtyId")
		@Override
		public MarginReportData7.MarginReportData7Builder setCtrPtyId(TradeCounterpartyReport20 _ctrPtyId) {
			this.ctrPtyId = _ctrPtyId == null ? null : _ctrPtyId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("evtDt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("evtDt")
		@Override
		public MarginReportData7.MarginReportData7Builder setEvtDt(Date _evtDt) {
			this.evtDt = _evtDt == null ? null : _evtDt;
			return this;
		}
		
		@RosettaAttribute("txId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("txId")
		@Override
		public MarginReportData7.MarginReportData7Builder setTxId(UniqueTransactionIdentifier2Choice _txId) {
			this.txId = _txId == null ? null : _txId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("coll")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("coll")
		@Override
		public MarginReportData7.MarginReportData7Builder setColl(MarginCollateralReport4 _coll) {
			this.coll = _coll == null ? null : _coll.toBuilder();
			return this;
		}
		
		@RosettaAttribute("pstdMrgnOrColl")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pstdMrgnOrColl")
		@Override
		public MarginReportData7.MarginReportData7Builder setPstdMrgnOrColl(PostedMarginOrCollateral6 _pstdMrgnOrColl) {
			this.pstdMrgnOrColl = _pstdMrgnOrColl == null ? null : _pstdMrgnOrColl.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rcvdMrgnOrColl")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rcvdMrgnOrColl")
		@Override
		public MarginReportData7.MarginReportData7Builder setRcvdMrgnOrColl(ReceivedMarginOrCollateral6 _rcvdMrgnOrColl) {
			this.rcvdMrgnOrColl = _rcvdMrgnOrColl == null ? null : _rcvdMrgnOrColl.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ctrPtyRatgTrggrInd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ctrPtyRatgTrggrInd")
		@Override
		public MarginReportData7.MarginReportData7Builder setCtrPtyRatgTrggrInd(Boolean _ctrPtyRatgTrggrInd) {
			this.ctrPtyRatgTrggrInd = _ctrPtyRatgTrggrInd == null ? null : _ctrPtyRatgTrggrInd;
			return this;
		}
		
		@RosettaAttribute("ctrPtyRatgThrshldInd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ctrPtyRatgThrshldInd")
		@Override
		public MarginReportData7.MarginReportData7Builder setCtrPtyRatgThrshldInd(Boolean _ctrPtyRatgThrshldInd) {
			this.ctrPtyRatgThrshldInd = _ctrPtyRatgThrshldInd == null ? null : _ctrPtyRatgThrshldInd;
			return this;
		}
		
		@RosettaAttribute("techAttrbts")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("techAttrbts")
		@Override
		public MarginReportData7.MarginReportData7Builder setTechAttrbts(TechnicalAttributes6 _techAttrbts) {
			this.techAttrbts = _techAttrbts == null ? null : _techAttrbts.toBuilder();
			return this;
		}
		
		@RosettaAttribute("splmtryData")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("splmtryData")
		@Override
		public MarginReportData7.MarginReportData7Builder addSplmtryData(SupplementaryData1 _splmtryData) {
			if (_splmtryData != null) {
				this.splmtryData.add(_splmtryData.toBuilder());
			}
			return this;
		}
		
		@Override
		public MarginReportData7.MarginReportData7Builder addSplmtryData(SupplementaryData1 _splmtryData, int idx) {
			getIndex(this.splmtryData, idx, () -> _splmtryData.toBuilder());
			return this;
		}
		
		@Override
		public MarginReportData7.MarginReportData7Builder addSplmtryData(List<? extends SupplementaryData1> splmtryDatas) {
			if (splmtryDatas != null) {
				for (final SupplementaryData1 toAdd : splmtryDatas) {
					this.splmtryData.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("splmtryData")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("splmtryData")
		@Override
		public MarginReportData7.MarginReportData7Builder setSplmtryData(List<? extends SupplementaryData1> splmtryDatas) {
			if (splmtryDatas == null) {
				this.splmtryData = new ArrayList<>();
			} else {
				this.splmtryData = splmtryDatas.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public MarginReportData7 build() {
			return new MarginReportData7.MarginReportData7Impl(this);
		}
		
		@Override
		public MarginReportData7.MarginReportData7Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MarginReportData7.MarginReportData7Builder prune() {
			if (ctrPtyId!=null && !ctrPtyId.prune().hasData()) ctrPtyId = null;
			if (txId!=null && !txId.prune().hasData()) txId = null;
			if (coll!=null && !coll.prune().hasData()) coll = null;
			if (pstdMrgnOrColl!=null && !pstdMrgnOrColl.prune().hasData()) pstdMrgnOrColl = null;
			if (rcvdMrgnOrColl!=null && !rcvdMrgnOrColl.prune().hasData()) rcvdMrgnOrColl = null;
			if (techAttrbts!=null && !techAttrbts.prune().hasData()) techAttrbts = null;
			splmtryData = splmtryData.stream().filter(b->b!=null).<SupplementaryData1.SupplementaryData1Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRptgTmStmp()!=null) return true;
			if (getCtrPtyId()!=null && getCtrPtyId().hasData()) return true;
			if (getEvtDt()!=null) return true;
			if (getTxId()!=null && getTxId().hasData()) return true;
			if (getColl()!=null && getColl().hasData()) return true;
			if (getPstdMrgnOrColl()!=null && getPstdMrgnOrColl().hasData()) return true;
			if (getRcvdMrgnOrColl()!=null && getRcvdMrgnOrColl().hasData()) return true;
			if (getCtrPtyRatgTrggrInd()!=null) return true;
			if (getCtrPtyRatgThrshldInd()!=null) return true;
			if (getTechAttrbts()!=null && getTechAttrbts().hasData()) return true;
			if (getSplmtryData()!=null && getSplmtryData().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MarginReportData7.MarginReportData7Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MarginReportData7.MarginReportData7Builder o = (MarginReportData7.MarginReportData7Builder) other;
			
			merger.mergeRosetta(getCtrPtyId(), o.getCtrPtyId(), this::setCtrPtyId);
			merger.mergeRosetta(getTxId(), o.getTxId(), this::setTxId);
			merger.mergeRosetta(getColl(), o.getColl(), this::setColl);
			merger.mergeRosetta(getPstdMrgnOrColl(), o.getPstdMrgnOrColl(), this::setPstdMrgnOrColl);
			merger.mergeRosetta(getRcvdMrgnOrColl(), o.getRcvdMrgnOrColl(), this::setRcvdMrgnOrColl);
			merger.mergeRosetta(getTechAttrbts(), o.getTechAttrbts(), this::setTechAttrbts);
			merger.mergeRosetta(getSplmtryData(), o.getSplmtryData(), this::getOrCreateSplmtryData);
			
			merger.mergeBasic(getRptgTmStmp(), o.getRptgTmStmp(), this::setRptgTmStmp);
			merger.mergeBasic(getEvtDt(), o.getEvtDt(), this::setEvtDt);
			merger.mergeBasic(getCtrPtyRatgTrggrInd(), o.getCtrPtyRatgTrggrInd(), this::setCtrPtyRatgTrggrInd);
			merger.mergeBasic(getCtrPtyRatgThrshldInd(), o.getCtrPtyRatgThrshldInd(), this::setCtrPtyRatgThrshldInd);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MarginReportData7 _that = getType().cast(o);
		
			if (!Objects.equals(rptgTmStmp, _that.getRptgTmStmp())) return false;
			if (!Objects.equals(ctrPtyId, _that.getCtrPtyId())) return false;
			if (!Objects.equals(evtDt, _that.getEvtDt())) return false;
			if (!Objects.equals(txId, _that.getTxId())) return false;
			if (!Objects.equals(coll, _that.getColl())) return false;
			if (!Objects.equals(pstdMrgnOrColl, _that.getPstdMrgnOrColl())) return false;
			if (!Objects.equals(rcvdMrgnOrColl, _that.getRcvdMrgnOrColl())) return false;
			if (!Objects.equals(ctrPtyRatgTrggrInd, _that.getCtrPtyRatgTrggrInd())) return false;
			if (!Objects.equals(ctrPtyRatgThrshldInd, _that.getCtrPtyRatgThrshldInd())) return false;
			if (!Objects.equals(techAttrbts, _that.getTechAttrbts())) return false;
			if (!ListEquals.listEquals(splmtryData, _that.getSplmtryData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rptgTmStmp != null ? rptgTmStmp.hashCode() : 0);
			_result = 31 * _result + (ctrPtyId != null ? ctrPtyId.hashCode() : 0);
			_result = 31 * _result + (evtDt != null ? evtDt.hashCode() : 0);
			_result = 31 * _result + (txId != null ? txId.hashCode() : 0);
			_result = 31 * _result + (coll != null ? coll.hashCode() : 0);
			_result = 31 * _result + (pstdMrgnOrColl != null ? pstdMrgnOrColl.hashCode() : 0);
			_result = 31 * _result + (rcvdMrgnOrColl != null ? rcvdMrgnOrColl.hashCode() : 0);
			_result = 31 * _result + (ctrPtyRatgTrggrInd != null ? ctrPtyRatgTrggrInd.hashCode() : 0);
			_result = 31 * _result + (ctrPtyRatgThrshldInd != null ? ctrPtyRatgThrshldInd.hashCode() : 0);
			_result = 31 * _result + (techAttrbts != null ? techAttrbts.hashCode() : 0);
			_result = 31 * _result + (splmtryData != null ? splmtryData.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MarginReportData7Builder {" +
				"rptgTmStmp=" + this.rptgTmStmp + ", " +
				"ctrPtyId=" + this.ctrPtyId + ", " +
				"evtDt=" + this.evtDt + ", " +
				"txId=" + this.txId + ", " +
				"coll=" + this.coll + ", " +
				"pstdMrgnOrColl=" + this.pstdMrgnOrColl + ", " +
				"rcvdMrgnOrColl=" + this.rcvdMrgnOrColl + ", " +
				"ctrPtyRatgTrggrInd=" + this.ctrPtyRatgTrggrInd + ", " +
				"ctrPtyRatgThrshldInd=" + this.ctrPtyRatgThrshldInd + ", " +
				"techAttrbts=" + this.techAttrbts + ", " +
				"splmtryData=" + this.splmtryData +
			'}';
		}
	}
}
