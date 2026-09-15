package iso20022.auth108.fca;

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
import iso20022.auth108.fca.meta.MarginReportData7__2Meta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies the details of the margin data.
 * @version ${project.version}
 */
@RosettaDataType(value="MarginReportData7__2", builder=MarginReportData7__2.MarginReportData7__2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="MarginReportData7__2", model="iso20022", builder=MarginReportData7__2.MarginReportData7__2BuilderImpl.class, version="${project.version}")
public interface MarginReportData7__2 extends RosettaModelObject {

	MarginReportData7__2Meta metaData = new MarginReportData7__2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Date and time of submission of the report to the trade repository.
	 */
	ZonedDateTime getRptgTmStmp();
	/**
	 * Data specific to counterparties and related fields.
	 */
	TradeCounterpartyReport20__2 getCtrPtyId();
	/**
	 * Date on which the reportable event pertaining to the transaction and captured by the report took place.
	 */
	Date getEvtDt();
	/**
	 * Choice between a Unique Transaction Identifier (UTI) or a proprietary identifier as agreed with the counterparty.
	 */
	UniqueTransactionIdentifier2Choice__2 getTxId();
	/**
	 * Information related to collateral agreement existing between counterparties.
	 */
	MarginCollateralReport4__1 getColl();
	/**
	 * Information on posted collateral and margin.
	 */
	PostedMarginOrCollateral6__1 getPstdMrgnOrColl();
	/**
	 * Information on received collateral and margin.
	 */
	ReceivedMarginOrCollateral6__1 getRcvdMrgnOrColl();

	/*********************** Build Methods  ***********************/
	MarginReportData7__2 build();
	
	MarginReportData7__2.MarginReportData7__2Builder toBuilder();
	
	static MarginReportData7__2.MarginReportData7__2Builder builder() {
		return new MarginReportData7__2.MarginReportData7__2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MarginReportData7__2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MarginReportData7__2> getType() {
		return MarginReportData7__2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("rptgTmStmp"), ZonedDateTime.class, getRptgTmStmp(), this);
		processRosetta(path.newSubPath("ctrPtyId"), processor, TradeCounterpartyReport20__2.class, getCtrPtyId());
		processor.processBasic(path.newSubPath("evtDt"), Date.class, getEvtDt(), this);
		processRosetta(path.newSubPath("txId"), processor, UniqueTransactionIdentifier2Choice__2.class, getTxId());
		processRosetta(path.newSubPath("coll"), processor, MarginCollateralReport4__1.class, getColl());
		processRosetta(path.newSubPath("pstdMrgnOrColl"), processor, PostedMarginOrCollateral6__1.class, getPstdMrgnOrColl());
		processRosetta(path.newSubPath("rcvdMrgnOrColl"), processor, ReceivedMarginOrCollateral6__1.class, getRcvdMrgnOrColl());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MarginReportData7__2Builder extends MarginReportData7__2, RosettaModelObjectBuilder {
		TradeCounterpartyReport20__2.TradeCounterpartyReport20__2Builder getOrCreateCtrPtyId();
		@Override
		TradeCounterpartyReport20__2.TradeCounterpartyReport20__2Builder getCtrPtyId();
		UniqueTransactionIdentifier2Choice__2.UniqueTransactionIdentifier2Choice__2Builder getOrCreateTxId();
		@Override
		UniqueTransactionIdentifier2Choice__2.UniqueTransactionIdentifier2Choice__2Builder getTxId();
		MarginCollateralReport4__1.MarginCollateralReport4__1Builder getOrCreateColl();
		@Override
		MarginCollateralReport4__1.MarginCollateralReport4__1Builder getColl();
		PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder getOrCreatePstdMrgnOrColl();
		@Override
		PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder getPstdMrgnOrColl();
		ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder getOrCreateRcvdMrgnOrColl();
		@Override
		ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder getRcvdMrgnOrColl();
		MarginReportData7__2.MarginReportData7__2Builder setRptgTmStmp(ZonedDateTime rptgTmStmp);
		MarginReportData7__2.MarginReportData7__2Builder setCtrPtyId(TradeCounterpartyReport20__2 ctrPtyId);
		MarginReportData7__2.MarginReportData7__2Builder setEvtDt(Date evtDt);
		MarginReportData7__2.MarginReportData7__2Builder setTxId(UniqueTransactionIdentifier2Choice__2 txId);
		MarginReportData7__2.MarginReportData7__2Builder setColl(MarginCollateralReport4__1 coll);
		MarginReportData7__2.MarginReportData7__2Builder setPstdMrgnOrColl(PostedMarginOrCollateral6__1 pstdMrgnOrColl);
		MarginReportData7__2.MarginReportData7__2Builder setRcvdMrgnOrColl(ReceivedMarginOrCollateral6__1 rcvdMrgnOrColl);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("rptgTmStmp"), ZonedDateTime.class, getRptgTmStmp(), this);
			processRosetta(path.newSubPath("ctrPtyId"), processor, TradeCounterpartyReport20__2.TradeCounterpartyReport20__2Builder.class, getCtrPtyId());
			processor.processBasic(path.newSubPath("evtDt"), Date.class, getEvtDt(), this);
			processRosetta(path.newSubPath("txId"), processor, UniqueTransactionIdentifier2Choice__2.UniqueTransactionIdentifier2Choice__2Builder.class, getTxId());
			processRosetta(path.newSubPath("coll"), processor, MarginCollateralReport4__1.MarginCollateralReport4__1Builder.class, getColl());
			processRosetta(path.newSubPath("pstdMrgnOrColl"), processor, PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder.class, getPstdMrgnOrColl());
			processRosetta(path.newSubPath("rcvdMrgnOrColl"), processor, ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder.class, getRcvdMrgnOrColl());
		}
		

		MarginReportData7__2.MarginReportData7__2Builder prune();
	}

	/*********************** Immutable Implementation of MarginReportData7__2  ***********************/
	class MarginReportData7__2Impl implements MarginReportData7__2 {
		private final ZonedDateTime rptgTmStmp;
		private final TradeCounterpartyReport20__2 ctrPtyId;
		private final Date evtDt;
		private final UniqueTransactionIdentifier2Choice__2 txId;
		private final MarginCollateralReport4__1 coll;
		private final PostedMarginOrCollateral6__1 pstdMrgnOrColl;
		private final ReceivedMarginOrCollateral6__1 rcvdMrgnOrColl;
		
		protected MarginReportData7__2Impl(MarginReportData7__2.MarginReportData7__2Builder builder) {
			this.rptgTmStmp = builder.getRptgTmStmp();
			this.ctrPtyId = ofNullable(builder.getCtrPtyId()).map(f->f.build()).orElse(null);
			this.evtDt = builder.getEvtDt();
			this.txId = ofNullable(builder.getTxId()).map(f->f.build()).orElse(null);
			this.coll = ofNullable(builder.getColl()).map(f->f.build()).orElse(null);
			this.pstdMrgnOrColl = ofNullable(builder.getPstdMrgnOrColl()).map(f->f.build()).orElse(null);
			this.rcvdMrgnOrColl = ofNullable(builder.getRcvdMrgnOrColl()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("rptgTmStmp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rptgTmStmp")
		public ZonedDateTime getRptgTmStmp() {
			return rptgTmStmp;
		}
		
		@Override
		@RosettaAttribute("ctrPtyId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ctrPtyId")
		public TradeCounterpartyReport20__2 getCtrPtyId() {
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
		public UniqueTransactionIdentifier2Choice__2 getTxId() {
			return txId;
		}
		
		@Override
		@RosettaAttribute("coll")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("coll")
		public MarginCollateralReport4__1 getColl() {
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
		public MarginReportData7__2 build() {
			return this;
		}
		
		@Override
		public MarginReportData7__2.MarginReportData7__2Builder toBuilder() {
			MarginReportData7__2.MarginReportData7__2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MarginReportData7__2.MarginReportData7__2Builder builder) {
			ofNullable(getRptgTmStmp()).ifPresent(builder::setRptgTmStmp);
			ofNullable(getCtrPtyId()).ifPresent(builder::setCtrPtyId);
			ofNullable(getEvtDt()).ifPresent(builder::setEvtDt);
			ofNullable(getTxId()).ifPresent(builder::setTxId);
			ofNullable(getColl()).ifPresent(builder::setColl);
			ofNullable(getPstdMrgnOrColl()).ifPresent(builder::setPstdMrgnOrColl);
			ofNullable(getRcvdMrgnOrColl()).ifPresent(builder::setRcvdMrgnOrColl);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MarginReportData7__2 _that = getType().cast(o);
		
			if (!Objects.equals(rptgTmStmp, _that.getRptgTmStmp())) return false;
			if (!Objects.equals(ctrPtyId, _that.getCtrPtyId())) return false;
			if (!Objects.equals(evtDt, _that.getEvtDt())) return false;
			if (!Objects.equals(txId, _that.getTxId())) return false;
			if (!Objects.equals(coll, _that.getColl())) return false;
			if (!Objects.equals(pstdMrgnOrColl, _that.getPstdMrgnOrColl())) return false;
			if (!Objects.equals(rcvdMrgnOrColl, _that.getRcvdMrgnOrColl())) return false;
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
			return _result;
		}
		
		@Override
		public String toString() {
			return "MarginReportData7__2 {" +
				"rptgTmStmp=" + this.rptgTmStmp + ", " +
				"ctrPtyId=" + this.ctrPtyId + ", " +
				"evtDt=" + this.evtDt + ", " +
				"txId=" + this.txId + ", " +
				"coll=" + this.coll + ", " +
				"pstdMrgnOrColl=" + this.pstdMrgnOrColl + ", " +
				"rcvdMrgnOrColl=" + this.rcvdMrgnOrColl +
			'}';
		}
	}

	/*********************** Builder Implementation of MarginReportData7__2  ***********************/
	class MarginReportData7__2BuilderImpl implements MarginReportData7__2.MarginReportData7__2Builder {
	
		protected ZonedDateTime rptgTmStmp;
		protected TradeCounterpartyReport20__2.TradeCounterpartyReport20__2Builder ctrPtyId;
		protected Date evtDt;
		protected UniqueTransactionIdentifier2Choice__2.UniqueTransactionIdentifier2Choice__2Builder txId;
		protected MarginCollateralReport4__1.MarginCollateralReport4__1Builder coll;
		protected PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder pstdMrgnOrColl;
		protected ReceivedMarginOrCollateral6__1.ReceivedMarginOrCollateral6__1Builder rcvdMrgnOrColl;
		
		@Override
		@RosettaAttribute("rptgTmStmp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rptgTmStmp")
		public ZonedDateTime getRptgTmStmp() {
			return rptgTmStmp;
		}
		
		@Override
		@RosettaAttribute("ctrPtyId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ctrPtyId")
		public TradeCounterpartyReport20__2.TradeCounterpartyReport20__2Builder getCtrPtyId() {
			return ctrPtyId;
		}
		
		@Override
		public TradeCounterpartyReport20__2.TradeCounterpartyReport20__2Builder getOrCreateCtrPtyId() {
			TradeCounterpartyReport20__2.TradeCounterpartyReport20__2Builder result;
			if (ctrPtyId!=null) {
				result = ctrPtyId;
			}
			else {
				result = ctrPtyId = TradeCounterpartyReport20__2.builder();
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
		@RosettaAttribute("coll")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("coll")
		public MarginCollateralReport4__1.MarginCollateralReport4__1Builder getColl() {
			return coll;
		}
		
		@Override
		public MarginCollateralReport4__1.MarginCollateralReport4__1Builder getOrCreateColl() {
			MarginCollateralReport4__1.MarginCollateralReport4__1Builder result;
			if (coll!=null) {
				result = coll;
			}
			else {
				result = coll = MarginCollateralReport4__1.builder();
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
		
		@RosettaAttribute("rptgTmStmp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("rptgTmStmp")
		@Override
		public MarginReportData7__2.MarginReportData7__2Builder setRptgTmStmp(ZonedDateTime _rptgTmStmp) {
			this.rptgTmStmp = _rptgTmStmp == null ? null : _rptgTmStmp;
			return this;
		}
		
		@RosettaAttribute("ctrPtyId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("ctrPtyId")
		@Override
		public MarginReportData7__2.MarginReportData7__2Builder setCtrPtyId(TradeCounterpartyReport20__2 _ctrPtyId) {
			this.ctrPtyId = _ctrPtyId == null ? null : _ctrPtyId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("evtDt")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("evtDt")
		@Override
		public MarginReportData7__2.MarginReportData7__2Builder setEvtDt(Date _evtDt) {
			this.evtDt = _evtDt == null ? null : _evtDt;
			return this;
		}
		
		@RosettaAttribute("txId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("txId")
		@Override
		public MarginReportData7__2.MarginReportData7__2Builder setTxId(UniqueTransactionIdentifier2Choice__2 _txId) {
			this.txId = _txId == null ? null : _txId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("coll")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("coll")
		@Override
		public MarginReportData7__2.MarginReportData7__2Builder setColl(MarginCollateralReport4__1 _coll) {
			this.coll = _coll == null ? null : _coll.toBuilder();
			return this;
		}
		
		@RosettaAttribute("pstdMrgnOrColl")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pstdMrgnOrColl")
		@Override
		public MarginReportData7__2.MarginReportData7__2Builder setPstdMrgnOrColl(PostedMarginOrCollateral6__1 _pstdMrgnOrColl) {
			this.pstdMrgnOrColl = _pstdMrgnOrColl == null ? null : _pstdMrgnOrColl.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rcvdMrgnOrColl")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rcvdMrgnOrColl")
		@Override
		public MarginReportData7__2.MarginReportData7__2Builder setRcvdMrgnOrColl(ReceivedMarginOrCollateral6__1 _rcvdMrgnOrColl) {
			this.rcvdMrgnOrColl = _rcvdMrgnOrColl == null ? null : _rcvdMrgnOrColl.toBuilder();
			return this;
		}
		
		@Override
		public MarginReportData7__2 build() {
			return new MarginReportData7__2.MarginReportData7__2Impl(this);
		}
		
		@Override
		public MarginReportData7__2.MarginReportData7__2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MarginReportData7__2.MarginReportData7__2Builder prune() {
			if (ctrPtyId!=null && !ctrPtyId.prune().hasData()) ctrPtyId = null;
			if (txId!=null && !txId.prune().hasData()) txId = null;
			if (coll!=null && !coll.prune().hasData()) coll = null;
			if (pstdMrgnOrColl!=null && !pstdMrgnOrColl.prune().hasData()) pstdMrgnOrColl = null;
			if (rcvdMrgnOrColl!=null && !rcvdMrgnOrColl.prune().hasData()) rcvdMrgnOrColl = null;
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
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MarginReportData7__2.MarginReportData7__2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MarginReportData7__2.MarginReportData7__2Builder o = (MarginReportData7__2.MarginReportData7__2Builder) other;
			
			merger.mergeRosetta(getCtrPtyId(), o.getCtrPtyId(), this::setCtrPtyId);
			merger.mergeRosetta(getTxId(), o.getTxId(), this::setTxId);
			merger.mergeRosetta(getColl(), o.getColl(), this::setColl);
			merger.mergeRosetta(getPstdMrgnOrColl(), o.getPstdMrgnOrColl(), this::setPstdMrgnOrColl);
			merger.mergeRosetta(getRcvdMrgnOrColl(), o.getRcvdMrgnOrColl(), this::setRcvdMrgnOrColl);
			
			merger.mergeBasic(getRptgTmStmp(), o.getRptgTmStmp(), this::setRptgTmStmp);
			merger.mergeBasic(getEvtDt(), o.getEvtDt(), this::setEvtDt);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MarginReportData7__2 _that = getType().cast(o);
		
			if (!Objects.equals(rptgTmStmp, _that.getRptgTmStmp())) return false;
			if (!Objects.equals(ctrPtyId, _that.getCtrPtyId())) return false;
			if (!Objects.equals(evtDt, _that.getEvtDt())) return false;
			if (!Objects.equals(txId, _that.getTxId())) return false;
			if (!Objects.equals(coll, _that.getColl())) return false;
			if (!Objects.equals(pstdMrgnOrColl, _that.getPstdMrgnOrColl())) return false;
			if (!Objects.equals(rcvdMrgnOrColl, _that.getRcvdMrgnOrColl())) return false;
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
			return _result;
		}
		
		@Override
		public String toString() {
			return "MarginReportData7__2Builder {" +
				"rptgTmStmp=" + this.rptgTmStmp + ", " +
				"ctrPtyId=" + this.ctrPtyId + ", " +
				"evtDt=" + this.evtDt + ", " +
				"txId=" + this.txId + ", " +
				"coll=" + this.coll + ", " +
				"pstdMrgnOrColl=" + this.pstdMrgnOrColl + ", " +
				"rcvdMrgnOrColl=" + this.rcvdMrgnOrColl +
			'}';
		}
	}
}
