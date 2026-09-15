package iso20022.auth108.hkma.tr;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import iso20022.auth108.hkma.tr.meta.MarginReportData9__1Meta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies the details of the margin data.
 * @version ${project.version}
 */
@RosettaDataType(value="MarginReportData9__1", builder=MarginReportData9__1.MarginReportData9__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="MarginReportData9__1", model="iso20022", builder=MarginReportData9__1.MarginReportData9__1BuilderImpl.class, version="${project.version}")
public interface MarginReportData9__1 extends RosettaModelObject {

	MarginReportData9__1Meta metaData = new MarginReportData9__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Date and time of submission of the report to the trade repository.
	 */
	ZonedDateTime getRptgTmStmp();
	/**
	 * Data specific to counterparties and related fields.
	 */
	TradeCounterpartyReport20__1 getCtrPtyId();
	/**
	 * Date on which the reportable event pertaining to the transaction and captured by the report took place.
	 */
	Date getEvtDt();
	/**
	 * Choice between a Unique Transaction Identifier (UTI) or a proprietary identifier as agreed with the counterparty.
	 */
	UniqueTransactionIdentifier2Choice__1 getTxId();
	/**
	 * Information related to collateral agreement existing between counterparties.
	 */
	MarginCollateralReport5__1 getColl();
	/**
	 * Information on posted collateral and margin.
	 */
	PostedMarginOrCollateral6__1 getPstdMrgnOrColl();
	/**
	 * Information on received collateral and margin.
	 */
	ReceivedMarginOrCollateral6__1 getRcvdMrgnOrColl();
	/**
	 * Specifies technical attributes of the message.
	 */
	TechnicalAttributes6__1 getTechAttrbts();

	/*********************** Build Methods  ***********************/
	MarginReportData9__1 build();
	
	MarginReportData9__1.MarginReportData9__1Builder toBuilder();
	
	static MarginReportData9__1.MarginReportData9__1Builder builder() {
		return new MarginReportData9__1.MarginReportData9__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MarginReportData9__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MarginReportData9__1> getType() {
		return MarginReportData9__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("rptgTmStmp"), ZonedDateTime.class, getRptgTmStmp(), this);
		processRosetta(path.newSubPath("ctrPtyId"), processor, TradeCounterpartyReport20__1.class, getCtrPtyId());
		processor.processBasic(path.newSubPath("evtDt"), Date.class, getEvtDt(), this);
		processRosetta(path.newSubPath("txId"), processor, UniqueTransactionIdentifier2Choice__1.class, getTxId());
		processRosetta(path.newSubPath("coll"), processor, MarginCollateralReport5__1.class, getColl());
		processRosetta(path.newSubPath("pstdMrgnOrColl"), processor, PostedMarginOrCollateral6__1.class, getPstdMrgnOrColl());
		processRosetta(path.newSubPath("rcvdMrgnOrColl"), processor, ReceivedMarginOrCollateral6__1.class, getRcvdMrgnOrColl());
		processRosetta(path.newSubPath("techAttrbts"), processor, TechnicalAttributes6__1.class, getTechAttrbts());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MarginReportData9__1Builder extends MarginReportData9__1, RosettaModelObjectBuilder {
		TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder getOrCreateCtrPtyId();
		@Override
		TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder getCtrPtyId();
		UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder getOrCreateTxId();
		@Override
		UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder getTxId();
		MarginCollateralReport5__1.MarginCollateralReport5__1Builder getOrCreateColl();
		@Override
		MarginCollateralReport5__1.MarginCollateralReport5__1Builder getColl();
		PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder getOrCreatePstdMrgnOrColl();
		@Override
		PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder getPstdMrgnOrColl();
		ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder getOrCreateRcvdMrgnOrColl();
		@Override
		ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder getRcvdMrgnOrColl();
		TechnicalAttributes6__1.TechnicalAttributes6__1Builder getOrCreateTechAttrbts();
		@Override
		TechnicalAttributes6__1.TechnicalAttributes6__1Builder getTechAttrbts();
		MarginReportData9__1.MarginReportData9__1Builder setRptgTmStmp(ZonedDateTime rptgTmStmp);
		MarginReportData9__1.MarginReportData9__1Builder setCtrPtyId(TradeCounterpartyReport20__1 ctrPtyId);
		MarginReportData9__1.MarginReportData9__1Builder setEvtDt(Date evtDt);
		MarginReportData9__1.MarginReportData9__1Builder setTxId(UniqueTransactionIdentifier2Choice__1 txId);
		MarginReportData9__1.MarginReportData9__1Builder setColl(MarginCollateralReport5__1 coll);
		MarginReportData9__1.MarginReportData9__1Builder setPstdMrgnOrColl(PostedMarginOrCollateral6__1 pstdMrgnOrColl);
		MarginReportData9__1.MarginReportData9__1Builder setRcvdMrgnOrColl(ReceivedMarginOrCollateral6__1 rcvdMrgnOrColl);
		MarginReportData9__1.MarginReportData9__1Builder setTechAttrbts(TechnicalAttributes6__1 techAttrbts);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("rptgTmStmp"), ZonedDateTime.class, getRptgTmStmp(), this);
			processRosetta(path.newSubPath("ctrPtyId"), processor, TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder.class, getCtrPtyId());
			processor.processBasic(path.newSubPath("evtDt"), Date.class, getEvtDt(), this);
			processRosetta(path.newSubPath("txId"), processor, UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder.class, getTxId());
			processRosetta(path.newSubPath("coll"), processor, MarginCollateralReport5__1.MarginCollateralReport5__1Builder.class, getColl());
			processRosetta(path.newSubPath("pstdMrgnOrColl"), processor, PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder.class, getPstdMrgnOrColl());
			processRosetta(path.newSubPath("rcvdMrgnOrColl"), processor, ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder.class, getRcvdMrgnOrColl());
			processRosetta(path.newSubPath("techAttrbts"), processor, TechnicalAttributes6__1.TechnicalAttributes6__1Builder.class, getTechAttrbts());
		}
		

		MarginReportData9__1.MarginReportData9__1Builder prune();
	}

	/*********************** Immutable Implementation of MarginReportData9__1  ***********************/
	class MarginReportData9__1Impl implements MarginReportData9__1 {
		private final ZonedDateTime rptgTmStmp;
		private final TradeCounterpartyReport20__1 ctrPtyId;
		private final Date evtDt;
		private final UniqueTransactionIdentifier2Choice__1 txId;
		private final MarginCollateralReport5__1 coll;
		private final PostedMarginOrCollateral6__1 pstdMrgnOrColl;
		private final ReceivedMarginOrCollateral6__1 rcvdMrgnOrColl;
		private final TechnicalAttributes6__1 techAttrbts;
		
		protected MarginReportData9__1Impl(MarginReportData9__1.MarginReportData9__1Builder builder) {
			this.rptgTmStmp = builder.getRptgTmStmp();
			this.ctrPtyId = ofNullable(builder.getCtrPtyId()).map(f->f.build()).orElse(null);
			this.evtDt = builder.getEvtDt();
			this.txId = ofNullable(builder.getTxId()).map(f->f.build()).orElse(null);
			this.coll = ofNullable(builder.getColl()).map(f->f.build()).orElse(null);
			this.pstdMrgnOrColl = ofNullable(builder.getPstdMrgnOrColl()).map(f->f.build()).orElse(null);
			this.rcvdMrgnOrColl = ofNullable(builder.getRcvdMrgnOrColl()).map(f->f.build()).orElse(null);
			this.techAttrbts = ofNullable(builder.getTechAttrbts()).map(f->f.build()).orElse(null);
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
		public TradeCounterpartyReport20__1 getCtrPtyId() {
			return ctrPtyId;
		}
		
		@Override
		@RosettaAttribute("evtDt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("evtDt")
		public Date getEvtDt() {
			return evtDt;
		}
		
		@Override
		@RosettaAttribute("txId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("txId")
		public UniqueTransactionIdentifier2Choice__1 getTxId() {
			return txId;
		}
		
		@Override
		@RosettaAttribute("coll")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("coll")
		public MarginCollateralReport5__1 getColl() {
			return coll;
		}
		
		@Override
		@RosettaAttribute("pstdMrgnOrColl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pstdMrgnOrColl")
		public PostedMarginOrCollateral6__1 getPstdMrgnOrColl() {
			return pstdMrgnOrColl;
		}
		
		@Override
		@RosettaAttribute("rcvdMrgnOrColl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rcvdMrgnOrColl")
		public ReceivedMarginOrCollateral6__1 getRcvdMrgnOrColl() {
			return rcvdMrgnOrColl;
		}
		
		@Override
		@RosettaAttribute("techAttrbts")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("techAttrbts")
		public TechnicalAttributes6__1 getTechAttrbts() {
			return techAttrbts;
		}
		
		@Override
		public MarginReportData9__1 build() {
			return this;
		}
		
		@Override
		public MarginReportData9__1.MarginReportData9__1Builder toBuilder() {
			MarginReportData9__1.MarginReportData9__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MarginReportData9__1.MarginReportData9__1Builder builder) {
			ofNullable(getRptgTmStmp()).ifPresent(builder::setRptgTmStmp);
			ofNullable(getCtrPtyId()).ifPresent(builder::setCtrPtyId);
			ofNullable(getEvtDt()).ifPresent(builder::setEvtDt);
			ofNullable(getTxId()).ifPresent(builder::setTxId);
			ofNullable(getColl()).ifPresent(builder::setColl);
			ofNullable(getPstdMrgnOrColl()).ifPresent(builder::setPstdMrgnOrColl);
			ofNullable(getRcvdMrgnOrColl()).ifPresent(builder::setRcvdMrgnOrColl);
			ofNullable(getTechAttrbts()).ifPresent(builder::setTechAttrbts);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MarginReportData9__1 _that = getType().cast(o);
		
			if (!Objects.equals(rptgTmStmp, _that.getRptgTmStmp())) return false;
			if (!Objects.equals(ctrPtyId, _that.getCtrPtyId())) return false;
			if (!Objects.equals(evtDt, _that.getEvtDt())) return false;
			if (!Objects.equals(txId, _that.getTxId())) return false;
			if (!Objects.equals(coll, _that.getColl())) return false;
			if (!Objects.equals(pstdMrgnOrColl, _that.getPstdMrgnOrColl())) return false;
			if (!Objects.equals(rcvdMrgnOrColl, _that.getRcvdMrgnOrColl())) return false;
			if (!Objects.equals(techAttrbts, _that.getTechAttrbts())) return false;
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
			_result = 31 * _result + (techAttrbts != null ? techAttrbts.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MarginReportData9__1 {" +
				"rptgTmStmp=" + this.rptgTmStmp + ", " +
				"ctrPtyId=" + this.ctrPtyId + ", " +
				"evtDt=" + this.evtDt + ", " +
				"txId=" + this.txId + ", " +
				"coll=" + this.coll + ", " +
				"pstdMrgnOrColl=" + this.pstdMrgnOrColl + ", " +
				"rcvdMrgnOrColl=" + this.rcvdMrgnOrColl + ", " +
				"techAttrbts=" + this.techAttrbts +
			'}';
		}
	}

	/*********************** Builder Implementation of MarginReportData9__1  ***********************/
	class MarginReportData9__1BuilderImpl implements MarginReportData9__1.MarginReportData9__1Builder {
	
		protected ZonedDateTime rptgTmStmp;
		protected TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder ctrPtyId;
		protected Date evtDt;
		protected UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder txId;
		protected MarginCollateralReport5__1.MarginCollateralReport5__1Builder coll;
		protected PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder pstdMrgnOrColl;
		protected ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder rcvdMrgnOrColl;
		protected TechnicalAttributes6__1.TechnicalAttributes6__1Builder techAttrbts;
		
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
		public TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder getCtrPtyId() {
			return ctrPtyId;
		}
		
		@Override
		public TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder getOrCreateCtrPtyId() {
			TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder result;
			if (ctrPtyId!=null) {
				result = ctrPtyId;
			}
			else {
				result = ctrPtyId = TradeCounterpartyReport20__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("evtDt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("evtDt")
		public Date getEvtDt() {
			return evtDt;
		}
		
		@Override
		@RosettaAttribute("txId")
		@Accessor(AccessorType.GETTER)
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
		@RosettaAttribute("coll")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("coll")
		public MarginCollateralReport5__1.MarginCollateralReport5__1Builder getColl() {
			return coll;
		}
		
		@Override
		public MarginCollateralReport5__1.MarginCollateralReport5__1Builder getOrCreateColl() {
			MarginCollateralReport5__1.MarginCollateralReport5__1Builder result;
			if (coll!=null) {
				result = coll;
			}
			else {
				result = coll = MarginCollateralReport5__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pstdMrgnOrColl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pstdMrgnOrColl")
		public PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder getPstdMrgnOrColl() {
			return pstdMrgnOrColl;
		}
		
		@Override
		public PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder getOrCreatePstdMrgnOrColl() {
			PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder result;
			if (pstdMrgnOrColl!=null) {
				result = pstdMrgnOrColl;
			}
			else {
				result = pstdMrgnOrColl = PostedMarginOrCollateral6__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rcvdMrgnOrColl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rcvdMrgnOrColl")
		public ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder getRcvdMrgnOrColl() {
			return rcvdMrgnOrColl;
		}
		
		@Override
		public ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder getOrCreateRcvdMrgnOrColl() {
			ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder result;
			if (rcvdMrgnOrColl!=null) {
				result = rcvdMrgnOrColl;
			}
			else {
				result = rcvdMrgnOrColl = ReceivedMarginOrCollateral6__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("techAttrbts")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("techAttrbts")
		public TechnicalAttributes6__1.TechnicalAttributes6__1Builder getTechAttrbts() {
			return techAttrbts;
		}
		
		@Override
		public TechnicalAttributes6__1.TechnicalAttributes6__1Builder getOrCreateTechAttrbts() {
			TechnicalAttributes6__1.TechnicalAttributes6__1Builder result;
			if (techAttrbts!=null) {
				result = techAttrbts;
			}
			else {
				result = techAttrbts = TechnicalAttributes6__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("rptgTmStmp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rptgTmStmp")
		@Override
		public MarginReportData9__1.MarginReportData9__1Builder setRptgTmStmp(ZonedDateTime _rptgTmStmp) {
			this.rptgTmStmp = _rptgTmStmp == null ? null : _rptgTmStmp;
			return this;
		}
		
		@RosettaAttribute("ctrPtyId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("ctrPtyId")
		@Override
		public MarginReportData9__1.MarginReportData9__1Builder setCtrPtyId(TradeCounterpartyReport20__1 _ctrPtyId) {
			this.ctrPtyId = _ctrPtyId == null ? null : _ctrPtyId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("evtDt")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("evtDt")
		@Override
		public MarginReportData9__1.MarginReportData9__1Builder setEvtDt(Date _evtDt) {
			this.evtDt = _evtDt == null ? null : _evtDt;
			return this;
		}
		
		@RosettaAttribute("txId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("txId")
		@Override
		public MarginReportData9__1.MarginReportData9__1Builder setTxId(UniqueTransactionIdentifier2Choice__1 _txId) {
			this.txId = _txId == null ? null : _txId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("coll")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("coll")
		@Override
		public MarginReportData9__1.MarginReportData9__1Builder setColl(MarginCollateralReport5__1 _coll) {
			this.coll = _coll == null ? null : _coll.toBuilder();
			return this;
		}
		
		@RosettaAttribute("pstdMrgnOrColl")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pstdMrgnOrColl")
		@Override
		public MarginReportData9__1.MarginReportData9__1Builder setPstdMrgnOrColl(PostedMarginOrCollateral6__1 _pstdMrgnOrColl) {
			this.pstdMrgnOrColl = _pstdMrgnOrColl == null ? null : _pstdMrgnOrColl.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rcvdMrgnOrColl")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rcvdMrgnOrColl")
		@Override
		public MarginReportData9__1.MarginReportData9__1Builder setRcvdMrgnOrColl(ReceivedMarginOrCollateral6__1 _rcvdMrgnOrColl) {
			this.rcvdMrgnOrColl = _rcvdMrgnOrColl == null ? null : _rcvdMrgnOrColl.toBuilder();
			return this;
		}
		
		@RosettaAttribute("techAttrbts")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("techAttrbts")
		@Override
		public MarginReportData9__1.MarginReportData9__1Builder setTechAttrbts(TechnicalAttributes6__1 _techAttrbts) {
			this.techAttrbts = _techAttrbts == null ? null : _techAttrbts.toBuilder();
			return this;
		}
		
		@Override
		public MarginReportData9__1 build() {
			return new MarginReportData9__1.MarginReportData9__1Impl(this);
		}
		
		@Override
		public MarginReportData9__1.MarginReportData9__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MarginReportData9__1.MarginReportData9__1Builder prune() {
			if (ctrPtyId!=null && !ctrPtyId.prune().hasData()) ctrPtyId = null;
			if (txId!=null && !txId.prune().hasData()) txId = null;
			if (coll!=null && !coll.prune().hasData()) coll = null;
			if (pstdMrgnOrColl!=null && !pstdMrgnOrColl.prune().hasData()) pstdMrgnOrColl = null;
			if (rcvdMrgnOrColl!=null && !rcvdMrgnOrColl.prune().hasData()) rcvdMrgnOrColl = null;
			if (techAttrbts!=null && !techAttrbts.prune().hasData()) techAttrbts = null;
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
			if (getTechAttrbts()!=null && getTechAttrbts().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MarginReportData9__1.MarginReportData9__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MarginReportData9__1.MarginReportData9__1Builder o = (MarginReportData9__1.MarginReportData9__1Builder) other;
			
			merger.mergeRosetta(getCtrPtyId(), o.getCtrPtyId(), this::setCtrPtyId);
			merger.mergeRosetta(getTxId(), o.getTxId(), this::setTxId);
			merger.mergeRosetta(getColl(), o.getColl(), this::setColl);
			merger.mergeRosetta(getPstdMrgnOrColl(), o.getPstdMrgnOrColl(), this::setPstdMrgnOrColl);
			merger.mergeRosetta(getRcvdMrgnOrColl(), o.getRcvdMrgnOrColl(), this::setRcvdMrgnOrColl);
			merger.mergeRosetta(getTechAttrbts(), o.getTechAttrbts(), this::setTechAttrbts);
			
			merger.mergeBasic(getRptgTmStmp(), o.getRptgTmStmp(), this::setRptgTmStmp);
			merger.mergeBasic(getEvtDt(), o.getEvtDt(), this::setEvtDt);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MarginReportData9__1 _that = getType().cast(o);
		
			if (!Objects.equals(rptgTmStmp, _that.getRptgTmStmp())) return false;
			if (!Objects.equals(ctrPtyId, _that.getCtrPtyId())) return false;
			if (!Objects.equals(evtDt, _that.getEvtDt())) return false;
			if (!Objects.equals(txId, _that.getTxId())) return false;
			if (!Objects.equals(coll, _that.getColl())) return false;
			if (!Objects.equals(pstdMrgnOrColl, _that.getPstdMrgnOrColl())) return false;
			if (!Objects.equals(rcvdMrgnOrColl, _that.getRcvdMrgnOrColl())) return false;
			if (!Objects.equals(techAttrbts, _that.getTechAttrbts())) return false;
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
			_result = 31 * _result + (techAttrbts != null ? techAttrbts.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MarginReportData9__1Builder {" +
				"rptgTmStmp=" + this.rptgTmStmp + ", " +
				"ctrPtyId=" + this.ctrPtyId + ", " +
				"evtDt=" + this.evtDt + ", " +
				"txId=" + this.txId + ", " +
				"coll=" + this.coll + ", " +
				"pstdMrgnOrColl=" + this.pstdMrgnOrColl + ", " +
				"rcvdMrgnOrColl=" + this.rcvdMrgnOrColl + ", " +
				"techAttrbts=" + this.techAttrbts +
			'}';
		}
	}
}
