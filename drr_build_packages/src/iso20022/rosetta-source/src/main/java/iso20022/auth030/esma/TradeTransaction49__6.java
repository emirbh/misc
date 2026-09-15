package iso20022.auth030.esma;

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
import iso20022.auth030.esma.meta.TradeTransaction49__6Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Provides details of the trade transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeTransaction49__6", builder=TradeTransaction49__6.TradeTransaction49__6BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeTransaction49__6", model="iso20022", builder=TradeTransaction49__6.TradeTransaction49__6BuilderImpl.class, version="${project.version}")
public interface TradeTransaction49__6 extends RosettaModelObject {

	TradeTransaction49__6Meta metaData = new TradeTransaction49__6Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Choice between a Unique Transaction Identifier (UTI) or a proprietary identifier as agreed with the counterparty.
	 */
	UniqueTransactionIdentifier2Choice__2 getTxId();
	/**
	 * Specifies the unique code assigned by the reporting counterparty to the portfolio if the collateral is posted on a portfolio basis.
	 */
	CollateralPortfolioCode5Choice__1 getCollPrtflCd();
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
	DerivativeEvent6__5 getDerivEvt();

	/*********************** Build Methods  ***********************/
	TradeTransaction49__6 build();
	
	TradeTransaction49__6.TradeTransaction49__6Builder toBuilder();
	
	static TradeTransaction49__6.TradeTransaction49__6Builder builder() {
		return new TradeTransaction49__6.TradeTransaction49__6BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeTransaction49__6> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeTransaction49__6> getType() {
		return TradeTransaction49__6.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("txId"), processor, UniqueTransactionIdentifier2Choice__2.class, getTxId());
		processRosetta(path.newSubPath("collPrtflCd"), processor, CollateralPortfolioCode5Choice__1.class, getCollPrtflCd());
		processor.processBasic(path.newSubPath("pstTradRskRdctnFlg"), Boolean.class, getPstTradRskRdctnFlg(), this);
		processRosetta(path.newSubPath("pstTradRskRdctnEvt"), processor, PTRREvent2__1.class, getPstTradRskRdctnEvt());
		processRosetta(path.newSubPath("derivEvt"), processor, DerivativeEvent6__5.class, getDerivEvt());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeTransaction49__6Builder extends TradeTransaction49__6, RosettaModelObjectBuilder {
		UniqueTransactionIdentifier2Choice__2.UniqueTransactionIdentifier2Choice__2Builder getOrCreateTxId();
		@Override
		UniqueTransactionIdentifier2Choice__2.UniqueTransactionIdentifier2Choice__2Builder getTxId();
		CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Builder getOrCreateCollPrtflCd();
		@Override
		CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Builder getCollPrtflCd();
		PTRREvent2__1.PTRREvent2__1Builder getOrCreatePstTradRskRdctnEvt();
		@Override
		PTRREvent2__1.PTRREvent2__1Builder getPstTradRskRdctnEvt();
		DerivativeEvent6__5.DerivativeEvent6__5Builder getOrCreateDerivEvt();
		@Override
		DerivativeEvent6__5.DerivativeEvent6__5Builder getDerivEvt();
		TradeTransaction49__6.TradeTransaction49__6Builder setTxId(UniqueTransactionIdentifier2Choice__2 txId);
		TradeTransaction49__6.TradeTransaction49__6Builder setCollPrtflCd(CollateralPortfolioCode5Choice__1 collPrtflCd);
		TradeTransaction49__6.TradeTransaction49__6Builder setPstTradRskRdctnFlg(Boolean pstTradRskRdctnFlg);
		TradeTransaction49__6.TradeTransaction49__6Builder setPstTradRskRdctnEvt(PTRREvent2__1 pstTradRskRdctnEvt);
		TradeTransaction49__6.TradeTransaction49__6Builder setDerivEvt(DerivativeEvent6__5 derivEvt);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("txId"), processor, UniqueTransactionIdentifier2Choice__2.UniqueTransactionIdentifier2Choice__2Builder.class, getTxId());
			processRosetta(path.newSubPath("collPrtflCd"), processor, CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Builder.class, getCollPrtflCd());
			processor.processBasic(path.newSubPath("pstTradRskRdctnFlg"), Boolean.class, getPstTradRskRdctnFlg(), this);
			processRosetta(path.newSubPath("pstTradRskRdctnEvt"), processor, PTRREvent2__1.PTRREvent2__1Builder.class, getPstTradRskRdctnEvt());
			processRosetta(path.newSubPath("derivEvt"), processor, DerivativeEvent6__5.DerivativeEvent6__5Builder.class, getDerivEvt());
		}
		

		TradeTransaction49__6.TradeTransaction49__6Builder prune();
	}

	/*********************** Immutable Implementation of TradeTransaction49__6  ***********************/
	class TradeTransaction49__6Impl implements TradeTransaction49__6 {
		private final UniqueTransactionIdentifier2Choice__2 txId;
		private final CollateralPortfolioCode5Choice__1 collPrtflCd;
		private final Boolean pstTradRskRdctnFlg;
		private final PTRREvent2__1 pstTradRskRdctnEvt;
		private final DerivativeEvent6__5 derivEvt;
		
		protected TradeTransaction49__6Impl(TradeTransaction49__6.TradeTransaction49__6Builder builder) {
			this.txId = ofNullable(builder.getTxId()).map(f->f.build()).orElse(null);
			this.collPrtflCd = ofNullable(builder.getCollPrtflCd()).map(f->f.build()).orElse(null);
			this.pstTradRskRdctnFlg = builder.getPstTradRskRdctnFlg();
			this.pstTradRskRdctnEvt = ofNullable(builder.getPstTradRskRdctnEvt()).map(f->f.build()).orElse(null);
			this.derivEvt = ofNullable(builder.getDerivEvt()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("collPrtflCd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collPrtflCd")
		public CollateralPortfolioCode5Choice__1 getCollPrtflCd() {
			return collPrtflCd;
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
		public DerivativeEvent6__5 getDerivEvt() {
			return derivEvt;
		}
		
		@Override
		public TradeTransaction49__6 build() {
			return this;
		}
		
		@Override
		public TradeTransaction49__6.TradeTransaction49__6Builder toBuilder() {
			TradeTransaction49__6.TradeTransaction49__6Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeTransaction49__6.TradeTransaction49__6Builder builder) {
			ofNullable(getTxId()).ifPresent(builder::setTxId);
			ofNullable(getCollPrtflCd()).ifPresent(builder::setCollPrtflCd);
			ofNullable(getPstTradRskRdctnFlg()).ifPresent(builder::setPstTradRskRdctnFlg);
			ofNullable(getPstTradRskRdctnEvt()).ifPresent(builder::setPstTradRskRdctnEvt);
			ofNullable(getDerivEvt()).ifPresent(builder::setDerivEvt);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeTransaction49__6 _that = getType().cast(o);
		
			if (!Objects.equals(txId, _that.getTxId())) return false;
			if (!Objects.equals(collPrtflCd, _that.getCollPrtflCd())) return false;
			if (!Objects.equals(pstTradRskRdctnFlg, _that.getPstTradRskRdctnFlg())) return false;
			if (!Objects.equals(pstTradRskRdctnEvt, _that.getPstTradRskRdctnEvt())) return false;
			if (!Objects.equals(derivEvt, _that.getDerivEvt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (txId != null ? txId.hashCode() : 0);
			_result = 31 * _result + (collPrtflCd != null ? collPrtflCd.hashCode() : 0);
			_result = 31 * _result + (pstTradRskRdctnFlg != null ? pstTradRskRdctnFlg.hashCode() : 0);
			_result = 31 * _result + (pstTradRskRdctnEvt != null ? pstTradRskRdctnEvt.hashCode() : 0);
			_result = 31 * _result + (derivEvt != null ? derivEvt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeTransaction49__6 {" +
				"txId=" + this.txId + ", " +
				"collPrtflCd=" + this.collPrtflCd + ", " +
				"pstTradRskRdctnFlg=" + this.pstTradRskRdctnFlg + ", " +
				"pstTradRskRdctnEvt=" + this.pstTradRskRdctnEvt + ", " +
				"derivEvt=" + this.derivEvt +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeTransaction49__6  ***********************/
	class TradeTransaction49__6BuilderImpl implements TradeTransaction49__6.TradeTransaction49__6Builder {
	
		protected UniqueTransactionIdentifier2Choice__2.UniqueTransactionIdentifier2Choice__2Builder txId;
		protected CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Builder collPrtflCd;
		protected Boolean pstTradRskRdctnFlg;
		protected PTRREvent2__1.PTRREvent2__1Builder pstTradRskRdctnEvt;
		protected DerivativeEvent6__5.DerivativeEvent6__5Builder derivEvt;
		
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
		public DerivativeEvent6__5.DerivativeEvent6__5Builder getDerivEvt() {
			return derivEvt;
		}
		
		@Override
		public DerivativeEvent6__5.DerivativeEvent6__5Builder getOrCreateDerivEvt() {
			DerivativeEvent6__5.DerivativeEvent6__5Builder result;
			if (derivEvt!=null) {
				result = derivEvt;
			}
			else {
				result = derivEvt = DerivativeEvent6__5.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("txId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("txId")
		@Override
		public TradeTransaction49__6.TradeTransaction49__6Builder setTxId(UniqueTransactionIdentifier2Choice__2 _txId) {
			this.txId = _txId == null ? null : _txId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("collPrtflCd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collPrtflCd")
		@Override
		public TradeTransaction49__6.TradeTransaction49__6Builder setCollPrtflCd(CollateralPortfolioCode5Choice__1 _collPrtflCd) {
			this.collPrtflCd = _collPrtflCd == null ? null : _collPrtflCd.toBuilder();
			return this;
		}
		
		@RosettaAttribute("pstTradRskRdctnFlg")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pstTradRskRdctnFlg")
		@Override
		public TradeTransaction49__6.TradeTransaction49__6Builder setPstTradRskRdctnFlg(Boolean _pstTradRskRdctnFlg) {
			this.pstTradRskRdctnFlg = _pstTradRskRdctnFlg == null ? null : _pstTradRskRdctnFlg;
			return this;
		}
		
		@RosettaAttribute("pstTradRskRdctnEvt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pstTradRskRdctnEvt")
		@Override
		public TradeTransaction49__6.TradeTransaction49__6Builder setPstTradRskRdctnEvt(PTRREvent2__1 _pstTradRskRdctnEvt) {
			this.pstTradRskRdctnEvt = _pstTradRskRdctnEvt == null ? null : _pstTradRskRdctnEvt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("derivEvt")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("derivEvt")
		@Override
		public TradeTransaction49__6.TradeTransaction49__6Builder setDerivEvt(DerivativeEvent6__5 _derivEvt) {
			this.derivEvt = _derivEvt == null ? null : _derivEvt.toBuilder();
			return this;
		}
		
		@Override
		public TradeTransaction49__6 build() {
			return new TradeTransaction49__6.TradeTransaction49__6Impl(this);
		}
		
		@Override
		public TradeTransaction49__6.TradeTransaction49__6Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeTransaction49__6.TradeTransaction49__6Builder prune() {
			if (txId!=null && !txId.prune().hasData()) txId = null;
			if (collPrtflCd!=null && !collPrtflCd.prune().hasData()) collPrtflCd = null;
			if (pstTradRskRdctnEvt!=null && !pstTradRskRdctnEvt.prune().hasData()) pstTradRskRdctnEvt = null;
			if (derivEvt!=null && !derivEvt.prune().hasData()) derivEvt = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTxId()!=null && getTxId().hasData()) return true;
			if (getCollPrtflCd()!=null && getCollPrtflCd().hasData()) return true;
			if (getPstTradRskRdctnFlg()!=null) return true;
			if (getPstTradRskRdctnEvt()!=null && getPstTradRskRdctnEvt().hasData()) return true;
			if (getDerivEvt()!=null && getDerivEvt().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeTransaction49__6.TradeTransaction49__6Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeTransaction49__6.TradeTransaction49__6Builder o = (TradeTransaction49__6.TradeTransaction49__6Builder) other;
			
			merger.mergeRosetta(getTxId(), o.getTxId(), this::setTxId);
			merger.mergeRosetta(getCollPrtflCd(), o.getCollPrtflCd(), this::setCollPrtflCd);
			merger.mergeRosetta(getPstTradRskRdctnEvt(), o.getPstTradRskRdctnEvt(), this::setPstTradRskRdctnEvt);
			merger.mergeRosetta(getDerivEvt(), o.getDerivEvt(), this::setDerivEvt);
			
			merger.mergeBasic(getPstTradRskRdctnFlg(), o.getPstTradRskRdctnFlg(), this::setPstTradRskRdctnFlg);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeTransaction49__6 _that = getType().cast(o);
		
			if (!Objects.equals(txId, _that.getTxId())) return false;
			if (!Objects.equals(collPrtflCd, _that.getCollPrtflCd())) return false;
			if (!Objects.equals(pstTradRskRdctnFlg, _that.getPstTradRskRdctnFlg())) return false;
			if (!Objects.equals(pstTradRskRdctnEvt, _that.getPstTradRskRdctnEvt())) return false;
			if (!Objects.equals(derivEvt, _that.getDerivEvt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (txId != null ? txId.hashCode() : 0);
			_result = 31 * _result + (collPrtflCd != null ? collPrtflCd.hashCode() : 0);
			_result = 31 * _result + (pstTradRskRdctnFlg != null ? pstTradRskRdctnFlg.hashCode() : 0);
			_result = 31 * _result + (pstTradRskRdctnEvt != null ? pstTradRskRdctnEvt.hashCode() : 0);
			_result = 31 * _result + (derivEvt != null ? derivEvt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeTransaction49__6Builder {" +
				"txId=" + this.txId + ", " +
				"collPrtflCd=" + this.collPrtflCd + ", " +
				"pstTradRskRdctnFlg=" + this.pstTradRskRdctnFlg + ", " +
				"pstTradRskRdctnEvt=" + this.pstTradRskRdctnEvt + ", " +
				"derivEvt=" + this.derivEvt +
			'}';
		}
	}
}
