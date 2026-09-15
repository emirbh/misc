package iso20022.auth030.esma;

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
import iso20022.auth030.esma.meta.TradeTransaction49__4Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Provides details of the trade transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeTransaction49__4", builder=TradeTransaction49__4.TradeTransaction49__4BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeTransaction49__4", model="iso20022", builder=TradeTransaction49__4.TradeTransaction49__4BuilderImpl.class, version="${project.version}")
public interface TradeTransaction49__4 extends RosettaModelObject {

	TradeTransaction49__4Meta metaData = new TradeTransaction49__4Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Choice between a Unique Transaction Identifier (UTI) or a proprietary identifier as agreed with the counterparty.
	 */
	UniqueTransactionIdentifier2Choice__2 getTxId();
	/**
	 * Choice between a Unique Transaction Identifier (UTI) or a proprietary identifier of the position in which a derivative is included. This field is applicable only for the reports related to the termination of a derivative due to its inclusion in a position.
	 */
	UniqueTransactionIdentifier3Choice__1 getSbsqntTxId();
	/**
	 * Specifies the unique code assigned by the reporting counterparty to the portfolio if the collateral is posted on a portfolio basis.
	 */
	CollateralPortfolioCode5Choice__1 getCollPrtflCd();
	/**
	 * Indicates the effective date of the early termination of the reported derivative transaction.
	 */
	Date getEarlyTermntnDt();
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
	DerivativeEvent6__4 getDerivEvt();
	/**
	 * Payment related to elements not reported in dedicated fields.
	 */
	List<? extends OtherPayment5__1> getOthrPmt();

	/*********************** Build Methods  ***********************/
	TradeTransaction49__4 build();
	
	TradeTransaction49__4.TradeTransaction49__4Builder toBuilder();
	
	static TradeTransaction49__4.TradeTransaction49__4Builder builder() {
		return new TradeTransaction49__4.TradeTransaction49__4BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeTransaction49__4> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeTransaction49__4> getType() {
		return TradeTransaction49__4.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("txId"), processor, UniqueTransactionIdentifier2Choice__2.class, getTxId());
		processRosetta(path.newSubPath("sbsqntTxId"), processor, UniqueTransactionIdentifier3Choice__1.class, getSbsqntTxId());
		processRosetta(path.newSubPath("collPrtflCd"), processor, CollateralPortfolioCode5Choice__1.class, getCollPrtflCd());
		processor.processBasic(path.newSubPath("earlyTermntnDt"), Date.class, getEarlyTermntnDt(), this);
		processor.processBasic(path.newSubPath("pstTradRskRdctnFlg"), Boolean.class, getPstTradRskRdctnFlg(), this);
		processRosetta(path.newSubPath("pstTradRskRdctnEvt"), processor, PTRREvent2__1.class, getPstTradRskRdctnEvt());
		processRosetta(path.newSubPath("derivEvt"), processor, DerivativeEvent6__4.class, getDerivEvt());
		processRosetta(path.newSubPath("othrPmt"), processor, OtherPayment5__1.class, getOthrPmt());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeTransaction49__4Builder extends TradeTransaction49__4, RosettaModelObjectBuilder {
		UniqueTransactionIdentifier2Choice__2.UniqueTransactionIdentifier2Choice__2Builder getOrCreateTxId();
		@Override
		UniqueTransactionIdentifier2Choice__2.UniqueTransactionIdentifier2Choice__2Builder getTxId();
		UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder getOrCreateSbsqntTxId();
		@Override
		UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder getSbsqntTxId();
		CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Builder getOrCreateCollPrtflCd();
		@Override
		CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Builder getCollPrtflCd();
		PTRREvent2__1.PTRREvent2__1Builder getOrCreatePstTradRskRdctnEvt();
		@Override
		PTRREvent2__1.PTRREvent2__1Builder getPstTradRskRdctnEvt();
		DerivativeEvent6__4.DerivativeEvent6__4Builder getOrCreateDerivEvt();
		@Override
		DerivativeEvent6__4.DerivativeEvent6__4Builder getDerivEvt();
		OtherPayment5__1.OtherPayment5__1Builder getOrCreateOthrPmt(int index);
		@Override
		List<? extends OtherPayment5__1.OtherPayment5__1Builder> getOthrPmt();
		TradeTransaction49__4.TradeTransaction49__4Builder setTxId(UniqueTransactionIdentifier2Choice__2 txId);
		TradeTransaction49__4.TradeTransaction49__4Builder setSbsqntTxId(UniqueTransactionIdentifier3Choice__1 sbsqntTxId);
		TradeTransaction49__4.TradeTransaction49__4Builder setCollPrtflCd(CollateralPortfolioCode5Choice__1 collPrtflCd);
		TradeTransaction49__4.TradeTransaction49__4Builder setEarlyTermntnDt(Date earlyTermntnDt);
		TradeTransaction49__4.TradeTransaction49__4Builder setPstTradRskRdctnFlg(Boolean pstTradRskRdctnFlg);
		TradeTransaction49__4.TradeTransaction49__4Builder setPstTradRskRdctnEvt(PTRREvent2__1 pstTradRskRdctnEvt);
		TradeTransaction49__4.TradeTransaction49__4Builder setDerivEvt(DerivativeEvent6__4 derivEvt);
		TradeTransaction49__4.TradeTransaction49__4Builder addOthrPmt(OtherPayment5__1 othrPmt);
		TradeTransaction49__4.TradeTransaction49__4Builder addOthrPmt(OtherPayment5__1 othrPmt, int idx);
		TradeTransaction49__4.TradeTransaction49__4Builder addOthrPmt(List<? extends OtherPayment5__1> othrPmt);
		TradeTransaction49__4.TradeTransaction49__4Builder setOthrPmt(List<? extends OtherPayment5__1> othrPmt);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("txId"), processor, UniqueTransactionIdentifier2Choice__2.UniqueTransactionIdentifier2Choice__2Builder.class, getTxId());
			processRosetta(path.newSubPath("sbsqntTxId"), processor, UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder.class, getSbsqntTxId());
			processRosetta(path.newSubPath("collPrtflCd"), processor, CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Builder.class, getCollPrtflCd());
			processor.processBasic(path.newSubPath("earlyTermntnDt"), Date.class, getEarlyTermntnDt(), this);
			processor.processBasic(path.newSubPath("pstTradRskRdctnFlg"), Boolean.class, getPstTradRskRdctnFlg(), this);
			processRosetta(path.newSubPath("pstTradRskRdctnEvt"), processor, PTRREvent2__1.PTRREvent2__1Builder.class, getPstTradRskRdctnEvt());
			processRosetta(path.newSubPath("derivEvt"), processor, DerivativeEvent6__4.DerivativeEvent6__4Builder.class, getDerivEvt());
			processRosetta(path.newSubPath("othrPmt"), processor, OtherPayment5__1.OtherPayment5__1Builder.class, getOthrPmt());
		}
		

		TradeTransaction49__4.TradeTransaction49__4Builder prune();
	}

	/*********************** Immutable Implementation of TradeTransaction49__4  ***********************/
	class TradeTransaction49__4Impl implements TradeTransaction49__4 {
		private final UniqueTransactionIdentifier2Choice__2 txId;
		private final UniqueTransactionIdentifier3Choice__1 sbsqntTxId;
		private final CollateralPortfolioCode5Choice__1 collPrtflCd;
		private final Date earlyTermntnDt;
		private final Boolean pstTradRskRdctnFlg;
		private final PTRREvent2__1 pstTradRskRdctnEvt;
		private final DerivativeEvent6__4 derivEvt;
		private final List<? extends OtherPayment5__1> othrPmt;
		
		protected TradeTransaction49__4Impl(TradeTransaction49__4.TradeTransaction49__4Builder builder) {
			this.txId = ofNullable(builder.getTxId()).map(f->f.build()).orElse(null);
			this.sbsqntTxId = ofNullable(builder.getSbsqntTxId()).map(f->f.build()).orElse(null);
			this.collPrtflCd = ofNullable(builder.getCollPrtflCd()).map(f->f.build()).orElse(null);
			this.earlyTermntnDt = builder.getEarlyTermntnDt();
			this.pstTradRskRdctnFlg = builder.getPstTradRskRdctnFlg();
			this.pstTradRskRdctnEvt = ofNullable(builder.getPstTradRskRdctnEvt()).map(f->f.build()).orElse(null);
			this.derivEvt = ofNullable(builder.getDerivEvt()).map(f->f.build()).orElse(null);
			this.othrPmt = ofNullable(builder.getOthrPmt()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
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
		@RosettaAttribute("sbsqntTxId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sbsqntTxId")
		public UniqueTransactionIdentifier3Choice__1 getSbsqntTxId() {
			return sbsqntTxId;
		}
		
		@Override
		@RosettaAttribute("collPrtflCd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collPrtflCd")
		public CollateralPortfolioCode5Choice__1 getCollPrtflCd() {
			return collPrtflCd;
		}
		
		@Override
		@RosettaAttribute("earlyTermntnDt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("earlyTermntnDt")
		public Date getEarlyTermntnDt() {
			return earlyTermntnDt;
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
		public DerivativeEvent6__4 getDerivEvt() {
			return derivEvt;
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
		public TradeTransaction49__4 build() {
			return this;
		}
		
		@Override
		public TradeTransaction49__4.TradeTransaction49__4Builder toBuilder() {
			TradeTransaction49__4.TradeTransaction49__4Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeTransaction49__4.TradeTransaction49__4Builder builder) {
			ofNullable(getTxId()).ifPresent(builder::setTxId);
			ofNullable(getSbsqntTxId()).ifPresent(builder::setSbsqntTxId);
			ofNullable(getCollPrtflCd()).ifPresent(builder::setCollPrtflCd);
			ofNullable(getEarlyTermntnDt()).ifPresent(builder::setEarlyTermntnDt);
			ofNullable(getPstTradRskRdctnFlg()).ifPresent(builder::setPstTradRskRdctnFlg);
			ofNullable(getPstTradRskRdctnEvt()).ifPresent(builder::setPstTradRskRdctnEvt);
			ofNullable(getDerivEvt()).ifPresent(builder::setDerivEvt);
			ofNullable(getOthrPmt()).ifPresent(builder::setOthrPmt);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeTransaction49__4 _that = getType().cast(o);
		
			if (!Objects.equals(txId, _that.getTxId())) return false;
			if (!Objects.equals(sbsqntTxId, _that.getSbsqntTxId())) return false;
			if (!Objects.equals(collPrtflCd, _that.getCollPrtflCd())) return false;
			if (!Objects.equals(earlyTermntnDt, _that.getEarlyTermntnDt())) return false;
			if (!Objects.equals(pstTradRskRdctnFlg, _that.getPstTradRskRdctnFlg())) return false;
			if (!Objects.equals(pstTradRskRdctnEvt, _that.getPstTradRskRdctnEvt())) return false;
			if (!Objects.equals(derivEvt, _that.getDerivEvt())) return false;
			if (!ListEquals.listEquals(othrPmt, _that.getOthrPmt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (txId != null ? txId.hashCode() : 0);
			_result = 31 * _result + (sbsqntTxId != null ? sbsqntTxId.hashCode() : 0);
			_result = 31 * _result + (collPrtflCd != null ? collPrtflCd.hashCode() : 0);
			_result = 31 * _result + (earlyTermntnDt != null ? earlyTermntnDt.hashCode() : 0);
			_result = 31 * _result + (pstTradRskRdctnFlg != null ? pstTradRskRdctnFlg.hashCode() : 0);
			_result = 31 * _result + (pstTradRskRdctnEvt != null ? pstTradRskRdctnEvt.hashCode() : 0);
			_result = 31 * _result + (derivEvt != null ? derivEvt.hashCode() : 0);
			_result = 31 * _result + (othrPmt != null ? othrPmt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeTransaction49__4 {" +
				"txId=" + this.txId + ", " +
				"sbsqntTxId=" + this.sbsqntTxId + ", " +
				"collPrtflCd=" + this.collPrtflCd + ", " +
				"earlyTermntnDt=" + this.earlyTermntnDt + ", " +
				"pstTradRskRdctnFlg=" + this.pstTradRskRdctnFlg + ", " +
				"pstTradRskRdctnEvt=" + this.pstTradRskRdctnEvt + ", " +
				"derivEvt=" + this.derivEvt + ", " +
				"othrPmt=" + this.othrPmt +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeTransaction49__4  ***********************/
	class TradeTransaction49__4BuilderImpl implements TradeTransaction49__4.TradeTransaction49__4Builder {
	
		protected UniqueTransactionIdentifier2Choice__2.UniqueTransactionIdentifier2Choice__2Builder txId;
		protected UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder sbsqntTxId;
		protected CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Builder collPrtflCd;
		protected Date earlyTermntnDt;
		protected Boolean pstTradRskRdctnFlg;
		protected PTRREvent2__1.PTRREvent2__1Builder pstTradRskRdctnEvt;
		protected DerivativeEvent6__4.DerivativeEvent6__4Builder derivEvt;
		protected List<OtherPayment5__1.OtherPayment5__1Builder> othrPmt = new ArrayList<>();
		
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
		@RosettaAttribute("earlyTermntnDt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("earlyTermntnDt")
		public Date getEarlyTermntnDt() {
			return earlyTermntnDt;
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
		public DerivativeEvent6__4.DerivativeEvent6__4Builder getDerivEvt() {
			return derivEvt;
		}
		
		@Override
		public DerivativeEvent6__4.DerivativeEvent6__4Builder getOrCreateDerivEvt() {
			DerivativeEvent6__4.DerivativeEvent6__4Builder result;
			if (derivEvt!=null) {
				result = derivEvt;
			}
			else {
				result = derivEvt = DerivativeEvent6__4.builder();
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
		
		@RosettaAttribute("txId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("txId")
		@Override
		public TradeTransaction49__4.TradeTransaction49__4Builder setTxId(UniqueTransactionIdentifier2Choice__2 _txId) {
			this.txId = _txId == null ? null : _txId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sbsqntTxId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sbsqntTxId")
		@Override
		public TradeTransaction49__4.TradeTransaction49__4Builder setSbsqntTxId(UniqueTransactionIdentifier3Choice__1 _sbsqntTxId) {
			this.sbsqntTxId = _sbsqntTxId == null ? null : _sbsqntTxId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("collPrtflCd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collPrtflCd")
		@Override
		public TradeTransaction49__4.TradeTransaction49__4Builder setCollPrtflCd(CollateralPortfolioCode5Choice__1 _collPrtflCd) {
			this.collPrtflCd = _collPrtflCd == null ? null : _collPrtflCd.toBuilder();
			return this;
		}
		
		@RosettaAttribute("earlyTermntnDt")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("earlyTermntnDt")
		@Override
		public TradeTransaction49__4.TradeTransaction49__4Builder setEarlyTermntnDt(Date _earlyTermntnDt) {
			this.earlyTermntnDt = _earlyTermntnDt == null ? null : _earlyTermntnDt;
			return this;
		}
		
		@RosettaAttribute("pstTradRskRdctnFlg")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pstTradRskRdctnFlg")
		@Override
		public TradeTransaction49__4.TradeTransaction49__4Builder setPstTradRskRdctnFlg(Boolean _pstTradRskRdctnFlg) {
			this.pstTradRskRdctnFlg = _pstTradRskRdctnFlg == null ? null : _pstTradRskRdctnFlg;
			return this;
		}
		
		@RosettaAttribute("pstTradRskRdctnEvt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pstTradRskRdctnEvt")
		@Override
		public TradeTransaction49__4.TradeTransaction49__4Builder setPstTradRskRdctnEvt(PTRREvent2__1 _pstTradRskRdctnEvt) {
			this.pstTradRskRdctnEvt = _pstTradRskRdctnEvt == null ? null : _pstTradRskRdctnEvt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("derivEvt")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("derivEvt")
		@Override
		public TradeTransaction49__4.TradeTransaction49__4Builder setDerivEvt(DerivativeEvent6__4 _derivEvt) {
			this.derivEvt = _derivEvt == null ? null : _derivEvt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("othrPmt")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("othrPmt")
		@Override
		public TradeTransaction49__4.TradeTransaction49__4Builder addOthrPmt(OtherPayment5__1 _othrPmt) {
			if (_othrPmt != null) {
				this.othrPmt.add(_othrPmt.toBuilder());
			}
			return this;
		}
		
		@Override
		public TradeTransaction49__4.TradeTransaction49__4Builder addOthrPmt(OtherPayment5__1 _othrPmt, int idx) {
			getIndex(this.othrPmt, idx, () -> _othrPmt.toBuilder());
			return this;
		}
		
		@Override
		public TradeTransaction49__4.TradeTransaction49__4Builder addOthrPmt(List<? extends OtherPayment5__1> othrPmts) {
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
		public TradeTransaction49__4.TradeTransaction49__4Builder setOthrPmt(List<? extends OtherPayment5__1> othrPmts) {
			if (othrPmts == null) {
				this.othrPmt = new ArrayList<>();
			} else {
				this.othrPmt = othrPmts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public TradeTransaction49__4 build() {
			return new TradeTransaction49__4.TradeTransaction49__4Impl(this);
		}
		
		@Override
		public TradeTransaction49__4.TradeTransaction49__4Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeTransaction49__4.TradeTransaction49__4Builder prune() {
			if (txId!=null && !txId.prune().hasData()) txId = null;
			if (sbsqntTxId!=null && !sbsqntTxId.prune().hasData()) sbsqntTxId = null;
			if (collPrtflCd!=null && !collPrtflCd.prune().hasData()) collPrtflCd = null;
			if (pstTradRskRdctnEvt!=null && !pstTradRskRdctnEvt.prune().hasData()) pstTradRskRdctnEvt = null;
			if (derivEvt!=null && !derivEvt.prune().hasData()) derivEvt = null;
			othrPmt = othrPmt.stream().filter(b->b!=null).<OtherPayment5__1.OtherPayment5__1Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTxId()!=null && getTxId().hasData()) return true;
			if (getSbsqntTxId()!=null && getSbsqntTxId().hasData()) return true;
			if (getCollPrtflCd()!=null && getCollPrtflCd().hasData()) return true;
			if (getEarlyTermntnDt()!=null) return true;
			if (getPstTradRskRdctnFlg()!=null) return true;
			if (getPstTradRskRdctnEvt()!=null && getPstTradRskRdctnEvt().hasData()) return true;
			if (getDerivEvt()!=null && getDerivEvt().hasData()) return true;
			if (getOthrPmt()!=null && getOthrPmt().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeTransaction49__4.TradeTransaction49__4Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeTransaction49__4.TradeTransaction49__4Builder o = (TradeTransaction49__4.TradeTransaction49__4Builder) other;
			
			merger.mergeRosetta(getTxId(), o.getTxId(), this::setTxId);
			merger.mergeRosetta(getSbsqntTxId(), o.getSbsqntTxId(), this::setSbsqntTxId);
			merger.mergeRosetta(getCollPrtflCd(), o.getCollPrtflCd(), this::setCollPrtflCd);
			merger.mergeRosetta(getPstTradRskRdctnEvt(), o.getPstTradRskRdctnEvt(), this::setPstTradRskRdctnEvt);
			merger.mergeRosetta(getDerivEvt(), o.getDerivEvt(), this::setDerivEvt);
			merger.mergeRosetta(getOthrPmt(), o.getOthrPmt(), this::getOrCreateOthrPmt);
			
			merger.mergeBasic(getEarlyTermntnDt(), o.getEarlyTermntnDt(), this::setEarlyTermntnDt);
			merger.mergeBasic(getPstTradRskRdctnFlg(), o.getPstTradRskRdctnFlg(), this::setPstTradRskRdctnFlg);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeTransaction49__4 _that = getType().cast(o);
		
			if (!Objects.equals(txId, _that.getTxId())) return false;
			if (!Objects.equals(sbsqntTxId, _that.getSbsqntTxId())) return false;
			if (!Objects.equals(collPrtflCd, _that.getCollPrtflCd())) return false;
			if (!Objects.equals(earlyTermntnDt, _that.getEarlyTermntnDt())) return false;
			if (!Objects.equals(pstTradRskRdctnFlg, _that.getPstTradRskRdctnFlg())) return false;
			if (!Objects.equals(pstTradRskRdctnEvt, _that.getPstTradRskRdctnEvt())) return false;
			if (!Objects.equals(derivEvt, _that.getDerivEvt())) return false;
			if (!ListEquals.listEquals(othrPmt, _that.getOthrPmt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (txId != null ? txId.hashCode() : 0);
			_result = 31 * _result + (sbsqntTxId != null ? sbsqntTxId.hashCode() : 0);
			_result = 31 * _result + (collPrtflCd != null ? collPrtflCd.hashCode() : 0);
			_result = 31 * _result + (earlyTermntnDt != null ? earlyTermntnDt.hashCode() : 0);
			_result = 31 * _result + (pstTradRskRdctnFlg != null ? pstTradRskRdctnFlg.hashCode() : 0);
			_result = 31 * _result + (pstTradRskRdctnEvt != null ? pstTradRskRdctnEvt.hashCode() : 0);
			_result = 31 * _result + (derivEvt != null ? derivEvt.hashCode() : 0);
			_result = 31 * _result + (othrPmt != null ? othrPmt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeTransaction49__4Builder {" +
				"txId=" + this.txId + ", " +
				"sbsqntTxId=" + this.sbsqntTxId + ", " +
				"collPrtflCd=" + this.collPrtflCd + ", " +
				"earlyTermntnDt=" + this.earlyTermntnDt + ", " +
				"pstTradRskRdctnFlg=" + this.pstTradRskRdctnFlg + ", " +
				"pstTradRskRdctnEvt=" + this.pstTradRskRdctnEvt + ", " +
				"derivEvt=" + this.derivEvt + ", " +
				"othrPmt=" + this.othrPmt +
			'}';
		}
	}
}
